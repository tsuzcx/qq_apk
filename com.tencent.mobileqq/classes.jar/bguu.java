import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bguu
{
  public static Map<String, String> a;
  private Context jdField_a_of_type_AndroidContentContext;
  private bgvh jdField_a_of_type_Bgvh = new bguv(this);
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bguu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("readerUrls");
        int i;
        if (paramJSONObject == null)
        {
          i = 0;
          if (i == 0)
          {
            bgwf.a("ReaderUrlConfigDataHelper", "jsonDataToTabItemData ,size=0");
            return false;
          }
        }
        else
        {
          i = paramJSONObject.length();
          continue;
        }
        jdField_a_of_type_JavaUtilMap.clear();
        int j = 0;
        if (j >= i) {
          break;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
        Iterator localIterator = localJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str)) {
            jdField_a_of_type_JavaUtilMap.put(str, localJSONObject.getString(str));
          }
        }
        else
        {
          j += 1;
        }
      }
      catch (Exception paramJSONObject)
      {
        bgwf.a("ReaderUrlConfigDataHelper", paramJSONObject.getMessage());
        return false;
      }
    }
    return true;
  }
  
  private void b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("CGI_RESPONSE", 0).getString("SP_URL_CONFIG_DATA" + str, "");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    try
    {
      a(new JSONObject(str));
      return;
    }
    catch (JSONException localJSONException)
    {
      bgwf.a("ReaderUrlConfigDataHelper", "getQQReaderUrlConfigDataFromDB," + localJSONException.getMessage());
    }
  }
  
  private void c()
  {
    bgwz.a(bgwz.c, this.jdField_a_of_type_Bgvh);
  }
  
  public void a()
  {
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguu
 * JD-Core Version:    0.7.0.1
 */