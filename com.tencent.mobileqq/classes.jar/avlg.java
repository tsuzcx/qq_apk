import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class avlg
  implements DialogInterface.OnClickListener
{
  avlg(avkt paramavkt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    auwz.a(this.a.a, 1032);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "openBindPhonePage");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlg
 * JD-Core Version:    0.7.0.1
 */