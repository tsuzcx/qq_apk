import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class awkw
{
  public final List<awkx> a = new ArrayList();
  
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
            awkx localawkx = new awkx();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localawkx.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localawkx.d = localJSONObject.optString("title");
            localawkx.e = localJSONObject.optString("iconNormal");
            localawkx.f = localJSONObject.optString("iconPress");
            localawkx.g = localJSONObject.optString("iconNightNormal");
            localawkx.h = localJSONObject.optString("iconNightPress");
            localawkx.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localawkx.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localawkx.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localawkx.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localawkx.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localawkx.a();
            localawkx.b();
            this.a.add(localawkx);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awkw
 * JD-Core Version:    0.7.0.1
 */