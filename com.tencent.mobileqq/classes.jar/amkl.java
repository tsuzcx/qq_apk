import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.Map;
import org.json.JSONObject;

public class amkl
{
  public static final int a;
  private static long a;
  
  static
  {
    jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  }
  
  public static int a(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return bcwh.a(paramContext, paramInt);
  }
  
  private static long a()
  {
    long l = System.currentTimeMillis() / 1000L;
    if ((jdField_a_of_type_Long != 0L) && (86400L + jdField_a_of_type_Long > l)) {
      return jdField_a_of_type_Long;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l = localCalendar.getTimeInMillis() / 1000L;
    jdField_a_of_type_Long = l;
    return l;
  }
  
  public static String a(String paramString)
  {
    String str = "{" + paramString + "}";
    paramString = "";
    try
    {
      str = new JSONObject(str).get("metaData").toString();
      paramString = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQDailyUtils", 2, localException, new Object[0]);
    }
    return paramString;
    return "";
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong > a();
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQDailyUtils", 2, "param is null");
      }
      return false;
    }
    String str1 = (String)paramMap.get("appname");
    String str2 = (String)paramMap.get("appview");
    String str3 = (String)paramMap.get("appversion");
    paramMap = (String)paramMap.get("metaData");
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyUtils", 2, "appName: " + str1 + "\nappView: " + str2 + "\nappVersion: " + str3 + "\nmetaData: " + paramMap);
    }
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkl
 * JD-Core Version:    0.7.0.1
 */