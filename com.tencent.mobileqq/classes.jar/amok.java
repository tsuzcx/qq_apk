import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import java.util.List;

class amok
  implements View.OnClickListener
{
  amok(amoj paramamoj, MessageForTroopConfess paramMessageForTroopConfess) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.items != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.items.isEmpty())) {
      amom.a(this.jdField_a_of_type_Amoj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amoj.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_Amoj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.getConfessTopicId(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.confessorUin), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.getConfessToUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amok
 * JD-Core Version:    0.7.0.1
 */