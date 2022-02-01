package com.tencent.mobileqq.ark.API;

import apua;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;

public class ArkAppYYBDownloadModule$6
  implements Runnable
{
  public ArkAppYYBDownloadModule$6(apua paramapua, long paramLong, String paramString) {}
  
  public void run()
  {
    try
    {
      ark.VariantWrapper localVariantWrapper1 = this.this$0.a(this.jdField_a_of_type_Long);
      if (localVariantWrapper1 == null)
      {
        QLog.d("ArkApp.downloadyyb.module", 1, "onQueryPackageState Callback is null");
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
      if (QLog.isColorLevel())
      {
        QLog.i("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB : " + this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "QUERRY_PACKAGE_INSTALL  : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.6
 * JD-Core Version:    0.7.0.1
 */