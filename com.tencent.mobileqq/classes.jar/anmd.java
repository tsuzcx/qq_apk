import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class anmd
  implements DialogInterface.OnDismissListener
{
  anmd(anmb paramanmb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    anmb.a(this.a, false);
    QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmd
 * JD-Core Version:    0.7.0.1
 */