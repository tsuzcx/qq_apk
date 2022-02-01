package com.tencent.luggage.wxa.gg;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fx.d;
import com.tencent.luggage.wxa.gf.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements c
{
  private com.tencent.luggage.wxa.gf.c a;
  private Map<String, b> b = new ConcurrentHashMap();
  private com.tencent.luggage.wxa.fx.c c;
  
  @Nullable
  private b a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      b localb2 = (b)this.b.get(paramString2);
      b localb1 = localb2;
      if (localb2 == null)
      {
        o.b(b(), "getPluginHandler, key:%s, current no handler for this key", new Object[] { paramString2 });
        localb1 = localb2;
        if (this.a != null)
        {
          localb1 = this.a.a(paramString1);
          if (localb1 != null)
          {
            o.c(b(), "getPluginHandler, key:%s, created new plugin handler(%s)", new Object[] { paramString2, Integer.valueOf(localb1.hashCode()) });
            localb1.b(paramInt);
            localb1.a(paramString1);
            localb1.a(this);
            this.b.put(paramString2, localb1);
          }
          else
          {
            o.b(b(), "getPluginHandler, key:%s, no handler for this key?", new Object[] { paramString2 });
          }
        }
      }
      return localb1;
    }
    finally {}
  }
  
  private String b()
  {
    return String.format(Locale.US, "%s(%s)", new Object[] { "MicroMsg.SameLayer.DefaultExtendPluginClientProxy", Integer.valueOf(hashCode()) });
  }
  
  public com.tencent.luggage.wxa.fx.c a()
  {
    return this.c;
  }
  
  public String a(String paramString, int paramInt, com.tencent.luggage.wxa.fx.a parama)
  {
    String str = d.a(paramString, paramInt);
    o.d(b(), "handleJsApi, key:%s, jsapi:%s", new Object[] { str, parama.e() });
    paramString = a(paramString, paramInt, str);
    if (paramString == null)
    {
      o.c(b(), "handleJsApi, key:%s, handler is null", new Object[] { str });
      return "";
    }
    if (paramString.a(parama))
    {
      if (parama.c()) {
        return paramString.b(parama);
      }
      paramString.b(parama);
      return "";
    }
    if (parama.c()) {
      return parama.a("ok");
    }
    return "";
  }
  
  public void a(com.tencent.luggage.wxa.fx.c paramc)
  {
    this.c = paramc;
  }
  
  public void a(com.tencent.luggage.wxa.gf.c paramc)
  {
    this.a = paramc;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = d.a(paramString, paramInt);
    o.d(b(), "onPluginDestroy, key:%s", new Object[] { str });
    paramString = a(paramString, paramInt, str);
    if (paramString == null)
    {
      o.c(b(), "onPluginDestroy, key:%s, handler is null", new Object[] { str });
      return;
    }
    paramString.d();
  }
  
  public void a(String paramString, int paramInt, @Nullable Bitmap paramBitmap)
  {
    String str = d.a(paramString, paramInt);
    o.f(b(), "onPluginScreenshotTaken, key:%s", new Object[] { str });
    paramString = a(paramString, paramInt, str);
    if (paramString == null)
    {
      o.c(b(), "onPluginScreenshotTaken, key:%s, handler is null", new Object[] { str });
      return;
    }
    paramString.a(paramBitmap);
  }
  
  public void a(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    String str = d.a(paramString, paramInt);
    o.d(b(), "onPluginReady, key:%s", new Object[] { str });
    paramString = a(paramString, paramInt, str);
    if (paramString == null)
    {
      o.c(b(), "onPluginReady, key:%s, handler is null", new Object[] { str });
      return;
    }
    o.d(b(), "onPluginReady, key:%s, handler is ready", new Object[] { str });
    paramString.a(paramSurfaceTexture);
  }
  
  public void a(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    String str = d.a(paramString, paramInt);
    o.f(b(), "onPluginTouch, key:%s", new Object[] { str });
    paramString = a(paramString, paramInt, str);
    if (paramString == null)
    {
      o.c(b(), "onPluginTouch, key:%s, handler is null", new Object[] { str });
      return;
    }
    paramString.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gg.a
 * JD-Core Version:    0.7.0.1
 */