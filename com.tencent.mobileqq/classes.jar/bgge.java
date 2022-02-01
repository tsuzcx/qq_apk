import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView;
import com.tencent.qphone.base.util.QLog;

public class bgge
{
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public bgge(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {}
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a;
      } while (localObject == null);
      if ((nty.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || ("1000000".equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin)) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopConfess)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemGradeLevelBuilder", 2, "handleMemberGradeLevel not need show");
        }
        ((TroopMemberGradeLevelView)localObject).setVisibility(8);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 1);
    if (!bhbt.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin))
    {
      ((TroopMemberGradeLevelView)localObject).setVisibility(8);
      return;
    }
    Object localObject = (bggg)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag(2131364559);
    if (localObject == null)
    {
      localObject = new bggg(this, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTag(2131364559, localObject);
    }
    for (;;)
    {
      ((bggg)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      ((bggg)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
      paramQQAppInterface = (bgfx)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAME_CARD_MANAGER);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, (bgfy)localObject);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopMemGradeLevelBuilder", 2, "troopGameCardManager is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgge
 * JD-Core Version:    0.7.0.1
 */