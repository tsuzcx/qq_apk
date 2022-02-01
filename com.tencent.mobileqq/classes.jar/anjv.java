import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class anjv
  implements DialogInterface.OnDismissListener
{
  anjv(anjr paramanjr, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.d("AccountIdentityManager", 1, "dialog dismiss");
    anjr.a(this.jdField_a_of_type_Anjr, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjv
 * JD-Core Version:    0.7.0.1
 */