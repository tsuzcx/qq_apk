import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe82.cmd0xe82.App;

public class bgbb
  extends bgba
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public bgbb(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    super(paramLong, paramString1, paramString2, paramInt);
  }
  
  public static bgbb a(String paramString1, String paramString2)
  {
    paramString1 = new bgbb(999L, paramString1, paramString2, 0);
    paramString1.jdField_a_of_type_JavaLangString = "local";
    return paramString1;
  }
  
  public static bgbb a(cmd0xe82.App paramApp)
  {
    if (paramApp != null)
    {
      bgbb localbgbb = new bgbb(paramApp.appid.get(), paramApp.name.get(), paramApp.icon.get(), paramApp.show_frame.get());
      localbgbb.jdField_a_of_type_JavaLangString = paramApp.url.get();
      localbgbb.jdField_a_of_type_Int = paramApp.redpoint.get();
      localbgbb.jdField_a_of_type_Long = paramApp.add_ts.get();
      return localbgbb;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbb
 * JD-Core Version:    0.7.0.1
 */