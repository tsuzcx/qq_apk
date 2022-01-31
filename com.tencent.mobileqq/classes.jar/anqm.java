import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class anqm
  implements DialogInterface.OnDismissListener
{
  anqm(anqk paramanqk) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    anqk.a(this.a, false);
    QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqm
 * JD-Core Version:    0.7.0.1
 */