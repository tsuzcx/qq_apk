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
  public MutableLiveData<QQSettingMePrettyNumBean> a;
  private boolean b;
  
  public QQSettingMePrettyNumProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public String a()
  {
    return "d_pretty_num";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMePrettyNumProcessor.1(this, paramQQSettingMe));
  }
  
  public void c()
  {
    super.c();
    this.b = false;
  }
  
  public void f()
  {
    g();
  }
  
  public void g()
  {
    QQSettingMePrettyNumBean localQQSettingMePrettyNumBean = new QQSettingMePrettyNumBean();
    boolean bool;
    if ((PrettyAccountUtil.a() == 1) && (PrettyAccountUtil.a())) {
      bool = true;
    } else {
      bool = false;
    }
    localQQSettingMePrettyNumBean.jdField_a_of_type_Boolean = bool;
    if (!localQQSettingMePrettyNumBean.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localQQSettingMePrettyNumBean);
      return;
    }
    localQQSettingMePrettyNumBean.jdField_a_of_type_MQQLhLogoResources = PrettyAccountUtil.a(PrettyAccountUtil.b());
    if (localQQSettingMePrettyNumBean.jdField_a_of_type_MQQLhLogoResources == null)
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localQQSettingMePrettyNumBean);
      return;
    }
    if (!this.b)
    {
      PrettyAccountUtil.a("0X800B231", PrettyAccountUtil.a(), PrettyAccountUtil.b());
      this.b = true;
    }
    String str = localQQSettingMePrettyNumBean.jdField_a_of_type_MQQLhLogoResources.logoUrl;
    Drawable localDrawable = URLDrawableHelperConstants.a;
    localQQSettingMePrettyNumBean.jdField_a_of_type_ComTencentImageURLDrawable = VasApngUtil.getApngURLDrawable(str, new int[] { 1 }, localDrawable, null, null);
    localQQSettingMePrettyNumBean.b = ThemeUtil.isNowThemeIsNight(null, false, null);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localQQSettingMePrettyNumBean);
  }
  
  public void onClick(View paramView)
  {
    PrettyAccountUtil.a();
    PrettyAccountUtil.a("0X800B232", PrettyAccountUtil.a(), PrettyAccountUtil.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMePrettyNumProcessor
 * JD-Core Version:    0.7.0.1
 */