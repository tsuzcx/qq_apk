import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aowq
  implements aokj<String>
{
  public String a;
  public ArrayList<aowr> a;
  private String b = "place_holder";
  private String c = "data";
  private String d = "topic_id";
  private String e = "topic_name";
  
  public aowq()
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
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString(this.b, alud.a(2131714550));
        if (paramString == null) {
          break;
        }
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        localJSONObject = paramString.getJSONObject(i);
        localaowr = new aowr();
        localaowr.jdField_a_of_type_Int = localJSONObject.optInt(this.d);
        localaowr.jdField_a_of_type_JavaLangString = localJSONObject.optString(this.e);
        if (!TextUtils.isEmpty(localaowr.jdField_a_of_type_JavaLangString)) {
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
        aowr localaowr;
        QLog.e("SigTopicConfig", 1, "SigTopic config parse exception", paramString);
        return;
      }
      if (j != 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localaowr);
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
 * Qualified Name:     aowq
 * JD-Core Version:    0.7.0.1
 */