package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.database.PublishVideoEntry;

abstract interface EncodeVideoTask$EncodeProcessListener
{
  public abstract void onError(int paramInt);
  
  public abstract void onNext(PublishVideoEntry paramPublishVideoEntry, String paramString);
  
  public abstract void onSend(PublishVideoEntry paramPublishVideoEntry, String paramString);
  
  public abstract void onStoryMergeCompleted(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.EncodeProcessListener
 * JD-Core Version:    0.7.0.1
 */