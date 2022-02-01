import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView;
import com.tencent.qphone.base.util.QLog;

class bggg
  implements bgfy
{
  public BaseChatItemLayout a;
  public String a;
  
  private bggg(bgge parambgge) {}
  
  public void a(Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a == null)) {}
    do
    {
      return;
      if (paramObject == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setTroopMemberGradeLevel(null);
      }
      if ((paramObject instanceof MemberGradeLevelInfo)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemGradeLevelBuilder", 2, "onResult object is not instanceof MemberGradeLevelInfo");
    return;
    paramObject = (MemberGradeLevelInfo)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setTroopMemberGradeLevel(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggg
 * JD-Core Version:    0.7.0.1
 */