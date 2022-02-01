import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

final class bdxm
  implements DialogInterface.OnClickListener
{
  bdxm(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdxi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bdxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bdxi.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bdxi.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", MainFragment.b);
    paramDialogInterface.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxm
 * JD-Core Version:    0.7.0.1
 */