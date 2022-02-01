import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class aqax
  implements DialogInterface.OnDismissListener
{
  aqax(aqav paramaqav) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    aqav.a(this.a, false);
    QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqax
 * JD-Core Version:    0.7.0.1
 */