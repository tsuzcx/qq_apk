package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;

abstract interface EncodeVideoTask$EncodeProcessListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong);
  
  public abstract void a(PublishVideoEntry paramPublishVideoEntry, String paramString);
  
  public abstract void b(PublishVideoEntry paramPublishVideoEntry, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.EncodeProcessListener
 * JD-Core Version:    0.7.0.1
 */