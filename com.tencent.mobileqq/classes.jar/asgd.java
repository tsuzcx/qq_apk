import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class asgd
  implements bjoe
{
  asgd(asgc paramasgc, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Asgc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(asgc.a(this.jdField_a_of_type_Asgc).uniseq, this.jdField_a_of_type_Asgc.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Asgc.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -1L) != -1) {
      ChatActivityUtils.a(this.jdField_a_of_type_Asgc.jdField_a_of_type_AndroidContentContext, 2131718116, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.cancel();
      return;
      paramView = aszt.a(this.jdField_a_of_type_Asgc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, asgc.a(this.jdField_a_of_type_Asgc));
      if (paramView.status == 16)
      {
        aszk.a(2131692520);
        this.jdField_a_of_type_Bjnw.cancel();
        return;
      }
      asgc.a(this.jdField_a_of_type_Asgc).status = 1002;
      aszt.a(this.jdField_a_of_type_Asgc.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Asgc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgd
 * JD-Core Version:    0.7.0.1
 */