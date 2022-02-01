package com.tencent.mobileqq.ar.utils;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class ShaderHelper
{
  public static int a(String paramString1, Context paramContext, int paramInt, String paramString2)
  {
    int i = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(i, paramString2);
    GLES20.glCompileShader(i);
    paramContext = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramContext, 0);
    paramInt = i;
    if (paramContext[0] == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("Error compiling shader: ");
      paramContext.append(GLES20.glGetShaderInfoLog(i));
      QLog.e(paramString1, 1, paramContext.toString());
      GLES20.glDeleteShader(i);
      paramInt = 0;
    }
    return paramInt;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      QLog.e(paramString1, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.ShaderHelper
 * JD-Core Version:    0.7.0.1
 */