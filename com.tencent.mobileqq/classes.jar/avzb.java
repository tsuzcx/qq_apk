import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class avzb
  implements DialogInterface.OnClickListener
{
  avzb(avyo paramavyo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((avyo.a(this.a) != null) && (avyo.a(this.a).isShowing()))
      {
        avyo.a(this.a).dismiss();
        avyo.a(this.a, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzb
 * JD-Core Version:    0.7.0.1
 */