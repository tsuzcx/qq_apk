package com.tencent.mobileqq.apollo.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CmShowSpriteDrawerInfoBridge$4
  implements EIPCResultCallback
{
  CmShowSpriteDrawerInfoBridge$4(CmShowSpriteDrawerInfoBridge paramCmShowSpriteDrawerInfoBridge, CmShowSpriteContext paramCmShowSpriteContext) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = (IPCSpriteContext)paramEIPCResult.data.getParcelable("IPCSpriteContext");
    paramEIPCResult = paramEIPCResult.data.getString("js_content");
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "checkfDressChanged CmShow_ spriteJs:" + paramEIPCResult);
    if (TextUtils.isEmpty(paramEIPCResult)) {
      TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(), 300, 301, new Object[] { "spriteJs is empty" });
    }
    do
    {
      return;
      localObject = (CmShowSpriteActionScript)CmShowSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge).a(100);
    } while (localObject == null);
    ThreadManagerV2.excute(new CmShowSpriteDrawerInfoBridge.4.1(this, paramEIPCResult, (CmShowSpriteActionScript)localObject), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.4
 * JD-Core Version:    0.7.0.1
 */