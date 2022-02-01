import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class azge
  implements DialogInterface.OnClickListener
{
  azge(azfn paramazfn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((azfn.a(this.a) != null) && (azfn.a(this.a).isShowing()))
      {
        this.a.c();
        azfn.a(this.a).dismiss();
        azfn.a(this.a, null);
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
 * Qualified Name:     azge
 * JD-Core Version:    0.7.0.1
 */