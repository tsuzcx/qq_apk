import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aorx
{
  public aosq a;
  public boolean a;
  
  public aorx()
  {
    this.jdField_a_of_type_Aosq = new aosq();
  }
  
  public static aorx a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aorx localaorx = new aorx();
        paramString = new JSONObject(paramString);
        localaorx.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          aosq localaosq = new aosq();
          localaosq.a(paramString.optInt("version"));
          localaosq.b(paramString.optInt("jumpType"));
          localaosq.a(paramString.optString("jumpUrl"));
          localaosq.b(paramString.optString("jumpExtensionInfo"));
          localaorx.jdField_a_of_type_Aosq = localaosq;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localaorx.toString());
        return localaorx;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_Aosq == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_Aosq.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorx
 * JD-Core Version:    0.7.0.1
 */