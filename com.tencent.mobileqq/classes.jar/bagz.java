import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.qphone.base.util.QLog;

class bagz
  extends azwy
{
  bagz(bagy parambagy) {}
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePersonalityLabelComponent", 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    if ((((azxr)bagy.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (TextUtils.equals(paramString, ((azxr)bagy.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) && (paramInt == 0))
    {
      ((azxr)bagy.c(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel = paramPersonalityLabel;
      ((azxr)bagy.d(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.vPersonalityLabelV2 = paramArrayOfByte;
      bagy.a(this.a, ((azxr)bagy.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagz
 * JD-Core Version:    0.7.0.1
 */