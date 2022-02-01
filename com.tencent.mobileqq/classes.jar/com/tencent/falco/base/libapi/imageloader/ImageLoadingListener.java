package com.tencent.falco.base.libapi.imageloader;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface ImageLoadingListener
{
  public abstract void onLoadingCancelled(String paramString, View paramView);
  
  public abstract void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap);
  
  public abstract void onLoadingFailed(String paramString1, View paramView, String paramString2);
  
  public abstract void onLoadingStarted(String paramString, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.ImageLoadingListener
 * JD-Core Version:    0.7.0.1
 */