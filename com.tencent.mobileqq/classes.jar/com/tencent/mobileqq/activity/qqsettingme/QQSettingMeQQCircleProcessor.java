package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QQSettingMeQQCircleProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<Boolean> b = new MutableLiveData();
  
  public String a()
  {
    return "d_smallworld";
  }
  
  public void a()
  {
    this.b.setValue(Boolean.valueOf(QzoneConfig.isQQCircleShowDrawTabEntrance()));
  }
  
  public void a(View paramView)
  {
    paramView = new HashMap();
    paramView.put("uin", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    paramView.put("key_jump_from", "9");
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.context, "openmainpage", paramView);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.b.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeQQCircleProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public void b()
  {
    super.b();
    this.b.setValue(Boolean.valueOf(QzoneConfig.isQQCircleShowDrawTabEntrance()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQQCircleProcessor
 * JD-Core Version:    0.7.0.1
 */