import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class axlz
  extends axmg
{
  axlz(axly paramaxly, axli paramaxli) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Axli.beginSwitch();
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
      this.jdField_a_of_type_Axli.postSwitch(paramInt);
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
  
  public boolean a(axmb paramaxmb)
  {
    try
    {
      this.jdField_a_of_type_Axli.doSwitch(paramaxmb.a(), paramaxmb.d());
      return true;
    }
    catch (RemoteException paramaxmb)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", paramaxmb);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axlz
 * JD-Core Version:    0.7.0.1
 */