import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.richmedia.RichmediaService;
import java.util.concurrent.atomic.AtomicBoolean;

public class aurv
{
  static volatile aurv jdField_a_of_type_Aurv;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  aurr jdField_a_of_type_Aurr;
  aury jdField_a_of_type_Aury;
  ausa jdField_a_of_type_Ausa;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Messenger b;
  
  private aurv()
  {
    auru.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Aury = new aury(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Aury);
    this.jdField_a_of_type_AndroidContentServiceConnection = new aurw(this);
    this.jdField_a_of_type_Aurr = new aurx(this);
  }
  
  public static aurv a()
  {
    auru.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_Aurv == null) {}
    try
    {
      if (jdField_a_of_type_Aurv == null) {
        jdField_a_of_type_Aurv = new aurv();
      }
      return jdField_a_of_type_Aurv;
    }
    finally {}
  }
  
  public ausa a()
  {
    if (this.jdField_a_of_type_Ausa == null) {
      this.jdField_a_of_type_Ausa = new ausa();
    }
    return this.jdField_a_of_type_Ausa;
  }
  
  public void a(Context paramContext)
  {
    auru.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      auru.a("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        auru.b("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    auru.a("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      auru.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
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
      auru.b("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
    return false;
  }
  
  public void b(Context paramContext)
  {
    auru.a("PTV.RichmediaClient", "unbindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      a(2, -1, null);
      paramContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aurv
 * JD-Core Version:    0.7.0.1
 */