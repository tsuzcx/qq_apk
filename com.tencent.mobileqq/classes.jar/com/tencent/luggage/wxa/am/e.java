package com.tencent.luggage.wxa.am;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e
  implements g
{
  private final ContentResolver a;
  private final w<? super e> b;
  private Uri c;
  private AssetFileDescriptor d;
  private InputStream e;
  private long f;
  private boolean g;
  
  public e(Context paramContext, w<? super e> paramw)
  {
    this.a = paramContext.getContentResolver();
    this.b = paramw;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.f;
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
      paramInt1 = this.e.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        if (this.f == -1L) {
          return -1;
        }
        throw new e.a(new EOFException());
      }
      l1 = this.f;
      if (l1 != -1L) {
        this.f = (l1 - paramInt1);
      }
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(this, paramInt1);
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new e.a(paramArrayOfByte);
    }
  }
  
  public long a(j paramj)
  {
    try
    {
      this.c = paramj.a;
      this.d = this.a.openAssetFileDescriptor(this.c, "r");
      if (this.d != null)
      {
        this.e = new FileInputStream(this.d.getFileDescriptor());
        long l1 = this.d.getStartOffset();
        l1 = this.e.skip(paramj.d + l1) - l1;
        if (l1 == paramj.d)
        {
          if (paramj.e != -1L)
          {
            this.f = paramj.e;
          }
          else
          {
            long l2 = this.d.getLength();
            if (l2 == -1L)
            {
              this.f = this.e.available();
              if (this.f == 0L) {
                this.f = -1L;
              }
            }
            else
            {
              this.f = (l2 - l1);
            }
          }
          this.g = true;
          w localw = this.b;
          if (localw != null) {
            localw.a(this, paramj);
          }
          return this.f;
        }
        throw new EOFException();
      }
      paramj = new StringBuilder();
      paramj.append("Could not open file descriptor for: ");
      paramj.append(this.c);
      throw new FileNotFoundException(paramj.toString());
    }
    catch (IOException paramj)
    {
      throw new e.a(paramj);
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 79	com/tencent/luggage/wxa/am/e:c	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 54	com/tencent/luggage/wxa/am/e:e	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 54	com/tencent/luggage/wxa/am/e:e	Ljava/io/InputStream;
    //   16: invokevirtual 148	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 54	com/tencent/luggage/wxa/am/e:e	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   28: ifnull +10 -> 38
    //   31: aload_0
    //   32: getfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   35: invokevirtual 149	android/content/res/AssetFileDescriptor:close	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   43: aload_0
    //   44: getfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   47: ifeq +24 -> 71
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   55: aload_0
    //   56: getfield 36	com/tencent/luggage/wxa/am/e:b	Lcom/tencent/luggage/wxa/am/w;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +10 -> 71
    //   64: aload_1
    //   65: aload_0
    //   66: invokeinterface 152 2 0
    //   71: return
    //   72: astore_1
    //   73: goto +13 -> 86
    //   76: astore_1
    //   77: new 61	com/tencent/luggage/wxa/am/e$a
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 67	com/tencent/luggage/wxa/am/e$a:<init>	(Ljava/io/IOException;)V
    //   85: athrow
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   91: aload_0
    //   92: getfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   95: ifeq +24 -> 119
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   103: aload_0
    //   104: getfield 36	com/tencent/luggage/wxa/am/e:b	Lcom/tencent/luggage/wxa/am/w;
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +10 -> 119
    //   112: aload_2
    //   113: aload_0
    //   114: invokeinterface 152 2 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto +13 -> 135
    //   125: astore_1
    //   126: new 61	com/tencent/luggage/wxa/am/e$a
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 67	com/tencent/luggage/wxa/am/e$a:<init>	(Ljava/io/IOException;)V
    //   134: athrow
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 54	com/tencent/luggage/wxa/am/e:e	Ljava/io/InputStream;
    //   140: aload_0
    //   141: getfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   144: ifnull +10 -> 154
    //   147: aload_0
    //   148: getfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   151: invokevirtual 149	android/content/res/AssetFileDescriptor:close	()V
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   159: aload_0
    //   160: getfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   163: ifeq +24 -> 187
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   171: aload_0
    //   172: getfield 36	com/tencent/luggage/wxa/am/e:b	Lcom/tencent/luggage/wxa/am/w;
    //   175: astore_2
    //   176: aload_2
    //   177: ifnull +10 -> 187
    //   180: aload_2
    //   181: aload_0
    //   182: invokeinterface 152 2 0
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: goto +13 -> 203
    //   193: astore_1
    //   194: new 61	com/tencent/luggage/wxa/am/e$a
    //   197: dup
    //   198: aload_1
    //   199: invokespecial 67	com/tencent/luggage/wxa/am/e$a:<init>	(Ljava/io/IOException;)V
    //   202: athrow
    //   203: aload_0
    //   204: aconst_null
    //   205: putfield 89	com/tencent/luggage/wxa/am/e:d	Landroid/content/res/AssetFileDescriptor;
    //   208: aload_0
    //   209: getfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   212: ifeq +24 -> 236
    //   215: aload_0
    //   216: iconst_0
    //   217: putfield 121	com/tencent/luggage/wxa/am/e:g	Z
    //   220: aload_0
    //   221: getfield 36	com/tencent/luggage/wxa/am/e:b	Lcom/tencent/luggage/wxa/am/w;
    //   224: astore_2
    //   225: aload_2
    //   226: ifnull +10 -> 236
    //   229: aload_2
    //   230: aload_0
    //   231: invokeinterface 152 2 0
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	e
    //   59	6	1	localw1	w
    //   72	1	1	localObject1	Object
    //   76	44	1	localIOException1	IOException
    //   121	1	1	localObject2	Object
    //   125	63	1	localIOException2	IOException
    //   189	1	1	localObject3	Object
    //   193	44	1	localIOException3	IOException
    //   107	123	2	localw2	w
    // Exception table:
    //   from	to	target	type
    //   24	38	72	finally
    //   77	86	72	finally
    //   24	38	76	java/io/IOException
    //   5	19	121	finally
    //   126	135	121	finally
    //   5	19	125	java/io/IOException
    //   140	154	189	finally
    //   194	203	189	finally
    //   140	154	193	java/io/IOException
  }
  
  public Uri b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.e
 * JD-Core Version:    0.7.0.1
 */