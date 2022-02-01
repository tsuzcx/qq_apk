package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class BaseThumbDecoder
{
  protected static boolean checkBitmapValid(LocalMediaInfo paramLocalMediaInfo, Bitmap paramBitmap, int paramInt)
  {
    return (paramInt == 0) && (paramBitmap.getWidth() == paramLocalMediaInfo.thumbWidth) && (paramBitmap.getHeight() == paramLocalMediaInfo.thumbWidth) && (paramBitmap.getConfig() == Bitmap.Config.RGB_565);
  }
  
  /* Error */
  protected static Bitmap realDecodeBitmap(LocalMediaInfo paramLocalMediaInfo, android.graphics.BitmapFactory.Options paramOptions, java.lang.String paramString)
  {
    // Byte code:
    //   0: new 42	com/tencent/image/SafeBitmapFactory$SafeDecodeOption
    //   3: dup
    //   4: invokespecial 43	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: aload_1
    //   12: putfield 47	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:inOptions	Landroid/graphics/BitmapFactory$Options;
    //   15: aload 7
    //   17: iconst_1
    //   18: putfield 51	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:inNeedFlashBackTest	Z
    //   21: aload_0
    //   22: getfield 55	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   25: aload 7
    //   27: invokestatic 61	com/tencent/image/SafeBitmapFactory:safeDecode	(Ljava/lang/Object;Lcom/tencent/image/SafeBitmapFactory$SafeDecodeOption;)Landroid/graphics/Bitmap;
    //   30: astore_1
    //   31: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +31 -> 65
    //   37: aload_2
    //   38: iconst_2
    //   39: new 69	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   46: ldc 72
    //   48: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 7
    //   53: invokevirtual 80	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:toString	()Ljava/lang/String;
    //   56: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload 7
    //   67: getfield 88	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:isInJustDecodeBounds	Z
    //   70: ifne +74 -> 144
    //   73: aload 7
    //   75: getfield 91	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:needRegionDecode	Z
    //   78: ifeq +66 -> 144
    //   81: aload 7
    //   83: invokevirtual 95	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:getInfo	()Ljava/util/HashMap;
    //   86: astore_0
    //   87: aload_0
    //   88: ldc 97
    //   90: aload_2
    //   91: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: invokestatic 109	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   98: invokestatic 115	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   101: astore_2
    //   102: aload 7
    //   104: getfield 118	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:isGetBitmap	Z
    //   107: istore 4
    //   109: aload 7
    //   111: getfield 122	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:runTime	J
    //   114: lstore 5
    //   116: aload 7
    //   118: getfield 125	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:rawHeight	I
    //   121: istore_3
    //   122: aload_2
    //   123: aconst_null
    //   124: ldc 126
    //   126: iload 4
    //   128: lload 5
    //   130: aload 7
    //   132: getfield 129	com/tencent/image/SafeBitmapFactory$SafeDecodeOption:rawWidth	I
    //   135: iload_3
    //   136: imul
    //   137: i2l
    //   138: aload_0
    //   139: ldc 131
    //   141: invokevirtual 135	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   144: aload_1
    //   145: areturn
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_0
    //   150: invokevirtual 138	java/lang/OutOfMemoryError:printStackTrace	()V
    //   153: aload_1
    //   154: areturn
    //   155: astore_0
    //   156: goto -7 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramLocalMediaInfo	LocalMediaInfo
    //   0	159	1	paramOptions	android.graphics.BitmapFactory.Options
    //   0	159	2	paramString	java.lang.String
    //   121	16	3	i	int
    //   107	20	4	bool	boolean
    //   114	15	5	l	long
    //   7	124	7	localSafeDecodeOption	com.tencent.image.SafeBitmapFactory.SafeDecodeOption
    // Exception table:
    //   from	to	target	type
    //   0	31	146	java/lang/OutOfMemoryError
    //   31	65	155	java/lang/OutOfMemoryError
    //   65	144	155	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.BaseThumbDecoder
 * JD-Core Version:    0.7.0.1
 */