import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZoneConnectProcessor.1;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class bhix
{
  private static bhix jdField_a_of_type_Bhix;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList<bhiy> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bhix a()
  {
    if (jdField_a_of_type_Bhix == null) {}
    try
    {
      if (jdField_a_of_type_Bhix == null) {
        jdField_a_of_type_Bhix = new bhix();
      }
      return jdField_a_of_type_Bhix;
    }
    finally {}
  }
  
  private void a(bhiy parambhiy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + parambhiy + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = bhiy.a(parambhiy).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, parambhiy, 1);
        return;
      }
      catch (SecurityException parambhiy) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", parambhiy);
  }
  
  private void a(bhiy parambhiy, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + parambhiy);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QZoneConnectProcessor.1(this, parambhiy), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new bhiy(this, paramServiceConnection, ???, paramInt);
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
 * Qualified Name:     bhix
 * JD-Core Version:    0.7.0.1
 */