import android.os.Bundle;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

class bmnl
  extends anvn
{
  bmnl(bmnj parambmnj) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("result", paramInt);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnl
 * JD-Core Version:    0.7.0.1
 */