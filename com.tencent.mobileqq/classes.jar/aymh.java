import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class aymh
  extends aymo
{
  aymh(aymg paramaymg, aylq paramaylq) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Aylq.beginSwitch();
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
      this.jdField_a_of_type_Aylq.postSwitch(paramInt);
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
  
  public boolean a(aymj paramaymj)
  {
    try
    {
      this.jdField_a_of_type_Aylq.doSwitch(paramaymj.a(), paramaymj.d());
      return true;
    }
    catch (RemoteException paramaymj)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", paramaymj);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aymh
 * JD-Core Version:    0.7.0.1
 */