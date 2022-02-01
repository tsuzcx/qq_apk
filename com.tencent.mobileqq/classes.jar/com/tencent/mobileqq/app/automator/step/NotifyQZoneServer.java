package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class NotifyQZoneServer
  extends AsyncStep
{
  protected int doStep()
  {
    if (!this.mAutomator.k.isBackgroundPause)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isBackground_Pause:");
        ((StringBuilder)localObject1).append(this.mAutomator.k.isBackgroundPause);
        QLog.d("NotifyQZoneServer", 2, ((StringBuilder)localObject1).toString());
      }
      return super.doStep();
    }
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "ClientOnlineColdTime", 300);
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("QZoneOnLineServlet", 0);
    Object localObject1 = this.mAutomator.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastReqTime");
    localStringBuilder.append((String)localObject1);
    long l1 = ((SharedPreferences)localObject2).getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l2 - l1;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastReqTime(ms):");
      localStringBuilder.append(l1);
      localStringBuilder.append(",currentTime(ms):");
      localStringBuilder.append(l2);
      localStringBuilder.append("divTime(ms):");
      localStringBuilder.append(l3);
      localStringBuilder.append(",coldTime(ms):");
      localStringBuilder.append(i * 1000);
      QLog.d("NotifyQZoneServer", 4, localStringBuilder.toString());
    }
    if (l3 > i * 1000)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReqTime:");
        localStringBuilder.append(l2);
        QLog.d("NotifyQZoneServer", 4, localStringBuilder.toString());
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastReqTime");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putLong(localStringBuilder.toString(), l2);
      if (Build.VERSION.SDK_INT >= 9) {
        ((SharedPreferences.Editor)localObject2).apply();
      } else {
        ((SharedPreferences.Editor)localObject2).commit();
      }
      localObject1 = (QZoneManager)this.mAutomator.k.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localObject1 != null) {
        ((QZoneManager)localObject1).c();
      }
    }
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.NotifyQZoneServer
 * JD-Core Version:    0.7.0.1
 */