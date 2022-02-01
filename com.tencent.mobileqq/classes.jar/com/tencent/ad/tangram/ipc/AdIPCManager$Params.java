package com.tencent.ad.tangram.ipc;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;

@Keep
public final class AdIPCManager$Params
{
  public static final String KEY_ACTION = "IPC_ACTION";
  public static final String KEY_TO_PROCESS_NAME = "IPC_TO_PROCESS_NAME";
  public Bundle bundle;
  
  public AdIPCManager$Params(Bundle paramBundle)
  {
    this.bundle = paramBundle;
  }
  
  public String getAction()
  {
    if (this.bundle != null) {
      return this.bundle.getString("IPC_ACTION");
    }
    return null;
  }
  
  public String getToProcessName()
  {
    if (this.bundle != null) {
      return this.bundle.getString("IPC_TO_PROCESS_NAME");
    }
    return null;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(getAction())) && (!TextUtils.isEmpty(getToProcessName()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.ipc.AdIPCManager.Params
 * JD-Core Version:    0.7.0.1
 */