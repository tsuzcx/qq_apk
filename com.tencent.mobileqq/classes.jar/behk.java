import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class behk
  implements DialogInterface.OnClickListener
{
  behk(behm parambehm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    behh.a("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    behh.a(false);
    if (this.a != null) {
      this.a.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behk
 * JD-Core Version:    0.7.0.1
 */