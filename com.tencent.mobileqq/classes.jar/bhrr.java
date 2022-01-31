import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

final class bhrr
  implements DialogInterface.OnClickListener
{
  bhrr(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (bgyi.a().indexOf("GM") < 0) {
        bhrp.a(QzoneConfig.getInstance().getConfig("H5Url", "DownloadQzoneClient", "https://m.qzone.com/client/fwd?bid=update&_wv=7"), this.a);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "simpleBrowserJump exception", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrr
 * JD-Core Version:    0.7.0.1
 */