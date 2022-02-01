package com.tencent.mobileqq.apollo.makeup;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "eipcResult", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class CmShowEALoader$AEKitResDownloadTask$executeAsync$1
  implements EIPCResultCallback
{
  CmShowEALoader$AEKitResDownloadTask$executeAsync$1(CmShowEALoader.AEKitResDownloadTask paramAEKitResDownloadTask) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramEIPCResult, "eipcResult");
    if (paramEIPCResult.isSuccess())
    {
      QLog.d(CmShowEALoader.f.a(), 1, "[CmShowAELoader][AEKitResDownloadTask] succeed 下载3d/基础资源包完成");
      this.a.j();
      return;
    }
    QLog.e(CmShowEALoader.f.a(), 1, "[AEKit]AECMShowQipcModule initStepDownloadAEKitResource error");
    this.a.a(-5032, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.AEKitResDownloadTask.executeAsync.1
 * JD-Core Version:    0.7.0.1
 */