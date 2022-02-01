package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.qav.log.AVLog;

public class OpenGlUtils
{
  public static int a(Bitmap paramBitmap, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    if (paramInt == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    else
    {
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
    return arrayOfInt[0];
  }
  
  public static int a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      paramString = new StringBuilder();
      paramString.append("Compilation\n");
      paramString.append(GLES20.glGetShaderInfoLog(paramInt));
      AVLog.a("OpenGlUtils", paramString.toString());
      return 0;
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int[] arrayOfInt = new int[1];
    int i = a(paramString1, 35633);
    if (i == 0)
    {
      AVLog.a("OpenGlUtils", "Vertex Shader Failed");
      return 0;
    }
    int j = a(paramString2, 35632);
    if (j == 0)
    {
      AVLog.a("OpenGlUtils", "Fragment Shader Failed");
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      AVLog.a("OpenGlUtils", "Linking Failed");
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.OpenGlUtils
 * JD-Core Version:    0.7.0.1
 */