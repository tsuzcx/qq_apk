package com.tencent.luggage.util;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.joor.Reflect;

public class a
  extends InputStream
{
  private final ByteBuffer a;
  private int b;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public static void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {}
    try
    {
      Reflect.on(Reflect.on(paramByteBuffer).call("cleaner").get()).call("clean");
      return;
    }
    catch (Exception paramByteBuffer) {}
  }
  
  public long a()
  {
    return this.a.limit();
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.a.position(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int available()
  {
    return this.a.remaining();
  }
  
  public ByteBuffer b()
  {
    return this.a;
  }
  
  public void close()
  {
    super.close();
    a(this.a);
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.b = this.a.position();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (this.a.hasRemaining()) {
      return this.a.get() & 0xFF;
    }
    return -1;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.a.hasRemaining()) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, this.a.remaining());
    this.a.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public void reset()
  {
    try
    {
      this.a.position(this.b);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.a
 * JD-Core Version:    0.7.0.1
 */