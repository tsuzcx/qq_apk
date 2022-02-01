package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.LhLogoResources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMePrettyNumBean;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;

public class QQSettingMePrettyNumProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<QQSettingMePrettyNumBean> a = new MutableLiveData();
  private boolean b;
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMePrettyNumProcessor.1(this, paramQQSettingMe));
  }
  
  public String b()
  {
    return "d_pretty_num";
  }
  
  public void e()
  {
    super.e();
    this.b = false;
  }
  
  public void h()
  {
    i();
  }
  
  public void i()
  {
    QQSettingMePrettyNumBean localQQSettingMePrettyNumBean = new QQSettingMePrettyNumBean();
    boolean bool;
    if ((PrettyAccountUtil.b() == 1) && (PrettyAccountUtil.a())) {
      bool = true;
    } else {
      bool = false;
    }
    localQQSettingMePrettyNumBean.a = bool;
    if (!localQQSettingMePrettyNumBean.a)
    {
      this.a.postValue(localQQSettingMePrettyNumBean);
      return;
    }
    localQQSettingMePrettyNumBean.b = PrettyAccountUtil.a(PrettyAccountUtil.c());
    if (localQQSettingMePrettyNumBean.b == null)
    {
      this.a.postValue(localQQSettingMePrettyNumBean);
      return;
    }
    if (!this.b)
    {
      PrettyAccountUtil.a("0X800B231", PrettyAccountUtil.b(), PrettyAccountUtil.c());
      this.b = true;
    }
    String str = localQQSettingMePrettyNumBean.b.logoUrl;
    Drawable localDrawable = URLDrawableHelperConstants.a;
    localQQSettingMePrettyNumBean.c = VasApngUtil.getApngURLDrawable(str, new int[] { 1 }, localDrawable, null, null);
    localQQSettingMePrettyNumBean.d = ThemeUtil.isNowThemeIsNight(null, false, null);
    this.a.postValue(localQQSettingMePrettyNumBean);
  }
  
  public void onClick(View paramView)
  {
    PrettyAccountUtil.d();
    PrettyAccountUtil.a("0X800B232", PrettyAccountUtil.b(), PrettyAccountUtil.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMePrettyNumProcessor
 * JD-Core Version:    0.7.0.1
 */