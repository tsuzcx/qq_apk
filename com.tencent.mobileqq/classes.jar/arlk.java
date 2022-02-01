import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arlk
  implements arae<String>
{
  public String a;
  public HashMap<String, arll> a;
  
  public arlk()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("*", new arll(this));
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    int i;
    Object localObject2;
    arll localarll;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.length() == 0) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      paramString = localJSONObject.names();
      i = 0;
      if (i >= paramString.length()) {
        break label212;
      }
      localObject1 = paramString.getString(i).trim().toLowerCase();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label213;
      }
      localObject2 = localJSONObject.optJSONObject((String)localObject1);
      localarll = new arll(this);
      localarll.c = ((JSONObject)localObject2).getInt("CellNetAutoDownloadSize");
      localarll.b = ((JSONObject)localObject2).getInt("CellNetWarningSize");
      localarll.a = ((JSONObject)localObject2).getInt("WiFiNetAutoDownloadSize");
      if (!((String)localObject1).contains(",")) {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localarll);
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("", 1, QLog.getStackTraceString(paramString));
      return;
    }
    Object localObject1 = ((String)localObject1).split(",");
    int j = 0;
    for (;;)
    {
      if (j < localObject1.length)
      {
        localObject2 = localObject1[j].trim().toLowerCase();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localarll);
        }
      }
      else
      {
        label212:
        label213:
        i += 1;
        break;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlk
 * JD-Core Version:    0.7.0.1
 */