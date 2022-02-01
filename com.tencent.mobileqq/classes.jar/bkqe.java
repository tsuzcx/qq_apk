import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class bkqe
  implements MiniAppLauncher.MiniAppLaunchListener
{
  bkqe(bkqb parambkqb, Activity paramActivity) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqe
 * JD-Core Version:    0.7.0.1
 */