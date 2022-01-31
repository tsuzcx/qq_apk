import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aqrh
  implements bhqd
{
  aqrh(aqrg paramaqrg, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Aqrg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aqrg.a(this.jdField_a_of_type_Aqrg).uniseq, this.jdField_a_of_type_Aqrg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqrg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L) != -1) {
      ChatActivityUtils.a(this.jdField_a_of_type_Aqrg.jdField_a_of_type_AndroidContentContext, 2131719744, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.cancel();
      return;
      paramView = arni.a(this.jdField_a_of_type_Aqrg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aqrg.a(this.jdField_a_of_type_Aqrg));
      if (paramView.status == 16)
      {
        armz.a(2131692939);
        this.jdField_a_of_type_Bhpy.cancel();
        return;
      }
      aqrg.a(this.jdField_a_of_type_Aqrg).status = 1002;
      arni.a(this.jdField_a_of_type_Aqrg.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Aqrg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrh
 * JD-Core Version:    0.7.0.1
 */