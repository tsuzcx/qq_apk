import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class amom
  implements Runnable
{
  public amom(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", true);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(BaseActivity.sTopActivity, localBundle, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2131034134, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amom
 * JD-Core Version:    0.7.0.1
 */