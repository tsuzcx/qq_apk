import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.11;
import com.tencent.mobileqq.location.ui.LocationShareFragment;

public class atml
  implements DialogInterface.OnClickListener
{
  public atml(LocationDialogUtil.11 param11) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = atln.a((QQAppInterface)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    paramDialogInterface.c(new atlh(this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString));
    paramDialogInterface.a(true);
    paramDialogInterface.a(this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString);
    LocationShareFragment.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atml
 * JD-Core Version:    0.7.0.1
 */