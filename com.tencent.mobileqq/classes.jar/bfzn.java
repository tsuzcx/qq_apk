import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class bfzn
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private long b;
  
  public bfzn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    long l;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Int != paramTroopInfo.wMemberNum) {
          return false;
        }
        l = System.currentTimeMillis();
        if (paramTroopInfo.wMemberNum > 500) {
          break;
        }
      } while (l - this.b < 180000L);
      return false;
    } while (l - this.b < 1800000L);
    return false;
  }
  
  public void a(String paramString)
  {
    aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((localaoep != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localaoep.a(true, paramString, localTroopInfo.troopcode, true, 2, this.jdField_a_of_type_Long, 0);
      this.jdField_a_of_type_Int = localTroopInfo.wMemberNum;
      this.b = System.currentTimeMillis();
    }
  }
  
  public boolean a(String paramString)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzn
 * JD-Core Version:    0.7.0.1
 */