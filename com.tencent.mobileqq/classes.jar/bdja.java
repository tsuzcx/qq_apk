import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class bdja
{
  protected static String a;
  protected static String b;
  protected static String c;
  protected static String d;
  protected static String e;
  
  public static String a()
  {
    if (TextUtils.isEmpty(a)) {
      a = "";
    }
    try
    {
      Object localObject = bcxm.a().a();
      if (localObject != null)
      {
        a = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("wifi_mac_address", "");
        if (TextUtils.isEmpty(a))
        {
          a = bfmw.c("7ef1aa");
          if (a != null)
          {
            localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
            ((SharedPreferences.Editor)localObject).putString("wifi_mac_address", a);
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return a;
  }
  
  public static String b()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String c()
  {
    Object localObject;
    if (TextUtils.isEmpty(c))
    {
      c = "";
      localObject = bcxm.a().a();
      if (localObject != null)
      {
        c = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("imei", "");
        if (!TextUtils.isEmpty(c)) {}
      }
    }
    try
    {
      c = bfmw.a("52b7f2");
      label61:
      if (c != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("imei", c);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return c;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public static String d()
  {
    Object localObject;
    if (TextUtils.isEmpty(d))
    {
      d = "";
      localObject = bcxm.a().a();
      if (localObject != null)
      {
        d = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("imsi", "");
        if (!TextUtils.isEmpty(d)) {}
      }
    }
    try
    {
      d = bfmw.b("ea6862");
      label61:
      if (d != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("imsi", d);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return d;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public static String e()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    WindowManager localWindowManager = (WindowManager)bcxm.a().a().getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    return i + "x" + j;
  }
  
  public static String f()
  {
    if (!TextUtils.isEmpty(e)) {
      return e;
    }
    Object localObject1 = bcxm.a().a();
    if (localObject1 == null) {
      return "";
    }
    try
    {
      localObject1 = (LocationManager)((Context)localObject1).getSystemService("location");
      Object localObject2 = new Criteria();
      ((Criteria)localObject2).setCostAllowed(false);
      ((Criteria)localObject2).setAccuracy(2);
      localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
      if (localObject2 != null)
      {
        localObject1 = ((LocationManager)localObject1).getLastKnownLocation((String)localObject2);
        if (localObject1 == null) {
          return "";
        }
        double d1 = ((Location)localObject1).getLatitude();
        double d2 = ((Location)localObject1).getLongitude();
        localObject1 = d1 + "*" + d2;
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      bdht.c("getLocation", "getLocation>>>", localException);
    }
    return "";
  }
  
  public static String g()
  {
    return "";
  }
  
  public static String h()
  {
    try
    {
      Context localContext = bcxm.a().a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("imei=").append(c()).append('&');
      localStringBuilder.append("model=").append(Build.MODEL).append('&');
      localStringBuilder.append("os=").append(Build.VERSION.RELEASE).append('&');
      localStringBuilder.append("apilevel=").append(Build.VERSION.SDK_INT).append('&');
      String str = bdho.b(localContext);
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localStringBuilder.append("network=").append((String)localObject).append('&');
      localObject = localStringBuilder.append("sdcard=");
      if (Environment.getExternalStorageState().equals("mounted")) {}
      for (int i = 1;; i = 0)
      {
        ((StringBuilder)localObject).append(i).append('&');
        localStringBuilder.append("display=").append(e()).append('&');
        localStringBuilder.append("manu=").append(Build.MANUFACTURER).append("&");
        localStringBuilder.append("wifi=").append(bdho.e(localContext));
        localObject = localStringBuilder.toString();
        return localObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public static String i()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", bcxm.a().f());
      localJSONObject.put("longitude", f());
      localJSONObject.put("platform", bcxm.a().g());
      localJSONObject.put("uin", bcxm.a().a());
      localJSONObject.put("imei", c());
      localJSONObject.put("imei", c());
      localJSONObject.put("resolution", e());
      localJSONObject.put("network", bdho.a(bcxm.a().a()));
      localJSONObject.put("wifimac", a());
      localJSONObject.put("mobile_pf", "1");
      localJSONObject.put("os_ver", Build.VERSION.RELEASE);
      localJSONObject.put("lang", b());
      localJSONObject.put("device", Build.DEVICE);
      localJSONObject.put("model_name", Build.MODEL);
      localJSONObject.put("sdk_ver", "1.5");
      localJSONObject.put("timezone", TimeZone.getDefault().getID());
      localJSONObject.put("city", g());
      localJSONObject.put("longitude", f());
      localJSONObject.put("ret_code", "0");
      localJSONObject.put("qua", bcxm.a().f());
      localJSONObject.put("qz_ver", bcxm.a().c());
      localJSONObject.put("imsi", d());
      localJSONObject.put("androidID", Settings.Secure.getString(bcxm.a().a().getContentResolver(), "android_id"));
      localJSONObject.put("os_api_level", Build.VERSION.SDK_INT);
      localJSONObject.put("sdkVersionCode", 1);
      localJSONObject.put("QVersionCode", bcxm.a().a());
      localJSONObject.put("brand", GlobalUtil.getInstance().getBrand());
      localJSONObject.put("manufacture", GlobalUtil.getInstance().getManufacture());
      localJSONObject.put("product", GlobalUtil.getInstance().getProduct());
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bdht.e("getMobileInfo", "gather mobile info exception.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdja
 * JD-Core Version:    0.7.0.1
 */