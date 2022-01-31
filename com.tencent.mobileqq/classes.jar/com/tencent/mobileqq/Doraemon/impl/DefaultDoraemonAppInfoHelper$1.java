package com.tencent.mobileqq.Doraemon.impl;

import abxj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class DefaultDoraemonAppInfoHelper$1
  implements Runnable
{
  public DefaultDoraemonAppInfoHelper$1(abxj paramabxj) {}
  
  public void run()
  {
    Object localObject7;
    long l1;
    long l2;
    try
    {
      ??? = "https://cgi.connect.qq.com/mqqapi/privilege_group_config?platform=1&platform_version=8.3.5&data_version=" + this.this$0.b;
      localObject7 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject7 == null)
      {
        QLog.e("DoraemonOpenAPI.permissionHelper", 1, "app is null");
        return;
      }
      Object localObject4 = (TicketManager)((AppRuntime)localObject7).getManager(2);
      localObject7 = ((AppRuntime)localObject7).getAccount();
      localObject4 = ((TicketManager)localObject4).getSkey((String)localObject7);
      ??? = new JSONObject(new OkHttpClient().newCall(new Request.Builder().addHeader("Cookie", "uin=" + (String)localObject7 + ";skey=" + (String)localObject4).addHeader("Referer", "https://connect.qq.com/").url((String)???).build()).execute().body().string());
      int i = ((JSONObject)???).getInt("retcode");
      QLog.i("DoraemonOpenAPI.permissionHelper", 1, "checkup code=" + i);
      if (i != 0) {
        return;
      }
      ??? = ((JSONObject)???).getJSONObject("result");
      l1 = ((JSONObject)???).getLong("version");
      l2 = ((JSONObject)???).getLong("next_req_duration") * 1000L;
      if (this.this$0.b == l1)
      {
        QLog.i("DoraemonOpenAPI.permissionHelper", 1, "no update, next=" + l2 + ", ver=" + l1);
        synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
        {
          this.this$0.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(300000L, l2));
          return;
        }
      }
      localJSONObject = localThrowable.getJSONObject("list");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DoraemonOpenAPI.permissionHelper", 1, "checkup error", localThrowable);
      return;
    }
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      JSONObject localJSONObject;
      this.this$0.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(300000L, l2));
      this.this$0.b = l1;
      localObject7 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.permissionHelper", 2, "checkup, next=" + l2 + ", ver=" + l1 + ", list=" + (String)localObject7);
      }
      synchronized (this.this$0)
      {
        this.this$0.jdField_a_of_type_OrgJsonJSONObject = localJSONObject;
        this.this$0.jdField_a_of_type_JavaUtilMap.clear();
        BaseApplicationImpl.getApplication().getSharedPreferences("DoraemonApiGroup.json", 4).edit().putString("content", (String)localObject7).putLong("version", l1).putString("app_version", "8.3.5").apply();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */