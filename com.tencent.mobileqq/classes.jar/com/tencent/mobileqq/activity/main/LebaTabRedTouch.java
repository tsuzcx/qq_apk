package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.util.Iterator;
import java.util.List;
import wmn;

public class LebaTabRedTouch
{
  public SplashActivity a;
  
  public LebaTabRedTouch(SplashActivity paramSplashActivity)
  {
    this.a = paramSplashActivity;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.a == null) || (this.a.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.a.app.getManager(9);
    if (localQZoneManagerImp != null)
    {
      int j = localQZoneManagerImp.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localQZoneManagerImp.a(1));
        i = j;
      }
    }
    return i;
  }
  
  private ReadInJoyNotifyRedTouchInfo a()
  {
    if (!b()) {
      return null;
    }
    if ((this.a == null) || (this.a.app == null)) {
      return null;
    }
    ReadInJoyManager localReadInJoyManager = (ReadInJoyManager)this.a.app.getManager(95);
    if (localReadInJoyManager == null) {
      return null;
    }
    return localReadInJoyManager.a();
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((this.a == null) || (this.a.app == null)) {
      return false;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.a.app.getManager(9);
    if (localQZoneManagerImp != null)
    {
      if (localQZoneManagerImp.a(2) > 0) {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localQZoneManagerImp.a(2) + " TYPE_ZEBRA_ALBUM:" + localQZoneManagerImp.a(17));
        bool2 = bool1;
      }
    }
    QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "MainAssistObserver", 1, "isNewQzoneMsgExist: " + bool2);
    return bool2;
  }
  
  private boolean b()
  {
    if ((this.a == null) || (this.a.app == null)) {
      return false;
    }
    Iterator localIterator = ((RedTouchManager)this.a.app.getManager(35)).b().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == 1130L) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  public Runnable a(LebaTabRedTouch.RefreshCallback paramRefreshCallback)
  {
    return new wmn(this, paramRefreshCallback);
  }
  
  public void a()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch
 * JD-Core Version:    0.7.0.1
 */