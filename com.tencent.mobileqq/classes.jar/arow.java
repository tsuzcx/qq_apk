import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arow
{
  private int a;
  private int b;
  private int c = 1;
  
  public static arow a(araj paramaraj)
  {
    arow localarow = new arow();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
      localarow.a(paramaraj.optInt("hotword_switch_message", 0));
      localarow.b(paramaraj.optInt("hotword_switch_contact", 0));
      localarow.c(paramaraj.optInt("hotword_switch_dongtai", 1));
      return localarow;
    }
    catch (Exception paramaraj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaraj.toString());
    }
    return localarow;
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
 * Qualified Name:     arow
 * JD-Core Version:    0.7.0.1
 */