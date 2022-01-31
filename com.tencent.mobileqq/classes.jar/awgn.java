import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class awgn
{
  public final List<awgo> a = new ArrayList();
  
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
            awgo localawgo = new awgo();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localawgo.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localawgo.d = localJSONObject.optString("title");
            localawgo.e = localJSONObject.optString("iconNormal");
            localawgo.f = localJSONObject.optString("iconPress");
            localawgo.g = localJSONObject.optString("iconNightNormal");
            localawgo.h = localJSONObject.optString("iconNightPress");
            localawgo.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localawgo.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localawgo.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localawgo.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localawgo.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localawgo.a();
            localawgo.b();
            this.a.add(localawgo);
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
 * Qualified Name:     awgn
 * JD-Core Version:    0.7.0.1
 */