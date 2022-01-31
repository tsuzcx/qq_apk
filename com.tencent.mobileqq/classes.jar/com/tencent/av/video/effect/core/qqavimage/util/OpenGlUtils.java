package com.tencent.av.video.effect.core.qqavimage.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.av.video.effect.core.ShaderManager;
import com.tencent.av.video.effect.utils.Log;
import java.nio.IntBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenGlUtils
{
  public static final float[] CUBE = CUBE16;
  public static final float[] CUBE1 = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] CUBE16;
  public static final float[] CUBE8 = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final int NO_TEXTURE = -1;
  private static final String TAG = "OpenGlUtils";
  private static int[] bufferId = null;
  
  static
  {
    CUBE16 = new float[] { -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public static boolean checkNeedCrypt(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  public static int loadProgram(String paramString1, String paramString2)
  {
    int[] arrayOfInt = new int[1];
    int i = loadShader(paramString1, 35633, checkNeedCrypt(paramString1));
    if (i == 0)
    {
      Log.d("OpenGlUtils", "Load Program: Vertex Shader Failed1");
      return 0;
    }
    int j = loadShader(paramString2, 35632, checkNeedCrypt(paramString2));
    if (j == 0)
    {
      Log.d("OpenGlUtils", "Load Program: Fragment Shader Failed2");
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      Log.d("OpenGlUtils", "Load Program: Linking Failed");
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  public static int loadShader(String paramString, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[1];
    int i = GLES20.glCreateShader(paramInt);
    if (i == 0)
    {
      Log.d("OpenGlUtils", "Load loadShader: shader == 0");
      return i;
    }
    if (paramBoolean) {
      try
      {
        paramInt = Integer.parseInt(paramString);
        if (paramInt == 0)
        {
          Log.d("OpenGlUtils", "Load loadShader: get shader source index fail");
          return 0;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.d("OpenGlUtils", "Load loadShader: " + paramString);
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      try
      {
        ShaderManager.nativeGLShaderSource(i, paramInt);
        GLES20.glCompileShader(i);
        GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
        if (arrayOfInt[0] != 0) {
          break;
        }
        Log.d("OpenGlUtils", "Load Program: Vertex Shader Failed1");
        return 0;
      }
      catch (Throwable paramString)
      {
        Log.e("OpenGlUtils", "Load loadShader: nativeGLShaderSource Exception e : " + paramString);
        return 0;
      }
      GLES20.glShaderSource(i, paramString);
    }
  }
  
  public static int loadTexture(Bitmap paramBitmap, int paramInt)
  {
    return loadTexture(paramBitmap, paramInt, true);
  }
  
  public static int loadTexture(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
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
    for (;;)
    {
      if (paramBoolean) {
        paramBitmap.recycle();
      }
      return arrayOfInt[0];
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int loadTexture(IntBuffer paramIntBuffer, Camera.Size paramSize, int paramInt)
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
      GLES20.glTexImage2D(3553, 0, 6408, paramSize.width, paramSize.height, 0, 6408, 5121, paramIntBuffer);
    }
    for (;;)
    {
      return arrayOfInt[0];
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramSize.width, paramSize.height, 6408, 5121, paramIntBuffer);
      arrayOfInt[0] = paramInt;
    }
  }
  
  public static int loadTextureAsBitmap(IntBuffer paramIntBuffer, Camera.Size paramSize, int paramInt)
  {
    return loadTexture(Bitmap.createBitmap(paramIntBuffer.array(), paramSize.width, paramSize.height, Bitmap.Config.ARGB_8888), paramInt);
  }
  
  public static int loadTextureWithClear(Bitmap paramBitmap, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    releaseTexture(paramInt);
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    return arrayOfInt[0];
  }
  
  public static void releaseTexture(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
  }
  
  public static float rnd(float paramFloat1, float paramFloat2)
  {
    return (float)Math.random() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils
 * JD-Core Version:    0.7.0.1
 */