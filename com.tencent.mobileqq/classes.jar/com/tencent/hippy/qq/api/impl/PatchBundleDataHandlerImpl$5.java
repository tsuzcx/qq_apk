package com.tencent.hippy.qq.api.impl;

import android.text.TextUtils;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SSOListConfig;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SSOListConfig.OnSSODataFetchListener;
import com.tencent.hippy.qq.patchbundle.PatchUtils;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class PatchBundleDataHandlerImpl$5
  implements PatchBundleConfig.SSOListConfig.OnSSODataFetchListener
{
  PatchBundleDataHandlerImpl$5(PatchBundleDataHandlerImpl paramPatchBundleDataHandlerImpl, int paramInt, Promise paramPromise) {}
  
  public void onFetchDone(int paramInt, PatchBundleConfig.SSOListConfig paramSSOListConfig)
  {
    Object localObject;
    if (this.val$contentHash == 0)
    {
      Promise localPromise = this.val$promise;
      if (paramInt == 0) {
        localObject = "ok";
      } else {
        localObject = "fail";
      }
      PatchBundleDataHandlerImpl.promiseSSOData(localPromise, paramInt, (String)localObject, paramSSOListConfig.mRsp);
      if (QLog.isColorLevel()) {
        QLog.i("PatchBundleDataHandlerImpl", 2, "getSSOListData doPromiseCallback sso data");
      }
    }
    else if ((!TextUtils.isEmpty(paramSSOListConfig.mRsp)) && (this.val$contentHash != paramSSOListConfig.mRsp.hashCode()))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramSSOListConfig);
      PatchUtils.dispatchSSOData2Page(null, (List)localObject);
      QLog.i("PatchBundleDataHandlerImpl", 2, "getSSOListData dispatch new sso data");
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("PatchBundleDataHandlerImpl", 2, "getSSOListData sso data the same, had doPromiseCallback");
    }
    if (paramInt == 0) {
      paramSSOListConfig.saveCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl.5
 * JD-Core Version:    0.7.0.1
 */