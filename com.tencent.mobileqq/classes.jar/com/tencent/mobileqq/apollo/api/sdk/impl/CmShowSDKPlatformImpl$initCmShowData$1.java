package com.tencent.mobileqq.apollo.api.sdk.impl;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.sdk.onCmShowDataInitListener;
import com.tencent.mobileqq.apollo.sdk.CmShowDataHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class CmShowSDKPlatformImpl$initCmShowData$1
  implements EIPCResultCallback
{
  CmShowSDKPlatformImpl$initCmShowData$1(CmShowSDKPlatformImpl paramCmShowSDKPlatformImpl, String paramString1, String paramString2, onCmShowDataInitListener paramonCmShowDataInitListener) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowSDKPlatformImpl.access$setSSdkInit$p(this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkImplCmShowSDKPlatformImpl, true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    CmShowDataHelper.a(this.jdField_a_of_type_JavaLangString, i);
    CmShowDataHelper.a(this.b, j);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkOnCmShowDataInitListener.a(true);
    QLog.i("CmShowSDKPlatform", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.impl.CmShowSDKPlatformImpl.initCmShowData.1
 * JD-Core Version:    0.7.0.1
 */