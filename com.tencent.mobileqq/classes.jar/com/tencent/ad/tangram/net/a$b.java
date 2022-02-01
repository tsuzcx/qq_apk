package com.tencent.ad.tangram.net;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;

final class a$b
  implements AdIPCManager.Handler
{
  static final String ACTION = "GET_IPV4";
  static final String KEY_IPV4_ADDRESS = "IPV4_ADDRESS";
  
  public a$b()
  {
    AdIPCManager.INSTANCE.register("GET_IPV4", this);
  }
  
  public a.a getCacheByIPC(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return null;
        Bundle localBundle = new Bundle();
        localBundle.putString("IPC_ACTION", "GET_IPV4");
        localBundle.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getMainProcessName());
        paramContext = AdIPCManager.INSTANCE.send(paramContext, new AdIPCManager.Params(localBundle));
      } while ((paramContext == null) || (!paramContext.success) || (paramContext.bundle == null) || (!paramContext.bundle.containsKey("IPV4_ADDRESS")));
      paramContext = paramContext.bundle.getSerializable("IPV4_ADDRESS");
    } while ((paramContext == null) || (!(paramContext instanceof a.a)));
    return (a.a)a.a.class.cast(paramContext);
  }
  
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    paramParams = AdProcessManager.INSTANCE.isOnMainProcess();
    if ((paramParams == null) || (!paramParams.booleanValue())) {
      return null;
    }
    paramParams = new Bundle();
    paramParams.putSerializable("IPV4_ADDRESS", a.access$000(a.INSTANCE));
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    localResult.success = true;
    localResult.bundle = paramParams;
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a.b
 * JD-Core Version:    0.7.0.1
 */