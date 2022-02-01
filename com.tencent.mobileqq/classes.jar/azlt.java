import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class azlt
{
  public final List<azlu> a = new ArrayList();
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("c2c");
        if (paramString.length() > 0)
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            azlu localazlu = new azlu();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localazlu.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localazlu.d = localJSONObject.optString("title");
            localazlu.e = localJSONObject.optString("iconNormal");
            localazlu.f = localJSONObject.optString("iconPress");
            localazlu.g = localJSONObject.optString("iconNightNormal");
            localazlu.h = localJSONObject.optString("iconNightPress");
            localazlu.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localazlu.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localazlu.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localazlu.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localazlu.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localazlu.a();
            localazlu.b();
            this.a.add(localazlu);
            i += 1;
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("AIOPanelIconConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlt
 * JD-Core Version:    0.7.0.1
 */