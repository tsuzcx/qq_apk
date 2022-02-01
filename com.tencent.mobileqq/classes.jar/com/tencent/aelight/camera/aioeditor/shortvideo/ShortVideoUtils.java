package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import java.io.File;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static int[] a = { 1, 97, 125 };
  
  /* Error */
  public static long a(String paramString)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 28	java/io/File:exists	()Z
    //   11: istore_2
    //   12: ldc2_w 29
    //   15: lstore 5
    //   17: iload_2
    //   18: ifne +56 -> 74
    //   21: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +46 -> 70
    //   27: new 37	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 7
    //   38: ldc 40
    //   40: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 7
    //   46: aload_0
    //   47: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: ldc 46
    //   55: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 48
    //   61: iconst_2
    //   62: aload 7
    //   64: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: ldc2_w 29
    //   73: lreturn
    //   74: new 58	android/media/MediaPlayer
    //   77: dup
    //   78: invokespecial 59	android/media/MediaPlayer:<init>	()V
    //   81: astore 7
    //   83: aload 7
    //   85: aload_0
    //   86: invokevirtual 62	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   89: aload 7
    //   91: invokevirtual 65	android/media/MediaPlayer:prepare	()V
    //   94: aload 7
    //   96: invokevirtual 69	android/media/MediaPlayer:getDuration	()I
    //   99: istore_1
    //   100: iload_1
    //   101: i2l
    //   102: lstore_3
    //   103: aload 7
    //   105: invokevirtual 72	android/media/MediaPlayer:release	()V
    //   108: lload_3
    //   109: lreturn
    //   110: astore_0
    //   111: goto +32 -> 143
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   119: lload 5
    //   121: lstore_3
    //   122: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq -22 -> 103
    //   128: ldc 48
    //   130: iconst_2
    //   131: ldc 76
    //   133: aload_0
    //   134: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: lload 5
    //   139: lstore_3
    //   140: goto -37 -> 103
    //   143: aload 7
    //   145: invokevirtual 72	android/media/MediaPlayer:release	()V
    //   148: goto +5 -> 153
    //   151: aload_0
    //   152: athrow
    //   153: goto -2 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   99	2	1	i	int
    //   11	7	2	bool	boolean
    //   102	38	3	l1	long
    //   15	123	5	l2	long
    //   34	110	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   83	100	110	finally
    //   115	119	110	finally
    //   122	137	110	finally
    //   83	100	114	java/lang/Exception
  }
  
  public static String a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = paramFile.getName();
    StringBuilder localStringBuilder = new StringBuilder(PathUtils.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append("_local");
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QIM视频");
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */