import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class blqc
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
  
  public static blqc a(String paramString)
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
  
  public static blqc a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    blqc localblqc = new blqc();
    try
    {
      if (paramJSONObject.has("pppid")) {
        localblqc.jdField_a_of_type_Int = paramJSONObject.getInt("pppid");
      }
      if (paramJSONObject.has("timecontrol"))
      {
        localObject = paramJSONObject.getJSONObject("timecontrol");
        localblqc.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localblqc.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("dayofweek");
        localblqc.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("hourofday");
      }
      if (paramJSONObject.has("reddot"))
      {
        localObject = paramJSONObject.getJSONObject("reddot");
        localblqc.jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localblqc.jdField_c_of_type_Boolean = ((JSONObject)localObject).optBoolean("apponly");
        localblqc.jdField_d_of_type_Boolean = ((JSONObject)localObject).getBoolean("app");
        localblqc.jdField_e_of_type_Boolean = ((JSONObject)localObject).getBoolean("leba");
      }
      if (paramJSONObject.has("lebalist")) {
        localblqc.jdField_h_of_type_Boolean = paramJSONObject.getJSONObject("lebalist").getBoolean("switch");
      }
      if (paramJSONObject.has("activetime"))
      {
        localObject = paramJSONObject.getJSONObject("activetime");
        localblqc.jdField_i_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localblqc.jdField_e_of_type_Int = ((JSONObject)localObject).getInt("hour");
      }
      if (paramJSONObject.has("usedtimes"))
      {
        localObject = paramJSONObject.getJSONObject("usedtimes");
        localblqc.j = ((JSONObject)localObject).getBoolean("switch");
        localblqc.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("times");
      }
      if (paramJSONObject.has("userlearn"))
      {
        localObject = paramJSONObject.getJSONObject("userlearn");
        localblqc.k = ((JSONObject)localObject).getBoolean("switch");
        localblqc.jdField_g_of_type_Int = ((JSONObject)localObject).getInt("timearea");
        localblqc.jdField_h_of_type_Int = ((JSONObject)localObject).getInt("methodid");
        localblqc.jdField_i_of_type_Int = ((JSONObject)localObject).getInt("clusternum");
      }
      localObject = localblqc;
      if (paramJSONObject.has("cdperiod"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("cdperiod");
        localblqc.jdField_f_of_type_Boolean = paramJSONObject.optBoolean("switch");
        localblqc.jdField_d_of_type_Int = paramJSONObject.optInt("time");
        localblqc.jdField_g_of_type_Boolean = paramJSONObject.optBoolean("reverse");
        localObject = localblqc;
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
 * Qualified Name:     blqc
 * JD-Core Version:    0.7.0.1
 */