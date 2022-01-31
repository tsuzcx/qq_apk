import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class atpv
  implements DialogInterface.OnClickListener
{
  atpv(atpi paramatpi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    atbp.a(this.a.a, 1032);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "openBindPhonePage");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpv
 * JD-Core Version:    0.7.0.1
 */