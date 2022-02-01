import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe82.cmd0xe82.App;

public class betv
  extends betu
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public betv(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    super(paramLong, paramString1, paramString2, paramInt);
  }
  
  public static betv a(String paramString1, String paramString2)
  {
    paramString1 = new betv(999L, paramString1, paramString2, 0);
    paramString1.jdField_a_of_type_JavaLangString = "local";
    return paramString1;
  }
  
  public static betv a(cmd0xe82.App paramApp)
  {
    if (paramApp != null)
    {
      betv localbetv = new betv(paramApp.appid.get(), paramApp.name.get(), paramApp.icon.get(), paramApp.show_frame.get());
      localbetv.jdField_a_of_type_JavaLangString = paramApp.url.get();
      localbetv.jdField_a_of_type_Int = paramApp.redpoint.get();
      localbetv.jdField_a_of_type_Long = paramApp.add_ts.get();
      return localbetv;
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     betv
 * JD-Core Version:    0.7.0.1
 */