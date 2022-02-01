import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class aywm
{
  public static aywj a(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramaymg != null)
      {
        localObject1 = new aywj();
        ((aywj)localObject1).jdField_a_of_type_Boolean = a(paramQQAppInterface, paramaymg);
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label84;
        }
        i = 1;
      }
    }
    while ((i != 0) && (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramaymg = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramaymg.iNewCount > 0)
      {
        ((aywj)localObject1).b = true;
        ((aywj)localObject1).jdField_a_of_type_Int = paramaymg.iNewCount;
        return localObject1;
        label84:
        i = 0;
      }
      else
      {
        paramQQAppInterface = (axfy)paramQQAppInterface.getManager(160);
        if (!paramQQAppInterface.a(paramQQAppInterface.a(10016), false)) {
          break label140;
        }
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if ((paramaymg.iUpgradeCount > 0) || (i != 0))
      {
        ((aywj)localObject1).b = true;
        ((aywj)localObject1).jdField_a_of_type_Int = 0;
      }
      return localObject1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    if ((paramQQAppInterface == null) || (paramaymg == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    while (((paramaymg.b) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramaymg.jdField_a_of_type_JavaLangString))) || (bfyz.X(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) || (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (bftf.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywm
 * JD-Core Version:    0.7.0.1
 */