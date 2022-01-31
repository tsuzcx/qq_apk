package com.tencent.av.video.effect.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

public class CommonUtils
{
  public static final String TAG = "CommonUtils";
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.e("CommonUtils", "convertStreamToString", paramInputStream);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      Log.e("CommonUtils", "convertStreamToString", localIOException);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            Log.e("CommonUtils", "convertStreamToString", paramInputStream);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.e("CommonUtils", "convertStreamToString", paramInputStream);
        }
      }
    }
    finally {}
  }
  
  public static InputStream getInputStreamFromPath(Context paramContext, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.toLowerCase().startsWith("assets://")) {
          return paramContext.getAssets().open(paramString.substring("assets://".length()));
        }
        paramContext = new File(paramString);
        if ((paramContext != null) && (paramContext.exists()))
        {
          paramContext = new BufferedInputStream(new FileInputStream(paramContext));
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.e("CommonUtils", "getInputStreamFromPath", paramContext);
      if (0 != 0) {}
      try
      {
        throw new NullPointerException();
        return null;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          Log.e("CommonUtils", "getInputStreamFromPath", paramContext);
        }
      }
    }
    return null;
  }
  
  public static void glCheckError()
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      Log.e("CommonUtils", "glerror : " + i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.CommonUtils
 * JD-Core Version:    0.7.0.1
 */