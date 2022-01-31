import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class aymf
  extends aymm
{
  aymf(ayme paramayme, aylo paramaylo) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Aylo.beginSwitch();
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
      this.jdField_a_of_type_Aylo.postSwitch(paramInt);
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
  
  public boolean a(aymh paramaymh)
  {
    try
    {
      this.jdField_a_of_type_Aylo.doSwitch(paramaymh.a(), paramaymh.d());
      return true;
    }
    catch (RemoteException paramaymh)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", paramaymh);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aymf
 * JD-Core Version:    0.7.0.1
 */