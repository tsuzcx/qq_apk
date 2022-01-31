import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anag
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public anag()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static anag a(ampi paramampi)
  {
    anag localanag = new anag();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString);
      localanag.a(paramampi.optInt("business_switch_message", 1));
      localanag.b(paramampi.optInt("business_switch_contact", 1));
      localanag.c(paramampi.optInt("business_switch_dongtai", 1));
      return localanag;
    }
    catch (Exception paramampi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramampi.toString());
    }
    return localanag;
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
 * Qualified Name:     anag
 * JD-Core Version:    0.7.0.1
 */