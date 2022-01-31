import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class bakd
  extends bakk
{
  bakd(bakc parambakc, bajm parambajm) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Bajm.beginSwitch();
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
      this.jdField_a_of_type_Bajm.postSwitch(paramInt);
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
  
  public boolean a(bakf parambakf)
  {
    try
    {
      this.jdField_a_of_type_Bajm.doSwitch(parambakf.a(), parambakf.d());
      return true;
    }
    catch (RemoteException parambakf)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", parambakf);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakd
 * JD-Core Version:    0.7.0.1
 */