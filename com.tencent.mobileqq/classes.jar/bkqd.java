import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class bkqd
  implements MiniAppLauncher.MiniAppLaunchListener
{
  bkqd(bkqb parambkqb, RequestEvent paramRequestEvent) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqd
 * JD-Core Version:    0.7.0.1
 */