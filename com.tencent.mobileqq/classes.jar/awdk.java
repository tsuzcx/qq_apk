import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class awdk
  implements DialogInterface.OnClickListener
{
  awdk(awcx paramawcx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((awcx.a(this.a) != null) && (awcx.a(this.a).isShowing()))
      {
        awcx.a(this.a).dismiss();
        awcx.a(this.a, null);
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
 * Qualified Name:     awdk
 * JD-Core Version:    0.7.0.1
 */