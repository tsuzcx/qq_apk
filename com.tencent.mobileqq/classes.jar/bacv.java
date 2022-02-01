import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileGameInfo;
import com.tencent.qphone.base.util.QLog;

class bacv
  extends aofu
{
  bacv(bacu parambacu) {}
  
  protected void onGetMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "onGetMemberGameCardSwitch.isSuccess = " + paramBoolean + ", errCode = " + paramLong3);
    }
    if ((!paramBoolean) || (bacu.a(this.a) == null) || (((azrb)bacu.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!((azrb)bacu.c(this.a)).jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong1))) || (!((azrb)bacu.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong2)))) {}
    while (!bacu.a(this.a)) {
      return;
    }
    bacu.a(this.a, String.valueOf(paramLong1), String.valueOf(paramLong2));
  }
  
  protected void onGetTroopMemberGameCard(boolean paramBoolean, String paramString1, String paramString2, ProfileGameInfo paramProfileGameInfo)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onGetTroopMemberGameCard.isSuccess = ").append(paramBoolean).append(", hasProfileGameInfo = ");
      if (paramProfileGameInfo != null)
      {
        bool = true;
        QLog.d("ProfileTroopMemGameInfoComponent", 2, bool);
      }
    }
    else
    {
      if ((paramBoolean) && (bacu.e(this.a) != null) && (((azrb)bacu.f(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((azrb)bacu.g(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramString2)))) {
        break label114;
      }
    }
    label114:
    do
    {
      return;
      bool = false;
      break;
      bacu.a(this.a, paramProfileGameInfo);
      bacu.a(this.a, true);
    } while (TextUtils.isEmpty(bgfz.a()));
    bacu.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacv
 * JD-Core Version:    0.7.0.1
 */