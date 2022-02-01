package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class QQSettingMeDrawerProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<Boolean> a;
  
  public QQSettingMeDrawerProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData(Boolean.valueOf(false));
  }
  
  private boolean a()
  {
    return 1 == QzoneConfig.getInstance().getConfig("tianshu_feature", "red_touch_dismiss", 1);
  }
  
  public String a()
  {
    return "d_common";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeDrawerProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(boolean paramBoolean)
  {
    VipInfoHandler.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    PrivacyPolicyHelper.a();
  }
  
  public void b()
  {
    super.b();
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!QQTheme.a()) && (SimpleUIUtil.a())) {
      ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
    }
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(1);
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(Boolean.valueOf(a()));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131365911) && (FrameHelperActivity.b()))
    {
      FrameHelperActivity.b(true);
      FrameHelperActivity.w();
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDrawerProcessor
 * JD-Core Version:    0.7.0.1
 */