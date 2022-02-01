package com.tencent.mobileqq.app.qzonelover;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_ICON.lighting_sweet_key_rsp;
import SWEET_NEW_ICON.sweet_upgrade_key_notify_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class QzoneLoverService
  implements BusinessObserver
{
  private static volatile QzoneLoverService b;
  private static Object c = new Object();
  private volatile boolean a = false;
  private volatile boolean d = false;
  
  public static QzoneLoverService a()
  {
    if (b == null) {
      synchronized (c)
      {
        if (b == null) {
          b = new QzoneLoverService();
        }
      }
    }
    return b;
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (sweet_upgrade_key_notify_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle != null) && (paramBoolean) && (paramBundle.req_comm != null))
    {
      if ((paramBundle.rsp_comm != null) && (paramBundle.rsp_comm.retcode == 0))
      {
        if (paramBundle.req_comm.uin != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetLoverCheckData succed(");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("), uin: ");
          ((StringBuilder)localObject).append(paramBundle.req_comm.uin);
          ((StringBuilder)localObject).append(", loginUin: ");
          ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
          QLog.i("QzoneLoverService", 1, ((StringBuilder)localObject).toString());
          return;
        }
        d();
        long l = paramBundle.req_comm.loveuin;
        if (l <= 10000L) {
          return;
        }
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          ((FriendListHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendDetailInfo(String.valueOf(l));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetLoverCheckData succed(");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("), uin:");
          ((StringBuilder)localObject).append(paramBundle.req_comm.uin);
          QLog.i("QzoneLoverService", 1, ((StringBuilder)localObject).toString());
        }
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetLoverCheckData succed(false), ret code: ");
      if (paramBundle.rsp_comm == null) {
        paramBundle = "null";
      } else {
        paramBundle = String.valueOf(paramBundle.rsp_comm.retcode);
      }
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("QzoneLoverService", 1, ((StringBuilder)localObject).toString());
      e();
      return;
    }
    QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(false)");
    e();
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.d = false;
    paramBundle = (lighting_sweet_key_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle != null) && (paramBoolean))
    {
      if ((paramBundle.rsp_comm != null) && (paramBundle.rsp_comm.retcode == 0))
      {
        f();
        paramBundle = new StringBuilder();
        paramBundle.append("onGetLoverLightingData succed(");
        paramBundle.append(paramBoolean);
        paramBundle.append(")");
        QLog.i("QzoneLoverService", 1, paramBundle.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetLoverLightingData succed(false), ret code: ");
      if (paramBundle.rsp_comm == null) {
        paramBundle = "null";
      } else {
        paramBundle = String.valueOf(paramBundle.rsp_comm.retcode);
      }
      localStringBuilder.append(paramBundle);
      QLog.i("QzoneLoverService", 1, localStringBuilder.toString());
      g();
      return;
    }
    QLog.i("QzoneLoverService", 1, "onGetLoverLightingData succed(false)");
    g();
  }
  
  private void d()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putBoolean("checkQzoneLoverSend2", true).apply();
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (l != localSharedPreferences.getLong("checkQzoneLoverLastFailTime", 0L))
    {
      localSharedPreferences.edit().putInt("checkQzoneLoverFailCount", 1);
    }
    else
    {
      int i = localSharedPreferences.getInt("checkQzoneLoverFailCount", 0);
      localSharedPreferences.edit().putInt("checkQzoneLoverFailCount", i + 1);
    }
    localSharedPreferences.edit().putLong("checkQzoneLoverLastFailTime", l);
    localSharedPreferences.edit().apply();
  }
  
  private void f()
  {
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putLong("lightingQzoneLoverTime", l).apply();
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (l != localSharedPreferences.getLong("lightingQzoneLoverLastFailTime", 0L))
    {
      localSharedPreferences.edit().putInt("lightingQzoneLoverFailCount", 1);
    }
    else
    {
      int i = localSharedPreferences.getInt("lightingQzoneLoverFailCount", 0);
      localSharedPreferences.edit().putInt("lightingQzoneLoverFailCount", i + 1);
    }
    localSharedPreferences.edit().putLong("lightingQzoneLoverLastFailTime", l);
    localSharedPreferences.edit().apply();
  }
  
  private boolean h()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool = false;
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(str, 0);
    if (System.currentTimeMillis() / 1000L / 3600L / 24L != ((SharedPreferences)localObject).getLong("lightingQzoneLoverLastFailTime", 0L)) {
      return false;
    }
    if (((SharedPreferences)localObject).getInt("lightingQzoneLoverFailCount", 0) >= QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLoverMaxFailCount", 10)) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest sending...");
      }
      return;
    }
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest false");
      }
      return;
    }
    if (h())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest fail count hit max count!!!");
      }
      return;
    }
    this.d = true;
    QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest true");
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), QzoneLoverLightingServlet.class);
    QzoneLoverLightingServlet.a(localNewIntent, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (!this.a)
    {
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
      this.a = true;
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public boolean c()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool = false;
    long l1 = ((BaseApplicationImpl)localObject).getSharedPreferences(str, 0).getLong("lightingQzoneLoverTime", 0L);
    long l2 = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startQzoneLoverLightingRequest curDay(");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("), lastDay(");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(")");
      QLog.i("QzoneLoverService", 2, ((StringBuilder)localObject).toString());
    }
    if (l2 != l1) {
      bool = true;
    }
    return bool;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      a(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 291) {
      b(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverService
 * JD-Core Version:    0.7.0.1
 */