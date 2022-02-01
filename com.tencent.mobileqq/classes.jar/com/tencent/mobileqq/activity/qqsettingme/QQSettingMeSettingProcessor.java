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
  public MutableLiveData<QQSettingMeSettingBean> a;
  private final ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new QQSettingMeSettingProcessor.1(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  private boolean b;
  
  public QQSettingMeSettingProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public String a()
  {
    return "d_setting";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSettingProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.b) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, false);
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void a(boolean paramBoolean)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100190));
    if (this.jdField_a_of_type_Boolean)
    {
      QQSettingMeSettingBean localQQSettingMeSettingBean = new QQSettingMeSettingBean();
      localQQSettingMeSettingBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localAppInfo;
      localQQSettingMeSettingBean.jdField_a_of_type_Boolean = UpgradeController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      localQQSettingMeSettingBean.b = PrivacyPolicyHelper.a(1);
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeSettingProcessor.3(this, localAppInfo, localQQSettingMeSettingBean));
    }
  }
  
  public void b()
  {
    super.b();
    if ((!this.b) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, false);
      this.b = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
  }
  
  public void d()
  {
    if (this.b) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
  }
  
  public void g()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100190));
    QQSettingMeSettingBean localQQSettingMeSettingBean = new QQSettingMeSettingBean();
    localQQSettingMeSettingBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localAppInfo;
    localQQSettingMeSettingBean.jdField_a_of_type_Boolean = UpgradeController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    localQQSettingMeSettingBean.b = PrivacyPolicyHelper.a(1);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localQQSettingMeSettingBean);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQSettingSettingActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramView);
    if (UpgradeController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime)) {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", UpgradeController.a(), "");
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    if ((paramView != null) && (paramView.a != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
      ConfigHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramView.getAppInfoByPath(String.valueOf(100190));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(100190, 31);
    }
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = QQSettingMe.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSettingProcessor
 * JD-Core Version:    0.7.0.1
 */