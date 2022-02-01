package com.huawei.updatesdk.a.a.a;

import java.util.ArrayDeque;
import java.util.Queue;

public final class a
{
  private static final a a = new a();
  private final Queue<byte[]> b = new ArrayDeque(0);
  
  public static a a()
  {
    return a;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 65536) {
      synchronized (this.b)
      {
        if ((this.b.size() < 32) && (!this.b.offer(paramArrayOfByte))) {
          com.huawei.updatesdk.a.a.b.a.a.a.a("ByteArrayPool", "releaseBytes false");
        }
        return;
      }
    }
  }
  
  public byte[] b()
  {
    synchronized (this.b)
    {
      byte[] arrayOfByte = (byte[])this.b.poll();
      ??? = arrayOfByte;
      if (arrayOfByte == null) {
        ??? = new byte[65536];
      }
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */