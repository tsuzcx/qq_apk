package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.pc.h;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.d;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.l;
import java.util.Iterator;
import java.util.Set;

public final class r
{
  private static final AppBrandSimpleImageLoader.l a = new AppBrandSimpleImageLoader.d();
  private static final h<d, String> b = new h();
  
  /* Error */
  public static android.graphics.Bitmap a(d paramd, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokestatic 32	com/tencent/mm/plugin/appbrand/appstorage/k:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_2
    //   11: aload_2
    //   12: invokestatic 38	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 40	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   27: astore_1
    //   28: aload_1
    //   29: aload_0
    //   30: invokevirtual 45	java/lang/Object:hashCode	()I
    //   33: bipush 35
    //   35: iadd
    //   36: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: getstatic 23	com/tencent/mm/plugin/appbrand/page/r:b	Lcom/tencent/luggage/wxa/pc/h;
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 59	com/tencent/luggage/wxa/pc/h:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   59: pop
    //   60: getstatic 18	com/tencent/mm/plugin/appbrand/page/r:a	Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$l;
    //   63: aload_1
    //   64: invokeinterface 64 2 0
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +12 -> 83
    //   74: aload_3
    //   75: invokevirtual 70	android/graphics/Bitmap:isRecycled	()Z
    //   78: ifne +5 -> 83
    //   81: aload_3
    //   82: areturn
    //   83: aload_0
    //   84: aload_2
    //   85: invokestatic 75	com/tencent/mm/plugin/appbrand/appcache/ad:c	(Lcom/tencent/luggage/wxa/iu/d;Ljava/lang/String;)Ljava/io/InputStream;
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +98 -> 188
    //   93: aload_0
    //   94: invokevirtual 80	java/io/InputStream:available	()I
    //   97: ifgt +6 -> 103
    //   100: goto +88 -> 188
    //   103: aload_0
    //   104: invokestatic 85	com/tencent/luggage/wxa/qz/b:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +30 -> 139
    //   112: aload_2
    //   113: invokevirtual 70	android/graphics/Bitmap:isRecycled	()Z
    //   116: ifne +23 -> 139
    //   119: getstatic 18	com/tencent/mm/plugin/appbrand/page/r:a	Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$l;
    //   122: aload_1
    //   123: aload_2
    //   124: invokeinterface 88 3 0
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokestatic 91	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   137: aload_2
    //   138: areturn
    //   139: aload_0
    //   140: ifnull +36 -> 176
    //   143: aload_0
    //   144: invokestatic 91	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_1
    //   150: goto +28 -> 178
    //   153: astore_1
    //   154: ldc 93
    //   156: ldc 95
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_1
    //   165: aastore
    //   166: invokestatic 100	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: ifnull +6 -> 176
    //   173: goto -30 -> 143
    //   176: aconst_null
    //   177: areturn
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokestatic 91	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   186: aload_1
    //   187: athrow
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokestatic 91	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   196: aconst_null
    //   197: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramd	d
    //   0	198	1	paramString	String
    //   10	128	2	localObject	Object
    //   69	13	3	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   93	100	149	finally
    //   103	108	149	finally
    //   112	129	149	finally
    //   154	169	149	finally
    //   93	100	153	java/io/IOException
    //   103	108	153	java/io/IOException
    //   112	129	153	java/io/IOException
  }
  
  public static void a(d paramd)
  {
    if (paramd == null) {
      return;
    }
    paramd = b.b(paramd);
    if (paramd != null)
    {
      paramd = paramd.iterator();
      while (paramd.hasNext())
      {
        String str = (String)paramd.next();
        a.c(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */