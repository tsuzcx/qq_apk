package com.tencent.hippy.qq.tuwen.callback;

import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;

public abstract interface ITKDTuWenHippyObserver
{
  public abstract void onDeleteMainComment(String paramString);
  
  public abstract void onDeleteSubComment(String paramString1, String paramString2);
  
  public abstract void onInsertSubComment(String paramString1, String paramString2, SubCommentData paramSubCommentData);
  
  public abstract void onLikeMainCommentChanged(String paramString, boolean paramBoolean);
  
  public abstract void onOpenCommentPublisher();
  
  public abstract void sendCommentReadTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObserver
 * JD-Core Version:    0.7.0.1
 */