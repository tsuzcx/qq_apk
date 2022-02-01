package com.google.android.filament;

public class SwapChain
{
  public static final long CONFIG_DEFAULT = 0L;
  public static final long CONFIG_READABLE = 2L;
  public static final long CONFIG_TRANSPARENT = 1L;
  private long mNativeObject;
  private final Object mSurface;
  
  SwapChain(long paramLong, Object paramObject)
  {
    this.mNativeObject = paramLong;
    this.mSurface = paramObject;
  }
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed SwapChain");
    }
    return this.mNativeObject;
  }
  
  public Object getNativeWindow()
  {
    return this.mSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.SwapChain
 * JD-Core Version:    0.7.0.1
 */