import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

public class awjp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public awjp(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo();
    }
  }
  
  private void c()
  {
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, 1);
    bdla.b(null, "CliOper", "", "", "0X800A763", "0X800A763", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      aftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().setCanLock(false);
    }
    ahpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407F", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationSheet", 2, new Object[] { "show: invoked. ", " sessionInfo: ", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo });
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    Object localObject = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afzr)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) && (!((anvk)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))))
    {
      d();
      return;
    }
    localObject = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    ((bkzi)localObject).a(2131718505, 0);
    ((bkzi)localObject).a(2131718778, 0);
    ((bkzi)localObject).c(2131690697);
    ((bkzi)localObject).a(new awjq(this, (bkzi)localObject));
    ((bkzi)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjp
 * JD-Core Version:    0.7.0.1
 */