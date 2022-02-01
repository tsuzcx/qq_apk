package com.tencent.luggage.wxa.hg;

import androidx.exifinterface.media.ExifInterface;

public class e
{
  public String a;
  public String b;
  public String c;
  public short d;
  public short e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public double l;
  public double m;
  public short n;
  public byte o;
  public int p;
  public int q;
  public int r;
  public int s;
  public double t = -1.0D;
  public double u = -1.0D;
  public double v = 0.0D;
  private ExifInterface w;
  
  public static e b(String paramString)
  {
    e locale = new e();
    locale.a(paramString);
    return locale;
  }
  
  private void b()
  {
    Object localObject = this.w;
    if (localObject == null) {
      return;
    }
    this.a = ((ExifInterface)localObject).getAttribute("ImageDescription");
    this.b = this.w.getAttribute("Make");
    this.c = this.w.getAttribute("Model");
    this.d = ((short)this.w.getAttributeInt("Orientation", 0));
    this.e = ((short)this.w.getAttributeInt("BitsPerSample", 0));
    this.f = this.w.getAttribute("Software");
    this.g = this.w.getAttribute("DateTime");
    this.h = this.w.getAttribute("DateTimeOriginal");
    this.i = this.w.getAttribute("DateTimeDigitized");
    this.j = this.w.getAttribute("SubSecTimeOriginal");
    this.k = this.w.getAttribute("Copyright");
    this.l = this.w.getAttributeDouble("ExposureTime", 0.0D);
    this.m = this.w.getAttributeDouble("FNumber", 0.0D);
    this.n = ((short)this.w.getAttributeInt("ISOSpeedRatings", 0));
    this.o = ((byte)this.w.getAttributeInt("Flash", 0));
    this.p = this.w.getAttributeInt("ImageWidth", 0);
    this.q = this.w.getAttributeInt("ImageLength", 0);
    this.r = this.w.getAttributeInt("FileSource", 0);
    this.s = this.w.getAttributeInt("SceneType", 0);
    localObject = this.w.getLatLong();
    if (localObject != null)
    {
      this.t = localObject[0];
      this.u = localObject[1];
    }
    this.v = this.w.getAltitude(0.0D);
  }
  
  public int a()
  {
    ExifInterface localExifInterface = this.w;
    if (localExifInterface != null) {
      return localExifInterface.getRotationDegrees();
    }
    int i1 = this.d;
    if (i1 != 3)
    {
      if (i1 != 6)
      {
        if (i1 != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: invokestatic 162	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload 4
    //   12: astore_2
    //   13: aload 4
    //   15: astore_3
    //   16: aload_0
    //   17: new 57	androidx/exifinterface/media/ExifInterface
    //   20: dup
    //   21: aload 4
    //   23: invokespecial 165	androidx/exifinterface/media/ExifInterface:<init>	(Ljava/io/InputStream;)V
    //   26: putfield 53	com/tencent/luggage/wxa/hg/e:w	Landroidx/exifinterface/media/ExifInterface;
    //   29: aload 4
    //   31: astore_2
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: invokespecial 167	com/tencent/luggage/wxa/hg/e:b	()V
    //   39: aload 4
    //   41: invokestatic 172	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: astore_1
    //   47: goto +36 -> 83
    //   50: astore 4
    //   52: aload_3
    //   53: astore_2
    //   54: ldc 174
    //   56: ldc 176
    //   58: iconst_2
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload 4
    //   70: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 185	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload_3
    //   78: invokestatic 172	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   81: iconst_m1
    //   82: ireturn
    //   83: aload_2
    //   84: invokestatic 172	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	e
    //   0	89	1	paramString	String
    //   3	81	2	localObject1	Object
    //   1	77	3	localObject2	Object
    //   8	32	4	localInputStream	java.io.InputStream
    //   50	19	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	10	46	finally
    //   16	29	46	finally
    //   35	39	46	finally
    //   54	77	46	finally
    //   4	10	50	java/lang/Exception
    //   16	29	50	java/lang/Exception
    //   35	39	50	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.e
 * JD-Core Version:    0.7.0.1
 */