package com.tencent.mobileqq.apollo.api.sdk.impl;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class CmShowSDKPlatformImpl$openCmShowStore$1
  implements EIPCResultCallback
{
  public static final 1 a = new 1();
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("CmShowSDKPlatform", 1, "openCmShowStore CmShow code:" + paramEIPCResult.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.impl.CmShowSDKPlatformImpl.openCmShowStore.1
 * JD-Core Version:    0.7.0.1
 */