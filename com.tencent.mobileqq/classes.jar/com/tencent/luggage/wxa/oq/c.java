package com.tencent.luggage.wxa.oq;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.k;

public abstract interface c
  extends k, g, Comparable<c>
{
  public abstract d a(@Nullable d.b paramb);
  
  public abstract void a(@ColorInt int paramInt, @NonNull com.tencent.luggage.wxa.iu.d paramd);
  
  public abstract void a(j paramj, com.tencent.luggage.wxa.iu.d paramd);
  
  public abstract boolean g_();
  
  public abstract Context getContext();
  
  public abstract e getOrientationHandler();
  
  @Nullable
  public abstract Rect getSafeAreaInsets();
  
  public abstract DisplayMetrics getVDisplayMetrics();
  
  public abstract boolean h_();
  
  public abstract boolean i();
  
  @Deprecated
  public abstract void setSoftOrientation(String paramString);
  
  public abstract void setWindowDescription(c.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.c
 * JD-Core Version:    0.7.0.1
 */