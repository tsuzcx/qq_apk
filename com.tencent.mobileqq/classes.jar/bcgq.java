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

public class bcgq
  implements BusinessObserver
{
  private static volatile bcgq jdField_a_of_type_Bcgq;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bcgs> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bcgq a()
  {
    if (jdField_a_of_type_Bcgq == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bcgq == null) {
        jdField_a_of_type_Bcgq = new bcgq();
      }
      return jdField_a_of_type_Bcgq;
    }
  }
  
  private bcgs a(String paramString)
  {
    bcgs localbcgs = new bcgs();
    localbcgs.jdField_a_of_type_JavaLangString = paramString;
    localbcgs.jdField_a_of_type_Int = 4;
    localbcgs.jdField_c_of_type_Int = 10006;
    return localbcgs;
  }
  
  private void a(Handler paramHandler, bcgs parambcgs)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambcgs;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bcgs parambcgs)
  {
    Handler localHandler;
    if ((parambcgs != null) && (parambcgs.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambcgs.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambcgs);
    HybridWebReporter.a().a(parambcgs.jdField_a_of_type_Bcgo);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bcgs localbcgs = (bcgs)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbcgs == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbcgs.jdField_a_of_type_Int = 2;
    localbcgs.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbcgs);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bcgs parambcgs)
  {
    if (parambcgs.jdField_a_of_type_Bcgo == null)
    {
      parambcgs.jdField_a_of_type_Bcgo = new bcgo();
      parambcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      parambcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_JavaLangString = parambcgs.jdField_b_of_type_JavaLangString;
      parambcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambcgs.jdField_a_of_type_Bcgo.jdField_f_of_type_Int = 1;
    }
    parambcgs.jdField_a_of_type_Bcgo.e = paramBundle.getString("key_user_ip");
    parambcgs.jdField_a_of_type_Bcgo.h = paramBundle.getString("key_dns_result");
    parambcgs.jdField_a_of_type_Bcgo.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambcgs.jdField_a_of_type_Bcgo.g = paramBundle.getString("key_server_port");
    parambcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambcgs.jdField_a_of_type_Bcgo.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambcgs.jdField_a_of_type_Bcgo.jdField_c_of_type_Int = 0;
    parambcgs.jdField_a_of_type_Bcgo.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambcgs.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambcgs.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambcgs);
      QLog.w("WebSoCgiService", 1, "state=" + parambcgs);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bcgn((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambcgs.jdField_c_of_type_Int = 10002;
        parambcgs.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambcgs);
        QLog.w("WebSoCgiService", 1, "state=" + parambcgs);
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
        parambcgs.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambcgs.jdField_a_of_type_Bcgo.d = localObject2[1].trim();
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
        parambcgs.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambcgs.jdField_c_of_type_Int = 0;
    parambcgs.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambcgs.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambcgs);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(bcgr parambcgr, Handler paramHandler)
  {
    return a(parambcgr, paramHandler, SwiftBrowserCookieMonster.c(parambcgr.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(bcgr parambcgr, Handler paramHandler, String paramString)
  {
    if ((parambcgr == null) || (TextUtils.isEmpty(parambcgr.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambcgr);
      return false;
    }
    if (!bbev.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambcgr);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambcgr + ",uniKey=" + str1);
    }
    bcgs localbcgs = new bcgs();
    localbcgs.jdField_a_of_type_JavaLangString = str1;
    localbcgs.jdField_b_of_type_JavaLangString = parambcgr.jdField_a_of_type_JavaLangString;
    localbcgs.jdField_a_of_type_Boolean = parambcgr.jdField_a_of_type_Boolean;
    localbcgs.jdField_a_of_type_Int = 1;
    localbcgs.e = parambcgr.jdField_f_of_type_JavaLangString;
    localbcgs.jdField_a_of_type_JavaLangObject = parambcgr.jdField_a_of_type_JavaLangObject;
    localbcgs.jdField_a_of_type_Bcgo = new bcgo();
    localbcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localbcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_JavaLangString = parambcgr.jdField_a_of_type_JavaLangString;
    localbcgs.jdField_a_of_type_Bcgo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbcgs);
    long l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str3 = bgxr.a();
    String str2 = bche.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambcgr.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambcgr.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambcgr.e);
      localJSONObject.put("uri", parambcgr.jdField_a_of_type_JavaLangString);
      if (parambcgr.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambcgr.d))
        {
          if (!parambcgr.jdField_a_of_type_JavaLangString.contains("?")) {
            break label705;
          }
          localJSONObject.put("uri", parambcgr.jdField_a_of_type_JavaLangString + "&" + parambcgr.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambcgr.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbcgs.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambcgr.jdField_a_of_type_JavaLangString, paramString, "", parambcgr.jdField_a_of_type_Int, 1101, str1, bcgq.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbcgs.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label705:
          localJSONObject.put("uri", parambcgr.jdField_a_of_type_JavaLangString + "?" + parambcgr.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambcgr.d)) {
          localJSONObject.put("content_length", parambcgr.d.length());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcgq
 * JD-Core Version:    0.7.0.1
 */