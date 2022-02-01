import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import java.util.HashMap;

public class bluu
  implements OnPluginInstallListener
{
  public bluu(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity, long paramLong) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallBegin");
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallDownloadProgress");
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    QLog.e("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallError");
    QzoneVerticalVideoDownloadActivity.access$000(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity).sendEmptyMessage(1012);
    paramString = new HashMap();
    paramString.put("status", "installError");
    QzoneVerticalVideoDownloadActivity.access$800(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity.app, "vertical_layer_plugin_depend", paramString);
  }
  
  public void onInstallFinish(String paramString)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallFinish");
    QzoneVerticalVideoDownloadActivity.access$000(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity).sendEmptyMessage(1011);
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    QzoneVerticalVideoDownloadActivity.access$700(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity.app, "vertical_layer_plugin_depend", "status", "installFinish", (int)(l1 - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluu
 * JD-Core Version:    0.7.0.1
 */