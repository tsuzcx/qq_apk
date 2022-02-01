package com.tencent.luggage.wxa.am;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
  implements g
{
  private final AssetManager a;
  private final w<? super c> b;
  private Uri c;
  private InputStream d;
  private long e;
  private boolean f;
  
  public c(Context paramContext, w<? super c> paramw)
  {
    this.a = paramContext.getAssets();
    this.b = paramw;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.e;
    if (l1 == 0L) {
      return -1;
    }
    long l2;
    if (l1 != -1L) {
      l2 = paramInt2;
    }
    try
    {
      paramInt2 = (int)Math.min(l1, l2);
      paramInt1 = this.d.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        if (this.e == -1L) {
          return -1;
        }
        throw new c.a(new EOFException());
      }
      l1 = this.e;
      if (l1 != -1L) {
        this.e = (l1 - paramInt1);
      }
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(this, paramInt1);
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new c.a(paramArrayOfByte);
    }
  }
  
  public long a(j paramj)
  {
    try
    {
      this.c = paramj.a;
      String str = this.c.getPath();
      Object localObject;
      if (str.startsWith("/android_asset/"))
      {
        localObject = str.substring(15);
      }
      else
      {
        localObject = str;
        if (str.startsWith("/")) {
          localObject = str.substring(1);
        }
      }
      this.d = this.a.open((String)localObject, 1);
      if (this.d.skip(paramj.d) >= paramj.d)
      {
        if (paramj.e != -1L)
        {
          this.e = paramj.e;
        }
        else
        {
          this.e = this.d.available();
          if (this.e == 2147483647L) {
            this.e = -1L;
          }
        }
        this.f = true;
        localObject = this.b;
        if (localObject != null) {
          ((w)localObject).a(this, paramj);
        }
        return this.e;
      }
      throw new EOFException();
    }
    catch (IOException paramj)
    {
      throw new c.a(paramj);
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 77	com/tencent/luggage/wxa/am/c:c	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 52	com/tencent/luggage/wxa/am/c:d	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 52	com/tencent/luggage/wxa/am/c:d	Ljava/io/InputStream;
    //   16: invokevirtual 124	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 52	com/tencent/luggage/wxa/am/c:d	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 118	com/tencent/luggage/wxa/am/c:f	Z
    //   28: ifeq +24 -> 52
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 118	com/tencent/luggage/wxa/am/c:f	Z
    //   36: aload_0
    //   37: getfield 34	com/tencent/luggage/wxa/am/c:b	Lcom/tencent/luggage/wxa/am/w;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +10 -> 52
    //   45: aload_1
    //   46: aload_0
    //   47: invokeinterface 127 2 0
    //   52: return
    //   53: astore_1
    //   54: goto +13 -> 67
    //   57: astore_1
    //   58: new 59	com/tencent/luggage/wxa/am/c$a
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 65	com/tencent/luggage/wxa/am/c$a:<init>	(Ljava/io/IOException;)V
    //   66: athrow
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 52	com/tencent/luggage/wxa/am/c:d	Ljava/io/InputStream;
    //   72: aload_0
    //   73: getfield 118	com/tencent/luggage/wxa/am/c:f	Z
    //   76: ifeq +24 -> 100
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 118	com/tencent/luggage/wxa/am/c:f	Z
    //   84: aload_0
    //   85: getfield 34	com/tencent/luggage/wxa/am/c:b	Lcom/tencent/luggage/wxa/am/w;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: aload_0
    //   95: invokeinterface 127 2 0
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	c
    //   40	6	1	localw1	w
    //   53	1	1	localObject	Object
    //   57	44	1	localIOException	IOException
    //   88	6	2	localw2	w
    // Exception table:
    //   from	to	target	type
    //   5	19	53	finally
    //   58	67	53	finally
    //   5	19	57	java/io/IOException
  }
  
  public Uri b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.c
 * JD-Core Version:    0.7.0.1
 */