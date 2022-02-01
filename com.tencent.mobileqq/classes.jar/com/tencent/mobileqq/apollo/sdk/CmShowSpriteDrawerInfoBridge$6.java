package com.tencent.mobileqq.apollo.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CmShowSpriteDrawerInfoBridge$6
  implements EIPCResultCallback
{
  CmShowSpriteDrawerInfoBridge$6(CmShowSpriteDrawerInfoBridge paramCmShowSpriteDrawerInfoBridge, IRenderViewListener paramIRenderViewListener, int paramInt, CmShowSpriteContext paramCmShowSpriteContext) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = (IPCSpriteContext)paramEIPCResult.data.getParcelable("IPCSpriteContext");
    paramEIPCResult = paramEIPCResult.data.getString("js_content");
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "CmShow_ spriteJs:" + paramEIPCResult);
    if (TextUtils.isEmpty(paramEIPCResult))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener.a(false, this.jdField_a_of_type_Int);
      }
      TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(), 300, 301, new Object[] { "spriteJs is empty" });
    }
    do
    {
      do
      {
        return;
        localObject = (CmShowSpriteActionScript)CmShowSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge).a(100);
      } while (localObject == null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSprite('").append(paramEIPCResult).append("');");
      TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(), 300, 0, new Object[0]);
      TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(), 350);
      ((CmShowSpriteActionScript)localObject).a(localStringBuilder.toString());
      ThreadManager.executeOnSubThread(new CmShowSpriteDrawerInfoBridge.6.1(this, (CmShowSpriteActionScript)localObject));
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener.a(true, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.6
 * JD-Core Version:    0.7.0.1
 */