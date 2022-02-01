package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StFeedDetailBizReqData;

public class QCircleGetFeedDetailRequest
  extends QCircleBaseRequest
{
  public static int FROM_NATIVE = 0;
  public static int FROM_PUSH_DETAIL = 3;
  public FeedCloudRead.StGetFeedDetailReq mRequest = new FeedCloudRead.StGetFeedDetailReq();
  
  public QCircleGetFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramLong, paramBoolean, 0, null, null);
  }
  
  public QCircleGetFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt, FeedCloudMeta.StFeed paramStFeed, QCircleInitBean paramQCircleInitBean)
  {
    this.mRequest.feedId.set(paramString1);
    this.mRequest.userId.set(paramString2);
    this.mRequest.createTime.set(paramLong);
    this.mRequest.useUGCStore.set(paramBoolean);
    this.mRequest.from.set(paramInt);
    if (paramStFeed != null)
    {
      paramString1 = QCirclePluginUtil.a(paramStFeed);
      if (paramString1 != null)
      {
        paramString1.busiTranparent.set(paramStFeed.busiTranparent.get());
        this.mRequest.entryFeed.set(paramString1);
      }
    }
    if (paramQCircleInitBean != null)
    {
      if (paramQCircleInitBean.isNeedShowGoHomeButton()) {
        this.mRequest.isMiddlePage.set(true);
      }
      if ((paramQCircleInitBean.getSchemeAttrs() != null) && (paramQCircleInitBean.getSchemeAttrs().containsKey("key_scheme")))
      {
        paramString1 = (String)paramQCircleInitBean.getSchemeAttrs().get("key_scheme");
        paramString2 = new QQCircleFeedBase.StFeedDetailBizReqData();
        if (paramString1 != null) {
          paramString2.entrySchema.set(paramString1);
        }
        this.mRequest.bizReqData.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
      }
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedDetailRsp localStGetFeedDetailRsp = new FeedCloudRead.StGetFeedDetailRsp();
    try
    {
      localStGetFeedDetailRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedDetailRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedDetailRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */