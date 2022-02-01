package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedLikeDataProvider$GetLikeListRequest
  extends LegoRequestBase
{
  String a;
  boolean b;
  
  public FeedLikeDataProvider$GetLikeListRequest(FeedLikeDataProvider paramFeedLikeDataProvider, String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspFeedLikeList();
    try
    {
      ((qqstory_service.RspFeedLikeList)localObject).mergeFrom(paramArrayOfByte);
      return new FeedLikeDataProvider.GetLikeListResponse(this.c, (qqstory_service.RspFeedLikeList)localObject, this.b);
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
    return FeedLikeDataProvider.a;
  }
  
  protected byte[] b()
  {
    qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
    localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.a));
    int i;
    if (this.b) {
      i = 2;
    } else {
      i = 1;
    }
    localReqFeedLikeList.source.set(i);
    return localReqFeedLikeList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.GetLikeListRequest
 * JD-Core Version:    0.7.0.1
 */