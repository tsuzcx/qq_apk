package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;

public abstract interface ImageLoader$StreamDownloadListener
{
  public abstract void onApplyToImage(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions);
  
  public abstract void onDownloadCanceled(String paramString1, String paramString2, String paramString3);
  
  public abstract void onDownloadFailed(String paramString1, String paramString2, String paramString3);
  
  public abstract void onDownloadProgress(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void onDownloadSucceed(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader.StreamDownloadListener
 * JD-Core Version:    0.7.0.1
 */