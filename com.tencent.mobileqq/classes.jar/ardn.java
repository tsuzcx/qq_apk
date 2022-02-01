import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ardn
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  
  public static ardn a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        ardn localardn = new ardn();
        paramString = new JSONObject(paramString);
        localardn.jdField_a_of_type_Int = paramString.optInt("pttWithTextSwitch", -1);
        localardn.jdField_a_of_type_Long = paramString.optLong("aioSttSpliceTimeout", 45000L);
        return localardn;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PttWithTextSwitchBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "open:" + this.jdField_a_of_type_Int + "  |  aioSttSpliceTimeout:" + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardn
 * JD-Core Version:    0.7.0.1
 */