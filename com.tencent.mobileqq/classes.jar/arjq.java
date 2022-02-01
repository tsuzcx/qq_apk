import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arjq
{
  public int a;
  public boolean a;
  public int b = 15;
  
  public arjq()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public static arjq a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        arjq localarjq = new arjq();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localarjq.jdField_a_of_type_Boolean = bool;
          localarjq.jdField_a_of_type_Int = paramString.optInt("sameMsgCount", 5);
          localarjq.b = paramString.optInt("loadMoreCount", 15);
          if (localarjq.jdField_a_of_type_Int < 2) {
            localarjq.jdField_a_of_type_Boolean = false;
          }
          if (localarjq.b < 15) {
            localarjq.b = 15;
          }
          if (localarjq.b > 40) {
            localarjq.b = 40;
          }
          QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localarjq.toString());
          return localarjq;
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
 * Qualified Name:     arjq
 * JD-Core Version:    0.7.0.1
 */