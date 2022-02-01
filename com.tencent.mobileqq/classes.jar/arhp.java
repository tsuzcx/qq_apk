import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class arhp
{
  private arhq a;
  public arhs a;
  public Map<String, String> a;
  
  public arhp()
  {
    this.jdField_a_of_type_Arhs = new arhs(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Arhq = new arhq();
  }
  
  public static arhp a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfBean", 2, "parse");
    }
    for (;;)
    {
      arhp localarhp;
      int i;
      Object localObject;
      int j;
      try
      {
        localarhp = new arhp();
        int k = paramArrayOfaraj.length;
        i = 0;
        if (i >= k) {
          break label488;
        }
        localObject = paramArrayOfaraj[i];
        if (TextUtils.isEmpty(((araj)localObject).jdField_a_of_type_JavaLangString)) {
          break label529;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQComicConfBean", 2, new Object[] { "parse, content=", ((araj)localObject).jdField_a_of_type_JavaLangString });
        }
        localObject = new JSONObject(((araj)localObject).jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("webbundle"))
        {
          localObject = ((JSONObject)localObject).optJSONObject("webbundle");
          if (localObject == null) {
            break label529;
          }
          localObject = ((JSONObject)localObject).optJSONObject("qqcomic");
          if (localObject == null) {
            break label529;
          }
          localarhp.jdField_a_of_type_Arhs.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("enable", false);
          localarhp.jdField_a_of_type_Arhs.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("preload_url", "");
          break label529;
        }
        if (((JSONObject)localObject).has("urlConfig"))
        {
          JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("urlConfig");
          if (QLog.isColorLevel()) {
            QLog.d("QQComicConfBean", 2, new Object[] { "parse, urlConfig=", localJSONArray });
          }
          int m = localJSONArray.length();
          j = 0;
          if (j >= m) {
            break label529;
          }
          JSONObject localJSONObject = localJSONArray.getJSONObject(j);
          String str2 = localJSONObject.optString("bizName");
          if (TextUtils.isEmpty(str2)) {
            break label536;
          }
          if (annu.a("8.4.5", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion")))
          {
            String str1 = localJSONObject.optString("androidUrl");
            localObject = str1;
            if (TextUtils.isEmpty(str1)) {
              localObject = localJSONObject.optString("url");
            }
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localarhp.jdField_a_of_type_JavaUtilMap.put(str2, localObject);
              QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", str2, ", url=", localObject });
            }
          }
          else
          {
            QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", str2, ", version not match" });
          }
        }
      }
      catch (Exception paramArrayOfaraj)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQComicConfBean", 1, new Object[] { "parse e:", paramArrayOfaraj.toString() });
        }
        return null;
      }
      if (((JSONObject)localObject).has("serviceAccount"))
      {
        localObject = ((JSONObject)localObject).optJSONObject("serviceAccount");
        if (localObject != null)
        {
          arhq.a(localarhp.jdField_a_of_type_Arhq, ((JSONObject)localObject).optString("uin"));
          arhq.b(localarhp.jdField_a_of_type_Arhq, ((JSONObject)localObject).optString("url"));
          break label529;
          label488:
          bmbh.a((String)localarhp.jdField_a_of_type_JavaUtilMap.get("danmuAnswerUrl"));
          QLog.d("QQComicConfBean", 1, new Object[] { "parse, confBean=", localarhp });
          return localarhp;
        }
      }
      label529:
      i += 1;
      continue;
      label536:
      j += 1;
    }
  }
  
  public static arhq a()
  {
    return ((arhp)aran.a().a(534)).jdField_a_of_type_Arhq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:").append(this.jdField_a_of_type_Arhs);
    localStringBuilder.append(" ,urlConfigMap:").append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuilder.append(" ,serviceAccountConfig:").append(this.jdField_a_of_type_Arhq);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhp
 * JD-Core Version:    0.7.0.1
 */