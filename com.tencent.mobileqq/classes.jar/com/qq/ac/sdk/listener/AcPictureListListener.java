package com.qq.ac.sdk.listener;

import com.qq.ac.sdk.bean.AcPictureListResponse;

public abstract interface AcPictureListListener
{
  public abstract void onFailure(int paramInt);
  
  public abstract void onResponse(AcPictureListResponse paramAcPictureListResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.ac.sdk.listener.AcPictureListListener
 * JD-Core Version:    0.7.0.1
 */