import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class aytq
{
  public static String a(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    if ((paramQQAppInterface == null) || (paramaymg == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    return a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface.getAppid(), "android-8.4.8", paramaymg.jdField_a_of_type_JavaLangString, aywm.a(paramQQAppInterface, paramaymg));
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, String paramString3, aywj paramaywj)
  {
    paramString1 = String.format("https://ti.qq.com/qcard/profile?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2 = paramString1 + "&troopUin=" + paramString3;
    }
    paramString1 = paramString2;
    if (bfrj.b()) {
      paramString1 = paramString2 + "&intl=1";
    }
    paramString2 = paramString1;
    if (paramaywj != null)
    {
      paramString2 = paramString1;
      if (paramaywj.jdField_a_of_type_Boolean) {
        paramString2 = paramString1 + "&mwentry=1";
      }
      paramString1 = paramString2;
      if (paramaywj.jdField_b_of_type_Boolean) {
        paramString1 = paramString2 + "&mwredpoint=1";
      }
      paramString2 = paramString1;
      if (paramaywj.jdField_a_of_type_Int > 1) {
        paramString2 = paramString1 + "&mwredpointnum=" + paramaywj.jdField_a_of_type_Int;
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
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, aymg paramaymg)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramaymg == null)) {
      return;
    }
    BusinessCard localBusinessCard = aphs.a(paramQQAppInterface, paramaymg);
    paramQQAppInterface = bfrj.a(new Intent(paramActivity, FriendProfileMoreInfoActivity.class), paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface, paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    paramQQAppInterface.putExtra("profile_entry_type", paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
    paramQQAppInterface.putExtra("troopUin", paramaymg.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("memberUin", paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("isTroopMemberCard", paramaymg.jdField_b_of_type_Boolean);
    paramQQAppInterface.putExtra("extendFriendEntryAddFriend", paramaymg.jdField_b_of_type_Int);
    paramActivity.startActivityForResult(paramQQAppInterface, 1022);
  }
  
  public static boolean a(aymg paramaymg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaymg != null)
    {
      bool1 = bool2;
      if (paramaymg.jdField_a_of_type_Long == aymn.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.b(paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytq
 * JD-Core Version:    0.7.0.1
 */