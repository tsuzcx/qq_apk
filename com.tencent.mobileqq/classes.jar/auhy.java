import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class auhy
  implements DialogInterface.OnClickListener
{
  auhy(auhk paramauhk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((auhk.a(this.a) != null) && (auhk.a(this.a).isShowing()))
      {
        auhk.a(this.a).dismiss();
        auhk.a(this.a, null);
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
 * Qualified Name:     auhy
 * JD-Core Version:    0.7.0.1
 */