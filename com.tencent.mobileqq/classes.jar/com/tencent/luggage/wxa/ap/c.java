package com.tencent.luggage.wxa.ap;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;

@TargetApi(17)
public final class c
  extends Surface
{
  private static boolean b;
  private static boolean c;
  public final boolean a;
  private final c.a d;
  private boolean e;
  
  private c(c.a parama, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.d = parama;
    this.a = paramBoolean;
  }
  
  public static c a(Context paramContext, boolean paramBoolean)
  {
    
    boolean bool;
    if ((paramBoolean) && (!a(paramContext))) {
      bool = false;
    } else {
      bool = true;
    }
    a.b(bool);
    return new c.a().a(paramBoolean);
  }
  
  private static void a()
  {
    if (x.a >= 17) {
      return;
    }
    throw new UnsupportedOperationException("Unsupported prior to API level 17");
  }
  
  public static boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (!c)
        {
          if ((x.a >= 24) && (b(paramContext)))
          {
            bool = true;
            b = bool;
            c = true;
          }
        }
        else
        {
          bool = b;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  @TargetApi(24)
  private static boolean b(Context paramContext)
  {
    String str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
    if (str != null)
    {
      if (!str.contains("EGL_EXT_protected_content")) {
        return false;
      }
      if ((x.a == 24) && ("samsung".equals(x.c))) {
        return false;
      }
      return (x.a >= 26) || (paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"));
    }
    return false;
  }
  
  public void release()
  {
    super.release();
    synchronized (this.d)
    {
      if (!this.e)
      {
        this.d.a();
        this.e = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.c
 * JD-Core Version:    0.7.0.1
 */