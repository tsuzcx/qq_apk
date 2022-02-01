package com.tencent.gdtad.adapter;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class GdtIPCAdapter
  implements AdIPCManager.Adapter
{
  private Map<String, AdIPCManager.Handler> a = new ConcurrentHashMap();
  
  public AdIPCManager.Handler getHandler(String paramString)
  {
    return (AdIPCManager.Handler)this.a.get(paramString);
  }
  
  public void init(Context paramContext)
  {
    GdtLog.b("GdtIPCAdapter", "init");
    QIPCClientHelper.getInstance().register(GdtIPCAdapter.ServerToClientIPCModule.a());
  }
  
  public boolean register(String paramString, AdIPCManager.Handler paramHandler)
  {
    boolean bool;
    if ((TextUtils.isEmpty(paramString)) || (paramHandler == null) || (this.a.containsKey(paramString)))
    {
      bool = false;
    }
    else
    {
      this.a.put(paramString, paramHandler);
      bool = true;
    }
    GdtLog.b("GdtIPCAdapter", String.format("register action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
    return bool;
  }
  
  public AdIPCManager.Result send(Context paramContext, AdIPCManager.Params paramParams)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramParams != null) {
      localObject1 = paramParams.getAction();
    } else {
      localObject1 = null;
    }
    String str;
    if (paramParams != null) {
      str = paramParams.getToProcessName();
    } else {
      str = null;
    }
    AdIPCManager.Handler localHandler = getHandler((String)localObject1);
    paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = Looper.getMainLooper();
    boolean bool = true;
    if ((localLooper1 != localLooper2) && (!TextUtils.isEmpty(paramContext)) && (localHandler != null) && (paramParams != null) && (paramParams.isValid()))
    {
      GdtLog.b("GdtIPCAdapter", String.format("send action:%s from:%s to:%s", new Object[] { localObject1, paramContext, str }));
      if (TextUtils.equals(paramContext, str)) {
        return localHandler.handle(paramParams);
      }
      if (TextUtils.equals(AdProcessManager.INSTANCE.getMainProcessName(), str))
      {
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_sync_module_client_to_server", (String)localObject1, paramParams.bundle);
        paramParams = new AdIPCManager.Result();
        if ((localObject1 == null) || (!((EIPCResult)localObject1).isSuccess())) {
          bool = false;
        }
        paramParams.success = bool;
        paramContext = localObject2;
        if (localObject1 != null) {
          paramContext = ((EIPCResult)localObject1).data;
        }
        paramParams.bundle = paramContext;
        return paramParams;
      }
      GdtLog.d("GdtIPCAdapter", String.format("send error action:%s from:%s to:%s", new Object[] { localObject1, paramContext, str }));
      return null;
    }
    GdtLog.d("GdtIPCAdapter", String.format("send error actionad:%s from:%s to:%s", new Object[] { localObject1, paramContext, str }));
    return null;
  }
  
  public void send(Context paramContext, AdIPCManager.Params paramParams, WeakReference<AdIPCManager.Callback> paramWeakReference)
  {
    String str2 = null;
    String str1;
    if (paramParams != null) {
      str1 = paramParams.getAction();
    } else {
      str1 = null;
    }
    if (paramParams != null) {
      str2 = paramParams.getToProcessName();
    }
    AdIPCManager.Handler localHandler = getHandler(str1);
    paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    if ((!TextUtils.isEmpty(paramContext)) && (localHandler != null) && (paramParams != null) && (paramParams.isValid()))
    {
      GdtLog.b("GdtIPCAdapter", String.format("send action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
      if (TextUtils.equals(paramContext, str2))
      {
        paramContext = localHandler.handle(paramParams);
        if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
          ((AdIPCManager.Callback)paramWeakReference.get()).onCallback(paramParams, paramContext);
        }
      }
      else
      {
        if (TextUtils.equals(AdProcessManager.INSTANCE.getMainProcessName(), str2))
        {
          QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_async_module_client_to_server", str1, paramParams.bundle, new GdtIPCAdapter.1(this, paramWeakReference, str1, paramContext, str2, paramParams));
          return;
        }
        QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_async_module_client_to_server", str1, paramParams.bundle, new GdtIPCAdapter.2(this, paramWeakReference, str1, paramContext, str2, paramParams));
      }
      return;
    }
    GdtLog.d("GdtIPCAdapter", String.format("send error action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter
 * JD-Core Version:    0.7.0.1
 */