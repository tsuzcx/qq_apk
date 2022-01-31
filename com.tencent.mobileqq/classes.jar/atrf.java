import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class atrf
{
  public final List<atrg> a = new ArrayList();
  
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
            atrg localatrg = new atrg();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localatrg.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localatrg.d = localJSONObject.optString("title");
            localatrg.e = localJSONObject.optString("iconNormal");
            localatrg.f = localJSONObject.optString("iconPress");
            localatrg.g = localJSONObject.optString("iconNightNormal");
            localatrg.h = localJSONObject.optString("iconNightPress");
            localatrg.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localatrg.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localatrg.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localatrg.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localatrg.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localatrg.a();
            localatrg.b();
            this.a.add(localatrg);
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
 * Qualified Name:     atrf
 * JD-Core Version:    0.7.0.1
 */