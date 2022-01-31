import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class aylg
  implements DialogInterface.OnClickListener
{
  aylg(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aylf.a("0X800A5B5");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showDarkModeTips systemDarMode  = " + this.a);
    }
    aylf.a(true);
    aylf.a(this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aylg
 * JD-Core Version:    0.7.0.1
 */