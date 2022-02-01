import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqzd
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public aqzd()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aqzd a(aqlg paramaqlg)
  {
    aqzd localaqzd = new aqzd();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
      localaqzd.a(paramaqlg.optInt("business_switch_message", 1));
      localaqzd.b(paramaqlg.optInt("business_switch_contact", 1));
      localaqzd.c(paramaqlg.optInt("business_switch_dongtai", 1));
      return localaqzd;
    }
    catch (Exception paramaqlg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaqlg.toString());
    }
    return localaqzd;
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
 * Qualified Name:     aqzd
 * JD-Core Version:    0.7.0.1
 */