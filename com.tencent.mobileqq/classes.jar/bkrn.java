import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class bkrn
  implements DialogInterface.OnClickListener
{
  bkrn(bkrk parambkrk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((bkqs)this.a.a.get()).b != null) {
      ((bkqs)this.a.a.get()).b.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrn
 * JD-Core Version:    0.7.0.1
 */