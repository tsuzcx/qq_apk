import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bdqs
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bdqt jdField_a_of_type_Bdqt;
  private bdqu jdField_a_of_type_Bdqu;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bdqs(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bdqu = new bdqu(paramInt, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bdqt a()
  {
    return this.jdField_a_of_type_Bdqt;
  }
  
  public bdqu a()
  {
    return this.jdField_a_of_type_Bdqu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdqt != null) {
      this.jdField_a_of_type_Bdqt.c();
    }
  }
  
  public void a(bdqt parambdqt)
  {
    this.jdField_a_of_type_Bdqt = parambdqt;
    this.jdField_a_of_type_Bdqt.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bdqt == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bdqt.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bdqt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqs
 * JD-Core Version:    0.7.0.1
 */