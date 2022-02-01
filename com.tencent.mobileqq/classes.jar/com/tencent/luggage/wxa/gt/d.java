package com.tencent.luggage.wxa.gt;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.gn.f;
import com.tencent.luggage.wxa.gq.a;
import com.tencent.luggage.wxa.gq.p;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{
  private volatile HashMap<String, Integer> A = new HashMap();
  private volatile HashMap<String, Integer> B = new HashMap();
  private volatile HashMap<String, Integer> C = new HashMap();
  private a D;
  private byte[] E = new byte[3536];
  private byte[] F = new byte[2];
  private short G = 0;
  private Handler H;
  private volatile boolean I = false;
  private int J = 0;
  private Runnable K = new d.1(this);
  ArrayList<String> a = new ArrayList();
  private int b = 2;
  private int c = 44100;
  private int d = 4;
  private AudioTrack e;
  private AtomicBoolean f = new AtomicBoolean(false);
  private AtomicBoolean g = new AtomicBoolean(false);
  private AtomicBoolean h = new AtomicBoolean(true);
  private Queue<com.tencent.luggage.wxa.gm.b> i = new ArrayDeque();
  private Object j = new Object();
  private Object k = new Object();
  private Thread l;
  private com.tencent.luggage.wxa.gs.d m;
  private b n;
  private p o;
  private g p;
  private volatile HashMap<String, com.tencent.luggage.wxa.if.b> q = new HashMap();
  private volatile HashMap<String, Boolean> r = new HashMap();
  private volatile HashMap<String, Boolean> s = new HashMap();
  private volatile HashMap<String, e<Integer>> t = new HashMap();
  private volatile HashMap<String, com.tencent.luggage.wxa.if.d> u = new HashMap();
  private volatile HashMap<String, Boolean> v = new HashMap();
  private ArrayList<String> w = new ArrayList();
  private volatile HashMap<String, Long> x = new HashMap();
  private volatile HashMap<String, Integer> y = new HashMap();
  private volatile HashMap<String, Integer> z = new HashMap();
  
  public d(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  private void a(int paramInt)
  {
    com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "onError, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void a(boolean paramBoolean)
  {
    a();
    s();
    if (paramBoolean) {
      e();
    }
    this.H = new Handler(Looper.myLooper());
  }
  
  private void c(com.tencent.luggage.wxa.gm.b paramb)
  {
    if (this.n == null) {
      return;
    }
    if (!this.I) {
      return;
    }
    com.tencent.luggage.wxa.gm.c localc = com.tencent.luggage.wxa.gn.c.a().b();
    if (localc == null) {
      return;
    }
    if ((localc.d == null) || (localc.d.length < paramb.d.length)) {
      localc.d = new byte[paramb.d.length];
    }
    System.arraycopy(paramb.d, 0, localc.d, 0, paramb.d.length);
    this.H.post(new d.4(this, localc));
  }
  
  private void n()
  {
    try
    {
      if (this.l == null)
      {
        this.l = new Thread(this.K, "audio_mix_player");
        this.l.start();
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.l.getId()) });
      }
      return;
    }
    finally {}
  }
  
  private void o()
  {
    try
    {
      if (this.l != null)
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.l.getId()) });
        this.l = null;
      }
      return;
    }
    finally {}
  }
  
  private void p()
  {
    if (!q())
    {
      a(710);
      return;
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "create AudioTrack success");
    this.e.play();
  }
  
  private boolean q()
  {
    for (;;)
    {
      try
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "createAudioTrack");
        if (this.b == 1)
        {
          i1 = 4;
          int i2 = AudioTrack.getMinBufferSize(this.c, i1, 2);
          this.d = (i2 / 3536);
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "miniBufferSize:%d, channels:%d, sampleRate:%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(this.b), Integer.valueOf(this.c) });
          if (this.e == null)
          {
            com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "audioTrack is null, new AudioTrack");
            try
            {
              this.e = new ReportAudioTrack(3, this.c, i1, 2, i2, 1);
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localIllegalArgumentException, "AudioTrack create", new Object[0]);
            }
          }
          if (this.e != null)
          {
            i1 = this.e.getState();
            if (i1 == 1) {
              return true;
            }
          }
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "audio track not initialized");
          if (this.e != null)
          {
            com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "AudioTrack getState", new Object[] { Integer.valueOf(this.e.getState()) });
            try
            {
              this.e.release();
              this.e = null;
            }
            catch (Exception localException)
            {
              com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localException, "AudioTrack release", new Object[0]);
            }
          }
          return false;
        }
      }
      finally {}
      int i1 = 12;
    }
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 194	com/tencent/luggage/wxa/gt/d:e	Landroid/media/AudioTrack;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 194	com/tencent/luggage/wxa/gt/d:e	Landroid/media/AudioTrack;
    //   13: invokevirtual 323	android/media/AudioTrack:flush	()V
    //   16: aload_0
    //   17: getfield 194	com/tencent/luggage/wxa/gt/d:e	Landroid/media/AudioTrack;
    //   20: invokevirtual 326	android/media/AudioTrack:stop	()V
    //   23: aload_0
    //   24: getfield 194	com/tencent/luggage/wxa/gt/d:e	Landroid/media/AudioTrack;
    //   27: invokevirtual 318	android/media/AudioTrack:release	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 194	com/tencent/luggage/wxa/gt/d:e	Landroid/media/AudioTrack;
    //   35: goto +21 -> 56
    //   38: astore_1
    //   39: goto +20 -> 59
    //   42: astore_1
    //   43: ldc 155
    //   45: aload_1
    //   46: ldc_w 328
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 307	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	d
    //   38	1	1	localObject	Object
    //   42	20	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	35	38	finally
    //   43	56	38	finally
    //   2	35	42	java/lang/Exception
  }
  
  private void s()
  {
    if (this.o != null) {
      return;
    }
    this.o = new d.3(this);
  }
  
  public com.tencent.luggage.wxa.if.b a(String paramString)
  {
    if (this.q.containsKey(paramString)) {
      return (com.tencent.luggage.wxa.if.b)this.q.get(paramString);
    }
    return null;
  }
  
  public void a()
  {
    this.m = new com.tencent.luggage.wxa.gs.d(this);
    this.m.a();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    try
    {
      if (this.e != null)
      {
        this.e.setStereoVolume(paramFloat1, paramFloat2);
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localException, "setVolume", new Object[0]);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, this.m.k(paramString));
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.q.get(paramString1);
    if (localb == null) {
      return;
    }
    com.tencent.luggage.wxa.gz.c localc = new com.tencent.luggage.wxa.gz.c();
    localc.a.c = paramString1;
    localc.a.a = paramInt1;
    localc.a.e = localb.n;
    localc.a.f = paramInt2;
    localc.a.g = paramString2;
    localc.a.d = com.tencent.luggage.wxa.gz.c.a(paramInt1);
    paramString1 = this.o;
    if (paramString1 != null) {
      paramString1.a(localc);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.q.get(paramString1);
    if (localb == null) {
      return;
    }
    com.tencent.luggage.wxa.gz.c localc = new com.tencent.luggage.wxa.gz.c();
    localc.a.c = paramString1;
    localc.a.a = paramInt;
    localc.a.e = localb.n;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.b;
    }
    localc.a.h = paramString1;
    localc.a.d = com.tencent.luggage.wxa.gz.c.a(paramInt);
    paramString1 = this.o;
    if (paramString1 != null) {
      paramString1.a(localc);
    }
  }
  
  protected void a(com.tencent.luggage.wxa.gm.b arg1)
  {
    Iterator localIterator = ???.e.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i1 = 0;
      synchronized (this.k)
      {
        if ((!TextUtils.isEmpty(str)) && ((!this.v.containsKey(str)) || (!((Boolean)this.v.get(str)).booleanValue())))
        {
          if (this.v.containsKey(str))
          {
            this.v.put(str, Boolean.valueOf(true));
            i1 = 1;
          }
          if (i1 == 0) {
            continue;
          }
          this.H.post(new d.2(this, str));
        }
      }
    }
  }
  
  public void a(a parama)
  {
    this.D = parama;
  }
  
  public void a(b paramb)
  {
    this.n = paramb;
  }
  
  public void a(g paramg)
  {
    this.p = paramg;
  }
  
  public void a(com.tencent.luggage.wxa.if.b paramb)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
    if ((!paramb.B) && (paramb.g))
    {
      if (this.f.get()) {
        n();
      } else {
        e();
      }
    }
    else if (paramb.B) {
      synchronized (this.k)
      {
        if (this.t.containsKey(paramb.a))
        {
          e locale = (e)this.t.get(paramb.a);
          if (locale != null) {
            if (locale.a(new Integer[] { Integer.valueOf(4) })) {
              this.t.remove(paramb.a);
            }
          }
        }
      }
    }
    this.q.put(paramb.a, paramb);
    synchronized (this.k)
    {
      this.v.put(paramb.a, Boolean.valueOf(false));
      this.m.a(paramb.a);
      this.m.b();
      return;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.m.a(paramString, paramInt);
  }
  
  public com.tencent.luggage.wxa.gs.d b()
  {
    return this.m;
  }
  
  public void b(com.tencent.luggage.wxa.gm.b paramb)
  {
    if (this.h.get())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
      return;
    }
    synchronized (this.j)
    {
      while (this.i.size() >= 2)
      {
        boolean bool = this.h.get();
        if (bool) {
          break;
        }
        try
        {
          this.j.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "enqueueMixBuffer", new Object[0]);
        }
      }
      this.i.add(paramb);
      this.j.notifyAll();
      return;
    }
    for (;;)
    {
      throw paramb;
    }
  }
  
  public void b(com.tencent.luggage.wxa.if.b paramb)
  {
    this.q.put(paramb.a, paramb);
  }
  
  public boolean b(String paramString)
  {
    return this.q.containsKey(paramString);
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    this.m.c();
    f();
  }
  
  public void c(com.tencent.luggage.wxa.if.b paramb)
  {
    if (this.q.containsKey(paramb.a)) {
      this.q.put(paramb.a, paramb);
    }
  }
  
  public void c(String paramString)
  {
    this.h.set(false);
    this.g.set(false);
    h();
    n();
    synchronized (this.k)
    {
      this.v.put(paramString, Boolean.valueOf(false));
      this.m.a(paramString);
      this.r.remove(paramString);
      this.s.put(paramString, Boolean.valueOf(true));
      if ((this.D.f(paramString)) && (this.D.g(paramString))) {
        a(0, paramString);
      }
      return;
    }
  }
  
  public void d()
  {
    this.m.k();
    this.q.clear();
    this.r.clear();
    this.s.clear();
    synchronized (this.k)
    {
      this.t.clear();
      this.u.clear();
      this.v.clear();
      return;
    }
  }
  
  public void d(String paramString)
  {
    this.h.set(false);
    this.g.set(false);
    h();
    n();
    synchronized (this.k)
    {
      this.v.put(paramString, Boolean.valueOf(false));
      this.m.a(paramString);
      this.r.remove(paramString);
      this.s.put(paramString, Boolean.valueOf(true));
      if ((this.D.f(paramString)) && (this.D.g(paramString))) {
        a(1, paramString);
      }
      return;
    }
  }
  
  protected void e()
  {
    if (this.f.get()) {
      return;
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
    this.f.set(true);
    this.h.set(false);
    this.g.set(false);
    n();
  }
  
  public void e(String paramString)
  {
    this.m.b(paramString);
    if ((this.D.f(paramString)) && (this.D.g(paramString))) {
      a(2, paramString);
    }
  }
  
  protected void f()
  {
    this.f.set(false);
    this.h.set(true);
    this.g.set(false);
    h();
    o();
  }
  
  public void f(String paramString)
  {
    this.m.c(paramString);
    synchronized (this.k)
    {
      this.v.remove(paramString);
      this.r.remove(paramString);
      this.s.put(paramString, Boolean.valueOf(false));
      if (this.D.f(paramString)) {
        a(3, paramString);
      }
      return;
    }
  }
  
  public com.tencent.luggage.wxa.gm.b g()
  {
    synchronized (this.j)
    {
      while ((this.i.size() == 0) || (this.g.get()))
      {
        boolean bool = this.h.get();
        if (bool) {
          break;
        }
        try
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
          a(0.0F, 0.0F);
          if ((this.e != null) && (this.e.getPlayState() == 3)) {
            this.e.stop();
          }
          this.j.wait();
          this.J = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
        }
      }
      com.tencent.luggage.wxa.gm.b localb = (com.tencent.luggage.wxa.gm.b)this.i.poll();
      this.j.notifyAll();
      return localb;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void g(String paramString)
  {
    this.q.remove(paramString);
    this.r.remove(paramString);
    this.s.remove(paramString);
    synchronized (this.k)
    {
      this.t.remove(paramString);
      this.v.remove(paramString);
      this.u.remove(paramString);
      return;
    }
  }
  
  public void h()
  {
    synchronized (this.j)
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.j.notifyAll();
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localException, "syncNotify", new Object[0]);
      }
      return;
    }
  }
  
  public boolean h(String paramString)
  {
    if (this.t.containsKey(paramString))
    {
      e locale = (e)this.t.get(paramString);
      if (locale != null) {
        if ((locale.a(new Integer[] { Integer.valueOf(0) })) && (!this.m.h())) {
          return true;
        }
      }
      if ((!this.m.h()) && (!this.m.f(paramString)) && (this.D.g(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public void i()
  {
    synchronized (this.j)
    {
      while ((this.g.get()) && (!this.h.get()))
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
        try
        {
          this.j.wait();
        }
        catch (Exception localException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean i(String paramString)
  {
    if (this.s.containsKey(paramString)) {
      return ((Boolean)this.s.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public g j()
  {
    return this.p;
  }
  
  public boolean j(String paramString)
  {
    if (this.t.containsKey(paramString))
    {
      paramString = (e)this.t.get(paramString);
      if (paramString != null) {
        if (paramString.a(new Integer[] { Integer.valueOf(9) })) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int k()
  {
    int i1;
    label153:
    synchronized (this.k)
    {
      Object localObject2 = this.t.keySet();
      Object localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll((Collection)localObject2);
      localObject2 = ((ArrayList)localObject4).iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject4 = (e)this.t.get(localObject4);
        if (localObject4 != null)
        {
          if (((e)localObject4).a(new Integer[] { Integer.valueOf(0) })) {
            break label153;
          }
          if (((e)localObject4).a(new Integer[] { Integer.valueOf(1) })) {
            break label153;
          }
          if (((e)localObject4).a(new Integer[] { Integer.valueOf(2) })) {
            break label153;
          }
        }
      }
      return i1;
    }
  }
  
  public boolean k(String paramString)
  {
    if (this.t.containsKey(paramString))
    {
      paramString = (e)this.t.get(paramString);
      if (paramString != null) {
        if (paramString.a(new Integer[] { Integer.valueOf(7) })) {
          return true;
        }
      }
    }
    return false;
  }
  
  public ArrayList<String> l()
  {
    this.w.clear();
    this.a.clear();
    synchronized (this.k)
    {
      Object localObject2 = this.t.keySet();
      this.a.addAll((Collection)localObject2);
      localObject2 = this.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.t.get(str);
        if (locale != null) {
          if (locale.a(new Integer[] { Integer.valueOf(2) })) {
            this.w.add(str);
          }
        }
      }
      return this.w;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public boolean l(String paramString)
  {
    if (this.t.containsKey(paramString))
    {
      paramString = (e)this.t.get(paramString);
      if (paramString != null) {
        if (paramString.a(new Integer[] { Integer.valueOf(2) })) {
          return true;
        }
      }
    }
    return false;
  }
  
  public long m()
  {
    return this.m.l();
  }
  
  public boolean m(String paramString)
  {
    if (this.t.containsKey(paramString))
    {
      paramString = (e)this.t.get(paramString);
      if (paramString != null)
      {
        if (!paramString.a(new Integer[] { Integer.valueOf(3) })) {
          if (!paramString.a(new Integer[] { Integer.valueOf(4) })) {
            if (!paramString.a(new Integer[] { Integer.valueOf(5) })) {
              break label83;
            }
          }
        }
        return true;
      }
    }
    label83:
    return false;
  }
  
  public boolean n(String paramString)
  {
    return this.h.get();
  }
  
  public boolean o(String paramString)
  {
    return (this.r.containsKey(paramString)) && (((Boolean)this.r.get(paramString)).booleanValue());
  }
  
  public int p(String paramString)
  {
    boolean bool = this.q.containsKey(paramString);
    int i1 = 0;
    if (bool)
    {
      com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.q.get(paramString);
      if (localb == null) {
        return 0;
      }
      long l1;
      if (localb.z) {
        l1 = this.m.h(paramString);
      } else {
        l1 = this.D.h(paramString);
      }
      i1 = (int)l1;
      if (i1 != -1) {
        localb.f = i1;
      } else {
        i1 = localb.f;
      }
      if (i1 == -1) {
        return 0;
      }
      int i2 = q(paramString);
      if ((i2 > 0) && (i1 > i2)) {
        return i2;
      }
    }
    return i1;
  }
  
  public int q(String paramString)
  {
    if (this.q.containsKey(paramString))
    {
      paramString = (com.tencent.luggage.wxa.if.b)this.q.get(paramString);
      if (paramString == null) {
        return 0;
      }
      paramString = paramString.c;
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramString = f.c().a(paramString);
      if (paramString != null) {
        return (int)paramString.d();
      }
    }
    return 0;
  }
  
  public int r(String paramString)
  {
    if (this.q.containsKey(paramString))
    {
      paramString = ((com.tencent.luggage.wxa.if.b)this.q.get(paramString)).c;
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramString = f.c().a(paramString);
      if ((paramString != null) && (paramString.d() > 0L)) {
        return 100;
      }
    }
    return 0;
  }
  
  public com.tencent.luggage.wxa.if.d s(String paramString)
  {
    com.tencent.luggage.wxa.if.d locald;
    if (this.u.containsKey(paramString))
    {
      locald = (com.tencent.luggage.wxa.if.d)this.u.get(paramString);
    }
    else
    {
      locald = new com.tencent.luggage.wxa.if.d();
      this.u.put(paramString, locald);
    }
    int i3 = q(paramString);
    int i4 = p(paramString);
    boolean bool = h(paramString);
    int i2 = r(paramString);
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    locald.b = i4;
    locald.a = i3;
    locald.c = (bool ^ true);
    locald.d = o(paramString);
    locald.e = (i1 * i3 / 100);
    if (this.q.containsKey(paramString))
    {
      paramString = (com.tencent.luggage.wxa.if.b)this.q.get(paramString);
      locald.g = paramString.e;
      locald.f = paramString.b;
      locald.h = paramString.v;
      return locald;
    }
    return null;
  }
  
  public int t(String paramString)
  {
    if (!this.t.containsKey(paramString)) {
      return -1;
    }
    paramString = (e)this.t.get(paramString);
    if (paramString != null) {
      return ((Integer)paramString.a()).intValue();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gt.d
 * JD-Core Version:    0.7.0.1
 */