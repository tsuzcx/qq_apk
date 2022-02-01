package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.BusinessObserver;

class ArkAppCGI$1
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkTemp.queryAppInfoByAppNameBatch, sso request failed");
      paramObject = null;
    }
    for (;;)
    {
      paramObject = ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, (String)paramObject);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback.a(paramObject, this.jdField_a_of_type_JavaLangObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.1
 * JD-Core Version:    0.7.0.1
 */