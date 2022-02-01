package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class PtvFilterUtils
{
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  public static final boolean a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static boolean b;
  private static boolean c;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 14) {
      bool = a("android.graphics.SurfaceTexture", "release", new Class[0]);
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
    b = false;
    c = false;
    jdField_a_of_type_ArrayOfInt = new int[2];
    jdField_a_of_type_JavaLangReflectMethod = null;
    try
    {
      jdField_a_of_type_JavaLangReflectMethod = HandlerThread.class.getDeclaredMethod("quitSafely", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static void a(int paramInt)
  {
    try
    {
      setBeautyKind(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("configure.txt");
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("configure file content:");
      paramString2.append(localStringBuilder.toString());
      QLog.d("PtvFilterUtils", 2, paramString2.toString());
    }
    FileUtils.writeFile(paramString1, localStringBuilder.toString());
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glFinish();
      return;
    }
    GLES20.glFlush();
  }
  
  private static boolean a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  private static native ByteBuffer allocate();
  
  public static native ByteBuffer allocateSharedMem(long paramLong);
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      setSupportBeauty(paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static native void copyMapData(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt);
  
  public static native Object getBitmapFromSharedMem(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int getGLFrameBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void getGLFrameBufferDataPBO(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void getGLFrameBufferDataPBOMap(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native long getNativePtrIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int getVideoFrameData(byte[] paramArrayOfByte);
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, ByteBuffer paramByteBuffer);
  
  private static native int realWriteData(AVIOStruct paramAVIOStruct);
  
  private static native void setBeautyKind(int paramInt);
  
  private static native void setEnableAsyncClipVideo(boolean paramBoolean);
  
  private static native void setSupportBeauty(boolean paramBoolean);
  
  private static native void setVideoClipThreadNum(int paramInt);
  
  private static native int writeSharedMemtoFile(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, AVIOStruct paramAVIOStruct, int paramInt5, boolean paramBoolean3, int paramInt6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils
 * JD-Core Version:    0.7.0.1
 */