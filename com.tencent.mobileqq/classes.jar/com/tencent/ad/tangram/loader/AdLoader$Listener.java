package com.tencent.ad.tangram.loader;

import android.support.annotation.Keep;
import android.support.annotation.MainThread;

@Keep
public abstract interface AdLoader$Listener
{
  @MainThread
  public abstract void onResponse(AdLoader.Session paramSession);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader.Listener
 * JD-Core Version:    0.7.0.1
 */