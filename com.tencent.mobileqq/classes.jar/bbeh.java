import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class bbeh
{
  static volatile bbeh jdField_a_of_type_Bbeh;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  bbed jdField_a_of_type_Bbed;
  bbek jdField_a_of_type_Bbek;
  bbem jdField_a_of_type_Bbem;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Messenger b;
  
  private bbeh()
  {
    bbeg.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Bbek = new bbek(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Bbek);
    this.jdField_a_of_type_AndroidContentServiceConnection = new bbei(this);
    this.jdField_a_of_type_Bbed = new bbej(this);
  }
  
  public static bbeh a()
  {
    bbeg.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_Bbeh == null) {}
    try
    {
      if (jdField_a_of_type_Bbeh == null) {
        jdField_a_of_type_Bbeh = new bbeh();
      }
      return jdField_a_of_type_Bbeh;
    }
    finally {}
  }
  
  public bbem a()
  {
    if (this.jdField_a_of_type_Bbem == null) {
      this.jdField_a_of_type_Bbem = new bbem();
    }
    return this.jdField_a_of_type_Bbem;
  }
  
  public void a(Context paramContext)
  {
    bbeg.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      bbeg.a("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        bbeg.b("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    bbeg.a("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      bbeg.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
      return false;
    }
    Message localMessage = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    localMessage.setData(paramBundle);
    try
    {
      this.b.send(localMessage);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      bbeg.b("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
    return false;
  }
  
  public void b(Context paramContext)
  {
    bbeg.a("PTV.RichmediaClient", "unbindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {}
    try
    {
      a(2, -1, null);
      paramContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("PTV.RichmediaClient", 1, "unbindService error.", paramContext);
      return;
    }
    finally
    {
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeh
 * JD-Core Version:    0.7.0.1
 */