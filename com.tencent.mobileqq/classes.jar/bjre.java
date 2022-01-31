import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReport_Retention_dc03208;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class bjre
{
  public static final Set<String> a = new HashSet();
  
  public static void a(int paramInt)
  {
    a(String.valueOf(paramInt), null);
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (a(paramString))
    {
      i = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report", 0);
      if ((i == 0) || (i == 2)) {
        b(paramString, paramHashMap);
      }
      if ((i == 0) || (i == 1)) {
        LpReport_Retention_dc03208.report(paramString, paramHashMap);
      }
      if (QZLog.isColorLevel()) {
        QZLog.i("Retention.Report", 2, new Object[] { "RetentionReport, functionid:", paramString });
      }
    }
    while (!QZLog.isColorLevel())
    {
      int i;
      return;
    }
    QZLog.i("Retention.Report", 2, new Object[] { "not meet condition, functionid:", paramString });
  }
  
  public static boolean a(String paramString)
  {
    if (a.size() == 0)
    {
      Object localObject = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report_blacklist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if (!TextUtils.isEmpty(localCharSequence)) {}
            try
            {
              a.add(localCharSequence);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QZLog.e("Retention.Report", "meetConditon error", localException);
              }
            }
          }
        }
      }
    }
    return (a.size() <= 0) || (!a.contains(paramString));
  }
  
  public static void b(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {}
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("function_id", paramString);
      paramHashMap = new Properties();
      paramHashMap.putAll((Map)localObject);
      azqh.a(BaseApplicationImpl.getContext()).reportKVEvent("qzone_retention_" + paramString, paramHashMap);
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("Retention.Report", "统计率上报失败", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjre
 * JD-Core Version:    0.7.0.1
 */