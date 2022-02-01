package com.tencent.mobileqq.Doraemon.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

class DefaultDoraemonAppInfoHelper$1
  implements Runnable
{
  DefaultDoraemonAppInfoHelper$1(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://cgi.connect.qq.com/mqqapi/privilege_group_config?platform=1&platform_version=8.7.0&data_version=");
      ((StringBuilder)localObject1).append(this.this$0.b);
      localObject1 = ((StringBuilder)localObject1).toString();
      ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (??? == null)
      {
        QLog.e("DoraemonOpenAPI.permissionHelper", 1, "app is null");
        return;
      }
      ??? = (TicketManager)((AppRuntime)???).getManager(2);
      ??? = ((AppRuntime)???).getAccount();
      ??? = ((TicketManager)???).getSkey((String)???);
      OkHttpClient localOkHttpClient = new OkHttpClient();
      Request.Builder localBuilder = new Request.Builder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append((String)???);
      localStringBuilder.append(";skey=");
      localStringBuilder.append((String)???);
      localObject1 = localOkHttpClient.newCall(localBuilder.addHeader("Cookie", localStringBuilder.toString()).addHeader("Referer", "https://connect.qq.com/").url((String)localObject1).build()).execute();
      ??? = new JSONObject(((Response)localObject1).body().string());
      int i = ((JSONObject)???).getInt("retcode");
      ??? = new StringBuilder();
      ((StringBuilder)???).append("checkup code=");
      ((StringBuilder)???).append(i);
      QLog.i("DoraemonOpenAPI.permissionHelper", 1, ((StringBuilder)???).toString());
      if (i == 0)
      {
        ??? = ((JSONObject)???).getJSONObject("result");
        long l1 = ((JSONObject)???).getLong("version");
        long l2 = ((JSONObject)???).getLong("next_req_duration") * 1000L;
        if (this.this$0.b == l1)
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("no update, next=");
          ((StringBuilder)???).append(l2);
          ((StringBuilder)???).append(", ver=");
          ((StringBuilder)???).append(l1);
          QLog.i("DoraemonOpenAPI.permissionHelper", 1, ((StringBuilder)???).toString());
          synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
          {
            this.this$0.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(300000L, l2));
            DefaultDoraemonAppInfoHelper.a(this.this$0, (Closeable)localObject1);
            return;
          }
        }
        JSONObject localJSONObject = ((JSONObject)???).getJSONObject("list");
        synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
        {
          this.this$0.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(300000L, l2));
          this.this$0.b = l1;
          ??? = localJSONObject.toString();
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("checkup, next=");
            ((StringBuilder)???).append(l2);
            ((StringBuilder)???).append(", ver=");
            ((StringBuilder)???).append(l1);
            ((StringBuilder)???).append(", list=");
            ((StringBuilder)???).append((String)???);
            QLog.d("DoraemonOpenAPI.permissionHelper", 2, ((StringBuilder)???).toString());
          }
          synchronized (this.this$0)
          {
            this.this$0.jdField_a_of_type_OrgJsonJSONObject = localJSONObject;
            this.this$0.jdField_a_of_type_JavaUtilMap.clear();
            BaseApplication.getContext().getSharedPreferences("DoraemonApiGroup.json", 4).edit().putString("content", (String)???).putLong("version", l1).putString("app_version", "8.7.0").apply();
            return;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DoraemonOpenAPI.permissionHelper", 1, "checkup error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */