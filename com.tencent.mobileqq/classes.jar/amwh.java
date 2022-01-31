import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amwh
{
  public amxa a;
  public boolean a;
  
  public amwh()
  {
    this.jdField_a_of_type_Amxa = new amxa();
  }
  
  public static amwh a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amwh localamwh = new amwh();
        paramString = new JSONObject(paramString);
        localamwh.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          amxa localamxa = new amxa();
          localamxa.a(paramString.optInt("version"));
          localamxa.b(paramString.optInt("jumpType"));
          localamxa.a(paramString.optString("jumpUrl"));
          localamxa.b(paramString.optString("jumpExtensionInfo"));
          localamwh.jdField_a_of_type_Amxa = localamxa;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localamwh.toString());
        return localamwh;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Amxa == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Amxa.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwh
 * JD-Core Version:    0.7.0.1
 */