package com.tencent.mobileqq.app;

import com.tencent.mobileqq.config.business.qvip.QVipPersonalIconConfig;
import com.tencent.mobileqq.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaIconEntryDynamicRedPointPathInterface
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  public List<String> getRedPointPaths(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      ILebaHelperService localILebaHelperService = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
      if ((localILebaHelperService != null) && (localILebaHelperService.isTableModel(paramAppRuntime))) {}
      for (int i = 1;; i = 0)
      {
        paramAppRuntime = QVipPersonalIconProcessor.c();
        if ((i == 0) || (!paramAppRuntime.a())) {
          break;
        }
        paramAppRuntime = new ArrayList();
        paramAppRuntime.add("150000");
        paramAppRuntime.add("150000.150100");
        return paramAppRuntime;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaIconEntryDynamicRedPointPathInterface
 * JD-Core Version:    0.7.0.1
 */