package com.tencent.mobileqq.ar;

public abstract interface ARNativeBridge$ActionCallback
{
  public static final int ACTION_ANIM_END_ERROR = 0;
  public static final int ACTION_ANIM_END_SUCCESSFULLY = 1;
  public static final int ACTION_ANIM_INTERRUPTED = 2;
  
  public abstract void callback(int paramInt1, String paramString1, int paramInt2, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback
 * JD-Core Version:    0.7.0.1
 */