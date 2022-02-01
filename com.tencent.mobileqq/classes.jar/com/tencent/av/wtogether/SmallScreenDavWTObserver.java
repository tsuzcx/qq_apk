package com.tencent.av.wtogether;

import android.content.Context;
import android.os.Handler;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenDavWTObserver
  extends WTogetherObserverImpl
{
  public SmallScreenDavWTObserver(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void a(String paramString)
  {
    boolean bool = SmallScreenUtils.f(this.b.getApp());
    if (bool) {
      this.a.post(new SmallScreenDavWTObserver.2(this, paramString));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startAlertDialog, isAppForeground[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], msg[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.ObserverImpl", 2, localStringBuilder.toString());
    }
  }
  
  protected void a()
  {
    a(BaseApplicationImpl.getContext().getString(2131893753));
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowTips, isDialog[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], tip[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.ObserverImpl", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      a(paramString);
      return;
    }
    this.a.post(new SmallScreenDavWTObserver.1(this, paramString));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeUIMode, start[");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("], isAdmin[");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("], from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.ObserverImpl", 4, ((StringBuilder)localObject).toString());
    }
    if ((!paramBoolean2) && (paramBoolean1) && (WTogetherUtil.c()))
    {
      paramString = BaseApplicationImpl.getContext();
      localObject = SessionMgr.a().b();
      localObject = ((WTogetherMng)this.b.c(17)).b((SessionInfo)localObject);
      if (!((WatchTogetherInfo)localObject).e)
      {
        ((WatchTogetherInfo)localObject).e = true;
        a(paramString.getString(2131893760));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "showNetTip, have shown. 3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.SmallScreenDavWTObserver
 * JD-Core Version:    0.7.0.1
 */