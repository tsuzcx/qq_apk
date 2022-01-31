package com.tencent.beacon.core.wup;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class c
{
  private static HashMap<String, byte[]> e = null;
  public final RequestPacket a = new RequestPacket();
  private HashMap<String, byte[]> b = new HashMap();
  private a c = new a();
  private String d = "GBK";
  
  private static byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    b localb = new b();
    localb.a(this.d);
    localb.a(paramT, 0);
    paramT = a(localb.a());
    this.b.put(paramString, paramT);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new a(paramArrayOfByte, (byte)0);
      paramArrayOfByte.a(this.d);
      this.a.readFrom(paramArrayOfByte);
      paramArrayOfByte = new a(this.a.sBuffer);
      paramArrayOfByte.a(this.d);
      if (e == null)
      {
        HashMap localHashMap = new HashMap();
        e = localHashMap;
        localHashMap.put("", new byte[0]);
      }
      this.b = paramArrayOfByte.a(e, 0, false);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    Object localObject = new b(0);
    ((b)localObject).a(this.d);
    ((b)localObject).a(this.b, 0);
    this.a.iVersion = 3;
    this.a.sBuffer = a(((b)localObject).a());
    localObject = new b(0);
    ((b)localObject).a(this.d);
    this.a.writeTo((b)localObject);
    localObject = a(((b)localObject).a());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
  
  public final <T> T b(String paramString, T paramT)
  {
    if (!this.b.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.b.get(paramString);
    try
    {
      this.c.a(paramString);
      this.c.a(this.d);
      paramString = this.c.a(paramT, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.wup.c
 * JD-Core Version:    0.7.0.1
 */