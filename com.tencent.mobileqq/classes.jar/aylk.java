import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class aylk
  implements DialogInterface.OnClickListener
{
  aylk(aylm paramaylm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aylh.a("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    aylh.a(false);
    if (this.a != null) {
      this.a.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aylk
 * JD-Core Version:    0.7.0.1
 */