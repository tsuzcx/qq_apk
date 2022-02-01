package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

public class QQSettingMeQRCodeProcessor
  extends QQSettingMeBaseProcessor
{
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> a;
  
  public QQSettingMeQRCodeProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public String a()
  {
    return "d_qrcode";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeQRCodeProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(boolean paramBoolean)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(101600));
    if (this.jdField_a_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeQRCodeProcessor.2(this, localAppInfo));
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QRDisplayActivity.class);
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    paramView.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131716714));
    paramView.putExtra("nick", ContactUtils.e((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, (String)localObject));
    paramView.putExtra("uin", (String)localObject);
    paramView.putExtra("type", 1);
    paramView.putExtra("reportFlag", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    localObject = paramView.getAppInfoByPath(String.valueOf(101600));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(101600, 31);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQRCodeProcessor
 * JD-Core Version:    0.7.0.1
 */