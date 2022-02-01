package com.tencent.biz.qqcircle.bizparts.danmaku.util;

import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;

public class DanmakuUtils
{
  public static int a(AbsDanmaku paramAbsDanmaku1, AbsDanmaku paramAbsDanmaku2)
  {
    if (paramAbsDanmaku1 == paramAbsDanmaku2) {
      return 0;
    }
    if (paramAbsDanmaku1 == null) {
      return -1;
    }
    if (paramAbsDanmaku2 == null) {
      return 1;
    }
    if (paramAbsDanmaku1.equals(paramAbsDanmaku2)) {
      return 0;
    }
    long l = paramAbsDanmaku1.r() - paramAbsDanmaku2.r();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    int i = paramAbsDanmaku1.D() - paramAbsDanmaku2.D();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    i = paramAbsDanmaku1.H() - paramAbsDanmaku2.H();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    i = paramAbsDanmaku1.E() - paramAbsDanmaku2.E();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    l = paramAbsDanmaku1.q() - paramAbsDanmaku2.q();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    if (paramAbsDanmaku1.s() == null) {
      return -1;
    }
    if (paramAbsDanmaku2.s() == null) {
      return 1;
    }
    i = paramAbsDanmaku1.k() - paramAbsDanmaku2.k();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return paramAbsDanmaku1.hashCode() - paramAbsDanmaku1.hashCode();
  }
  
  public static int a(AbsDanmaku paramAbsDanmaku1, AbsDanmaku paramAbsDanmaku2, long paramLong)
  {
    if (paramAbsDanmaku1.k() != paramAbsDanmaku2.k()) {
      return -1;
    }
    if (!paramAbsDanmaku1.g())
    {
      if (paramAbsDanmaku2.g()) {
        return -1;
      }
      float[] arrayOfFloat = paramAbsDanmaku1.b(paramAbsDanmaku1.r());
      int i = (int)((paramAbsDanmaku2.b(paramAbsDanmaku1.r())[0] - arrayOfFloat[2]) / paramAbsDanmaku2.b());
      arrayOfFloat = paramAbsDanmaku1.b(paramAbsDanmaku1.d());
      return Math.max(i, (int)((paramAbsDanmaku2.b(paramAbsDanmaku1.d())[0] - arrayOfFloat[2]) / paramAbsDanmaku2.b()));
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.util.DanmakuUtils
 * JD-Core Version:    0.7.0.1
 */