import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.HttpRequestPackage;
import com.tencent.mobileqq.webview.webso.HybridWebReporter;
import com.tencent.mobileqq.webview.webso.WebSoServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class bgyp
  implements BusinessObserver
{
  private static volatile bgyp jdField_a_of_type_Bgyp;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bgyr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bgyp a()
  {
    if (jdField_a_of_type_Bgyp == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bgyp == null) {
        jdField_a_of_type_Bgyp = new bgyp();
      }
      return jdField_a_of_type_Bgyp;
    }
  }
  
  private bgyr a(String paramString)
  {
    bgyr localbgyr = new bgyr();
    localbgyr.jdField_a_of_type_JavaLangString = paramString;
    localbgyr.jdField_a_of_type_Int = 4;
    localbgyr.jdField_c_of_type_Int = 10006;
    return localbgyr;
  }
  
  private void a(Handler paramHandler, bgyr parambgyr)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambgyr;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bgyr parambgyr)
  {
    Handler localHandler;
    if ((parambgyr != null) && (parambgyr.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambgyr.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambgyr);
    HybridWebReporter.a().a(parambgyr.jdField_a_of_type_Bgyn);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bgyr localbgyr = (bgyr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbgyr == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbgyr.jdField_a_of_type_Int = 2;
    localbgyr.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbgyr);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bgyr parambgyr)
  {
    if (parambgyr.jdField_a_of_type_Bgyn == null)
    {
      parambgyr.jdField_a_of_type_Bgyn = new bgyn();
      parambgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_Long = bgzd.a();
      parambgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_JavaLangString = parambgyr.jdField_b_of_type_JavaLangString;
      parambgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambgyr.jdField_a_of_type_Bgyn.jdField_f_of_type_Int = 1;
    }
    parambgyr.jdField_a_of_type_Bgyn.e = paramBundle.getString("key_user_ip");
    parambgyr.jdField_a_of_type_Bgyn.h = paramBundle.getString("key_dns_result");
    parambgyr.jdField_a_of_type_Bgyn.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambgyr.jdField_a_of_type_Bgyn.g = paramBundle.getString("key_server_port");
    parambgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambgyr.jdField_a_of_type_Bgyn.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambgyr.jdField_a_of_type_Bgyn.jdField_c_of_type_Int = 0;
    parambgyr.jdField_a_of_type_Bgyn.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambgyr.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambgyr.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambgyr);
      QLog.w("WebSoCgiService", 1, "state=" + parambgyr);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bgym((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambgyr.jdField_c_of_type_Int = 10002;
        parambgyr.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambgyr);
        QLog.w("WebSoCgiService", 1, "state=" + parambgyr);
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
        parambgyr.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambgyr.jdField_a_of_type_Bgyn.d = localObject2[1].trim();
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
        parambgyr.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambgyr.jdField_c_of_type_Int = 0;
    parambgyr.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambgyr.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambgyr);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(bgyq parambgyq, Handler paramHandler)
  {
    return a(parambgyq, paramHandler, SwiftBrowserCookieMonster.c(parambgyq.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(bgyq parambgyq, Handler paramHandler, String paramString)
  {
    if ((parambgyq == null) || (TextUtils.isEmpty(parambgyq.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambgyq);
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambgyq);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambgyq + ",uniKey=" + str1);
    }
    bgyr localbgyr = new bgyr();
    localbgyr.jdField_a_of_type_JavaLangString = str1;
    localbgyr.jdField_b_of_type_JavaLangString = parambgyq.jdField_a_of_type_JavaLangString;
    localbgyr.jdField_a_of_type_Boolean = parambgyq.jdField_a_of_type_Boolean;
    localbgyr.jdField_a_of_type_Int = 1;
    localbgyr.e = parambgyq.jdField_f_of_type_JavaLangString;
    localbgyr.jdField_a_of_type_JavaLangObject = parambgyq.jdField_a_of_type_JavaLangObject;
    localbgyr.jdField_a_of_type_Bgyn = new bgyn();
    localbgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_Long = bgzd.a();
    localbgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_JavaLangString = parambgyq.jdField_a_of_type_JavaLangString;
    localbgyr.jdField_a_of_type_Bgyn.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbgyr);
    long l1 = bgzd.a();
    String str3 = QUA.getQUA3();
    String str2 = bgzd.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambgyq.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambgyq.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambgyq.e);
      localJSONObject.put("uri", parambgyq.jdField_a_of_type_JavaLangString);
      if (parambgyq.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambgyq.d))
        {
          if (!parambgyq.jdField_a_of_type_JavaLangString.contains("?")) {
            break label693;
          }
          localJSONObject.put("uri", parambgyq.jdField_a_of_type_JavaLangString + "&" + parambgyq.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambgyq.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbgyr.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambgyq.jdField_a_of_type_JavaLangString, paramString, "", parambgyq.jdField_a_of_type_Int, 1101, str1, bgyp.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbgyr.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label693:
          localJSONObject.put("uri", parambgyq.jdField_a_of_type_JavaLangString + "?" + parambgyq.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambgyq.d)) {
          localJSONObject.put("content_length", parambgyq.d.length());
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
 * Qualified Name:     bgyp
 * JD-Core Version:    0.7.0.1
 */