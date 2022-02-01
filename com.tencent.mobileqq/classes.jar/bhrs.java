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

public class bhrs
  implements BusinessObserver
{
  private static volatile bhrs jdField_a_of_type_Bhrs;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bhru> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bhrs a()
  {
    if (jdField_a_of_type_Bhrs == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bhrs == null) {
        jdField_a_of_type_Bhrs = new bhrs();
      }
      return jdField_a_of_type_Bhrs;
    }
  }
  
  private bhru a(String paramString)
  {
    bhru localbhru = new bhru();
    localbhru.jdField_a_of_type_JavaLangString = paramString;
    localbhru.jdField_a_of_type_Int = 4;
    localbhru.jdField_c_of_type_Int = 10006;
    return localbhru;
  }
  
  private void a(Handler paramHandler, bhru parambhru)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambhru;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bhru parambhru)
  {
    Handler localHandler;
    if ((parambhru != null) && (parambhru.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambhru.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambhru);
    HybridWebReporter.a().a(parambhru.jdField_a_of_type_Bhrq);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bhru localbhru = (bhru)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbhru == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbhru.jdField_a_of_type_Int = 2;
    localbhru.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbhru);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bhru parambhru)
  {
    if (parambhru.jdField_a_of_type_Bhrq == null)
    {
      parambhru.jdField_a_of_type_Bhrq = new bhrq();
      parambhru.jdField_a_of_type_Bhrq.jdField_a_of_type_Long = bhsg.a();
      parambhru.jdField_a_of_type_Bhrq.jdField_a_of_type_JavaLangString = parambhru.jdField_b_of_type_JavaLangString;
      parambhru.jdField_a_of_type_Bhrq.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambhru.jdField_a_of_type_Bhrq.jdField_f_of_type_Int = 1;
    }
    parambhru.jdField_a_of_type_Bhrq.e = paramBundle.getString("key_user_ip");
    parambhru.jdField_a_of_type_Bhrq.h = paramBundle.getString("key_dns_result");
    parambhru.jdField_a_of_type_Bhrq.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambhru.jdField_a_of_type_Bhrq.g = paramBundle.getString("key_server_port");
    parambhru.jdField_a_of_type_Bhrq.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambhru.jdField_a_of_type_Bhrq.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambhru.jdField_a_of_type_Bhrq.jdField_c_of_type_Int = 0;
    parambhru.jdField_a_of_type_Bhrq.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambhru.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambhru.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambhru);
      QLog.w("WebSoCgiService", 1, "state=" + parambhru);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bhrp((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambhru.jdField_c_of_type_Int = 10002;
        parambhru.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambhru);
        QLog.w("WebSoCgiService", 1, "state=" + parambhru);
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
        parambhru.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambhru.jdField_a_of_type_Bhrq.d = localObject2[1].trim();
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
        parambhru.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambhru.jdField_c_of_type_Int = 0;
    parambhru.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambhru.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambhru);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(bhrt parambhrt, Handler paramHandler)
  {
    return a(parambhrt, paramHandler, SwiftBrowserCookieMonster.c(parambhrt.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(bhrt parambhrt, Handler paramHandler, String paramString)
  {
    if ((parambhrt == null) || (TextUtils.isEmpty(parambhrt.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambhrt);
      return false;
    }
    if (!bgnt.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambhrt);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambhrt + ",uniKey=" + str1);
    }
    bhru localbhru = new bhru();
    localbhru.jdField_a_of_type_JavaLangString = str1;
    localbhru.jdField_b_of_type_JavaLangString = parambhrt.jdField_a_of_type_JavaLangString;
    localbhru.jdField_a_of_type_Boolean = parambhrt.jdField_a_of_type_Boolean;
    localbhru.jdField_a_of_type_Int = 1;
    localbhru.e = parambhrt.jdField_f_of_type_JavaLangString;
    localbhru.jdField_a_of_type_JavaLangObject = parambhrt.jdField_a_of_type_JavaLangObject;
    localbhru.jdField_a_of_type_Bhrq = new bhrq();
    localbhru.jdField_a_of_type_Bhrq.jdField_a_of_type_Long = bhsg.a();
    localbhru.jdField_a_of_type_Bhrq.jdField_a_of_type_JavaLangString = parambhrt.jdField_a_of_type_JavaLangString;
    localbhru.jdField_a_of_type_Bhrq.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbhru);
    long l1 = bhsg.a();
    String str3 = blru.a();
    String str2 = bhsg.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambhrt.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambhrt.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambhrt.e);
      localJSONObject.put("uri", parambhrt.jdField_a_of_type_JavaLangString);
      if (parambhrt.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambhrt.d))
        {
          if (!parambhrt.jdField_a_of_type_JavaLangString.contains("?")) {
            break label693;
          }
          localJSONObject.put("uri", parambhrt.jdField_a_of_type_JavaLangString + "&" + parambhrt.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambhrt.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbhru.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambhrt.jdField_a_of_type_JavaLangString, paramString, "", parambhrt.jdField_a_of_type_Int, 1101, str1, bhrs.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbhru.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label693:
          localJSONObject.put("uri", parambhrt.jdField_a_of_type_JavaLangString + "?" + parambhrt.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambhrt.d)) {
          localJSONObject.put("content_length", parambhrt.d.length());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrs
 * JD-Core Version:    0.7.0.1
 */