import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class bkng
  implements DialogInterface.OnClickListener
{
  bkng(bknd parambknd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((bkml)this.a.a.get()).b != null) {
      ((bkml)this.a.a.get()).b.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkng
 * JD-Core Version:    0.7.0.1
 */