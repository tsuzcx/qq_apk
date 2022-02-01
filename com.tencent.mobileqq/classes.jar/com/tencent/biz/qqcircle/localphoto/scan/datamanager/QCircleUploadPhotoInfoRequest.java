package com.tencent.biz.qqcircle.localphoto.scan.datamanager;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import qqcircle.QQCirclePhotocatemetadata.PhotoMetadata;
import qqcircle.QQCircleReport.PhotoMetadataUploadReq;
import qqcircle.QQCircleReport.PhotoMetadataUploadRsp;

public class QCircleUploadPhotoInfoRequest
  extends QCircleBaseRequest
{
  QQCircleReport.PhotoMetadataUploadReq mRequest = new QQCircleReport.PhotoMetadataUploadReq();
  
  public QCircleUploadPhotoInfoRequest(ArrayList<QQCirclePhotocatemetadata.PhotoMetadata> paramArrayList1, ArrayList<QQCirclePhotocatemetadata.PhotoMetadata> paramArrayList2, boolean paramBoolean)
  {
    if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
      this.mRequest.AddPhotoMetadatas.set(paramArrayList1);
    }
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
      this.mRequest.DelPhotoMetadatas.set(paramArrayList2);
    }
    this.mRequest.uploadComplete.set(paramBoolean);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleReport.PhotoMetadataUploadRsp localPhotoMetadataUploadRsp = new QQCircleReport.PhotoMetadataUploadRsp();
    try
    {
      localPhotoMetadataUploadRsp.mergeFrom(paramArrayOfByte);
      return localPhotoMetadataUploadRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localPhotoMetadataUploadRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.PhotoMetadataUpload";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.datamanager.QCircleUploadPhotoInfoRequest
 * JD-Core Version:    0.7.0.1
 */