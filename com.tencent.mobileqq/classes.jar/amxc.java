import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class amxc
{
  private static amxc jdField_a_of_type_Amxc;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static amxc a()
  {
    if (jdField_a_of_type_Amxc == null) {}
    try
    {
      if (jdField_a_of_type_Amxc == null) {
        jdField_a_of_type_Amxc = new amxc();
      }
      return jdField_a_of_type_Amxc;
    }
    finally {}
  }
  
  private void a(amxe paramamxe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + paramamxe + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = amxe.a(paramamxe).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, paramamxe, 1);
        return;
      }
      catch (SecurityException paramamxe) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", paramamxe);
  }
  
  private void a(amxe paramamxe, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + paramamxe);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new amxd(this, paramamxe), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new amxe(this, paramServiceConnection, ???, paramInt);
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
 * Qualified Name:     amxc
 * JD-Core Version:    0.7.0.1
 */