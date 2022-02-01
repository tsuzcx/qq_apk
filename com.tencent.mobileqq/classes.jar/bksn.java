import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;

class bksn
  implements DialogInterface.OnClickListener
{
  bksn(bksl parambksl, IMiniAppContext paramIMiniAppContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "confirm");
    bksl.a(this.jdField_a_of_type_Bksl).postDelayed(bksl.a(this.jdField_a_of_type_Bksl), 15000L);
    QbSdk.setTbsListener(this.jdField_a_of_type_Bksl);
    TbsDownloader.startDownload(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getContext(), true);
    if (bksl.a(this.jdField_a_of_type_Bksl) == null) {
      bksl.a(this.jdField_a_of_type_Bksl, new bksq(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity()));
    }
    bksl.a(this.jdField_a_of_type_Bksl).a(anvx.a(2131705370));
    if (!bksl.a(this.jdField_a_of_type_Bksl).isShowing()) {
      bksl.a(this.jdField_a_of_type_Bksl).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksn
 * JD-Core Version:    0.7.0.1
 */