package com.qq.ac.sdk.listener;

import com.qq.ac.sdk.bean.AcChapterListResponse;

public abstract interface AcChapterListListener
{
  public abstract void onFailure(int paramInt);
  
  public abstract void onResponse(AcChapterListResponse paramAcChapterListResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.listener.AcChapterListListener
 * JD-Core Version:    0.7.0.1
 */