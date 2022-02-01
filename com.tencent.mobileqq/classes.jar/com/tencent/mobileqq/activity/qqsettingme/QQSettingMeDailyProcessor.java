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
  public MutableLiveData<QQSettingMeDailyBean> a = new MutableLiveData();
  private int b = -1;
  private String i = null;
  private boolean j;
  
  @NonNull
  private QQSettingMeDailyBean a()
  {
    if (this.a.getValue() == null) {
      return new QQSettingMeDailyBean();
    }
    return (QQSettingMeDailyBean)this.a.getValue();
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
    if (a().a != 1) {
      return;
    }
    if (this.b != -1)
    {
      if (this.i == null) {
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
      localTianShuReportData.b = localStringBuilder.toString();
      localTianShuReportData.c = 1;
      int k;
      if (paramBoolean) {
        k = 102;
      } else {
        k = 101;
      }
      localTianShuReportData.p = k;
      localTianShuReportData.f = "tianshu.103";
      localTianShuReportData.g = "tianshu.103";
      localTianShuReportData.h = String.valueOf(this.b);
      localTianShuReportData.q = 1;
      localTianShuReportData.s = this.i;
      localTianShuReportData.o = l;
      TianShuManager.getInstance().report(localTianShuReportData);
    }
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMeDailyProcessor.1(this, paramQQSettingMe));
  }
  
  public String b()
  {
    return "d_daily";
  }
  
  public void d()
  {
    super.d();
    i();
    TianShuManager.setLastClickAdTraceInfo("", "");
    b(false);
  }
  
  public void h()
  {
    i();
  }
  
  public void i()
  {
    Object localObject1 = this;
    QQSettingMeDailyBean localQQSettingMeDailyBean = a();
    localQQSettingMeDailyBean.e = HardCodeUtil.a(2131908395);
    localQQSettingMeDailyBean.f = 0;
    SharedPreferences localSharedPreferences = ((QQSettingMeDailyProcessor)localObject1).c.getPreferences();
    long l1 = localSharedPreferences.getLong("sign_in_time_stamp", 0L);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((QQSettingMeDailyProcessor)localObject1).c.getCurrentUin());
    ((StringBuilder)localObject3).append("sign_in_info");
    String str = localSharedPreferences.getString(((StringBuilder)localObject3).toString(), "");
    try
    {
      localObject3 = new JSONObject(str);
      localQQSettingMeDailyBean.a = ((JSONObject)localObject3).optInt("type");
      localQQSettingMeDailyBean.f = ((JSONObject)localObject3).optInt("day");
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
      localQQSettingMeDailyBean.a = 1;
      localQQSettingMeDailyBean.f = 0;
    }
    Object localObject4;
    int k;
    if (LocaleManager.d() != 1033)
    {
      long l2;
      int m;
      try
      {
        ((QQSettingMeDailyProcessor)localObject1).b = -1;
        localObject4 = null;
        ((QQSettingMeDailyProcessor)localObject1).i = null;
        k = localQQSettingMeDailyBean.a;
        if (k == 1)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((QQSettingMeDailyProcessor)localObject1).c.getCurrentUin());
          ((StringBuilder)localObject5).append("sign_in_operation");
          ((StringBuilder)localObject5).append("11");
          localObject5 = localSharedPreferences.getString(((StringBuilder)localObject5).toString(), "");
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject1 = new JSONObject((String)localObject5);
            k = ((JSONObject)localObject1).optInt("start_time");
            l1 = k;
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
        k = ((JSONObject)localObject1).optInt("id", -1);
        localObject4 = this;
        ((QQSettingMeDailyProcessor)localObject4).b = k;
        ((QQSettingMeDailyProcessor)localObject4).i = ((JSONObject)localObject1).optString("trace_info", null);
        break label1540;
      }
      localObject1 = null;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.c.getCurrentUin());
      ((StringBuilder)localObject4).append("sign_in_operation");
      ((StringBuilder)localObject4).append("10");
      localObject4 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1510;
      }
      localObject1 = new JSONObject((String)localObject4);
    }
    catch (JSONException localJSONException3)
    {
      QQSettingMeDailyProcessor localQQSettingMeDailyProcessor;
      break label1052;
      localObject5 = "end_time";
      localObject4 = localJSONException3;
      localObject2 = localObject5;
    }
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(((QQSettingMeDailyProcessor)localObject1).c.getCurrentUin());
    ((StringBuilder)localObject5).append("sign_in_operation");
    ((StringBuilder)localObject5).append("10");
    localObject5 = localSharedPreferences.getString(((StringBuilder)localObject5).toString(), "");
    localObject1 = localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      localObject1 = new JSONObject((String)localObject5);
      break label1510;
      localQQSettingMeDailyBean.e = HardCodeUtil.a(2131908386);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((QQSettingMeDailyProcessor)localObject1).c.getCurrentUin());
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
            break label1536;
          }
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((QQSettingMeDailyProcessor)localObject1).c.getCurrentUin());
        ((StringBuilder)localObject4).append("sign_in_operation");
        ((StringBuilder)localObject4).append("40");
        localObject1 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1566;
        }
        localObject1 = new JSONObject((String)localObject1);
        break label1550;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((QQSettingMeDailyProcessor)localObject1).c.getCurrentUin());
      ((StringBuilder)localObject4).append("sign_in_operation");
      ((StringBuilder)localObject4).append("40");
      localObject1 = localSharedPreferences.getString(((StringBuilder)localObject4).toString(), "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1566;
      }
      localObject1 = new JSONObject((String)localObject1);
      break label1550;
      if (localObject1 != null)
      {
        l1 = ((JSONObject)localObject1).optInt("start_time");
        m = ((JSONObject)localObject1).optInt((String)localObject5);
        l2 = m;
        try
        {
          if ((System.currentTimeMillis() <= l1 * 1000L) || (System.currentTimeMillis() >= l2 * 1000L)) {
            break label1144;
          }
          localQQSettingMeDailyBean.e = ((JSONObject)localObject1).optString("template_text");
          localObject4 = ((JSONObject)localObject1).optString("bytes_url");
          if (k != 0)
          {
            localQQSettingMeDailyBean.c = ((JSONObject)localObject1).optString("bytes_icon_url");
            localQQSettingMeDailyBean.d = ((JSONObject)localObject1).optString("bytes_icon_custom_url");
          }
          else
          {
            localQQSettingMeDailyBean.c = "";
            localQQSettingMeDailyBean.d = "";
          }
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label1144;
          }
          localObject1 = localSharedPreferences.edit();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(this.c.getCurrentUin());
          ((StringBuilder)localObject5).append("sign_in_jump_url");
          ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject5).toString(), (String)localObject4).commit();
        }
        catch (JSONException localJSONException1) {}
        label1052:
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("doUpdateDailySignInItemView JSONException, json = ");
          ((StringBuilder)localObject4).append(str);
          QLog.i("DailySignIn", 2, ((StringBuilder)localObject4).toString());
        }
        localJSONException2.printStackTrace();
        break label1144;
        if (localQQSettingMeDailyBean.a == 1) {
          localQQSettingMeDailyBean.e = HardCodeUtil.a(2131908395);
        } else if (localQQSettingMeDailyBean.a == 4) {
          localQQSettingMeDailyBean.e = HardCodeUtil.a(2131908386);
        }
      }
      label1144:
      localQQSettingMeDailyProcessor = this;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("doUpdateDailySignInItemView type=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.a);
        ((StringBuilder)localObject4).append(" iconUrl=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.c);
        ((StringBuilder)localObject4).append(" wording=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.e);
        ((StringBuilder)localObject4).append(" day=");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.f);
        ((StringBuilder)localObject4).append("coverIconUrl");
        ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.d);
        QLog.i("DailySignIn", 2, ((StringBuilder)localObject4).toString());
      }
      localQQSettingMeDailyBean.b = true;
      if (localQQSettingMeDailyBean.a == 4)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("use signed wording:");
          ((StringBuilder)localObject4).append(localQQSettingMeDailyBean.e);
          QLog.i("DailySignIn", 2, ((StringBuilder)localObject4).toString());
        }
        if (localQQSettingMeDailyBean.f > 0) {
          localQQSettingMeDailyBean.e = String.format(localQQSettingMeDailyBean.e, new Object[] { Integer.valueOf(localQQSettingMeDailyBean.f) });
        }
        if ((localQQSettingMeDailyProcessor.g) && (!localQQSettingMeDailyProcessor.j))
        {
          localQQSettingMeDailyProcessor.j = true;
          ReportController.b(localQQSettingMeDailyProcessor.c, "dc00898", "", "", "0X800ACFC", "0X800ACFC", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use unsigned wording");
        }
        if ((localQQSettingMeDailyProcessor.g) && (!localQQSettingMeDailyProcessor.j))
        {
          localQQSettingMeDailyProcessor.j = true;
          ReportController.b(localQQSettingMeDailyProcessor.c, "dc00898", "", "", "0X800ACFB", "0X800ACFB", 0, 0, "", "", "", "");
        }
      }
      localQQSettingMeDailyProcessor.a.setValue(localQQSettingMeDailyBean);
      return;
    }
    for (;;)
    {
      label1510:
      k = 0;
      localObject5 = localObject2;
      Object localObject2 = localObject4;
      break;
      label1536:
      localObject2 = localObject4;
      label1540:
      localObject5 = "end_time";
      k = 1;
      break;
      label1550:
      localObject5 = "end_time";
      localObject4 = localObject2;
      localObject2 = localObject5;
      continue;
      label1566:
      localObject2 = "end_time";
      localObject4 = null;
    }
  }
  
  public void j()
  {
    ((QQAppInterface)this.c).getSignInInfo(0);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (a().b)
    {
      paramView = this.c.getPreferences();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c.getCurrentUin());
      ((StringBuilder)localObject).append("sign_in_jump_url");
      paramView = paramView.getString(((StringBuilder)localObject).toString(), "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
      localObject = new Intent(this.d, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("uin", this.c.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_ad_daka");
      ((Intent)localObject).putExtra("url", paramView);
      this.d.startActivity((Intent)localObject);
      if (a().a == 1) {
        ReportController.b(this.c, "dc00898", "", "", "0X800ACFD", "0X800ACFD", 0, 0, "", "", "", "");
      } else if (a().a == 4) {
        ReportController.b(this.c, "dc00898", "", "", "0X800ACFE", "0X800ACFE", 0, 0, "", "", "", "");
      }
      b(true);
    }
    else
    {
      paramView = this.c.getApp();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task_entry_config");
      ((StringBuilder)localObject).append(this.c.getCurrentAccountUin());
      paramView = paramView.getSharedPreferences(((StringBuilder)localObject).toString(), 0).getString("jump_url", "");
      localObject = new Intent(this.d, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("uin", this.c.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_ad_daka");
      ((Intent)localObject).putExtra("url", paramView);
      this.d.startActivity((Intent)localObject);
      ReportController.b(this.c, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("myDaily onClick mDailySignMode = ");
      paramView.append(a().b);
      QLog.i("DailySignIn", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDailyProcessor
 * JD-Core Version:    0.7.0.1
 */