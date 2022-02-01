package com.google.android.filament;

class RenderTarget$Builder$BuilderFinalizer
{
  private final long mNativeObject;
  
  RenderTarget$Builder$BuilderFinalizer(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  /* Error */
  public void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	java/lang/Object:finalize	()V
    //   4: aload_0
    //   5: getfield 13	com/google/android/filament/RenderTarget$Builder$BuilderFinalizer:mNativeObject	J
    //   8: invokestatic 25	com/google/android/filament/RenderTarget:access$800	(J)J
    //   11: pop2
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 13	com/google/android/filament/RenderTarget$Builder$BuilderFinalizer:mNativeObject	J
    //   18: invokestatic 25	com/google/android/filament/RenderTarget:access$800	(J)J
    //   21: pop2
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 13	com/google/android/filament/RenderTarget$Builder$BuilderFinalizer:mNativeObject	J
    //   28: invokestatic 25	com/google/android/filament/RenderTarget:access$800	(J)J
    //   31: pop2
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	BuilderFinalizer
    //   13	1	1	localThrowable	java.lang.Throwable
    //   23	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	13	java/lang/Throwable
    //   0	4	23	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.RenderTarget.Builder.BuilderFinalizer
 * JD-Core Version:    0.7.0.1
 */