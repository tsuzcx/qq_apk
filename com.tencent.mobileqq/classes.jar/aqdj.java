import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqdj
{
  public int a;
  public boolean a;
  public int b = 15;
  
  public aqdj()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public static aqdj a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        aqdj localaqdj = new aqdj();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localaqdj.jdField_a_of_type_Boolean = bool;
          localaqdj.jdField_a_of_type_Int = paramString.optInt("sameMsgCount", 5);
          localaqdj.b = paramString.optInt("loadMoreCount", 15);
          if (localaqdj.jdField_a_of_type_Int < 2) {
            localaqdj.jdField_a_of_type_Boolean = false;
          }
          if (localaqdj.b < 15) {
            localaqdj.b = 15;
          }
          if (localaqdj.b > 40) {
            localaqdj.b = 40;
          }
          QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaqdj.toString());
          return localaqdj;
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
 * Qualified Name:     aqdj
 * JD-Core Version:    0.7.0.1
 */