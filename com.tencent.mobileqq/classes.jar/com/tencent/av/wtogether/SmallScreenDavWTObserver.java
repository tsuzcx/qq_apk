package com.tencent.av.wtogether;

import android.content.Context;
import android.os.Handler;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenDavWTObserver
  extends WTogetherObserverImpl
{
  protected final SmallScreenDoubleVideoControlUI a;
  
  public SmallScreenDavWTObserver(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI)
  {
    super(paramSmallScreenDoubleVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenDoubleVideoControlUI = paramSmallScreenDoubleVideoControlUI;
  }
  
  private void a(String paramString)
  {
    boolean bool = SmallScreenUtils.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (bool) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenDavWTObserver.2(this, paramString));
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.ObserverImpl", 2, "startAlertDialog, isAppForeground[" + bool + "], msg[" + paramString + "]");
    }
  }
  
  protected void a()
  {
    a(BaseApplicationImpl.getContext().getString(2131695976));
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.ObserverImpl", 2, "onShowTips, isDialog[" + paramBoolean + "], tip[" + paramString + "]");
    }
    if (paramBoolean)
    {
      a(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenDavWTObserver.1(this, paramString));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ObserverImpl", 4, "changeUIMode, start[" + paramBoolean1 + "], isAdmin[" + paramBoolean2 + "], from[" + paramString + "]");
    }
    if ((!paramBoolean2) && (paramBoolean1) && (WTogetherUtil.b()))
    {
      paramString = BaseApplicationImpl.getContext();
      Object localObject = SessionMgr.a().a();
      localObject = ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).b((SessionInfo)localObject);
      if (((WatchTogetherInfo)localObject).a) {
        break label124;
      }
      ((WatchTogetherInfo)localObject).a = true;
      a(paramString.getString(2131695983));
    }
    label124:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("WTogether", 2, "showNetTip, have shown. 3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.SmallScreenDavWTObserver
 * JD-Core Version:    0.7.0.1
 */