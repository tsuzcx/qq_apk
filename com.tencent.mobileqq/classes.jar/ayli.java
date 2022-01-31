import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class ayli
  implements DialogInterface.OnClickListener
{
  ayli(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aylh.a("0X800A5B5");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showDarkModeTips systemDarMode  = " + this.a);
    }
    aylh.a(true);
    aylh.a(this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayli
 * JD-Core Version:    0.7.0.1
 */