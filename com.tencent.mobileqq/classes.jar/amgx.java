import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class amgx
{
  private static amgx jdField_a_of_type_Amgx;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static amgx a()
  {
    if (jdField_a_of_type_Amgx == null) {}
    try
    {
      if (jdField_a_of_type_Amgx == null) {
        jdField_a_of_type_Amgx = new amgx();
      }
      return jdField_a_of_type_Amgx;
    }
    finally {}
  }
  
  private void a(amgz paramamgz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + paramamgz + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = amgz.a(paramamgz).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, paramamgz, 1);
        return;
      }
      catch (SecurityException paramamgz) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", paramamgz);
  }
  
  private void a(amgz paramamgz, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + paramamgz);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new amgy(this, paramamgz), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new amgz(this, paramServiceConnection, ???, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgx
 * JD-Core Version:    0.7.0.1
 */