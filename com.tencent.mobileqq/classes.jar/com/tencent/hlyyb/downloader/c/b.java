package com.tencent.hlyyb.downloader.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.common.a.f;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.hlyyb.downloader.e.a.c;
import com.tencent.hlyyb.downloader.e.a.d;
import com.tencent.hlyyb.downloader.e.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

public final class b
  implements com.tencent.hlyyb.common.a.b, DownloaderTaskListener, d
{
  private static b a = null;
  private Vector<i> b = new Vector();
  private c c = new c(this);
  
  private b()
  {
    com.tencent.hlyyb.common.a.a.a("downloader", this);
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private static void a(i parami, int paramInt)
  {
    if (parami == null) {
      return;
    }
    for (;;)
    {
      int i;
      String str1;
      try
      {
        localHashMap = new HashMap();
        i = parami.getFailCode();
        if (paramInt != 0) {
          break label1650;
        }
        i = 0;
        if (!parami.isEaseTask()) {
          break label1631;
        }
        str1 = "HLDownTiny";
        if (!f.a(f.a(str1, i, false))) {
          break;
        }
        localHashMap.put("D1", com.tencent.hlyyb.common.a.b());
        localHashMap.put("B1", parami.n);
        localHashMap.put("B2", com.tencent.hlyyb.common.b.b.d());
        localHashMap.put("B3", com.tencent.hlyyb.common.b.b.e());
        localHashMap.put("B4", com.tencent.hlyyb.common.b.b.f());
        if (!TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.a.a)) {
          localHashMap.put("B5", com.tencent.hlyyb.downloader.a.a.a);
        }
        localHashMap.put("B6", com.tencent.hlyyb.common.a.e());
        if (!TextUtils.isEmpty(parami.c)) {
          localHashMap.put("B7", parami.c);
        }
        if (!TextUtils.isEmpty(parami.d)) {
          localHashMap.put("B8", parami.d);
        }
        if (!TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.a.b)) {
          localHashMap.put("B9", com.tencent.hlyyb.downloader.a.a.b);
        }
        if (!TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.a.c)) {
          localHashMap.put("B10", com.tencent.hlyyb.downloader.a.a.c);
        }
        localHashMap.put("C13", parami.getSavePath());
        localHashMap.put("B14", parami.g);
        localHashMap.put("B15", parami.j);
        if (parami.a != -1) {
          localHashMap.put("B18", parami.a);
        }
        if (!TextUtils.isEmpty(parami.b)) {
          localHashMap.put("B19", parami.b);
        }
        localHashMap.put("B21", i);
        localHashMap.put("B22", paramInt);
        localHashMap.put("B23", parami.o());
        if (!TextUtils.isEmpty(parami.y)) {
          localHashMap.put("B24", parami.y);
        }
        localHashMap.put("B25", com.tencent.hlyyb.common.a.a.g());
        localObject = new StringBuilder();
        if (!parami.isSupportRange()) {
          break label1639;
        }
        j = 1;
        localHashMap.put("B28", j);
        localHashMap.put("B85", parami.getCategory().ordinal());
        localHashMap.put("B33", parami.j());
        if (parami.getKnownSize() > 0L) {
          localHashMap.put("B34", parami.getKnownSize());
        }
        if (paramInt != 0) {
          parami.v = SystemClock.elapsedRealtime();
        }
        long l2 = -1L;
        l1 = l2;
        if (parami.u > 0L)
        {
          l1 = l2;
          if (parami.v > parami.u) {
            l1 = parami.v - parami.u;
          }
        }
        localHashMap.put("B38", l1);
        localHashMap.put("B41", parami.getReceivedLength());
        localHashMap.put("B44", parami.o);
        localHashMap.put("B45", parami.p.getAndSet(0L));
        if (parami.w) {
          localHashMap.put("B46", "1");
        }
        localHashMap.put("B66", parami.f());
        if ((paramInt != 0) || (parami.A <= 0L)) {
          break label1653;
        }
        localHashMap.put("B77", parami.A);
        break label1653;
      }
      catch (Throwable parami)
      {
        HashMap localHashMap;
        Object localObject;
        long l1;
        String str2;
        parami = parami;
        parami.printStackTrace();
        return;
      }
      finally {}
      localHashMap.put("C11", f.b());
      localHashMap.put("C12", f.a());
      l1 = System.currentTimeMillis();
      localHashMap.put("C16", parami.t);
      localHashMap.put("C17", l1);
      localHashMap.put("C20", com.tencent.hlyyb.common.b.b.b(parami.getFailInfo()));
      str2 = parami.l();
      int j = str2.length();
      localObject = str2;
      if (j > 600) {
        localObject = str2.substring(0, 600) + "|" + j;
      }
      localHashMap.put("C26", (String)localObject);
      localHashMap.put("C27", parami.z);
      str2 = parami.m();
      j = str2.length();
      localObject = str2;
      if (j > 2000) {
        localObject = str2.substring(0, 2000) + "|" + j;
      }
      localHashMap.put("C37", localObject);
      if ((paramInt == 0) && (parami.d() > 1000)) {
        localHashMap.put("C48", parami.d());
      }
      if (parami.h() > 1000L) {
        localHashMap.put("C72", parami.h());
      }
      if (parami.g()) {
        localHashMap.put("C74", "1");
      }
      localHashMap.put("C78", parami.n());
      localHashMap.put("C79", parami.k());
      if (!TextUtils.isEmpty(parami.x)) {
        localHashMap.put("C80", parami.x);
      }
      localHashMap.put("B90", parami.p());
      localHashMap.put("B91", parami.q());
      localObject = parami.r();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("C92", localObject);
      }
      localObject = parami.s();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("C93", localObject);
      }
      localHashMap.put("C94", parami.u());
      if ((paramInt == 2) && (parami.isPausedOnMobile())) {
        localHashMap.put("B87", "1");
      }
      localHashMap.put("D1", com.tencent.hlyyb.common.a.c());
      localHashMap.put("D2", com.tencent.hlyyb.common.a.d());
      boolean bool;
      if (i == 0)
      {
        bool = true;
        f.a(str1, bool, localHashMap);
        return;
        label1631:
        str1 = "B_DLSDK_Result";
        continue;
        label1639:
        j = 0;
      }
      else
      {
        bool = false;
        continue;
        label1650:
        continue;
        label1653:
        if ((i != -40) && (i != -12)) {
          if (i != -45) {}
        }
      }
    }
  }
  
  private boolean g()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali.isRunning()) || (locali.isWaiting())) {
          return true;
        }
      }
      return false;
    }
  }
  
  public final List<DownloaderTask> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      i locali;
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locali = (i)localIterator.next();
        if (locali.isEaseTask())
        {
          if (!paramBoolean2) {
            continue;
          }
          if (!locali.isRunning()) {
            break label101;
          }
          if (!paramBoolean3) {
            continue;
          }
          localLinkedList.add(locali);
        }
      }
      if (paramBoolean1)
      {
        continue;
        label101:
        if (locali.isWaiting())
        {
          if (paramBoolean4) {}
        }
        else if (locali.isPaused())
        {
          if (paramBoolean5) {}
        }
        else if (locali.isFailed())
        {
          if (paramBoolean6) {}
        }
        else if ((!locali.isCompleted()) || (!paramBoolean7)) {}
      }
    }
    return localList;
  }
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject = d();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
  }
  
  public final void a(DownloaderTask arg1)
  {
    i locali;
    Object localObject1;
    if ((??? == null) || (!(??? instanceof i)))
    {
      ??? = "param task not illegal.";
      if (!"".equals(???)) {
        throw new HalleyException(???);
      }
    }
    else
    {
      locali = (i)???;
      for (;;)
      {
        try
        {
          if (com.tencent.hlyyb.common.b.b.a(locali.i)) {
            locali.i = "";
          }
          if (locali.i.contains("../")) {
            locali.i = locali.i.replace("../", "");
          }
          if (!com.tencent.hlyyb.downloader.a.a.g(locali.i)) {
            break label323;
          }
          localObject1 = c().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label316;
          }
          ??? = (DownloaderTask)((Iterator)localObject1).next();
          if (!locali.h.equalsIgnoreCase(???.getSaveDir())) {
            continue;
          }
          String str = locali.i;
          if (com.tencent.hlyyb.downloader.a.a.g(((i)???).i))
          {
            ??? = ???.getInitSaveName();
            if (!str.equalsIgnoreCase(???)) {
              continue;
            }
            ??? = "Can not add new task, another task exists with the same path:" + locali.h + "/" + locali.i;
            localObject1 = ???;
            if ("".equals(???)) {
              break label244;
            }
            break;
          }
        }
        finally {}
        ??? = ???.getRealSaveName();
      }
    }
    for (;;)
    {
      label244:
      synchronized (this.b)
      {
        this.b.add(locali);
      }
      return;
      label316:
      ??? = "";
      break;
      label323:
      ??? = "";
    }
  }
  
  public final void a(DownloaderTask paramDownloaderTask, boolean paramBoolean)
  {
    if (paramDownloaderTask == null) {
      return;
    }
    ((i)paramDownloaderTask).a(paramBoolean);
    synchronized (this.b)
    {
      this.b.remove(paramDownloaderTask);
      if (paramDownloaderTask.getStatus() != DownloaderTaskStatus.COMPLETE) {
        a((i)paramDownloaderTask, 3);
      }
      if (g())
      {
        this.c.a();
        return;
      }
    }
    this.c.b();
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (!locali.getUniqueKey().equals(paramString)) {
            continue;
          }
          paramString = locali;
          if (paramString != null) {
            a(paramString, paramBoolean);
          }
          return;
        }
      }
      paramString = null;
    }
  }
  
  public final void b()
  {
    if (this.c != null) {
      this.c.c();
    }
  }
  
  public final List<DownloaderTask> c()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      localLinkedList.addAll(this.b);
      return localLinkedList;
    }
  }
  
  public final List<DownloaderTask> d()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (locali.isRunning()) {
          localLinkedList.add(locali);
        }
      }
    }
    return localList;
  }
  
  public final boolean e()
  {
    Object localObject = d();
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    boolean bool1 = false;
    boolean bool2;
    if (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.a(i);
      if (locali.isRunning())
      {
        bool2 = locali.b();
        label70:
        if (!bool2) {
          break label86;
        }
        bool1 = true;
      }
    }
    label86:
    for (;;)
    {
      break;
      bool2 = false;
      break label70;
      return bool1;
    }
  }
  
  public final long f()
  {
    long l = 0L;
    for (;;)
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.isRunning()) {
            l = locali.i() + l;
          }
        }
        else
        {
          return l;
        }
      }
    }
  }
  
  public final void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask)
  {
    a((i)paramDownloaderTask, 0);
  }
  
  public final void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskFailedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskFailedSubloop(DownloaderTask paramDownloaderTask)
  {
    a((i)paramDownloaderTask, 1);
  }
  
  public final void onTaskPausedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskPausedSubloop(DownloaderTask paramDownloaderTask)
  {
    a((i)paramDownloaderTask, 2);
  }
  
  public final void onTaskPendingMainloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskStartedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskStartedSubloop(DownloaderTask paramDownloaderTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.c.b
 * JD-Core Version:    0.7.0.1
 */