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
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import eipc.EIPCResult;

public final class GdtIPCAdapter$ClientToServerIPCAsyncModule
  extends QIPCModule
{
  private static volatile ClientToServerIPCAsyncModule a;
  
  private GdtIPCAdapter$ClientToServerIPCAsyncModule(String paramString)
  {
    super(paramString);
  }
  
  public static ClientToServerIPCAsyncModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ClientToServerIPCAsyncModule("gdt_ipc_async_module_client_to_server");
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
    GdtLog.b("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
    String str = localParams.getAction();
    int i = 0;
    GdtLog.b("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCall action:%s to:%s", new Object[] { str, localParams.getToProcessName() }));
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!localParams.isValid()) {
      return null;
    }
    if (!TextUtils.equals(localParams.getAction(), paramString)) {
      return null;
    }
    str = AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext());
    paramString = AdIPCManager.INSTANCE.getHandler(paramString);
    if (TextUtils.equals(str, localParams.getToProcessName()))
    {
      if (paramString == null) {
        return null;
      }
      paramString = paramString.handle(localParams);
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
    QIPCServerHelper.getInstance().callClient(localParams.getToProcessName(), "gdt_ipc_module_server_to_client", localParams.getAction(), paramBundle, new GdtIPCAdapter.ClientToServerIPCAsyncModule.1(this, localParams, paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.ClientToServerIPCAsyncModule
 * JD-Core Version:    0.7.0.1
 */