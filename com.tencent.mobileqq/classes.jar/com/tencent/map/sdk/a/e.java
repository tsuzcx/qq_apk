package com.tencent.map.sdk.a;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class e
  extends d
{
  static HashMap<String, byte[]> h = null;
  static HashMap<String, HashMap<String, byte[]>> i = null;
  protected f g = new f();
  private int j = 0;
  private int k = 0;
  
  public e()
  {
    this.g.a = 2;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (paramString.startsWith(".")) {
      throw new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(paramString)));
    }
    super.a(paramString, paramT);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    Object localObject = ByteBuffer.allocate(4);
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    ((ByteBuffer)localObject).put(arrayOfByte).flip();
    this.j = ((ByteBuffer)localObject).getInt();
    try
    {
      paramArrayOfByte = new k(paramArrayOfByte, (byte)0);
      paramArrayOfByte.a(this.c);
      this.g.readFrom(paramArrayOfByte);
      if (this.g.a == 3)
      {
        paramArrayOfByte = new k(this.g.g);
        paramArrayOfByte.a(this.c);
        if (h == null)
        {
          localObject = new HashMap();
          h = (HashMap)localObject;
          ((HashMap)localObject).put("", new byte[0]);
        }
        this.e = paramArrayOfByte.a(h, 0, false);
        return;
      }
      this.e = null;
      paramArrayOfByte = new k(this.g.g);
      paramArrayOfByte.a(this.c);
      if (i == null)
      {
        i = new HashMap();
        localObject = new HashMap();
        ((HashMap)localObject).put("", new byte[0]);
        i.put("", localObject);
      }
      this.a = paramArrayOfByte.a(i, 0, false);
      this.b = new HashMap();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    if (this.g.a == 2)
    {
      if ((this.g.e == null) || (this.g.e.equals(""))) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if ((this.g.f == null) || (this.g.f.equals(""))) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this.g.e == null) {
        this.g.e = "";
      }
      if (this.g.f == null) {
        this.g.f = "";
      }
    }
    Object localObject = new l(0);
    ((l)localObject).a(this.c);
    if ((this.g.a == 2) || (this.g.a == 1)) {
      ((l)localObject).a(this.a, 0);
    }
    for (;;)
    {
      this.g.g = o.a(((l)localObject).a);
      localObject = new l(0);
      ((l)localObject).a(this.c);
      this.g.writeTo((l)localObject);
      localObject = o.a(((l)localObject).a);
      int m = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(m + 4);
      localByteBuffer.putInt(m + 4).put((byte[])localObject).flip();
      return localByteBuffer.array();
      ((l)localObject).a(this.e, 0);
    }
  }
  
  public final void b(String paramString)
  {
    this.g.e = paramString;
  }
  
  public final void c(String paramString)
  {
    this.g.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */