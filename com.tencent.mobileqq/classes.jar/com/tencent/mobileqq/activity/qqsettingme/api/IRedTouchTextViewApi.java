package com.tencent.mobileqq.activity.qqsettingme.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.InputStream;

@QAPI(process={""})
public abstract interface IRedTouchTextViewApi
  extends QRouteApi
{
  public abstract Drawable getApngURLDrawable(String paramString);
  
  public abstract double getOptRatio(InputStream paramInputStream, int paramInt1, int paramInt2);
  
  public abstract Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi
 * JD-Core Version:    0.7.0.1
 */