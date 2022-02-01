import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class bfji
  extends atlv
{
  long jdField_a_of_type_Long;
  anrc jdField_a_of_type_Anrc = null;
  bfjs jdField_a_of_type_Bfjs;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bfji(QQAppInterface paramQQAppInterface, long paramLong, bfjs parambfjs)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bfjs = parambfjs;
    this.jdField_a_of_type_Long = paramLong;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Anrc = new bfjj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anrc);
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anrc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrc);
    }
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bfjs.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Bfjs.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Bfjs.e, this.jdField_a_of_type_Bfjs.g, this.jdField_a_of_type_Bfjs.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfji
 * JD-Core Version:    0.7.0.1
 */