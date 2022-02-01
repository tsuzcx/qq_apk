import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqis
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public aqis()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aqis a(aptx paramaptx)
  {
    aqis localaqis = new aqis();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
      localaqis.a(paramaptx.optInt("business_switch_message", 1));
      localaqis.b(paramaptx.optInt("business_switch_contact", 1));
      localaqis.c(paramaptx.optInt("business_switch_dongtai", 1));
      return localaqis;
    }
    catch (Exception paramaptx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaptx.toString());
    }
    return localaqis;
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
 * Qualified Name:     aqis
 * JD-Core Version:    0.7.0.1
 */