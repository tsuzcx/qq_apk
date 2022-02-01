package com.tencent.ad.tangram.lbs;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import java.lang.ref.WeakReference;

final class AdLocationManager$a
  implements AdIPCManager.Handler
{
  static final String ACTION = "GET_LBS_CACHE";
  static final String KEY_LOCATION = "LOCATION";
  private AdIPCManager.Callback ipcCallback = new AdLocationManager.a.1(this);
  
  public AdLocationManager$a()
  {
    AdIPCManager.INSTANCE.register("GET_LBS_CACHE", this);
  }
  
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    Object localObject3 = null;
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    Object localObject1 = AdProcessManager.INSTANCE.isOnMainProcess();
    Object localObject2;
    if (localObject1 != null) {
      if (!((Boolean)localObject1).booleanValue())
      {
        localObject1 = null;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      paramParams = AdLocation.merge((AdLocation)localObject1, (AdLocation)localObject2);
      AdLocationManager.access$200(AdLocationManager.INSTANCE, paramParams);
      AdLog.i("AdLocationManager", String.format("IPCHandler.handle result:%s mainProcess:%s childProcess:%s", new Object[] { paramParams, localObject1, localObject2 }));
      if ((paramParams != null) && (paramParams.isValid()))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putSerializable("LOCATION", paramParams);
        localResult.bundle = ((Bundle)localObject1);
      }
      return localResult;
      localResult.success = true;
      AdLocation localAdLocation = AdLocationManager.access$100(AdLocationManager.INSTANCE);
      localObject2 = localObject3;
      localObject1 = localAdLocation;
      if (paramParams != null)
      {
        localObject2 = localObject3;
        localObject1 = localAdLocation;
        if (paramParams.bundle != null)
        {
          localObject2 = localObject3;
          localObject1 = localAdLocation;
          if (paramParams.bundle.containsKey("LOCATION"))
          {
            paramParams = paramParams.bundle.getSerializable("LOCATION");
            localObject2 = localObject3;
            localObject1 = localAdLocation;
            if (paramParams != null)
            {
              localObject2 = localObject3;
              localObject1 = localAdLocation;
              if ((paramParams instanceof AdLocation))
              {
                localObject2 = (AdLocation)AdLocation.class.cast(paramParams);
                localObject1 = localAdLocation;
                continue;
                localObject1 = null;
                localObject2 = localObject3;
              }
            }
          }
        }
      }
    }
  }
  
  public void updateCacheByIPC(Context paramContext, AdLocation paramAdLocation)
  {
    Object localObject = AdProcessManager.INSTANCE.isOnMainProcess();
    if ((localObject == null) || (((Boolean)localObject).booleanValue())) {}
    while (paramContext == null) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("IPC_ACTION", "GET_LBS_CACHE");
    ((Bundle)localObject).putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getMainProcessName());
    if ((paramAdLocation != null) && (paramAdLocation.isValid())) {
      ((Bundle)localObject).putSerializable("LOCATION", paramAdLocation);
    }
    AdIPCManager.INSTANCE.send(paramContext, new AdIPCManager.Params((Bundle)localObject), new WeakReference(this.ipcCallback));
    AdLog.i("AdLocationManager", String.format("IPCHandler.updateCacheByIPC childProcess:%s", new Object[] { paramAdLocation }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocationManager.a
 * JD-Core Version:    0.7.0.1
 */