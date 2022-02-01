import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class bkqc
  implements MiniAppLauncher.MiniAppLaunchListener
{
  bkqc(bkqb parambkqb, RequestEvent paramRequestEvent) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqc
 * JD-Core Version:    0.7.0.1
 */