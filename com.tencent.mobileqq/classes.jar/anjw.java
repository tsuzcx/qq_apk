import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class anjw
  implements DialogInterface.OnCancelListener
{
  anjw(anjr paramanjr, Activity paramActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QLog.d("AccountIdentityManager", 1, "dialog cancel");
    anjr.a(this.jdField_a_of_type_Anjr, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjw
 * JD-Core Version:    0.7.0.1
 */