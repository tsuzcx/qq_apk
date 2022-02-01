package com.tencent.biz.expand.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface IQFlutterFaceLoaderApi$ApiFaceObserver
{
  public abstract void onFaceUpdate(ApiDecodeRequest paramApiDecodeRequest, Bitmap paramBitmap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.IQFlutterFaceLoaderApi.ApiFaceObserver
 * JD-Core Version:    0.7.0.1
 */