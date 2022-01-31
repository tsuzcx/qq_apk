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
    int i = 0;
    if (this.b != null) {
      if (Build.VERSION.SDK_INT < 19) {
        break label46;
      }
    }
    label46:
    for (i = this.b.getAllocationByteCount() + 0;; i = this.b.getByteCount() + 0)
    {
      int j = i;
      if (this.d != null) {
        j = i + this.d.length;
      }
      return j;
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    c();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.d = paramArrayOfByte;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {}
    }
    else
    {
      return;
    }
    a.a = localOptions.outWidth;
    a.b = localOptions.outHeight;
    Bitmap localBitmap = null;
    int i = 0;
    int k;
    for (int j = 0; (j == 0) && (i < 20); j = k)
    {
      localBitmap = (Bitmap)((ow.h)c.a()).a;
      k = j;
      if (localBitmap.getWidth() == localOptions.outWidth)
      {
        k = j;
        if (localBitmap.getHeight() == localOptions.outHeight) {
          k = 1;
        }
      }
      i += 1;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (j != 0) {
      localOptions.inBitmap = localBitmap;
    }
    localOptions.inSampleSize = 1;
    localOptions.inMutable = true;
    this.b = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
  }
  
  /* Error */
  public final byte[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/map/sdk/a/ok:d	[B
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 49	com/tencent/map/sdk/a/ok:d	[B
    //   11: areturn
    //   12: aload_0
    //   13: getfield 51	com/tencent/map/sdk/a/ok:b	Landroid/graphics/Bitmap;
    //   16: ifnull +42 -> 58
    //   19: new 121	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 122	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 51	com/tencent/map/sdk/a/ok:b	Landroid/graphics/Bitmap;
    //   31: getstatic 128	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   34: bipush 100
    //   36: aload_2
    //   37: invokevirtual 132	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   40: ifeq +14 -> 54
    //   43: aload_2
    //   44: invokevirtual 135	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: astore_1
    //   48: aload_2
    //   49: invokestatic 140	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   52: aload_1
    //   53: areturn
    //   54: aload_2
    //   55: invokestatic 140	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   58: iconst_0
    //   59: newarray byte
    //   61: areturn
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: invokestatic 140	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: goto -7 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ok
    //   47	6	1	arrayOfByte	byte[]
    //   62	8	1	localObject1	java.lang.Object
    //   71	1	1	localObject2	java.lang.Object
    //   26	40	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   19	27	62	finally
    //   27	48	71	finally
  }
  
  public final void c()
  {
    if ((this.b != null) && (!this.b.isRecycled()))
    {
      if (c.a(new ow.h(this.b))) {
        break label65;
      }
      os.a("BitmapData").a();
      this.b.recycle();
      this.b = null;
    }
    for (;;)
    {
      this.d = null;
      return;
      label65:
      os.a("BitmapData").a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ok
 * JD-Core Version:    0.7.0.1
 */