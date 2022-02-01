package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSettingBean;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import mqq.app.AppRuntime;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingMeSettingProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<QQSettingMeSettingBean> a = new MutableLiveData();
  private UpgradeDetailWrapper b;
  private final ConfigObserver i = new QQSettingMeSettingProcessor.1(this);
  private boolean j;
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMeSettingProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.j) && (this.c != null))
    {
      ((QQAppInterface)this.c).removeObserver(this.i);
      this.c = paramAppRuntime;
      ((QQAppInterface)this.c).addObserver(this.i, false);
      return;
    }
    this.c = paramAppRuntime;
  }
  
  public void a(boolean paramBoolean)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100190));
    if (this.g)
    {
      QQSettingMeSettingBean localQQSettingMeSettingBean = new QQSettingMeSettingBean();
      localQQSettingMeSettingBean.a = localAppInfo;
      localQQSettingMeSettingBean.b = UpgradeController.b((QQAppInterface)this.c);
      localQQSettingMeSettingBean.c = PrivacyPolicyHelper.a(1);
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeSettingProcessor.3(this, localAppInfo, localQQSettingMeSettingBean));
    }
  }
  
  public String b()
  {
    return "d_setting";
  }
  
  public void d()
  {
    super.d();
    if ((!this.j) && (this.c != null))
    {
      ((QQAppInterface)this.c).addObserver(this.i, false);
      this.j = true;
    }
    this.b = UpgradeController.a().d();
  }
  
  public void f()
  {
    if (this.j) {
      ((QQAppInterface)this.c).removeObserver(this.i);
    }
  }
  
  public void i()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100190));
    QQSettingMeSettingBean localQQSettingMeSettingBean = new QQSettingMeSettingBean();
    localQQSettingMeSettingBean.a = localAppInfo;
    localQQSettingMeSettingBean.b = UpgradeController.b((QQAppInterface)this.c);
    localQQSettingMeSettingBean.c = PrivacyPolicyHelper.a(1);
    this.a.postValue(localQQSettingMeSettingBean);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.d, QQSettingSettingActivity.class);
    this.d.startActivity(paramView);
    if (UpgradeController.b((QQAppInterface)this.c)) {
      ReportController.b(this.c, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", UpgradeController.k(), "");
    }
    paramView = this.b;
    if ((paramView != null) && (paramView.b != null) && (this.b.b.iUpgradeType > 0)) {
      ConfigHandler.a((QQAppInterface)this.c, this.b.b.iNewTimeStamp);
    }
    ReportController.b(this.c, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramView.getAppInfoByPath(String.valueOf(100190));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(100190, 31);
    }
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSettingProcessor
 * JD-Core Version:    0.7.0.1
 */