import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;

public class bapn
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bapo jdField_a_of_type_Bapo;
  private bapp jdField_a_of_type_Bapp;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public bapn(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bapp = new bapp(paramInt, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public bapo a()
  {
    return this.jdField_a_of_type_Bapo;
  }
  
  public bapp a()
  {
    return this.jdField_a_of_type_Bapp;
  }
  
  public void a(bapo parambapo)
  {
    this.jdField_a_of_type_Bapo = parambapo;
    this.jdField_a_of_type_Bapo.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bapo == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Bapo.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Bapo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapn
 * JD-Core Version:    0.7.0.1
 */