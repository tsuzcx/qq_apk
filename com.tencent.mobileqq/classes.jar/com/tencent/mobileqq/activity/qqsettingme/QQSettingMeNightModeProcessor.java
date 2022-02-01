package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.NightModeLogic;
import com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback;
import mqq.app.AppRuntime;

public class QQSettingMeNightModeProcessor
  extends QQSettingMeBaseProcessor
{
  private View jdField_a_of_type_AndroidViewView;
  public MutableLiveData<Integer> a;
  private final NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic$NightModeCallback = new QQSettingMeNightModeProcessor.1(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic;
  public MutableLiveData<Integer> b;
  private boolean b;
  
  public QQSettingMeNightModeProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = 0;
    if (AppSetting.d)
    {
      String str;
      if (!QQTheme.a()) {
        str = "关闭夜间模式";
      } else {
        str = "夜间模式 ";
      }
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, str, Button.class.getName());
    }
    QCircleUtils.a().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v87004.skin");
  }
  
  public String a()
  {
    return "d_night_mode";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidViewView = paramQQSettingMe.b;
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeNightModeProcessor.2(this, paramQQSettingMe));
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeNightModeProcessor.3(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic$NightModeCallback, false);
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a(paramAppRuntime);
      this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic$NightModeCallback, true);
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void b()
  {
    super.b();
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_MqqAppAppRuntime);
      this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic$NightModeCallback, true);
      this.jdField_b_of_type_Boolean = true;
    }
    g();
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      NightModeLogic localNightModeLogic = this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic;
      if (localNightModeLogic != null)
      {
        localNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic$NightModeCallback, false);
        this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a();
      }
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void f()
  {
    NightModeLogic localNightModeLogic = this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic;
    if (localNightModeLogic != null) {
      localNightModeLogic.b();
    }
  }
  
  public void g()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqVasThemeNightModeLogic.a();
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(Integer.valueOf(i));
  }
  
  public void onClick(View paramView)
  {
    if (!DarkModeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "", new QQSettingMeNightModeProcessor.4(this))) {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNightModeProcessor
 * JD-Core Version:    0.7.0.1
 */