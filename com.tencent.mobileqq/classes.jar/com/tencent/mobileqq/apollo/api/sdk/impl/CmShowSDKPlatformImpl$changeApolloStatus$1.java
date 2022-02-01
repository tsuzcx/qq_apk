package com.tencent.mobileqq.apollo.api.sdk.impl;

import com.tencent.mobileqq.apollo.api.sdk.onChangeApolloStatusListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class CmShowSDKPlatformImpl$changeApolloStatus$1
  implements EIPCResultCallback
{
  CmShowSDKPlatformImpl$changeApolloStatus$1(onChangeApolloStatusListener paramonChangeApolloStatusListener) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    QLog.i("CmShowSDKPlatform", 1, "changeApolloStatus ipc code:" + paramEIPCResult.code);
    ApolloUtilImpl.showDebugTipsToast("changeApolloStatus code:" + paramEIPCResult.code);
    onChangeApolloStatusListener localonChangeApolloStatusListener = this.a;
    if (localonChangeApolloStatusListener != null) {
      if (paramEIPCResult.code != 0) {
        break label79;
      }
    }
    for (;;)
    {
      localonChangeApolloStatusListener.a(bool);
      return;
      label79:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.impl.CmShowSDKPlatformImpl.changeApolloStatus.1
 * JD-Core Version:    0.7.0.1
 */