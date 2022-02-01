package com.tencent.ad.tangram.lbs;

import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;

class AdLocationManager$a$1
  implements AdIPCManager.Callback
{
  AdLocationManager$a$1(AdLocationManager.a parama) {}
  
  public void onCallback(AdIPCManager.Params paramParams, AdIPCManager.Result paramResult)
  {
    paramParams = AdProcessManager.INSTANCE.isOnMainProcess();
    if (paramParams != null) {
      if (paramParams.booleanValue()) {
        paramParams = null;
      }
    }
    for (;;)
    {
      AdLog.i("AdLocationManager", String.format("IPCHandler.onCallback result:%s", new Object[] { paramParams }));
      return;
      if (paramResult == null)
      {
        paramParams = null;
      }
      else if (!paramResult.success)
      {
        paramParams = null;
      }
      else if (paramResult.bundle == null)
      {
        paramParams = null;
      }
      else if (!paramResult.bundle.containsKey("LOCATION"))
      {
        paramParams = null;
      }
      else
      {
        paramParams = paramResult.bundle.getSerializable("LOCATION");
        if (paramParams == null)
        {
          paramParams = null;
        }
        else if (!(paramParams instanceof AdLocation))
        {
          paramParams = null;
        }
        else
        {
          paramParams = (AdLocation)AdLocation.class.cast(paramParams);
          if (!paramParams.isValid())
          {
            paramParams = null;
          }
          else
          {
            AdLocationManager.access$200(AdLocationManager.INSTANCE, paramParams);
            continue;
            paramParams = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocationManager.a.1
 * JD-Core Version:    0.7.0.1
 */