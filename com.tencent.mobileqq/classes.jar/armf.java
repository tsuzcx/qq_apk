import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class armf
{
  private int a;
  private int b;
  private int c = 1;
  
  public static armf a(aqxa paramaqxa)
  {
    armf localarmf = new armf();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
      localarmf.a(paramaqxa.optInt("hotword_switch_message", 0));
      localarmf.b(paramaqxa.optInt("hotword_switch_contact", 0));
      localarmf.c(paramaqxa.optInt("hotword_switch_dongtai", 1));
      return localarmf;
    }
    catch (Exception paramaqxa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaqxa.toString());
    }
    return localarmf;
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
    return String.format("mHotWordSwitchTabMessage:%d, mHotWordSwitchTabContact:%d, mHotWordSwitchTabDongtai:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armf
 * JD-Core Version:    0.7.0.1
 */