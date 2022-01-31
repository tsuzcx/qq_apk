package com.tencent.ad.tangram.ipc;

import android.support.annotation.Keep;

@Keep
public abstract interface AdIPCManager$Handler
{
  public abstract AdIPCManager.Result receive(AdIPCManager.Params paramParams);
  
  public abstract AdIPCManager.Result send(AdIPCManager.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ipc.AdIPCManager.Handler
 * JD-Core Version:    0.7.0.1
 */