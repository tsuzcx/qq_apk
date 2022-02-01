import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class beto
  extends atdl
{
  long jdField_a_of_type_Long;
  anif jdField_a_of_type_Anif = null;
  bety jdField_a_of_type_Bety;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public beto(QQAppInterface paramQQAppInterface, long paramLong, bety parambety)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bety = parambety;
    this.jdField_a_of_type_Long = paramLong;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Anif = new betp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anif);
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anif != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anif);
    }
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bety.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Bety.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Bety.e, this.jdField_a_of_type_Bety.g, this.jdField_a_of_type_Bety.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beto
 * JD-Core Version:    0.7.0.1
 */