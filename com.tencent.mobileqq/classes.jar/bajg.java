import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class bajg
  implements DialogInterface.OnClickListener
{
  bajg(baji parambaji) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bajd.a("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    bajd.a(false);
    if (this.a != null) {
      this.a.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajg
 * JD-Core Version:    0.7.0.1
 */