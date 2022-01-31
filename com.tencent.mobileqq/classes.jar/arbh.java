import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class arbh
  implements DialogInterface.OnClickListener
{
  arbh(arbb paramarbb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    arbb.a(this.a);
    QLog.d("PresenceInterfaceImpl", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbh
 * JD-Core Version:    0.7.0.1
 */