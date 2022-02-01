package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQAvatarUtilApi
  extends QRouteApi
{
  public abstract Bitmap genSquareFaceBmpByShape(Bitmap paramBitmap);
  
  public abstract String get1080QQHeadDownLoadUrl(String paramString, byte paramByte);
  
  public abstract Bitmap getBitmapWithCache(String paramString, int paramInt);
  
  public abstract Drawable getDefaultDiscusionFaceDrawable();
  
  public abstract Drawable getDefaultFaceDrawable(boolean paramBoolean);
  
  public abstract Drawable getDefaultTroopFaceDrawable();
  
  public abstract Bitmap getDrawableBitmap(Drawable paramDrawable);
  
  public abstract String getIp(String paramString, boolean paramBoolean);
  
  public abstract Bitmap getRoundFaceBitmap(Bitmap paramBitmap);
  
  public abstract Bitmap getShapeRoundFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
 * JD-Core Version:    0.7.0.1
 */