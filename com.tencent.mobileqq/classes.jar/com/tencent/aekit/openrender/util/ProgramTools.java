package com.tencent.aekit.openrender.util;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ProgramTools
{
  public static final int PER_FLOAT_BYTE = 4;
  private static final String TAG = "ProgramTools";
  
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vertex shader compile, failed computerShader: [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      Log.e(str, localStringBuilder.toString());
      Log.e(TAG, (String)localObject);
      if (AEOpenRenderConfig.isEnableLog())
      {
        if (paramString.length() >= 100) {
          i = paramString.length() - 100;
        } else {
          i = 0;
        }
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("vertex shader compile, failed computerShader substring(index) : [");
        localStringBuilder.append(paramString.substring(i));
        localStringBuilder.append("]");
        Log.e(str, localStringBuilder.toString());
        Log.e(TAG, (String)localObject);
      }
      return 0;
    }
    int j = GLES20.glCreateProgram();
    GLES20.glAttachShader(j, i);
    GLES20.glLinkProgram(j);
    GLES20.glGetProgramiv(j, 35714, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      GLES20.glDeleteProgram(j);
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("link program,failed:");
      ((StringBuilder)localObject).append(GLES20.glGetProgramInfoLog(j));
      Log.e(paramString, ((StringBuilder)localObject).toString());
      if (AEOpenRenderConfig.isEnableLog())
      {
        paramString = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("link program,failed:");
        ((StringBuilder)localObject).append(GLES20.glGetProgramInfoLog(j));
        Log.e(paramString, ((StringBuilder)localObject).toString());
      }
      return 0;
    }
    GLES20.glDeleteShader(i);
    return j;
  }
  
  public static ProgramTools.ProgramInfo createProgram(String paramString1, String paramString2)
  {
    int i = GLES20.glCreateShader(35633);
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glShaderSource(j, paramString2);
    Object localObject = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, (int[])localObject, 0);
    StringBuilder localStringBuilder;
    if (localObject[0] == 0)
    {
      paramString2 = GLES20.glGetShaderInfoLog(i);
      GLES20.glDeleteShader(i);
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vertex shader compile,failed vertexShader Code : ");
      localStringBuilder.append(paramString1);
      Log.e((String)localObject, localStringBuilder.toString());
      Log.e(TAG, paramString2);
      return null;
    }
    GLES20.glCompileShader(j);
    GLES20.glGetShaderiv(j, 35713, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      paramString1 = GLES20.glGetShaderInfoLog(j);
      GLES20.glDeleteShader(j);
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fragment shader compile,failed:");
      localStringBuilder.append(paramString2);
      Log.e((String)localObject, localStringBuilder.toString());
      Log.e(TAG, paramString1);
      return null;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      paramString1 = GLES20.glGetProgramInfoLog(k);
      GLES20.glDeleteProgram(k);
      paramString2 = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("link program,failed:");
      ((StringBuilder)localObject).append(paramString1);
      Log.e(paramString2, ((StringBuilder)localObject).toString());
      if (AEOpenRenderConfig.isEnableLog())
      {
        paramString2 = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("link program,failed:");
        ((StringBuilder)localObject).append(paramString1);
        Log.e(paramString2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
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
  
  /* Error */
  private static String readTextFile(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 156	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 162	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore_0
    //   9: new 164	java/io/BufferedReader
    //   12: dup
    //   13: new 166	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 169	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 172	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: new 52	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_2
    //   34: invokevirtual 175	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +20 -> 61
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: ldc 177
    //   54: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -25 -> 33
    //   61: aload_0
    //   62: invokevirtual 182	java/io/InputStream:close	()V
    //   65: aload_2
    //   66: invokevirtual 183	java/io/BufferedReader:close	()V
    //   69: goto +8 -> 77
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   77: aload_3
    //   78: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: areturn
    //   82: astore_3
    //   83: goto +25 -> 108
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   91: aload_0
    //   92: invokevirtual 182	java/io/InputStream:close	()V
    //   95: aload_2
    //   96: invokevirtual 183	java/io/BufferedReader:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: aload_0
    //   109: invokevirtual 182	java/io/InputStream:close	()V
    //   112: aload_2
    //   113: invokevirtual 183	java/io/BufferedReader:close	()V
    //   116: goto +8 -> 124
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   124: goto +5 -> 129
    //   127: aload_3
    //   128: athrow
    //   129: goto -2 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramContext	android.content.Context
    //   0	132	1	paramInt	int
    //   24	89	2	localBufferedReader	java.io.BufferedReader
    //   32	46	3	localStringBuilder	StringBuilder
    //   82	1	3	localObject	Object
    //   86	42	3	localException	java.lang.Exception
    //   37	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   61	69	72	java/io/IOException
    //   33	39	82	finally
    //   44	58	82	finally
    //   87	91	82	finally
    //   33	39	86	java/lang/Exception
    //   44	58	86	java/lang/Exception
    //   91	99	101	java/io/IOException
    //   108	116	119	java/io/IOException
  }
  
  @TargetApi(18)
  public static void setupSSBufferObject(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    paramInt3 *= 4;
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramInt3).order(ByteOrder.nativeOrder()).asFloatBuffer();
    if (paramArrayOfFloat != null) {
      localFloatBuffer.put(paramArrayOfFloat).position(0);
    }
    GLES31.glBindBuffer(37074, paramInt1);
    GLES31.glBufferData(37074, paramInt3, localFloatBuffer, 35044);
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vertex shader test compile failed, shader : [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      Log.e(str, localStringBuilder.toString());
      Log.e(TAG, (String)localObject);
      GLES20.glDeleteShader(paramInt);
      return false;
    }
    GLES20.glDeleteShader(paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.ProgramTools
 * JD-Core Version:    0.7.0.1
 */