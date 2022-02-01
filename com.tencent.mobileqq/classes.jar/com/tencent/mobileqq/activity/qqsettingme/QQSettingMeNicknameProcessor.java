package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeNicknameBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class QQSettingMeNicknameProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<String> a;
  public MutableLiveData<QQSettingMeNicknameBean> b;
  private String b;
  
  public QQSettingMeNicknameProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public String a()
  {
    return "d_nickname";
  }
  
  public void a()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(str);
    this.jdField_b_of_type_JavaLangString = ((MobileQQ)localObject).getProperty(localStringBuilder.toString());
    localObject = this.jdField_b_of_type_JavaLangString;
    if ((localObject == null) || ("".equals(((String)localObject).trim()))) {
      this.jdField_b_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeNicknameProcessor.1(this, paramQQSettingMe));
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeNicknameProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    g();
  }
  
  public void b()
  {
    super.b();
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if ((str != null) && (str.equals(this.jdField_b_of_type_JavaLangString))) {
      ThreadManagerV2.executeOnSubThread(new QQSettingMeNicknameProcessor.3(this));
    }
    g();
  }
  
  public void g()
  {
    ThreadManagerV2.executeOnSubThread(new QQSettingMeNicknameProcessor.4(this));
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "jumpToProfile");
    }
    paramView = new AllInOne(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
    paramView.lastActivity = 1;
    paramView.profileEntryType = 8;
    ProfileUtils.openProfileCardForResult(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramView, 1009);
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80072D6", "0X80072D6", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor
 * JD-Core Version:    0.7.0.1
 */