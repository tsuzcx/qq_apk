package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.basic.util.j;
import com.tencent.liteav.basic.util.j.a;
import com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class c
{
  private static volatile c a;
  private final Context b;
  private final Handler c;
  private final Map<Surface, c.a> d = new HashMap();
  private boolean e = false;
  private MediaProjection f;
  private j g;
  private boolean h;
  private MediaProjection.Callback i = new c.1(this);
  private j.a j = new c.2(this);
  
  public c(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new f(Looper.getMainLooper());
    this.h = b(paramContext);
  }
  
  public static c a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new c(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if (locala.e == null)
      {
        locala.e = this.f.createVirtualDisplay("TXCScreenCapture", locala.b, locala.c, 1, 1, locala.a, null, null);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create VirtualDisplay ");
        localStringBuilder.append(locala.e);
        TXCLog.i("VirtualDisplayManager", localStringBuilder.toString());
        if (locala.d != null) {
          locala.d.a(true, false);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.d.isEmpty()) {
      return;
    }
    if (paramBoolean)
    {
      this.c.postDelayed(new c.3(this), TimeUnit.SECONDS.toMillis(1L));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop media projection session ");
    ((StringBuilder)localObject).append(this.f);
    TXCLog.i("VirtualDisplayManager", ((StringBuilder)localObject).toString());
    localObject = this.f;
    if (localObject != null)
    {
      ((MediaProjection)localObject).unregisterCallback(this.i);
      this.f.stop();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((j)localObject).a();
      this.g = null;
    }
  }
  
  private boolean b(Context paramContext)
  {
    int k = h.g(paramContext);
    return (k == 0) || (k == 2);
  }
  
  public void a(MediaProjection paramMediaProjection)
  {
    this.e = false;
    if (paramMediaProjection == null)
    {
      paramMediaProjection = new HashMap(this.d);
      this.d.clear();
      paramMediaProjection = paramMediaProjection.values().iterator();
      while (paramMediaProjection.hasNext())
      {
        localObject = (c.a)paramMediaProjection.next();
        if (((c.a)localObject).d != null) {
          ((c.a)localObject).d.a(false, true);
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Got session ");
    ((StringBuilder)localObject).append(paramMediaProjection);
    TXCLog.i("VirtualDisplayManager", ((StringBuilder)localObject).toString());
    this.f = paramMediaProjection;
    this.f.registerCallback(this.i, this.c);
    a();
    this.g = new j(Looper.getMainLooper(), this.j);
    this.g.a(50, 50);
    a(true);
  }
  
  public void a(Surface paramSurface)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (paramSurface == null) {
        return;
      }
      paramSurface = (c.a)this.d.remove(paramSurface);
      if ((paramSurface != null) && (paramSurface.e != null))
      {
        paramSurface.e.release();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VirtualDisplay released, ");
        localStringBuilder.append(paramSurface.e);
        TXCLog.i("VirtualDisplayManager", localStringBuilder.toString());
      }
      a(true);
      return;
    }
    throw new IllegalStateException("Must call this at main thread!");
  }
  
  public void a(Surface paramSurface, int paramInt1, int paramInt2, c.b paramb)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (paramSurface == null)
      {
        TXCLog.e("VirtualDisplayManager", "surface is null!");
        paramb.a(false, false);
        return;
      }
      c.a locala = new c.a(null);
      locala.a = paramSurface;
      locala.b = paramInt1;
      locala.c = paramInt2;
      locala.d = paramb;
      locala.e = null;
      this.d.put(paramSurface, locala);
      if (this.f == null)
      {
        if (!this.e)
        {
          this.e = true;
          paramSurface = new Intent(this.b, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
          paramSurface.addFlags(268435456);
          this.b.startActivity(paramSurface);
        }
      }
      else {
        a();
      }
      return;
    }
    throw new IllegalStateException("Must call this method in main thread!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.c
 * JD-Core Version:    0.7.0.1
 */