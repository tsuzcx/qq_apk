import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ascf
  extends aryv
{
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  
  public ascf(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    super.a();
    AbsStructMsg localAbsStructMsg = azvd.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = azvd.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("struct_msg_show_in_dialog"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localAbsStructMsg);
    }
    return true;
  }
  
  protected boolean a(bdjz parambdjz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      parambdjz.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(aepi.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aepi.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aepi.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardRecommendFriendOption", 2, "updateImageView addStructView");
        }
        parambdjz.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B34", "0X8005B34", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.d();
      return;
      if (i == 84) {
        if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("pa_type", -1) == 53) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007018", "0X8007018", 0, 0, "", "", "", "");
        } else {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007169", "0X8007169", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  protected void r()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B35", "0X8005B35", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.r();
      return;
      if (i == 84) {
        if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("pa_type", -1) == 53) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007017", "0X8007017", 0, 0, "", "", "", "");
        } else {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800716A", "0X800716A", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascf
 * JD-Core Version:    0.7.0.1
 */