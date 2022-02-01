package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import vhe;

public class QCircleGetFeedDetailRequest
  extends QCircleBaseRequest
{
  public static int FROM_NATIVE;
  public static int FROM_PUSH_DETAIL = 3;
  public FeedCloudRead.StGetFeedDetailReq mRequest = new FeedCloudRead.StGetFeedDetailReq();
  
  public QCircleGetFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramLong, paramBoolean, 0, null);
  }
  
  public QCircleGetFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    this.mRequest.feedId.set(paramString1);
    this.mRequest.userId.set(paramString2);
    this.mRequest.createTime.set(paramLong);
    this.mRequest.useUGCStore.set(paramBoolean);
    this.mRequest.from.set(paramInt);
    if (paramStFeed != null)
    {
      paramString1 = vhe.a(paramStFeed);
      if (paramString1 != null)
      {
        paramString1.busiTranparent.set(paramStFeed.busiTranparent.get());
        this.mRequest.entryFeed.set(paramString1);
      }
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedDetailRsp localStGetFeedDetailRsp = new FeedCloudRead.StGetFeedDetailRsp();
    localStGetFeedDetailRsp.mergeFrom(paramArrayOfByte);
    return localStGetFeedDetailRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleGetFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */