import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqzf
{
  private int a;
  private int b;
  private int c = 1;
  
  public static aqzf a(aqlg paramaqlg)
  {
    aqzf localaqzf = new aqzf();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
      localaqzf.a(paramaqlg.optInt("hotword_switch_message", 0));
      localaqzf.b(paramaqlg.optInt("hotword_switch_contact", 0));
      localaqzf.c(paramaqlg.optInt("hotword_switch_dongtai", 1));
      return localaqzf;
    }
    catch (Exception paramaqlg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaqlg.toString());
    }
    return localaqzf;
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
 * Qualified Name:     aqzf
 * JD-Core Version:    0.7.0.1
 */