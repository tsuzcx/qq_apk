import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class aomx
  implements DialogInterface.OnDismissListener
{
  aomx(aoms paramaoms) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    aoms.a(this.a, null);
    QLog.d("AccountPhoneUnityManager", 1, "dialog dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomx
 * JD-Core Version:    0.7.0.1
 */