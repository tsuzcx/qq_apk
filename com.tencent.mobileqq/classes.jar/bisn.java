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

public class bisn
  implements BusinessObserver
{
  private static volatile bisn jdField_a_of_type_Bisn;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bisp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bisn a()
  {
    if (jdField_a_of_type_Bisn == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bisn == null) {
        jdField_a_of_type_Bisn = new bisn();
      }
      return jdField_a_of_type_Bisn;
    }
  }
  
  private bisp a(String paramString)
  {
    bisp localbisp = new bisp();
    localbisp.jdField_a_of_type_JavaLangString = paramString;
    localbisp.jdField_a_of_type_Int = 4;
    localbisp.jdField_c_of_type_Int = 10006;
    return localbisp;
  }
  
  private void a(Handler paramHandler, bisp parambisp)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambisp;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bisp parambisp)
  {
    Handler localHandler;
    if ((parambisp != null) && (parambisp.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambisp.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambisp);
    HybridWebReporter.a().a(parambisp.jdField_a_of_type_Bisl);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bisp localbisp = (bisp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbisp == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbisp.jdField_a_of_type_Int = 2;
    localbisp.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbisp);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bisp parambisp)
  {
    if (parambisp.jdField_a_of_type_Bisl == null)
    {
      parambisp.jdField_a_of_type_Bisl = new bisl();
      parambisp.jdField_a_of_type_Bisl.jdField_a_of_type_Long = bitb.a();
      parambisp.jdField_a_of_type_Bisl.jdField_a_of_type_JavaLangString = parambisp.jdField_b_of_type_JavaLangString;
      parambisp.jdField_a_of_type_Bisl.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambisp.jdField_a_of_type_Bisl.jdField_f_of_type_Int = 1;
    }
    parambisp.jdField_a_of_type_Bisl.e = paramBundle.getString("key_user_ip");
    parambisp.jdField_a_of_type_Bisl.h = paramBundle.getString("key_dns_result");
    parambisp.jdField_a_of_type_Bisl.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambisp.jdField_a_of_type_Bisl.g = paramBundle.getString("key_server_port");
    parambisp.jdField_a_of_type_Bisl.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambisp.jdField_a_of_type_Bisl.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambisp.jdField_a_of_type_Bisl.jdField_c_of_type_Int = 0;
    parambisp.jdField_a_of_type_Bisl.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambisp.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambisp.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambisp);
      QLog.w("WebSoCgiService", 1, "state=" + parambisp);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bisk((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambisp.jdField_c_of_type_Int = 10002;
        parambisp.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambisp);
        QLog.w("WebSoCgiService", 1, "state=" + parambisp);
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
        parambisp.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambisp.jdField_a_of_type_Bisl.d = localObject2[1].trim();
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
        parambisp.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambisp.jdField_c_of_type_Int = 0;
    parambisp.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambisp.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambisp);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(biso parambiso, Handler paramHandler)
  {
    return a(parambiso, paramHandler, SwiftBrowserCookieMonster.c(parambiso.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(biso parambiso, Handler paramHandler, String paramString)
  {
    if ((parambiso == null) || (TextUtils.isEmpty(parambiso.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambiso);
      return false;
    }
    if (!bhnv.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambiso);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambiso + ",uniKey=" + str1);
    }
    bisp localbisp = new bisp();
    localbisp.jdField_a_of_type_JavaLangString = str1;
    localbisp.jdField_b_of_type_JavaLangString = parambiso.jdField_a_of_type_JavaLangString;
    localbisp.jdField_a_of_type_Boolean = parambiso.jdField_a_of_type_Boolean;
    localbisp.jdField_a_of_type_Int = 1;
    localbisp.e = parambiso.jdField_f_of_type_JavaLangString;
    localbisp.jdField_a_of_type_JavaLangObject = parambiso.jdField_a_of_type_JavaLangObject;
    localbisp.jdField_a_of_type_Bisl = new bisl();
    localbisp.jdField_a_of_type_Bisl.jdField_a_of_type_Long = bitb.a();
    localbisp.jdField_a_of_type_Bisl.jdField_a_of_type_JavaLangString = parambiso.jdField_a_of_type_JavaLangString;
    localbisp.jdField_a_of_type_Bisl.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbisp);
    long l1 = bitb.a();
    String str3 = bmsw.a();
    String str2 = bitb.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambiso.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambiso.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambiso.e);
      localJSONObject.put("uri", parambiso.jdField_a_of_type_JavaLangString);
      if (parambiso.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambiso.d))
        {
          if (!parambiso.jdField_a_of_type_JavaLangString.contains("?")) {
            break label693;
          }
          localJSONObject.put("uri", parambiso.jdField_a_of_type_JavaLangString + "&" + parambiso.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambiso.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbisp.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambiso.jdField_a_of_type_JavaLangString, paramString, "", parambiso.jdField_a_of_type_Int, 1101, str1, bisn.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbisp.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label693:
          localJSONObject.put("uri", parambiso.jdField_a_of_type_JavaLangString + "?" + parambiso.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambiso.d)) {
          localJSONObject.put("content_length", parambiso.d.length());
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
 * Qualified Name:     bisn
 * JD-Core Version:    0.7.0.1
 */