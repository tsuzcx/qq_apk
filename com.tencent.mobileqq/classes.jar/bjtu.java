import android.content.Context;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;

public class bjtu
  extends nce
  implements bjtr
{
  protected Context a;
  protected bjtt a;
  
  public bjtu(Context paramContext, bjtt parambjtt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjtt = parambjtt;
    this.jdField_a_of_type_Bjtt.a(this);
  }
  
  private byte[] a(Bundle paramBundle)
  {
    return paramBundle.getByteArray("buffer");
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bjtt != null) {
      this.jdField_a_of_type_Bjtt.a(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte) {}
  
  public void b(byte[] paramArrayOfByte) {}
  
  public void d(Bundle paramBundle)
  {
    llc.a(String.valueOf(AppSetting.a()), this.jdField_a_of_type_AndroidContentContext, a(paramBundle));
  }
  
  public void e(Bundle paramBundle) {}
  
  public void f(Bundle paramBundle) {}
  
  public void g(Bundle paramBundle)
  {
    receiveMultiVideoMsg(1, a(paramBundle));
  }
  
  public void h(Bundle paramBundle)
  {
    receiveMultiVideoMsg(2, a(paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtu
 * JD-Core Version:    0.7.0.1
 */