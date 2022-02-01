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
  public MutableLiveData<Integer> a = new MutableLiveData();
  public MutableLiveData<Integer> b = new MutableLiveData();
  private NightModeLogic i;
  private boolean j;
  private View k;
  private final NightModeLogic.NightModeCallback l = new QQSettingMeNightModeProcessor.1(this);
  
  private void a()
  {
    this.k.setOnClickListener(null);
    this.k.setClickable(false);
    this.i.a(this.d);
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = 0;
    if (AppSetting.e)
    {
      String str;
      if (!QQTheme.isNowThemeIsNight()) {
        str = "关闭夜间模式";
      } else {
        str = "夜间模式 ";
      }
      AccessibilityUtil.a(this.k, str, Button.class.getName());
    }
    QCircleUtils.a().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v87006.skin");
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.k = paramQQSettingMe.f;
    this.a.observe(this.e, new QQSettingMeNightModeProcessor.2(this, paramQQSettingMe));
    this.b.observe(this.e, new QQSettingMeNightModeProcessor.3(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.j)
    {
      this.i.a(this.l, false);
      this.c = paramAppRuntime;
      this.i.a(paramAppRuntime);
      this.i.a(this.l, true);
      return;
    }
    this.c = paramAppRuntime;
  }
  
  public String b()
  {
    return "d_night_mode";
  }
  
  public void d()
  {
    super.d();
    if ((!this.j) || (this.i == null))
    {
      this.i = new NightModeLogic(this.c);
      this.i.a(this.l, true);
      this.j = true;
    }
    i();
  }
  
  public void f()
  {
    if (this.j)
    {
      NightModeLogic localNightModeLogic = this.i;
      if (localNightModeLogic != null)
      {
        localNightModeLogic.a(this.l, false);
        this.i.d();
      }
    }
    this.k = null;
  }
  
  public void h()
  {
    NightModeLogic localNightModeLogic = this.i;
    if (localNightModeLogic != null) {
      localNightModeLogic.e();
    }
  }
  
  public void i()
  {
    int m = this.i.a();
    this.a.setValue(Integer.valueOf(m));
  }
  
  public void onClick(View paramView)
  {
    if (!DarkModeManager.b(this.d, "", new QQSettingMeNightModeProcessor.4(this))) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNightModeProcessor
 * JD-Core Version:    0.7.0.1
 */