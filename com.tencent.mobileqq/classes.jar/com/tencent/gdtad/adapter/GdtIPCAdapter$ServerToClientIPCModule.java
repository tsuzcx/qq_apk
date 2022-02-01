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

final class GdtIPCAdapter$ServerToClientIPCModule
  extends QIPCModule
{
  private static volatile ServerToClientIPCModule a;
  
  private GdtIPCAdapter$ServerToClientIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ServerToClientIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ServerToClientIPCModule("gdt_ipc_module_server_to_client");
        }
      }
      finally {}
    }
    return a;
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    boolean bool;
    if (paramEIPCResult != null) {
      bool = paramEIPCResult.isSuccess();
    } else {
      bool = false;
    }
    GdtLog.b("GdtIPCAdapter", String.format("ServerToClientIPCModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = new AdIPCManager.Params(paramBundle);
    String str = paramBundle.getAction();
    int i = 0;
    GdtLog.b("GdtIPCAdapter", String.format("ServerToClientIPCModule.onCall action:%s to:%s", new Object[] { str, paramBundle.getToProcessName() }));
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!paramBundle.isValid()) {
      return null;
    }
    if (!TextUtils.equals(paramBundle.getAction(), paramString)) {
      return null;
    }
    if (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), paramBundle.getToProcessName())) {
      return null;
    }
    paramString = AdIPCManager.INSTANCE.getHandler(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = paramString.handle(paramBundle);
    paramBundle = new EIPCResult();
    if ((paramString == null) || (!paramString.success)) {
      i = -102;
    }
    paramBundle.code = i;
    if (paramString != null) {
      paramString = paramString.bundle;
    } else {
      paramString = null;
    }
    paramBundle.data = paramString;
    callbackResult(paramInt, paramBundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.ServerToClientIPCModule
 * JD-Core Version:    0.7.0.1
 */