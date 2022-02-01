package com.tencent.beacon.core.wup;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class c
{
  static HashMap<String, byte[]> a;
  public HashMap<String, byte[]> b = new HashMap();
  a c = new a();
  public String d = "GBK";
  public final RequestPacket e = new RequestPacket();
  
  private Object a(byte[] paramArrayOfByte, Object paramObject)
  {
    this.c.a(paramArrayOfByte);
    this.c.a(this.d);
    return this.c.a(paramObject, 0, true);
  }
  
  private byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  private void b()
  {
    a locala = new a(this.e.sBuffer);
    locala.a(this.d);
    if (a == null)
    {
      a = new HashMap();
      a.put("", new byte[0]);
    }
    this.b = locala.a(a, 0, false);
  }
  
  public <T> T a(String paramString, T paramT)
  {
    if (!this.b.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.b.get(paramString);
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
    this.e.iRequestId = paramInt;
  }
  
  public void a(String paramString)
  {
    this.e.sFuncName = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new a(paramArrayOfByte, 4);
        paramArrayOfByte.a(this.d);
        this.e.readFrom(paramArrayOfByte);
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
    ((b)localObject1).a(this.b, 0);
    Object localObject2 = this.e;
    ((RequestPacket)localObject2).iVersion = 3;
    ((RequestPacket)localObject2).sBuffer = a(((b)localObject1).a());
    localObject1 = new b(0);
    ((b)localObject1).a(this.d);
    this.e.writeTo((b)localObject1);
    localObject1 = a(((b)localObject1).a());
    int i = localObject1.length + 4;
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(i).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public void b(String paramString)
  {
    this.e.sServantName = paramString;
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
          this.b.put(paramString, paramT);
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.wup.c
 * JD-Core Version:    0.7.0.1
 */