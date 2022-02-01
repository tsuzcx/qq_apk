import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class azmp
{
  public static String a(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    if ((paramQQAppInterface == null) || (paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    return a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface.getAppid(), "android-8.4.1", paramazfe.jdField_a_of_type_JavaLangString, azof.a(paramQQAppInterface, paramazfe));
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, String paramString3, azoc paramazoc)
  {
    paramString1 = String.format("https://ti.qq.com/qcard/profile?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2 = paramString1 + "&troopUin=" + paramString3;
    }
    paramString1 = paramString2;
    if (bghy.b()) {
      paramString1 = paramString2 + "&intl=1";
    }
    paramString2 = paramString1;
    if (paramazoc != null)
    {
      paramString2 = paramString1;
      if (paramazoc.jdField_a_of_type_Boolean) {
        paramString2 = paramString1 + "&mwentry=1";
      }
      paramString1 = paramString2;
      if (paramazoc.jdField_b_of_type_Boolean) {
        paramString1 = paramString2 + "&mwredpoint=1";
      }
      paramString2 = paramString1;
      if (paramazoc.jdField_a_of_type_Int > 1) {
        paramString2 = paramString1 + "&mwredpointnum=" + paramazoc.jdField_a_of_type_Int;
      }
    }
    return paramString2;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, BaseApplication.getContext().getString(paramInt2));
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, azfe paramazfe)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramazfe == null)) {
      return;
    }
    BusinessCard localBusinessCard = aqaj.a(paramQQAppInterface, paramazfe);
    paramQQAppInterface = bghy.a(new Intent(paramActivity, FriendProfileMoreInfoActivity.class), paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface, paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    paramQQAppInterface.putExtra("profile_entry_type", paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
    paramQQAppInterface.putExtra("troopUin", paramazfe.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("memberUin", paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("isTroopMemberCard", paramazfe.jdField_b_of_type_Boolean);
    paramQQAppInterface.putExtra("extendFriendEntryAddFriend", paramazfe.jdField_b_of_type_Int);
    paramActivity.startActivityForResult(paramQQAppInterface, 1022);
  }
  
  public static boolean a(azfe paramazfe)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazfe != null)
    {
      bool1 = bool2;
      if (paramazfe.jdField_a_of_type_Long == azfl.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.b(paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmp
 * JD-Core Version:    0.7.0.1
 */