package com.tencent.biz.qqcircle.datacenter.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StBatchGetFeedDetailReq;
import feedcloud.FeedCloudRead.StBatchGetFeedDetailRsp;
import java.util.List;

public class QCircleFeedDetailListRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StBatchGetFeedDetailReq mRequest = new FeedCloudRead.StBatchGetFeedDetailReq();
  
  public QCircleFeedDetailListRequest(int paramInt, List<FeedCloudMeta.StFeed> paramList)
  {
    this.mRequest.from.set(0);
    this.mRequest.feedIndex.set(paramList);
    this.mRequest.source.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StBatchGetFeedDetailRsp localStBatchGetFeedDetailRsp = new FeedCloudRead.StBatchGetFeedDetailRsp();
    try
    {
      localStBatchGetFeedDetailRsp.mergeFrom(paramArrayOfByte);
      return localStBatchGetFeedDetailRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStBatchGetFeedDetailRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.BatchGetFeedDetail";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.request.QCircleFeedDetailListRequest
 * JD-Core Version:    0.7.0.1
 */