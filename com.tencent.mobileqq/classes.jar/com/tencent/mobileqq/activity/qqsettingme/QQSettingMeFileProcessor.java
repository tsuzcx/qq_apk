package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeFileBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Action;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.ActionType;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSettingMeFileProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<QQSettingMeFileBean> b = new MutableLiveData();
  
  protected void a()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    ReportController.b(this.c, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
    Object localObject = localIRedTouchManager.getAppInfoByPath(String.valueOf(100160));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0))
    {
      localIRedTouchManager.reportLevelOneRedInfo(100160, 31);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("service_type", 2);
        localJSONObject.put("act_id", 1002);
        localIRedTouchManager.onReportBusinessRedTouch((BusinessInfoCheckUpdate.AppInfo)localObject, localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c.getCurrentAccountUin());
    ((StringBuilder)localObject).append("qqsettingme_f2f_guide");
    localBaseApplication.getSharedPreferences(((StringBuilder)localObject).toString(), 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
  }
  
  public void a(View paramView)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openMyFile(this.d);
    a();
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.e, new QQSettingMeFileProcessor.1(this, paramQQSettingMe));
  }
  
  public String b()
  {
    return "d_document";
  }
  
  protected void b(String paramString)
  {
    FakeUrl localFakeUrl = new FakeUrl();
    localFakeUrl.init(this.d);
    localFakeUrl.gotoMqq(this.d, paramString);
    a();
  }
  
  public void d()
  {
    super.d();
    i();
  }
  
  public void i()
  {
    QQSettingMeFileBean localQQSettingMeFileBean = new QQSettingMeFileBean();
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.getCurrentAccountUin());
    localStringBuilder.append("qqsettingme_f2f_guide");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localQQSettingMeFileBean.a = ((SharedPreferences)localObject).getInt("qqsettingme_f2f_guide_switch", 0);
    localQQSettingMeFileBean.b = ((SharedPreferences)localObject).getString("qqsettingme_f2f_guide_tip", HardCodeUtil.a(2131908382));
    localQQSettingMeFileBean.c = ((SharedPreferences)localObject).getBoolean("qqsettingme_f2f_guide_flag", false);
    this.b.setValue(localQQSettingMeFileBean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = QQSettingMe.a(b());
    if (localObject == null)
    {
      QLog.e("QQSettingMeFileProcessor", 1, new Object[] { "onClick(), bizId = ", b(), ", bizBean == null" });
      return;
    }
    localObject = ((QQSettingMeBizBean)localObject).g();
    if ((localObject != null) && (((QQSettingMeBizBean.Action)localObject).a == QQSettingMeBizBean.ActionType.SCHEMA) && (!TextUtils.isEmpty(((QQSettingMeBizBean.Action)localObject).b)))
    {
      b(((QQSettingMeBizBean.Action)localObject).b);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeFileProcessor
 * JD-Core Version:    0.7.0.1
 */