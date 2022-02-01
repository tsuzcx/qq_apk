import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class argl
{
  public arhh a;
  public boolean a;
  
  public argl()
  {
    this.jdField_a_of_type_Arhh = new arhh();
  }
  
  public static argl a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        argl localargl = new argl();
        paramString = new JSONObject(paramString);
        localargl.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          arhh localarhh = new arhh();
          localarhh.a(paramString.optInt("version"));
          localarhh.b(paramString.optInt("jumpType"));
          localarhh.a(paramString.optString("jumpUrl"));
          localarhh.b(paramString.optString("jumpExtensionInfo"));
          localargl.jdField_a_of_type_Arhh = localarhh;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localargl.toString());
        return localargl;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Arhh == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Arhh.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argl
 * JD-Core Version:    0.7.0.1
 */