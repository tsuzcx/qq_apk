import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class bexd
{
  protected static bexd a;
  protected static String a;
  protected int a;
  protected long a;
  protected Context a;
  protected long b;
  protected String b;
  protected String c = "";
  protected String d = "";
  protected String e = "";
  protected String f = "";
  protected String g = "";
  protected String h = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "androidqq";
  }
  
  protected bexd()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public static bexd a()
  {
    try
    {
      if (jdField_a_of_type_Bexd == null) {
        jdField_a_of_type_Bexd = new bexd();
      }
      bexd localbexd = jdField_a_of_type_Bexd;
      return localbexd;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != -1) {
      return this.jdField_a_of_type_Int;
    }
    a();
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
      bfhg.b("CommonDataAdapter", "get uin from app runtim succ:" + this.jdField_a_of_type_Long);
      label46:
      return this.jdField_a_of_type_Long;
    }
    catch (Throwable localThrowable)
    {
      break label46;
    }
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return BaseApplication.getContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(int paramInt, Context paramContext)
  {
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    PackageManager localPackageManager = paramContext.getPackageManager();
    int j = paramInt;
    if (paramInt <= 0) {
      j = 5;
    }
    localObject1 = ((ActivityManager)localObject1).getRecentTasks(64, 1);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int n;
    int k;
    Object localObject2;
    if (localObject1 != null)
    {
      n = ((List)localObject1).size();
      k = 0;
      paramInt = 0;
      if ((k < n) && (paramInt < j))
      {
        localObject2 = (ActivityManager.RecentTaskInfo)((List)localObject1).get(k);
        paramContext = ((ActivityManager.RecentTaskInfo)localObject2).baseIntent;
        localObject2 = ((ActivityManager.RecentTaskInfo)localObject2).origActivity;
        if (localObject2 != null) {
          paramContext = ((ComponentName)localObject2).getPackageName();
        }
      }
    }
    for (;;)
    {
      label133:
      int i = paramInt;
      if (paramContext != null)
      {
        if (localArrayList.contains(paramContext)) {}
        for (;;)
        {
          k += 1;
          break;
          if (paramContext == null) {
            break label388;
          }
          paramContext = paramContext.getComponent().getPackageName();
          break label133;
          localArrayList.add(paramContext);
          i = -1;
          try
          {
            localObject2 = localPackageManager.getPackageInfo(paramContext, 0);
            if (localObject2 != null) {
              break label206;
            }
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        label206:
        if (localObject2 != null)
        {
          i = ((PackageInfo)localObject2).versionCode;
          String str = ((PackageInfo)localObject2).versionName;
        }
        if ((((PackageInfo)localObject2).applicationInfo.flags & 0x1) == 0) {
          break label382;
        }
      }
      label382:
      for (int m = 1;; m = 0)
      {
        paramInt += 1;
        localStringBuilder.append("\"");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("\"");
        localStringBuilder.append(":");
        localStringBuilder.append("\"");
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        localStringBuilder.append(m);
        localStringBuilder.append("\"");
        i = paramInt;
        if (k < n - 1)
        {
          localStringBuilder.append(",");
          i = paramInt;
        }
        paramInt = i;
        break;
        paramInt = localStringBuilder.length();
        if (localStringBuilder.charAt(paramInt - 1) == ',') {
          localStringBuilder.deleteCharAt(paramInt - 1);
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      label388:
      paramContext = null;
    }
  }
  
  protected void a()
  {
    Object localObject = a().a().getApplicationContext();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      this.d = ((PackageInfo)localObject).versionName;
      this.e = (this.d + "." + ((PackageInfo)localObject).versionCode);
      this.f = this.d.substring(this.d.lastIndexOf('.') + 1, this.d.length());
      this.jdField_a_of_type_Int = ((PackageInfo)localObject).versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bfhg.e("AppUpdate", "getPackageInfo NameNotFoundException : " + localNameNotFoundException.toString());
      return;
    }
    catch (Exception localException)
    {
      bfhg.e("AppUpdate", "getPackageInfo exception : " + localException.toString());
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, Context paramContext, WebView paramWebView)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("imei", bfin.c());
      localJSONObject2.put("imsi", bfin.d());
      localJSONObject2.put("mac_addr", bfin.a());
      localJSONObject2.put("model_info", Build.MODEL);
      localJSONObject2.put("network_type", bfhb.a(a().a()));
      localJSONObject2.put("network_operater", "");
      localJSONObject2.put("location", bfin.f());
      localJSONObject2.put("android_id", Settings.Secure.getString(a().a().getContentResolver(), "android_id"));
      localJSONObject2.put("os_api_level", Build.VERSION.SDK_INT);
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("params");
      if ((localJSONObject3 != null) && (localJSONObject3.length() > 0))
      {
        Iterator localIterator = localJSONObject3.keys();
        while (localIterator.hasNext())
        {
          String str2 = localIterator.next().toString();
          Object localObject = localJSONObject3.get(str2);
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject2.put(str2, localObject);
          }
        }
      }
      String str1;
      return;
    }
    catch (JSONException localJSONException)
    {
      bfhg.e("AppUpdate", "getUpdateApp parse H5 params error : " + localJSONException.toString());
      if (!paramContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
      {
        bfhg.c("AppUpdate", "getUpdateApp will do full report");
        bfiq.a(paramContext, paramString, paramWebView, String.valueOf(a().a()), false);
        return;
        if (localJSONObject3 != null) {
          localJSONObject2.put("latest_used", a(localJSONObject3.optInt("latest_num", 10), paramContext));
        }
        for (;;)
        {
          localJSONException.put("params", localJSONObject2);
          str1 = localJSONException.toString();
          paramString = str1;
          break;
          localJSONObject2.put("latest_used", a(10, paramContext));
        }
      }
      if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
      {
        bfhg.c("AppUpdate", "getUpdateApp will do incremental report");
        bfiq.a(paramContext, null, 0, paramString, paramWebView, String.valueOf(a().a()));
        return;
      }
      bfhg.c("AppUpdate", "getUpdateApp will get update app directly");
      bfis.a(paramContext, paramWebView, paramString, true, String.valueOf(a().a()));
    }
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return this.e;
    }
    a();
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public String d()
  {
    if (!TextUtils.isEmpty(this.d)) {
      return this.d;
    }
    a();
    return this.d;
  }
  
  public String e()
  {
    return "12";
  }
  
  public String f()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    this.g = ("V1_AND_SQ_" + c());
    return this.g;
  }
  
  public String g()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexd
 * JD-Core Version:    0.7.0.1
 */