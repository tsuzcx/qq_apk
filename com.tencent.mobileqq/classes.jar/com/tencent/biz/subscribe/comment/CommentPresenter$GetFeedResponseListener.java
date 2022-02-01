package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;

public abstract interface CommentPresenter$GetFeedResponseListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.GetFeedResponseListener
 * JD-Core Version:    0.7.0.1
 */