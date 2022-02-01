import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class aoxt
  implements DialogInterface.OnDismissListener
{
  aoxt(aoxr paramaoxr) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    aoxr.a(this.a, false);
    QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxt
 * JD-Core Version:    0.7.0.1
 */