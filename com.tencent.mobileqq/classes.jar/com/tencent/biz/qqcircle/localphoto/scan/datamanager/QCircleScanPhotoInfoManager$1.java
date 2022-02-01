package com.tencent.biz.qqcircle.localphoto.scan.datamanager;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePhotocatemetadata.PhotoMetadata;
import qqcircle.QQCircleReport.PhotoMetadataUploadRsp;

class QCircleScanPhotoInfoManager$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.PhotoMetadataUploadRsp>
{
  QCircleScanPhotoInfoManager$1(QCircleScanPhotoInfoManager paramQCircleScanPhotoInfoManager, ArrayList paramArrayList) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.PhotoMetadataUploadRsp paramPhotoMetadataUploadRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.a.size() > 0) {
        paramBaseRequest = this.a.iterator();
      }
    }
    else {
      while (paramBaseRequest.hasNext())
      {
        paramString = (QQCirclePhotocatemetadata.PhotoMetadata)paramBaseRequest.next();
        if (paramString != null)
        {
          paramString = QCircleScanPhotoInfoManager.d().query(QCircleScanPhotoInfoEntity.class, QCircleScanPhotoInfoEntity.class.getSimpleName(), true, "photoId=?", new String[] { paramString.id.get() }, null, null, null, null);
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = (ArrayList)paramString;
            ((QCircleScanPhotoInfoEntity)paramString.get(0)).hasUpload = true;
            QCircleScanPhotoInfoManager.d().update((Entity)paramString.get(0));
            continue;
            paramBaseRequest = new StringBuilder();
            paramBaseRequest.append("uploadLocalPhotoInfoToServer error isSuccess: ");
            paramBaseRequest.append(paramBoolean);
            paramBaseRequest.append(" retCode: ");
            paramBaseRequest.append(paramLong);
            QLog.e("QCircleScanPhotoInfoManager", 1, paramBaseRequest.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.datamanager.QCircleScanPhotoInfoManager.1
 * JD-Core Version:    0.7.0.1
 */