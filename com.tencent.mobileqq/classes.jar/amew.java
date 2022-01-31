import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;

class amew
  implements DialogInterface.OnClickListener
{
  amew(amev paramamev, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("back_for_hidden_chat", true);
    paramDialogInterface.setFlags(603979776);
    HiddenChatFragment.a(this.jdField_a_of_type_AndroidAppActivity, 3, 0, paramDialogInterface);
    azmj.b(this.jdField_a_of_type_Amev.a, "dc00898", "", "", "0X800A34A", "0X800A34A", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amew
 * JD-Core Version:    0.7.0.1
 */