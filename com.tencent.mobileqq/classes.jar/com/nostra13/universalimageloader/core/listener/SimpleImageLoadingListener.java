package com.nostra13.universalimageloader.core.listener;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

public class SimpleImageLoadingListener
  implements ImageLoadingListener
{
  public void onLoadingCancelled(String paramString, View paramView) {}
  
  public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {}
  
  public void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason) {}
  
  public void onLoadingStarted(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener
 * JD-Core Version:    0.7.0.1
 */