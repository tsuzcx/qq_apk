import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class aorm
  implements DialogInterface.OnDismissListener
{
  aorm(aori paramaori, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.d("AccountIdentityManager", 1, "dialog dismiss");
    aori.a(this.jdField_a_of_type_Aori, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorm
 * JD-Core Version:    0.7.0.1
 */