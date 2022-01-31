import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bbrk
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bbrl jdField_a_of_type_Bbrl;
  private bbrm jdField_a_of_type_Bbrm;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bbrk(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bbrm = new bbrm(paramInt, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bbrl a()
  {
    return this.jdField_a_of_type_Bbrl;
  }
  
  public bbrm a()
  {
    return this.jdField_a_of_type_Bbrm;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbrl != null) {
      this.jdField_a_of_type_Bbrl.c();
    }
  }
  
  public void a(bbrl parambbrl)
  {
    this.jdField_a_of_type_Bbrl = parambbrl;
    this.jdField_a_of_type_Bbrl.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bbrl == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bbrl.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bbrl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrk
 * JD-Core Version:    0.7.0.1
 */