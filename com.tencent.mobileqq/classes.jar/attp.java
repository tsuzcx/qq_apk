import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

class attp
  implements DialogInterface.OnClickListener
{
  attp(attm paramattm, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbgu.dismiss();
    this.jdField_a_of_type_Attm.a.e();
    paramDialogInterface = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attp
 * JD-Core Version:    0.7.0.1
 */