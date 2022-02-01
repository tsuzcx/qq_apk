import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

class aypc
  implements DialogInterface.OnClickListener
{
  aypc(ayoz paramayoz, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bhpc.dismiss();
    this.jdField_a_of_type_Ayoz.a.e();
    paramDialogInterface = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypc
 * JD-Core Version:    0.7.0.1
 */