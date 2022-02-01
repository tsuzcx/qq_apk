package com.tencent.luggage.wxa.ma;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface e
{
  public abstract void a();
  
  public abstract void a(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean a(double paramDouble);
  
  public abstract boolean a(double paramDouble, boolean paramBoolean);
  
  public abstract boolean a(float paramFloat);
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract boolean f();
  
  public abstract void g();
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract View getView();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void setCover(Bitmap paramBitmap);
  
  public abstract void setFullDirection(int paramInt);
  
  public abstract void setIMMVideoViewCallback(e.c paramc);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(e.h paramh);
  
  public abstract void setVideoFooterView(e.b paramb);
  
  public abstract void setVideoSource(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.e
 * JD-Core Version:    0.7.0.1
 */