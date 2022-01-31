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
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 255) {}
      for (int n = 255;; n = paramInt1)
      {
        if (paramInt2 < 0) {}
        for (paramInt1 = 0;; paramInt1 = paramInt2)
        {
          if (paramInt1 > 255) {}
          for (paramInt2 = 255;; paramInt2 = paramInt1)
          {
            if (paramInt3 < 0) {}
            for (paramInt1 = 0;; paramInt1 = paramInt3)
            {
              paramInt3 = paramInt1;
              if (paramInt1 > 255) {
                paramInt3 = 255;
              }
              if (paramInt4 < 0) {}
              for (paramInt1 = i2;; paramInt1 = paramInt4)
              {
                if (paramInt1 > 255) {
                  paramInt1 = i1;
                }
                for (;;)
                {
                  this.a = (n / 255.0F);
                  this.b = (paramInt2 / 255.0F);
                  this.c = (paramInt3 / 255.0F);
                  this.d = (paramInt1 / 255.0F);
                  this.m = -1;
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f2 = 1.0F;
    float f3 = 0.0F;
    if (this.k == null) {
      return;
    }
    a();
    if (paramFloat1 < 0.0F) {
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      float f1 = paramFloat1;
      if (paramFloat1 > 1.0F) {
        f1 = 1.0F;
      }
      if (paramFloat2 < 0.0F) {}
      for (paramFloat1 = f3;; paramFloat1 = paramFloat2)
      {
        if (paramFloat1 > 1.0F) {
          paramFloat1 = f2;
        }
        for (;;)
        {
          long l1 = paramLong;
          if (paramLong < 0L) {
            l1 = 0L;
          }
          this.e = 1;
          if (l1 > 0L) {
            this.e = ((int)(50L * (l1 / 1000L)));
          }
          if (this.e == 0) {
            this.e = 1;
          }
          this.f = ((int)(l1 / this.e));
          this.g = ((paramFloat1 - f1) / this.e);
          this.h = f1;
          this.i = 0;
          this.k.sendEmptyMessage(0);
          return;
        }
      }
    }
  }
  
  final void a()
  {
    if (this.k != null) {
      this.k.removeMessages(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.mt.a
 * JD-Core Version:    0.7.0.1
 */