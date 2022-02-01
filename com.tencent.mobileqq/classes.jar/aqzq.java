import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzq
  implements aqlb<String>
{
  public String a;
  public ArrayList<aqzr> a;
  private String b = "place_holder";
  private String c = "data";
  private String d = "topic_id";
  private String e = "topic_name";
  
  public aqzq()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SigTopicConfig", 1, "SigTopic config content is empty");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONArray(this.c);
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString(this.b, anni.a(2131712920));
        if (paramString == null) {
          break;
        }
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        localJSONObject = paramString.getJSONObject(i);
        localaqzr = new aqzr();
        localaqzr.jdField_a_of_type_Int = localJSONObject.optInt(this.d);
        localaqzr.jdField_a_of_type_JavaLangString = localJSONObject.optString(this.e);
        if (!TextUtils.isEmpty(localaqzr.jdField_a_of_type_JavaLangString)) {
          break label193;
        }
        if (!QLog.isColorLevel()) {
          break label198;
        }
        QLog.e("SigTopicConfig", 2, new Object[] { "SigTopic config parse has invalid item,index=", Integer.valueOf(i) });
      }
      catch (JSONException paramString)
      {
        int i;
        aqzr localaqzr;
        QLog.e("SigTopicConfig", 1, "SigTopic config parse exception", paramString);
        return;
      }
      if (j != 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localaqzr);
      }
      i += 1;
      continue;
      label193:
      int j = 1;
      continue;
      label198:
      j = 0;
    }
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return "recommend title is " + this.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_JavaUtilArrayList.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzq
 * JD-Core Version:    0.7.0.1
 */