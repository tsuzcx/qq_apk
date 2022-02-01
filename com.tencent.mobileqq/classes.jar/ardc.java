import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;

class ardc
  implements amea
{
  ardc(arcu paramarcu, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("apollo_apolloVipFlag", this.jdField_a_of_type_Int);
      localBundle.putInt("apollo_apolloVipLevel", this.jdField_b_of_type_Int);
      localBundle.putInt("apollo_result", 0);
      localBundle.putInt("apollo_partnerRoleId", this.jdField_c_of_type_Int);
      localBundle.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
      localBundle.putInt("apollo_previewAction", this.jdField_d_of_type_Int);
      localBundle.putBoolean("apollo_previewOnFrame", this.jdField_a_of_type_Boolean);
      localBundle.putString("apollo_id", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("title", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("subTitle", this.jdField_d_of_type_JavaLangString);
      localBundle.putBoolean("apollo_is_super_yellow", alnr.c());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    localBundle.putInt("apollo_result", 1);
    localBundle.putInt("apollo_audioId", paramInt);
    localBundle.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardc
 * JD-Core Version:    0.7.0.1
 */