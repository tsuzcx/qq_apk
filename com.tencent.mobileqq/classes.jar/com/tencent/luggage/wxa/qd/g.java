package com.tencent.luggage.wxa.qd;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.gr.f.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class g
{
  private static g K;
  private HashMap<String, String> A = new HashMap();
  private HashMap<String, Integer> B = new HashMap();
  private com.tencent.luggage.wxa.gt.c C;
  private volatile boolean D = true;
  private AudioManager E = (AudioManager)r.a().getSystemService("audio");
  private long F = 0L;
  private LinkedList<String> G = new LinkedList();
  private LinkedList<String> H = new LinkedList();
  private com.tencent.luggage.wxa.gr.a I;
  private Handler J;
  private e L = new g.2(this);
  private Runnable M = new g.3(this);
  private Runnable N = new g.4(this);
  private com.tencent.luggage.wxa.gt.b O = new g.6(this);
  private com.tencent.luggage.wxa.gt.g P = new g.7(this);
  private f.a Q = new g.8(this);
  volatile boolean a = true;
  volatile int b = 0;
  private LinkedList<String> c = new LinkedList();
  private HashMap<String, j> d = new HashMap();
  private LinkedList<String> e = new LinkedList();
  private HashMap<String, j> f = new HashMap();
  private LinkedList<String> g = new LinkedList();
  private LinkedList<String> h = new LinkedList();
  private HashMap<String, String> i = new HashMap();
  private HashMap<String, LinkedList<String>> j = new HashMap();
  private HashMap<String, com.tencent.luggage.wxa.if.b> k = new HashMap();
  private HashMap<String, com.tencent.luggage.wxa.if.d> l = new HashMap();
  private LinkedList<String> m = new LinkedList();
  private HashMap<String, Integer> n = new HashMap();
  private LinkedList<String> o = new LinkedList();
  private Object p = new Object();
  private boolean q = false;
  private boolean r = false;
  private long s = 0L;
  private long t = 0L;
  private com.tencent.luggage.wxa.qe.a u;
  private com.tencent.luggage.wxa.if.a v = new com.tencent.luggage.wxa.if.a();
  private com.tencent.luggage.wxa.qf.a w = new com.tencent.luggage.wxa.qf.a();
  private y x;
  private volatile boolean y = false;
  private ArrayList<i> z = new ArrayList();
  
  private g()
  {
    b();
    this.C = new com.tencent.luggage.wxa.gt.c(false);
    this.C.a(this.O);
    this.C.a(this.P);
    this.I = new b();
    this.I.a(this.Q);
  }
  
  private void A(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.v.c)) && (!paramString.equalsIgnoreCase(this.v.c)))
    {
      this.v.a();
      o.d("MicroMsg.Audio.AudioPlayerMgr", "reset AudioContextParam, appId:%s", new Object[] { paramString });
    }
    com.tencent.luggage.wxa.if.a locala = this.v;
    locala.c = paramString;
    this.a = locala.b;
  }
  
  private void B(String paramString)
  {
    if (this.G.remove(paramString)) {
      this.k.remove(paramString);
    }
  }
  
  public static g a()
  {
    if (K == null) {
      K = new g();
    }
    return K;
  }
  
  private void a(com.tencent.luggage.wxa.if.b paramb1, com.tencent.luggage.wxa.if.b paramb2)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
    u(paramb1.a);
    e(paramb1);
    if ((TextUtils.isEmpty(paramb1.c)) && (paramb2 != null) && (paramb2.a(paramb1))) {
      paramb1.c = paramb2.c;
    }
    if (paramb1.g)
    {
      if ((paramb2 != null) && (!paramb2.a(paramb1)))
      {
        a(paramb1, true, false);
        o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
        if ((this.C.h(paramb1.a)) || (this.C.i(paramb1.a)) || (this.C.j(paramb1.a)) || (this.C.k(paramb1.a)) || (this.C.l(paramb1.a))) {
          this.C.f(paramb1.a);
        }
        this.C.a(paramb1);
        return;
      }
      if (this.C.h(paramb1.a))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
        return;
      }
      if ((this.C.i(paramb1.a)) && (this.C.l(paramb1.a)))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb1, true, false);
        this.C.d(paramb1.a);
        return;
      }
      if (this.C.k(paramb1.a))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb1, true, false);
        this.C.d(paramb1.a);
        return;
      }
      if (this.C.j(paramb1.a))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
        return;
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
      a(paramb1, true, false);
      this.C.a(paramb1);
      return;
    }
    if (this.C.b(paramb1.a)) {
      this.C.c(paramb1);
    } else {
      this.C.b(paramb1);
    }
    if ((paramb2 != null) && (!paramb2.a(paramb1)))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
      if ((this.C.h(paramb1.a)) || (this.C.i(paramb1.a)) || (this.C.j(paramb1.a)) || (this.C.k(paramb1.a)) || (this.C.l(paramb1.a))) {
        this.C.f(paramb1.a);
      }
    }
    this.C.a(7, paramb1.a);
  }
  
  private void a(com.tencent.luggage.wxa.if.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.u = ((com.tencent.luggage.wxa.qe.a)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qe.a.class));
    com.tencent.luggage.wxa.qe.a locala = this.u;
    if (locala != null) {
      locala.a(paramb.a, paramb.b, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.o = l2;
    long l1;
    if (paramBoolean1)
    {
      l1 = paramb.s;
      paramb.p = paramb.r;
    }
    else
    {
      l1 = paramb.u;
      paramb.p = paramb.t;
    }
    if ((l1 > 0L) && (l2 > l1))
    {
      paramb.q = (l2 - l1);
      return;
    }
    paramb.q = 0L;
  }
  
  private void a(String paramString, j paramj)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if ((localb != null) && (paramj.t()) && (paramj.B()))
    {
      localb.g = true;
      localb.d = paramj.H();
    }
    else if ((localb != null) && (paramj.B()))
    {
      localb.g = true;
      localb.d = paramj.H();
    }
    else if (localb != null)
    {
      localb.g = true;
      localb.d = 0;
    }
    b(paramString, paramj);
    paramString = j(paramString);
    if ((paramString != null) && (paramj.t())) {
      paramString.c = true;
    }
    if ((!paramj.t()) && (!paramj.B()) && (!paramj.u()) && (!paramj.v()) && (!paramj.w()))
    {
      paramj.D();
      return;
    }
    paramj.E();
  }
  
  private boolean a(j paramj)
  {
    if (paramj == null) {
      return true;
    }
    int i1;
    if ((!paramj.t()) && (!paramj.w()) && (!paramj.u()) && (!paramj.v()) && (!paramj.B())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    return i1 ^ 0x1;
  }
  
  private void b(com.tencent.luggage.wxa.if.b paramb1, com.tencent.luggage.wxa.if.b paramb2)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
    j localj = s(paramb1.a);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb1.a });
      paramb2 = i();
      paramb2.a(this.L);
      paramb2.a(paramb1.a);
      paramb2.a(paramb1);
      if (paramb1.g)
      {
        a(paramb1, true, true);
        e(paramb1.a, paramb2);
        paramb1.j = System.currentTimeMillis();
        paramb2.b(paramb1);
        return;
      }
      f(paramb1.a, paramb2);
      paramb2.h();
      o.b("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      return;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb1.a });
    if (paramb1.g)
    {
      e(paramb1.a, localj);
      paramb1.j = System.currentTimeMillis();
      localj.a(paramb1);
      if ((paramb2 != null) && (!paramb2.a(paramb1)))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localj.t()) || (localj.B()) || (localj.u()) || (localj.v()) || (localj.w())) {
          localj.G();
        }
        a(paramb1, true, true);
        localj.b(paramb1);
        return;
      }
      if (localj.t())
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
        return;
      }
      if ((localj.B()) && (localj.w()))
      {
        a(paramb1, true, true);
        o.d("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localj.s();
        return;
      }
      if (localj.v())
      {
        a(paramb1, true, true);
        o.d("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localj.s();
        return;
      }
      if (localj.u())
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
        return;
      }
      a(paramb1, true, true);
      o.d("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
      localj.b(paramb1);
      return;
    }
    synchronized (this.p)
    {
      boolean bool = this.e.contains(paramb1.a);
      if (!bool)
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
        f(paramb1.a, localj);
      }
      else
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
      }
      localj.a(paramb1);
      if ((paramb2 != null) && (!paramb2.a(paramb1)))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
        if ((localj.t()) || (localj.B()) || (localj.u()) || (localj.v()) || (localj.w())) {
          localj.G();
        }
      }
      localj.h();
      o.b("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
      return;
    }
  }
  
  private void b(String paramString, com.tencent.luggage.wxa.if.b paramb)
  {
    if (paramb == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
      return;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
    this.i.put(paramb.n, paramb.k);
    this.k.put(paramb.a, paramb);
    b(paramb.n, paramString);
    this.n.remove(paramString);
  }
  
  private void b(String paramString, j paramj)
  {
    this.l.put(paramString, paramj.K());
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      if (!this.h.contains(paramString1)) {
        this.h.add(paramString1);
      }
      if (!this.c.contains(paramString2)) {
        this.c.add(paramString2);
      }
      LinkedList localLinkedList2 = (LinkedList)this.j.get(paramString1);
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null) {
        localLinkedList1 = new LinkedList();
      }
      if (!localLinkedList1.contains(paramString2)) {
        localLinkedList1.add(paramString2);
      }
      this.j.put(paramString1, localLinkedList1);
    }
  }
  
  private boolean b(String paramString, int paramInt)
  {
    paramString = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if (paramString != null)
    {
      paramString.d = paramInt;
      return true;
    }
    return false;
  }
  
  private void c(com.tencent.luggage.wxa.if.b paramb)
  {
    if (this.C.b(paramb.a)) {
      this.C.c(paramb);
    } else {
      this.C.b(paramb);
    }
    if ((h(paramb)) || (!TextUtils.isEmpty(paramb.c))) {
      r(paramb.a);
    }
  }
  
  private void c(String paramString, j paramj)
  {
    if (paramj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      return;
    }
    if ((paramj.t()) || (paramj.B()) || (paramj.u()) || (paramj.v()) || (paramj.w())) {
      paramj.G();
    }
    paramj.L();
    o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
  }
  
  private boolean c(String paramString, int paramInt)
  {
    int i1;
    if (this.n.containsKey(paramString)) {
      i1 = ((Integer)this.n.get(paramString)).intValue();
    } else {
      i1 = 0;
    }
    if (i1 >= 1)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
      this.n.remove(paramString);
      return false;
    }
    if (66 != paramInt)
    {
      this.n.remove(paramString);
      return false;
    }
    if (y(paramString))
    {
      this.n.put(paramString, Integer.valueOf(i1 + 1));
      return true;
    }
    return false;
  }
  
  private void d(com.tencent.luggage.wxa.if.b paramb)
  {
    this.u = ((com.tencent.luggage.wxa.qe.a)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qe.a.class));
    com.tencent.luggage.wxa.qe.a locala = this.u;
    if (locala != null) {
      locala.a(paramb.a, paramb.b);
    }
  }
  
  private void d(String paramString, j paramj)
  {
    o.e("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramj);
  }
  
  private void e(com.tencent.luggage.wxa.if.b paramb)
  {
    if (paramb.y != null) {
      try
      {
        paramb.y.close();
        paramb.y = null;
        return;
      }
      catch (Exception paramb)
      {
        o.a("MicroMsg.Audio.AudioPlayerMgr", paramb, "closeAudioDataSource", new Object[0]);
      }
    }
  }
  
  private void e(String paramString, j paramj)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.p)
    {
      if (this.g.contains(paramString))
      {
        this.f.remove(paramString);
        this.g.remove(paramString);
      }
      if (!this.e.contains(paramString))
      {
        this.e.add(paramString);
        this.d.put(paramString, paramj);
      }
      return;
    }
  }
  
  private void f(com.tencent.luggage.wxa.if.b paramb)
  {
    if (paramb == null) {
      return;
    }
    if (TextUtils.isEmpty(paramb.b)) {
      return;
    }
    if (!paramb.b.startsWith("http")) {
      return;
    }
    int i1;
    if ((!TextUtils.isEmpty(paramb.c)) && (this.C.t(paramb.c))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return;
    }
    if (this.J == null) {
      this.J = new Handler(Looper.myLooper());
    }
    com.tencent.luggage.wxa.qg.g.a(paramb.b);
    boolean bool = com.tencent.luggage.wxa.qg.i.b(paramb.b);
    o.d("MicroMsg.Audio.AudioPlayerMgr", "checkNeedDownloadSrc audioId:%s, cacheValid:%b, checkCount:%d", new Object[] { paramb.a, Boolean.valueOf(bool), Integer.valueOf(this.b) });
    this.b += 1;
    if (!bool)
    {
      this.I.a(paramb);
      return;
    }
    z(paramb.a);
    g(paramb);
    r(paramb.a);
  }
  
  private void f(String paramString, j paramj)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.p)
    {
      if (this.e.contains(paramString))
      {
        this.d.remove(paramString);
        this.e.remove(paramString);
      }
      if (!this.g.contains(paramString))
      {
        this.g.add(paramString);
        this.f.put(paramString, paramj);
      }
      return;
    }
  }
  
  private void g(com.tencent.luggage.wxa.if.b paramb)
  {
    if ((TextUtils.isEmpty(paramb.c)) && (this.A.containsKey(paramb.b))) {
      paramb.c = ((String)this.A.get(paramb.b));
    }
  }
  
  private void g(String paramString, j arg2)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { paramString });
    synchronized (this.p)
    {
      if (this.g.contains(paramString))
      {
        this.f.remove(paramString);
        this.g.remove(paramString);
      }
      if (this.e.contains(paramString))
      {
        this.e.remove(paramString);
        this.d.remove(paramString);
      }
      return;
    }
  }
  
  private boolean h(com.tencent.luggage.wxa.if.b paramb)
  {
    return (paramb != null) && (paramb.b.startsWith("wxblob://")) && (paramb.C != null);
  }
  
  private j i()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    synchronized (this.p)
    {
      if (this.f.size() == 0)
      {
        localObject1 = new j();
        return localObject1;
      }
      Object localObject1 = null;
      Object localObject3 = "";
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.g.iterator();
      long l1 = 0L;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        j localj = (j)this.f.get(str);
        if ((localj != null) && ((localj.C()) || (localj.y()) || (localj.z()) || (localj.A())) && ((l1 == 0L) || (localj.O() < l1)))
        {
          l1 = localj.O();
          localObject3 = str;
          localObject1 = localj;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        g((String)localObject3, (j)localObject1);
        return localObject1;
      }
      return new j();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void j()
  {
    if (k() > 0)
    {
      long l1 = System.currentTimeMillis();
      if ((this.r) && (l1 - this.t < 10000L)) {
        return;
      }
      synchronized (this.p)
      {
        this.r = true;
        this.t = l1;
        a(600000);
        return;
      }
    }
    synchronized (this.p)
    {
      this.r = false;
      t.b(this.M);
      return;
    }
  }
  
  private int k()
  {
    synchronized (this.p)
    {
      Iterator localIterator = this.g.iterator();
      int i1 = 0;
      while (localIterator.hasNext()) {
        if (i((String)localIterator.next())) {
          i1 += 1;
        }
      }
      return i1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void l()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.p)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.g);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        j localj = (j)this.f.get(str);
        if ((localj != null) && (localj.w())) {
          a(str, localj);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void m()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    synchronized (this.p)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.g);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        j localj = (j)this.f.remove(str);
        this.g.remove(str);
        if (localj != null) {
          if (localj.C())
          {
            b(str, localj);
            d(str, localj);
          }
          else if (!localj.w())
          {
            b(str, localj);
            c(str, localj);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void n()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.m.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      o.d("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      b(str);
      t();
    }
    localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      o.d("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      b(str);
      t();
    }
    this.m.clear();
    this.o.clear();
  }
  
  private int o()
  {
    return com.tencent.luggage.wxa.qg.g.a(3);
  }
  
  private void p()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.v.a), Boolean.valueOf(r()) });
    if ((!this.v.a) && (!r()))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      q();
      return;
    }
    if ((this.v.a) && (r()))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      s();
    }
  }
  
  private void q()
  {
    if (r()) {
      return;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.w.a()) });
  }
  
  private boolean r()
  {
    return this.w.c();
  }
  
  private j s(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return (j)this.d.get(paramString);
    }
    if (this.f.containsKey(paramString)) {
      return (j)this.f.get(paramString);
    }
    return null;
  }
  
  private void s()
  {
    if (r()) {
      this.w.b();
    }
  }
  
  private String t(String paramString)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.j.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString))) {
        return str;
      }
    }
    return "";
  }
  
  private void t()
  {
    this.u = ((com.tencent.luggage.wxa.qe.a)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qe.a.class));
    com.tencent.luggage.wxa.qe.a locala = this.u;
    if (locala != null) {
      locala.a();
    }
  }
  
  private boolean u()
  {
    return (d.a()) && (v());
  }
  
  private boolean u(String paramString)
  {
    ??? = s(paramString);
    if (??? == null) {
      return false;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (j)???);
    synchronized (this.p)
    {
      this.d.remove(paramString);
      this.e.remove(paramString);
      this.f.remove(paramString);
      this.g.remove(paramString);
      return true;
    }
  }
  
  private void v(String paramString)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i1 = this.d.size();
    int i2 = this.f.size();
    int i3 = k();
    if ((i1 > 0) || (i2 > 0) || (i3 > 0)) {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
    }
    if (i1 >= 10) {
      l();
    } else if (i3 >= 6) {
      l();
    } else if (i1 + i3 >= 8) {
      l();
    }
    paramString = t(paramString);
    i1 = this.d.size();
    i2 = this.f.size();
    if ((i1 > 0) || (i2 > 0)) {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
    }
    Iterator localIterator;
    String str;
    if (i2 >= 50)
    {
      localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          w(str);
        }
      }
    }
    if (i2 + i1 >= 50)
    {
      localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          w(str);
        }
      }
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "condition is not satisfy to do recycleStopPlayerByAppId");
    i2 = this.f.size();
    if ((i1 > 0) || (i2 > 0)) {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
    }
    if (i2 >= 50)
    {
      m();
      return;
    }
    if (i1 + i2 >= 50)
    {
      m();
      return;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "condition is not satisfy to do recycleAllStopPlayer");
  }
  
  private boolean v()
  {
    return (this.v.b) || (this.v.a);
  }
  
  private void w(String paramString)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    p(paramString);
  }
  
  private boolean x(String paramString)
  {
    Object localObject2 = new ArrayList();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    synchronized (this.p)
    {
      int i5 = this.d.size();
      if (i5 < 10)
      {
        this.m.clear();
        o.d("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(i5) });
        return false;
      }
      Object localObject3 = this.e.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.luggage.wxa.if.b)this.k.get(localObject4);
        if ((localObject4 != null) && (((com.tencent.luggage.wxa.if.b)localObject4).b != null))
        {
          ArrayList localArrayList;
          if (!localHashMap2.containsKey(((com.tencent.luggage.wxa.if.b)localObject4).b))
          {
            localHashMap2.put(((com.tencent.luggage.wxa.if.b)localObject4).b, Integer.valueOf(1));
            localArrayList = new ArrayList();
            localArrayList.add(((com.tencent.luggage.wxa.if.b)localObject4).a);
            localHashMap1.put(((com.tencent.luggage.wxa.if.b)localObject4).b, localArrayList);
          }
          else
          {
            i1 = ((Integer)localHashMap2.get(((com.tencent.luggage.wxa.if.b)localObject4).b)).intValue();
            localHashMap2.put(((com.tencent.luggage.wxa.if.b)localObject4).b, Integer.valueOf(i1 + 1));
            localArrayList = (ArrayList)localHashMap1.get(((com.tencent.luggage.wxa.if.b)localObject4).b);
            if (!localArrayList.contains(((com.tencent.luggage.wxa.if.b)localObject4).a)) {
              localArrayList.add(((com.tencent.luggage.wxa.if.b)localObject4).a);
            }
            localHashMap1.put(((com.tencent.luggage.wxa.if.b)localObject4).b, localArrayList);
          }
          if (!((ArrayList)localObject2).contains(((com.tencent.luggage.wxa.if.b)localObject4).b)) {
            ((ArrayList)localObject2).add(((com.tencent.luggage.wxa.if.b)localObject4).b);
          }
        }
      }
      int i3 = o();
      o.e("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(i3) });
      Object localObject4 = ((ArrayList)localObject2).iterator();
      int i1 = i3;
      ??? = "";
      boolean bool1 = false;
      int i2;
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (String)((Iterator)localObject4).next();
        int i4 = ((Integer)localHashMap2.get(localObject3)).intValue();
        o.e("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(i4), localObject3 });
        i2 = i1;
        localObject2 = ???;
        if (i4 >= i3)
        {
          i2 = i1;
          if (i1 < i4)
          {
            ??? = localObject3;
            i2 = i4;
          }
          localObject2 = ???;
          if (TextUtils.isEmpty((CharSequence)???)) {
            localObject2 = localObject3;
          }
          bool1 = true;
        }
        i1 = i2;
        ??? = localObject2;
      }
      boolean bool2 = bool1;
      if (bool1)
      {
        paramString = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
        bool2 = bool1;
        if (paramString != null)
        {
          bool2 = bool1;
          if (??? != null)
          {
            bool2 = bool1;
            if (((String)???).equalsIgnoreCase(paramString.b))
            {
              o.d("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
              bool2 = false;
            }
          }
        }
      }
      if (bool2)
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        ??? = (ArrayList)localHashMap1.get(???);
        if ((??? != null) && (((ArrayList)???).size() > 0))
        {
          paramString = new LinkedList();
          ??? = ((ArrayList)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (String)((Iterator)???).next();
            localObject2 = (com.tencent.luggage.wxa.if.b)this.k.get(localObject2);
            if (localObject2 != null) {
              paramString.add(localObject2);
            }
          }
          Collections.sort(paramString, new g.a(this));
          ??? = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)???).add(((com.tencent.luggage.wxa.if.b)paramString.next()).a);
          }
          i1 = i5 - 10;
          if ((i1 > 0) && (((LinkedList)???).size() > i1))
          {
            i1 += 1;
            o.d("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i1) });
            i2 = ((LinkedList)???).size() - i1;
            i1 = i2;
            if (i2 < 0) {
              i1 = 1;
            }
            this.m.addAll(((LinkedList)???).subList(i1, ((LinkedList)???).size()));
          }
          else if ((i1 > 0) && (((LinkedList)???).size() < i1))
          {
            this.m.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
          }
          else
          {
            this.m.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          }
          o.d("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.m.size()) });
          return bool2;
        }
      }
      else
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
        this.m.clear();
      }
      return bool2;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private boolean y(String paramString)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    synchronized (this.p)
    {
      int i1 = this.d.size();
      if (i1 <= 5)
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i1) });
        return false;
      }
      Object localObject3 = this.e.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.luggage.wxa.if.b)this.k.get(localObject4);
        if ((localObject4 != null) && (((com.tencent.luggage.wxa.if.b)localObject4).b != null))
        {
          ArrayList localArrayList;
          if (!localHashMap1.containsKey(((com.tencent.luggage.wxa.if.b)localObject4).b))
          {
            localHashMap1.put(((com.tencent.luggage.wxa.if.b)localObject4).b, Integer.valueOf(1));
            localArrayList = new ArrayList();
            localArrayList.add(((com.tencent.luggage.wxa.if.b)localObject4).a);
            localHashMap2.put(((com.tencent.luggage.wxa.if.b)localObject4).b, localArrayList);
          }
          else
          {
            i1 = ((Integer)localHashMap1.get(((com.tencent.luggage.wxa.if.b)localObject4).b)).intValue();
            localHashMap1.put(((com.tencent.luggage.wxa.if.b)localObject4).b, Integer.valueOf(i1 + 1));
            localArrayList = (ArrayList)localHashMap2.get(((com.tencent.luggage.wxa.if.b)localObject4).b);
            if (!localArrayList.contains(((com.tencent.luggage.wxa.if.b)localObject4).a)) {
              localArrayList.add(((com.tencent.luggage.wxa.if.b)localObject4).a);
            }
            localHashMap2.put(((com.tencent.luggage.wxa.if.b)localObject4).b, localArrayList);
          }
          if (!((ArrayList)localObject1).contains(((com.tencent.luggage.wxa.if.b)localObject4).b)) {
            ((ArrayList)localObject1).add(((com.tencent.luggage.wxa.if.b)localObject4).b);
          }
        }
      }
      paramString = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
      ??? = ((ArrayList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.b)))
        {
          o.d("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
          return false;
        }
      }
      o.e("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
      localObject3 = ((ArrayList)localObject1).iterator();
      paramString = "";
      boolean bool = false;
      i1 = 2;
      while (((Iterator)localObject3).hasNext())
      {
        ??? = (String)((Iterator)localObject3).next();
        int i3 = ((Integer)localHashMap1.get(???)).intValue();
        o.e("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(i3), ??? });
        if (i3 >= 2)
        {
          int i2 = i1;
          if (i1 < i3)
          {
            paramString = (String)???;
            i2 = i3;
          }
          localObject1 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            localObject1 = ???;
          }
          bool = true;
          paramString = (String)localObject1;
          i1 = i2;
        }
      }
      if (bool)
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramString = new LinkedList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (String)((Iterator)localObject1).next();
            ??? = (com.tencent.luggage.wxa.if.b)this.k.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new g.a(this));
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.luggage.wxa.if.b)paramString.next()).a);
          }
          this.o.add(((LinkedList)localObject1).getLast());
          o.d("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.o.size()) });
          return bool;
        }
      }
      else
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      }
      return bool;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void z(String paramString)
  {
    paramString = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString.b)) {
        return;
      }
      if ((!paramString.b.startsWith("http://")) && (!paramString.b.startsWith("https://"))) {
        return;
      }
      if (!com.tencent.luggage.wxa.qg.i.b(paramString.b)) {
        return;
      }
      paramString.c = com.tencent.luggage.wxa.qq.b.b(paramString.b);
      if (!this.A.containsKey(paramString.b)) {
        this.A.put(paramString.b, paramString.c);
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.j.get(paramString1);
    Object localObject = this.p;
    if (localLinkedList != null) {}
    for (;;)
    {
      try
      {
        if (!localLinkedList.contains(paramString2)) {
          break label208;
        }
        if (this.e.contains(paramString2)) {
          continue;
        }
        if (!this.g.contains(paramString2)) {
          break label208;
        }
      }
      finally
      {
        int i2;
        continue;
      }
      i2 = k(paramString1);
      if (TextUtils.isEmpty(paramString2))
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
        a(604, paramString2);
        return null;
      }
      if (i2 >= 10)
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(i2) });
        b(paramString1, paramString2);
        return null;
      }
      if (i1 != 0)
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        a(603, paramString2);
        return null;
      }
      b(paramString1, paramString2);
      v(paramString2);
      o.d("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      return paramString2;
      throw paramString1;
      int i1 = 1;
      continue;
      label208:
      i1 = 0;
    }
  }
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    t.b(this.M);
    t.a(this.M, paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    o.b("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = f.a();
    }
    paramString = new com.tencent.luggage.wxa.gz.c();
    paramString.a.a = 4;
    paramString.a.d = "error";
    paramString.a.f = com.tencent.luggage.wxa.ql.e.a(paramInt);
    paramString.a.g = com.tencent.luggage.wxa.ql.e.b(paramInt);
    paramString.a.c = str;
    paramString.a.e = t(str);
    com.tencent.luggage.wxa.qy.a.a.a(paramString, Looper.getMainLooper());
  }
  
  public void a(i parami)
  {
    synchronized (this.z)
    {
      if (!this.z.contains(parami)) {
        this.z.add(parami);
      }
      return;
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.if.a parama)
  {
    this.v = parama;
    this.a = parama.b;
    return true;
  }
  
  public boolean a(com.tencent.luggage.wxa.if.b paramb)
  {
    if (paramb == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      return false;
    }
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.k.get(paramb.a);
    if (localb != null)
    {
      localb.b(paramb);
    }
    else
    {
      this.k.put(paramb.a, paramb);
      localb = paramb;
    }
    j localj = s(paramb.a);
    if (localj != null)
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localj.a(localb);
    }
    else
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
    }
    if (u()) {
      if (this.C.b(paramb.a)) {
        this.C.c(paramb);
      } else {
        this.C.b(paramb);
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.C.b(paramString))
      {
        this.C.e(paramString);
        return true;
      }
      return false;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { paramString });
    localj.q();
    b(paramString, localj);
    f(paramString, localj);
    return true;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.C.b(paramString)) {
        this.C.a(paramString, paramInt);
      }
      return b(paramString, paramInt);
    }
    if (paramInt < 0)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localj.I()) });
      return false;
    }
    if (localj.I() <= 0)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localj.I()) });
      localj.m();
      return b(paramString, paramInt);
    }
    if ((paramInt > 0) && (paramInt > localj.I()))
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localj.I()) });
      return false;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((!localj.t()) && (!localj.B()) && (!localj.w()))
    {
      localj.m();
      return b(paramString, paramInt);
    }
    return localj.c(paramInt);
  }
  
  public boolean a(String paramString, com.tencent.luggage.wxa.if.b paramb)
  {
    Object localObject = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if (((!this.c.contains(paramString)) || (localObject == null)) && (paramb != null))
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      b(paramString, paramb);
      if (localObject == null) {
        break label118;
      }
    }
    else
    {
      if (!this.c.contains(paramString))
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        a(601, paramString);
        return false;
      }
      if (localObject == null)
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
        a(602, paramString);
        return false;
      }
    }
    paramb = (com.tencent.luggage.wxa.if.b)localObject;
    label118:
    d(paramb);
    o.d("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
    localObject = t(paramString);
    int i1 = k((String)localObject);
    if (i1 >= 10)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i1) });
      if (x(paramString))
      {
        n();
      }
      else
      {
        t();
        a(600, paramString);
        return false;
      }
    }
    p();
    this.k.put(paramString, paramb);
    A((String)localObject);
    d();
    localObject = s(paramString);
    if (u())
    {
      boolean bool2 = a((j)localObject);
      boolean bool1;
      if ((this.C.b(paramString)) && (this.C.s(paramString))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), paramb.a });
      if ((bool2) && (bool1))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
        u(paramb.a);
        e(paramb);
        if (this.C.h(paramb.a))
        {
          o.d("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
          return true;
        }
        if (this.C.j(paramb.a))
        {
          o.d("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
          paramb.g = true;
          ((j)localObject).a(paramb);
          return true;
        }
        a(paramb, false, false);
        this.C.c(paramString);
        return true;
      }
    }
    else
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    }
    if (localObject == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      v(paramString);
      o.d("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      localObject = i();
      ((j)localObject).a(this.L);
      ((j)localObject).a(paramString);
      e(paramString, (j)localObject);
      paramb.g = true;
      paramb.d = 0;
      paramb.j = System.currentTimeMillis();
      a(paramb, false, true);
      ((j)localObject).b(paramb);
      return true;
    }
    e(paramString, (j)localObject);
    if ((((j)localObject).B()) && (!((j)localObject).t()))
    {
      a(paramb, false, true);
      o.d("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      ((j)localObject).s();
      return true;
    }
    if (((j)localObject).v())
    {
      a(paramb, false, true);
      paramb.g = true;
      paramb.j = System.currentTimeMillis();
      o.d("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
      ((j)localObject).s();
      paramb.d = 0;
      ((j)localObject).a(paramb);
      return true;
    }
    if (((j)localObject).u())
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
      paramb.g = true;
      paramb.j = System.currentTimeMillis();
      ((j)localObject).a(paramb);
      return true;
    }
    if (((j)localObject).C())
    {
      a(paramb, false, true);
      paramb.g = true;
      paramb.j = System.currentTimeMillis();
      o.d("MicroMsg.Audio.AudioPlayerMgr", "is paused on background, do resume");
      ((j)localObject).b(paramb);
      return true;
    }
    if (!((j)localObject).B())
    {
      a(paramb, false, true);
      paramb.g = true;
      paramb.j = System.currentTimeMillis();
      o.d("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
      ((j)localObject).b(paramb);
      paramb.d = 0;
      return true;
    }
    o.b("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    return false;
  }
  
  public void b()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.c.clear();
    synchronized (this.p)
    {
      Object localObject2 = this.e.iterator();
      String str;
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        c(str, (j)this.d.remove(str));
      }
      this.e.clear();
      this.d.clear();
      localObject2 = this.g.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        c(str, (j)this.f.remove(str));
      }
      this.g.clear();
      this.f.clear();
      ??? = this.h.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (String)((Iterator)???).next();
        localObject2 = (LinkedList)this.j.remove(localObject2);
        if (localObject2 != null) {
          ((LinkedList)localObject2).clear();
        }
      }
      this.h.clear();
      this.i.clear();
      this.j.clear();
      this.k.clear();
      this.l.clear();
      this.n.clear();
      this.o.clear();
      t.b(this.M);
      t.b(this.N);
      this.q = false;
      this.r = false;
      h();
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void b(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if ((this.q) && (l1 - this.s < 10000L)) {
      return;
    }
    this.s = l1;
    synchronized (this.p)
    {
      this.q = true;
      o.d("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
      t.b(this.N);
      t.a(this.N, paramInt);
      return;
    }
  }
  
  public void b(i parami)
  {
    synchronized (this.z)
    {
      if (this.z.contains(parami)) {
        this.z.remove(parami);
      }
      return;
    }
  }
  
  public boolean b(com.tencent.luggage.wxa.if.b paramb)
  {
    if (paramb == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      a(605, "");
      return false;
    }
    if (TextUtils.isEmpty(paramb.a))
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      a(604, paramb.a);
      return false;
    }
    if (!this.c.contains(paramb.a))
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      a(601, paramb.a);
      return false;
    }
    if (paramb.g) {
      d(paramb);
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    g();
    Object localObject2 = t(paramb.a);
    Object localObject1 = l(paramb.a);
    int i1 = k((String)localObject2);
    if (i1 >= 10)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(i1) });
      this.k.put(paramb.a, paramb);
      o.d("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.g) });
      f(paramb);
      if ((paramb.g) && (x(paramb.a)))
      {
        n();
      }
      else
      {
        if (paramb.g)
        {
          a(600, paramb.a);
          t();
          return false;
        }
        o.b("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
        localObject1 = s(paramb.a);
        if (localObject1 != null)
        {
          ((j)localObject1).a(paramb);
          ((j)localObject1).h();
        }
        return true;
      }
    }
    v(paramb.a);
    p();
    A((String)localObject2);
    d();
    this.i.put(localObject2, paramb.k);
    this.k.put(paramb.a, paramb);
    g(paramb);
    localObject2 = s(paramb.a);
    boolean bool2 = u();
    if (bool2)
    {
      boolean bool3 = a((j)localObject2);
      boolean bool1;
      if (((!TextUtils.isEmpty(paramb.c)) && (this.C.t(paramb.c))) || ((localObject1 != null) && (paramb.a((com.tencent.luggage.wxa.if.b)localObject1)) && (!TextUtils.isEmpty(((com.tencent.luggage.wxa.if.b)localObject1).c)) && (this.C.t(((com.tencent.luggage.wxa.if.b)localObject1).c)))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.a });
      if ((bool3) && (bool1))
      {
        a(paramb, (com.tencent.luggage.wxa.if.b)localObject1);
        return true;
      }
    }
    else
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
    }
    b(paramb, (com.tencent.luggage.wxa.if.b)localObject1);
    if (bool2) {
      c(paramb);
    }
    f(paramb);
    return true;
  }
  
  public boolean b(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.C.b(paramString))
      {
        this.C.f(paramString);
        return true;
      }
      return false;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localj.G();
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if (localb != null)
    {
      localb.d = 0;
      localb.g = true;
    }
    b(paramString, localj);
    f(paramString, localj);
    return true;
  }
  
  public com.tencent.luggage.wxa.if.a c()
  {
    return this.v;
  }
  
  public boolean c(String paramString)
  {
    if (this.C.b(paramString)) {
      this.C.f(paramString);
    }
    j localj = s(paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      return false;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localj.F();
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if (localb != null)
    {
      localb.d = 0;
      localb.g = true;
    }
    b(paramString, localj);
    f(paramString, localj);
    return true;
  }
  
  public void d()
  {
    if ((this.v.a) && (!this.D))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, useSpeakerOn is false, return");
      e();
      return;
    }
    if (this.v.a)
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, return");
      return;
    }
    if ((this.a) && (this.E.getMode() != 0))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "speaker is on and reset speaker");
      e();
      return;
    }
    if (this.a)
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "speaker is on, do nothing");
      return;
    }
    if (y.b())
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when phone calling");
      return;
    }
    if ((!this.E.isBluetoothScoOn()) && (!this.E.isBluetoothA2dpOn()))
    {
      if (this.E.isWiredHeadsetOn())
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
        return;
      }
      if ((!this.D) && (this.E.getMode() == 3) && (!this.E.isSpeakerphoneOn()))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
        return;
      }
      this.D = false;
      this.E.setSpeakerphoneOn(false);
      this.E.setMode(3);
      o.d("MicroMsg.Audio.AudioPlayerMgr", "set speaker off and change mode to MODE_IN_COMMUNICATION");
      return;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when isBluetoothScoOn:%b , isBluetoothA2dpOn:%b", new Object[] { Boolean.valueOf(this.E.isBluetoothScoOn()), Boolean.valueOf(this.E.isBluetoothA2dpOn()) });
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.H)
    {
      boolean bool2 = this.H.contains(paramString);
      boolean bool1 = bool2;
      if (!bool2)
      {
        ??? = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
        if ((??? != null) && (this.C.u(((com.tencent.luggage.wxa.if.b)???).c))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      if (!bool1)
      {
        if ((this.C.b(paramString)) && ((this.C.l(paramString)) || (this.C.h(paramString)) || (this.C.k(paramString)) || (this.C.j(paramString)) || (this.C.i(paramString)))) {
          this.C.f(paramString);
        }
        this.C.g(paramString);
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
      ??? = s(paramString);
      if (??? != null)
      {
        c(paramString, (j)???);
        synchronized (this.p)
        {
          this.d.remove(paramString);
          this.e.remove(paramString);
          this.f.remove(paramString);
          this.g.remove(paramString);
        }
      }
      o.b("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      this.c.remove(paramString);
      ??? = this.h.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.j.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.j.remove(str);
            this.h.remove(str);
            this.i.remove(str);
          }
        }
      }
      this.l.remove(paramString);
      if (!bool1)
      {
        this.k.remove(paramString);
        return true;
      }
      if (!this.G.contains(paramString)) {
        this.G.add(paramString);
      }
      return true;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void e()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "resetSpeaker");
    if ((!this.D) && (this.E.getMode() == 3))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "set speaker on and reset mode to MODE_NORMAL");
      this.E.setSpeakerphoneOn(true);
      this.E.setMode(0);
    }
    else if (!this.D)
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "set speaker on");
      this.E.setSpeakerphoneOn(true);
    }
    this.D = true;
  }
  
  public boolean e(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      if (this.C.b(paramString)) {
        return this.C.i(paramString);
      }
      o.b("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      return false;
    }
    return localj.B();
  }
  
  public int f()
  {
    if (!this.a)
    {
      if (this.v.a) {
        return 3;
      }
      if (!this.D) {
        return 0;
      }
    }
    return 3;
  }
  
  public boolean f(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      if (this.C.b(paramString)) {
        return this.C.h(paramString);
      }
      o.b("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      return false;
    }
    return localj.t();
  }
  
  protected void g()
  {
    if (this.y) {
      return;
    }
    if (ContextCompat.checkSelfPermission(r.a(), "android.permission.READ_PHONE_STATE") != 0)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.x = new y();
    this.x.a(r.a());
    this.x.a(new g.9(this));
    this.y = true;
    o.d("MicroMsg.Audio.AudioPlayerMgr", "addPhoneStatusWatcher");
  }
  
  public boolean g(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      if (this.C.b(paramString)) {
        return this.C.m(paramString);
      }
      o.b("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
      return true;
    }
    return localj.z();
  }
  
  protected void h()
  {
    try
    {
      if (this.x != null)
      {
        this.x.c();
        this.x.a();
        this.x = null;
      }
      this.y = false;
      o.d("MicroMsg.Audio.AudioPlayerMgr", "removePhoneStatusWatcher");
      return;
    }
    finally {}
  }
  
  public boolean h(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      if (this.C.b(paramString)) {
        return this.C.n(paramString);
      }
      o.b("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = j(paramString);
      if (paramString != null) {
        return paramString.d;
      }
      return false;
    }
    return localj.C();
  }
  
  protected boolean i(String paramString)
  {
    j localj = s(paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
      paramString = j(paramString);
      if (paramString != null) {
        return paramString.c;
      }
      return false;
    }
    return localj.w();
  }
  
  public com.tencent.luggage.wxa.if.d j(String paramString)
  {
    Object localObject = s(paramString);
    if (localObject != null) {
      return ((j)localObject).K();
    }
    if (this.C.b(paramString))
    {
      localObject = this.C.p(paramString);
      if (localObject != null) {
        return localObject;
      }
    }
    return (com.tencent.luggage.wxa.if.d)this.l.get(paramString);
  }
  
  public int k(String paramString)
  {
    int i2 = k();
    synchronized (this.p)
    {
      int i3 = this.c.size();
      int i4 = this.d.size();
      int i5 = this.f.size();
      paramString = (LinkedList)this.j.get(paramString);
      int i1;
      if (paramString == null) {
        i1 = 0;
      } else {
        i1 = paramString.size();
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i1), Integer.valueOf(i2) });
      return i4;
    }
  }
  
  public com.tencent.luggage.wxa.if.b l(String paramString)
  {
    if (this.k.containsKey(paramString)) {
      return (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    }
    return null;
  }
  
  public void m(String paramString)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.C.a();
    com.tencent.luggage.wxa.rz.f.a.c(new g.1(this));
    s();
    Object localObject3 = (LinkedList)this.j.get(paramString);
    long l1 = this.C.h();
    long l2 = this.C.d();
    long l3 = this.C.e();
    long l4 = l2 + l3;
    o.d("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.u = ((com.tencent.luggage.wxa.qe.a)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qe.a.class));
    if ((localObject3 != null) && (((LinkedList)localObject3).size() != 0))
    {
      if ((this.d.isEmpty()) && (this.f.isEmpty()))
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        localObject1 = this.u;
        if (localObject1 != null) {
          ((com.tencent.luggage.wxa.qe.a)localObject1).a(paramString, l1, l4, l2);
        }
        return;
      }
      Object localObject1 = new LinkedList();
      synchronized (this.p)
      {
        ((LinkedList)localObject1).addAll((Collection)localObject3);
        ??? = ((LinkedList)localObject1).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (String)((Iterator)???).next();
          j localj = (j)this.f.get(localObject3);
          if (localj != null) {
            a((String)localObject3, localj);
          }
        }
        o.d("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.d.size()) });
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (String)((Iterator)localObject1).next();
          localObject3 = (j)this.d.get(???);
          if (localObject3 != null)
          {
            a((String)???, (j)localObject3);
            f((String)???, (j)localObject3);
          }
        }
        localObject1 = this.u;
        if (localObject1 != null) {
          ((com.tencent.luggage.wxa.qe.a)localObject1).a(paramString, l1, l4, l2);
        }
        return;
      }
    }
    o.b("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
  }
  
  public void n(String paramString)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    s();
    A(paramString);
    e();
    LinkedList localLinkedList = (LinkedList)this.j.remove(paramString);
    if ((localLinkedList != null) && (localLinkedList.size() != 0)) {
      synchronized (this.p)
      {
        Iterator localIterator = localLinkedList.iterator();
        String str;
        j localj;
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localj = (j)this.d.remove(str);
          this.e.remove(str);
          o.d("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
          c(str, localj);
          this.k.remove(str);
          this.l.remove(str);
          if (this.C.b(str))
          {
            this.C.f(str);
            this.C.g(str);
          }
        }
        localIterator = localLinkedList.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localj = (j)this.f.remove(str);
          this.g.remove(str);
          o.d("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
          c(str, localj);
          this.k.remove(str);
          this.l.remove(str);
          if (this.C.b(str))
          {
            this.C.f(str);
            this.C.g(str);
          }
        }
        this.c.removeAll(localLinkedList);
        this.h.remove(paramString);
        this.i.remove(paramString);
        this.C.b();
        this.C.f();
        this.A.clear();
        this.B.clear();
        return;
      }
    }
    o.b("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
  }
  
  public void o(String arg1)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
    Object localObject1 = (LinkedList)this.j.get(???);
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0)) {
      synchronized (this.p)
      {
        Object localObject3 = ((LinkedList)localObject1).iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if (this.C.b((String)localObject4)) {
            this.C.f((String)localObject4);
          }
          j localj = (j)this.d.remove(localObject4);
          this.e.remove(localObject4);
          if (localj != null)
          {
            b((String)localObject4, localj);
            o.d("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
            if (localj.C()) {
              d((String)localObject4, localj);
            } else {
              c((String)localObject4, localj);
            }
          }
        }
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          if (this.C.b((String)localObject3)) {
            this.C.f((String)localObject3);
          }
          localObject4 = (j)this.f.remove(localObject3);
          this.g.remove(localObject3);
          if (localObject4 != null)
          {
            b((String)localObject3, (j)localObject4);
            o.d("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
            if (((j)localObject4).C()) {
              d((String)localObject3, (j)localObject4);
            } else {
              c((String)localObject3, (j)localObject4);
            }
          }
        }
        return;
      }
    }
    o.b("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
  }
  
  public void p(String arg1)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    A(???);
    e();
    Object localObject1 = (LinkedList)this.j.get(???);
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0)) {
      synchronized (this.p)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          if (this.C.b(str)) {
            this.C.f(str);
          }
          j localj = (j)this.f.remove(str);
          this.g.remove(str);
          if (localj != null)
          {
            b(str, localj);
            o.d("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
            if (localj.C()) {
              d(str, localj);
            } else {
              c(str, localj);
            }
          }
        }
        return;
      }
    }
    o.b("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
  }
  
  public void q(String paramString)
  {
    if (this.h.size() == 0) {
      return;
    }
    o.d("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.h);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.i.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        o.d("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        n(str1);
      }
    }
  }
  
  public void r(String paramString)
  {
    if (!u()) {
      return;
    }
    ??? = (com.tencent.luggage.wxa.if.b)this.k.get(paramString);
    if ((??? != null) && (!TextUtils.isEmpty(((com.tencent.luggage.wxa.if.b)???).c)) && (this.C.t(((com.tencent.luggage.wxa.if.b)???).c)))
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache cache done!");
      return;
    }
    synchronized (this.H)
    {
      if (!this.H.contains(paramString)) {
        this.H.add(paramString);
      }
      Looper.myQueue().addIdleHandler(new g.5(this, paramString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g
 * JD-Core Version:    0.7.0.1
 */