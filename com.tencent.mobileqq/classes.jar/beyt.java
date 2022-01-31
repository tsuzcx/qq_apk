import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class beyt
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public boolean j;
  public boolean k;
  
  public static beyt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return a(paramString);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadPublicParam", 2, "PreloadPublicParam parseJson Exception");
        }
        paramString = null;
      }
    }
  }
  
  public static beyt a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    beyt localbeyt = new beyt();
    try
    {
      if (paramJSONObject.has("pppid")) {
        localbeyt.jdField_a_of_type_Int = paramJSONObject.getInt("pppid");
      }
      if (paramJSONObject.has("timecontrol"))
      {
        localObject = paramJSONObject.getJSONObject("timecontrol");
        localbeyt.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localbeyt.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("dayofweek");
        localbeyt.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("hourofday");
      }
      if (paramJSONObject.has("reddot"))
      {
        localObject = paramJSONObject.getJSONObject("reddot");
        localbeyt.jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localbeyt.jdField_c_of_type_Boolean = ((JSONObject)localObject).optBoolean("apponly");
        localbeyt.jdField_d_of_type_Boolean = ((JSONObject)localObject).getBoolean("app");
        localbeyt.jdField_e_of_type_Boolean = ((JSONObject)localObject).getBoolean("leba");
      }
      if (paramJSONObject.has("lebalist")) {
        localbeyt.jdField_h_of_type_Boolean = paramJSONObject.getJSONObject("lebalist").getBoolean("switch");
      }
      if (paramJSONObject.has("activetime"))
      {
        localObject = paramJSONObject.getJSONObject("activetime");
        localbeyt.jdField_i_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localbeyt.jdField_e_of_type_Int = ((JSONObject)localObject).getInt("hour");
      }
      if (paramJSONObject.has("usedtimes"))
      {
        localObject = paramJSONObject.getJSONObject("usedtimes");
        localbeyt.j = ((JSONObject)localObject).getBoolean("switch");
        localbeyt.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("times");
      }
      if (paramJSONObject.has("userlearn"))
      {
        localObject = paramJSONObject.getJSONObject("userlearn");
        localbeyt.k = ((JSONObject)localObject).getBoolean("switch");
        localbeyt.jdField_g_of_type_Int = ((JSONObject)localObject).getInt("timearea");
        localbeyt.jdField_h_of_type_Int = ((JSONObject)localObject).getInt("methodid");
        localbeyt.jdField_i_of_type_Int = ((JSONObject)localObject).getInt("clusternum");
      }
      localObject = localbeyt;
      if (paramJSONObject.has("cdperiod"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("cdperiod");
        localbeyt.jdField_f_of_type_Boolean = paramJSONObject.optBoolean("switch");
        localbeyt.jdField_d_of_type_Int = paramJSONObject.optInt("time");
        localbeyt.jdField_g_of_type_Boolean = paramJSONObject.optBoolean("reverse");
        localObject = localbeyt;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadPublicParam", 2, "PreloadPublicParam parseJson Exception");
        }
        Object localObject = null;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyt
 * JD-Core Version:    0.7.0.1
 */