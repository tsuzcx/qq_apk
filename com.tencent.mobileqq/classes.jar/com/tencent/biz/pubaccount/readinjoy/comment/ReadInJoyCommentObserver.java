package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.ResponseCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.ResponseExtraInfo;

public abstract interface ReadInJoyCommentObserver
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo1, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo2, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo);
  
  public abstract void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData);
  
  public abstract void a(int paramInt, String paramString, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo);
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2);
  
  public abstract void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString);
  
  public abstract void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, int paramInt, String paramString, boolean paramBoolean2);
  
  public abstract void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, String paramString, boolean paramBoolean2);
  
  public abstract void b(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData);
  
  public abstract void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString);
  
  public abstract void c(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver
 * JD-Core Version:    0.7.0.1
 */