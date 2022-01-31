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

public class avrg
{
  static volatile avrg jdField_a_of_type_Avrg;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  avrc jdField_a_of_type_Avrc;
  avrj jdField_a_of_type_Avrj;
  avrl jdField_a_of_type_Avrl;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Messenger b;
  
  private avrg()
  {
    avrf.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Avrj = new avrj(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Avrj);
    this.jdField_a_of_type_AndroidContentServiceConnection = new avrh(this);
    this.jdField_a_of_type_Avrc = new avri(this);
  }
  
  public static avrg a()
  {
    avrf.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_Avrg == null) {}
    try
    {
      if (jdField_a_of_type_Avrg == null) {
        jdField_a_of_type_Avrg = new avrg();
      }
      return jdField_a_of_type_Avrg;
    }
    finally {}
  }
  
  public avrl a()
  {
    if (this.jdField_a_of_type_Avrl == null) {
      this.jdField_a_of_type_Avrl = new avrl();
    }
    return this.jdField_a_of_type_Avrl;
  }
  
  public void a(Context paramContext)
  {
    avrf.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      avrf.a("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        avrf.b("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    avrf.a("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      avrf.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
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
      avrf.b("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
    return false;
  }
  
  public void b(Context paramContext)
  {
    avrf.a("PTV.RichmediaClient", "unbindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      a(2, -1, null);
      paramContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrg
 * JD-Core Version:    0.7.0.1
 */