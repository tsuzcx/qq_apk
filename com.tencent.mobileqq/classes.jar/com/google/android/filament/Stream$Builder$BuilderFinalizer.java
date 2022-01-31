package com.google.android.filament;

class Stream$Builder$BuilderFinalizer
{
  private final long mNativeObject;
  
  Stream$Builder$BuilderFinalizer(long paramLong)
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
    //   5: getfield 13	com/google/android/filament/Stream$Builder$BuilderFinalizer:mNativeObject	J
    //   8: invokestatic 24	com/google/android/filament/Stream:access$600	(J)V
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 13	com/google/android/filament/Stream$Builder$BuilderFinalizer:mNativeObject	J
    //   17: invokestatic 24	com/google/android/filament/Stream:access$600	(J)V
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 13	com/google/android/filament/Stream$Builder$BuilderFinalizer:mNativeObject	J
    //   26: invokestatic 24	com/google/android/filament/Stream:access$600	(J)V
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	BuilderFinalizer
    //   12	1	1	localThrowable	java.lang.Throwable
    //   21	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	12	java/lang/Throwable
    //   0	4	21	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Stream.Builder.BuilderFinalizer
 * JD-Core Version:    0.7.0.1
 */