import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqtz
{
  public aquv a;
  public boolean a;
  
  public aqtz()
  {
    this.jdField_a_of_type_Aquv = new aquv();
  }
  
  public static aqtz a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqtz localaqtz = new aqtz();
        paramString = new JSONObject(paramString);
        localaqtz.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          aquv localaquv = new aquv();
          localaquv.a(paramString.optInt("version"));
          localaquv.b(paramString.optInt("jumpType"));
          localaquv.a(paramString.optString("jumpUrl"));
          localaquv.b(paramString.optString("jumpExtensionInfo"));
          localaqtz.jdField_a_of_type_Aquv = localaquv;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localaqtz.toString());
        return localaqtz;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Aquv == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Aquv.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtz
 * JD-Core Version:    0.7.0.1
 */