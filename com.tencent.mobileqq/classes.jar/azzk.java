import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class azzk
  implements DialogInterface.OnClickListener
{
  public azzk(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_Bbgu.isShowing()) {
      this.a.jdField_a_of_type_Bbgu.dismiss();
    }
    if (!bbfj.g(this.a.jdField_a_of_type_AndroidContentContext)) {
      this.a.jdField_a_of_type_Bbgu.show();
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
 * Qualified Name:     azzk
 * JD-Core Version:    0.7.0.1
 */