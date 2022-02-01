import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;

class bjhc
  implements DialogInterface.OnClickListener
{
  bjhc(bjha parambjha, IMiniAppContext paramIMiniAppContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "confirm");
    bjha.a(this.jdField_a_of_type_Bjha).postDelayed(bjha.a(this.jdField_a_of_type_Bjha), 15000L);
    QbSdk.setTbsListener(this.jdField_a_of_type_Bjha);
    TbsDownloader.startDownload(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getContext(), true);
    if (bjha.a(this.jdField_a_of_type_Bjha) == null) {
      bjha.a(this.jdField_a_of_type_Bjha, new bjhf(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity()));
    }
    bjha.a(this.jdField_a_of_type_Bjha).a(amtj.a(2131705019));
    if (!bjha.a(this.jdField_a_of_type_Bjha).isShowing()) {
      bjha.a(this.jdField_a_of_type_Bjha).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhc
 * JD-Core Version:    0.7.0.1
 */