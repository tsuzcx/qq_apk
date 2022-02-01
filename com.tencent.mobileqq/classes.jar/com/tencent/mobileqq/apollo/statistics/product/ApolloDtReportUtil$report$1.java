package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.TMG.utils.QLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloDtReportUtil$report$1
  implements Runnable
{
  ApolloDtReportUtil$report$1(String paramString1, String paramString2, String paramString3, Map paramMap) {}
  
  public final void run()
  {
    String str = this.jdField_a_of_type_JavaLangString + '#' + this.b + '#' + this.c;
    HashMap localHashMap = new HashMap();
    Object localObject2 = (Map)localHashMap;
    Object localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (localObject1 != null)
    {
      localObject1 = ((AppRuntime)localObject1).getAccount();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      ((Map)localObject2).put("qqUin", localObject1);
      ((Map)localHashMap).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        localHashMap.putAll(this.jdField_a_of_type_JavaUtilMap);
      }
      localObject1 = new StringBuilder();
      localObject2 = ((Map)localHashMap).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(";");
      }
      localObject1 = "";
    }
    QLog.d("ApolloDtReportUtil", 1, "report " + str + " ; params:  " + ((StringBuilder)localObject1).toString());
    UserAction.onUserActionToTunnel("0AND0FB8I14UU93I", str, (Map)localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.report.1
 * JD-Core Version:    0.7.0.1
 */