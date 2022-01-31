import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aono
{
  public aooh a;
  public boolean a;
  
  public aono()
  {
    this.jdField_a_of_type_Aooh = new aooh();
  }
  
  public static aono a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aono localaono = new aono();
        paramString = new JSONObject(paramString);
        localaono.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          aooh localaooh = new aooh();
          localaooh.a(paramString.optInt("version"));
          localaooh.b(paramString.optInt("jumpType"));
          localaooh.a(paramString.optString("jumpUrl"));
          localaooh.b(paramString.optString("jumpExtensionInfo"));
          localaono.jdField_a_of_type_Aooh = localaooh;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localaono.toString());
        return localaono;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Aooh == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Aooh.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aono
 * JD-Core Version:    0.7.0.1
 */