package com.tencent.mobileqq.ark.API;

import aool;
import aoop;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;

public class ArkAppDownloadModule$2$1
  implements Runnable
{
  public ArkAppDownloadModule$2$1(aoop paramaoop, ArrayList paramArrayList) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper1 = this.jdField_a_of_type_Aoop.jdField_a_of_type_Aool.a(this.jdField_a_of_type_Aoop.jdField_a_of_type_Long);
    if (localVariantWrapper1 == null)
    {
      QLog.d("ark.download.module", 1, "ark.dctrl.onQueryPackageStateVia Callback is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    JSONArray localJSONArray = aool.a(this.jdField_a_of_type_Aoop.jdField_a_of_type_Aool, this.jdField_a_of_type_JavaUtilArrayList, "QueryPackageStateVia");
    String str = "";
    if (localJSONArray != null) {
      str = localJSONArray.toString();
    }
    localVariantWrapper2.SetTableAsJsonString(str);
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
    localVariantWrapper3.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
    QLog.e("ark.download.module", 1, "ark.dctrl.QueryPackageStateVia result : " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.2.1
 * JD-Core Version:    0.7.0.1
 */