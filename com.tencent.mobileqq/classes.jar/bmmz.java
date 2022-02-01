import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class bmmz
  extends OnPluginInstallListener.Stub
{
  public bmmz(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    String str = String.valueOf(paramInt);
    paramString = anzj.a(2131709267);
    if (this.a.b == QQIndividualityBridgeActivity.c) {
      paramString = anzj.a(2131709260);
    }
    for (;;)
    {
      bmgk.a(str, paramString);
      int i = bhnv.a(this.a);
      QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt + " and netType = " + i);
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.c(this.a);
      bdll.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
      return;
      if (this.a.b == QQIndividualityBridgeActivity.d) {
        paramString = anzj.a(2131709261);
      } else if (this.a.b == QQIndividualityBridgeActivity.e) {
        paramString = anzj.a(2131709264);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmz
 * JD-Core Version:    0.7.0.1
 */