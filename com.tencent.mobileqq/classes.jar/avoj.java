import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class avoj
  implements DialogInterface.OnClickListener
{
  avoj(avod paramavod) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    avod.a(this.a);
    QLog.d("PresenceInterfaceImpl", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avoj
 * JD-Core Version:    0.7.0.1
 */