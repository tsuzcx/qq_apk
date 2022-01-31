import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class bgsf
  extends OnPluginInstallListener.Stub
{
  public bgsf(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    String str = String.valueOf(paramInt);
    paramString = ajya.a(2131710398);
    if (this.a.b == QQIndividualityBridgeActivity.c) {
      paramString = ajya.a(2131710391);
    }
    for (;;)
    {
      bglh.a(str, paramString);
      int i = bbfj.a(this.a);
      QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt + " and netType = " + i);
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.c(this.a);
      axqy.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
      return;
      if (this.a.b == QQIndividualityBridgeActivity.d) {
        paramString = ajya.a(2131710392);
      } else if (this.a.b == QQIndividualityBridgeActivity.e) {
        paramString = ajya.a(2131710395);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsf
 * JD-Core Version:    0.7.0.1
 */