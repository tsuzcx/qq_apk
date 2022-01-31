import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amke
{
  private int a;
  private int b;
  private int c = 1;
  
  public static amke a(alzs paramalzs)
  {
    amke localamke = new amke();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
      localamke.a(paramalzs.optInt("hotword_switch_message", 0));
      localamke.b(paramalzs.optInt("hotword_switch_contact", 0));
      localamke.c(paramalzs.optInt("hotword_switch_dongtai", 1));
      return localamke;
    }
    catch (Exception paramalzs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramalzs.toString());
    }
    return localamke;
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
 * Qualified Name:     amke
 * JD-Core Version:    0.7.0.1
 */