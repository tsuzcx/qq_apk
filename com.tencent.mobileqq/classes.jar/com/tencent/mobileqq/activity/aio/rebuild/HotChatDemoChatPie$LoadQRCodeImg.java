package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class HotChatDemoChatPie$LoadQRCodeImg
  implements Runnable
{
  private WeakReference<MqqHandler> a;
  private final String b;
  private final int c;
  private final int d;
  private final int e;
  
  public HotChatDemoChatPie$LoadQRCodeImg(String paramString, MqqHandler paramMqqHandler, int paramInt)
  {
    this(paramString, paramMqqHandler, paramInt, 2, 0);
  }
  
  public HotChatDemoChatPie$LoadQRCodeImg(String paramString, MqqHandler paramMqqHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramString;
    this.c = paramInt1;
    this.a = new WeakReference(paramMqqHandler);
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  /* Error */
  private Bitmap a(String paramString, Resources paramResources)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 6
    //   11: aload 6
    //   13: astore_3
    //   14: aload 7
    //   16: astore 4
    //   18: aload 8
    //   20: astore 5
    //   22: new 48	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   29: astore 9
    //   31: aload 6
    //   33: astore_3
    //   34: aload 7
    //   36: astore 4
    //   38: aload 8
    //   40: astore 5
    //   42: aload 9
    //   44: getstatic 54	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_PATH	Ljava/lang/String;
    //   47: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 6
    //   53: astore_3
    //   54: aload 7
    //   56: astore 4
    //   58: aload 8
    //   60: astore 5
    //   62: aload 9
    //   64: aload_1
    //   65: invokevirtual 64	java/lang/String:getBytes	()[B
    //   68: invokestatic 70	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   71: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: astore_3
    //   78: aload 7
    //   80: astore 4
    //   82: aload 8
    //   84: astore 5
    //   86: aload 9
    //   88: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 9
    //   93: aload 6
    //   95: astore_3
    //   96: aload 7
    //   98: astore 4
    //   100: aload 8
    //   102: astore 5
    //   104: invokestatic 80	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   107: ifeq +83 -> 190
    //   110: aload 6
    //   112: astore_3
    //   113: aload 7
    //   115: astore 4
    //   117: aload 8
    //   119: astore 5
    //   121: new 48	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   128: astore 10
    //   130: aload 6
    //   132: astore_3
    //   133: aload 7
    //   135: astore 4
    //   137: aload 8
    //   139: astore 5
    //   141: aload 10
    //   143: ldc 82
    //   145: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: astore_3
    //   152: aload 7
    //   154: astore 4
    //   156: aload 8
    //   158: astore 5
    //   160: aload 10
    //   162: aload 9
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 6
    //   170: astore_3
    //   171: aload 7
    //   173: astore 4
    //   175: aload 8
    //   177: astore 5
    //   179: ldc 84
    //   181: iconst_4
    //   182: aload 10
    //   184: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload 6
    //   192: astore_3
    //   193: aload 7
    //   195: astore 4
    //   197: aload 8
    //   199: astore 5
    //   201: new 90	java/io/File
    //   204: dup
    //   205: aload 9
    //   207: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: astore 10
    //   212: aload 6
    //   214: astore_3
    //   215: aload 7
    //   217: astore 4
    //   219: aload 8
    //   221: astore 5
    //   223: aload 10
    //   225: invokevirtual 96	java/io/File:exists	()Z
    //   228: ifne +79 -> 307
    //   231: aload 6
    //   233: astore_3
    //   234: aload 7
    //   236: astore 4
    //   238: aload 8
    //   240: astore 5
    //   242: aload_1
    //   243: aload_2
    //   244: aload_0
    //   245: getfield 28	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:c	I
    //   248: iconst_0
    //   249: iconst_1
    //   250: invokestatic 101	com/tencent/mobileqq/troopshare/TroopShareUtility:a	(Ljava/lang/String;Landroid/content/res/Resources;IIZ)Landroid/graphics/Bitmap;
    //   253: astore_2
    //   254: aload_2
    //   255: astore_3
    //   256: aload_2
    //   257: astore 4
    //   259: aload_2
    //   260: astore 5
    //   262: aload_2
    //   263: aload 10
    //   265: invokestatic 106	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   268: pop
    //   269: aload_2
    //   270: astore_3
    //   271: aload_2
    //   272: astore 4
    //   274: aload_2
    //   275: astore_1
    //   276: aload_2
    //   277: astore 5
    //   279: aload_0
    //   280: getfield 37	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:d	I
    //   283: iconst_1
    //   284: if_icmpne +124 -> 408
    //   287: aload_2
    //   288: astore_3
    //   289: aload_2
    //   290: astore 4
    //   292: aload_2
    //   293: astore 5
    //   295: aload_2
    //   296: aload_0
    //   297: getfield 39	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:e	I
    //   300: invokestatic 109	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   303: astore_1
    //   304: goto +104 -> 408
    //   307: aload 6
    //   309: astore_3
    //   310: aload 7
    //   312: astore 4
    //   314: aload 8
    //   316: astore 5
    //   318: aload 9
    //   320: invokestatic 115	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   323: astore_2
    //   324: aload_2
    //   325: astore_3
    //   326: aload_2
    //   327: astore 4
    //   329: aload_2
    //   330: astore_1
    //   331: aload_2
    //   332: astore 5
    //   334: aload_0
    //   335: getfield 37	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:d	I
    //   338: iconst_1
    //   339: if_icmpne +69 -> 408
    //   342: aload_2
    //   343: astore_3
    //   344: aload_2
    //   345: astore 4
    //   347: aload_2
    //   348: astore 5
    //   350: aload_2
    //   351: aload_0
    //   352: getfield 39	com/tencent/mobileqq/activity/aio/rebuild/HotChatDemoChatPie$LoadQRCodeImg:e	I
    //   355: invokestatic 109	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   358: astore_1
    //   359: goto +49 -> 408
    //   362: astore_1
    //   363: goto +41 -> 404
    //   366: astore_2
    //   367: aload_3
    //   368: astore_1
    //   369: invokestatic 80	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   372: ifeq +36 -> 408
    //   375: aload_2
    //   376: invokevirtual 118	java/lang/Error:printStackTrace	()V
    //   379: aload_3
    //   380: astore_1
    //   381: goto +27 -> 408
    //   384: astore_2
    //   385: aload 4
    //   387: astore_1
    //   388: invokestatic 80	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   391: ifeq +17 -> 408
    //   394: aload_2
    //   395: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   398: aload 4
    //   400: astore_1
    //   401: goto +7 -> 408
    //   404: aload_0
    //   405: monitorexit
    //   406: aload_1
    //   407: athrow
    //   408: aload_0
    //   409: monitorexit
    //   410: aload_1
    //   411: areturn
    //   412: astore_1
    //   413: aload 5
    //   415: astore_1
    //   416: goto -8 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	LoadQRCodeImg
    //   0	419	1	paramString	String
    //   0	419	2	paramResources	Resources
    //   13	367	3	localObject1	Object
    //   16	383	4	localObject2	Object
    //   20	394	5	localObject3	Object
    //   9	299	6	localObject4	Object
    //   3	308	7	localObject5	Object
    //   6	309	8	localObject6	Object
    //   29	290	9	localObject7	Object
    //   128	136	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	362	finally
    //   42	51	362	finally
    //   62	75	362	finally
    //   86	93	362	finally
    //   104	110	362	finally
    //   121	130	362	finally
    //   141	149	362	finally
    //   160	168	362	finally
    //   179	190	362	finally
    //   201	212	362	finally
    //   223	231	362	finally
    //   242	254	362	finally
    //   262	269	362	finally
    //   279	287	362	finally
    //   295	304	362	finally
    //   318	324	362	finally
    //   334	342	362	finally
    //   350	359	362	finally
    //   369	379	362	finally
    //   388	398	362	finally
    //   22	31	366	java/lang/Error
    //   42	51	366	java/lang/Error
    //   62	75	366	java/lang/Error
    //   86	93	366	java/lang/Error
    //   104	110	366	java/lang/Error
    //   121	130	366	java/lang/Error
    //   141	149	366	java/lang/Error
    //   160	168	366	java/lang/Error
    //   179	190	366	java/lang/Error
    //   201	212	366	java/lang/Error
    //   223	231	366	java/lang/Error
    //   242	254	366	java/lang/Error
    //   262	269	366	java/lang/Error
    //   279	287	366	java/lang/Error
    //   295	304	366	java/lang/Error
    //   318	324	366	java/lang/Error
    //   334	342	366	java/lang/Error
    //   350	359	366	java/lang/Error
    //   22	31	384	java/lang/Exception
    //   42	51	384	java/lang/Exception
    //   62	75	384	java/lang/Exception
    //   86	93	384	java/lang/Exception
    //   104	110	384	java/lang/Exception
    //   121	130	384	java/lang/Exception
    //   141	149	384	java/lang/Exception
    //   160	168	384	java/lang/Exception
    //   179	190	384	java/lang/Exception
    //   201	212	384	java/lang/Exception
    //   223	231	384	java/lang/Exception
    //   242	254	384	java/lang/Exception
    //   262	269	384	java/lang/Exception
    //   279	287	384	java/lang/Exception
    //   295	304	384	java/lang/Exception
    //   318	324	384	java/lang/Exception
    //   334	342	384	java/lang/Exception
    //   350	359	384	java/lang/Exception
    //   22	31	412	java/lang/OutOfMemoryError
    //   42	51	412	java/lang/OutOfMemoryError
    //   62	75	412	java/lang/OutOfMemoryError
    //   86	93	412	java/lang/OutOfMemoryError
    //   104	110	412	java/lang/OutOfMemoryError
    //   121	130	412	java/lang/OutOfMemoryError
    //   141	149	412	java/lang/OutOfMemoryError
    //   160	168	412	java/lang/OutOfMemoryError
    //   179	190	412	java/lang/OutOfMemoryError
    //   201	212	412	java/lang/OutOfMemoryError
    //   223	231	412	java/lang/OutOfMemoryError
    //   242	254	412	java/lang/OutOfMemoryError
    //   262	269	412	java/lang/OutOfMemoryError
    //   279	287	412	java/lang/OutOfMemoryError
    //   295	304	412	java/lang/OutOfMemoryError
    //   318	324	412	java/lang/OutOfMemoryError
    //   334	342	412	java/lang/OutOfMemoryError
    //   350	359	412	java/lang/OutOfMemoryError
  }
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getContext().getResources();
    Object localObject2 = a(this.b, (Resources)localObject1);
    if (localObject2 != null) {
      localObject1 = new BitmapDrawable((Resources)localObject1, (Bitmap)localObject2);
    } else {
      localObject1 = null;
    }
    localObject2 = (MqqHandler)this.a.get();
    if (localObject2 != null) {
      ((MqqHandler)localObject2).obtainMessage(34, this.d, 0, localObject1).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie.LoadQRCodeImg
 * JD-Core Version:    0.7.0.1
 */