import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqzm
  implements View.OnClickListener
{
  aqzm(aqzl paramaqzl, MessageForTroopConfess paramMessageForTroopConfess) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.items != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.items.isEmpty())) {
      aqzo.a(this.jdField_a_of_type_Aqzl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqzl.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_Aqzl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.getConfessTopicId(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.confessorUin), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.getConfessToUin()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzm
 * JD-Core Version:    0.7.0.1
 */