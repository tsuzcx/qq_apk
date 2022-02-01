package com.tencent.mobileqq.activity.aio.pluspanel.filter;

import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.C2CPlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.List;

public class C2CCommonAppInfoOrderFilter
  implements AppInfoFilter
{
  private int a(List<PlusPanelAppInfo> paramList)
  {
    if (paramList.size() > 0)
    {
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        if (209 == ((PlusPanelAppInfo)paramList.get(i)).getAppID()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (((paramPlusPanelAppLoader instanceof C2CPlusPanelAppLoader)) && (!((C2CPlusPanelAppLoader)paramPlusPanelAppLoader).a()))
    {
      paramPlusPanelAppLoader.b(1000000006);
      if (!QQTheme.f()) {
        paramPlusPanelAppLoader.b(219);
      }
      paramQQAppInterface = paramPlusPanelAppLoader.a();
      paramInt = a(paramQQAppInterface);
      if (paramInt >= 0)
      {
        paramString = (PlusPanelAppInfo)paramQQAppInterface.get(paramInt);
        paramPlusPanelAppLoader.b(209);
        if (paramQQAppInterface.size() < 10)
        {
          paramQQAppInterface.add(paramString);
          return;
        }
        paramQQAppInterface.add(10, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.C2CCommonAppInfoOrderFilter
 * JD-Core Version:    0.7.0.1
 */