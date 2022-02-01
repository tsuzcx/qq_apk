package com.tencent.av.wtogether;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class WTogetherRealNameMainProcessHelper
{
  private ConfigObserver a = null;
  private QQAppInterface b;
  
  public WTogetherRealNameMainProcessHelper(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.avReceiveRealNameMsg");
    localIntent.putExtra("real_name_result", paramBoolean);
    localIntent.setPackage(this.b.getApplication().getPackageName());
    this.b.getApp().sendBroadcast(localIntent);
  }
  
  private boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus");
    }
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus remove observer");
      }
      this.b.removeObserver(this.a);
    }
    return ((ConfigHandler)this.b.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).p();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "startMonitorRealNameResult");
    }
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "monitorRealNameResult remove observer");
      }
      this.b.removeObserver(this.a);
      this.a = null;
    }
    this.a = new WTogetherRealNameMainProcessHelper.1(this);
    this.b.addObserver(this.a);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return false;
      }
    }
    else {
      bool = c();
    }
    a();
    return bool;
  }
  
  public void b()
  {
    ConfigObserver localConfigObserver = this.a;
    if (localConfigObserver != null)
    {
      this.b.removeObserver(localConfigObserver);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameMainProcessHelper
 * JD-Core Version:    0.7.0.1
 */