package com.tencent.mobileqq.app.identity;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SafeUtils
{
  public static TipsBar a(AppRuntime paramAppRuntime, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SafeUtils", 2, "init phone unity banner");
    }
    String str = (String)BaseSharedPreUtil.a(paramContext, paramAppRuntime.getAccount(), "phone_unity_banner_tips", "");
    TipsBar localTipsBar = new TipsBar(paramContext);
    localTipsBar.setVisibility(8);
    localTipsBar.a().setText(str);
    localTipsBar.setTipsIcon(paramContext.getResources().getDrawable(2130839273));
    localTipsBar.setOriginalOnClickListener(new SafeUtils.1(paramContext, paramAppRuntime));
    ReportController.b(paramAppRuntime, "dc00898", "", "", "0X800B3E9", "0X800B3E9", 0, 0, "", "", "", "");
    return localTipsBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.SafeUtils
 * JD-Core Version:    0.7.0.1
 */