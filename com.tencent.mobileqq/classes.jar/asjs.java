import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class asjs
  implements bhzw<auvw>
{
  asjs(asiw paramasiw, int paramInt, aogu paramaogu, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(auvw paramauvw, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.jdField_a_of_type_Int);
    if ((paramauvw != null) || (this.jdField_a_of_type_Int == 0))
    {
      paramObject.putInt("result", 0);
      this.jdField_a_of_type_Aogu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      biaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(this.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      bhzz.a("individual_v2_colorscreen_set_fail", "id:" + this.jdField_a_of_type_Int);
      paramObject.putInt("result", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjs
 * JD-Core Version:    0.7.0.1
 */