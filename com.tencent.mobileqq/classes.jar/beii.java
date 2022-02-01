import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class beii
  extends beip
{
  beii(beih parambeih, behq parambehq) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Behq.beginSwitch();
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
      this.jdField_a_of_type_Behq.postSwitch(paramInt);
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
  
  public boolean a(beik parambeik)
  {
    try
    {
      this.jdField_a_of_type_Behq.doSwitch(parambeik.a(), parambeik.d());
      return true;
    }
    catch (RemoteException parambeik)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", parambeik);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beii
 * JD-Core Version:    0.7.0.1
 */