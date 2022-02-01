import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqde
{
  public aqea a;
  public boolean a;
  
  public aqde()
  {
    this.jdField_a_of_type_Aqea = new aqea();
  }
  
  public static aqde a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqde localaqde = new aqde();
        paramString = new JSONObject(paramString);
        localaqde.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          aqea localaqea = new aqea();
          localaqea.a(paramString.optInt("version"));
          localaqea.b(paramString.optInt("jumpType"));
          localaqea.a(paramString.optString("jumpUrl"));
          localaqea.b(paramString.optString("jumpExtensionInfo"));
          localaqde.jdField_a_of_type_Aqea = localaqea;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localaqde.toString());
        return localaqde;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Aqea == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Aqea.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqde
 * JD-Core Version:    0.7.0.1
 */