package com.gyailib.librarytest;

import android.graphics.Bitmap;
import com.gyailib.library.GYDetectCommonResultStruct;

public class GYAITestUtil
{
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 12
    //   2: invokestatic 18	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   5: ldc 20
    //   7: invokestatic 18	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   10: ldc 22
    //   12: invokestatic 18	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   15: return
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 25	java/lang/Exception:printStackTrace	()V
    //   21: return
    //   22: astore_0
    //   23: aload_0
    //   24: athrow
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 26	java/lang/Error:printStackTrace	()V
    //   30: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	2	0	localException	java.lang.Exception
    //   22	2	0	localObject	Object
    //   25	2	0	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   0	15	16	java/lang/Exception
    //   0	15	22	finally
    //   17	21	22	finally
    //   26	30	22	finally
    //   0	15	25	java/lang/Error
  }
  
  public static native double[][] compareDetectCommonResult(GYDetectCommonResultStruct paramGYDetectCommonResultStruct1, GYDetectCommonResultStruct paramGYDetectCommonResultStruct2);
  
  public static native float differChannel(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat);
  
  public static native float[] iou(Bitmap paramBitmap1, Bitmap paramBitmap2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.librarytest.GYAITestUtil
 * JD-Core Version:    0.7.0.1
 */