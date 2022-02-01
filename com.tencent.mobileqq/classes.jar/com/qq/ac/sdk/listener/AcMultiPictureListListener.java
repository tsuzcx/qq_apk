package com.qq.ac.sdk.listener;

import com.qq.ac.sdk.bean.AcMultiPictureListResponse;

public abstract interface AcMultiPictureListListener
{
  public abstract void onFailure(int paramInt);
  
  public abstract void onResponse(AcMultiPictureListResponse paramAcMultiPictureListResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.listener.AcMultiPictureListListener
 * JD-Core Version:    0.7.0.1
 */