package com.tencent.av.video.effect.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class CommonUtils
{
  public static final String TAG = "CommonUtils";
  
  /* Error */
  public static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 19	java/io/BufferedReader
    //   3: dup
    //   4: new 21	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 24	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 27	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 29	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 34	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +40 -> 70
    //   33: new 29	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: ldc 40
    //   53: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: aload 4
    //   60: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: goto -43 -> 24
    //   70: aload_0
    //   71: invokevirtual 48	java/io/InputStream:close	()V
    //   74: goto +32 -> 106
    //   77: astore_0
    //   78: ldc 8
    //   80: ldc 49
    //   82: aload_0
    //   83: invokestatic 55	com/tencent/av/video/effect/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: goto +20 -> 106
    //   89: astore_1
    //   90: goto +21 -> 111
    //   93: astore_2
    //   94: ldc 8
    //   96: ldc 49
    //   98: aload_2
    //   99: invokestatic 55	com/tencent/av/video/effect/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_0
    //   103: invokevirtual 48	java/io/InputStream:close	()V
    //   106: aload_1
    //   107: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: areturn
    //   111: aload_0
    //   112: invokevirtual 48	java/io/InputStream:close	()V
    //   115: goto +12 -> 127
    //   118: astore_0
    //   119: ldc 8
    //   121: ldc 49
    //   123: aload_0
    //   124: invokestatic 55	com/tencent/av/video/effect/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto +5 -> 132
    //   130: aload_1
    //   131: athrow
    //   132: goto -2 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramInputStream	InputStream
    //   23	35	1	localStringBuilder1	StringBuilder
    //   89	42	1	localObject	Object
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   93	6	2	localIOException	java.io.IOException
    //   28	17	3	str	String
    //   40	19	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	74	77	java/io/IOException
    //   102	106	77	java/io/IOException
    //   24	29	89	finally
    //   33	67	89	finally
    //   94	102	89	finally
    //   24	29	93	java/io/IOException
    //   33	67	93	java/io/IOException
    //   111	115	118	java/io/IOException
  }
  
  public static InputStream getInputStreamFromPath(Context paramContext, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.toLowerCase().startsWith("assets://")) {
          return paramContext.getAssets().open(paramString.substring(9));
        }
        paramContext = new File(paramString);
        if (paramContext.exists())
        {
          paramContext = new BufferedInputStream(new FileInputStream(paramContext));
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.e("CommonUtils", "getInputStreamFromPath", paramContext);
    }
    return null;
  }
  
  public static void glCheckError()
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("glerror : ");
      localStringBuilder.append(i);
      Log.e("CommonUtils", localStringBuilder.toString());
    }
  }
  
  public static int initFrameBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return arrayOfInt[0];
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.CommonUtils
 * JD-Core Version:    0.7.0.1
 */