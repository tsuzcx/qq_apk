package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public abstract interface NativeCommentServlet$CommentObserver
{
  public abstract void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString);
  
  public abstract void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.NativeCommentServlet.CommentObserver
 * JD-Core Version:    0.7.0.1
 */