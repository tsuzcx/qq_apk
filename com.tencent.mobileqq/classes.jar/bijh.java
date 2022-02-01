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

public class bijh
  implements BusinessObserver
{
  private static volatile bijh jdField_a_of_type_Bijh;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bijj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bijh a()
  {
    if (jdField_a_of_type_Bijh == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bijh == null) {
        jdField_a_of_type_Bijh = new bijh();
      }
      return jdField_a_of_type_Bijh;
    }
  }
  
  private bijj a(String paramString)
  {
    bijj localbijj = new bijj();
    localbijj.jdField_a_of_type_JavaLangString = paramString;
    localbijj.jdField_a_of_type_Int = 4;
    localbijj.jdField_c_of_type_Int = 10006;
    return localbijj;
  }
  
  private void a(Handler paramHandler, bijj parambijj)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambijj;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bijj parambijj)
  {
    Handler localHandler;
    if ((parambijj != null) && (parambijj.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambijj.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambijj);
    HybridWebReporter.a().a(parambijj.jdField_a_of_type_Bijf);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bijj localbijj = (bijj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbijj == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbijj.jdField_a_of_type_Int = 2;
    localbijj.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbijj);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bijj parambijj)
  {
    if (parambijj.jdField_a_of_type_Bijf == null)
    {
      parambijj.jdField_a_of_type_Bijf = new bijf();
      parambijj.jdField_a_of_type_Bijf.jdField_a_of_type_Long = bijv.a();
      parambijj.jdField_a_of_type_Bijf.jdField_a_of_type_JavaLangString = parambijj.jdField_b_of_type_JavaLangString;
      parambijj.jdField_a_of_type_Bijf.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambijj.jdField_a_of_type_Bijf.jdField_f_of_type_Int = 1;
    }
    parambijj.jdField_a_of_type_Bijf.e = paramBundle.getString("key_user_ip");
    parambijj.jdField_a_of_type_Bijf.h = paramBundle.getString("key_dns_result");
    parambijj.jdField_a_of_type_Bijf.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambijj.jdField_a_of_type_Bijf.g = paramBundle.getString("key_server_port");
    parambijj.jdField_a_of_type_Bijf.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambijj.jdField_a_of_type_Bijf.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambijj.jdField_a_of_type_Bijf.jdField_c_of_type_Int = 0;
    parambijj.jdField_a_of_type_Bijf.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambijj.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambijj.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambijj);
      QLog.w("WebSoCgiService", 1, "state=" + parambijj);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bije((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambijj.jdField_c_of_type_Int = 10002;
        parambijj.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambijj);
        QLog.w("WebSoCgiService", 1, "state=" + parambijj);
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
        parambijj.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambijj.jdField_a_of_type_Bijf.d = localObject2[1].trim();
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
        parambijj.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambijj.jdField_c_of_type_Int = 0;
    parambijj.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambijj.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambijj);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(biji parambiji, Handler paramHandler)
  {
    return a(parambiji, paramHandler, SwiftBrowserCookieMonster.c(parambiji.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(biji parambiji, Handler paramHandler, String paramString)
  {
    if ((parambiji == null) || (TextUtils.isEmpty(parambiji.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambiji);
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambiji);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambiji + ",uniKey=" + str1);
    }
    bijj localbijj = new bijj();
    localbijj.jdField_a_of_type_JavaLangString = str1;
    localbijj.jdField_b_of_type_JavaLangString = parambiji.jdField_a_of_type_JavaLangString;
    localbijj.jdField_a_of_type_Boolean = parambiji.jdField_a_of_type_Boolean;
    localbijj.jdField_a_of_type_Int = 1;
    localbijj.e = parambiji.jdField_f_of_type_JavaLangString;
    localbijj.jdField_a_of_type_JavaLangObject = parambiji.jdField_a_of_type_JavaLangObject;
    localbijj.jdField_a_of_type_Bijf = new bijf();
    localbijj.jdField_a_of_type_Bijf.jdField_a_of_type_Long = bijv.a();
    localbijj.jdField_a_of_type_Bijf.jdField_a_of_type_JavaLangString = parambiji.jdField_a_of_type_JavaLangString;
    localbijj.jdField_a_of_type_Bijf.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbijj);
    long l1 = bijv.a();
    String str3 = QUA.getQUA3();
    String str2 = bijv.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambiji.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambiji.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambiji.e);
      localJSONObject.put("uri", parambiji.jdField_a_of_type_JavaLangString);
      if (parambiji.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambiji.d))
        {
          if (!parambiji.jdField_a_of_type_JavaLangString.contains("?")) {
            break label693;
          }
          localJSONObject.put("uri", parambiji.jdField_a_of_type_JavaLangString + "&" + parambiji.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambiji.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbijj.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambiji.jdField_a_of_type_JavaLangString, paramString, "", parambiji.jdField_a_of_type_Int, 1101, str1, bijh.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbijj.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label693:
          localJSONObject.put("uri", parambiji.jdField_a_of_type_JavaLangString + "?" + parambiji.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambiji.d)) {
          localJSONObject.put("content_length", parambiji.d.length());
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
 * Qualified Name:     bijh
 * JD-Core Version:    0.7.0.1
 */