import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.UUID;

class atkq
  implements DialogInterface.OnClickListener
{
  atkq(atko paramatko, long paramLong, UUID paramUUID, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface = bgjh.a(this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      paramDialogInterface.b(paramDialogInterface.a(this.jdField_a_of_type_JavaUtilUUID));
      this.jdField_a_of_type_Atko.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().onCurrentMessageDeleted(this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      return;
    }
    new bfis(this.jdField_a_of_type_Long, this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkq
 * JD-Core Version:    0.7.0.1
 */