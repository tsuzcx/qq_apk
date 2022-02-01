package com.tencent.beacon.pack;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class c
{
  private static HashMap<String, byte[]> a = new HashMap();
  public final RequestPacket b = new RequestPacket();
  public HashMap<String, byte[]> c = new HashMap();
  public String d = "GBK";
  a e = new a();
  
  static
  {
    a.put("", new byte[0]);
  }
  
  private Object a(byte[] paramArrayOfByte, Object paramObject)
  {
    this.e.a(paramArrayOfByte);
    this.e.a(this.d);
    return this.e.a(paramObject, 0, true);
  }
  
  private byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  private void b()
  {
    a locala = new a(this.b.sBuffer);
    locala.a(this.d);
    this.c = locala.a(a, 0, false);
  }
  
  public <T> T a(String paramString, T paramT)
  {
    if (!this.c.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.c.get(paramString);
    try
    {
      paramString = a(paramString, paramT);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public void a(int paramInt)
  {
    this.b.iRequestId = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b.sFuncName = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new a(paramArrayOfByte, 4);
        paramArrayOfByte.a(this.d);
        this.b.readFrom(paramArrayOfByte);
        b();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public byte[] a()
  {
    Object localObject1 = new b(0);
    ((b)localObject1).a(this.d);
    ((b)localObject1).a(this.c, 0);
    Object localObject2 = this.b;
    ((RequestPacket)localObject2).iVersion = 3;
    ((RequestPacket)localObject2).sBuffer = a(((b)localObject1).a());
    localObject1 = new b(0);
    ((b)localObject1).a(this.d);
    this.b.writeTo((b)localObject1);
    localObject1 = a(((b)localObject1).a());
    int i = localObject1.length + 4;
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(i).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public void b(String paramString)
  {
    this.b.sServantName = paramString;
  }
  
  public <T> void b(String paramString, T paramT)
  {
    if (paramString != null)
    {
      if (paramT != null)
      {
        if (!(paramT instanceof Set))
        {
          b localb = new b();
          localb.a(this.d);
          localb.a(paramT, 0);
          paramT = a(localb.a());
          this.c.put(paramString, paramT);
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.c
 * JD-Core Version:    0.7.0.1
 */