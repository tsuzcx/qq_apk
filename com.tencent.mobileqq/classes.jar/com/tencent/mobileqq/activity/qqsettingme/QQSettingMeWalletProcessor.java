package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.QQSettingUtil;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;

public class QQSettingMeWalletProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public String a()
  {
    return "d_qqwallet";
  }
  
  public void a(View paramView)
  {
    if (!((IQWalletHelper)QRoute.api(IQWalletHelper.class)).isValidToLaunchQWallet(System.currentTimeMillis())) {
      return;
    }
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, true, true);
    QQSettingUtil.c((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    boolean bool = QQSettingMe.a("d_qqwallet").c();
    if ((this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() != null) && (((BusinessInfoCheckUpdate.AppInfo)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).iNewFlag.get() != 0)) {
      ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(100007, 31);
    }
    int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), bool);
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin();
    if (bool) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
    localStringBuilder.append("");
    ReportController.b(localAppRuntime, "P_CliOper", "Vip_pay_mywallet", str, "wallet", "wallet.entrance.click", 0, 0, paramView, localStringBuilder.toString(), "", "8.7.0");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i, 0, String.valueOf(i), "", "", "");
    if (QQSettingMe.a > 0)
    {
      com.tencent.mobileqq.activity.recent.DrawerFrame.a = 2;
      return;
    }
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = QQSettingMe.a;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    int i = localIRedTouchManager.getNumRedNumByAppIdAndMsgType(100007, 100);
    if (i > 0) {
      paramAppInfo = localIRedTouchManager.createNumAppInfo(1, 100007, "100007", i, false);
    }
    super.a(paramAppInfo, paramBoolean);
  }
  
  public void b()
  {
    super.b();
    if (QQSettingMe.a("d_qqwallet").getVisibility() != 0) {
      return;
    }
    int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), false);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i, 0, String.valueOf(i), "", "", "");
    Object localObject = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(100007));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1)) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
    localStringBuilder.append("");
    ReportController.b(localAppRuntime, "P_CliOper", "Vip_pay_mywallet", str, "wallet", "wallet.entrance.show", 0, 0, (String)localObject, localStringBuilder.toString(), "", "8.7.0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWalletProcessor
 * JD-Core Version:    0.7.0.1
 */