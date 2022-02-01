package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.gdtad.log.GdtLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

class GdtIPCAdapter$1
  implements EIPCResultCallback
{
  GdtIPCAdapter$1(GdtIPCAdapter paramGdtIPCAdapter, WeakReference paramWeakReference, String paramString1, String paramString2, String paramString3, AdIPCManager.Params paramParams) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = this.a;
    boolean bool2 = true;
    boolean bool1;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    GdtLog.b("GdtIPCAdapter", String.format("send.onCallback:%b action:%s from:%s to:%s", new Object[] { Boolean.valueOf(bool1), this.b, this.c, this.d }));
    localObject = new AdIPCManager.Result();
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((AdIPCManager.Result)localObject).success = bool1;
    if (paramEIPCResult != null) {
      paramEIPCResult = paramEIPCResult.data;
    } else {
      paramEIPCResult = null;
    }
    ((AdIPCManager.Result)localObject).bundle = paramEIPCResult;
    paramEIPCResult = this.a;
    if ((paramEIPCResult != null) && (paramEIPCResult.get() != null)) {
      ((AdIPCManager.Callback)this.a.get()).onCallback(this.e, (AdIPCManager.Result)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.1
 * JD-Core Version:    0.7.0.1
 */