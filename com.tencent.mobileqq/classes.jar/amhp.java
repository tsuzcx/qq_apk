import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amhp
  implements alzn<String>
{
  public String a;
  public HashMap<String, amhq> a;
  
  public amhp()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("*", new amhq(this));
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    int i;
    Object localObject2;
    amhq localamhq;
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
      localamhq = new amhq(this);
      localamhq.c = ((JSONObject)localObject2).getInt("CellNetAutoDownloadSize");
      localamhq.b = ((JSONObject)localObject2).getInt("CellNetWarningSize");
      localamhq.a = ((JSONObject)localObject2).getInt("WiFiNetAutoDownloadSize");
      if (!((String)localObject1).contains(",")) {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localamhq);
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
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localamhq);
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
 * Qualified Name:     amhp
 * JD-Core Version:    0.7.0.1
 */