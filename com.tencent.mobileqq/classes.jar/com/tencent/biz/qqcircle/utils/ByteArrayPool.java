package com.tencent.biz.qqcircle.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool
{
  protected static final Comparator<byte[]> a = new ByteArrayPool.1();
  private static ByteArrayPool b = new ByteArrayPool(102400);
  private List<byte[]> c = new LinkedList();
  private List<byte[]> d = new ArrayList(64);
  private int e = 0;
  private final int f;
  
  public ByteArrayPool(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */