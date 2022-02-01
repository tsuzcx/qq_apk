package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;

class ArkAppYYBDownloadModule$6
  implements Runnable
{
  ArkAppYYBDownloadModule$6(ArkAppYYBDownloadModule paramArkAppYYBDownloadModule, long paramLong, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = ArkAppYYBDownloadModule.c(this.this$0, this.jdField_a_of_type_Long);
      if (localObject1 == null)
      {
        QLog.d("ArkApp.downloadyyb.module", 1, "onQueryPackageState Callback is null");
        return;
      }
      localObject2 = ((ark.VariantWrapper)localObject1).Create();
      ((ark.VariantWrapper)localObject2).SetNull();
      ark.VariantWrapper localVariantWrapper = ((ark.VariantWrapper)localObject1).Create();
      ((ark.VariantWrapper)localObject2).SetTableAsJsonString(this.jdField_a_of_type_JavaLangString);
      ((ark.VariantWrapper)localObject1).InvokeDefault(new ark.VariantWrapper[] { localObject2 }, localVariantWrapper);
      localVariantWrapper.Reset();
      ((ark.VariantWrapper)localObject2).Reset();
      ((ark.VariantWrapper)localObject1).Reset();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryPackageStateYYB : ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("ArkApp.downloadyyb.module", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QUERRY_PACKAGE_INSTALL  : ");
      ((StringBuilder)localObject2).append(localException);
      QLog.e("ArkApp.downloadyyb.module", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.6
 * JD-Core Version:    0.7.0.1
 */