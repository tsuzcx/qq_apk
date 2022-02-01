package com.tencent.gdtad.inject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public abstract interface IGdtThirdProcessor
{
  public abstract Drawable a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt1, int paramInt2);
  
  public abstract Drawable a(Context paramContext, String paramString);
  
  public abstract String a(Context paramContext);
  
  public abstract void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract boolean a();
  
  public abstract Drawable b(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.inject.IGdtThirdProcessor
 * JD-Core Version:    0.7.0.1
 */