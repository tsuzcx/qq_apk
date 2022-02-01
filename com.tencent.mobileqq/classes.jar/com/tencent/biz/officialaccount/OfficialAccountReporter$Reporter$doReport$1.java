package com.tencent.biz.officialaccount;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class OfficialAccountReporter$Reporter$doReport$1
  implements Runnable
{
  OfficialAccountReporter$Reporter$doReport$1(HashMap paramHashMap, String paramString) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = BaseApplicationImpl.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
        String str2 = ((AppRuntime)localObject).getAccount();
        localObject = (Map)this.a;
        Intrinsics.checkExpressionValueIsNotNull(str2, "uin");
        ((Map)localObject).put("uin", str2);
        ((Map)this.a).put("A8", str2);
        if (this.b != null) {
          ((Map)this.a).put("target_qq", this.b);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReport ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("OfficialAccountReporter", 2, ((StringBuilder)localObject).toString());
        if (this.a.containsKey("code"))
        {
          localObject = String.valueOf(this.a.get("code"));
          StatisticCollector.getInstance((Context)BaseApplicationImpl.getContext()).collectPerformance("00000KCQ7Y3ITP3Z", str2, (String)localObject, true, -1L, -1L, this.a, "");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("OfficialAccountReporter", 2, (Throwable)localException, new Object[0]);
        return;
      }
      String str1 = "PublicAccountReport";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter.doReport.1
 * JD-Core Version:    0.7.0.1
 */