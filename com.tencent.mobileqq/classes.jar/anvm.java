import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class anvm
  implements bbrm<apzg>
{
  anvm(anuq paramanuq, int paramInt, akfv paramakfv, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(apzg paramapzg, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.jdField_a_of_type_Int);
    if ((paramapzg != null) || (this.jdField_a_of_type_Int == 0))
    {
      paramObject.putInt("result", 0);
      this.jdField_a_of_type_Akfv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      bbrq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(this.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      bbrp.a("individual_v2_colorscreen_set_fail", "id:" + this.jdField_a_of_type_Int);
      paramObject.putInt("result", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvm
 * JD-Core Version:    0.7.0.1
 */