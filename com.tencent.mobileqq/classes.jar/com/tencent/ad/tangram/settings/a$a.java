package com.tencent.ad.tangram.settings;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import java.lang.ref.WeakReference;

final class a$a
  implements AdIPCManager.Handler
{
  static final String ACTION = "GET_SETTINGS";
  static final String KEY_SETTINGS = "SETTINGS";
  private WeakReference<Context> appContext;
  
  public a$a(WeakReference<Context> paramWeakReference)
  {
    this.appContext = paramWeakReference;
    AdIPCManager.INSTANCE.register("GET_SETTINGS", this);
  }
  
  public gdt_settings.Settings getCacheByIPC()
  {
    Object localObject;
    if (this.appContext.get() != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("IPC_ACTION", "GET_SETTINGS");
      ((Bundle)localObject).putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getMainProcessName());
      localObject = AdIPCManager.INSTANCE.send((Context)this.appContext.get(), new AdIPCManager.Params((Bundle)localObject));
      if ((localObject != null) && (((AdIPCManager.Result)localObject).success) && (((AdIPCManager.Result)localObject).bundle != null) && (((AdIPCManager.Result)localObject).bundle.containsKey("SETTINGS"))) {}
    }
    else
    {
      return null;
    }
    return b.toObject(((AdIPCManager.Result)localObject).bundle.getString("SETTINGS"));
  }
  
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    paramParams = AdProcessManager.INSTANCE.isOnMainProcess();
    if ((paramParams != null) && (paramParams.booleanValue()))
    {
      Object localObject = b.toString(AdSettingsManager.INSTANCE.getCache());
      paramParams = new Bundle();
      paramParams.putString("SETTINGS", (String)localObject);
      localObject = new AdIPCManager.Result();
      ((AdIPCManager.Result)localObject).success = true;
      ((AdIPCManager.Result)localObject).bundle = paramParams;
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.a.a
 * JD-Core Version:    0.7.0.1
 */