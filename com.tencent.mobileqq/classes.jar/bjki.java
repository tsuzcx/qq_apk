import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZoneConnectProcessor.1;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class bjki
{
  private static bjki jdField_a_of_type_Bjki;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList<bjkj> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bjki a()
  {
    if (jdField_a_of_type_Bjki == null) {}
    try
    {
      if (jdField_a_of_type_Bjki == null) {
        jdField_a_of_type_Bjki = new bjki();
      }
      return jdField_a_of_type_Bjki;
    }
    finally {}
  }
  
  private void a(bjkj parambjkj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + parambjkj + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = bjkj.a(parambjkj).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, parambjkj, 1);
        return;
      }
      catch (SecurityException parambjkj) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", parambjkj);
  }
  
  private void a(bjkj parambjkj, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + parambjkj);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QZoneConnectProcessor.1(this, parambjkj), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new bjkj(this, paramServiceConnection, ???, paramInt);
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
 * Qualified Name:     bjki
 * JD-Core Version:    0.7.0.1
 */