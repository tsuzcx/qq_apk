package com.tencent.mobileqq.app;

import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaDynamicRedPointPathInterface
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  public List<String> getRedPointPaths(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      ILebaHelperService localILebaHelperService = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
      int i;
      if ((localILebaHelperService != null) && (localILebaHelperService.isTableModel(paramAppRuntime))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramAppRuntime = new ArrayList();
        paramAppRuntime.add("100000");
        return paramAppRuntime;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaDynamicRedPointPathInterface
 * JD-Core Version:    0.7.0.1
 */