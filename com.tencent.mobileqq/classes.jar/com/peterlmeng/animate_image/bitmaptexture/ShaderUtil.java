package com.peterlmeng.animate_image.bitmaptexture;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import com.peterlmeng.animate_image.support.log.LogUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShaderUtil
{
  private static final String TAG = "ShaderUtil";
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {
      return 0;
    }
    int j = loadShader(35632, paramString2);
    if (j == 0) {
      return 0;
    }
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        LogUtils.a("ShaderUtil", "link program error");
        GLES20.glDeleteProgram(k);
        return 0;
      }
    }
    return k;
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    paramInt = i;
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      paramString = new int[1];
      GLES20.glGetShaderiv(i, 35713, paramString, 0);
      paramInt = i;
      if (paramString[0] != 1)
      {
        LogUtils.a("ShaderUtil", "shader compile error");
        GLES20.glDeleteShader(i);
        paramInt = 0;
      }
    }
    return paramInt;
  }
  
  public static String readRawTxt(Context paramContext, int paramInt)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramContext.getResources().openRawResource(paramInt)));
    paramContext = new StringBuffer();
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
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.bitmaptexture.ShaderUtil
 * JD-Core Version:    0.7.0.1
 */