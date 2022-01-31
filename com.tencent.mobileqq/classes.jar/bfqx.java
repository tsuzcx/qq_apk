import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bfqx
  extends bfqv
{
  private static bfqx jdField_a_of_type_Bfqx;
  private int jdField_a_of_type_Int;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public static bfqx a()
  {
    if (jdField_a_of_type_Bfqx == null) {}
    try
    {
      if (jdField_a_of_type_Bfqx == null) {
        jdField_a_of_type_Bfqx = new bfqx();
      }
      return jdField_a_of_type_Bfqx;
    }
    finally {}
  }
  
  protected long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    }
    return l;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    int i = 0;
    if ((paramAppRuntime instanceof AppInterface)) {
      i = ((AppInterface)paramAppRuntime).getAppid();
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = i;
  }
  
  protected void b()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bfqz.class);
    localNewIntent.putExtra("req_type", 5);
    localNewIntent.putExtra("app_id", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void g(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bfqz.class);
    localNewIntent.putExtra("req_type", 6);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void h(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bfqz.class);
    localNewIntent.putExtra("req_type", 2);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void i(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bfqz.class);
    localNewIntent.putExtra("req_type", 3);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void j(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bfqz.class);
    localNewIntent.putExtra("req_type", 4);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfqx
 * JD-Core Version:    0.7.0.1
 */