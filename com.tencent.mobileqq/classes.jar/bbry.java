import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class bbry
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bbrz jdField_a_of_type_Bbrz;
  private bbsa jdField_a_of_type_Bbsa;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bbry(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bbsa = new bbsa(paramInt, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bbrz a()
  {
    return this.jdField_a_of_type_Bbrz;
  }
  
  public bbsa a()
  {
    return this.jdField_a_of_type_Bbsa;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbrz != null) {
      this.jdField_a_of_type_Bbrz.c();
    }
  }
  
  public void a(bbrz parambbrz)
  {
    this.jdField_a_of_type_Bbrz = parambbrz;
    this.jdField_a_of_type_Bbrz.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bbrz == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bbrz.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bbrz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbry
 * JD-Core Version:    0.7.0.1
 */