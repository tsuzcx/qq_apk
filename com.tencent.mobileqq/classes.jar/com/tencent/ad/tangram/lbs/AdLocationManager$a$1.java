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
    if ((paramParams != null) && (!paramParams.booleanValue()) && (paramResult != null) && (paramResult.success) && (paramResult.bundle != null) && (paramResult.bundle.containsKey("LOCATION")))
    {
      paramParams = paramResult.bundle.getSerializable("LOCATION");
      if ((paramParams != null) && ((paramParams instanceof AdLocation)))
      {
        paramParams = (AdLocation)AdLocation.class.cast(paramParams);
        if (paramParams.isValid())
        {
          AdLocationManager.access$200(AdLocationManager.INSTANCE, paramParams);
          break label122;
        }
      }
    }
    paramParams = null;
    label122:
    AdLog.i("AdLocationManager", String.format("IPCHandler.onCallback result:%s", new Object[] { paramParams }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocationManager.a.1
 * JD-Core Version:    0.7.0.1
 */