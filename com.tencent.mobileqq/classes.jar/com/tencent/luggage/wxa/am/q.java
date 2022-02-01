package com.tencent.luggage.wxa.am;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class q
  implements g
{
  private final w<? super q> a;
  private RandomAccessFile b;
  private Uri c;
  private long d;
  private boolean e;
  
  public q()
  {
    this(null);
  }
  
  public q(w<? super q> paramw)
  {
    this.a = paramw;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l = this.d;
    if (l == 0L) {
      return -1;
    }
    try
    {
      paramInt1 = this.b.read(paramArrayOfByte, paramInt1, (int)Math.min(l, paramInt2));
      if (paramInt1 > 0)
      {
        this.d -= paramInt1;
        paramArrayOfByte = this.a;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.a(this, paramInt1);
        }
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new q.a(paramArrayOfByte);
    }
  }
  
  public long a(j paramj)
  {
    try
    {
      this.c = paramj.a;
      this.b = new RandomAccessFile(paramj.a.getPath(), "r");
      this.b.seek(paramj.d);
      if (paramj.e == -1L) {
        l = this.b.length() - paramj.d;
      } else {
        l = paramj.e;
      }
      this.d = l;
      long l = this.d;
      if (l >= 0L)
      {
        this.e = true;
        w localw = this.a;
        if (localw != null) {
          localw.a(this, paramj);
        }
        return this.d;
      }
      throw new EOFException();
    }
    catch (IOException paramj)
    {
      throw new q.a(paramj);
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 64	com/tencent/luggage/wxa/am/q:c	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 36	com/tencent/luggage/wxa/am/q:b	Ljava/io/RandomAccessFile;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 36	com/tencent/luggage/wxa/am/q:b	Ljava/io/RandomAccessFile;
    //   16: invokevirtual 99	java/io/RandomAccessFile:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 36	com/tencent/luggage/wxa/am/q:b	Ljava/io/RandomAccessFile;
    //   24: aload_0
    //   25: getfield 90	com/tencent/luggage/wxa/am/q:e	Z
    //   28: ifeq +24 -> 52
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 90	com/tencent/luggage/wxa/am/q:e	Z
    //   36: aload_0
    //   37: getfield 27	com/tencent/luggage/wxa/am/q:a	Lcom/tencent/luggage/wxa/am/w;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +10 -> 52
    //   45: aload_1
    //   46: aload_0
    //   47: invokeinterface 102 2 0
    //   52: return
    //   53: astore_1
    //   54: goto +13 -> 67
    //   57: astore_1
    //   58: new 54	com/tencent/luggage/wxa/am/q$a
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 57	com/tencent/luggage/wxa/am/q$a:<init>	(Ljava/io/IOException;)V
    //   66: athrow
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 36	com/tencent/luggage/wxa/am/q:b	Ljava/io/RandomAccessFile;
    //   72: aload_0
    //   73: getfield 90	com/tencent/luggage/wxa/am/q:e	Z
    //   76: ifeq +24 -> 100
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 90	com/tencent/luggage/wxa/am/q:e	Z
    //   84: aload_0
    //   85: getfield 27	com/tencent/luggage/wxa/am/q:a	Lcom/tencent/luggage/wxa/am/w;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: aload_0
    //   95: invokeinterface 102 2 0
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	q
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
 * Qualified Name:     com.tencent.luggage.wxa.am.q
 * JD-Core Version:    0.7.0.1
 */