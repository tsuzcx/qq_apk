package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLikeFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLikeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedLikeDataProvider$LikeFeedRequest
  extends LegoRequestBase
{
  String a;
  boolean b;
  int c;
  int d = -1;
  
  public FeedLikeDataProvider$LikeFeedRequest(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramBoolean;
    this.d = paramInt1;
    this.c = paramInt2;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspLikeFeed();
    try
    {
      ((qqstory_service.RspLikeFeed)localObject).mergeFrom(paramArrayOfByte);
      return new FeedLikeDataProvider.LikeFeedRespone((qqstory_service.RspLikeFeed)localObject);
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:FeedLikeDataProvider", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    return FeedLikeDataProvider.b;
  }
  
  protected byte[] b()
  {
    qqstory_service.ReqLikeFeed localReqLikeFeed = new qqstory_service.ReqLikeFeed();
    localReqLikeFeed.feed_id.set(ByteStringMicro.copyFromUtf8(this.a));
    PBUInt32Field localPBUInt32Field = localReqLikeFeed.operation;
    int i;
    if (this.b) {
      i = 1;
    } else {
      i = 2;
    }
    localPBUInt32Field.set(i);
    localReqLikeFeed.source.set(this.c);
    if (this.d != -1) {
      localReqLikeFeed.type.set(this.d);
    }
    return localReqLikeFeed.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.LikeFeedRequest
 * JD-Core Version:    0.7.0.1
 */