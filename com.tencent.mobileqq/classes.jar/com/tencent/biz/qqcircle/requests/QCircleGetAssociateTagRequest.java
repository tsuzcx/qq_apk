package com.tencent.biz.qqcircle.requests;

import circlesearch.CircleSearchExhibition.StMoreDataReq;
import circlesearch.CircleSearchExhibition.StMoreDataRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public class QCircleGetAssociateTagRequest
  extends QCircleBaseRequest
{
  public static final String TAG = "QCircleGetAssociateTagRequest";
  private CircleSearchExhibition.StMoreDataReq mReq = new CircleSearchExhibition.StMoreDataReq();
  
  public QCircleGetAssociateTagRequest(FeedCloudCommon.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.mReq.ext_info.set(paramStCommonExt);
    }
    this.mReq.query.set(paramString);
    this.mReq.type.set(9);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CircleSearchExhibition.StMoreDataRsp localStMoreDataRsp = new CircleSearchExhibition.StMoreDataRsp();
    try
    {
      localStMoreDataRsp.mergeFrom(paramArrayOfByte);
      return localStMoreDataRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStMoreDataRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.ExhibitionMoreData";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public CircleSearchExhibition.StMoreDataReq getmReq()
  {
    return this.mReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetAssociateTagRequest
 * JD-Core Version:    0.7.0.1
 */