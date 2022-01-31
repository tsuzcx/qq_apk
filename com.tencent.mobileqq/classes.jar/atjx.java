import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class atjx
  implements DialogInterface.OnClickListener
{
  atjx(atjj paramatjj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((atjj.a(this.a) != null) && (atjj.a(this.a).isShowing()))
      {
        atjj.a(this.a).dismiss();
        atjj.a(this.a, null);
      }
      label42:
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "switch status cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atjx
 * JD-Core Version:    0.7.0.1
 */