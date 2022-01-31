import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aowd
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public aowd()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aowd a(aoko paramaoko)
  {
    aowd localaowd = new aowd();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString);
      localaowd.a(paramaoko.optInt("business_switch_message", 1));
      localaowd.b(paramaoko.optInt("business_switch_contact", 1));
      localaowd.c(paramaoko.optInt("business_switch_dongtai", 1));
      return localaowd;
    }
    catch (Exception paramaoko)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaoko.toString());
    }
    return localaowd;
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
 * Qualified Name:     aowd
 * JD-Core Version:    0.7.0.1
 */