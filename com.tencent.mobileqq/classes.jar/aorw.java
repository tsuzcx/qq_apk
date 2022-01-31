import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aorw
{
  private int a;
  private int b;
  private int c = 1;
  
  public static aorw a(aogf paramaogf)
  {
    aorw localaorw = new aorw();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString);
      localaorw.a(paramaogf.optInt("hotword_switch_message", 0));
      localaorw.b(paramaogf.optInt("hotword_switch_contact", 0));
      localaorw.c(paramaogf.optInt("hotword_switch_dongtai", 1));
      return localaorw;
    }
    catch (Exception paramaogf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaogf.toString());
    }
    return localaorw;
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
 * Qualified Name:     aorw
 * JD-Core Version:    0.7.0.1
 */