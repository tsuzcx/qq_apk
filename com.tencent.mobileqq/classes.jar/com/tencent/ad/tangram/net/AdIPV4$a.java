package com.tencent.ad.tangram.net;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;

final class AdIPV4$a
  implements AdIPCManager.Handler
{
  static final String ACTION = "GET_IPV4";
  static final String KEY_IPV4_ADDRESS = "IPV4_ADDRESS";
  
  public AdIPV4$a()
  {
    AdIPCManager.INSTANCE.register("GET_IPV4", this);
  }
  
  public AdIPV4.Address getCacheByIPC(Context paramContext)
  {
    if (paramContext != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("IPC_ACTION", "GET_IPV4");
      localBundle.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getMainProcessName());
      paramContext = AdIPCManager.INSTANCE.send(paramContext, new AdIPCManager.Params(localBundle));
      if ((paramContext != null) && (paramContext.success) && (paramContext.bundle != null) && (paramContext.bundle.containsKey("IPV4_ADDRESS")))
      {
        paramContext = paramContext.bundle.getSerializable("IPV4_ADDRESS");
        if ((paramContext != null) && ((paramContext instanceof AdIPV4.Address))) {
          break label119;
        }
      }
    }
    return null;
    label119:
    return (AdIPV4.Address)AdIPV4.Address.class.cast(paramContext);
  }
  
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    paramParams = AdProcessManager.INSTANCE.isOnMainProcess();
    if ((paramParams != null) && (paramParams.booleanValue()))
    {
      paramParams = new Bundle();
      paramParams.putSerializable("IPV4_ADDRESS", AdIPV4.access$000(AdIPV4.INSTANCE));
      AdIPCManager.Result localResult = new AdIPCManager.Result();
      localResult.success = true;
      localResult.bundle = paramParams;
      return localResult;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdIPV4.a
 * JD-Core Version:    0.7.0.1
 */