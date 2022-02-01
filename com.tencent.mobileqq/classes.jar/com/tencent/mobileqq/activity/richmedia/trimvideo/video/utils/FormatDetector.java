package com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils;

public class FormatDetector
{
  /* Error */
  public static int a(java.lang.String paramString)
  {
    // Byte code:
    //   0: getstatic 19	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 14
    //   5: if_icmplt +204 -> 209
    //   8: new 21	android/media/MediaMetadataRetriever
    //   11: dup
    //   12: invokespecial 22	android/media/MediaMetadataRetriever:<init>	()V
    //   15: astore_1
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 26	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: bipush 12
    //   24: invokevirtual 30	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   27: astore_0
    //   28: new 32	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   35: astore_2
    //   36: aload_2
    //   37: ldc 35
    //   39: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: aload_0
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 41
    //   51: iconst_1
    //   52: aload_2
    //   53: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +83 -> 146
    //   66: aload_0
    //   67: ldc 59
    //   69: invokevirtual 65	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifne +6 -> 78
    //   75: goto +71 -> 146
    //   78: aload_1
    //   79: bipush 17
    //   81: invokevirtual 30	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   84: astore_0
    //   85: new 32	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   92: astore_2
    //   93: aload_2
    //   94: ldc 67
    //   96: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc 41
    //   108: iconst_1
    //   109: aload_2
    //   110: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +12 -> 132
    //   123: aload_0
    //   124: ldc 69
    //   126: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   129: ifne +68 -> 197
    //   132: ldc 41
    //   134: iconst_1
    //   135: ldc 74
    //   137: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_1
    //   141: invokevirtual 80	android/media/MediaMetadataRetriever:release	()V
    //   144: iconst_m1
    //   145: ireturn
    //   146: new 32	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   153: astore_2
    //   154: aload_2
    //   155: ldc 82
    //   157: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: aload_0
    //   163: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 41
    //   169: iconst_1
    //   170: aload_2
    //   171: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_1
    //   178: invokevirtual 80	android/media/MediaMetadataRetriever:release	()V
    //   181: iconst_m1
    //   182: ireturn
    //   183: astore_0
    //   184: goto +19 -> 203
    //   187: astore_0
    //   188: ldc 41
    //   190: iconst_1
    //   191: ldc 84
    //   193: aload_0
    //   194: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_1
    //   198: invokevirtual 80	android/media/MediaMetadataRetriever:release	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: aload_1
    //   204: invokevirtual 80	android/media/MediaMetadataRetriever:release	()V
    //   207: aload_0
    //   208: athrow
    //   209: aload_0
    //   210: invokestatic 92	com/tencent/maxvideo/trim/TrimNative:detect	(Ljava/lang/String;)I
    //   213: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramString	java.lang.String
    //   15	189	1	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   35	136	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	75	183	finally
    //   78	132	183	finally
    //   132	140	183	finally
    //   146	177	183	finally
    //   188	197	183	finally
    //   16	75	187	java/lang/Exception
    //   78	132	187	java/lang/Exception
    //   132	140	187	java/lang/Exception
    //   146	177	187	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.FormatDetector
 * JD-Core Version:    0.7.0.1
 */