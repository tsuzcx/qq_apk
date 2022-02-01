import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class bafb
{
  public static String a(QQAppInterface paramQQAppInterface, azxr paramazxr)
  {
    if ((paramQQAppInterface == null) || (paramazxr == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    return a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface.getAppid(), "android-8.4.5", paramazxr.jdField_a_of_type_JavaLangString, bagv.a(paramQQAppInterface, paramazxr));
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, String paramString3, bags parambags)
  {
    paramString1 = String.format("https://ti.qq.com/qcard/profile?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2 = paramString1 + "&troopUin=" + paramString3;
    }
    paramString1 = paramString2;
    if (bhhz.b()) {
      paramString1 = paramString2 + "&intl=1";
    }
    paramString2 = paramString1;
    if (parambags != null)
    {
      paramString2 = paramString1;
      if (parambags.jdField_a_of_type_Boolean) {
        paramString2 = paramString1 + "&mwentry=1";
      }
      paramString1 = paramString2;
      if (parambags.jdField_b_of_type_Boolean) {
        paramString1 = paramString2 + "&mwredpoint=1";
      }
      paramString2 = paramString1;
      if (parambags.jdField_a_of_type_Int > 1) {
        paramString2 = paramString1 + "&mwredpointnum=" + parambags.jdField_a_of_type_Int;
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
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, azxr paramazxr)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramazxr == null)) {
      return;
    }
    BusinessCard localBusinessCard = aqoj.a(paramQQAppInterface, paramazxr);
    paramQQAppInterface = bhhz.a(new Intent(paramActivity, FriendProfileMoreInfoActivity.class), paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface, paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    paramQQAppInterface.putExtra("profile_entry_type", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
    paramQQAppInterface.putExtra("troopUin", paramazxr.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("memberUin", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("isTroopMemberCard", paramazxr.jdField_b_of_type_Boolean);
    paramQQAppInterface.putExtra("extendFriendEntryAddFriend", paramazxr.jdField_b_of_type_Int);
    paramActivity.startActivityForResult(paramQQAppInterface, 1022);
  }
  
  public static boolean a(azxr paramazxr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazxr != null)
    {
      bool1 = bool2;
      if (paramazxr.jdField_a_of_type_Long == azxy.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (anyw)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.b(paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafb
 * JD-Core Version:    0.7.0.1
 */