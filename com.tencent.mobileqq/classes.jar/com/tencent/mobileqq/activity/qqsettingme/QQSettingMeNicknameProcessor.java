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
  public MutableLiveData<String> a = new MutableLiveData();
  public MutableLiveData<QQSettingMeNicknameBean> b = new MutableLiveData();
  private String i;
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMeNicknameProcessor.1(this, paramQQSettingMe));
    this.b.observe(this.e, new QQSettingMeNicknameProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.c = paramAppRuntime;
    i();
  }
  
  public String b()
  {
    return "d_nickname";
  }
  
  public void c()
  {
    String str = this.c.getCurrentAccountUin();
    Object localObject = this.c.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(str);
    this.i = ((MobileQQ)localObject).getProperty(localStringBuilder.toString());
    localObject = this.i;
    if ((localObject == null) || ("".equals(((String)localObject).trim()))) {
      this.i = str;
    }
    this.a.setValue(this.i);
  }
  
  public void d()
  {
    super.d();
    String str = this.c.getCurrentAccountUin();
    if ((str != null) && (str.equals(this.i))) {
      ThreadManagerV2.executeOnSubThread(new QQSettingMeNicknameProcessor.3(this));
    }
    i();
  }
  
  public void i()
  {
    ThreadManagerV2.executeOnSubThread(new QQSettingMeNicknameProcessor.4(this));
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "jumpToProfile");
    }
    paramView = new AllInOne(this.c.getCurrentAccountUin(), 0);
    paramView.lastActivity = 1;
    paramView.profileEntryType = 8;
    ProfileUtils.openProfileCardForResult(this.d, paramView, 1009);
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface)this.c);
    ReportController.b(this.c, "CliOper", "", "", "0X80072D6", "0X80072D6", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor
 * JD-Core Version:    0.7.0.1
 */