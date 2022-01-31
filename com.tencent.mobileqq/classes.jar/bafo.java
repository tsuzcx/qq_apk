import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.App;

public class bafo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString;
  
  public static bafo a(String paramString1, String paramString2)
  {
    bafo localbafo = new bafo();
    localbafo.jdField_a_of_type_Long = 999L;
    localbafo.jdField_a_of_type_JavaLangString = paramString1;
    localbafo.jdField_b_of_type_JavaLangString = paramString2;
    localbafo.jdField_c_of_type_JavaLangString = "local";
    localbafo.jdField_a_of_type_Int = 0;
    return localbafo;
  }
  
  public static bafo a(cmd0xe0a.App paramApp)
  {
    if (paramApp != null)
    {
      bafo localbafo = new bafo();
      localbafo.jdField_a_of_type_Long = paramApp.appid.get();
      localbafo.jdField_a_of_type_JavaLangString = paramApp.name.get();
      localbafo.jdField_b_of_type_JavaLangString = paramApp.icon.get();
      localbafo.jdField_c_of_type_JavaLangString = paramApp.url.get();
      localbafo.jdField_a_of_type_Int = paramApp.disabled.get();
      if (paramApp.default_disabled.has()) {
        localbafo.jdField_c_of_type_Int = paramApp.default_disabled.get();
      }
      return localbafo;
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafo
 * JD-Core Version:    0.7.0.1
 */