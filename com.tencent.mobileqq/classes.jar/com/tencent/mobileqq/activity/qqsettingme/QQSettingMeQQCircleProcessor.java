package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QQSettingMeQQCircleProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<Boolean> b = new MutableLiveData();
  
  public void a(View paramView)
  {
    paramView = new HashMap();
    paramView.put("uin", this.c.getCurrentUin());
    paramView.put("key_jump_from", "9");
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.context, "openmainpage", paramView);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.b.observe(this.e, new QQSettingMeQQCircleProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public String b()
  {
    return "d_smallworld";
  }
  
  public void c()
  {
    this.b.setValue(Boolean.valueOf(QCircleConfigHelper.bp()));
  }
  
  public void d()
  {
    super.d();
    this.b.setValue(Boolean.valueOf(QCircleConfigHelper.bp()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQQCircleProcessor
 * JD-Core Version:    0.7.0.1
 */