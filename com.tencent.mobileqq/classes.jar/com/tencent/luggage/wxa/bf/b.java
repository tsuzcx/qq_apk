package com.tencent.luggage.wxa.bf;

import android.opengl.GLES20;
import com.tencent.luggage.wxa.qz.o;

public class b
{
  public static int a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
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
      o.b("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(paramInt));
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
      o.b("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
      return 0;
    }
    int j = a(paramString2, 35632);
    if (j == 0)
    {
      o.b("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      o.b("MicroMsg.MMSightCameraGLUtil", "link program failed");
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  public static int b()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      o.b("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
      return 0;
    }
    return arrayOfInt[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bf.b
 * JD-Core Version:    0.7.0.1
 */