import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.vashealth.PathTraceService;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public class bglz
  extends WebViewPlugin
{
  public Activity a;
  private LocationManager a;
  public AppInterface a;
  public boolean a;
  
  public bglz()
  {
    this.mPluginNameSpace = "healthpathtrace";
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("__page=run"));
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = (PathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(210);
    this.jdField_a_of_type_Boolean = a(paramString);
    if (!this.jdField_a_of_type_Boolean) {
      bool2 = false;
    }
    do
    {
      return bool2;
      ((PathTraceManager)localObject).a(this);
    } while ((paramLong != 8589934597L) && (paramLong != 2L) && (paramLong != 32L));
    if ((paramLong == 8589934597L) && (((PathTraceManager)localObject).b() == 0))
    {
      ((PathTraceManager)localObject).b(0);
      paramString = "pause";
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      QLog.i("PathTraceManager.Plugin", 1, "webview event type:" + paramLong + ", event name: " + paramString);
      return bool1;
      if ((paramLong == 2L) && (((PathTraceManager)localObject).b() == 0))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity)) {
              ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            }
          }
        }
        for (;;)
        {
          paramString = "resume";
          bool1 = true;
          break;
          ((PathTraceManager)localObject).a(0);
          continue;
          ((PathTraceManager)localObject).a(0);
        }
      }
      if (paramLong == 32L)
      {
        paramString = Uri.parse(paramString);
        label334:
        float f2;
        float f1;
        if (paramString.getQuery() != null) {
          if (paramString.getQueryParameter("runningState") != null)
          {
            paramString = String.valueOf(paramMap.get("url")).replace("runningState=" + paramString.getQueryParameter("runningState"), "runningState=" + ((PathTraceManager)localObject).a());
            localObject = BaseApplicationImpl.getApplication().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin(), 0);
            f2 = 0.0F;
            f1 = 0.0F;
            long l = ((SharedPreferences)localObject).getLong("search_lbs_timestamp", 0L);
            if (System.currentTimeMillis() - l < 10800000L)
            {
              f2 = ((SharedPreferences)localObject).getFloat("search_lbs_logitude", 0.0F);
              f1 = ((SharedPreferences)localObject).getFloat("search_lbs_latitude", 0.0F);
            }
            if (!paramString.contains("lati")) {
              break label665;
            }
            paramString = paramString.replace("lati=" + Uri.parse(paramString).getQueryParameter("lati"), "lati=" + f1);
            label469:
            if (!paramString.contains("logi")) {
              break label693;
            }
          }
        }
        label665:
        label693:
        for (paramString = paramString.replace("logi=" + Uri.parse(paramString).getQueryParameter("logi"), "logi=" + f2);; paramString = paramString + "&logi=" + f2)
        {
          paramMap.put("url", paramString);
          if (QLog.isColorLevel()) {
            QLog.d("PathTraceManager.Plugin", 2, "Intercep url:" + paramString);
          }
          bool1 = false;
          paramString = "";
          break;
          paramString = String.valueOf(paramMap.get("url")) + "&runningState=" + ((PathTraceManager)localObject).a();
          break label334;
          paramString = String.valueOf(paramMap.get("url")) + "?runningState=" + ((PathTraceManager)localObject).a();
          break label334;
          paramString = paramString + "&lati=" + f1;
          break label469;
        }
      }
      paramString = "";
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString1 == null) || (!"healthpathtrace".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localJSONObject == null) {
        break label2556;
      }
      paramJsBridgeListener = localJSONObject.getString("callback");
      QLog.i("PathTraceManager.Plugin", 1, "handleJsRequest method: " + paramString3 + ", args: " + localJSONObject.toString());
      paramString1 = paramVarArgs[0];
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("PathTraceManager.Plugin", 1, "need callback");
        return true;
      }
      paramVarArgs = (PathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(210);
      if ("PathTraceStatus".equals(paramString3))
      {
        paramString2 = new JSONObject();
        paramString2.put("retCode", 1);
        paramString2.put("runningState", paramVarArgs.a());
        if (paramVarArgs.a() != 0)
        {
          paramString1 = paramVarArgs.a();
          if (paramString1 != null) {
            break label2553;
          }
          paramString1 = paramVarArgs.b();
          label182:
          if (paramString1 == null) {
            break label217;
          }
          paramString2.put("type", paramString1.type);
        }
        for (;;)
        {
          super.callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          break;
          label217:
          QLog.i("PathTraceManager.Plugin", 1, "pathtrace type err");
        }
      }
      if (!"PathTraceInit".equals(paramString3)) {
        break label391;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.i("PathTraceManager.Plugin", 1, "HandleJs Err:" + paramJsBridgeListener.toString());
    }
    paramString1 = new JSONObject();
    if (!this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps")) {
      paramString1.put("retCode", -2);
    }
    for (;;)
    {
      callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      break;
      paramString1.put("retCode", 1);
      if ((paramVarArgs != null) && (paramVarArgs.b() != null))
      {
        paramString1.put("retCode", -7);
        paramString1.put("startTime", paramVarArgs.b().startTime);
        paramString1.put("records", paramVarArgs.a(null).toString());
      }
    }
    label391:
    if ("PathTraceOriginLocation".equals(paramString3))
    {
      if ((paramVarArgs != null) && (paramVarArgs.b() > 0))
      {
        paramString1 = new JSONObject();
        paramString1.put("retCode", -4);
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      else
      {
        paramString1 = new JSONObject();
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
          {
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
            {
              ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
              paramString1.put("retCode", -4);
              super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              if (paramVarArgs != null) {
                paramVarArgs.a(0);
              }
            }
          }
          else
          {
            paramString1.put("retCode", 1);
            super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            if (paramVarArgs != null) {
              paramVarArgs.a(0);
            }
          }
        }
        else
        {
          paramString1.put("retCode", 1);
          super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          if (paramVarArgs != null) {
            paramVarArgs.a(0);
          }
        }
      }
    }
    else if ("PathTraceStart".equals(paramString3))
    {
      paramString1 = new JSONObject();
      if (!this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps"))
      {
        paramString1.put("retCode", -2);
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return false;
      }
      if (Build.VERSION.SDK_INT < 19)
      {
        paramString1.put("stepAuth", 1);
        label706:
        paramString2 = new Bundle();
        paramString2.putString("cmd", "qq_sport_banner");
        paramString2.putBoolean("showParameter", true);
        ardu.a().b(paramString2);
        if (Build.VERSION.SDK_INT < 23) {
          break label882;
        }
        if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity)) {
            break label2561;
          }
          ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          paramString1.put("retCode", -2);
          super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          break label2561;
        }
      }
      else
      {
        if (((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor")).getDefaultSensor(19) != null) {
          break label2563;
        }
      }
    }
    label2561:
    label2563:
    for (int i = 1;; i = 0)
    {
      paramString1.put("stepAuth", i);
      break label706;
      paramVarArgs.a(localJSONObject);
      super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      break label2561;
      label882:
      paramVarArgs.a(localJSONObject);
      super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      break label2561;
      if ("PathTracePause".equals(paramString3))
      {
        paramString1 = new JSONObject();
        paramVarArgs.c();
        paramString1.put("retCode", 1);
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      else
      {
        if ("PathTraceResume".equals(paramString3))
        {
          paramString1 = new JSONObject();
          if (!this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps"))
          {
            paramString1.put("retCode", -2);
            super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return false;
          }
          if (paramVarArgs.a() == null)
          {
            paramString1.put("retCode", -12);
            paramString1.put("message", "invalid startTime");
          }
          for (;;)
          {
            super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            break;
            paramString2 = new Bundle();
            paramString2.putString("cmd", "qq_sport_banner");
            paramString2.putBoolean("showParameter", true);
            ardu.a().b(paramString2);
            if (Build.VERSION.SDK_INT >= 23)
            {
              if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
              {
                if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
                {
                  ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
                  paramString1.put("retCode", -2);
                  super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                }
              }
              else
              {
                paramVarArgs.d();
                paramString1.put("retCode", 1);
              }
            }
            else
            {
              paramVarArgs.d();
              paramString1.put("retCode", 1);
            }
          }
        }
        if ("PathTraceEnd".equals(paramString3))
        {
          paramString3 = new JSONObject();
          paramString2 = paramVarArgs.a();
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = paramVarArgs.b();
          }
          if (paramString1 == null)
          {
            paramString3.put("retCode", -8);
            QLog.e("PathTraceManager.Plugin", 1, "PathTraceEnd Err");
          }
          for (;;)
          {
            paramString1 = new Bundle();
            paramString1.putString("cmd", "qq_sport_banner");
            paramString1.putBoolean("showParameter", false);
            ardu.a().b(paramString1);
            QLog.d("PathTraceManager.Plugin", 1, "end result data:" + paramString3.toString());
            super.callJs(paramJsBridgeListener, new String[] { paramString3.toString() });
            break;
            long l1 = localJSONObject.optLong("totalTime", paramString1.totalTime);
            long l2;
            float f;
            if (paramVarArgs.a(l1))
            {
              paramString3.put("retCode", 1);
              paramString3.put("startTime", paramString1.startTime);
              paramString2 = new JSONArray();
              paramVarArgs = BaseApplicationImpl.getApplication().getSharedPreferences(String.valueOf(paramString1.startTime), 0);
              l2 = paramVarArgs.getLong(String.valueOf(PathTraceManager.a), 0L);
              f = paramVarArgs.getFloat(String.valueOf(PathTraceManager.jdField_b_of_type_Int), 0.0F);
              if (l1 - l2 <= 0L) {
                break label1747;
              }
              paramVarArgs.edit().putString(String.valueOf((int)(paramString1.distance / 1000.0D + 1.0D)), String.valueOf((int)((l1 - l2) / ((paramString1.distance - f) / Float.valueOf(1000.0F).floatValue()))) + ",0,0").commit();
              QLog.d("PathTraceManager.Plugin", 1, ">0 toalTime:" + l1 + ",lastspeedtime:" + l2 + ",distance:" + paramString1.distance + ",lastdistance:" + f);
            }
            for (;;)
            {
              i = 1;
              for (paramString1 = paramVarArgs.getString(String.valueOf(1), null); paramString1 != null; paramString1 = paramVarArgs.getString(String.valueOf(i), null))
              {
                paramString1 = paramString1.split(",");
                localJSONObject = new JSONObject();
                localJSONObject.put("km", String.valueOf(i));
                localJSONObject.put("time", paramString1[0]);
                localJSONObject.put("latitude", paramString1[1]);
                localJSONObject.put("longitude", paramString1[2]);
                paramString2.put(localJSONObject);
                i += 1;
              }
              paramString3.put("retCode", -5);
              break;
              label1747:
              if (paramString1.totalTime - l2 > 0L)
              {
                paramVarArgs.edit().putString(String.valueOf((int)(paramString1.distance / 1000.0D + 1.0D)), String.valueOf((int)((paramString1.totalTime - l2) / ((paramString1.distance - f) / Float.valueOf(1000.0F).floatValue()))) + ",0,0").commit();
                QLog.d("PathTraceManager.Plugin", 1, "<0 toalTime:" + l1 + ",lastspeedtime:" + l2 + ",distance:" + paramString1.distance + ",lastdistance:" + f);
              }
              else
              {
                QLog.d("PathTraceManager.Plugin", 1, "<>0exception toalTime:" + l1 + ",lastspeedtime:" + l2 + ",distance:" + paramString1.distance + ",lastdistance:" + f);
              }
            }
            paramString3.put("kmrecords", paramString2);
          }
        }
        if ("PathTraceUpload".equals(paramString3))
        {
          paramString1 = new JSONObject();
          if (!localJSONObject.has("startTime"))
          {
            paramString1.put("retCode", -12);
            paramString1.put("message", "invalid startTime");
            super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          else
          {
            paramVarArgs.a(localJSONObject.optLong("startTime"), paramJsBridgeListener);
          }
        }
        else if ("PathTraceBack".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramString1.put("retCode", 1);
          super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        }
        else
        {
          if ("PathTraceQueryOne".equals(paramString3))
          {
            paramString2 = new JSONObject();
            if (!TextUtils.isEmpty(paramJsBridgeListener))
            {
              paramString1 = paramVarArgs.a(paramString1);
              paramString2.put("retCode", 1);
              paramString2.put("records", paramString1.toString());
            }
            for (;;)
            {
              super.callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
              break;
              paramString2.put("retCode", -8);
            }
          }
          if ("PathTraceQuery".equals(paramString3))
          {
            super.callJs(paramJsBridgeListener, new String[] { paramVarArgs.a().toString() });
          }
          else if ("PathTraceDelete".equals(paramString3))
          {
            paramString1 = Long.valueOf(new JSONObject(paramString1).optLong("startTime"));
            paramJsBridgeListener = paramString1;
            if (paramString1.longValue() == 0L)
            {
              paramJsBridgeListener = paramString1;
              if (paramVarArgs.b() != null) {
                paramJsBridgeListener = Long.valueOf(paramVarArgs.b().startTime);
              }
            }
            paramVarArgs.a(paramJsBridgeListener);
          }
          else
          {
            if ("PathTraceVoiceControl".equals(paramString3))
            {
              i = new JSONObject(paramString1).optInt("mute");
              if (i == 1) {
                paramVarArgs.d = true;
              }
              for (;;)
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", 1);
                super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                break;
                if (i == 0) {
                  paramVarArgs.d = false;
                }
              }
            }
            if ("PathTraceIgnoreSpeed".equals(paramString3))
            {
              if (new JSONObject(paramString1).optInt("ignoreSpeed") == 1) {}
              for (paramVarArgs.jdField_b_of_type_Boolean = true;; paramVarArgs.jdField_b_of_type_Boolean = false)
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", 1);
                super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                break;
              }
            }
            if ("PathTraceGpsAuth".equals(paramString3))
            {
              paramString1 = new JSONObject();
              if (!this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps")) {
                paramString1.put("retCode", -2);
              }
              for (;;)
              {
                super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                break;
                paramString1.put("retCode", 1);
              }
              label2553:
              break label182;
              label2556:
              paramJsBridgeListener = null;
              break;
            }
          }
        }
      }
      return false;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    this.jdField_a_of_type_AndroidLocationLocationManager = ((LocationManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("location"));
    PathTraceManager localPathTraceManager = (PathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(210);
    if (this.mRuntime.a() != null) {}
    for (String str = this.mRuntime.a().mUrl;; str = null)
    {
      this.jdField_a_of_type_Boolean = a(str);
      if (this.jdField_a_of_type_Boolean) {
        localPathTraceManager.a(this);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager.Plugin", 2, "OnCreate isRunningPage: " + this.jdField_a_of_type_Boolean);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      PathTraceManager localPathTraceManager = (PathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(210);
      if (this.mRuntime.a() != null) {
        String str = this.mRuntime.a().mUrl;
      }
      if ((localPathTraceManager != null) && (localPathTraceManager.b() == 0) && (this.jdField_a_of_type_Boolean))
      {
        QLog.d("PathTraceManager.Plugin", 1, "here stop");
        localPathTraceManager.b(-1);
        PathTraceService.c();
      }
      QLog.d("PathTraceManager.Plugin", 1, "onDestroy isRunningPage: " + this.jdField_a_of_type_Boolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PathTraceManager.Plugin", 1, "onDestroy Err:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglz
 * JD-Core Version:    0.7.0.1
 */