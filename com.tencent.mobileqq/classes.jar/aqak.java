import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqak
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  
  public static aqak a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqak localaqak = new aqak();
        paramString = new JSONObject(paramString);
        localaqak.jdField_a_of_type_Int = paramString.optInt("pttWithTextSwitch", -1);
        localaqak.jdField_a_of_type_Long = paramString.optLong("aioSttSpliceTimeout", 45000L);
        return localaqak;
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
 * Qualified Name:     aqak
 * JD-Core Version:    0.7.0.1
 */