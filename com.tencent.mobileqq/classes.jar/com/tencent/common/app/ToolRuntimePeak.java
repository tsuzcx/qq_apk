package com.tencent.common.app;

import android.content.Context;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qqgift.runtime.QQGiftToolAppInterface;
import com.tencent.mobileqq.qqlive.runtime.QQLiveToolAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ToolRuntimePeak
  extends ToolRuntimeBase
{
  public static final String a = ToolAppRuntime.class.getSimpleName();
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if ("peak".equals(paramString)) {
      localObject = new PeakAppInterface((BaseApplicationImpl)localObject, "peak");
    } else if ("Photoplus.apk".equals(paramString)) {
      localObject = QZoneHelper.createPhotoPlusAppInterface((Context)localObject);
    } else if ("qq_live_tool".equals(paramString)) {
      localObject = new QQLiveToolAppInterface((MobileQQ)localObject, MobileQQ.processName);
    } else if ("qq_gift_tool".equals(paramString)) {
      localObject = new QQGiftToolAppInterface((MobileQQ)localObject, MobileQQ.processName);
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ToolRuntimePeak.onGetSubRuntime() moduleId ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" appInstance = ");
      localStringBuilder.append(localObject);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.ToolRuntimePeak
 * JD-Core Version:    0.7.0.1
 */