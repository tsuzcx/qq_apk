package com.tencent.map.sdk.a;

public class nv
{
  public static final nv o = new nv(1, null);
  public static final nv p = new nv(2, null, true);
  public static final nv q = new nv(104, null);
  public int i;
  public double[] j;
  public long k = -1L;
  public boolean l = false;
  public boolean m;
  public Runnable n;
  
  public nv() {}
  
  public nv(int paramInt, double[] paramArrayOfDouble)
  {
    this(paramInt, paramArrayOfDouble, false);
  }
  
  public nv(int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    this.i = paramInt;
    this.j = paramArrayOfDouble;
    this.m = paramBoolean;
  }
  
  public nv(Runnable paramRunnable)
  {
    this.i = 6;
    this.n = paramRunnable;
  }
  
  public void a() {}
  
  public final boolean a(nw paramnw)
  {
    boolean bool = b();
    paramnw.b(this);
    return bool;
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.nv
 * JD-Core Version:    0.7.0.1
 */