package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.sdk.service.protocol.jce.rtt.RttRequest;
import com.tencent.map.sdk.service.protocol.jce.user.user_login_t;
import java.util.ArrayList;
import java.util.List;

public final class jp
  extends Thread
{
  public boolean a = false;
  boolean b = false;
  private lw c = null;
  private qe d = null;
  private boolean e = true;
  private List<Object> f;
  
  public jp(lw paramlw, qe paramqe)
  {
    this.c = paramlw;
    this.d = paramqe;
    this.f = new ArrayList();
  }
  
  private jp.a a(double paramDouble1, double paramDouble2)
  {
    paramDouble1 = (180.0D + paramDouble1) / 360.0D;
    paramDouble2 = Math.sin(3.1415926D * paramDouble2 / 180.0D);
    paramDouble2 = (180.0D - Math.log((1.0D + paramDouble2) / (1.0D - paramDouble2)) * 180.0D / 6.2831852D) / 360.0D;
    jp.a locala = new jp.a(this, (byte)0);
    locala.a = ((int)(paramDouble1 * 268435456.0D + 0.5D));
    locala.b = ((int)(0.5D + paramDouble2 * 268435456.0D));
    return locala;
  }
  
  public final void run()
  {
    super.run();
    for (;;)
    {
      if (!this.b)
      {
        if (this.a) {
          break label235;
        }
        if (this.c != null) {}
      }
      else
      {
        return;
      }
      if (this.c != null) {}
      try
      {
        i = this.c.c.i.b.f;
        Object localObject1 = this.c.c.p();
        double d1 = ((Rect)localObject1).left / 1000000.0F;
        double d2 = ((Rect)localObject1).bottom / 1000000.0F;
        double d3 = ((Rect)localObject1).right / 1000000.0F;
        double d4 = ((Rect)localObject1).top / 1000000.0F;
        localObject1 = a(d1, d2);
        localObject3 = a(d3, d4);
        this.c.a.a(i, Math.min(((jp.a)localObject1).a, ((jp.a)localObject3).a), Math.min(((jp.a)localObject1).b, ((jp.a)localObject3).b), Math.max(((jp.a)localObject3).a, ((jp.a)localObject1).a), Math.max(((jp.a)localObject3).b, ((jp.a)localObject1).b));
        if (this.c != null) {
          break;
        }
        localObject1 = null;
        if ((localObject1 != null) && (localObject1.length > 0)) {
          this.c.a.a((byte[])localObject1, localObject1.length);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i;
          label235:
          RttRequest localRttRequest;
          label256:
          int j;
          or.b("refreshTrafficData error", localThrowable);
        }
      }
      this.c.k();
      try
      {
        try
        {
          if (!this.e) {
            break label576;
          }
          wait(500L);
          this.e = false;
          continue;
        }
        finally {}
        if (this.c != null) {
          break label290;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return;
      }
    }
    localRttRequest = null;
    break label586;
    label290:
    Object localObject3 = this.c.a.g();
    Object localObject4;
    e locale;
    if ((localObject3 != null) && (localObject3.length != 0))
    {
      localRttRequest = new RttRequest();
      localObject4 = new ArrayList();
      j = localObject3.length;
      i = 0;
      while (i < j)
      {
        locale = localObject3[i];
        ((ArrayList)localObject4).add(Integer.valueOf(locale.d));
        ((ArrayList)localObject4).add(Integer.valueOf(locale.c));
        ((ArrayList)localObject4).add(Integer.valueOf(locale.f));
        ((ArrayList)localObject4).add(Integer.valueOf(locale.e));
        ((ArrayList)localObject4).add(Integer.valueOf(locale.g));
        i += 1;
      }
      localRttRequest.bounds = ((ArrayList)localObject4);
      localRttRequest.zip = 1;
      localRttRequest.zoom = ((short)localObject3[0].a);
    }
    label576:
    label586:
    label601:
    for (;;)
    {
      localObject3 = this.d;
      localObject4 = new user_login_t();
      ((user_login_t)localObject4).pf = "android_sdk";
      ((user_login_t)localObject4).is_login = false;
      ((user_login_t)localObject4).channel = fz.d;
      ((user_login_t)localObject4).imei = fz.a();
      locale = new e();
      locale.b("rttserverex");
      locale.c("getRtt");
      locale.a("info", localObject4);
      locale.a("req", localThrowable);
      byte[] arrayOfByte = ((qe)localObject3).a(locale.a());
      break;
      wait(30000L);
      break label256;
      for (;;)
      {
        if (arrayOfByte != null) {
          break label601;
        }
        arrayOfByte = null;
        break;
        arrayOfByte = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.jp
 * JD-Core Version:    0.7.0.1
 */