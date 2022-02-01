import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;

public class bagv
{
  public static bags a(QQAppInterface paramQQAppInterface, azxr paramazxr)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramazxr != null)
      {
        localObject1 = new bags();
        ((bags)localObject1).jdField_a_of_type_Boolean = a(paramQQAppInterface, paramazxr);
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label84;
        }
        i = 1;
      }
    }
    while ((i != 0) && (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramazxr = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramazxr.iNewCount > 0)
      {
        ((bags)localObject1).b = true;
        ((bags)localObject1).jdField_a_of_type_Int = paramazxr.iNewCount;
        return localObject1;
        label84:
        i = 0;
      }
      else
      {
        paramQQAppInterface = (aysq)paramQQAppInterface.getManager(160);
        if (!paramQQAppInterface.a(paramQQAppInterface.a(10016), false)) {
          break label140;
        }
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if ((paramazxr.iUpgradeCount > 0) || (i != 0))
      {
        ((bags)localObject1).b = true;
        ((bags)localObject1).jdField_a_of_type_Int = 0;
      }
      return localObject1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, azxr paramazxr)
  {
    if ((paramQQAppInterface == null) || (paramazxr == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    while (((paramazxr.b) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString))) || (bhsi.W(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (bhjx.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagv
 * JD-Core Version:    0.7.0.1
 */