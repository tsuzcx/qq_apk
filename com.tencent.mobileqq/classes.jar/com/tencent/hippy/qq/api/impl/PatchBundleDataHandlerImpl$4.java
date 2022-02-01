package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.qphone.base.util.QLog;

class PatchBundleDataHandlerImpl$4
  implements IUpdateListener
{
  PatchBundleDataHandlerImpl$4(PatchBundleDataHandlerImpl paramPatchBundleDataHandlerImpl) {}
  
  public void onUpdateFailed(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateFailed patch update bundleName:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" retMsg:");
    localStringBuilder.append(paramString1);
    QLog.i("PatchBundleDataHandlerImpl", 1, localStringBuilder.toString());
  }
  
  public void onUpdateSuccess(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateSuccess patch update bundleName:");
    localStringBuilder.append(paramString);
    QLog.i("PatchBundleDataHandlerImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl.4
 * JD-Core Version:    0.7.0.1
 */