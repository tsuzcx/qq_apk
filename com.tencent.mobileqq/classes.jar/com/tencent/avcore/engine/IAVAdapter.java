package com.tencent.avcore.engine;

import android.content.Context;
import com.tencent.avcore.util.AVNativeEventProcessor;

public abstract interface IAVAdapter
{
  public abstract Context getContext();
  
  public abstract AVNativeEventProcessor getNativeEventProcessor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.engine.IAVAdapter
 * JD-Core Version:    0.7.0.1
 */