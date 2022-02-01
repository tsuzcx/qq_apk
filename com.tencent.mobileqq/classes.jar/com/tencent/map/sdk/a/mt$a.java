package com.tencent.map.sdk.a;

import android.os.Handler;

final class mt$a
{
  float a = 0.0F;
  float b = 0.0F;
  float c = 0.0F;
  float d = 0.0F;
  int e = 1;
  int f = 0;
  float g = 0.0F;
  float h = 0.0F;
  int i = 0;
  boolean j = false;
  Handler k = new mt.a.1(this);
  private int m = -1;
  
  mt$a(mt parammt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = paramInt1;
    if (paramInt1 < 0) {
      n = 0;
    }
    int i2 = 255;
    int i1 = n;
    if (n > 255) {
      i1 = 255;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > 255) {
      paramInt2 = 255;
    }
    paramInt1 = paramInt3;
    if (paramInt3 < 0) {
      paramInt1 = 0;
    }
    paramInt3 = paramInt1;
    if (paramInt1 > 255) {
      paramInt3 = 255;
    }
    paramInt1 = paramInt4;
    if (paramInt4 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > 255) {
      paramInt1 = i2;
    }
    this.a = (i1 / 255.0F);
    this.b = (paramInt2 / 255.0F);
    this.c = (paramInt3 / 255.0F);
    this.d = (paramInt1 / 255.0F);
    this.m = -1;
  }
  
  private void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    if (this.k == null) {
      return;
    }
    a();
    float f1 = paramFloat1;
    if (paramFloat1 < 0.0F) {
      f1 = 0.0F;
    }
    float f2 = f1;
    if (f1 > 1.0F) {
      f2 = 1.0F;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 < 0.0F) {
      paramFloat1 = 0.0F;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 > 1.0F) {
      paramFloat2 = 1.0F;
    }
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    this.e = 1;
    if (l1 > 0L) {
      this.e = ((int)(l1 / 1000L * 50L));
    }
    if (this.e == 0) {
      this.e = 1;
    }
    int n = this.e;
    this.f = ((int)(l1 / n));
    this.g = ((paramFloat2 - f2) / n);
    this.h = f2;
    this.i = 0;
    this.k.sendEmptyMessage(0);
  }
  
  final void a()
  {
    Handler localHandler = this.k;
    if (localHandler != null) {
      localHandler.removeMessages(0);
    }
  }
  
  final void a(long paramLong)
  {
    this.j = false;
    a(0.0F, this.d, paramLong);
  }
  
  final void b(long paramLong)
  {
    this.j = true;
    a(this.h, 0.0F, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mt.a
 * JD-Core Version:    0.7.0.1
 */