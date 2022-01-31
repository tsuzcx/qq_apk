import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bcnk
  extends bcni
{
  private static bcnk jdField_a_of_type_Bcnk;
  private int jdField_a_of_type_Int;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public static bcnk a()
  {
    if (jdField_a_of_type_Bcnk == null) {}
    try
    {
      if (jdField_a_of_type_Bcnk == null) {
        jdField_a_of_type_Bcnk = new bcnk();
      }
      return jdField_a_of_type_Bcnk;
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bcnm.class);
    localNewIntent.putExtra("req_type", 5);
    localNewIntent.putExtra("app_id", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void g(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bcnm.class);
    localNewIntent.putExtra("req_type", 6);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void h(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bcnm.class);
    localNewIntent.putExtra("req_type", 2);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void i(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bcnm.class);
    localNewIntent.putExtra("req_type", 3);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void j(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), bcnm.class);
    localNewIntent.putExtra("req_type", 4);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcnk
 * JD-Core Version:    0.7.0.1
 */