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
    paramDouble1 = (paramDouble1 + 180.0D) / 360.0D;
    paramDouble2 = Math.sin(paramDouble2 * 3.1415926D / 180.0D);
    paramDouble2 = (180.0D - Math.log((paramDouble2 + 1.0D) / (1.0D - paramDouble2)) * 180.0D / 6.2831852D) / 360.0D;
    jp.a locala = new jp.a(this, (byte)0);
    locala.a = ((int)(paramDouble1 * 268435456.0D + 0.5D));
    locala.b = ((int)(paramDouble2 * 268435456.0D + 0.5D));
    return locala;
  }
  
  public final void run()
  {
    super.run();
    Object localObject1;
    if (!this.b) {
      if (!this.a)
      {
        localObject1 = this.c;
        if (localObject1 == null) {
          return;
        }
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      Object localObject4;
      for (;;)
      {
        try
        {
          int i = ((lw)localObject1).c.i.b.f;
          localObject1 = this.c.c.p();
          double d1 = ((Rect)localObject1).left / 1000000.0F;
          double d2 = ((Rect)localObject1).bottom / 1000000.0F;
          double d3 = ((Rect)localObject1).right / 1000000.0F;
          double d4 = ((Rect)localObject1).top / 1000000.0F;
          localObject1 = a(d1, d2);
          localObject4 = a(d3, d4);
          this.c.a.a(i, Math.min(((jp.a)localObject1).a, ((jp.a)localObject4).a), Math.min(((jp.a)localObject1).b, ((jp.a)localObject4).b), Math.max(((jp.a)localObject4).a, ((jp.a)localObject1).a), Math.max(((jp.a)localObject4).b, ((jp.a)localObject1).b));
          localObject1 = this.c;
          localObject4 = null;
          if (localObject1 == null)
          {
            localObject1 = localObject4;
          }
          else
          {
            if (this.c == null) {
              break label594;
            }
            Object localObject5 = this.c.a.g();
            if ((localObject5 == null) || (localObject5.length == 0)) {
              break label594;
            }
            localObject1 = new RttRequest();
            Object localObject6 = new ArrayList();
            int j = localObject5.length;
            i = 0;
            if (i < j)
            {
              Object localObject7 = localObject5[i];
              ((ArrayList)localObject6).add(Integer.valueOf(localObject7.d));
              ((ArrayList)localObject6).add(Integer.valueOf(localObject7.c));
              ((ArrayList)localObject6).add(Integer.valueOf(localObject7.f));
              ((ArrayList)localObject6).add(Integer.valueOf(localObject7.e));
              ((ArrayList)localObject6).add(Integer.valueOf(localObject7.g));
              i += 1;
              continue;
            }
            ((RttRequest)localObject1).bounds = ((ArrayList)localObject6);
            ((RttRequest)localObject1).zip = 1;
            ((RttRequest)localObject1).zoom = ((short)localObject5[0].a);
            break label597;
            localObject4 = this.d;
            localObject5 = new user_login_t();
            ((user_login_t)localObject5).pf = "android_sdk";
            ((user_login_t)localObject5).is_login = false;
            ((user_login_t)localObject5).channel = fz.d;
            ((user_login_t)localObject5).imei = fz.a();
            localObject6 = new e();
            ((e)localObject6).b("rttserverex");
            ((e)localObject6).c("getRtt");
            ((e)localObject6).a("info", localObject5);
            ((e)localObject6).a("req", localObject1);
            localObject1 = ((qe)localObject4).a(((e)localObject6).a());
          }
          if ((localObject1 != null) && (localObject1.length > 0)) {
            this.c.a.a((byte[])localObject1, localObject1.length);
          }
        }
        catch (Throwable localThrowable)
        {
          or.b("refreshTrafficData error", localThrowable);
        }
        this.c.k();
        try
        {
          for (;;)
          {
            try
            {
              if (this.e)
              {
                wait(500L);
                this.e = false;
              }
              else
              {
                wait(30000L);
              }
              break;
            }
            finally {}
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          label582:
          break label582;
        }
      }
      Thread.currentThread().interrupt();
      return;
      label594:
      Object localObject3 = null;
      label597:
      if (localObject3 == null) {
        localObject3 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.jp
 * JD-Core Version:    0.7.0.1
 */