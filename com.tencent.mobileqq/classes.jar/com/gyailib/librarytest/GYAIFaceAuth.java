package com.gyailib.librarytest;

public class GYAIFaceAuth
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
    //   10: return
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 25	java/lang/Exception:printStackTrace	()V
    //   16: return
    //   17: astore_0
    //   18: aload_0
    //   19: athrow
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 26	java/lang/Error:printStackTrace	()V
    //   25: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	2	0	localException	java.lang.Exception
    //   17	2	0	localObject	Object
    //   20	2	0	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   0	10	11	java/lang/Exception
    //   0	10	17	finally
    //   12	16	17	finally
    //   21	25	17	finally
    //   0	10	20	java/lang/Error
  }
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int processAllJni(CrossTesterConfig paramCrossTesterConfig);
  
  public native int registerFaceLicenseTest(String paramString);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.librarytest.GYAIFaceAuth
 * JD-Core Version:    0.7.0.1
 */