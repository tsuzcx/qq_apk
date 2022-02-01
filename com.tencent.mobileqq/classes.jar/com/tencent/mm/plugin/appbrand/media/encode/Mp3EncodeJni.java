package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.luggage.wxa.ns.a;
import com.tencent.luggage.wxa.ns.a.a;

public class Mp3EncodeJni
{
  static
  {
    ClassLoader localClassLoader = Mp3EncodeJni.class.getClassLoader();
    a.a().a("mp3lame", localClassLoader);
  }
  
  public static native void close();
  
  public static native int encode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte);
  
  public static native int flush(byte[] paramArrayOfByte);
  
  public static native int getVersion();
  
  public static native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni
 * JD-Core Version:    0.7.0.1
 */