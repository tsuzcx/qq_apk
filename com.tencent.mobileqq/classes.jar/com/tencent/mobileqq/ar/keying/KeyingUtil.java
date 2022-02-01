package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class KeyingUtil
{
  public static final String a;
  public static final float[] a;
  public static String b;
  public static String c;
  public static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131706027);
    b = "    //抠像逻辑片段\n";
    c = "    //用户定义，抠像后逻辑片段\n";
    d = "}\n";
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
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
      paramString = new StringBuilder();
      paramString.append("Could not compile shader ");
      paramString.append(paramInt);
      paramString.append(":");
      paramString.append(GLES20.glGetShaderInfoLog(j));
      Log.e("KeyingUtil", paramString.toString());
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
    if (k == 0) {
      Log.e("KeyingUtil", "Could not create program");
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
      paramString1 = new StringBuilder();
      paramString1.append("Could not link program:");
      paramString1.append(GLES20.glGetProgramInfoLog(k));
      Log.e("KeyingUtil", paramString1.toString());
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (!QLog.isDevelopLevel()) {
              return "";
            }
            throw new IllegalArgumentException("invalid textureType!");
          }
          return "#define TEXTURE_TYPE_Y_UV\n";
        }
        return "#define TEXTURE_TYPE_Y_U_V\n";
      }
      return "#define TEXTURE_TYPE_SAMPLER2D\n";
    }
    return "#define TEXTURE_TYPE_OES\n";
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      int i = GLES20.glGetError();
      if (i != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(": glError 0x");
        localStringBuilder.append(Integer.toHexString(i));
        Log.e("KeyingUtil", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingUtil
 * JD-Core Version:    0.7.0.1
 */