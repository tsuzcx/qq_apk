import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class aooj
{
  private List<String> a = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static aooj a(aoko[] paramArrayOfaoko)
  {
    aooj localaooj = new aooj();
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = localaooj;
      try
      {
        if (i < paramArrayOfaoko.length)
        {
          localaooj.a.clear();
          localObject = paramArrayOfaoko[i].a;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONArray((String)localObject);
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localaooj.a.add(((JSONArray)localObject).getString(j));
              j += 1;
            }
          }
          i += 1;
        }
      }
      catch (Throwable paramArrayOfaoko)
      {
        QLog.d("MiniAppApiReportProcessor", 2, "parse, failed!", paramArrayOfaoko);
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
 * Qualified Name:     aooj
 * JD-Core Version:    0.7.0.1
 */