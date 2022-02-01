import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;

public class azof
{
  public static azoc a(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramazfe != null)
      {
        localObject1 = new azoc();
        ((azoc)localObject1).jdField_a_of_type_Boolean = a(paramQQAppInterface, paramazfe);
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label84;
        }
        i = 1;
      }
    }
    while ((i != 0) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramazfe = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramazfe.iNewCount > 0)
      {
        ((azoc)localObject1).b = true;
        ((azoc)localObject1).jdField_a_of_type_Int = paramazfe.iNewCount;
        return localObject1;
        label84:
        i = 0;
      }
      else
      {
        paramQQAppInterface = (axzw)paramQQAppInterface.getManager(160);
        if (!paramQQAppInterface.a(paramQQAppInterface.a(10016), false)) {
          break label140;
        }
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if ((paramazfe.iUpgradeCount > 0) || (i != 0))
      {
        ((azoc)localObject1).b = true;
        ((azoc)localObject1).jdField_a_of_type_Int = 0;
      }
      return localObject1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    if ((paramQQAppInterface == null) || (paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    while (((paramazfe.b) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString))) || (bgsg.W(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (bgjw.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azof
 * JD-Core Version:    0.7.0.1
 */