import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class bbtd
  extends aqxd
{
  long jdField_a_of_type_Long;
  alpa jdField_a_of_type_Alpa = null;
  bbtn jdField_a_of_type_Bbtn;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bbtd(QQAppInterface paramQQAppInterface, long paramLong, bbtn parambbtn)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bbtn = parambbtn;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Alpa = new bbte(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpa);
  }
  
  public int a()
  {
    return 3;
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bbtn.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Bbtn.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.e, this.jdField_a_of_type_Bbtn.g, this.jdField_a_of_type_Bbtn.h);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alpa != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtd
 * JD-Core Version:    0.7.0.1
 */