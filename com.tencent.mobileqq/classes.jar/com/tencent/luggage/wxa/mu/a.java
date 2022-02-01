package com.tencent.luggage.wxa.mu;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.i;
import com.tencent.luggage.wxa.fy.m;
import com.tencent.luggage.wxa.fy.n;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends com.tencent.luggage.wxa.iz.a
{
  @NonNull
  private final d a;
  @NonNull
  private final String b;
  @NonNull
  private final c c;
  private volatile boolean d;
  @Nullable
  private volatile a.a e = null;
  private volatile boolean f = true;
  @Nullable
  private volatile i g = null;
  private final Object h = new Object();
  private final Map<i, Boolean> i = new ArrayMap();
  private final List<i> j = new ArrayList();
  private final List<i> k = new ArrayList();
  private final LinkedList<i> l = new LinkedList();
  private AtomicBoolean m = new AtomicBoolean(false);
  private AtomicBoolean n = new AtomicBoolean(false);
  
  public a(@NonNull d paramd)
  {
    this.a = paramd;
    this.b = paramd.aa();
    this.c = new c(this);
    this.d = (paramd.aQ() ^ true);
    com.tencent.luggage.wxa.iu.c.a(this.b, new a.1(this));
  }
  
  private void f(@NonNull i parami)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playAudio, videoPlayer:");
    ((StringBuilder)localObject).append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)localObject).toString());
    localObject = (m)parami.a(m.class);
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      return;
    }
    ((m)localObject).a();
    c(parami);
  }
  
  private void g()
  {
    this.d = false;
    if (this.m.getAndSet(false))
    {
      o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeForeground, ignore");
      return;
    }
    i locali = b();
    if (locali == null) {
      return;
    }
    if (!j(locali)) {
      g(locali);
    }
    this.f = false;
    this.c.b();
    this.g = null;
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeForeground, disableAppBrandBackgroundRun");
    f();
  }
  
  private void g(@NonNull i parami)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playVideo, videoPlayer:");
    ((StringBuilder)localObject).append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)localObject).toString());
    localObject = (m)parami.a(m.class);
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      return;
    }
    ((m)localObject).b();
    c(parami);
  }
  
  private void h()
  {
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.luggage.wxa.na.a locala = new com.tencent.luggage.wxa.na.a();
    locala.a.a = this.b;
    locala.a.b = 8;
    locala.a.c = 1;
    com.tencent.luggage.wxa.qy.a.a.a(locala);
  }
  
  private boolean h(@NonNull i parami)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPlay, videoPlayer:");
    localStringBuilder.append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", localStringBuilder.toString());
    parami = (n)parami.a(n.class);
    if (parami == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      return false;
    }
    parami.a();
    return true;
  }
  
  @Nullable
  private String i()
  {
    Object localObject = (com.tencent.luggage.wxa.nd.c)this.a.c(com.tencent.luggage.wxa.nd.c.class);
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      return null;
    }
    localObject = ((com.tencent.luggage.wxa.nd.c)localObject).a();
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    return localObject;
  }
  
  private boolean i(@NonNull i parami)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pausePlay, videoPlayer:");
    localStringBuilder.append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", localStringBuilder.toString());
    parami = (n)parami.a(n.class);
    if (parami == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      return false;
    }
    parami.b();
    return true;
  }
  
  private boolean j(@NonNull i parami)
  {
    synchronized (this.h)
    {
      parami = (Boolean)this.i.get(parami);
      return (parami != null) && (parami.booleanValue());
    }
  }
  
  public void a(c.d arg1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onRuntimeBackground, pauseType: ");
    ((StringBuilder)localObject1).append(???);
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)localObject1).toString());
    this.d = true;
    ??? = b();
    if (??? != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRuntimeBackground, backgroundAudioPlayer: ");
      ((StringBuilder)localObject1).append(???.a());
      o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)localObject1).toString());
      return;
    }
    synchronized (this.h)
    {
      if (!this.l.isEmpty())
      {
        localObject1 = (i)this.l.getFirst();
        if (localObject1 != null)
        {
          this.g = ((i)localObject1);
          ??? = i();
          if (!af.c(???))
          {
            o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
            e();
            f.a.a(new a.2(this, ???));
            return;
          }
          this.c.a();
          this.f = false;
          f((i)localObject1);
          o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
          h();
          return;
        }
      }
      o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
      return;
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (this.h)
      {
        if (!this.l.isEmpty())
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean a(@NonNull i parami)
  {
    ??? = com.tencent.luggage.wxa.iu.c.i(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("amIBackgroundAudioPlayer, videoPlayer: ");
    localStringBuilder.append(parami.a());
    localStringBuilder.append(", pauseType: ");
    localStringBuilder.append(???);
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", localStringBuilder.toString());
    for (;;)
    {
      synchronized (this.h)
      {
        if ((!this.l.isEmpty()) && (parami == this.l.getFirst()))
        {
          bool1 = true;
          boolean bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (this.n.getAndSet(false))
            {
              o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
              bool2 = false;
            }
          }
          parami = new StringBuilder();
          parami.append("amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ");
          parami.append(bool2);
          o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", parami.toString());
          return bool2;
        }
      }
      boolean bool1 = false;
    }
  }
  
  public boolean a(@NonNull i parami, boolean paramBoolean)
  {
    ??? = parami.a();
    int i1 = 0;
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { ???, Boolean.valueOf(paramBoolean) });
    if (this.d)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      return false;
    }
    synchronized (this.h)
    {
      this.i.put(parami, Boolean.valueOf(paramBoolean));
      if (this.k.contains(parami))
      {
        this.k.remove(parami);
        this.l.remove(parami);
        this.l.addFirst(parami);
        i1 = 1;
      }
      else
      {
        this.j.remove(parami);
        this.j.add(parami);
      }
      if ((i1 != 0) && (paramBoolean)) {
        f(parami);
      }
      return true;
    }
  }
  
  @Nullable
  public i b()
  {
    i locali2 = this.g;
    i locali1 = locali2;
    if (locali2 != null)
    {
      locali1 = locali2;
      if (this.n.get())
      {
        o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        locali1 = null;
      }
    }
    return locali1;
  }
  
  public void b(@NonNull i parami)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("disableBackgroundPlayAudio, videoPlayer:");
    ((StringBuilder)???).append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)???).toString());
    synchronized (this.h)
    {
      this.i.remove(parami);
      i locali = b();
      boolean bool = this.l.contains(parami);
      int i1 = 1;
      int i2 = 0;
      if ((!bool) && (locali != parami))
      {
        this.j.remove(parami);
        i1 = 0;
      }
      else
      {
        this.l.remove(parami);
        if (locali == parami)
        {
          i1 = 0;
          i2 = 1;
        }
      }
      if (i2 != 0)
      {
        e();
        f();
        this.c.b();
        this.g = null;
      }
      if (i1 != 0) {
        g(parami);
      }
      return;
    }
  }
  
  public void c()
  {
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = b();
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      return;
    }
    if (h((i)localObject))
    {
      this.f = false;
      this.c.a();
      localObject = this.e;
      if (localObject != null) {
        ((a.a)localObject).a();
      }
    }
  }
  
  public void c(@NonNull i parami)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("markVideoPlayStart, videoPlayer:");
    ((StringBuilder)???).append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)???).toString());
    synchronized (this.h)
    {
      int i1;
      if (this.j.contains(parami))
      {
        this.j.remove(parami);
        i1 = 1;
        this.l.remove(parami);
        this.l.addFirst(parami);
      }
      else
      {
        this.k.remove(parami);
        this.k.add(parami);
        i1 = 0;
      }
      if ((i1 != 0) && (j(parami))) {
        f(parami);
      }
      if ((this.d) && (b() != null)) {
        h();
      }
      return;
    }
  }
  
  public void d()
  {
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = b();
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      return;
    }
    if (i((i)localObject))
    {
      this.f = true;
      localObject = this.e;
      if (localObject != null) {
        ((a.a)localObject).b();
      }
    }
  }
  
  public void d(@NonNull i parami)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("markVideoPlayPauseOrStop, videoPlayer:");
    ((StringBuilder)???).append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)???).toString());
    synchronized (this.h)
    {
      if (this.l.contains(parami))
      {
        this.l.remove(parami);
        this.j.add(parami);
      }
      else
      {
        this.k.remove(parami);
      }
      if (b() == parami)
      {
        o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
        f();
        if (!this.f)
        {
          this.c.b();
          this.g = null;
        }
      }
      return;
    }
  }
  
  public void e()
  {
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    i locali = b();
    if (locali == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      return;
    }
    if (i(locali))
    {
      this.f = false;
      this.c.b();
    }
  }
  
  public void e(@NonNull i parami)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("markVideoPlayerRelease, videoPlayer:");
    ((StringBuilder)???).append(parami.a());
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", ((StringBuilder)???).toString());
    synchronized (this.h)
    {
      this.j.remove(parami);
      this.k.remove(parami);
      this.l.remove(parami);
      if (b() == parami)
      {
        o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        f();
        if (!this.f)
        {
          this.c.b();
          this.g = null;
        }
      }
      return;
    }
  }
  
  public void f()
  {
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.luggage.wxa.na.a locala = new com.tencent.luggage.wxa.na.a();
    locala.a.a = this.b;
    locala.a.b = 8;
    locala.a.c = 2;
    com.tencent.luggage.wxa.qy.a.a.a(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mu.a
 * JD-Core Version:    0.7.0.1
 */