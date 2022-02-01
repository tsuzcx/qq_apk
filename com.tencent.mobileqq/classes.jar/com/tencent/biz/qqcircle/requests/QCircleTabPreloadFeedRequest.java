package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleTabPreloadFeedRequest
  extends QCircleBaseRequest
{
  protected FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  
  public QCircleTabPreloadFeedRequest(int paramInt, String paramString)
  {
    this.mRequest.source.set(paramInt);
    this.mRequest.from.set(0);
    if (!TextUtils.isEmpty(paramString)) {
      this.mRequest.feedAttchInfo.set(paramString);
    }
    paramString = new QQCircleFeedBase.StFeedListBusiReqData();
    paramString.pullSceneType.set(2);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
  }
  
  public FeedCloudRead.StGetFeedListRsp decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    try
    {
      localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleTabPreloadFeedRequest
 * JD-Core Version:    0.7.0.1
 */