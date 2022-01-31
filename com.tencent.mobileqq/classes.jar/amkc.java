import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amkc
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public amkc()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static amkc a(alzs paramalzs)
  {
    amkc localamkc = new amkc();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
      localamkc.a(paramalzs.optInt("business_switch_message", 1));
      localamkc.b(paramalzs.optInt("business_switch_contact", 1));
      localamkc.c(paramalzs.optInt("business_switch_dongtai", 1));
      return localamkc;
    }
    catch (Exception paramalzs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramalzs.toString());
    }
    return localamkc;
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
 * Qualified Name:     amkc
 * JD-Core Version:    0.7.0.1
 */