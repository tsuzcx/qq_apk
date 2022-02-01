package com.tencent.mm.appbrand.v8;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.gi.c.c;
import java.nio.ByteBuffer;

public class BufferURLManager
{
  private volatile long a = 0L;
  
  public BufferURLManager()
  {
    c.c.b("BufferURLManager", "BufferURLManager created %d", new Object[] { Long.valueOf(this.a) });
  }
  
  private static void a(String paramString, Object... paramVarArgs) {}
  
  private static native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3);
  
  private static native long nativeCreate();
  
  private static native void nativeDestroy(long paramLong);
  
  private static native ByteBuffer nativeGetBuffer(long paramLong, String paramString);
  
  @Nullable
  public ByteBuffer a(@Nullable String paramString)
  {
    if (paramString == null)
    {
      c.c.c("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
      return null;
    }
    paramString = nativeGetBuffer(this.a, paramString);
    a("BufferURLManager createBufferURL with %s", new Object[] { paramString });
    return paramString;
  }
  
  public void a()
  {
    c.c.b("BufferURLManager", "BufferURLManager destroying %d", new Object[] { Long.valueOf(this.a) });
    nativeDestroy(this.a);
    this.a = 0L;
    c.c.b("BufferURLManager", "BufferURLManager destroyed %d", new Object[] { Long.valueOf(this.a) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    c.c.b("BufferURLManager", "BufferURLManager %d %d %d", new Object[] { Long.valueOf(this.a), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    nativeBindTo(this.a, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.BufferURLManager
 * JD-Core Version:    0.7.0.1
 */