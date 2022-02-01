package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.qz.aa;
import com.tencent.luggage.wxa.qz.aa.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public class c
{
  private aa.a a = new c.1(this);
  private com.tencent.luggage.wxa.jx.c b;
  
  public void a()
  {
    o.d("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      aa.a(r.a(), this.a);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      o.a("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] resume set callback", new Object[0]);
    }
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc)
  {
    this.b = paramc;
    o.d("MicroMsg.AppBrandUserCaptureScreenMonitor", "init");
    try
    {
      aa.a(r.a(), this.a);
      return;
    }
    catch (SecurityException paramc)
    {
      o.a("MicroMsg.AppBrandUserCaptureScreenMonitor", paramc, "[NOT CRASH] init set callback", new Object[0]);
    }
  }
  
  public void b()
  {
    o.d("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      aa.a(r.a(), null);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      o.a("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.c
 * JD-Core Version:    0.7.0.1
 */