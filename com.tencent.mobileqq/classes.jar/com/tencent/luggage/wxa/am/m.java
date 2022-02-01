package com.tencent.luggage.wxa.am;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class m
  implements g
{
  private final Context a;
  private final w<? super g> b;
  private final g c;
  private g d;
  private g e;
  private g f;
  private g g;
  private g h;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramw;
    this.c = ((g)a.a(paramg));
  }
  
  private g c()
  {
    if (this.d == null) {
      this.d = new q(this.b);
    }
    return this.d;
  }
  
  private g d()
  {
    if (this.e == null) {
      this.e = new c(this.a, this.b);
    }
    return this.e;
  }
  
  private g e()
  {
    if (this.f == null) {
      this.f = new e(this.a, this.b);
    }
    return this.f;
  }
  
  private g f()
  {
    if (this.g == null) {}
    try
    {
      try
      {
        this.g = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", localInvocationTargetException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", localInstantiationException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label88:
      break label88;
    }
    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
    if (this.g == null) {
      this.g = this.c;
    }
    return this.g;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.h.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long a(j paramj)
  {
    boolean bool;
    if (this.h == null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    String str = paramj.a.getScheme();
    if (x.a(paramj.a))
    {
      if (paramj.a.getPath().startsWith("/android_asset/")) {
        this.h = d();
      } else {
        this.h = c();
      }
    }
    else if ("asset".equals(str)) {
      this.h = d();
    } else if ("content".equals(str)) {
      this.h = e();
    } else if ("rtmp".equals(str)) {
      this.h = f();
    } else {
      this.h = this.c;
    }
    return this.h.a(paramj);
  }
  
  public void a()
  {
    g localg = this.h;
    if (localg != null) {
      try
      {
        localg.a();
        return;
      }
      finally
      {
        this.h = null;
      }
    }
  }
  
  public Uri b()
  {
    g localg = this.h;
    if (localg == null) {
      return null;
    }
    return localg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.m
 * JD-Core Version:    0.7.0.1
 */