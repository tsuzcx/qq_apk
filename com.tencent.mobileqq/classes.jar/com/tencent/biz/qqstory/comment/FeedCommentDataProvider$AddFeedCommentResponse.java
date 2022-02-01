package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;

public class FeedCommentDataProvider$AddFeedCommentResponse
  extends LegoResponseBase
{
  qqstory_service.RspAddFeedComment a;
  LegoResponseCallBack b;
  
  public FeedCommentDataProvider$AddFeedCommentResponse(LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.b = paramLegoResponseCallBack;
  }
  
  public FeedCommentDataProvider$AddFeedCommentResponse(qqstory_service.RspAddFeedComment paramRspAddFeedComment, LegoResponseCallBack paramLegoResponseCallBack)
  {
    super(paramRspAddFeedComment.result);
    this.a = paramRspAddFeedComment;
    this.b = paramLegoResponseCallBack;
  }
  
  public void a()
  {
    this.b.a(this.a);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.b.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b.a(paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.b.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.AddFeedCommentResponse
 * JD-Core Version:    0.7.0.1
 */