import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aque
{
  public int a;
  public boolean a;
  public int b = 15;
  
  public aque()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public static aque a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        aque localaque = new aque();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localaque.jdField_a_of_type_Boolean = bool;
          localaque.jdField_a_of_type_Int = paramString.optInt("sameMsgCount", 5);
          localaque.b = paramString.optInt("loadMoreCount", 15);
          if (localaque.jdField_a_of_type_Int < 2) {
            localaque.jdField_a_of_type_Boolean = false;
          }
          if (localaque.b < 15) {
            localaque.b = 15;
          }
          if (localaque.b > 40) {
            localaque.b = 40;
          }
          QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaque.toString());
          return localaque;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("openSwitch = ").append(this.jdField_a_of_type_Boolean).append(",sameMsgCount = ").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aque
 * JD-Core Version:    0.7.0.1
 */