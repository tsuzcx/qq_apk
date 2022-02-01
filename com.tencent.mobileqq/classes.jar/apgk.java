import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class apgk
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public apgk(QRScanEntryView paramQRScanEntryView, String paramString, Activity paramActivity) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = new Intent();
      paramBundle.putExtra("detectType", 2);
      paramBundle.putExtra("scannerResult", this.jdField_a_of_type_JavaLangString.trim());
      this.jdField_a_of_type_AndroidAppActivity.setResult(13, paramBundle);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      QRScanEntryView.a(this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView, null);
      QRScanEntryView.a(this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView, 0L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, "onLaunchResult 1 false " + this.jdField_a_of_type_JavaLangString);
    }
    QRScanEntryView.a(this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView, this.jdField_a_of_type_JavaLangString);
    QRScanEntryView.a(this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView, System.currentTimeMillis());
    ((apep)this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView.a).b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgk
 * JD-Core Version:    0.7.0.1
 */