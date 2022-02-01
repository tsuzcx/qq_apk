package com.tencent.luggage.wxa.be;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.b;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;

class a$b
  implements a.a
{
  private a$b(a parama) {}
  
  private String a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    if (af.c(paramString)) {
      return paramString;
    }
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    if (paramc.getFileSystem().a(new com.tencent.luggage.wxa.rt.i(paramString), "", true, locali) == j.a) {
      return (String)locali.a;
    }
    return null;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (a.k(this.a) != null) {
      a.k(this.a).a(paramInt, paramString);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (a.k(this.a) != null)
    {
      int j;
      long l;
      int i;
      int k;
      if (paramInt == 0)
      {
        int[] arrayOfInt = new int[3];
        a(paramString3, arrayOfInt);
        double d = arrayOfInt[0];
        Double.isNaN(d);
        j = (int)Math.round(d * 1.0D / 1000.0D);
        l = k.c(paramString3);
        i = arrayOfInt[1];
        k = arrayOfInt[2];
      }
      else
      {
        l = 0L;
        j = 0;
        i = 0;
        k = 0;
      }
      a.k(this.a).a(paramInt, paramString1, a(a.g(this.a), paramString2), a(a.g(this.a), paramString3), j, l, i, k);
    }
    a.v(this.a);
  }
  
  private void a(String paramString)
  {
    if (af.c(paramString))
    {
      a(-1, "record file not exist", a.y(this.a), paramString);
    }
    else
    {
      a locala = this.a;
      a(a.a(locala, paramString, a.z(locala), a.A(this.a), a.h(this.a).g()), a.y(this.a));
      a(0, "", a.y(this.a), paramString);
    }
    h();
  }
  
  /* Error */
  private void a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +244 -> 245
    //   4: aload_2
    //   5: arraylength
    //   6: iconst_3
    //   7: if_icmpge +6 -> 13
    //   10: goto +235 -> 245
    //   13: aload_1
    //   14: invokestatic 145	com/tencent/luggage/wxa/rt/k:h	(Ljava/lang/String;)Z
    //   17: ifne +19 -> 36
    //   20: ldc 147
    //   22: ldc 149
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: invokestatic 155	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: return
    //   36: aconst_null
    //   37: astore 6
    //   39: aconst_null
    //   40: astore 4
    //   42: new 157	android/media/MediaMetadataRetriever
    //   45: dup
    //   46: invokespecial 158	android/media/MediaMetadataRetriever:<init>	()V
    //   49: astore 5
    //   51: aload 5
    //   53: aload_1
    //   54: invokevirtual 161	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   57: aload_2
    //   58: iconst_0
    //   59: aload 5
    //   61: bipush 9
    //   63: invokevirtual 165	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   66: iconst_0
    //   67: invokestatic 168	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   70: iastore
    //   71: aload 5
    //   73: bipush 24
    //   75: invokevirtual 165	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   78: iconst_0
    //   79: invokestatic 168	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   82: istore_3
    //   83: iload_3
    //   84: bipush 90
    //   86: if_icmpeq +44 -> 130
    //   89: iload_3
    //   90: sipush 270
    //   93: if_icmpne +6 -> 99
    //   96: goto +34 -> 130
    //   99: aload_2
    //   100: iconst_1
    //   101: aload 5
    //   103: bipush 18
    //   105: invokevirtual 165	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   108: iconst_0
    //   109: invokestatic 168	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   112: iastore
    //   113: aload_2
    //   114: iconst_2
    //   115: aload 5
    //   117: bipush 19
    //   119: invokevirtual 165	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   122: iconst_0
    //   123: invokestatic 168	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   126: iastore
    //   127: goto +31 -> 158
    //   130: aload_2
    //   131: iconst_1
    //   132: aload 5
    //   134: bipush 19
    //   136: invokevirtual 165	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   139: iconst_0
    //   140: invokestatic 168	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   143: iastore
    //   144: aload_2
    //   145: iconst_2
    //   146: aload 5
    //   148: bipush 18
    //   150: invokevirtual 165	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   153: iconst_0
    //   154: invokestatic 168	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   157: iastore
    //   158: aload 5
    //   160: invokevirtual 171	android/media/MediaMetadataRetriever:release	()V
    //   163: return
    //   164: astore_1
    //   165: goto +68 -> 233
    //   168: astore 4
    //   170: aload 5
    //   172: astore_1
    //   173: aload 4
    //   175: astore 5
    //   177: goto +16 -> 193
    //   180: astore_1
    //   181: aload 4
    //   183: astore 5
    //   185: goto +48 -> 233
    //   188: astore 5
    //   190: aload 6
    //   192: astore_1
    //   193: aload_1
    //   194: astore 4
    //   196: ldc 147
    //   198: ldc 173
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload 5
    //   208: aastore
    //   209: invokestatic 176	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_2
    //   213: iconst_0
    //   214: iconst_0
    //   215: iastore
    //   216: aload_2
    //   217: iconst_1
    //   218: iconst_0
    //   219: iastore
    //   220: aload_2
    //   221: iconst_2
    //   222: iconst_0
    //   223: iastore
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 171	android/media/MediaMetadataRetriever:release	()V
    //   232: return
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 171	android/media/MediaMetadataRetriever:release	()V
    //   243: aload_1
    //   244: athrow
    //   245: ldc 147
    //   247: ldc 178
    //   249: invokestatic 181	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	b
    //   0	253	1	paramString	String
    //   0	253	2	paramArrayOfInt	int[]
    //   82	12	3	i	int
    //   40	1	4	localObject1	Object
    //   168	14	4	localException1	Exception
    //   194	1	4	str	String
    //   49	135	5	localObject2	Object
    //   188	51	5	localException2	Exception
    //   37	154	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   51	83	164	finally
    //   99	127	164	finally
    //   130	158	164	finally
    //   51	83	168	java/lang/Exception
    //   99	127	168	java/lang/Exception
    //   130	158	168	java/lang/Exception
    //   42	51	180	finally
    //   196	212	180	finally
    //   42	51	188	java/lang/Exception
  }
  
  private boolean a(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      try
      {
        a.b(this.a, paramBitmap.getWidth());
        a.c(this.a, paramBitmap.getHeight());
        int i = 90;
        if ("normal".equals(a.t(this.a))) {
          i = 44;
        } else if ("low".equals(a.t(this.a))) {
          i = 25;
        }
        b.a(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(k.c(paramString)) });
        return true;
      }
      catch (Exception paramBitmap)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
      }
    }
    return false;
  }
  
  private void g()
  {
    f.a.c(new a.b.3(this));
  }
  
  private void h()
  {
    a.B(this.a);
    a.c(this.a, false);
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "takePicture.");
    if (a.h(this.a) == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "recordView is null");
      return;
    }
    if (a.o(this.a) == 2)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
      return;
    }
    if ((!a.p(this.a)) && (af.c(a.q(this.a)) >= 300L))
    {
      if (!this.a.b)
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
        a.a(this.a, -1, null, "camera has not been initialized");
        return;
      }
      a.a(this.a, af.b());
      a.b(this.a, true);
      a.a(this.a, 3);
      a.h(this.a).a(new a.b.1(this), "on".equals(a.s(this.a)));
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!a.n(this.a)) {}
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "startRecord.");
    if (!com.tencent.luggage.wxa.kp.a.a().d())
    {
      Toast.makeText(a.u(this.a), 2131891828, 1).show();
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "no micro phone permission");
      a(-1, "permission");
      return;
    }
    if (a.o(this.a) == 2)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
      a(-1, "is recording");
      return;
    }
    if (!this.a.b)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
      a(-1, "camera has not been initialized");
      return;
    }
    if (a.h(this.a).d())
    {
      a.b(this.a, af.b());
      a.a(this.a, 2);
      a(0, "");
      a.v(this.a);
      return;
    }
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "startRecord fail !!");
    a(-1, "startRecord fail");
  }
  
  public void c()
  {
    long l = af.c(a.C(this.a));
    if (l < 1500L)
    {
      l = 1500L - l;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(l) });
      t.a(new a.b.4(this), l);
      return;
    }
    f();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "stopRecord");
    if (a.h(this.a) == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "recordView is null");
      a(-1, "camera is null", null, null);
      return;
    }
    if (a.o(this.a) != 2)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
      a(-1, "is not recording", null, null);
      return;
    }
    if (a.w(this.a))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
      a(-1, "is stopping", null, null);
      return;
    }
    a.c(this.a, true);
    a.h(this.a).a(new a.b.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.b
 * JD-Core Version:    0.7.0.1
 */