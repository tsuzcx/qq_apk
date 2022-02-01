package com.tencent.av.business.manager.support;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public abstract class SupportBase
{
  protected String a;
  protected int b;
  protected long c;
  protected int d;
  protected long e;
  protected VideoAppInterface f;
  
  public SupportBase(VideoAppInterface paramVideoAppInterface)
  {
    this.f = paramVideoAppInterface;
  }
  
  public void a()
  {
    this.a = Build.MODEL.toLowerCase();
    this.b = Build.VERSION.SDK_INT;
    this.c = VcSystemInfo.getMaxCpuFreq();
    this.d = VcSystemInfo.getNumCores();
    this.e = DeviceInfoUtil.a();
  }
  
  public abstract boolean a(int paramInt, String paramString);
  
  public abstract boolean a(String paramString);
  
  public abstract int b(String paramString);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportBase
 * JD-Core Version:    0.7.0.1
 */