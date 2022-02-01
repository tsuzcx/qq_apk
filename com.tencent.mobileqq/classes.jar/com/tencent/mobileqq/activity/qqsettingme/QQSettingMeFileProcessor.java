package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeFileBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSettingMeFileProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<QQSettingMeFileBean> b = new MutableLiveData();
  
  public String a()
  {
    return "d_document";
  }
  
  public void a(View paramView)
  {
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openMyFile(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.jdField_a_of_type_Int = QQSettingMe.jdField_a_of_type_Int;
    Object localObject = paramView.getAppInfoByPath(String.valueOf(100160));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0))
    {
      paramView.reportLevelOneRedInfo(100160, 31);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("service_type", 2);
        localJSONObject.put("act_id", 1002);
        paramView.onReportBusinessRedTouch((BusinessInfoCheckUpdate.AppInfo)localObject, localJSONObject.toString());
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
    }
    paramView = BaseApplication.getContext();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    ((StringBuilder)localObject).append("qqsettingme_f2f_guide");
    paramView.getSharedPreferences(((StringBuilder)localObject).toString(), 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeFileProcessor.1(this, paramQQSettingMe));
  }
  
  public void b()
  {
    super.b();
    g();
  }
  
  public void g()
  {
    QQSettingMeFileBean localQQSettingMeFileBean = new QQSettingMeFileBean();
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localStringBuilder.append("qqsettingme_f2f_guide");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localQQSettingMeFileBean.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("qqsettingme_f2f_guide_switch", 0);
    localQQSettingMeFileBean.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject).getString("qqsettingme_f2f_guide_tip", HardCodeUtil.a(2131710701));
    localQQSettingMeFileBean.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("qqsettingme_f2f_guide_flag", false);
    this.b.setValue(localQQSettingMeFileBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeFileProcessor
 * JD-Core Version:    0.7.0.1
 */