package com.tencent.beacon.a.h;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class d
{
  private static HashMap<String, byte[]> e = null;
  public final e a = new e();
  private HashMap<String, byte[]> b = new HashMap();
  private a c = new a();
  private String d = "GBK";
  
  public final <T> void a(String paramString, T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new b();
    ((b)localObject).a(this.d);
    ((b)localObject).a(paramT, 0);
    paramT = ((b)localObject).a();
    localObject = new byte[paramT.position()];
    System.arraycopy(paramT.array(), 0, localObject, 0, localObject.length);
    this.b.put(paramString, localObject);
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
      this.a.a(paramArrayOfByte);
      paramArrayOfByte = new a(this.a.e);
      paramArrayOfByte.a(this.d);
      if (e == null)
      {
        HashMap localHashMap = new HashMap();
        e = localHashMap;
        localHashMap.put("", new byte[0]);
      }
      this.b = paramArrayOfByte.a(e);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    Object localObject2 = new b(0);
    ((b)localObject2).a(this.d);
    ((b)localObject2).a(this.b, 0);
    this.a.a = 3;
    Object localObject1 = this.a;
    localObject2 = ((b)localObject2).a();
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((e)localObject1).e = arrayOfByte;
    localObject1 = new b(0);
    ((b)localObject1).a(this.d);
    this.a.a((b)localObject1);
    localObject2 = ((b)localObject1).a();
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length;
    localObject2 = ByteBuffer.allocate(i + 4);
    ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final <T> T b(String paramString, T paramT)
    throws Exception
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
 * Qualified Name:     com.tencent.beacon.a.h.d
 * JD-Core Version:    0.7.0.1
 */