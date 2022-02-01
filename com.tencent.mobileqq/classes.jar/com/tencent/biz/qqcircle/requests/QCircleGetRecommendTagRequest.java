package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudTagcategorysvr.PicRecomEntry;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomReq;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;
import java.util.List;

public class QCircleGetRecommendTagRequest
  extends QCircleBaseRequest
{
  public static final String TAG = "QCircleGetRecommendTagRequest";
  private FeedCloudTagcategorysvr.StTagCategoryRecomReq mReq = new FeedCloudTagcategorysvr.StTagCategoryRecomReq();
  
  public QCircleGetRecommendTagRequest(FeedCloudMeta.StGPSV2 paramStGPSV2, List<FeedCloudTagcategorysvr.PicRecomEntry> paramList)
  {
    this.mReq.reqType.set(1);
    FeedCloudTagcategorysvr.StTagCategoryRecomReq localStTagCategoryRecomReq = this.mReq;
    localStTagCategoryRecomReq.gpsInfo = paramStGPSV2;
    localStTagCategoryRecomReq.picRecomMap.set(paramList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudTagcategorysvr.StTagCategoryRecomRsp localStTagCategoryRecomRsp = new FeedCloudTagcategorysvr.StTagCategoryRecomRsp();
    try
    {
      localStTagCategoryRecomRsp.mergeFrom(paramArrayOfByte);
      return localStTagCategoryRecomRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStTagCategoryRecomRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.tagcategorysvr.TagCategoryProcess.GetTagCategoryRecom";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetRecommendTagRequest
 * JD-Core Version:    0.7.0.1
 */