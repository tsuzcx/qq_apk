import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ayzx
  implements DialogInterface.OnClickListener
{
  ayzx(ayzg paramayzg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((ayzg.a(this.a) != null) && (ayzg.a(this.a).isShowing()))
      {
        this.a.c();
        ayzg.a(this.a).dismiss();
        ayzg.a(this.a, null);
      }
      label49:
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "switch status cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzx
 * JD-Core Version:    0.7.0.1
 */