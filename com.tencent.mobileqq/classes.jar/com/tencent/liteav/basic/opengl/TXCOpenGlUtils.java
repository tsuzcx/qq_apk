package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class TXCOpenGlUtils
{
  public static FloatBuffer a = a(f);
  public static FloatBuffer b = a(g);
  public static FloatBuffer c = a(h);
  public static FloatBuffer d = a(i);
  public static FloatBuffer e = a(j);
  private static float[] f = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static float[] g = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static float[] h = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private static float[] i = { 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private static float[] j = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private static int k = 2;
  
  public static final int a()
  {
    return k;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, (IntBuffer)null);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IntBuffer paramIntBuffer)
  {
    int m = c();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, paramIntBuffer);
    GLES20.glBindTexture(3553, 0);
    return m;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt4, 5121, null);
    return paramArrayOfInt[0];
  }
  
  public static int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    GLES30.glGenBuffers(1, paramArrayOfInt, 0);
    GLES30.glBindBuffer(35051, paramArrayOfInt[0]);
    GLES30.glBufferData(35051, paramInt1 * paramInt2 * 4, null, 35049);
    GLES30.glBindBuffer(35051, 0);
    return paramArrayOfInt[0];
  }
  
  public static int a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
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
    if (paramBoolean) {
      paramBitmap.recycle();
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
      TXCLog.w("Load Shader Failed", paramString.toString());
      return 0;
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int[] arrayOfInt = new int[1];
    int m = a(paramString1, 35633);
    if (m == 0)
    {
      TXCLog.w("Load Program", "Vertex Shader Failed");
      return 0;
    }
    int n = a(paramString2, 35632);
    if (n == 0)
    {
      TXCLog.w("Load Program", "Fragment Shader Failed");
      return 0;
    }
    int i1 = GLES20.glCreateProgram();
    GLES20.glAttachShader(i1, m);
    GLES20.glAttachShader(i1, n);
    GLES20.glLinkProgram(i1);
    GLES20.glGetProgramiv(i1, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      TXCLog.w("Load Program", "Linking Failed");
      return 0;
    }
    GLES20.glDeleteShader(m);
    GLES20.glDeleteShader(n);
    return i1;
  }
  
  public static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    if (paramInt3 == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, paramByteBuffer);
    }
    else
    {
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6408, 5121, paramByteBuffer);
      arrayOfInt[0] = paramInt3;
    }
    return arrayOfInt[0];
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
  
  public static void a(int paramInt)
  {
    k = paramInt;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    
    if ((paramObject instanceof ByteBuffer))
    {
      paramObject = (ByteBuffer)paramObject;
      paramObject.position(0);
      GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, paramObject);
      return;
    }
    GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, ByteBuffer.wrap((byte[])paramObject));
  }
  
  public static void a(e.a parama, int paramInt1, int paramInt2, Object paramObject)
  {
    if (parama == e.a.a)
    {
      a(0, 0, paramInt1, paramInt2, paramObject);
      return;
    }
    if (paramInt2 % 8 == 0)
    {
      a(0, 0, paramInt1, paramInt2 * 3 / 8, paramObject);
      return;
    }
    int m = (paramInt2 * 3 + 7) / 8;
    parama = ByteBuffer.allocateDirect(paramInt1 * m * 4);
    a(0, 0, paramInt1, m, parama);
    if ((paramObject instanceof ByteBuffer))
    {
      nativeCopyDataFromByteBufferToByteBuffer(parama, (ByteBuffer)paramObject, paramInt1 * paramInt2 * 3 / 2);
      return;
    }
    nativeCopyDataFromByteBufferToByteArray(parama, (byte[])paramObject, paramInt1 * paramInt2 * 3 / 2);
  }
  
  public static void a(String paramString)
  {
    int m = GLES20.glGetError();
    if (m != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError 0x");
      localStringBuilder.append(Integer.toHexString(m));
      TXCLog.e("OpenGlUtils", localStringBuilder.toString());
    }
  }
  
  public static void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramByteBuffer.isDirect())
    {
      nativeLoadYuv420ByteBufferToTextures(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramArrayOfInt);
      return;
    }
    nativeLoadYuv420ByteArrayToTextures(paramByteBuffer.array(), paramInt1, paramInt2, paramInt3, paramArrayOfInt);
  }
  
  public static int b()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    return arrayOfInt[0];
  }
  
  public static void b(int paramInt)
  {
    if (paramInt != -1) {
      GLES20.glDeleteFramebuffers(1, new int[] { paramInt }, 0);
    }
  }
  
  public static int c()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    return arrayOfInt[0];
  }
  
  public static void c(int paramInt)
  {
    if (paramInt != -1) {
      GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    }
  }
  
  public static int d()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public static void d(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, paramInt);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static Object e()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return EGL14.eglGetCurrentContext();
    }
    return ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
  }
  
  public static native void nativeCopyDataFromByteBufferToByteArray(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt);
  
  public static native void nativeCopyDataFromByteBufferToByteBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt);
  
  private static native void nativeLoadYuv420ByteArrayToTextures(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.TXCOpenGlUtils
 * JD-Core Version:    0.7.0.1
 */