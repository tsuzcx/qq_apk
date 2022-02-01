import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.qphone.base.util.QLog;

class aywq
  extends ayln
{
  aywq(aywp paramaywp) {}
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePersonalityLabelComponent", 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    if ((((aymg)aywp.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (TextUtils.equals(paramString, ((aymg)aywp.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) && (paramInt == 0))
    {
      ((aymg)aywp.c(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel = paramPersonalityLabel;
      ((aymg)aywp.d(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.vPersonalityLabelV2 = paramArrayOfByte;
      aywp.a(this.a, ((aymg)aywp.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywq
 * JD-Core Version:    0.7.0.1
 */