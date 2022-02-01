import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class aorn
  implements DialogInterface.OnCancelListener
{
  aorn(aori paramaori, Activity paramActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QLog.d("AccountIdentityManager", 1, "dialog cancel");
    aori.a(this.jdField_a_of_type_Aori, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorn
 * JD-Core Version:    0.7.0.1
 */