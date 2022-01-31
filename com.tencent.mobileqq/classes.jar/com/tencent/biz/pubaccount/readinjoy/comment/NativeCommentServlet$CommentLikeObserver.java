package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONObject;

public abstract interface NativeCommentServlet$CommentLikeObserver
{
  public abstract void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2);
  
  public abstract void a(ArticleInfo paramArticleInfo, String paramString, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CommentLikeObserver
 * JD-Core Version:    0.7.0.1
 */