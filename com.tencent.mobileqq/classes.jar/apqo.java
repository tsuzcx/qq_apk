import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;

class apqo
  implements aled
{
  apqo(apqh paramapqh, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    int i;
    if (paramBoolean) {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramArrayOfInt = ((aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramArrayOfInt == null) {
          break label231;
        }
        i = paramArrayOfInt.apolloVipFlag;
        paramInt2 = paramArrayOfInt.apolloVipLevel;
      }
    }
    for (;;)
    {
      paramString.putInt("apollo_apolloVipFlag", i);
      paramString.putInt("apollo_apolloVipLevel", paramInt2);
      paramString.putBoolean("apollo_is_super_yellow", aknx.c());
      paramString.putInt("apollo_result", 0);
      paramString.putInt("apollo_partnerRoleId", paramInt1);
      paramString.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
      paramString.putInt("apollo_previewAction", this.jdField_b_of_type_Int);
      paramString.putBoolean("apollo_previewOnFrame", this.jdField_a_of_type_Boolean);
      paramString.putString("apollo_id", this.jdField_b_of_type_JavaLangString);
      paramString.putString("title", this.c);
      paramString.putString("subTitle", this.d);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      paramString.putInt("apollo_result", 1);
      paramString.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      label231:
      paramInt2 = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqo
 * JD-Core Version:    0.7.0.1
 */