package com.tencent.aelight.camera.ae.flashshow.util;

public class VideoVoiceEncoderUtil
{
  /* Error */
  @android.annotation.TargetApi(19)
  @androidx.annotation.Nullable
  public static java.lang.String a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc 19
    //   2: ldc 21
    //   4: invokestatic 27	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   14: astore_3
    //   15: aload_3
    //   16: ldc 32
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_2
    //   24: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 19
    //   30: aload_3
    //   31: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 27	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 29	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: ldc 42
    //   48: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: aload_1
    //   54: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 19
    //   60: aload_3
    //   61: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 27	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: new 29	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: getstatic 48	com/tencent/aelight/camera/ae/AEPath$CAMERA$FILES:c	Ljava/lang/String;
    //   79: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_3
    //   84: getstatic 53	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   95: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_3
    //   100: ldc 64
    //   102: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_3
    //   107: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_3
    //   111: new 29	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   118: astore 4
    //   120: aload 4
    //   122: aload_0
    //   123: getstatic 69	android/os/Environment:DIRECTORY_MUSIC	Ljava/lang/String;
    //   126: invokevirtual 75	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   129: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: ldc 80
    //   137: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   146: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 4
    //   152: ldc 64
    //   154: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 4
    //   160: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore_0
    //   164: aconst_null
    //   165: aconst_null
    //   166: iconst_0
    //   167: invokestatic 85	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   170: astore 4
    //   172: aload 4
    //   174: aload_0
    //   175: putfield 89	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	Ljava/lang/String;
    //   178: aload 4
    //   180: aload_1
    //   181: putfield 91	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:a	Ljava/lang/String;
    //   184: aload 4
    //   186: invokestatic 94	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;)I
    //   189: ifne +80 -> 269
    //   192: new 29	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   199: astore_1
    //   200: aload_1
    //   201: ldc 96
    //   203: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_1
    //   208: aload_0
    //   209: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 19
    //   215: aload_1
    //   216: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 27	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_2
    //   223: aload_0
    //   224: aload_3
    //   225: iconst_0
    //   226: invokestatic 102	com/tencent/mobileqq/editor/composite/step/HwVideoMerge:merge	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
    //   229: ifne +40 -> 269
    //   232: new 29	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   239: astore_1
    //   240: aload_1
    //   241: ldc 104
    //   243: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: aload_3
    //   249: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 19
    //   255: aload_1
    //   256: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 27	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: invokestatic 110	com/tencent/mobileqq/filemanager/util/FileUtil:e	(Ljava/lang/String;)Z
    //   266: pop
    //   267: aload_3
    //   268: areturn
    //   269: aload_0
    //   270: invokestatic 110	com/tencent/mobileqq/filemanager/util/FileUtil:e	(Ljava/lang/String;)Z
    //   273: pop
    //   274: goto +17 -> 291
    //   277: astore_1
    //   278: goto +22 -> 300
    //   281: astore_1
    //   282: ldc 19
    //   284: aload_1
    //   285: invokestatic 113	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto -19 -> 269
    //   291: ldc 19
    //   293: ldc 115
    //   295: invokestatic 27	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aconst_null
    //   299: areturn
    //   300: aload_0
    //   301: invokestatic 110	com/tencent/mobileqq/filemanager/util/FileUtil:e	(Ljava/lang/String;)Z
    //   304: pop
    //   305: goto +5 -> 310
    //   308: aload_1
    //   309: athrow
    //   310: goto -2 -> 308
    //   313: astore_0
    //   314: aload_3
    //   315: areturn
    //   316: astore_0
    //   317: goto -26 -> 291
    //   320: astore_0
    //   321: goto -16 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramContext	android.content.Context
    //   0	324	1	paramString1	java.lang.String
    //   0	324	2	paramString2	java.lang.String
    //   14	301	3	localObject1	Object
    //   118	67	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   164	262	277	finally
    //   282	288	277	finally
    //   164	262	281	java/lang/Exception
    //   262	267	313	java/lang/Exception
    //   269	274	316	java/lang/Exception
    //   300	305	320	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.util.VideoVoiceEncoderUtil
 * JD-Core Version:    0.7.0.1
 */