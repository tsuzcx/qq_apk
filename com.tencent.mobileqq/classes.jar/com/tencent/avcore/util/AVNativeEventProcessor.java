package com.tencent.avcore.util;

import android.os.Handler.Callback;

public abstract interface AVNativeEventProcessor
  extends Handler.Callback
{
  public abstract boolean isMsgNeedExtraDeal(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.AVNativeEventProcessor
 * JD-Core Version:    0.7.0.1
 */