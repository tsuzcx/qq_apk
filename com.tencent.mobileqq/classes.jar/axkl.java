import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONArray;

public class axkl
{
  public static axkl a;
  private int jdField_a_of_type_Int = 0;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplicationImpl.getContext();
  private String jdField_a_of_type_JavaLangString = DeviceInfoUtil.getQQVersion();
  private Callback jdField_a_of_type_Okhttp3Callback = new axkm(this);
  private String b = String.valueOf(DeviceInfoUtil.getQQVersionWithCode(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication));
  private String c = DeviceInfoUtil.getIMEI();
  private String d;
  private String e;
  private String f = Build.MODEL;
  
  static
  {
    jdField_a_of_type_Axkl = new axkl();
  }
  
  private axkl()
  {
    if (this.f == null) {
      this.f = "unknown";
    }
    this.e = Build.VERSION.RELEASE;
    if (this.e == null) {
      this.e = "unknown";
    }
    this.d = Build.MANUFACTURER;
    if (this.d == null) {
      this.d = "unknown";
    }
  }
  
  private static int a(Context paramContext)
  {
    int i = NetworkUtil.getNetworkType(paramContext);
    if (i == 1) {
      return 2;
    }
    if (i == 2) {
      return 3;
    }
    if (i == 3) {
      return 4;
    }
    return 1;
  }
  
  private String a(Bundle paramBundle)
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    String str1 = "personal_live_base";
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if ("tid".equals(str2))
      {
        str1 = paramBundle.getString(str2);
      }
      else
      {
        if (!"bid".equals(str2))
        {
          localJSONArray1.put(str2);
          if (!StringUtil.isEmpty(paramBundle.getString(str2))) {
            break label111;
          }
        }
        label111:
        for (str2 = "";; str2 = paramBundle.getString(str2))
        {
          localJSONArray2.put(str2);
          break;
        }
      }
    }
    paramBundle = new JSONArray();
    paramBundle.put(localJSONArray2);
    try
    {
      paramBundle = "&table=" + str1 + "&fields=" + URLEncoder.encode(localJSONArray1.toString(), "UTF-8") + "&datas=" + URLEncoder.encode(paramBundle.toString(), "UTF-8");
      return paramBundle;
    }
    catch (UnsupportedEncodingException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return "";
  }
  
  private void b(Bundle paramBundle)
  {
    Headers localHeaders = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "https://now.qq.com/").build();
    paramBundle = RequestBody.create(MediaType.get("application/x-www-form-urlencoded"), a(paramBundle));
    paramBundle = new Request.Builder().url("https://now.qq.com/cgi-bin/now/web/tdw/report").headers(localHeaders).post(paramBundle).build();
    axjo.a().newCall(paramBundle).enqueue(this.jdField_a_of_type_Okhttp3Callback);
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", String.valueOf(16130));
    localBundle.putString("installsrc", String.valueOf(16130));
    localBundle.putString("platform", "Android");
    localBundle.putString("opername", "now_jiehe");
    localBundle.putString("uin_type", "0");
    localBundle.putString("uin", String.valueOf(axjz.a()));
    localBundle.putString("rom", this.d);
    localBundle.putString("deviceID", this.c);
    localBundle.putString("osversion", this.e);
    localBundle.putString("clientVersion", this.b);
    localBundle.putString("qqversion", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("timestr", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("networktype", String.valueOf(a(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication)));
    Object localObject = "";
    try
    {
      String str = DeviceInfoUtil.getIMEI();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("ReportCenter", 4, "no phone permission");
      }
    }
    localBundle.putString("imei", (String)localObject);
    return localBundle;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.d("ReportCenter", 4, "send(): no data to report");
      return;
    }
    b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkl
 * JD-Core Version:    0.7.0.1
 */