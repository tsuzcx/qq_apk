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
    boolean bool2 = true;
    boolean bool1;
    AdIPCManager.Result localResult;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      bool1 = true;
      GdtLog.b("GdtIPCAdapter", String.format("send.onCallback:%b action:%s from:%s to:%s", new Object[] { Boolean.valueOf(bool1), this.jdField_a_of_type_JavaLangString, this.b, this.c }));
      localResult = new AdIPCManager.Result();
      if ((paramEIPCResult == null) || (!paramEIPCResult.isSuccess())) {
        break label150;
      }
      bool1 = bool2;
      label85:
      localResult.success = bool1;
      if (paramEIPCResult == null) {
        break label155;
      }
    }
    label150:
    label155:
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = null)
    {
      localResult.bundle = paramEIPCResult;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((AdIPCManager.Callback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onCallback(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params, localResult);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.2
 * JD-Core Version:    0.7.0.1
 */