import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class ankf
  implements DialogInterface.OnCancelListener
{
  ankf(anjz paramanjz) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    anjz.a(this.a, null);
    QLog.d("AccountPhoneUnityManager", 1, "dialog cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankf
 * JD-Core Version:    0.7.0.1
 */