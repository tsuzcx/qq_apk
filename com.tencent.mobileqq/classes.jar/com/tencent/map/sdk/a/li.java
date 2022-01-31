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
    pn localpn;
    lj locallj;
    if (!this.a.h())
    {
      localpn = this.a;
      locallj = this.b;
      if (locallj == null) {}
    }
    synchronized (localpn.a)
    {
      localpn.j = locallj;
      int i = this.b.a(paramBubbleOptions, paramkg);
      this.a.s();
      return i;
    }
  }
  
  public final void a()
  {
    if (this.b == null) {
      return;
    }
    this.b.c();
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
    if (paramInt < 0) {}
    while (this.b == null) {
      return true;
    }
    boolean bool = this.b.c(paramInt);
    this.a.s();
    return bool;
  }
  
  public final boolean a(int paramInt, BubbleOptions paramBubbleOptions)
  {
    if ((paramInt < 0) || (paramBubbleOptions == null)) {}
    while (this.b == null) {
      return false;
    }
    boolean bool = this.b.a(paramInt, paramBubbleOptions);
    this.a.s();
    return bool;
  }
  
  public final List<Integer> b()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.d();
  }
  
  public final boolean b(int paramInt)
  {
    if (this.b == null) {
      return false;
    }
    return this.b.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.li
 * JD-Core Version:    0.7.0.1
 */