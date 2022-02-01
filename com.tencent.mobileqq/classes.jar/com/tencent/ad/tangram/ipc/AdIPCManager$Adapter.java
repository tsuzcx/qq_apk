package com.tencent.ad.tangram.ipc;

import android.content.Context;
import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdIPCManager$Adapter
{
  public abstract AdIPCManager.Handler getHandler(String paramString);
  
  public abstract void init(Context paramContext);
  
  public abstract boolean register(String paramString, AdIPCManager.Handler paramHandler);
  
  public abstract AdIPCManager.Result send(Context paramContext, AdIPCManager.Params paramParams);
  
  public abstract void send(Context paramContext, AdIPCManager.Params paramParams, WeakReference<AdIPCManager.Callback> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.ipc.AdIPCManager.Adapter
 * JD-Core Version:    0.7.0.1
 */