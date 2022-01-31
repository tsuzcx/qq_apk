import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;

public class aqba
{
  private static aqba jdField_a_of_type_Aqba;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private altm jdField_a_of_type_Altm = new aqbb(this);
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aqbc(this);
  
  public static aqba a()
  {
    if (jdField_a_of_type_Aqba == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Aqba == null) {
        jdField_a_of_type_Aqba = new aqba();
      }
      return jdField_a_of_type_Aqba;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Aqba != null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if ((jdField_a_of_type_Aqba != null) && (jdField_a_of_type_Aqba.jdField_a_of_type_JavaLangRefWeakReference != null))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)jdField_a_of_type_Aqba.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localQQAppInterface != null) {
            localQQAppInterface.removeObserver(jdField_a_of_type_Aqba.jdField_a_of_type_Altm);
          }
          jdField_a_of_type_Aqba = null;
        }
        return;
      }
    }
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("checkDevLockSms_ret", paramInt);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "openEquipmentLock");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      if (QLog.isColorLevel()) {
        QLog.i("EquipLockWebImpl", 2, "resp to sever: ");
      }
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isWaiting", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setWaitingResponse");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void b(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("setMobileResult", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setMobileResult");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void c(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isBack", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "closeWeb");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Messenger paramMessenger)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsMessenger = paramMessenger;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQAppInterface != null) {
        break label30;
      }
    }
    label30:
    for (int i = -1;; i = aqbd.a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), null, paramArrayOfByte, this.jdField_a_of_type_MqqObserverWtloginObserver))
    {
      a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqba
 * JD-Core Version:    0.7.0.1
 */