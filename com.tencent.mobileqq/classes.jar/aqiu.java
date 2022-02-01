import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqiu
{
  private int a;
  private int b;
  private int c = 1;
  
  public static aqiu a(aptx paramaptx)
  {
    aqiu localaqiu = new aqiu();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
      localaqiu.a(paramaptx.optInt("hotword_switch_message", 0));
      localaqiu.b(paramaptx.optInt("hotword_switch_contact", 0));
      localaqiu.c(paramaptx.optInt("hotword_switch_dongtai", 1));
      return localaqiu;
    }
    catch (Exception paramaptx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaptx.toString());
    }
    return localaqiu;
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
 * Qualified Name:     aqiu
 * JD-Core Version:    0.7.0.1
 */