import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;

public class bgwz
  implements DialogInterface.OnClickListener
{
  public bgwz(UpgradeDetailActivity paramUpgradeDetailActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bgvx.a().b(false);
      paramDialogInterface.dismiss();
      UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeActivityUpgradeDetailActivity, this.jdField_a_of_type_Int, 3);
      return;
    }
    UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeActivityUpgradeDetailActivity, this.jdField_a_of_type_ComTencentMobileqqUpgradeActivityUpgradeDetailActivity, this.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
    UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeActivityUpgradeDetailActivity, this.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwz
 * JD-Core Version:    0.7.0.1
 */