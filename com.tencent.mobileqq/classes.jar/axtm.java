import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class axtm
  implements DialogInterface.OnClickListener
{
  axtm(axsv paramaxsv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((axsv.a(this.a) != null) && (axsv.a(this.a).isShowing()))
      {
        this.a.c();
        axsv.a(this.a).dismiss();
        axsv.a(this.a, null);
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
 * Qualified Name:     axtm
 * JD-Core Version:    0.7.0.1
 */