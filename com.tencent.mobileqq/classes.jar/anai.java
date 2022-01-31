import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anai
{
  private int a;
  private int b;
  private int c = 1;
  
  public static anai a(ampi paramampi)
  {
    anai localanai = new anai();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString);
      localanai.a(paramampi.optInt("hotword_switch_message", 0));
      localanai.b(paramampi.optInt("hotword_switch_contact", 0));
      localanai.c(paramampi.optInt("hotword_switch_dongtai", 1));
      return localanai;
    }
    catch (Exception paramampi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramampi.toString());
    }
    return localanai;
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
 * Qualified Name:     anai
 * JD-Core Version:    0.7.0.1
 */