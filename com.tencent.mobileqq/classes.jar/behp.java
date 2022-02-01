import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class behp
  implements DialogInterface.OnClickListener
{
  behp(behr parambehr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    behm.a("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    behm.a(false);
    if (this.a != null) {
      this.a.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behp
 * JD-Core Version:    0.7.0.1
 */