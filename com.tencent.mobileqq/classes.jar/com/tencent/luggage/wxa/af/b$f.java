package com.tencent.luggage.wxa.af;

import android.util.SparseArray;

final class b$f
{
  public final int a;
  public final boolean b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final int i;
  public final int j;
  public final SparseArray<b.g> k;
  
  public b$f(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<b.g> paramSparseArray)
  {
    this.a = paramInt1;
    this.b = paramBoolean;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.h = paramInt7;
    this.i = paramInt8;
    this.j = paramInt9;
    this.k = paramSparseArray;
  }
  
  public void a(f paramf)
  {
    if (paramf == null) {
      return;
    }
    paramf = paramf.k;
    int m = 0;
    while (m < paramf.size())
    {
      this.k.put(paramf.keyAt(m), paramf.valueAt(m));
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.af.b.f
 * JD-Core Version:    0.7.0.1
 */