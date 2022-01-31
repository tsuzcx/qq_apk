import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aowf
{
  private int a;
  private int b;
  private int c = 1;
  
  public static aowf a(aoko paramaoko)
  {
    aowf localaowf = new aowf();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString);
      localaowf.a(paramaoko.optInt("hotword_switch_message", 0));
      localaowf.b(paramaoko.optInt("hotword_switch_contact", 0));
      localaowf.c(paramaoko.optInt("hotword_switch_dongtai", 1));
      return localaowf;
    }
    catch (Exception paramaoko)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaoko.toString());
    }
    return localaowf;
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
 * Qualified Name:     aowf
 * JD-Core Version:    0.7.0.1
 */