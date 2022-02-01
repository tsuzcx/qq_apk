package com.tencent.mobileqq.ar.utils;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class ShaderHelper
{
  public static int a(String paramString1, Context paramContext, int paramInt, String paramString2)
  {
    int i = 0;
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString2);
    GLES20.glCompileShader(paramInt);
    paramContext = new int[1];
    GLES20.glGetShaderiv(paramInt, 35713, paramContext, 0);
    if (paramContext[0] == 0)
    {
      QLog.e(paramString1, 1, "Error compiling shader: " + GLES20.glGetShaderInfoLog(paramInt));
      GLES20.glDeleteShader(paramInt);
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt == 0) {}
      return paramInt;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QLog.e(paramString1, 1, paramString2 + ": glError " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.ShaderHelper
 * JD-Core Version:    0.7.0.1
 */