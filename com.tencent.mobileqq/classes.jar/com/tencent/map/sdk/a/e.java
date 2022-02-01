package com.tencent.map.sdk.a;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class e
  extends d
{
  static HashMap<String, byte[]> h;
  static HashMap<String, HashMap<String, byte[]>> i;
  protected f g = new f();
  private int j = 0;
  private int k = 0;
  
  public e()
  {
    this.g.a = 2;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (!paramString.startsWith("."))
    {
      super.a(paramString, paramT);
      return;
    }
    throw new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(paramString)));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4)
    {
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
        int m = this.g.a;
        if (m == 3)
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
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public final byte[] a()
  {
    if (this.g.a == 2)
    {
      if ((this.g.e != null) && (!this.g.e.equals("")))
      {
        if ((this.g.f == null) || (this.g.f.equals(""))) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
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
    if ((this.g.a != 2) && (this.g.a != 1)) {
      ((l)localObject).a(this.e, 0);
    } else {
      ((l)localObject).a(this.a, 0);
    }
    this.g.g = o.a(((l)localObject).a);
    localObject = new l(0);
    ((l)localObject).a(this.c);
    this.g.writeTo((l)localObject);
    localObject = o.a(((l)localObject).a);
    int m = localObject.length + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(m);
    localByteBuffer.putInt(m).put((byte[])localObject).flip();
    return localByteBuffer.array();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */