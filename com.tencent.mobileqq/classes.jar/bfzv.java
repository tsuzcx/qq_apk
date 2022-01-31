import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZoneConnectProcessor.1;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class bfzv
{
  private static bfzv jdField_a_of_type_Bfzv;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinkedList<bfzw> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bfzv a()
  {
    if (jdField_a_of_type_Bfzv == null) {}
    try
    {
      if (jdField_a_of_type_Bfzv == null) {
        jdField_a_of_type_Bfzv = new bfzv();
      }
      return jdField_a_of_type_Bfzv;
    }
    finally {}
  }
  
  private void a(bfzw parambfzw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + parambfzw + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = bfzw.a(parambfzw).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, parambfzw, 1);
        return;
      }
      catch (SecurityException parambfzw) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", parambfzw);
  }
  
  private void a(bfzw parambfzw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + parambfzw);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QZoneConnectProcessor.1(this, parambfzw), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new bfzw(this, paramServiceConnection, ???, paramInt);
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
 * Qualified Name:     bfzv
 * JD-Core Version:    0.7.0.1
 */