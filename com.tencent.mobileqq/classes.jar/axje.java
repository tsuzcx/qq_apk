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

public class axje
{
  static volatile axje jdField_a_of_type_Axje;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  axja jdField_a_of_type_Axja;
  axjh jdField_a_of_type_Axjh;
  axjj jdField_a_of_type_Axjj;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Messenger b;
  
  private axje()
  {
    axjd.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Axjh = new axjh(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Axjh);
    this.jdField_a_of_type_AndroidContentServiceConnection = new axjf(this);
    this.jdField_a_of_type_Axja = new axjg(this);
  }
  
  public static axje a()
  {
    axjd.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_Axje == null) {}
    try
    {
      if (jdField_a_of_type_Axje == null) {
        jdField_a_of_type_Axje = new axje();
      }
      return jdField_a_of_type_Axje;
    }
    finally {}
  }
  
  public axjj a()
  {
    if (this.jdField_a_of_type_Axjj == null) {
      this.jdField_a_of_type_Axjj = new axjj();
    }
    return this.jdField_a_of_type_Axjj;
  }
  
  public void a(Context paramContext)
  {
    axjd.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      axjd.a("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        axjd.b("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    axjd.a("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      axjd.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
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
      axjd.b("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
    return false;
  }
  
  public void b(Context paramContext)
  {
    axjd.a("PTV.RichmediaClient", "unbindService");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axje
 * JD-Core Version:    0.7.0.1
 */