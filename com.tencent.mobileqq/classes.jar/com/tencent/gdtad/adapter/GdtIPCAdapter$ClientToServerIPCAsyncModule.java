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
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ClientToServerIPCAsyncModule("gdt_ipc_async_module_client_to_server");
      }
      return a;
    }
    finally {}
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null) {}
    for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
    {
      GdtLog.b("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
      super.callbackResult(paramInt, paramEIPCResult);
      return;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
    String str1;
    String str2;
    if (localParams != null)
    {
      str1 = localParams.getAction();
      if (localParams == null) {
        break label73;
      }
      str2 = localParams.getToProcessName();
      label34:
      GdtLog.b("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCall action:%s to:%s", new Object[] { str1, str2 }));
      if (!TextUtils.isEmpty(paramString)) {
        break label79;
      }
    }
    label73:
    label79:
    do
    {
      do
      {
        return null;
        str1 = null;
        break;
        str2 = null;
        break label34;
      } while ((!localParams.isValid()) || (!TextUtils.equals(localParams.getAction(), paramString)));
      str1 = AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext());
      paramString = AdIPCManager.INSTANCE.getHandler(paramString);
      if (!TextUtils.equals(str1, localParams.getToProcessName())) {
        break label206;
      }
    } while (paramString == null);
    paramString = paramString.handle(localParams);
    paramBundle = new EIPCResult();
    int i;
    if ((paramString != null) && (paramString.success))
    {
      i = 0;
      paramBundle.code = i;
      if (paramString == null) {
        break label201;
      }
    }
    label201:
    for (paramString = paramString.bundle;; paramString = null)
    {
      paramBundle.data = paramString;
      callbackResult(paramInt, paramBundle);
      return null;
      i = -102;
      break;
    }
    label206:
    QIPCServerHelper.getInstance().callClient(localParams.getToProcessName(), "gdt_ipc_module_server_to_client", localParams.getAction(), paramBundle, new GdtIPCAdapter.ClientToServerIPCAsyncModule.1(this, localParams, paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.ClientToServerIPCAsyncModule
 * JD-Core Version:    0.7.0.1
 */