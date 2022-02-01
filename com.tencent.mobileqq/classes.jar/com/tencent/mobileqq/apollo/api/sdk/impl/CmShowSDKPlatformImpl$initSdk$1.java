package com.tencent.mobileqq.apollo.api.sdk.impl;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class CmShowSDKPlatformImpl$initSdk$1
  implements EIPCResultCallback
{
  CmShowSDKPlatformImpl$initSdk$1(CmShowSDKPlatformImpl paramCmShowSDKPlatformImpl, IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowSDKPlatformImpl.access$setSSdkInit$p(this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkImplCmShowSDKPlatformImpl, true);
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback.a(1);
      QLog.i("CmShowSDKPlatform", 1, "initSdk resp == null");
      return;
    }
    ApolloConstant.H = paramEIPCResult.getString("sApolloBaseScriptId");
    Object localObject = QRoute.api(IApolloUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IApolloUtil::class.java)");
    localObject = ((IApolloUtil)localObject).getAppInterface();
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
      }
      localObject = (ApolloManagerServiceImpl)localObject;
      if (localObject != null)
      {
        ((ApolloManagerServiceImpl)localObject).setDisableCreateRenderThread(paramEIPCResult.getBoolean("sDisableCreateRenderThread"));
        ((ApolloManagerServiceImpl)localObject).setApolloEngineLockEnable(paramEIPCResult.getBoolean("sApolloEngineLockEnable"));
      }
    }
    ApolloConstant.I = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/" + ApolloConstant.H + "/";
    if (ApolloSoLoaderImpl.isLibReady()) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback.a(0);
    }
    for (;;)
    {
      QLog.i("CmShowSDKPlatform", 1, "initSdk");
      return;
      ApolloSoLoaderImpl.removeLoadCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback);
      ApolloSoLoaderImpl.addLoadCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback);
      ApolloSoLoaderImpl.loadSo("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.impl.CmShowSDKPlatformImpl.initSdk.1
 * JD-Core Version:    0.7.0.1
 */