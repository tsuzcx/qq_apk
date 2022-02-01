package com.hiar.sdk.utils;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static int a(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("Could not compile shader ");
        paramString.append(paramInt);
        paramString.append(":");
        paramString.append(GLES20.glGetShaderInfoLog(j));
        QLog.e("GlUtil", 2, paramString.toString());
      }
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {
      return 0;
    }
    int j = a(35632, paramString2);
    if (j == 0) {
      return 0;
    }
    int k = GLES20.glCreateProgram();
    a("glCreateProgram");
    if ((k == 0) && (QLog.isColorLevel())) {
      QLog.e("GlUtil", 2, "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    a("glAttachShader");
    GLES20.glAttachShader(k, j);
    a("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("Could not link program:");
        paramString1.append(GLES20.glGetProgramInfoLog(k));
        QLog.e("GlUtil", 2, paramString1.toString());
      }
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError 0x");
      localStringBuilder.append(Integer.toHexString(i));
      paramString = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.e("GlUtil", 2, paramString);
      }
      throw new RuntimeException(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.hiar.sdk.utils.GlUtil
 * JD-Core Version:    0.7.0.1
 */