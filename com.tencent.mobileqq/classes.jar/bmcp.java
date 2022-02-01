import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class bmcp
  extends OnPluginInstallListener.Stub
{
  public bmcp(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    String str = String.valueOf(paramInt);
    paramString = anvx.a(2131709846);
    if (this.a.b == QQIndividualityBridgeActivity.c) {
      paramString = anvx.a(2131709839);
    }
    for (;;)
    {
      blvy.a(str, paramString);
      int i = NetworkUtil.getSystemNetwork(this.a);
      QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt + " and netType = " + i);
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.c(this.a);
      bdla.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
      return;
      if (this.a.b == QQIndividualityBridgeActivity.d) {
        paramString = anvx.a(2131709840);
      } else if (this.a.b == QQIndividualityBridgeActivity.e) {
        paramString = anvx.a(2131709843);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcp
 * JD-Core Version:    0.7.0.1
 */