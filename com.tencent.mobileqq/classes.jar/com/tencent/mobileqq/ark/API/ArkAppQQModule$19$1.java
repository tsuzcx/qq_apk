package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$19$1
  implements Runnable
{
  ArkAppQQModule$19$1(ArkAppQQModule.19 param19, String paramString) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper1 = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule$19.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule$19.jdField_a_of_type_Long);
    if (localVariantWrapper1 == null)
    {
      ChooseImageIPCModule.a().a(null);
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    localVariantWrapper2.SetTableAsJsonString(this.jdField_a_of_type_JavaLangString);
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
    localVariantWrapper3.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
    QLog.i("ArkApp", 1, "QQ.ChooseImage callback : " + this.jdField_a_of_type_JavaLangString);
    ChooseImageIPCModule.a().a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.19.1
 * JD-Core Version:    0.7.0.1
 */