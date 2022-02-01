import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ayfg
{
  public final List<ayfh> a = new ArrayList();
  
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
            ayfh localayfh = new ayfh();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localayfh.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localayfh.d = localJSONObject.optString("title");
            localayfh.e = localJSONObject.optString("iconNormal");
            localayfh.f = localJSONObject.optString("iconPress");
            localayfh.g = localJSONObject.optString("iconNightNormal");
            localayfh.h = localJSONObject.optString("iconNightPress");
            localayfh.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localayfh.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localayfh.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localayfh.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localayfh.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localayfh.a();
            localayfh.b();
            this.a.add(localayfh);
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
 * Qualified Name:     ayfg
 * JD-Core Version:    0.7.0.1
 */