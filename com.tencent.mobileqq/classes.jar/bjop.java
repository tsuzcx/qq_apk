import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZoneConnectProcessor.1;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class bjop
{
  private static bjop jdField_a_of_type_Bjop;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList<bjoq> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bjop a()
  {
    if (jdField_a_of_type_Bjop == null) {}
    try
    {
      if (jdField_a_of_type_Bjop == null) {
        jdField_a_of_type_Bjop = new bjop();
      }
      return jdField_a_of_type_Bjop;
    }
    finally {}
  }
  
  private void a(bjoq parambjoq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + parambjoq + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = bjoq.a(parambjoq).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, parambjoq, 1);
        return;
      }
      catch (SecurityException parambjoq) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", parambjoq);
  }
  
  private void a(bjoq parambjoq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + parambjoq);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QZoneConnectProcessor.1(this, parambjoq), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new bjoq(this, paramServiceConnection, ???, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjop
 * JD-Core Version:    0.7.0.1
 */