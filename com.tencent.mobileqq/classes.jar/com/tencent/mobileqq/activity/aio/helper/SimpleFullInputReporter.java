package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;

public class SimpleFullInputReporter
{
  public static void a(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (!QQTheme.isNowSimpleUI()) {
      return;
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    ReportController.a(paramAppInterface, "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleFullInputReporter
 * JD-Core Version:    0.7.0.1
 */