import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class baom
  extends baot
{
  baom(baol parambaol, banv parambanv) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Banv.beginSwitch();
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
      this.jdField_a_of_type_Banv.postSwitch(paramInt);
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
  
  public boolean a(baoo parambaoo)
  {
    try
    {
      this.jdField_a_of_type_Banv.doSwitch(parambaoo.a(), parambaoo.d());
      return true;
    }
    catch (RemoteException parambaoo)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", parambaoo);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baom
 * JD-Core Version:    0.7.0.1
 */