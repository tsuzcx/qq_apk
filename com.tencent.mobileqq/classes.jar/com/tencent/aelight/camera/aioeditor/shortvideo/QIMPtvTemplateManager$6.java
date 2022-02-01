package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.aioeditor.capture.data.TemplateGroupItem;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QIMPtvTemplateManager$6
  implements INetEngineListener
{
  QIMPtvTemplateManager$6(QIMPtvTemplateManager paramQIMPtvTemplateManager, PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener) {}
  
  public void onResp(NetResp arg1)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp url: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.c);
      ((StringBuilder)localObject1).append(" resultcode: ");
      ((StringBuilder)localObject1).append(???.mHttpCode);
      QLog.i("QIMPtvTemplateManager", 2, ((StringBuilder)localObject1).toString());
    }
    ??? = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    ???.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.a(???);
    synchronized (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaLangObject)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (TemplateGroupItem)((Iterator)localObject1).next();
        if (((TemplateGroupItem)localObject3).jdField_a_of_type_JavaUtilList != null)
        {
          localObject3 = ((TemplateGroupItem)localObject3).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject3).next();
            if (localPtvTemplateInfo.e.equals(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.e)) {
              localPtvTemplateInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.a(localPtvTemplateInfo);
            }
          }
        }
      }
      ??? = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
      if (??? != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
        ???.a((PtvTemplateInfo)localObject1, ((PtvTemplateInfo)localObject1).jdField_b_of_type_Boolean);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    paramNetReq.jdField_b_of_type_Long = paramLong2;
    PtvTemplateManager.IPtvTemplateDownloadListener localIPtvTemplateDownloadListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
    if (localIPtvTemplateDownloadListener != null) {
      localIPtvTemplateDownloadListener.a(paramNetReq, (int)(paramLong1 * 100L / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.6
 * JD-Core Version:    0.7.0.1
 */