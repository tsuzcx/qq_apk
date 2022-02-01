package com.tencent.mobileqq.activity.contact.newfriend.poke;

import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class NewFriendNotifyPokeMsgHelper$3$1
  implements ImageAssetDelegate
{
  NewFriendNotifyPokeMsgHelper$3$1(NewFriendNotifyPokeMsgHelper.3 param3) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 12	com/tencent/mobileqq/activity/contact/newfriend/poke/NewFriendNotifyPokeMsgHelper$3$1:a	Lcom/tencent/mobileqq/activity/contact/newfriend/poke/NewFriendNotifyPokeMsgHelper$3;
    //   6: getfield 28	com/tencent/mobileqq/activity/contact/newfriend/poke/NewFriendNotifyPokeMsgHelper$3:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: new 36	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: getfield 12	com/tencent/mobileqq/activity/contact/newfriend/poke/NewFriendNotifyPokeMsgHelper$3$1:a	Lcom/tencent/mobileqq/activity/contact/newfriend/poke/NewFriendNotifyPokeMsgHelper$3;
    //   23: getfield 40	com/tencent/mobileqq/activity/contact/newfriend/poke/NewFriendNotifyPokeMsgHelper$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 50	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   33: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokevirtual 59	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: new 61	android/graphics/BitmapFactory$Options
    //   50: dup
    //   51: invokespecial 62	android/graphics/BitmapFactory$Options:<init>	()V
    //   54: astore_3
    //   55: aload_2
    //   56: astore_1
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 66	android/graphics/BitmapFactory$Options:inScaled	Z
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: aconst_null
    //   66: checkcast 68	android/graphics/Rect
    //   69: aload_3
    //   70: invokestatic 74	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: invokevirtual 79	java/io/InputStream:close	()V
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 79	java/io/InputStream:close	()V
    //   88: aload_3
    //   89: areturn
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: ldc 81
    //   97: iconst_0
    //   98: ldc 83
    //   100: aload_3
    //   101: checkcast 23	java/lang/Exception
    //   104: invokestatic 89	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 79	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 79	java/io/InputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_3
    //   130: areturn
    //   131: astore_1
    //   132: goto -17 -> 115
    //   135: astore_2
    //   136: goto -10 -> 126
    //   139: astore_3
    //   140: aload_1
    //   141: astore_2
    //   142: aload_3
    //   143: astore_1
    //   144: goto -26 -> 118
    //   147: astore_3
    //   148: goto -55 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	1
    //   0	151	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   1	122	2	localLottieImageAsset1	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   135	1	2	localException	java.lang.Exception
    //   141	1	2	localLottieImageAsset2	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   54	35	3	localObject1	Object
    //   90	40	3	localThrowable1	java.lang.Throwable
    //   139	4	3	localObject2	Object
    //   147	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	43	90	java/lang/Throwable
    //   2	43	117	finally
    //   84	88	128	java/lang/Exception
    //   111	115	131	java/lang/Exception
    //   122	126	135	java/lang/Exception
    //   47	55	139	finally
    //   57	62	139	finally
    //   64	74	139	finally
    //   76	80	139	finally
    //   95	107	139	finally
    //   47	55	147	java/lang/Throwable
    //   57	62	147	java/lang/Throwable
    //   64	74	147	java/lang/Throwable
    //   76	80	147	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper.3.1
 * JD-Core Version:    0.7.0.1
 */