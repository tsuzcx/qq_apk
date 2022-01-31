package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public abstract interface ArticleCommentModule$CreateCommentObserver
{
  public abstract void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2);
  
  public abstract void a(ArticleInfo paramArticleInfo, String paramString, CommentInfo paramCommentInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.CreateCommentObserver
 * JD-Core Version:    0.7.0.1
 */