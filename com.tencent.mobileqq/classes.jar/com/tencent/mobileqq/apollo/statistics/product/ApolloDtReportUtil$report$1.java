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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append('#');
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append('#');
    ((StringBuilder)localObject1).append(this.c);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2 = new HashMap();
    Map localMap = (Map)localObject2;
    localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (localObject1 != null)
    {
      localObject1 = ((AppRuntime)localObject1).getAccount();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localMap.put("qqUin", localObject1);
    localMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    if (localObject1 != null) {
      ((HashMap)localObject2).putAll((Map)localObject1);
    }
    localObject1 = new StringBuilder();
    localObject2 = localMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append((String)localEntry.getKey());
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append((String)localEntry.getValue());
      ((StringBuilder)localObject1).append(";");
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("report ");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(" ; params:  ");
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    QLog.d("ApolloDtReportUtil", 1, ((StringBuilder)localObject2).toString());
    UserAction.onUserActionToTunnel("0AND0FB8I14UU93I", str, localMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.report.1
 * JD-Core Version:    0.7.0.1
 */