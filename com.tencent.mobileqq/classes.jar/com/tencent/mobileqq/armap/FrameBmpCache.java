package com.tencent.mobileqq.armap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import java.util.LinkedList;
import java.util.List;

public class FrameBmpCache
{
  public MQLruCache<String, Object> a = GlobalImageCache.a;
  public int b = 10;
  public int c;
  public boolean d;
  public List<String> e;
  public boolean f;
  LinkedList<FrameBmpCache.CancelAbleRunnable> g;
  volatile FrameBmpCache.CancelAbleRunnable h;
  Object i;
  Resources j;
  private long k;
  private volatile boolean l;
  private int m;
  private int n;
  private Bitmap o;
  private long p;
  private int q;
  private int r;
  private volatile boolean s;
  private boolean t;
  private boolean u;
  private FrameBmpCache.EndListener v;
  
  public FrameBmpCache(Resources paramResources)
  {
    int i1 = this.b;
    this.k = (1000 / i1);
    this.c = ((int)(i1 / 2.0F));
    this.d = false;
    this.f = false;
    this.l = false;
    this.m = -1;
    this.n = 0;
    this.s = false;
    this.g = new LinkedList();
    this.i = new Object();
    this.t = false;
    this.u = true;
    this.j = paramResources;
  }
  
  private Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      if ((this.u) && (this.j.getDisplayMetrics().density >= 2.0F)) {
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
      } else {
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("FrameBmpCache", 2, "decodeBitmap oom", paramString);
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ecodeBitmap oom ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("FrameBmpCache", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private int c(int paramInt)
  {
    return paramInt % this.e.size();
  }
  
  private void d(int paramInt)
  {
    int i1;
    int i2;
    Object localObject3;
    label228:
    label235:
    synchronized (this.i)
    {
      LinkedList localLinkedList = new LinkedList();
      i1 = paramInt;
      i2 = 0;
      if ((i1 < paramInt + 3) && ((i1 < this.e.size()) || (this.t)))
      {
        Object localObject1 = (String)this.e.get(c(i1));
        if (this.a.get(localObject1) != null)
        {
          break label235;
          localObject1 = localObject3;
          if (i2 < this.g.size())
          {
            if (c(((FrameBmpCache.CancelAbleRunnable)this.g.get(i2)).a) != c(i1)) {
              break label228;
            }
            localObject1 = (FrameBmpCache.CancelAbleRunnable)this.g.remove(i2);
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new FrameBmpCache.CancelAbleRunnable(this, i1);
          }
          localLinkedList.add(localObject3);
          break label235;
        }
      }
      else
      {
        if (localLinkedList.size() > 0)
        {
          this.g.addAll(0, localLinkedList);
          if (this.h == null) {
            f();
          }
        }
        return;
      }
    }
  }
  
  private void f()
  {
    this.h = ((FrameBmpCache.CancelAbleRunnable)this.g.poll());
    if (this.h != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("keepRunning ");
        localStringBuilder.append(this.h);
        QLog.i("FrameBmpCache", 2, localStringBuilder.toString());
      }
      ThreadManager.postImmediately(this.h, null, true);
    }
  }
  
  private void g()
  {
    if (this.e == null) {
      return;
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Bitmap localBitmap = (Bitmap)this.a.get(this.e.get(i1));
      if ((localBitmap != null) && (localBitmap != this.o)) {
        this.a.remove(this.e.get(i1));
      }
      i1 += 1;
    }
  }
  
  private void h()
  {
    this.l = true;
    this.f = false;
    this.m = -1;
    this.n = 0;
    this.q = 0;
    this.k = (1000 / this.b);
    synchronized (this.i)
    {
      this.g.clear();
      if (this.h != null)
      {
        this.h.a();
        this.h = null;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    paramInt = this.b;
    this.k = (1000 / paramInt);
    this.c = ((int)(paramInt / 2.0F));
  }
  
  public void a(FrameBmpCache.EndListener paramEndListener)
  {
    this.v = paramEndListener;
  }
  
  public void a(List<String> paramList)
  {
    this.e = paramList;
    this.r = 0;
    this.l = false;
    if (MemoryManager.d() <= 37748736L) {
      this.u = false;
    }
    paramList = new StringBuilder();
    paramList.append("mUseHighQuality=");
    paramList.append(this.u);
    QLog.d("FrameBmpCache", 1, paramList.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e != null;
  }
  
  public Bitmap b(int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      String str = (String)this.e.get(paramInt);
      Bitmap localBitmap = (Bitmap)this.a.get(str);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = a(str);
        this.a.put(str, localObject);
      }
      return localObject;
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameBmpCache", 2, "startDecode");
    }
    Object localObject1 = this.i;
    int i1 = 0;
    try
    {
      while (i1 < this.e.size())
      {
        FrameBmpCache.CancelAbleRunnable localCancelAbleRunnable = new FrameBmpCache.CancelAbleRunnable(this, i1);
        this.g.add(localCancelAbleRunnable);
        i1 += 1;
      }
      if (this.h == null) {
        f();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public Bitmap c()
  {
    boolean bool = this.l;
    Object localObject = null;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "getCurrentBitmap, isStop");
      }
      if (this.s) {
        localObject = this.o;
      }
      return localObject;
    }
    int i2 = (int)(System.currentTimeMillis() - this.p);
    int i1 = this.m;
    this.m = ((int)(i2 / this.k));
    if (this.m != i1) {
      d(i1 + 1);
    }
    if (this.m < i1) {
      this.m = i1;
    }
    if ((this.m >= this.e.size()) && (!this.t))
    {
      this.m = (this.e.size() - 1);
      this.f = true;
      localObject = this.v;
      if (localObject != null) {
        ((FrameBmpCache.EndListener)localObject).a(null);
      }
      if (this.s) {
        return (Bitmap)this.a.get(this.e.get(c(this.m)));
      }
      return null;
    }
    Bitmap localBitmap = (Bitmap)this.a.get(this.e.get(c(this.m)));
    localObject = localBitmap;
    if (localBitmap == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCurrentBitmap, cant find bitmap in cache, index=");
        ((StringBuilder)localObject).append(this.m);
        QLog.i("FrameBmpCache", 2, ((StringBuilder)localObject).toString());
      }
      localBitmap = (Bitmap)this.a.get(this.e.get(c(this.n)));
      localObject = localBitmap;
      if (localBitmap != null)
      {
        this.m = this.n;
        localObject = localBitmap;
      }
    }
    i2 = this.m;
    if ((i2 != i1) && (i2 - i1 != 1)) {
      this.q += 1;
    }
    if (localObject != null) {
      this.o = ((Bitmap)localObject);
    }
    if (this.d)
    {
      i1 = this.m - 1;
      if ((i1 > 0) && (i1 < this.e.size()))
      {
        localObject = (String)this.e.get(i1);
        this.a.remove(localObject);
      }
    }
    return this.o;
  }
  
  public void d()
  {
    this.m = 0;
    this.n = 0;
    this.q = 0;
    this.p = System.currentTimeMillis();
    this.o = ((Bitmap)this.a.get(this.e.get(this.m)));
    this.l = false;
    this.f = false;
  }
  
  public void e()
  {
    if (a())
    {
      h();
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache
 * JD-Core Version:    0.7.0.1
 */