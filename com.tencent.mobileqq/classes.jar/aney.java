import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class aney
  implements bapb<aphb>
{
  aney(aned paramaned, int paramInt, ajrm paramajrm, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(aphb paramaphb, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.jdField_a_of_type_Int);
    if ((paramaphb != null) || (this.jdField_a_of_type_Int == 0))
    {
      paramObject.putInt("result", 0);
      this.jdField_a_of_type_Ajrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      bapf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(this.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      bape.a("individual_v2_colorscreen_set_fail", "id:" + this.jdField_a_of_type_Int);
      paramObject.putInt("result", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aney
 * JD-Core Version:    0.7.0.1
 */