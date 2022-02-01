package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import apjw;
import apjx;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ArkAppYYBDownloadModule$1$1
  implements Runnable
{
  public ArkAppYYBDownloadModule$1$1(apjx paramapjx, String paramString) {}
  
  public void run()
  {
    int i;
    if ((apjw.a(this.jdField_a_of_type_Apjx.a) != null) && (apjw.a(this.jdField_a_of_type_Apjx.a).size() > 0)) {
      i = 0;
    }
    for (;;)
    {
      ark.VariantWrapper localVariantWrapper1;
      if (i < apjw.a(this.jdField_a_of_type_Apjx.a).size())
      {
        localVariantWrapper1 = this.jdField_a_of_type_Apjx.a.b(((Long)apjw.a(this.jdField_a_of_type_Apjx.a).get(i)).longValue());
        if ((localVariantWrapper1 == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          QLog.d("ArkApp.downloadyyb.module", 1, "onDownloadState Callback is null");
        }
      }
      else
      {
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      localVariantWrapper2.SetNull();
      ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
      localVariantWrapper2.SetTableAsJsonString(this.jdField_a_of_type_JavaLangString);
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.downloadyyb.module", 1, "onDownloadState callback : " + this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.1.1
 * JD-Core Version:    0.7.0.1
 */