package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public abstract interface NativeCommentServlet$CommentLikeObserver
{
  public abstract void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, int paramInt, String paramString2);
  
  public abstract void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.NativeCommentServlet.CommentLikeObserver
 * JD-Core Version:    0.7.0.1
 */