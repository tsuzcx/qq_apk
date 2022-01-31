import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anan
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public anan()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static anan a(amph paramamph)
  {
    anan localanan = new anan();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString);
      localanan.a(paramamph.optInt("business_switch_message", 1));
      localanan.b(paramamph.optInt("business_switch_contact", 1));
      localanan.c(paramamph.optInt("business_switch_dongtai", 1));
      return localanan;
    }
    catch (Exception paramamph)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramamph.toString());
    }
    return localanan;
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
 * Qualified Name:     anan
 * JD-Core Version:    0.7.0.1
 */