import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class ayli
  implements DialogInterface.OnClickListener
{
  ayli(aylk paramaylk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aylf.a("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    aylf.a(false);
    if (this.a != null) {
      this.a.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayli
 * JD-Core Version:    0.7.0.1
 */