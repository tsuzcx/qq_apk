import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class apqk
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public apqk(QRScanEntryView paramQRScanEntryView, String paramString1, String paramString2, Activity paramActivity, apot paramapot) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = new Intent();
      paramBundle.putExtra("detectType", 2);
      paramBundle.putExtra("scannerResult", this.jdField_a_of_type_JavaLangString.trim());
      if (!TextUtils.isEmpty(this.b)) {
        paramBundle.putExtra("filePath", this.b);
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(13, paramBundle);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, "onLaunchResult 2 false");
    }
    this.jdField_a_of_type_Apot.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqk
 * JD-Core Version:    0.7.0.1
 */