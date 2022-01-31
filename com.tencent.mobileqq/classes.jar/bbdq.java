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

public class bbdq
  implements BusinessObserver
{
  private static volatile bbdq jdField_a_of_type_Bbdq;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, bbds> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bbdq a()
  {
    if (jdField_a_of_type_Bbdq == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bbdq == null) {
        jdField_a_of_type_Bbdq = new bbdq();
      }
      return jdField_a_of_type_Bbdq;
    }
  }
  
  private bbds a(String paramString)
  {
    bbds localbbds = new bbds();
    localbbds.jdField_a_of_type_JavaLangString = paramString;
    localbbds.jdField_a_of_type_Int = 4;
    localbbds.jdField_c_of_type_Int = 10006;
    return localbbds;
  }
  
  private void a(Handler paramHandler, bbds parambbds)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambbds;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(bbds parambbds)
  {
    Handler localHandler;
    if ((parambbds != null) && (parambbds.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambbds.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambbds);
    HybridWebReporter.a().a(parambbds.jdField_a_of_type_Bbdo);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    bbds localbbds = (bbds)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbbds == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbbds.jdField_a_of_type_Int = 2;
    localbbds.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbbds);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, bbds parambbds)
  {
    if (parambbds.jdField_a_of_type_Bbdo == null)
    {
      parambbds.jdField_a_of_type_Bbdo = new bbdo();
      parambbds.jdField_a_of_type_Bbdo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      parambbds.jdField_a_of_type_Bbdo.jdField_a_of_type_JavaLangString = parambbds.jdField_b_of_type_JavaLangString;
      parambbds.jdField_a_of_type_Bbdo.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambbds.jdField_a_of_type_Bbdo.jdField_f_of_type_Int = 1;
    }
    parambbds.jdField_a_of_type_Bbdo.e = paramBundle.getString("key_user_ip");
    parambbds.jdField_a_of_type_Bbdo.h = paramBundle.getString("key_dns_result");
    parambbds.jdField_a_of_type_Bbdo.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambbds.jdField_a_of_type_Bbdo.g = paramBundle.getString("key_server_port");
    parambbds.jdField_a_of_type_Bbdo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambbds.jdField_a_of_type_Bbdo.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambbds.jdField_a_of_type_Bbdo.jdField_c_of_type_Int = 0;
    parambbds.jdField_a_of_type_Bbdo.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambbds.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambbds.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambbds);
      QLog.w("WebSoCgiService", 1, "state=" + parambbds);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new bbdn((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambbds.jdField_c_of_type_Int = 10002;
        parambbds.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambbds);
        QLog.w("WebSoCgiService", 1, "state=" + parambbds);
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
        parambbds.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambbds.jdField_a_of_type_Bbdo.d = localObject2[1].trim();
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
        parambbds.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambbds.jdField_c_of_type_Int = 0;
    parambbds.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambbds.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambbds);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(bbdr parambbdr, Handler paramHandler)
  {
    return a(parambbdr, paramHandler, SwiftBrowserCookieMonster.c(parambbdr.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(bbdr parambbdr, Handler paramHandler, String paramString)
  {
    if ((parambbdr == null) || (TextUtils.isEmpty(parambbdr.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambbdr);
      return false;
    }
    if (!badq.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambbdr);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambbdr + ",uniKey=" + str1);
    }
    bbds localbbds = new bbds();
    localbbds.jdField_a_of_type_JavaLangString = str1;
    localbbds.jdField_b_of_type_JavaLangString = parambbdr.jdField_a_of_type_JavaLangString;
    localbbds.jdField_a_of_type_Boolean = parambbdr.jdField_a_of_type_Boolean;
    localbbds.jdField_a_of_type_Int = 1;
    localbbds.e = parambbdr.jdField_f_of_type_JavaLangString;
    localbbds.jdField_a_of_type_JavaLangObject = parambbdr.jdField_a_of_type_JavaLangObject;
    localbbds.jdField_a_of_type_Bbdo = new bbdo();
    localbbds.jdField_a_of_type_Bbdo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localbbds.jdField_a_of_type_Bbdo.jdField_a_of_type_JavaLangString = parambbdr.jdField_a_of_type_JavaLangString;
    localbbds.jdField_a_of_type_Bbdo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbbds);
    long l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str3 = bfpk.a();
    String str2 = bbee.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambbdr.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambbdr.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambbdr.e);
      localJSONObject.put("uri", parambbdr.jdField_a_of_type_JavaLangString);
      if (parambbdr.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambbdr.d))
        {
          if (!parambbdr.jdField_a_of_type_JavaLangString.contains("?")) {
            break label705;
          }
          localJSONObject.put("uri", parambbdr.jdField_a_of_type_JavaLangString + "&" + parambbdr.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambbdr.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbbds.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambbdr.jdField_a_of_type_JavaLangString, paramString, "", parambbdr.jdField_a_of_type_Int, 1101, str1, bbdq.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbbds.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label705:
          localJSONObject.put("uri", parambbdr.jdField_a_of_type_JavaLangString + "?" + parambbdr.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambbdr.d)) {
          localJSONObject.put("content_length", parambbdr.d.length());
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
 * Qualified Name:     bbdq
 * JD-Core Version:    0.7.0.1
 */