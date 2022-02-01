import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class armd
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public armd()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static armd a(aqxa paramaqxa)
  {
    armd localarmd = new armd();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
      localarmd.a(paramaqxa.optInt("business_switch_message", 1));
      localarmd.b(paramaqxa.optInt("business_switch_contact", 1));
      localarmd.c(paramaqxa.optInt("business_switch_dongtai", 1));
      return localarmd;
    }
    catch (Exception paramaqxa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaqxa.toString());
    }
    return localarmd;
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
 * Qualified Name:     armd
 * JD-Core Version:    0.7.0.1
 */