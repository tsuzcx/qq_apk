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

public class begf
  implements BusinessObserver
{
  private static volatile begf jdField_a_of_type_Begf;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, begh> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static begf a()
  {
    if (jdField_a_of_type_Begf == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Begf == null) {
        jdField_a_of_type_Begf = new begf();
      }
      return jdField_a_of_type_Begf;
    }
  }
  
  private begh a(String paramString)
  {
    begh localbegh = new begh();
    localbegh.jdField_a_of_type_JavaLangString = paramString;
    localbegh.jdField_a_of_type_Int = 4;
    localbegh.jdField_c_of_type_Int = 10006;
    return localbegh;
  }
  
  private void a(Handler paramHandler, begh parambegh)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = parambegh;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(begh parambegh)
  {
    Handler localHandler;
    if ((parambegh != null) && (parambegh.jdField_a_of_type_AndroidOsHandler != null))
    {
      localHandler = parambegh.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, parambegh);
    HybridWebReporter.a().a(parambegh.jdField_a_of_type_Begd);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    begh localbegh = (begh)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localbegh == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localbegh.jdField_a_of_type_Int = 2;
    localbegh.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localbegh);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, begh parambegh)
  {
    if (parambegh.jdField_a_of_type_Begd == null)
    {
      parambegh.jdField_a_of_type_Begd = new begd();
      parambegh.jdField_a_of_type_Begd.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      parambegh.jdField_a_of_type_Begd.jdField_a_of_type_JavaLangString = parambegh.jdField_b_of_type_JavaLangString;
      parambegh.jdField_a_of_type_Begd.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      parambegh.jdField_a_of_type_Begd.jdField_f_of_type_Int = 1;
    }
    parambegh.jdField_a_of_type_Begd.e = paramBundle.getString("key_user_ip");
    parambegh.jdField_a_of_type_Begd.h = paramBundle.getString("key_dns_result");
    parambegh.jdField_a_of_type_Begd.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    parambegh.jdField_a_of_type_Begd.g = paramBundle.getString("key_server_port");
    parambegh.jdField_a_of_type_Begd.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    parambegh.jdField_a_of_type_Begd.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    parambegh.jdField_a_of_type_Begd.jdField_c_of_type_Int = 0;
    parambegh.jdField_a_of_type_Begd.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      parambegh.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      parambegh.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(parambegh);
      QLog.w("WebSoCgiService", 1, "state=" + parambegh);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new begc((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        parambegh.jdField_c_of_type_Int = 10002;
        parambegh.jdField_f_of_type_JavaLangString = "rsp is null";
        a(parambegh);
        QLog.w("WebSoCgiService", 1, "state=" + parambegh);
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
        parambegh.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        parambegh.jdField_a_of_type_Begd.d = localObject2[1].trim();
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
        parambegh.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    parambegh.jdField_c_of_type_Int = 0;
    parambegh.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = parambegh.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(parambegh);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(begg parambegg, Handler paramHandler)
  {
    return a(parambegg, paramHandler, SwiftBrowserCookieMonster.c(parambegg.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(begg parambegg, Handler paramHandler, String paramString)
  {
    if ((parambegg == null) || (TextUtils.isEmpty(parambegg.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parambegg);
      return false;
    }
    if (!bdee.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parambegg);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parambegg + ",uniKey=" + str1);
    }
    begh localbegh = new begh();
    localbegh.jdField_a_of_type_JavaLangString = str1;
    localbegh.jdField_b_of_type_JavaLangString = parambegg.jdField_a_of_type_JavaLangString;
    localbegh.jdField_a_of_type_Boolean = parambegg.jdField_a_of_type_Boolean;
    localbegh.jdField_a_of_type_Int = 1;
    localbegh.e = parambegg.jdField_f_of_type_JavaLangString;
    localbegh.jdField_a_of_type_JavaLangObject = parambegg.jdField_a_of_type_JavaLangObject;
    localbegh.jdField_a_of_type_Begd = new begd();
    localbegh.jdField_a_of_type_Begd.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localbegh.jdField_a_of_type_Begd.jdField_a_of_type_JavaLangString = parambegg.jdField_a_of_type_JavaLangString;
    localbegh.jdField_a_of_type_Begd.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localbegh);
    long l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str3 = bizf.a();
    String str2 = begt.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parambegg.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", parambegg.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parambegg.e);
      localJSONObject.put("uri", parambegg.jdField_a_of_type_JavaLangString);
      if (parambegg.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parambegg.d))
        {
          if (!parambegg.jdField_a_of_type_JavaLangString.contains("?")) {
            break label705;
          }
          localJSONObject.put("uri", parambegg.jdField_a_of_type_JavaLangString + "&" + parambegg.d);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parambegg.jdField_c_of_type_JavaLangString);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localbegh.jdField_a_of_type_AndroidOsHandler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parambegg.jdField_a_of_type_JavaLangString, paramString, "", parambegg.jdField_a_of_type_Int, 1101, str1, begf.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localbegh.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label705:
          localJSONObject.put("uri", parambegg.jdField_a_of_type_JavaLangString + "?" + parambegg.d);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parambegg.d)) {
          localJSONObject.put("content_length", parambegg.d.length());
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
 * Qualified Name:     begf
 * JD-Core Version:    0.7.0.1
 */