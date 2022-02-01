package com.tencent.mobileqq.activity.qqsettingme;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Action;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.ActionType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;

public class QQSettingMeBaseMenuProcessor
  extends QQSettingMeBaseProcessor
{
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> a;
  
  public QQSettingMeBaseMenuProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  protected void a(View paramView) {}
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeBaseMenuProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    boolean bool;
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    QQSettingMeRedTouchUtil.a(paramAppInfo);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeBaseMenuProcessor.2(this, paramBoolean, paramAppInfo, bool));
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    Object localObject = QQSettingMe.a(a());
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "onClick(), bizId = ", a(), ", bizBean == null" });
      }
      return;
    }
    localObject = ((QQSettingMeBizBean)localObject).a();
    if (Uri.parse(((QQSettingMeBizBean.Action)localObject).jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "QQSettingMeBaseMenuProcessor#onClick, ", ((QQSettingMeBizBean.Action)localObject).jdField_a_of_type_JavaLangString, ", uri==null" });
      }
      ((QQSettingMeBizBean.Action)localObject).jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$ActionType = QQSettingMeBizBean.ActionType.DEFAULT;
    }
    FakeUrl localFakeUrl = new FakeUrl();
    localFakeUrl.init(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    int i = QQSettingMeBaseMenuProcessor.3.a[localObject.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$ActionType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          a(paramView);
          return;
        }
        localFakeUrl.gotoH5(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ((QQSettingMeBizBean.Action)localObject).jdField_a_of_type_JavaLangString, false, false);
        return;
      }
      localFakeUrl.gotoMqq(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ((QQSettingMeBizBean.Action)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ((QQSettingMeBizBean.Action)localObject).jdField_a_of_type_JavaLangString, 2066, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeBaseMenuProcessor
 * JD-Core Version:    0.7.0.1
 */