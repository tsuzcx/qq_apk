package com.tencent.luggage.wxa.kp;

import android.util.Size;
import android.view.View;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;

public abstract interface e
  extends f.b, f.c, f.d
{
  public static final e c = new e.1();
  
  public abstract float a(float paramFloat);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(com.tencent.luggage.wxa.jx.c paramc, String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract boolean a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void g();
  
  public abstract int getCameraId();
  
  public abstract View getView();
  
  public abstract void h();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract void setAppId(String paramString);
  
  public abstract void setCameraId(int paramInt);
  
  public abstract void setCompressRecord(boolean paramBoolean);
  
  public abstract void setDisplayScreenSize(Size paramSize);
  
  public abstract void setFlash(String paramString);
  
  public abstract void setFrameLimitSize(int paramInt);
  
  public abstract void setMode(String paramString);
  
  public abstract void setNeedOutput(boolean paramBoolean);
  
  public abstract void setOperateCallBack(c paramc);
  
  public abstract void setOutPutCallBack(b paramb);
  
  public abstract void setPage(com.tencent.luggage.wxa.jx.e parame);
  
  public abstract void setPageOrientation(boolean paramBoolean);
  
  public abstract void setPreviewCenterCrop(boolean paramBoolean);
  
  public abstract void setQuality(String paramString);
  
  public abstract void setResolution(String paramString);
  
  public abstract void setScanFreq(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.e
 * JD-Core Version:    0.7.0.1
 */