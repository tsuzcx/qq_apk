import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amwi
{
  public amxb a;
  public boolean a;
  
  public amwi()
  {
    this.jdField_a_of_type_Amxb = new amxb();
  }
  
  public static amwi a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amwi localamwi = new amwi();
        paramString = new JSONObject(paramString);
        localamwi.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          amxb localamxb = new amxb();
          localamxb.a(paramString.optInt("version"));
          localamxb.b(paramString.optInt("jumpType"));
          localamxb.a(paramString.optString("jumpUrl"));
          localamxb.b(paramString.optString("jumpExtensionInfo"));
          localamwi.jdField_a_of_type_Amxb = localamxb;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localamwi.toString());
        return localamwi;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Amxb == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Amxb.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwi
 * JD-Core Version:    0.7.0.1
 */