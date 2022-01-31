import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QRBridgeActivity;

public class amyf
  extends OnPluginInstallListener.Stub
{
  public amyf(QRBridgeActivity paramQRBridgeActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "installPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    }
    ReportController.b(this.a.app, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "installPlugin onInstallFinish, pluginId = " + paramString);
    }
    ReportController.b(this.a.app, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyf
 * JD-Core Version:    0.7.0.1
 */