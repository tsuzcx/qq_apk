package com.tencent.biz.officialaccount;

import android.content.Context;
import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class OfficialAccountReporter$Reporter$doReport$1
  implements Runnable
{
  public OfficialAccountReporter$Reporter$doReport$1(HashMap paramHashMap, String paramString) {}
  
  public final void run()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
      String str = ((AppRuntime)localObject).getAccount();
      localObject = (Map)this.jdField_a_of_type_JavaUtilHashMap;
      Intrinsics.checkExpressionValueIsNotNull(str, "uin");
      ((Map)localObject).put("uin", str);
      ((Map)this.jdField_a_of_type_JavaUtilHashMap).put("A8", str);
      if (this.jdField_a_of_type_JavaLangString != null) {
        ((Map)this.jdField_a_of_type_JavaUtilHashMap).put("target_qq", this.jdField_a_of_type_JavaLangString);
      }
      QLog.d("OfficialAccountReporter", 2, "doReport " + this.jdField_a_of_type_JavaUtilHashMap);
      localObject = "PublicAccountReport";
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("code")) {
        localObject = String.valueOf(this.jdField_a_of_type_JavaUtilHashMap.get("code"));
      }
      bdmc.a((Context)BaseApplicationImpl.getContext()).a("00000KCQ7Y3ITP3Z", str, (String)localObject, true, -1L, -1L, this.jdField_a_of_type_JavaUtilHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter.doReport.1
 * JD-Core Version:    0.7.0.1
 */