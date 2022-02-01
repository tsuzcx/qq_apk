import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZoneConnectProcessor.1;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class bnea
{
  private static bnea jdField_a_of_type_Bnea;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList<bneb> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bnea a()
  {
    if (jdField_a_of_type_Bnea == null) {}
    try
    {
      if (jdField_a_of_type_Bnea == null) {
        jdField_a_of_type_Bnea = new bnea();
      }
      return jdField_a_of_type_Bnea;
    }
    finally {}
  }
  
  private void a(bneb parambneb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + parambneb + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = bneb.a(parambneb).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, parambneb, 1);
        return;
      }
      catch (SecurityException parambneb) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", parambneb);
  }
  
  private void a(bneb parambneb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + parambneb);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QZoneConnectProcessor.1(this, parambneb), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new bneb(this, paramServiceConnection, ???, paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "queue");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.offer(paramServiceConnection);
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(paramServiceConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnea
 * JD-Core Version:    0.7.0.1
 */