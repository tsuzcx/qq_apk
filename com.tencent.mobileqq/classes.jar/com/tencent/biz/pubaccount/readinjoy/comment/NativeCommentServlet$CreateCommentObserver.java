package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract interface NativeCommentServlet$CreateCommentObserver
{
  public abstract void a(ArticleInfo paramArticleInfo, int paramInt1, String paramString1, JSONObject paramJSONObject, String paramString2, JSONArray paramJSONArray, int paramInt2);
  
  public abstract void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CreateCommentObserver
 * JD-Core Version:    0.7.0.1
 */