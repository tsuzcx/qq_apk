package com.tencent.mobileqq.armap;

import android.os.Handler;
import android.os.Looper;

class NonMainProcAvatarLoader$3
  extends Handler
{
  NonMainProcAvatarLoader$3(NonMainProcAvatarLoader paramNonMainProcAvatarLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 26	android/os/Message:what	I
    //   4: sipush 1001
    //   7: if_icmpne +425 -> 432
    //   10: aload_1
    //   11: getfield 30	android/os/Message:obj	Ljava/lang/Object;
    //   14: checkcast 32	java/util/ArrayList
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull +413 -> 432
    //   22: aload_1
    //   23: invokevirtual 36	java/util/ArrayList:size	()I
    //   26: ifle +406 -> 432
    //   29: aload_1
    //   30: invokevirtual 40	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 46 1 0
    //   40: ifeq +392 -> 432
    //   43: aload_3
    //   44: invokeinterface 50 1 0
    //   49: checkcast 52	java/lang/String
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 10	com/tencent/mobileqq/armap/NonMainProcAvatarLoader$3:a	Lcom/tencent/mobileqq/armap/NonMainProcAvatarLoader;
    //   58: getfield 58	com/tencent/mobileqq/armap/NonMainProcAvatarLoader:b	Landroid/support/v4/util/LruCache;
    //   61: aload 4
    //   63: invokevirtual 64	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 52	java/lang/String
    //   69: astore 5
    //   71: aload 5
    //   73: invokestatic 70	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull -44 -> 34
    //   81: aload_0
    //   82: getfield 10	com/tencent/mobileqq/armap/NonMainProcAvatarLoader$3:a	Lcom/tencent/mobileqq/armap/NonMainProcAvatarLoader;
    //   85: invokestatic 73	com/tencent/mobileqq/armap/NonMainProcAvatarLoader:a	(Lcom/tencent/mobileqq/armap/NonMainProcAvatarLoader;)B
    //   88: iconst_1
    //   89: if_icmpne +96 -> 185
    //   92: aload_1
    //   93: aload_1
    //   94: invokevirtual 78	android/graphics/Bitmap:getWidth	()I
    //   97: invokestatic 83	com/tencent/mobileqq/utils/BaseImageUtil:a	(I)I
    //   100: bipush 50
    //   102: bipush 50
    //   104: invokestatic 88	com/tencent/mobileqq/avatar/utils/AvatarUtil:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: aconst_null
    //   111: iconst_0
    //   112: aconst_null
    //   113: invokestatic 94	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isNowThemeIsNight	(Lmqq/app/AppRuntime;ZLjava/lang/String;)Z
    //   116: ifeq +151 -> 267
    //   119: new 96	android/graphics/Paint
    //   122: dup
    //   123: invokespecial 99	android/graphics/Paint:<init>	()V
    //   126: astore_1
    //   127: aload_1
    //   128: iconst_1
    //   129: invokevirtual 103	android/graphics/Paint:setAntiAlias	(Z)V
    //   132: aload_1
    //   133: getstatic 106	com/tencent/mobileqq/vas/theme/api/ThemeUtil:NIGHTMODE_MASKCOLOR	I
    //   136: invokevirtual 110	android/graphics/Paint:setColor	(I)V
    //   139: new 112	android/graphics/Canvas
    //   142: dup
    //   143: aload_2
    //   144: invokespecial 115	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   147: astore 6
    //   149: aload 6
    //   151: new 117	android/graphics/RectF
    //   154: dup
    //   155: fconst_0
    //   156: fconst_0
    //   157: aload 6
    //   159: invokevirtual 118	android/graphics/Canvas:getWidth	()I
    //   162: i2f
    //   163: aload 6
    //   165: invokevirtual 121	android/graphics/Canvas:getHeight	()I
    //   168: i2f
    //   169: invokespecial 124	android/graphics/RectF:<init>	(FFFF)V
    //   172: ldc 125
    //   174: ldc 125
    //   176: aload_1
    //   177: invokevirtual 129	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   180: aload_2
    //   181: astore_1
    //   182: goto +85 -> 267
    //   185: aload_0
    //   186: getfield 10	com/tencent/mobileqq/armap/NonMainProcAvatarLoader$3:a	Lcom/tencent/mobileqq/armap/NonMainProcAvatarLoader;
    //   189: aload_1
    //   190: invokevirtual 132	com/tencent/mobileqq/armap/NonMainProcAvatarLoader:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   193: astore_2
    //   194: aload_2
    //   195: astore_1
    //   196: aconst_null
    //   197: iconst_0
    //   198: aconst_null
    //   199: invokestatic 94	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isNowThemeIsNight	(Lmqq/app/AppRuntime;ZLjava/lang/String;)Z
    //   202: ifeq +65 -> 267
    //   205: new 96	android/graphics/Paint
    //   208: dup
    //   209: invokespecial 99	android/graphics/Paint:<init>	()V
    //   212: astore_1
    //   213: aload_1
    //   214: iconst_1
    //   215: invokevirtual 103	android/graphics/Paint:setAntiAlias	(Z)V
    //   218: aload_1
    //   219: getstatic 106	com/tencent/mobileqq/vas/theme/api/ThemeUtil:NIGHTMODE_MASKCOLOR	I
    //   222: invokevirtual 110	android/graphics/Paint:setColor	(I)V
    //   225: new 112	android/graphics/Canvas
    //   228: dup
    //   229: aload_2
    //   230: invokespecial 115	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   233: astore 6
    //   235: aload 6
    //   237: aload 6
    //   239: invokevirtual 118	android/graphics/Canvas:getWidth	()I
    //   242: iconst_2
    //   243: idiv
    //   244: i2f
    //   245: aload 6
    //   247: invokevirtual 121	android/graphics/Canvas:getHeight	()I
    //   250: iconst_2
    //   251: idiv
    //   252: i2f
    //   253: aload 6
    //   255: invokevirtual 118	android/graphics/Canvas:getWidth	()I
    //   258: iconst_2
    //   259: idiv
    //   260: i2f
    //   261: aload_1
    //   262: invokevirtual 136	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   265: aload_2
    //   266: astore_1
    //   267: aload_1
    //   268: ifnull -234 -> 34
    //   271: invokestatic 140	android/os/Message:obtain	()Landroid/os/Message;
    //   274: astore_2
    //   275: new 142	android/os/Bundle
    //   278: dup
    //   279: invokespecial 143	android/os/Bundle:<init>	()V
    //   282: astore 6
    //   284: aload 6
    //   286: ldc 145
    //   288: aload_1
    //   289: invokevirtual 149	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   292: aload 6
    //   294: ldc 151
    //   296: aload 4
    //   298: invokevirtual 155	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 6
    //   303: ldc 157
    //   305: aload 5
    //   307: invokevirtual 155	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_2
    //   311: aload 6
    //   313: putfield 30	android/os/Message:obj	Ljava/lang/Object;
    //   316: aload_2
    //   317: sipush 1002
    //   320: putfield 26	android/os/Message:what	I
    //   323: aload_0
    //   324: getfield 10	com/tencent/mobileqq/armap/NonMainProcAvatarLoader$3:a	Lcom/tencent/mobileqq/armap/NonMainProcAvatarLoader;
    //   327: getfield 160	com/tencent/mobileqq/armap/NonMainProcAvatarLoader:a	Landroid/os/Handler;
    //   330: aload_2
    //   331: invokevirtual 164	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   334: pop
    //   335: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq -304 -> 34
    //   341: new 171	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   348: astore_1
    //   349: aload_1
    //   350: ldc 174
    //   352: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: aload 4
    //   359: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: ldc 180
    //   365: iconst_2
    //   366: aload_1
    //   367: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: goto -339 -> 34
    //   376: astore_1
    //   377: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +52 -> 432
    //   383: new 171	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   390: astore_2
    //   391: aload_2
    //   392: ldc 190
    //   394: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_2
    //   399: aload_1
    //   400: invokevirtual 191	java/lang/Exception:toString	()Ljava/lang/String;
    //   403: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 180
    //   409: iconst_2
    //   410: aload_2
    //   411: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: return
    //   418: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +11 -> 432
    //   424: ldc 180
    //   426: iconst_2
    //   427: ldc 196
    //   429: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: return
    //   433: astore_1
    //   434: goto -16 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	3
    //   0	437	1	paramMessage	android.os.Message
    //   107	304	2	localObject1	java.lang.Object
    //   33	11	3	localIterator	java.util.Iterator
    //   52	306	4	str1	java.lang.String
    //   69	237	5	str2	java.lang.String
    //   147	165	6	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   10	18	376	java/lang/Exception
    //   22	34	376	java/lang/Exception
    //   34	77	376	java/lang/Exception
    //   81	108	376	java/lang/Exception
    //   110	180	376	java/lang/Exception
    //   185	194	376	java/lang/Exception
    //   196	265	376	java/lang/Exception
    //   271	373	376	java/lang/Exception
    //   10	18	433	java/lang/OutOfMemoryError
    //   22	34	433	java/lang/OutOfMemoryError
    //   34	77	433	java/lang/OutOfMemoryError
    //   81	108	433	java/lang/OutOfMemoryError
    //   110	180	433	java/lang/OutOfMemoryError
    //   185	194	433	java/lang/OutOfMemoryError
    //   196	265	433	java/lang/OutOfMemoryError
    //   271	373	433	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainProcAvatarLoader.3
 * JD-Core Version:    0.7.0.1
 */