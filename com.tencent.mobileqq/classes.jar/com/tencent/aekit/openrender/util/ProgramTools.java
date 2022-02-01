package com.tencent.aekit.openrender.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ProgramTools
{
  public static final int PER_FLOAT_BYTE = 4;
  private static final String TAG = ProgramTools.class.getSimpleName();
  
  public static int createComputeProgram(String paramString)
  {
    int i = GLES31.glCreateShader(37305);
    GLES20.glShaderSource(i, paramString);
    Object localObject = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      localObject = GLES20.glGetShaderInfoLog(i);
      GLES20.glDeleteShader(i);
      Log.e(TAG, "vertex shader compile, failed computerShader: [" + paramString + "]");
      Log.e(TAG, (String)localObject);
      if (AEOpenRenderConfig.isEnableLog())
      {
        if (paramString.length() < 100) {
          break label149;
        }
        i = paramString.length() - 100;
        Log.e(TAG, "vertex shader compile, failed computerShader substring(index) : [" + paramString.substring(i) + "]");
        Log.e(TAG, (String)localObject);
      }
    }
    label149:
    int j;
    do
    {
      return 0;
      i = 0;
      break;
      j = GLES20.glCreateProgram();
      GLES20.glAttachShader(j, i);
      GLES20.glLinkProgram(j);
      GLES20.glGetProgramiv(j, 35714, (int[])localObject, 0);
      if (localObject[0] != 0) {
        break label251;
      }
      GLES20.glDeleteProgram(j);
      Log.e(TAG, "link program,failed:" + GLES20.glGetProgramInfoLog(j));
    } while (!AEOpenRenderConfig.isEnableLog());
    Log.e(TAG, "link program,failed:" + GLES20.glGetProgramInfoLog(j));
    return 0;
    label251:
    GLES20.glDeleteShader(i);
    return j;
  }
  
  public static ProgramTools.ProgramInfo createProgram(String paramString1, String paramString2)
  {
    int i = GLES20.glCreateShader(35633);
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glShaderSource(j, paramString2);
    int[] arrayOfInt = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      paramString2 = GLES20.glGetShaderInfoLog(i);
      GLES20.glDeleteShader(i);
      Log.e(TAG, "vertex shader compile,failed vertexShader Code : " + paramString1);
      Log.e(TAG, paramString2);
    }
    int k;
    do
    {
      return null;
      GLES20.glCompileShader(j);
      GLES20.glGetShaderiv(j, 35713, arrayOfInt, 0);
      if (arrayOfInt[0] == 0)
      {
        paramString1 = GLES20.glGetShaderInfoLog(j);
        GLES20.glDeleteShader(j);
        Log.e(TAG, "fragment shader compile,failed:" + paramString2);
        Log.e(TAG, paramString1);
        return null;
      }
      k = GLES20.glCreateProgram();
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
      if (arrayOfInt[0] != 0) {
        break;
      }
      paramString1 = GLES20.glGetProgramInfoLog(k);
      GLES20.glDeleteProgram(k);
      Log.e(TAG, "link program,failed:" + paramString1);
    } while (!AEOpenRenderConfig.isEnableLog());
    Log.e(TAG, "link program,failed:" + paramString1);
    return null;
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return new ProgramTools.ProgramInfo(k, i, j);
  }
  
  public static void createTexture(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, null);
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    return paramInt;
  }
  
  public static void mallocTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
  }
  
  private static String readTextFile(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().openRawResource(paramInt);
    localBufferedReader = new BufferedReader(new InputStreamReader(paramContext));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      try
      {
        paramContext.close();
        localBufferedReader.close();
        throw localObject;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      for (;;)
      {
        try
        {
          paramContext.close();
          localBufferedReader.close();
          return null;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        try
        {
          paramContext.close();
          localBufferedReader.close();
          return localException.toString();
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  @TargetApi(18)
  public static void setupSSBufferObject(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramInt3 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    if (paramArrayOfFloat != null) {
      localFloatBuffer.put(paramArrayOfFloat).position(0);
    }
    GLES31.glBindBuffer(37074, paramInt1);
    GLES31.glBufferData(37074, paramInt3 * 4, localFloatBuffer, 35044);
    GLES31.glBindBufferBase(37074, paramInt2, paramInt1);
  }
  
  public static boolean testCompileShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    Object localObject = new int[1];
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      localObject = GLES20.glGetShaderInfoLog(paramInt);
      GLES20.glDeleteShader(paramInt);
      Log.e(TAG, "vertex shader test compile failed, shader : [" + paramString + "]");
      Log.e(TAG, (String)localObject);
      GLES20.glDeleteShader(paramInt);
      return false;
    }
    GLES20.glDeleteShader(paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.ProgramTools
 * JD-Core Version:    0.7.0.1
 */