package com.tencent.mobileqq.app.identity;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SmsQuickLoginReporter
  implements IDelayReporter
{
  public boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = "quickLoginError".equals(paramString);
    if (bool)
    {
      if (paramHashMap == null) {
        return true;
      }
      paramString = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (paramString != null) {
        break label67;
      }
    }
    label67:
    for (paramString = "";; paramString = paramString.getAccount())
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramHashMap.put("keyUin", paramString);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(paramString, "quickLoginError", false, 0L, 0L, paramHashMap, "");
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.SmsQuickLoginReporter
 * JD-Core Version:    0.7.0.1
 */