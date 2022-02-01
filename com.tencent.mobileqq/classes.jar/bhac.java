import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bhac
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhad jdField_a_of_type_Bhad;
  private bhae jdField_a_of_type_Bhae;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bhac(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bhae = new bhae(paramInt, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bhad a()
  {
    return this.jdField_a_of_type_Bhad;
  }
  
  public bhae a()
  {
    return this.jdField_a_of_type_Bhae;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhad != null) {
      this.jdField_a_of_type_Bhad.c();
    }
  }
  
  public void a(bhad parambhad)
  {
    this.jdField_a_of_type_Bhad = parambhad;
    this.jdField_a_of_type_Bhad.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bhad == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bhad.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bhad.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhac
 * JD-Core Version:    0.7.0.1
 */