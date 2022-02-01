package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.gdtad.log.GdtLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

class GdtIPCAdapter$2
  implements EIPCResultCallback
{
  GdtIPCAdapter$2(GdtIPCAdapter paramGdtIPCAdapter, WeakReference paramWeakReference, String paramString1, String paramString2, String paramString3, AdIPCManager.Params paramParams) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    boolean bool2 = true;
    boolean bool1;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    GdtLog.b("GdtIPCAdapter", String.format("send.onCallback:%b action:%s from:%s to:%s", new Object[] { Boolean.valueOf(bool1), this.jdField_a_of_type_JavaLangString, this.b, this.c }));
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
    paramEIPCResult = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramEIPCResult != null) && (paramEIPCResult.get() != null)) {
      ((AdIPCManager.Callback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onCallback(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params, (AdIPCManager.Result)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.2
 * JD-Core Version:    0.7.0.1
 */