import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class avvp
  implements DialogInterface.OnClickListener
{
  avvp(avvj paramavvj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    avvj.a(this.a);
    QLog.d("PresenceInterfaceImpl", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvp
 * JD-Core Version:    0.7.0.1
 */