package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkAppYYBDownloadModule$1$1
  implements Runnable
{
  ArkAppYYBDownloadModule$1$1(ArkAppYYBDownloadModule.1 param1, String paramString) {}
  
  public void run()
  {
    if ((ArkAppYYBDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$1.a) != null) && (ArkAppYYBDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$1.a).size() > 0))
    {
      int i = 0;
      while (i < ArkAppYYBDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$1.a).size())
      {
        Object localObject = ArkAppYYBDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$1.a, ((Long)ArkAppYYBDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$1.a).get(i)).longValue());
        if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          ark.VariantWrapper localVariantWrapper1 = ((ark.VariantWrapper)localObject).Create();
          localVariantWrapper1.SetNull();
          ark.VariantWrapper localVariantWrapper2 = ((ark.VariantWrapper)localObject).Create();
          localVariantWrapper1.SetTableAsJsonString(this.jdField_a_of_type_JavaLangString);
          ((ark.VariantWrapper)localObject).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper2);
          localVariantWrapper2.Reset();
          localVariantWrapper1.Reset();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onDownloadState callback : ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
            QLog.i("ArkApp.downloadyyb.module", 1, ((StringBuilder)localObject).toString());
          }
          i += 1;
        }
        else
        {
          QLog.d("ArkApp.downloadyyb.module", 1, "onDownloadState Callback is null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.1.1
 * JD-Core Version:    0.7.0.1
 */