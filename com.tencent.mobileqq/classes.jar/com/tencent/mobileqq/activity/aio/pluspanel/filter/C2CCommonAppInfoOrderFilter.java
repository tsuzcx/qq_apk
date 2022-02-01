package com.tencent.mobileqq.activity.aio.pluspanel.filter;

import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.C2CPlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQTheme;

public class C2CCommonAppInfoOrderFilter
  implements AppInfoFilter
{
  public void a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (((paramPlusPanelAppLoader instanceof C2CPlusPanelAppLoader)) && (!((C2CPlusPanelAppLoader)paramPlusPanelAppLoader).d()))
    {
      paramPlusPanelAppLoader.c(1000000006);
      if (!QQTheme.isNowSimpleUI()) {
        paramPlusPanelAppLoader.c(219);
      }
      paramQQAppInterface = paramPlusPanelAppLoader.b(209);
      if (paramQQAppInterface != null)
      {
        paramPlusPanelAppLoader.c(209);
        if (paramPlusPanelAppLoader.b() < 10)
        {
          paramPlusPanelAppLoader.b(paramQQAppInterface);
          return;
        }
        paramPlusPanelAppLoader.a(10, paramQQAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.C2CCommonAppInfoOrderFilter
 * JD-Core Version:    0.7.0.1
 */