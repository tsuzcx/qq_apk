package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONObject;

public abstract interface NativeCommentServlet$CommentObserver
{
  public abstract void a(ArticleInfo paramArticleInfo, int paramInt, String paramString);
  
  public abstract void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CommentObserver
 * JD-Core Version:    0.7.0.1
 */