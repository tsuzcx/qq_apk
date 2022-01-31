import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;
import java.util.concurrent.CountDownLatch;

class aqlp
  implements ServiceConnection
{
  aqlp(aqln paramaqln, CountDownLatch paramCountDownLatch) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.i("HuayangPluginNewDownloader", 2, "onServiceConnected ");
    aqln.a(this.jdField_a_of_type_Aqln).unbindService(this);
    paramComponentName = PluginProcessService.wrapBinder(paramIBinder);
    try
    {
      paramComponentName.exit();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        QLog.d("HuayangPluginNewDownloader", 2, "exit over", paramComponentName);
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqlp
 * JD-Core Version:    0.7.0.1
 */