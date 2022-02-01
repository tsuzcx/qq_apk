import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class biai
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private biaj jdField_a_of_type_Biaj;
  private biak jdField_a_of_type_Biak;
  
  public biai(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Biak = new biak(paramInt, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public biaj a()
  {
    return this.jdField_a_of_type_Biaj;
  }
  
  public biak a()
  {
    return this.jdField_a_of_type_Biak;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Biaj != null) {
      this.jdField_a_of_type_Biaj.c();
    }
  }
  
  public void a(biaj parambiaj)
  {
    this.jdField_a_of_type_Biaj = parambiaj;
    this.jdField_a_of_type_Biaj.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Biaj == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Biaj.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Biaj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biai
 * JD-Core Version:    0.7.0.1
 */