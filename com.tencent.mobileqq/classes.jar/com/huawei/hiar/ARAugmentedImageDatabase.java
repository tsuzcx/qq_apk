package com.huawei.hiar;

public class ARAugmentedImageDatabase
{
  static final String TAG = ARAugmentedImageDatabase.class.getSimpleName();
  long mNativeDatabaseHandle;
  private final ARSession mSession;
  
  ARAugmentedImageDatabase(ARSession paramARSession, long paramLong)
  {
    this.mSession = paramARSession;
    this.mNativeDatabaseHandle = paramLong;
  }
  
  private static native void nativeDestroy(long paramLong);
  
  protected void finalize()
  {
    if (this.mNativeDatabaseHandle != 0L) {
      nativeDestroy(this.mNativeDatabaseHandle);
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARAugmentedImageDatabase
 * JD-Core Version:    0.7.0.1
 */