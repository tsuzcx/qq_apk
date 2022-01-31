import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class aqmw
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = 1;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aqnb(this);
  protected Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new aqmz(this, Looper.getMainLooper());
  private aqkd jdField_a_of_type_Aqkd;
  private aqmf jdField_a_of_type_Aqmf;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  public String a;
  public long b;
  public String b;
  private long c;
  public String c;
  public String d;
  private String e = "";
  private String f = "com.tencent.huiyin";
  
  public aqmw()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.mPluginNameSpace = "huiyin";
  }
  
  private JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("state", Integer.valueOf(paramInt));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("seqid", paramLong);
      if (paramString2 != null) {
        localJSONObject.put("msg", paramString2);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("data", paramJSONObject);
      }
      a("invoke jscallback " + localJSONObject.toString());
      callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      a("invoke callback error " + paramString1.getLocalizedMessage());
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/huiyin";
    if (!new File(str).exists()) {
      new File(str).mkdir();
    }
    this.jdField_a_of_type_Aqmf.a(str + "/av_" + System.currentTimeMillis() + this.jdField_a_of_type_Aqmf.a(), new aqmy(this));
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 0;
    a(0, paramLong, paramString, null, null);
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    str5 = "unknown";
    String str4 = "http://huiyin.qq.com/cgi-bin/mozart/upload_user_voice";
    String str3 = "0";
    Log.i("Huiyin", "do real upload begin...");
    localObject2 = str3;
    str1 = str4;
    try
    {
      localJSONObject = new JSONObject(paramString2);
      localObject2 = str3;
      str1 = str4;
      localObject1 = str4;
      if (!localJSONObject.has("uploadUrl")) {
        break label502;
      }
      localObject2 = str3;
      str1 = str4;
      localObject1 = localJSONObject.getString("uploadUrl");
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        Object localObject1;
        try
        {
          JSONObject localJSONObject;
          str1 = URLEncoder.encode(this.jdField_c_of_type_JavaLangString, "UTF-8");
          aqmj.a(paramString2, this.e, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, str1, (String)localObject1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_JavaLangString, new aqna(this, paramLong, paramString1));
          return;
          paramString2 = paramString2;
          localObject1 = localObject2;
          paramString2 = str1;
          continue;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          String str2 = str5;
          continue;
        }
        paramString2 = (String)localObject1;
        if (localObject1 == null) {
          paramString2 = "http://huiyin.qq.com/cgi-bin/mozart/upload_user_voice";
        }
      }
    }
    localObject1 = str3;
    localObject2 = str3;
    str1 = paramString2;
    if (localJSONObject.has("gender"))
    {
      localObject2 = str3;
      str1 = paramString2;
      localObject1 = localJSONObject.getString("gender");
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("tinyID"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.jdField_a_of_type_Long = Long.parseLong(localJSONObject.getString("tinyID"));
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "tinyID: " + this.jdField_a_of_type_Long);
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("a2"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.jdField_a_of_type_JavaLangString = localJSONObject.getString("a2");
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "a2: " + this.jdField_a_of_type_JavaLangString);
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("uid"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.jdField_b_of_type_Long = Long.parseLong(localJSONObject.getString("uid"));
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "uin: " + this.jdField_b_of_type_Long);
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("voice_word"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.jdField_b_of_type_JavaLangString = localJSONObject.getString("voice_word");
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "voice_word: " + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Huiyin", 2, paramString);
    }
  }
  
  private void b(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Aqmf.a();
    this.jdField_a_of_type_Int = 1;
    a(0, paramLong, paramString, null, null);
  }
  
  private void c(long paramLong, String paramString)
  {
    int i = this.jdField_a_of_type_Aqmf.c();
    if (this.jdField_a_of_type_Int == 0) {}
    for (long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;; l = 0L) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("volume", i);
        localJSONObject.put("duration", l);
        localJSONObject.put("state", this.jdField_a_of_type_Int);
        localJSONObject.put("seqid", paramLong);
        a(0, paramLong, paramString, null, localJSONObject);
        return;
      }
      catch (JSONException paramString) {}
    }
  }
  
  void a(String paramString, int paramInt)
  {
    aqnc.a.jdField_a_of_type_Int = -1;
    if (paramString == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("redNum", paramInt);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"huiyin".equals(paramString2)) {}
    do
    {
      return false;
      paramString2 = new StringBuilder().append("huiyin handleJsRequest: method:").append(paramString3).append(" args:");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        paramJsBridgeListener = paramVarArgs[0];
      }
      for (;;)
      {
        a(paramJsBridgeListener);
        long l1 = 0L;
        paramString1 = Uri.parse(paramString1);
        for (;;)
        {
          try
          {
            long l2 = Long.valueOf(paramString1.getQueryParameter("seqid")).longValue();
            l1 = l2;
          }
          catch (Exception paramJsBridgeListener)
          {
            continue;
          }
          try
          {
            paramJsBridgeListener = paramString1.getQueryParameter("callback");
            if ("startRecord".equals(paramString3))
            {
              a(l1, paramJsBridgeListener);
              return false;
              paramJsBridgeListener = "";
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener = null;
            continue;
            if ("stopRecord".equals(paramString3))
            {
              b(l1, paramJsBridgeListener);
              return false;
            }
            if ("queryRecordState".equals(paramString3))
            {
              c(l1, paramJsBridgeListener);
              return false;
            }
            if ("uploadRecord".equals(paramString3)) {
              try
              {
                paramString1 = URLDecoder.decode(paramString1.getQueryParameter("param"), "UTF-8");
                Log.i("Huiyin", "upload extra " + paramString1);
                a(l1, paramJsBridgeListener, paramString1);
                return false;
              }
              catch (Exception paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                return false;
              }
            }
            if ("start".equals(paramString3))
            {
              baig.b(this.mRuntime.a().getApp().getApplicationContext());
              aqnc.a.a(this.mRuntime.a(), paramString1.getQueryParameter("p"));
              a(this.d, 0);
              this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("huiyin").opName("huiyin_click").report();
              aqnc.a.a(0, null);
              return false;
            }
            if ("requestRedNum".equals(paramString3))
            {
              aqnc.a.b(this.mRuntime.a(), paramString1.getQueryParameter("p"));
              this.d = paramJsBridgeListener;
              if (aqnc.a.jdField_a_of_type_Int != -1)
              {
                a(this.d, aqnc.a.jdField_a_of_type_Int);
                return false;
              }
              aqnc.a.a(this.mRuntime.a(), new aqmx(this));
              return false;
            }
          }
        }
      }
    } while (!"registerOk".equals(paramString3));
    aqnc.a.jdField_a_of_type_Boolean = false;
    aqnc.a.a(11, null);
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
    a(" onCreate");
    this.jdField_a_of_type_Aqmf = new aqmf(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Aqkd = new aqkd();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("huiyin");
    IntentFilter localIntentFilter = new IntentFilter(aqlr.a(this.f));
    localIntentFilter.addAction(aqlr.b(this.f));
    localIntentFilter.addAction(aqlr.c(this.f));
    localIntentFilter.addAction(aqlr.d(this.f));
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Aqmf.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmw
 * JD-Core Version:    0.7.0.1
 */