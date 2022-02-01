import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class arfa
{
  private List<String> a = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static arfa a(araj[] paramArrayOfaraj)
  {
    arfa localarfa = new arfa();
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = localarfa;
      try
      {
        if (i < paramArrayOfaraj.length)
        {
          localarfa.a.clear();
          localObject = paramArrayOfaraj[i].a;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONArray((String)localObject);
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localarfa.a.add(((JSONArray)localObject).getString(j));
              j += 1;
            }
          }
          i += 1;
        }
      }
      catch (Throwable paramArrayOfaraj)
      {
        QLog.d("MiniAppApiReportProcessor", 2, "parse, failed!", paramArrayOfaraj);
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
 * Qualified Name:     arfa
 * JD-Core Version:    0.7.0.1
 */