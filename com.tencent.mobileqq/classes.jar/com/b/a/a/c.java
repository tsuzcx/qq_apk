package com.b.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private static Comparator<byte[]> e = new c.1();
  private final List<byte[]> a = new LinkedList();
  private final List<byte[]> b = new ArrayList(64);
  private int c = 0;
  private final int d = 4096;
  
  public c(int paramInt) {}
  
  private void a()
  {
    try
    {
      while (this.c > this.d)
      {
        byte[] arrayOfByte = (byte[])this.a.remove(0);
        this.b.remove(arrayOfByte);
        this.c -= arrayOfByte.length;
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= this.d)
        {
          this.a.add(paramArrayOfByte);
          int j = Collections.binarySearch(this.b, paramArrayOfByte, e);
          int i = j;
          if (j < 0) {
            i = -j - 1;
          }
          this.b.add(i, paramArrayOfByte);
          this.c += paramArrayOfByte.length;
          a();
          return;
        }
      }
      finally {}
    }
  }
  
  public final byte[] a(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        arrayOfByte = (byte[])this.b.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.c -= arrayOfByte.length;
          this.b.remove(i);
          this.a.remove(arrayOfByte);
          return arrayOfByte;
        }
        i += 1;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */