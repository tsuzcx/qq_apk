package com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenGLUtils
{
  public static final float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] b = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] c = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  
  public static int a(String paramString1, String paramString2)
  {
    int i = GLES20.glCreateShader(35633);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glCompileShader(i);
    paramString1 = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString1, 0);
    if (paramString1[0] == 1)
    {
      int j = GLES20.glCreateShader(35632);
      GLES20.glShaderSource(j, paramString2);
      GLES20.glCompileShader(j);
      GLES20.glGetShaderiv(j, 35713, paramString1, 0);
      if (paramString1[0] == 1)
      {
        int k = GLES20.glCreateProgram();
        GLES20.glAttachShader(k, i);
        GLES20.glAttachShader(k, j);
        GLES20.glLinkProgram(k);
        GLES20.glGetProgramiv(k, 35714, paramString1, 0);
        if (paramString1[0] == 1)
        {
          GLES20.glDeleteShader(i);
          GLES20.glDeleteShader(j);
          return k;
        }
        paramString1 = new StringBuilder();
        paramString1.append("link program:");
        paramString1.append(GLES20.glGetProgramInfoLog(k));
        throw new IllegalStateException(paramString1.toString());
      }
      paramString1 = new StringBuilder();
      paramString1.append("load fragment shader:");
      paramString1.append(GLES20.glGetShaderInfoLog(i));
      throw new IllegalStateException(paramString1.toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append("load vertex shader:");
    paramString1.append(GLES20.glGetShaderInfoLog(i));
    throw new IllegalStateException(paramString1.toString());
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramContext.getResources().openRawResource(paramInt)));
    paramContext = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        paramContext.append(str);
        paramContext.append("\n");
      }
      return paramContext.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      try
      {
        localBufferedReader.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.OpenGLUtils
 * JD-Core Version:    0.7.0.1
 */