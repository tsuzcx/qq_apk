package com.tencent.gdtad.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public final class GdtIPCAdapter$ClientToServerIPCSyncModule
  extends QIPCModule
{
  private static volatile ClientToServerIPCSyncModule a;
  
  private GdtIPCAdapter$ClientToServerIPCSyncModule(String paramString)
  {
    super(paramString);
  }
  
  public static ClientToServerIPCSyncModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ClientToServerIPCSyncModule("gdt_ipc_sync_module_client_to_server");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = new AdIPCManager.Params(paramBundle);
    paramBundle = ((AdIPCManager.Params)localObject1).getAction();
    paramInt = 0;
    GdtLog.b("GdtIPCAdapter", String.format("ClientToServerIPCSyncModule.onCall action:%s to:%s", new Object[] { paramBundle, ((AdIPCManager.Params)localObject1).getToProcessName() }));
    boolean bool = TextUtils.isEmpty(paramString);
    paramBundle = null;
    if (bool) {
      return null;
    }
    if (!((AdIPCManager.Params)localObject1).isValid()) {
      return null;
    }
    if (!TextUtils.equals(((AdIPCManager.Params)localObject1).getAction(), paramString)) {
      return null;
    }
    Object localObject2 = AdProcessManager.INSTANCE.isOnMainProcess();
    if (localObject2 != null)
    {
      if (!((Boolean)localObject2).booleanValue()) {
        return null;
      }
      if (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), ((AdIPCManager.Params)localObject1).getToProcessName())) {
        return null;
      }
      paramString = AdIPCManager.INSTANCE.getHandler(paramString);
      if (paramString == null) {
        return null;
      }
      localObject2 = paramString.handle((AdIPCManager.Params)localObject1);
      localObject1 = new EIPCResult();
      if ((localObject2 == null) || (!((AdIPCManager.Result)localObject2).success)) {
        paramInt = -102;
      }
      ((EIPCResult)localObject1).code = paramInt;
      paramString = paramBundle;
      if (localObject2 != null) {
        paramString = ((AdIPCManager.Result)localObject2).bundle;
      }
      ((EIPCResult)localObject1).data = paramString;
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.ClientToServerIPCSyncModule
 * JD-Core Version:    0.7.0.1
 */