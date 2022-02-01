package com.tencent.hippy.qq.patchbundle;

import com.tencent.qphone.base.util.QLog;

class PatchBundleConfig$1
  implements PatchBundleConfig.SSOListConfig.OnSSODataFetchListener
{
  PatchBundleConfig$1(PatchBundleConfig paramPatchBundleConfig) {}
  
  public void onFetchDone(int paramInt, PatchBundleConfig.SSOListConfig paramSSOListConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadSSOList onFetchDone code:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ssoListConfig:");
      localStringBuilder.append(paramSSOListConfig);
      QLog.d("PatchBundleConfig", 2, localStringBuilder.toString());
    }
    paramSSOListConfig.saveCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig.1
 * JD-Core Version:    0.7.0.1
 */