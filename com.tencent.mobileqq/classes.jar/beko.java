import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.HttpRequestPackage;
import com.tencent.mobileqq.webview.webso.HybridWebReporter;
import com.tencent.mobileqq.webview.webso.WebSoServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class beko
  implements BusinessObserver
{
  private static volatile beko jdField_a_of_type_Beko;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bekq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static beko a()
  {
    if (jdField_a_of_type_Beko == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Beko == null) {
        jdField_a_of_type_Beko = new beko();
      }
      return jdField_a_of_type_Beko;
    }
  }
  
  private bekq a(String paramString)
  {
    bekq localbekq = new bekq();
    localbekq.jdField_a_of_type_JavaLangString = paramString;
    localbekq.jdField_a_of_type_Int = 4;
    localbekq.jdField_c_of_type_Int = 10006;
    return localbekq;
  }
  
  private void a(Handler paramHandler, bekq parambekq)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambekq;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bekq parambekq)
  {
    Handler localHandler;
    if ((parambekq != null) && (parambekq.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambekq.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambekq);
    HybridWebReporter.a().a(parambekq.jdField_a_of_type_Bekm);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bekq localbekq = (bekq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbekq == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbekq.jdField_a_of_type_Int = 2;
    localbekq.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbekq);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bekq parambekq)
  {
    if (parambekq.jdField_a_of_type_Bekm == null)
    {
      parambekq.jdField_a_of_type_Bekm = new bekm();
      parambekq.jdField_a_of_type_Bekm.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      parambekq.jdField_a_of_type_Bekm.jdField_a_of_type_JavaLangString = parambekq.jdField_b_of_type_JavaLangString;
      parambekq.jdField_a_of_type_Bekm.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambekq.jdField_a_of_type_Bekm.jdField_f_of_type_Int = 1;
    }
    parambekq.jdField_a_of_type_Bekm.e = paramBundle.getString("key_user_ip");
    parambekq.jdField_a_of_type_Bekm.h = paramBundle.getString("key_dns_result");
    parambekq.jdField_a_of_type_Bekm.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambekq.jdField_a_of_type_Bekm.g = paramBundle.getString("key_server_port");
    parambekq.jdField_a_of_type_Bekm.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambekq.jdField_a_of_type_Bekm.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambekq.jdField_a_of_type_Bekm.jdField_c_of_type_Int = 0;
    parambekq.jdField_a_of_type_Bekm.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambekq.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambekq.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambekq);
      QLog.w("WebSoCgiService", 1, "state=" + parambekq);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bekl((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambekq.jdField_c_of_type_Int = 10002;
        parambekq.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambekq);
        QLog.w("WebSoCgiService", 1, "state=" + parambekq);
        return;
      }
      localObject1 = ((HttpRsp)localObject1).rspinfo;
      i = ((String)localObject1).indexOf("\r\n\r\n");
      paramBundle = paramBundle.d;
    } while (i < 1);
    String[] arrayOfString1 = ((String)localObject1).substring(0, i - 1).split("\r\n");
    int j = arrayOfString1.length;
    if (j >= 1)
    {
      Object localObject2 = arrayOfString1[0].split(" ");
      if (localObject2.length >= 2) {}
      try
      {
        parambekq.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambekq.jdField_a_of_type_Bekm.d = localObject2[1].trim();
        localObject2 = new JSONObject();
        i = 1;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split(":");
          if (arrayOfString2.length <= 1) {}
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            String[] arrayOfString2;
            ((JSONObject)localObject2).put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
            i += 1;
          }
          localException = localException;
          localException.printStackTrace();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        parambekq.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambekq.jdField_c_of_type_Int = 0;
    parambekq.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambekq.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambekq);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(bekp parambekp, Handler paramHandler)
  {
    return a(parambekp, paramHandler, SwiftBrowserCookieMonster.c(parambekp.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(bekp parambekp, Handler paramHandler, String paramString)
  {
    if ((parambekp == null) || (TextUtils.isEmpty(parambekp.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambekp);
      return false;
    }
    if (!bdin.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambekp);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambekp + ",uniKey=" + str1);
    }
    bekq localbekq = new bekq();
    localbekq.jdField_a_of_type_JavaLangString = str1;
    localbekq.jdField_b_of_type_JavaLangString = parambekp.jdField_a_of_type_JavaLangString;
    localbekq.jdField_a_of_type_Boolean = parambekp.jdField_a_of_type_Boolean;
    localbekq.jdField_a_of_type_Int = 1;
    localbekq.e = parambekp.jdField_f_of_type_JavaLangString;
    localbekq.jdField_a_of_type_JavaLangObject = parambekp.jdField_a_of_type_JavaLangObject;
    localbekq.jdField_a_of_type_Bekm = new bekm();
    localbekq.jdField_a_of_type_Bekm.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localbekq.jdField_a_of_type_Bekm.jdField_a_of_type_JavaLangString = parambekp.jdField_a_of_type_JavaLangString;
    localbekq.jdField_a_of_type_Bekm.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbekq);
    long l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str3 = bjdm.a();
    String str2 = belc.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambekp.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambekp.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambekp.e);
      localJSONObject.put("uri", parambekp.jdField_a_of_type_JavaLangString);
      if (parambekp.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambekp.d))
        {
          if (!parambekp.jdField_a_of_type_JavaLangString.contains("?")) {
            break label705;
          }
          localJSONObject.put("uri", parambekp.jdField_a_of_type_JavaLangString + "&" + parambekp.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambekp.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbekq.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambekp.jdField_a_of_type_JavaLangString, paramString, "", parambekp.jdField_a_of_type_Int, 1101, str1, beko.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbekq.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label705:
          localJSONObject.put("uri", parambekp.jdField_a_of_type_JavaLangString + "?" + parambekp.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambekp.d)) {
          localJSONObject.put("content_length", parambekp.d.length());
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1101) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beko
 * JD-Core Version:    0.7.0.1
 */