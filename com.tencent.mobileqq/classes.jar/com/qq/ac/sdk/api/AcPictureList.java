package com.qq.ac.sdk.api;

import com.qq.ac.sdk.a.a.a;
import com.qq.ac.sdk.bean.AcPictureListResponse;
import com.qq.ac.sdk.listener.AcPictureListListener;

public class AcPictureList
  extends BaseAcApi<AcPictureList, AcPictureListListener>
{
  public void getPictureList(String paramString1, String paramString2)
  {
    this.mAcComicImpl.b(paramString1, paramString2);
  }
  
  public AcPictureList setListener(AcPictureListListener paramAcPictureListListener)
  {
    this.mAcComicImpl.a(paramAcPictureListListener);
    return this;
  }
  
  public AcPictureListResponse syncGetPictureList(String paramString1, String paramString2)
  {
    return this.mAcComicImpl.c(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.api.AcPictureList
 * JD-Core Version:    0.7.0.1
 */