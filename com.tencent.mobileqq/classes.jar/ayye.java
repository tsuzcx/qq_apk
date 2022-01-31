import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class ayye
  implements DialogInterface.OnClickListener
{
  public ayye(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_Bafb.isShowing()) {
      this.a.jdField_a_of_type_Bafb.dismiss();
    }
    if (!badq.g(this.a.jdField_a_of_type_AndroidContentContext)) {
      this.a.jdField_a_of_type_Bafb.show();
    }
    do
    {
      return;
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    } while (ReciteRecordLayout.a(this.a) == null);
    ReciteRecordLayout.a(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayye
 * JD-Core Version:    0.7.0.1
 */