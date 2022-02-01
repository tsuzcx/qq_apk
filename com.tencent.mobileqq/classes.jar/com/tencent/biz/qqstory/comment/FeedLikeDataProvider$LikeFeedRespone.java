package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLikeFeed;

public class FeedLikeDataProvider$LikeFeedRespone
  extends LegoResponseBase
{
  qqstory_service.RspLikeFeed a;
  
  public FeedLikeDataProvider$LikeFeedRespone() {}
  
  public FeedLikeDataProvider$LikeFeedRespone(qqstory_service.RspLikeFeed paramRspLikeFeed)
  {
    super(paramRspLikeFeed.result);
    this.a = paramRspLikeFeed;
  }
  
  public void a() {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.LikeFeedRespone
 * JD-Core Version:    0.7.0.1
 */