import android.os.Bundle;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

class bitq
  extends alls
{
  bitq(bito parambito) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("result", paramInt);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bitq
 * JD-Core Version:    0.7.0.1
 */