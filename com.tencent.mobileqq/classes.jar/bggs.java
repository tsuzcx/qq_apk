import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bggs
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private bggt jdField_a_of_type_Bggt;
  private bggu jdField_a_of_type_Bggu;
  
  public bggs(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bggu = new bggu(paramInt, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bggt a()
  {
    return this.jdField_a_of_type_Bggt;
  }
  
  public bggu a()
  {
    return this.jdField_a_of_type_Bggu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bggt != null) {
      this.jdField_a_of_type_Bggt.c();
    }
  }
  
  public void a(bggt parambggt)
  {
    this.jdField_a_of_type_Bggt = parambggt;
    this.jdField_a_of_type_Bggt.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bggt == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bggt.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bggt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggs
 * JD-Core Version:    0.7.0.1
 */