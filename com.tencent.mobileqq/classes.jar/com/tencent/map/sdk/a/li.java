package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.BubbleOptions;
import java.util.List;

public final class li
  implements kt
{
  public pn a;
  private lj b;
  
  public final int a(BubbleOptions paramBubbleOptions, kg paramkg)
  {
    if (paramBubbleOptions == null) {
      return -1;
    }
    if (this.b == null) {
      this.b = new lj(this.a);
    }
    if (!this.a.h())
    {
      pn localpn = this.a;
      lj locallj = this.b;
      if (locallj != null) {
        synchronized (localpn.a)
        {
          localpn.j = locallj;
        }
      }
    }
    int i = this.b.a(paramBubbleOptions, paramkg);
    this.a.s();
    return i;
  }
  
  public final void a()
  {
    ??? = this.b;
    if (??? == null) {
      return;
    }
    ((lj)???).c();
    pn localpn = this.a;
    synchronized (localpn.a)
    {
      if (localpn.j != null)
      {
        localpn.j.c();
        localpn.j = null;
      }
      this.a.s();
      this.b = null;
      return;
    }
  }
  
  public final boolean a(int paramInt)
  {
    if (paramInt < 0) {
      return true;
    }
    lj locallj = this.b;
    if (locallj == null) {
      return true;
    }
    boolean bool = locallj.c(paramInt);
    this.a.s();
    return bool;
  }
  
  public final boolean a(int paramInt, BubbleOptions paramBubbleOptions)
  {
    if (paramInt >= 0)
    {
      if (paramBubbleOptions == null) {
        return false;
      }
      lj locallj = this.b;
      if (locallj == null) {
        return false;
      }
      boolean bool = locallj.a(paramInt, paramBubbleOptions);
      this.a.s();
      return bool;
    }
    return false;
  }
  
  public final List<Integer> b()
  {
    lj locallj = this.b;
    if (locallj == null) {
      return null;
    }
    return locallj.d();
  }
  
  public final boolean b(int paramInt)
  {
    lj locallj = this.b;
    if (locallj == null) {
      return false;
    }
    return locallj.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.li
 * JD-Core Version:    0.7.0.1
 */