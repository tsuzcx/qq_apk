import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.qphone.base.util.QLog;

class babl
  extends azqi
{
  babl(babk parambabk) {}
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePersonalityLabelComponent", 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    if ((((azrb)babk.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (TextUtils.equals(paramString, ((azrb)babk.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) && (paramInt == 0))
    {
      ((azrb)babk.c(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel = paramPersonalityLabel;
      ((azrb)babk.d(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.vPersonalityLabelV2 = paramArrayOfByte;
      babk.a(this.a, ((azrb)babk.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babl
 * JD-Core Version:    0.7.0.1
 */