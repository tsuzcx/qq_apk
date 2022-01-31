import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amge
{
  public amgx a;
  public boolean a;
  
  public amge()
  {
    this.jdField_a_of_type_Amgx = new amgx();
  }
  
  public static amge a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amge localamge = new amge();
        paramString = new JSONObject(paramString);
        localamge.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          amgx localamgx = new amgx();
          localamgx.a(paramString.optInt("version"));
          localamgx.b(paramString.optInt("jumpType"));
          localamgx.a(paramString.optString("jumpUrl"));
          localamgx.b(paramString.optString("jumpExtensionInfo"));
          localamge.jdField_a_of_type_Amgx = localamgx;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localamge.toString());
        return localamge;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Amgx == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Amgx.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amge
 * JD-Core Version:    0.7.0.1
 */