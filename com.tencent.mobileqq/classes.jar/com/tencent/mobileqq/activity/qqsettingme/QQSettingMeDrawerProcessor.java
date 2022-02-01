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
  public MutableLiveData<Boolean> a = new MutableLiveData(Boolean.valueOf(false));
  
  private boolean a()
  {
    return 1 == QzoneConfig.getInstance().getConfig("tianshu_feature", "red_touch_dismiss", 1);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMeDrawerProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(boolean paramBoolean)
  {
    VipInfoHandler.a(this.c.getCurrentUin());
    PrivacyPolicyHelper.a();
  }
  
  public String b()
  {
    return "d_common";
  }
  
  public void d()
  {
    super.d();
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!QQTheme.isNowThemeIsNight()) && (SimpleUIUtil.e())) {
      ImmersiveUtils.setStatusTextColor(true, this.d.getWindow());
    }
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(1);
  }
  
  public void e()
  {
    super.e();
    this.a.setValue(Boolean.valueOf(a()));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131432179) && (FrameHelperActivity.G()))
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.H();
      ReportController.b(this.c, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDrawerProcessor
 * JD-Core Version:    0.7.0.1
 */