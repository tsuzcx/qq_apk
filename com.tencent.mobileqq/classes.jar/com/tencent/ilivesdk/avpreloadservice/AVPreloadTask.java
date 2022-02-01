package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.AVPreloadState;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;

public class AVPreloadTask
  implements AVPreloadTaskInterface, Comparable<AVPreloadTask>
{
  private boolean A;
  private int B;
  private boolean C;
  private String a;
  private long b;
  private int c;
  private String d;
  private String e;
  private long f;
  private boolean g = false;
  private long h;
  private long i;
  private long j;
  private long k;
  private int l;
  private int m;
  private int n;
  private int o;
  private AVPreloadTaskInterface.TaskReportInfo p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v = 0L;
  private AVPreloadTaskInterface.AVPreloadState w = AVPreloadTaskInterface.AVPreloadState.PRELOAD_UNKNOWN;
  private boolean x = false;
  private int y = 60;
  private Bitmap z;
  
  public void A()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" clear--isBitmapUsed=");
    ((StringBuilder)localObject).append(this.C);
    Log.d("AVPreload|PreloadTask", ((StringBuilder)localObject).toString());
    if (!this.C)
    {
      localObject = this.z;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.z.recycle();
        Log.d("AVPreload|PreloadTask", "clear--preFirstFrameBitmap.recycle()");
      }
      this.z = null;
    }
  }
  
  public boolean B()
  {
    return this.g;
  }
  
  public int a(AVPreloadTask paramAVPreloadTask)
  {
    int i1 = paramAVPreloadTask.c;
    return i1 - i1;
  }
  
  public AVPreloadTaskInterface.TaskReportInfo a()
  {
    return this.p;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!this.C)
    {
      Log.d("AVPreload|PreloadTask", "clear--setPreFirstFrameBitmap.recycle()");
      Bitmap localBitmap = this.z;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        this.z.recycle();
        Log.d("AVPreload|PreloadTask", "clear--setPreFirstFrameBitmap finished");
      }
      this.z = null;
    }
    this.z = paramBitmap;
  }
  
  public void a(AVPreloadTaskInterface.AVPreloadState paramAVPreloadState)
  {
    this.w = paramAVPreloadState;
  }
  
  public void a(AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo)
  {
    this.p = paramTaskReportInfo;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public long b()
  {
    return this.h;
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVPreloadLog.c("AVPreload|Core", "set url is empty.", new Object[0]);
      return;
    }
    this.d = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public long c()
  {
    return this.i;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public long d()
  {
    return this.j;
  }
  
  public void d(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.k = paramLong;
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public long e()
  {
    return this.k;
  }
  
  public void e(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void e(long paramLong)
  {
    this.t = paramLong;
  }
  
  public long f()
  {
    return this.r;
  }
  
  public void f(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void f(long paramLong)
  {
    this.u = paramLong;
  }
  
  public long g()
  {
    return this.t;
  }
  
  public void g(long paramLong)
  {
    this.r = paramLong;
  }
  
  public long h()
  {
    return this.u;
  }
  
  public void h(long paramLong)
  {
    this.s = paramLong;
  }
  
  public long i()
  {
    return this.s;
  }
  
  public void i(long paramLong)
  {
    this.q = paramLong;
  }
  
  public long j()
  {
    return this.q;
  }
  
  public void j(long paramLong)
  {
    this.b = paramLong;
  }
  
  public int k()
  {
    return this.l;
  }
  
  public void k(long paramLong)
  {
    this.f = paramLong;
  }
  
  public int l()
  {
    return this.m;
  }
  
  public void l(long paramLong)
  {
    this.v = paramLong;
  }
  
  public int m()
  {
    return this.n;
  }
  
  public int n()
  {
    return this.o;
  }
  
  public int o()
  {
    return this.y;
  }
  
  public boolean p()
  {
    return this.x;
  }
  
  public String q()
  {
    if (TextUtils.isEmpty(this.a)) {
      return s();
    }
    return this.a;
  }
  
  public long r()
  {
    return this.b;
  }
  
  public String s()
  {
    String str2 = this.d;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String t()
  {
    if (TextUtils.isEmpty(this.e)) {
      return this.d;
    }
    return this.e;
  }
  
  public int u()
  {
    return this.c;
  }
  
  public long v()
  {
    return this.f;
  }
  
  public long w()
  {
    return this.v;
  }
  
  public Bitmap x()
  {
    return this.z;
  }
  
  public boolean y()
  {
    return this.A;
  }
  
  public int z()
  {
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTask
 * JD-Core Version:    0.7.0.1
 */