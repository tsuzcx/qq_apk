package com.tencent.hlyyb.downloader.e.a;

import java.util.LinkedList;

public final class a
{
  private volatile long a = 0L;
  private volatile LinkedList<b> b = new LinkedList();
  private Object c = new Object();
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(int paramInt, long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    synchronized (this.c)
    {
      LinkedList localLinkedList = this.b;
      byte[] arrayOfByte = new byte[(int)paramLong2];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, (int)paramLong2);
      localLinkedList.addLast(new b(paramInt, paramLong1, arrayOfByte, paramLong2));
      this.a += paramLong2;
      return;
    }
  }
  
  public final b b()
  {
    synchronized (this.c)
    {
      if (this.b.size() > 0)
      {
        b localb = (b)this.b.removeFirst();
        this.a -= localb.d;
        return localb;
      }
      return null;
    }
  }
  
  public final void c()
  {
    synchronized (this.c)
    {
      while (b() != null) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.a.a
 * JD-Core Version:    0.7.0.1
 */