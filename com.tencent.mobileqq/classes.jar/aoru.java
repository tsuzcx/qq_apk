import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoru
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public aoru()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aoru a(aogf paramaogf)
  {
    aoru localaoru = new aoru();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString);
      localaoru.a(paramaogf.optInt("business_switch_message", 1));
      localaoru.b(paramaogf.optInt("business_switch_contact", 1));
      localaoru.c(paramaogf.optInt("business_switch_dongtai", 1));
      return localaoru;
    }
    catch (Exception paramaogf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaogf.toString());
    }
    return localaoru;
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
 * Qualified Name:     aoru
 * JD-Core Version:    0.7.0.1
 */