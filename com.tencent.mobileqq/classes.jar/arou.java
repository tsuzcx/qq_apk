import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arou
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public arou()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static arou a(araj paramaraj)
  {
    arou localarou = new arou();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
      localarou.a(paramaraj.optInt("business_switch_message", 1));
      localarou.b(paramaraj.optInt("business_switch_contact", 1));
      localarou.c(paramaraj.optInt("business_switch_dongtai", 1));
      return localarou;
    }
    catch (Exception paramaraj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaraj.toString());
    }
    return localarou;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean c()
  {
    return this.c == 1;
  }
  
  public String toString()
  {
    return String.format("mBusinessSwitchTabMessage:%d, mBusinessSwitchTabContact:%d, mBusinessSwitchTabDongtai:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arou
 * JD-Core Version:    0.7.0.1
 */