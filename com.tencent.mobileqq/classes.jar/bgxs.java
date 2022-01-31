import NS_COMM.COMM.Entry;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bgxs
{
  private static List<COMM.Entry> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    do
    {
      for (;;)
      {
        try
        {
          paramString2 = new JSONObject(new JSONObject(paramString2).optString("actionData"));
          String str1 = paramString2.optString("business");
          if ("mmbizwxamonitor".equals(str1))
          {
            localArrayList.add(bgxz.a(paramString2.optString("name"), String.valueOf(paramString2.optInt("value"))));
            Iterator localIterator = paramString2.keys();
            if (!localIterator.hasNext()) {
              break;
            }
            String str2 = (String)localIterator.next();
            if ((("mmbizwxamonitor".equals(str1)) && (("name".equals(str2)) || ("value".equals(str2)))) || (("mmbizwxaanalytics".equals(str1)) && (("eventID".equals(str2)) || ("data".equals(str2))))) {
              continue;
            }
            localArrayList.add(bgxz.a(str2, paramString2.optString(str2)));
            continue;
          }
          if (!"mmbizwxaanalytics".equals(str1)) {
            continue;
          }
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          return localArrayList;
        }
        localArrayList.add(bgxz.a(paramString2.optString("eventID"), paramString2.optString("data")));
      }
      localArrayList.add(bgxz.a("appid", paramString1));
    } while (QUAUtil.isQQApp());
    localArrayList.addAll(bgxz.a());
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.contains("mmbizwxajsapi")) || (paramString2.contains("mmbizwxaservicequality")))
    {
      QMLog.w("MiniProgramLpReportDC04", "handleReportRealTimeAction not handle data " + paramString2);
      return;
    }
    paramString1 = bgxz.a(4, String.valueOf(3), a(paramString1, paramString2), null);
    bgya.a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxs
 * JD-Core Version:    0.7.0.1
 */