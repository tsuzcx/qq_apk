import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class atbi
{
  public static Map<String, atbi> a;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap.get(paramString) != null) {}
    do
    {
      return;
      paramContext = paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).getString("pre_monitor" + paramString, null);
    } while (paramContext == null);
    a(paramString, paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((jdField_a_of_type_JavaUtilMap.get(paramString1) != null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit().putString("pre_monitor" + paramString1, paramString2).commit();
    a(paramString1, paramString2);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      atbi localatbi = new atbi();
      localatbi.jdField_a_of_type_Int = paramString2.optInt("startupId");
      localatbi.b = paramString2.optInt("downloadSucId");
      localatbi.c = paramString2.optInt("downloadFailId");
      localatbi.d = paramString2.optInt("loadSucId");
      localatbi.e = paramString2.optInt("loadFailId");
      localatbi.f = paramString2.optInt("startSucId");
      localatbi.g = paramString2.optInt("firstUserId");
      localatbi.h = paramString2.optInt("exitId");
      jdField_a_of_type_JavaUtilMap.put(paramString1, localatbi);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorConfig", 2, paramString1 + localatbi);
      }
      return;
    }
    catch (Throwable paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MonitorConfig", 2, "pareMonitorConfig exception :" + paramString1);
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap.get(paramString) != null)
    {
      atbh.b(String.valueOf(((atbi)jdField_a_of_type_JavaUtilMap.get(paramString)).jdField_a_of_type_Int));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MonitorConfig", 2, "没有找到匹配的monitor离线配置文件，重新拉取一次");
    }
    atbh.b("3235982");
    new Handler(Looper.getMainLooper()).postDelayed(new MonitorConfig.1(paramContext, paramString), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbi
 * JD-Core Version:    0.7.0.1
 */