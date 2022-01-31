import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class asrv
  implements DialogInterface.OnClickListener
{
  asrv(asrp paramasrp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    asrp.a(this.a);
    QLog.d("PresenceInterfaceImpl", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrv
 * JD-Core Version:    0.7.0.1
 */