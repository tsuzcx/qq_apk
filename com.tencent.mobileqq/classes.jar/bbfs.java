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

public class bbfs
{
  static volatile bbfs jdField_a_of_type_Bbfs;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  bbfo jdField_a_of_type_Bbfo;
  bbfv jdField_a_of_type_Bbfv;
  bbfx jdField_a_of_type_Bbfx;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Messenger b;
  
  private bbfs()
  {
    bbfr.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Bbfv = new bbfv(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Bbfv);
    this.jdField_a_of_type_AndroidContentServiceConnection = new bbft(this);
    this.jdField_a_of_type_Bbfo = new bbfu(this);
  }
  
  public static bbfs a()
  {
    bbfr.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_Bbfs == null) {}
    try
    {
      if (jdField_a_of_type_Bbfs == null) {
        jdField_a_of_type_Bbfs = new bbfs();
      }
      return jdField_a_of_type_Bbfs;
    }
    finally {}
  }
  
  public bbfx a()
  {
    if (this.jdField_a_of_type_Bbfx == null) {
      this.jdField_a_of_type_Bbfx = new bbfx();
    }
    return this.jdField_a_of_type_Bbfx;
  }
  
  public void a(Context paramContext)
  {
    bbfr.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      bbfr.a("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        bbfr.b("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    bbfr.a("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      bbfr.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
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
      bbfr.b("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
    return false;
  }
  
  public void b(Context paramContext)
  {
    bbfr.a("PTV.RichmediaClient", "unbindService");
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
 * Qualified Name:     bbfs
 * JD-Core Version:    0.7.0.1
 */