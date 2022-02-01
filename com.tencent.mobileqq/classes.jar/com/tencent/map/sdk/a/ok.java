package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;

public class ok
  extends nz
{
  protected static ow.a a;
  private static ow.f<ow.h<Bitmap>> c;
  public Bitmap b;
  private byte[] d;
  
  static
  {
    os.b("BitmapData");
    ow.a locala = new ow.a(Bitmap.Config.ARGB_8888);
    a = locala;
    c = ow.a(locala);
  }
  
  public ok() {}
  
  public ok(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
    if ((this.b == null) && (paramArrayOfByte != null)) {
      a(paramArrayOfByte);
    }
  }
  
  public final int a()
  {
    Object localObject = this.b;
    int i = 0;
    if (localObject != null)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        i = this.b.getAllocationByteCount();
      } else {
        i = this.b.getByteCount();
      }
      i = 0 + i;
    }
    localObject = this.d;
    int j = i;
    if (localObject != null) {
      j = i + localObject.length;
    }
    return j;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    c();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.d = paramArrayOfByte;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      if (localOptions.outWidth > 0)
      {
        if (localOptions.outHeight <= 0) {
          return;
        }
        a.a = localOptions.outWidth;
        a.b = localOptions.outHeight;
        Bitmap localBitmap = null;
        int j = 0;
        int i = 0;
        while ((j == 0) && (i < 20))
        {
          localBitmap = (Bitmap)((ow.h)c.a()).a;
          int k = j;
          if (localBitmap.getWidth() == localOptions.outWidth)
          {
            k = j;
            if (localBitmap.getHeight() == localOptions.outHeight) {
              k = 1;
            }
          }
          i += 1;
          j = k;
        }
        localOptions = new BitmapFactory.Options();
        if (j != 0) {
          localOptions.inBitmap = localBitmap;
        }
        localOptions.inSampleSize = 1;
        localOptions.inMutable = true;
        this.b = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      }
    }
  }
  
  /* Error */
  public final byte[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/map/sdk/a/ok:d	[B
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: aload_0
    //   12: getfield 51	com/tencent/map/sdk/a/ok:b	Landroid/graphics/Bitmap;
    //   15: ifnull +58 -> 73
    //   18: new 121	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 122	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 51	com/tencent/map/sdk/a/ok:b	Landroid/graphics/Bitmap;
    //   30: getstatic 128	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   33: bipush 100
    //   35: aload_2
    //   36: invokevirtual 132	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   39: ifeq +14 -> 53
    //   42: aload_2
    //   43: invokevirtual 135	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   46: astore_1
    //   47: aload_2
    //   48: invokestatic 140	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   51: aload_1
    //   52: areturn
    //   53: aload_2
    //   54: invokestatic 140	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   57: goto +16 -> 73
    //   60: astore_1
    //   61: goto +6 -> 67
    //   64: astore_1
    //   65: aconst_null
    //   66: astore_2
    //   67: aload_2
    //   68: invokestatic 140	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   71: aload_1
    //   72: athrow
    //   73: iconst_0
    //   74: newarray byte
    //   76: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ok
    //   4	48	1	arrayOfByte	byte[]
    //   60	1	1	localObject1	Object
    //   64	8	1	localObject2	Object
    //   25	43	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   26	47	60	finally
    //   18	26	64	finally
  }
  
  public final void c()
  {
    Bitmap localBitmap = this.b;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      if (!c.a(new ow.h(this.b)))
      {
        os.a("BitmapData").a();
        this.b.recycle();
        this.b = null;
      }
      else
      {
        os.a("BitmapData").a();
      }
    }
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ok
 * JD-Core Version:    0.7.0.1
 */