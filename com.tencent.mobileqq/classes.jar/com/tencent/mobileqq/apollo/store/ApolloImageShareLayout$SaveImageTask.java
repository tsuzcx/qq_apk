package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class ApolloImageShareLayout$SaveImageTask
  implements Runnable
{
  WeakReference<ApolloImageShareLayout> a;
  private final int b;
  private final WeakReference<Bitmap> c;
  
  ApolloImageShareLayout$SaveImageTask(ApolloImageShareLayout paramApolloImageShareLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.a = new WeakReference(paramApolloImageShareLayout);
    this.b = paramInt3;
    this.c = new WeakReference(paramBitmap);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout$SaveImageTask:a	Ljava/lang/ref/WeakReference;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +247 -> 253
    //   9: aload_0
    //   10: getfield 29	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout$SaveImageTask:c	Ljava/lang/ref/WeakReference;
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: invokevirtual 39	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   21: checkcast 41	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +227 -> 253
    //   29: aload_1
    //   30: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   33: ifnull +220 -> 253
    //   36: aload_1
    //   37: getfield 47	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:b	Lcom/tencent/util/WeakReferenceHandler;
    //   40: ifnonnull +4 -> 44
    //   43: return
    //   44: aload_0
    //   45: getfield 29	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout$SaveImageTask:c	Ljava/lang/ref/WeakReference;
    //   48: invokevirtual 39	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   51: checkcast 49	android/graphics/Bitmap
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +144 -> 200
    //   59: aload_1
    //   60: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   63: iconst_1
    //   64: invokevirtual 55	android/widget/RelativeLayout:buildDrawingCache	(Z)V
    //   67: aload_1
    //   68: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   71: invokevirtual 59	android/widget/RelativeLayout:getWidth	()I
    //   74: aload_1
    //   75: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   78: invokevirtual 62	android/widget/RelativeLayout:getHeight	()I
    //   81: getstatic 68	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   84: invokestatic 72	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +93 -> 182
    //   92: new 74	android/graphics/Canvas
    //   95: dup
    //   96: aload_3
    //   97: invokespecial 77	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   100: astore 4
    //   102: aload_1
    //   103: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   106: invokevirtual 81	android/widget/RelativeLayout:getDrawingCache	()Landroid/graphics/Bitmap;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +13 -> 126
    //   116: aload 4
    //   118: aload 5
    //   120: fconst_0
    //   121: fconst_0
    //   122: aconst_null
    //   123: invokevirtual 85	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   126: aload 4
    //   128: aload_2
    //   129: aload_1
    //   130: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   133: invokevirtual 59	android/widget/RelativeLayout:getWidth	()I
    //   136: aload_2
    //   137: invokevirtual 86	android/graphics/Bitmap:getWidth	()I
    //   140: isub
    //   141: iconst_2
    //   142: idiv
    //   143: i2f
    //   144: aload_1
    //   145: invokestatic 89	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:b	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)I
    //   148: i2f
    //   149: aconst_null
    //   150: invokevirtual 85	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   153: aload_3
    //   154: invokestatic 94	com/tencent/biz/common/util/ImageUtil:a	(Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   157: astore_2
    //   158: aload_1
    //   159: getfield 47	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:b	Lcom/tencent/util/WeakReferenceHandler;
    //   162: aload_0
    //   163: getfield 27	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout$SaveImageTask:b	I
    //   166: invokevirtual 100	com/tencent/util/WeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   169: astore_3
    //   170: aload_3
    //   171: aload_2
    //   172: putfield 106	android/os/Message:obj	Ljava/lang/Object;
    //   175: aload_3
    //   176: invokevirtual 109	android/os/Message:sendToTarget	()V
    //   179: goto +11 -> 190
    //   182: ldc 111
    //   184: iconst_2
    //   185: ldc 113
    //   187: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_1
    //   191: invokestatic 44	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	(Lcom/tencent/mobileqq/apollo/store/ApolloImageShareLayout;)Landroid/widget/RelativeLayout;
    //   194: invokevirtual 122	android/widget/RelativeLayout:destroyDrawingCache	()V
    //   197: goto +43 -> 240
    //   200: ldc 111
    //   202: iconst_2
    //   203: ldc 124
    //   205: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: goto +32 -> 240
    //   211: astore_2
    //   212: goto +34 -> 246
    //   215: astore_2
    //   216: ldc 111
    //   218: iconst_2
    //   219: aload_2
    //   220: invokevirtual 128	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   223: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto +14 -> 240
    //   229: astore_2
    //   230: ldc 111
    //   232: iconst_2
    //   233: aload_2
    //   234: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   237: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_1
    //   241: iconst_0
    //   242: putfield 132	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	Z
    //   245: return
    //   246: aload_1
    //   247: iconst_0
    //   248: putfield 132	com/tencent/mobileqq/apollo/store/ApolloImageShareLayout:a	Z
    //   251: aload_2
    //   252: athrow
    //   253: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	SaveImageTask
    //   4	243	1	localObject1	Object
    //   54	118	2	localObject2	Object
    //   211	1	2	localObject3	Object
    //   215	5	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   229	23	2	localException	java.lang.Exception
    //   87	89	3	localObject4	Object
    //   100	27	4	localCanvas	android.graphics.Canvas
    //   109	10	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   44	55	211	finally
    //   59	88	211	finally
    //   92	111	211	finally
    //   116	126	211	finally
    //   126	179	211	finally
    //   182	190	211	finally
    //   190	197	211	finally
    //   200	208	211	finally
    //   216	226	211	finally
    //   230	240	211	finally
    //   44	55	215	java/lang/OutOfMemoryError
    //   59	88	215	java/lang/OutOfMemoryError
    //   92	111	215	java/lang/OutOfMemoryError
    //   116	126	215	java/lang/OutOfMemoryError
    //   126	179	215	java/lang/OutOfMemoryError
    //   182	190	215	java/lang/OutOfMemoryError
    //   190	197	215	java/lang/OutOfMemoryError
    //   200	208	215	java/lang/OutOfMemoryError
    //   44	55	229	java/lang/Exception
    //   59	88	229	java/lang/Exception
    //   92	111	229	java/lang/Exception
    //   116	126	229	java/lang/Exception
    //   126	179	229	java/lang/Exception
    //   182	190	229	java/lang/Exception
    //   190	197	229	java/lang/Exception
    //   200	208	229	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageShareLayout.SaveImageTask
 * JD-Core Version:    0.7.0.1
 */