package com.tencent.mobileqq.activity.springfestival.entry;

import android.graphics.Bitmap;
import org.jetbrains.annotations.Nullable;

public abstract interface IPreloadRes
{
  @Nullable
  public abstract Bitmap a(String paramString1, String paramString2);
  
  @Nullable
  public abstract Bitmap a(String paramString1, String paramString2, String paramString3);
  
  @Nullable
  public abstract String a(String paramString);
  
  public abstract void a(IPreloadRes.OnDownloadCallback paramOnDownloadCallback);
  
  @Nullable
  public abstract String b(String paramString);
  
  public abstract void b(IPreloadRes.OnDownloadCallback paramOnDownloadCallback);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes
 * JD-Core Version:    0.7.0.1
 */