package com.tencent.map.sdk.a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

public final class nu
  extends nm
{
  private static ThreadLocal<Object> f = new ThreadLocal();
  private static final ThreadLocal<ArrayList<nu>> g = new nu.1();
  private static final ThreadLocal<ArrayList<nu>> h = new nu.2();
  private static final ThreadLocal<ArrayList<nu>> i = new nu.3();
  private static final ThreadLocal<ArrayList<nu>> j = new nu.4();
  private static final ThreadLocal<ArrayList<nu>> k = new nu.5();
  private static final Interpolator l = new LinearInterpolator();
  private static long p = 10L;
  long b;
  int c;
  nr[] d;
  HashMap<Integer, nr> e;
  private boolean m;
  private int n;
  private boolean o;
  private ArrayList<Object> q;
  
  public static void a(long paramLong)
  {
    p = paramLong;
  }
  
  public final nm a()
  {
    int i2 = 0;
    nu localnu = (nu)super.a();
    int i3;
    int i1;
    if (this.q != null)
    {
      localObject = this.q;
      localnu.q = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localnu.q.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localnu.b = -1L;
    localnu.m = false;
    localnu.n = 0;
    localnu.c = 0;
    localnu.o = false;
    Object localObject = this.d;
    if (localObject != null)
    {
      i3 = localObject.length;
      localnu.d = new nr[i3];
      localnu.e = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        nr localnr = localObject[i1].a();
        localnu.d[i1] = localnr;
        localnu.e.put(Integer.valueOf(localnr.a), localnr);
        i1 += 1;
      }
    }
    return localnu;
  }
  
  public final String toString()
  {
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.d != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.d.length) {
          break;
        }
        str1 = str1 + "\n    " + this.d[i1].toString();
        i1 += 1;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.nu
 * JD-Core Version:    0.7.0.1
 */