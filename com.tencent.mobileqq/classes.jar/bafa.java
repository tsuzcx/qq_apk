import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.App;

public class bafa
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString;
  
  public static bafa a(String paramString1, String paramString2)
  {
    bafa localbafa = new bafa();
    localbafa.jdField_a_of_type_Long = 999L;
    localbafa.jdField_a_of_type_JavaLangString = paramString1;
    localbafa.jdField_b_of_type_JavaLangString = paramString2;
    localbafa.jdField_c_of_type_JavaLangString = "local";
    localbafa.jdField_a_of_type_Int = 0;
    return localbafa;
  }
  
  public static bafa a(cmd0xe0a.App paramApp)
  {
    if (paramApp != null)
    {
      bafa localbafa = new bafa();
      localbafa.jdField_a_of_type_Long = paramApp.appid.get();
      localbafa.jdField_a_of_type_JavaLangString = paramApp.name.get();
      localbafa.jdField_b_of_type_JavaLangString = paramApp.icon.get();
      localbafa.jdField_c_of_type_JavaLangString = paramApp.url.get();
      localbafa.jdField_a_of_type_Int = paramApp.disabled.get();
      if (paramApp.default_disabled.has()) {
        localbafa.jdField_c_of_type_Int = paramApp.default_disabled.get();
      }
      return localbafa;
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
 * Qualified Name:     bafa
 * JD-Core Version:    0.7.0.1
 */