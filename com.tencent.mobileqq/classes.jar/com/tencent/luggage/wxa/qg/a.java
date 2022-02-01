package com.tencent.luggage.wxa.qg;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  private com.tencent.luggage.wxa.qp.a a;
  private d b;
  private h c;
  private byte[] d = new byte[81920];
  private int e = -1;
  private int f = 0;
  private int g = -1;
  private int h = 0;
  
  public a(com.tencent.luggage.wxa.qp.a parama)
  {
    this.a = parama;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt2 -= this.e;
      this.f = (paramInt2 + paramInt3);
      System.arraycopy(paramArrayOfByte, paramInt1, this.d, paramInt2, paramInt3);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  private boolean a(int paramInt)
  {
    try
    {
      if (this.e <= paramInt)
      {
        int i = this.e;
        if (paramInt <= i + 81920)
        {
          bool = true;
          break label30;
        }
      }
      boolean bool = false;
      label30:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean b(int paramInt)
  {
    try
    {
      if (this.e <= paramInt)
      {
        int i = this.e;
        int j = this.f;
        if (paramInt <= i + j)
        {
          bool = true;
          break label36;
        }
      }
      boolean bool = false;
      label36:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 -= this.e;
      this.f = (paramInt1 + paramInt2);
      System.arraycopy(paramArrayOfByte, 0, this.d, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  private boolean c(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    paramInt -= 1;
    if (this.b.c(paramInt)) {
      return false;
    }
    int i = this.g;
    int j = this.h;
    if ((i + j == this.e) && (this.f > 0) && (j >= 8192))
    {
      o.d("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", new Object[] { Integer.valueOf(paramInt) });
      return true;
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    try
    {
      this.g = this.e;
      this.h = this.f;
      this.e = paramInt;
      this.f = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean d()
  {
    for (;;)
    {
      try
      {
        if ((this.e < 0) || (this.f <= 0)) {
          continue;
        }
        localObject1 = new byte[this.f];
        System.arraycopy(this.d, 0, localObject1, 0, this.f);
        this.c.b((byte[])localObject1, this.e, this.f);
        localObject1 = this.b.a(this.e, this.f);
        if (localObject1 == null)
        {
          o.b("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
          return false;
        }
        if (localObject1[0] == -1) {
          continue;
        }
        if (localObject1[1] != -1) {
          continue;
        }
      }
      finally
      {
        Object localObject1;
        continue;
        throw localObject2;
        continue;
        int i = localObject2[0];
        continue;
      }
      if (i > localObject1[1]) {
        continue;
      }
      this.b.d(i);
      i += 1;
    }
    if (c(localObject1[0])) {
      this.b.d(localObject1[0] - 1);
    }
    this.b.b();
    return true;
    o.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
    return false;
    o.b("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) });
    return false;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if (c() <= 0L)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("read(), fileLength is error, file length is ");
        paramArrayOfByte.append(c());
        o.b("MicroMsg.Music.FileBytesCacheMgr", paramArrayOfByte.toString());
        return -1;
      }
      int i = paramInt1 + paramInt2;
      if (i > c())
      {
        o.b("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Long.valueOf(c()) });
        paramInt2 = (int)c() - paramInt1;
      }
      if (this.b.b(paramInt1, paramInt2)) {
        return this.c.a(paramArrayOfByte, paramInt1, paramInt2);
      }
      return -1;
    }
    o.b("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return -1;
  }
  
  public void a()
  {
    String str = this.a.a();
    this.b = new d(str);
    this.b.a(c());
    this.b.a();
    this.c = new h(str);
    if (!this.c.d())
    {
      o.d("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
      this.b.c();
    }
    else if ((this.c.f() != c()) && (c() != -1L))
    {
      o.d("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
      this.b.c();
      this.c.e();
    }
    else if (c() == -1L)
    {
      o.d("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
    }
    else
    {
      o.d("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
    }
    long l = c();
    this.c.a();
    this.c.a(l);
    g.a(str, l);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("attach() fileLength is ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(",pieceFileCache length is ");
    ((StringBuilder)localObject).append(this.c.c());
    o.d("MicroMsg.Music.FileBytesCacheMgr", ((StringBuilder)localObject).toString());
    localObject = this.a.getMIMEType();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"application/octet-stream".equalsIgnoreCase((String)localObject))) {
      g.b(str, (String)localObject);
    }
    this.e = -1;
    this.f = 0;
    this.g = -1;
    this.h = 0;
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if (c() <= 0L)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("write() fileLength is error, file length is ");
        paramArrayOfByte.append(c());
        o.b("MicroMsg.Music.FileBytesCacheMgr", paramArrayOfByte.toString());
        return -1;
      }
      int i = paramInt1 + paramInt2;
      long l = i;
      if (l > c())
      {
        o.b("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[] { Integer.valueOf(i), Long.valueOf(c()) });
        return -1;
      }
      if ((a(paramInt1)) && (a(i)))
      {
        if ((!b(paramInt1)) || (!b(i))) {
          if (b(paramInt1))
          {
            c(paramArrayOfByte, paramInt1, paramInt2);
            if (this.f == 81920)
            {
              d();
              d(i);
            }
          }
          else
          {
            d();
            d(paramInt1);
            c(paramArrayOfByte, paramInt1, paramInt2);
          }
        }
      }
      else if ((a(paramInt1)) && (!a(i)) && (b(paramInt1)))
      {
        int j = 81920 - this.f;
        paramInt2 -= j;
        if (j > 0) {
          c(paramArrayOfByte, paramInt1, j);
        }
        d();
        paramInt1 += j;
        d(paramInt1);
        if (paramInt2 > 0) {
          a(paramArrayOfByte, j, paramInt1, paramInt2);
        }
      }
      else
      {
        d();
        d(paramInt1);
        c(paramArrayOfByte, paramInt1, paramInt2);
      }
      if (l == c())
      {
        d();
        d(i);
      }
      return 1;
    }
    o.b("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return -1;
  }
  
  public void b()
  {
    d();
    this.b.b();
    this.c.b();
    this.a = null;
    o.d("MicroMsg.Music.FileBytesCacheMgr", "detach()");
  }
  
  public long c()
  {
    return this.a.getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qg.a
 * JD-Core Version:    0.7.0.1
 */