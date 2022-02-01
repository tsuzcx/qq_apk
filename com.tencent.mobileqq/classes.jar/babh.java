import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class babh
{
  public static babe a(QQAppInterface paramQQAppInterface, azrb paramazrb)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramazrb != null)
      {
        localObject1 = new babe();
        ((babe)localObject1).jdField_a_of_type_Boolean = a(paramQQAppInterface, paramazrb);
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label84;
        }
        i = 1;
      }
    }
    while ((i != 0) && (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramazrb = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramazrb.iNewCount > 0)
      {
        ((babe)localObject1).b = true;
        ((babe)localObject1).jdField_a_of_type_Int = paramazrb.iNewCount;
        return localObject1;
        label84:
        i = 0;
      }
      else
      {
        paramQQAppInterface = (aymd)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        if (!paramQQAppInterface.a(paramQQAppInterface.a(10016), false)) {
          break label140;
        }
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if ((paramazrb.iUpgradeCount > 0) || (i != 0))
      {
        ((babe)localObject1).b = true;
        ((babe)localObject1).jdField_a_of_type_Int = 0;
      }
      return localObject1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, azrb paramazrb)
  {
    if ((paramQQAppInterface == null) || (paramazrb == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    while (((paramazrb.b) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramazrb.jdField_a_of_type_JavaLangString))) || (bhhr.X(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (bhbx.b(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babh
 * JD-Core Version:    0.7.0.1
 */