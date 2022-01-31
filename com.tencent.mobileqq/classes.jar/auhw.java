import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class auhw
  implements DialogInterface.OnClickListener
{
  auhw(auhi paramauhi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((auhi.a(this.a) != null) && (auhi.a(this.a).isShowing()))
      {
        auhi.a(this.a).dismiss();
        auhi.a(this.a, null);
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
 * Qualified Name:     auhw
 * JD-Core Version:    0.7.0.1
 */