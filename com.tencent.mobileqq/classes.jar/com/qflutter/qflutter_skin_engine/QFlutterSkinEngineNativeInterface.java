package com.qflutter.qflutter_skin_engine;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.List;

public abstract interface QFlutterSkinEngineNativeInterface
{
  public abstract Bitmap getBitmapFromDrawable(Drawable paramDrawable);
  
  public abstract NativeImageInfo getNativeAppImage(String paramString);
  
  public abstract List<NativeColorInfo> getNativeSkinColors();
  
  public abstract NinePatchInfo getNinePatchInfo(Drawable paramDrawable);
  
  public abstract Handler getSubThreadHandler();
  
  public abstract Handler getUiThreadHandler();
  
  public abstract boolean isNinePatchDrawable(Drawable paramDrawable);
  
  public abstract void loadJniSo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qflutter.qflutter_skin_engine.QFlutterSkinEngineNativeInterface
 * JD-Core Version:    0.7.0.1
 */