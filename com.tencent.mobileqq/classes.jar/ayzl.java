import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ayzl
{
  public final List<ayzm> a = new ArrayList();
  
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
            ayzm localayzm = new ayzm();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localayzm.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localayzm.d = localJSONObject.optString("title");
            localayzm.e = localJSONObject.optString("iconNormal");
            localayzm.f = localJSONObject.optString("iconPress");
            localayzm.g = localJSONObject.optString("iconNightNormal");
            localayzm.h = localJSONObject.optString("iconNightPress");
            localayzm.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localayzm.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localayzm.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localayzm.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localayzm.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localayzm.a();
            localayzm.b();
            this.a.add(localayzm);
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
 * Qualified Name:     ayzl
 * JD-Core Version:    0.7.0.1
 */