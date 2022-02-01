import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atkj
  implements bkzq
{
  atkj(atki paramatki, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Atki.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(atki.a(this.jdField_a_of_type_Atki).uniseq, this.jdField_a_of_type_Atki.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Atki.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -1L) != -1) {
      ChatActivityUtils.a(this.jdField_a_of_type_Atki.jdField_a_of_type_AndroidContentContext, 2131718501, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.cancel();
      return;
      paramView = auea.a(this.jdField_a_of_type_Atki.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, atki.a(this.jdField_a_of_type_Atki));
      if (paramView.status == 16)
      {
        audr.a(2131692622);
        this.jdField_a_of_type_Bkzi.cancel();
        return;
      }
      atki.a(this.jdField_a_of_type_Atki).status = 1002;
      auea.a(this.jdField_a_of_type_Atki.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Atki.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkj
 * JD-Core Version:    0.7.0.1
 */