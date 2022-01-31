import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class aoka
{
  private List<String> a = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static aoka a(aogf[] paramArrayOfaogf)
  {
    aoka localaoka = new aoka();
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = localaoka;
      try
      {
        if (i < paramArrayOfaogf.length)
        {
          localaoka.a.clear();
          localObject = paramArrayOfaogf[i].a;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONArray((String)localObject);
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localaoka.a.add(((JSONArray)localObject).getString(j));
              j += 1;
            }
          }
          i += 1;
        }
      }
      catch (Throwable paramArrayOfaogf)
      {
        QLog.d("MiniAppApiReportProcessor", 2, "parse, failed!", paramArrayOfaogf);
        localObject = null;
      }
    }
    return localObject;
  }
  
  public List<String> a()
  {
    return this.a;
  }
  
  public String toString()
  {
    new StringBuilder().append("getApiReportList:").append(TextUtils.join(",", a()));
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoka
 * JD-Core Version:    0.7.0.1
 */