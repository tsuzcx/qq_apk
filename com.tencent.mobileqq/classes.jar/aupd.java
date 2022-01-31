import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aupd
{
  public final List<aupe> a = new ArrayList();
  
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
            aupe localaupe = new aupe();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localaupe.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localaupe.d = localJSONObject.optString("title");
            localaupe.e = localJSONObject.optString("iconNormal");
            localaupe.f = localJSONObject.optString("iconPress");
            localaupe.g = localJSONObject.optString("iconNightNormal");
            localaupe.h = localJSONObject.optString("iconNightPress");
            localaupe.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localaupe.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localaupe.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localaupe.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localaupe.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localaupe.a();
            localaupe.b();
            this.a.add(localaupe);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */