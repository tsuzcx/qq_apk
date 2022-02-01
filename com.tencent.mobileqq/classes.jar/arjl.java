import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arjl
{
  public arkh a;
  public boolean a;
  
  public arjl()
  {
    this.jdField_a_of_type_Arkh = new arkh();
  }
  
  public static arjl a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        arjl localarjl = new arjl();
        paramString = new JSONObject(paramString);
        localarjl.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          arkh localarkh = new arkh();
          localarkh.a(paramString.optInt("version"));
          localarkh.b(paramString.optInt("jumpType"));
          localarkh.a(paramString.optString("jumpUrl"));
          localarkh.b(paramString.optString("jumpExtensionInfo"));
          localarjl.jdField_a_of_type_Arkh = localarkh;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localarjl.toString());
        return localarjl;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Arkh == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Arkh.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjl
 * JD-Core Version:    0.7.0.1
 */