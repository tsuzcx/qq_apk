package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;

public class FeedCommentDataProvider$DelFeedCommentResponse
  extends LegoResponseBase
{
  qqstory_service.RspDelFeedComment a;
  LegoResponseCallBack b;
  
  public FeedCommentDataProvider$DelFeedCommentResponse(LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.b = paramLegoResponseCallBack;
  }
  
  public FeedCommentDataProvider$DelFeedCommentResponse(qqstory_service.RspDelFeedComment paramRspDelFeedComment, LegoResponseCallBack paramLegoResponseCallBack)
  {
    super(paramRspDelFeedComment.result);
    this.a = paramRspDelFeedComment;
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
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.DelFeedCommentResponse
 * JD-Core Version:    0.7.0.1
 */