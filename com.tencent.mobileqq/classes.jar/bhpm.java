import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bhpm
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private bhpn jdField_a_of_type_Bhpn;
  private bhpo jdField_a_of_type_Bhpo;
  
  public bhpm(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bhpo = new bhpo(paramInt, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bhpn a()
  {
    return this.jdField_a_of_type_Bhpn;
  }
  
  public bhpo a()
  {
    return this.jdField_a_of_type_Bhpo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhpn != null) {
      this.jdField_a_of_type_Bhpn.c();
    }
  }
  
  public void a(bhpn parambhpn)
  {
    this.jdField_a_of_type_Bhpn = parambhpn;
    this.jdField_a_of_type_Bhpn.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bhpn == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bhpn.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bhpn.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpm
 * JD-Core Version:    0.7.0.1
 */