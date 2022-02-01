import android.os.Bundle;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

class bmdb
  extends ansi
{
  bmdb(bmcz parambmcz) {}
  
  protected void onUpdateStatusActions(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("result", paramInt);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdb
 * JD-Core Version:    0.7.0.1
 */