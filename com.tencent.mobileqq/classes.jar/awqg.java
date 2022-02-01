import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

public class awqg
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public awqg(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
  }
  
  private void c()
  {
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    bdll.b(null, "CliOper", "", "", "0X800A763", "0X800A763", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
    }
    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407F", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationSheet", 2, new Object[] { "show: invoked. ", " sessionInfo: ", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo });
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    Object localObject = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijc)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!((anyw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      d();
      return;
    }
    localObject = blir.a(this.jdField_a_of_type_AndroidContentContext);
    ((blir)localObject).a(2131717882, 0);
    ((blir)localObject).a(2131718151, 0);
    ((blir)localObject).c(2131690580);
    ((blir)localObject).a(new awqh(this, (blir)localObject));
    ((blir)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqg
 * JD-Core Version:    0.7.0.1
 */