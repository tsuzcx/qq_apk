import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class argq
{
  public int a;
  public boolean a;
  public int b = 15;
  
  public argq()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public static argq a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        argq localargq = new argq();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localargq.jdField_a_of_type_Boolean = bool;
          localargq.jdField_a_of_type_Int = paramString.optInt("sameMsgCount", 5);
          localargq.b = paramString.optInt("loadMoreCount", 15);
          if (localargq.jdField_a_of_type_Int < 2) {
            localargq.jdField_a_of_type_Boolean = false;
          }
          if (localargq.b < 15) {
            localargq.b = 15;
          }
          if (localargq.b > 40) {
            localargq.b = 40;
          }
          QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localargq.toString());
          return localargq;
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
 * Qualified Name:     argq
 * JD-Core Version:    0.7.0.1
 */