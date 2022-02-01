package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
    if (paramStFeed != null)
    {
      this.req = new FeedCloudRead.StGetLightInteractListReq();
      if (paramInt != 1) {
        break label144;
      }
      paramString2 = new QQCircleFeedBase.StFeedBusiReqData();
    }
    for (;;)
    {
      try
      {
        paramString2.mergeFrom(paramStFeed.busiData.get().toByteArray());
        this.req.id.set(paramString2.pushList.id.get());
        this.req.feedID.set(paramStFeed.id.get());
        this.req.hostID.set(paramStFeed.poster.id.get());
        this.req.type.set(paramInt);
        if (paramString1 != null) {
          this.req.attachInfo.set(paramString1);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
      }
      label144:
      if ((paramInt == 6) || (paramInt == 7))
      {
        if (TextUtils.isEmpty(paramString2)) {
          this.req.id.set(paramStFeed.likeInfo.id.get());
        }
        for (;;)
        {
          paramInt = 2;
          break;
          this.req.id.set(paramString2);
        }
      }
      this.req.id.set(paramStFeed.likeInfo.id.get());
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetLightInteractListRsp localStGetLightInteractListRsp = new FeedCloudRead.StGetLightInteractListRsp();
    localStGetLightInteractListRsp.mergeFrom(paramArrayOfByte);
    return localStGetLightInteractListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetLightInteractList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest
 * JD-Core Version:    0.7.0.1
 */