package com.gyailib.library;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class GYAIFaceClassify
{
  private long nativePtr;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   5: ldc 22
    //   7: invokestatic 20	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   10: ldc 24
    //   12: invokestatic 20	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   15: ldc 26
    //   17: invokestatic 20	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   20: ldc 28
    //   22: invokestatic 20	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   25: ldc 30
    //   27: invokestatic 20	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   30: return
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 33	java/lang/Exception:printStackTrace	()V
    //   36: return
    //   37: astore_0
    //   38: aload_0
    //   39: athrow
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 34	java/lang/Error:printStackTrace	()V
    //   45: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	2	0	localException	java.lang.Exception
    //   37	2	0	localObject	Object
    //   40	2	0	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   0	30	31	java/lang/Exception
    //   0	30	37	finally
    //   32	36	37	finally
    //   41	45	37	finally
    //   0	30	40	java/lang/Error
  }
  
  public native int cleanupModelData();
  
  public native int forwardDetect(Bitmap paramBitmap, Rect paramRect, GYDetectCommonResultStruct paramGYDetectCommonResultStruct, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int initInstance(SDKDeviceConfig paramSDKDeviceConfig);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setupWithModel(SDKModelConfig paramSDKModelConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYAIFaceClassify
 * JD-Core Version:    0.7.0.1
 */