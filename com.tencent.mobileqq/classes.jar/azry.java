import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class azry
{
  public final List<azrz> a = new ArrayList();
  
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
            azrz localazrz = new azrz();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localazrz.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localazrz.d = localJSONObject.optString("title");
            localazrz.e = localJSONObject.optString("iconNormal");
            localazrz.f = localJSONObject.optString("iconPress");
            localazrz.g = localJSONObject.optString("iconNightNormal");
            localazrz.h = localJSONObject.optString("iconNightPress");
            localazrz.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localazrz.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localazrz.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localazrz.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localazrz.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localazrz.a();
            localazrz.b();
            this.a.add(localazrz);
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
 * Qualified Name:     azry
 * JD-Core Version:    0.7.0.1
 */