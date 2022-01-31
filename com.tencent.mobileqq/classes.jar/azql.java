import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class azql
  extends aozw
{
  long jdField_a_of_type_Long;
  ajsy jdField_a_of_type_Ajsy = null;
  azqv jdField_a_of_type_Azqv;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public azql(QQAppInterface paramQQAppInterface, long paramLong, azqv paramazqv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Azqv = paramazqv;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajsy = new azqm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
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
    if (this.jdField_a_of_type_Azqv.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Azqv.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Azqv.e, this.jdField_a_of_type_Azqv.g, this.jdField_a_of_type_Azqv.h);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azql
 * JD-Core Version:    0.7.0.1
 */