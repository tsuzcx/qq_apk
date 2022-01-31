import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bdvb
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bdvc jdField_a_of_type_Bdvc;
  private bdvd jdField_a_of_type_Bdvd;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bdvb(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bdvd = new bdvd(paramInt, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bdvc a()
  {
    return this.jdField_a_of_type_Bdvc;
  }
  
  public bdvd a()
  {
    return this.jdField_a_of_type_Bdvd;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdvc != null) {
      this.jdField_a_of_type_Bdvc.c();
    }
  }
  
  public void a(bdvc parambdvc)
  {
    this.jdField_a_of_type_Bdvc = parambdvc;
    this.jdField_a_of_type_Bdvc.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bdvc == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bdvc.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bdvc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvb
 * JD-Core Version:    0.7.0.1
 */