import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class axla
  implements DialogInterface.OnClickListener
{
  axla(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axkz.a("0X800A5B5");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showDarkModeTips systemDarMode  = " + this.a);
    }
    axkz.a(true);
    axkz.a(this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axla
 * JD-Core Version:    0.7.0.1
 */