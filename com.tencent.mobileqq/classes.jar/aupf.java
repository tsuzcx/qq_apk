import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aupf
{
  public final List<aupg> a = new ArrayList();
  
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
            aupg localaupg = new aupg();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localaupg.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localaupg.d = localJSONObject.optString("title");
            localaupg.e = localJSONObject.optString("iconNormal");
            localaupg.f = localJSONObject.optString("iconPress");
            localaupg.g = localJSONObject.optString("iconNightNormal");
            localaupg.h = localJSONObject.optString("iconNightPress");
            localaupg.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localaupg.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localaupg.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localaupg.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localaupg.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localaupg.a();
            localaupg.b();
            this.a.add(localaupg);
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
 * Qualified Name:     aupf
 * JD-Core Version:    0.7.0.1
 */