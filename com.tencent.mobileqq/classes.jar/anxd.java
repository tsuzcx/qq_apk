import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class anxd
  implements DialogInterface.OnDismissListener
{
  anxd(anxc paramanxc) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDismiss begins, mCurTaskId:" + this.a.a);
    }
    this.a.a(this.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDismiss ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxd
 * JD-Core Version:    0.7.0.1
 */