package com.qflutter.resource_loader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.List;

public abstract interface NativeAppInterface
{
  public abstract Bitmap getBitmapFromDrawable(Drawable paramDrawable);
  
  public abstract NativeImageInfo getNativeAppImage(String paramString);
  
  public abstract List<NativeColorInfo> getNativeThemeColors();
  
  public abstract NinePatchInfo getNinePatchInfo(Drawable paramDrawable);
  
  public abstract Handler getSubThreadHandler();
  
  public abstract String getThemeId();
  
  public abstract Handler getUiThreadHandler();
  
  public abstract boolean isNinePatchDrawable(Drawable paramDrawable);
  
  public abstract void loadJniSo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qflutter.resource_loader.NativeAppInterface
 * JD-Core Version:    0.7.0.1
 */