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
import java.io.Serializable;
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
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    Object localObject = AdProcessManager.INSTANCE.isOnMainProcess();
    AdLocation localAdLocation = null;
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      localResult.success = true;
      localObject = AdLocationManager.access$100(AdLocationManager.INSTANCE);
      if (paramParams == null)
      {
        paramParams = (AdIPCManager.Params)localObject;
      }
      else if (paramParams.bundle == null)
      {
        paramParams = (AdIPCManager.Params)localObject;
      }
      else if (!paramParams.bundle.containsKey("LOCATION"))
      {
        paramParams = (AdIPCManager.Params)localObject;
      }
      else
      {
        paramParams = paramParams.bundle.getSerializable("LOCATION");
        if (paramParams == null)
        {
          paramParams = (AdIPCManager.Params)localObject;
        }
        else if (!(paramParams instanceof AdLocation))
        {
          paramParams = (AdIPCManager.Params)localObject;
        }
        else
        {
          localAdLocation = (AdLocation)AdLocation.class.cast(paramParams);
          paramParams = (AdIPCManager.Params)localObject;
        }
      }
    }
    else
    {
      paramParams = null;
    }
    localObject = AdLocation.merge(paramParams, localAdLocation);
    AdLocationManager.access$200(AdLocationManager.INSTANCE, (AdLocation)localObject);
    AdLog.i("AdLocationManager", String.format("IPCHandler.handle result:%s mainProcess:%s childProcess:%s", new Object[] { localObject, paramParams, localAdLocation }));
    if ((localObject != null) && (((AdLocation)localObject).isValid()))
    {
      paramParams = new Bundle();
      paramParams.putSerializable("LOCATION", (Serializable)localObject);
      localResult.bundle = paramParams;
    }
    return localResult;
  }
  
  public void updateCacheByIPC(Context paramContext, AdLocation paramAdLocation)
  {
    Object localObject = AdProcessManager.INSTANCE.isOnMainProcess();
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return;
      }
      if (paramContext == null) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocationManager.a
 * JD-Core Version:    0.7.0.1
 */