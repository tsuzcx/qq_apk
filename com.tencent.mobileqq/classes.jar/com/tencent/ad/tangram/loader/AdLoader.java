package com.tencent.ad.tangram.loader;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdLoader
{
  private static final String TAG = "AdLoader";
  
  public static void load(AdLoader.Session paramSession, WeakReference<AdLoader.Listener> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new AdLoader.1(paramSession, paramWeakReference), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader
 * JD-Core Version:    0.7.0.1
 */