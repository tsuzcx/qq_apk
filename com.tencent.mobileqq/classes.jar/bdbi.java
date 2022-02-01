import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class bdbi
  extends bdbp
{
  bdbi(bdbh parambdbh, bdar parambdar) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Bdar.beginSwitch();
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
      this.jdField_a_of_type_Bdar.postSwitch(paramInt);
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
  
  public boolean a(bdbk parambdbk)
  {
    try
    {
      this.jdField_a_of_type_Bdar.doSwitch(parambdbk.a(), parambdbk.d());
      return true;
    }
    catch (RemoteException parambdbk)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", parambdbk);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbi
 * JD-Core Version:    0.7.0.1
 */