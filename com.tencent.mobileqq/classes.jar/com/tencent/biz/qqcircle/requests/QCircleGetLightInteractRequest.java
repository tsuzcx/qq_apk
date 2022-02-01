package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetLightInteractListReq;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleGetLightInteractRequest
  extends QCircleBaseRequest
{
  private FeedCloudRead.StGetLightInteractListReq req;
  
  public QCircleGetLightInteractRequest(FeedCloudMeta.StFeed paramStFeed, String paramString1, int paramInt, String paramString2)
  {
    this(paramStFeed, paramString1, paramInt, paramString2, -1L, 1);
  }
  
  public QCircleGetLightInteractRequest(FeedCloudMeta.StFeed paramStFeed, String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2)
  {
    if (paramStFeed != null)
    {
      this.req = new FeedCloudRead.StGetLightInteractListReq();
      if (paramInt1 == 1)
      {
        paramString2 = new QQCircleFeedBase.StFeedBusiReqData();
        try
        {
          paramString2.mergeFrom(paramStFeed.busiData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        this.req.id.set(paramString2.pushList.id.get());
      }
      else if ((paramInt1 != 6) && (paramInt1 != 7))
      {
        this.req.id.set(paramStFeed.likeInfo.id.get());
      }
      else
      {
        if (TextUtils.isEmpty(paramString2)) {
          this.req.id.set(paramStFeed.likeInfo.id.get());
        } else {
          this.req.id.set(paramString2);
        }
        paramInt1 = 2;
      }
      this.req.feedID.set(paramStFeed.id.get());
      this.req.hostID.set(paramStFeed.poster.id.get());
      this.req.type.set(paramInt1);
      if (paramLong != -1L)
      {
        paramStFeed = new FeedCloudCommon.Entry();
        paramStFeed.key.set("last_like_time");
        paramStFeed.value.set(String.valueOf(paramLong));
        this.req.extInfo.mapInfo.add(paramStFeed);
      }
      if (paramString1 != null) {
        this.req.attachInfo.set(paramString1);
      }
      this.req.source.set(paramInt2);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetLightInteractListRsp localStGetLightInteractListRsp = new FeedCloudRead.StGetLightInteractListRsp();
    try
    {
      localStGetLightInteractListRsp.mergeFrom(paramArrayOfByte);
      return localStGetLightInteractListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetLightInteractListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetLightInteractList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest
 * JD-Core Version:    0.7.0.1
 */