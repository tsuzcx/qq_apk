import android.os.Bundle;
import com.tencent.mobileqq.utils.StringUtil;
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

public class aymr
{
  public static aymr a;
  private Callback a;
  
  static
  {
    jdField_a_of_type_Aymr = new aymr();
  }
  
  private aymr()
  {
    this.jdField_a_of_type_Okhttp3Callback = new ayms(this);
  }
  
  private String a(Bundle paramBundle)
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    String str1 = "";
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
    aymq.a().newCall(paramBundle).enqueue(this.jdField_a_of_type_Okhttp3Callback);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.d("TurtleReportCenter", 4, "send(): no data to report");
      return;
    }
    b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymr
 * JD-Core Version:    0.7.0.1
 */