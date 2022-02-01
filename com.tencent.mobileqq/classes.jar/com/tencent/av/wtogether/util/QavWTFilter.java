package com.tencent.av.wtogether.util;

import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.AppInfoFilter;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QavWTFilter
  implements AppInfoFilter
{
  public void a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((!WTogetherUtil.a()) && (paramPlusPanelAppLoader != null))
    {
      paramPlusPanelAppLoader.b(223);
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "filter aio entry. sdk[" + Build.VERSION.SDK_INT + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.QavWTFilter
 * JD-Core Version:    0.7.0.1
 */