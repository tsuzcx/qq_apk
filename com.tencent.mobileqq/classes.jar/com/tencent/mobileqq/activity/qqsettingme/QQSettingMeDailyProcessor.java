package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDailyBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.Calendar;
import java.util.Date;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSettingMeDailyProcessor
  extends QQSettingMeBaseProcessor
{
  private int a;
  public MutableLiveData<QQSettingMeDailyBean> a;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean;
  
  public QQSettingMeDailyProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_Int = -1;
  }
  
  @NonNull
  private QQSettingMeDailyBean a()
  {
    if (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() == null) {
      return new QQSettingMeDailyBean();
    }
    return (QQSettingMeDailyBean)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue();
  }
  
  private boolean a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date(System.currentTimeMillis()));
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(new Date(paramLong));
    if (localCalendar2.get(1) == localCalendar1.get(1)) {
      return localCalendar2.get(6) - localCalendar1.get(6) == 0;
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (a().jdField_a_of_type_Int != 1) {
      return;
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      if (this.jdField_b_of_type_JavaLangString == null) {
        return;
      }
      TianShuReportData localTianShuReportData = new TianShuReportData();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null) {
        localObject = ((AppRuntime)localObject).getAccount();
      } else {
        localObject = "";
      }
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append(l);
      localTianShuReportData.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      localTianShuReportData.jdField_a_of_type_Int = 1;
      int i;
      if (paramBoolean) {
        i = 102;
      } else {
        i = 101;
      }
      localTianShuReportData.d = i;
      localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.103";
      localTianShuReportData.f = "tianshu.103";
      localTianShuReportData.g = String.valueOf(this.jdField_a_of_type_Int);
      localTianShuReportData.jdField_e_of_type_Int = 1;
      localTianShuReportData.l = this.jdField_b_of_type_JavaLangString;
      localTianShuReportData.jdField_a_of_type_Long = l;
      TianShuManager.getInstance().report(localTianShuReportData);
    }
  }
  
  public String a()
  {
    return "d_daily";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeDailyProcessor.1(this, paramQQSettingMe));
  }
  
  public void b()
  {
    super.b();
    g();
    TianShuManager.setLastClickAdTraceInfo("", "");
    b(false);
  }
  
  public void f()
  {
    g();
  }
  
  public void g()
  {
    Object localObject1 = this;
    QQSettingMeDailyBean localQQSettingMeDailyBean = a();
    localQQSettingMeDailyBean.c = HardCodeUtil.a(2131710712);
    localQQSettingMeDailyBean.jdField_b_of_type_Int = 0;
    SharedPreferences localSharedPreferences = ((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getPreferences();
    long l1 = localSharedPreferences.getLong("sign_in_time_stamp", 0L);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    ((StringBuilder)localObject3).append("sign_in_info");
    String str = localSharedPreferences.getString(((StringBuilder)localObject3).toString(), "");
    try
    {
      localObject3 = new JSONObject(str);
      localQQSettingMeDailyBean.jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("type");
      localQQSettingMeDailyBean.jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("day");
    }
    catch (JSONException localJSONException4)
    {
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("doUpdateDailySignInItemView JSONException, json = ");
        ((StringBuilder)localObject5).append(str);
        QLog.i("DailySignIn", 2, ((StringBuilder)localObject5).toString());
      }
      localJSONException4.printStackTrace();
    }
    if (!((QQSettingMeDailyProcessor)localObject1).a(l1 * 1000L))
    {
      localQQSettingMeDailyBean.jdField_a_of_type_Int = 1;
      localQQSettingMeDailyBean.jdField_b_of_type_Int = 0;
    }
    Object localObject4;
    int i;
    if (LocaleManager.a() != 1033)
    {
      long l2;
      int j;
      try
      {
        ((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_Int = -1;
        localObject4 = null;
        ((QQSettingMeDailyProcessor)localObject1).jdField_b_of_type_JavaLangString = null;
        i = localQQSettingMeDailyBean.jdField_a_of_type_Int;
        if (i == 1)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
          ((StringBuilder)localObject5).append("sign_in_operation");
          ((StringBuilder)localObject5).append("11");
          localObject5 = localSharedPreferences.getString(((StringBuilder)localObject5).toString(), "");
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject1 = new JSONObject((String)localObject5);
            i = ((JSONObject)localObject1).optInt("start_time");
            l1 = i;
          }
        }
      }
      catch (JSONException localJSONException2) {}
    }
    try
    {
      l2 = ((JSONObject)localObject1).optInt("end_time");
      if ((System.currentTimeMillis() > l1 * 1000L) && (System.currentTimeMillis() < l2 * 1000L))
      {
        i = ((JSONObject)localObject1).optInt("id", -1);
        localObject4 = this;
        ((QQSettingMeDailyProcessor)localObject4).jdField_a_of_type_Int = i;
        ((QQSettingMeDailyProcessor)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("trace_info", null);
        break label1539;
      }
      localObject1 = null;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
      ((StringBuilder)localObject4).append("sign_in_operation");
      ((StringBuilder)localObject4).append("10");
      localObject4 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1509;
      }
      localObject1 = new JSONObject((String)localObject4);
    }
    catch (JSONException localJSONException3)
    {
      QQSettingMeDailyProcessor localQQSettingMeDailyProcessor;
      break label1051;
      localObject5 = "end_time";
      localObject4 = localJSONException3;
      localObject2 = localObject5;
    }
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    ((StringBuilder)localObject5).append("sign_in_operation");
    ((StringBuilder)localObject5).append("10");
    localObject5 = localSharedPreferences.getString(((StringBuilder)localObject5).toString(), "");
    localObject1 = localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      localObject1 = new JSONObject((String)localObject5);
      break label1509;
      localQQSettingMeDailyBean.c = HardCodeUtil.a(2131710705);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
      ((StringBuilder)localObject4).append("sign_in_operation");
      ((StringBuilder)localObject4).append("41");
      localObject4 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject4 = new JSONObject((String)localObject4);
        l1 = ((JSONObject)localObject4).optInt("start_time");
        l2 = ((JSONObject)localObject4).optInt("end_time");
        if (System.currentTimeMillis() > l1 * 1000L) {
          if (System.currentTimeMillis() < l2 * 1000L) {
            break label1535;
          }
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
        ((StringBuilder)localObject4).append("sign_in_operation");
        ((StringBuilder)localObject4).append("40");
        localObject1 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1565;
        }
        localObject1 = new JSONObject((String)localObject1);
        break label1549;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((QQSettingMeDailyProcessor)localObject1).jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
      ((StringBuilder)localObject4).append("sign_in_operation");
      ((StringBuilder)localObject4).append("40");
      localObject1 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1565;
      }
      localObject1 = new JSONObject((String)localObject1);
      break label1549;
      if (localObject1 != null)
      {
        l1 = ((JSONObject)localObject1).optInt("start_time");
        j = ((JSONObject)localObject1).optInt((String)localObject5);
        l2 = j;
        try
        {
          if ((System.currentTimeMillis() <= l1 * 1000L) || (System.currentTimeMillis() >= l2 * 1000L)) {
            break label1143;
          }
          localQQSettingMeDailyBean.c = ((JSONObject)localObject1).optString("template_text");
          localObject4 = ((JSONObject)localObject1).optString("bytes_url");
          if (i != 0)
          {
            localQQSettingMeDailyBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("bytes_icon_url");
            localQQSettingMeDailyBean.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("bytes_icon_custom_url");
          }
          else
          {
            localQQSettingMeDailyBean.jdField_a_of_type_JavaLangString = "";
            localQQSettingMeDailyBean.jdField_b_of_type_JavaLangString = "";
          }
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label1143;
          }
          localObject1 = localSharedPreferences.edit();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
          ((StringBuilder)localObject5).append("sign_in_jump_url");
          ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject5).toString(), (String)localObject4).commit();
        }
        catch (JSONException localJSONException1) {}
        label1051:
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("doUpdateDailySignInItemView JSONException, json = ");
          ((StringBuilder)localObject4).append(str);
          QLog.i("DailySignIn", 2, ((StringBuilder)localObject4).toString());
        }
        localJSONException2.printStackTrace();
        break label1143;
        if (localQQSettingMeDailyBean.jdField_a_of_type_Int == 1) {
          localQQSettingMeDailyBean.c = HardCodeUtil.a(2131710712);
        } else if (localQQSettingMeDailyBean.jdField_a_of_type_Int == 4) {
          localQQSettingMeDailyBean.c = HardCodeUtil.a(2131710705);
        }
      }
      label1143:
      localQQSettingMeDailyProcessor = this;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("doUpdateDailySignInItemView type=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.jdField_a_of_type_Int);
        ((StringBuilder)localObject4).append(" iconUrl=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject4).append(" wording=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.c);
        ((StringBuilder)localObject4).append(" day=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.jdField_b_of_type_Int);
        ((StringBuilder)localObject4).append("coverIconUrl");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.jdField_b_of_type_JavaLangString);
        QLog.i("DailySignIn", 2, ((StringBuilder)localObject4).toString());
      }
      localQQSettingMeDailyBean.jdField_a_of_type_Boolean = true;
      if (localQQSettingMeDailyBean.jdField_a_of_type_Int == 4)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("use signed wording:");
          ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.c);
          QLog.i("DailySignIn", 2, ((StringBuilder)localObject4).toString());
        }
        if (localQQSettingMeDailyBean.jdField_b_of_type_Int > 0) {
          localQQSettingMeDailyBean.c = String.format(localQQSettingMeDailyBean.c, new Object[] { Integer.valueOf(localQQSettingMeDailyBean.jdField_b_of_type_Int) });
        }
        if ((localQQSettingMeDailyProcessor.jdField_a_of_type_Boolean) && (!localQQSettingMeDailyProcessor.jdField_b_of_type_Boolean))
        {
          localQQSettingMeDailyProcessor.jdField_b_of_type_Boolean = true;
          ReportController.b(localQQSettingMeDailyProcessor.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800ACFC", "0X800ACFC", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use unsigned wording");
        }
        if ((localQQSettingMeDailyProcessor.jdField_a_of_type_Boolean) && (!localQQSettingMeDailyProcessor.jdField_b_of_type_Boolean))
        {
          localQQSettingMeDailyProcessor.jdField_b_of_type_Boolean = true;
          ReportController.b(localQQSettingMeDailyProcessor.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800ACFB", "0X800ACFB", 0, 0, "", "", "", "");
        }
      }
      localQQSettingMeDailyProcessor.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeDailyBean);
      return;
    }
    for (;;)
    {
      label1509:
      i = 0;
      localObject5 = localObject2;
      Object localObject2 = localObject4;
      break;
      label1535:
      localObject2 = localObject4;
      label1539:
      localObject5 = "end_time";
      i = 1;
      break;
      label1549:
      localObject5 = "end_time";
      localObject4 = localObject2;
      localObject2 = localObject5;
      continue;
      label1565:
      localObject2 = "end_time";
      localObject4 = null;
    }
  }
  
  public void h()
  {
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getSignInInfo(0);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (a().jdField_a_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
      ((StringBuilder)localObject).append("sign_in_jump_url");
      paramView = paramView.getString(((StringBuilder)localObject).toString(), "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_ad_daka");
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      if (a().jdField_a_of_type_Int == 1) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800ACFD", "0X800ACFD", 0, 0, "", "", "", "");
      } else if (a().jdField_a_of_type_Int == 4) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800ACFE", "0X800ACFE", 0, 0, "", "", "", "");
      }
      b(true);
    }
    else
    {
      paramView = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task_entry_config");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      paramView = paramView.getSharedPreferences(((StringBuilder)localObject).toString(), 0).getString("jump_url", "");
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_ad_daka");
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("myDaily onClick mDailySignMode = ");
      paramView.append(a().jdField_a_of_type_Boolean);
      QLog.i("DailySignIn", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDailyProcessor
 * JD-Core Version:    0.7.0.1
 */