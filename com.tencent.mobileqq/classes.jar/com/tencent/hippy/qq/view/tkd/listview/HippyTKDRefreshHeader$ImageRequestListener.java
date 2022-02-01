package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Bitmap;

abstract interface HippyTKDRefreshHeader$ImageRequestListener
{
  public abstract void onRequestFail(Throwable paramThrowable, String paramString);
  
  public abstract void onRequestSuccess(Bitmap paramBitmap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.ImageRequestListener
 * JD-Core Version:    0.7.0.1
 */