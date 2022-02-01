import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class bdpq
  extends bdpx
{
  bdpq(bdpp parambdpp, bdoz parambdoz) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Bdoz.beginSwitch();
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
      this.jdField_a_of_type_Bdoz.postSwitch(paramInt);
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
  
  public boolean a(bdps parambdps)
  {
    try
    {
      this.jdField_a_of_type_Bdoz.doSwitch(parambdps.a(), parambdps.d());
      return true;
    }
    catch (RemoteException parambdps)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", parambdps);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpq
 * JD-Core Version:    0.7.0.1
 */