import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anap
{
  private int a;
  private int b;
  private int c = 1;
  
  public static anap a(amph paramamph)
  {
    anap localanap = new anap();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString);
      localanap.a(paramamph.optInt("hotword_switch_message", 0));
      localanap.b(paramamph.optInt("hotword_switch_contact", 0));
      localanap.c(paramamph.optInt("hotword_switch_dongtai", 1));
      return localanap;
    }
    catch (Exception paramamph)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramamph.toString());
    }
    return localanap;
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
 * Qualified Name:     anap
 * JD-Core Version:    0.7.0.1
 */