import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class beim
  extends beit
{
  beim(beil parambeil, behv parambehv) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Behv.beginSwitch();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("ThemeIPCModule", 1, "beginSwitch: ", localRemoteException);
    }
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Behv.postSwitch(paramInt);
      return super.a(paramInt);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ThemeIPCModule", 1, "postSwitch: ", localRemoteException);
      }
    }
  }
  
  public boolean a(beio parambeio)
  {
    try
    {
      this.jdField_a_of_type_Behv.doSwitch(parambeio.a(), parambeio.d());
      return true;
    }
    catch (RemoteException parambeio)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", parambeio);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beim
 * JD-Core Version:    0.7.0.1
 */