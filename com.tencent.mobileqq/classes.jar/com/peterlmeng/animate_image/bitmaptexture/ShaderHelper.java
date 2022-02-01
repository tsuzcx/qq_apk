package com.peterlmeng.animate_image.bitmaptexture;

import android.opengl.GLES20;
import com.peterlmeng.animate_image.support.log.LogUtils;

public class ShaderHelper
{
  private static final String TAG = "ShaderHelper";
  
  public static int compileFragmentShader(String paramString)
  {
    return compileShader(35632, paramString);
  }
  
  private static int compileShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0)
    {
      LogUtils.e("ShaderHelper", "Could not create new shader.");
      return 0;
    }
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    int[] arrayOfInt = new int[1];
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Results of compiling source:\n");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n:");
    localStringBuilder.append(GLES20.glGetShaderInfoLog(paramInt));
    LogUtils.d("ShaderHelper", localStringBuilder.toString());
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteShader(paramInt);
      LogUtils.e("ShaderHelper", "Compilation of shader failed.");
      return 0;
    }
    return paramInt;
  }
  
  public static int compileVertexShader(String paramString)
  {
    return compileShader(35633, paramString);
  }
  
  public static int linkProgram(int paramInt1, int paramInt2)
  {
    int i = GLES20.glCreateProgram();
    if (i == 0)
    {
      LogUtils.e("ShaderHelper", "Could not create new program");
      return 0;
    }
    GLES20.glAttachShader(i, paramInt1);
    GLES20.glAttachShader(i, paramInt2);
    GLES20.glLinkProgram(i);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(i, 35714, arrayOfInt, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Results of linking program:\n");
    localStringBuilder.append(GLES20.glGetProgramInfoLog(i));
    LogUtils.d("ShaderHelper", localStringBuilder.toString());
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteProgram(i);
      LogUtils.e("ShaderHelper", "Linking of program failed.");
      return 0;
    }
    return i;
  }
  
  public static boolean validateProgram(int paramInt)
  {
    GLES20.glValidateProgram(paramInt);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(paramInt, 35715, arrayOfInt, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Results of validating program: ");
    localStringBuilder.append(arrayOfInt[0]);
    localStringBuilder.append("\nLog:");
    localStringBuilder.append(GLES20.glGetProgramInfoLog(paramInt));
    LogUtils.d("ShaderHelper", localStringBuilder.toString());
    return arrayOfInt[0] != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.bitmaptexture.ShaderHelper
 * JD-Core Version:    0.7.0.1
 */