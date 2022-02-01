import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class anke
  implements DialogInterface.OnDismissListener
{
  anke(anjz paramanjz) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    anjz.a(this.a, null);
    QLog.d("AccountPhoneUnityManager", 1, "dialog dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anke
 * JD-Core Version:    0.7.0.1
 */