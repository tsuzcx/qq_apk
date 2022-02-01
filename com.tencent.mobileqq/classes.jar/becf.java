import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class becf
  extends ashp
{
  long jdField_a_of_type_Long;
  amop jdField_a_of_type_Amop = null;
  becp jdField_a_of_type_Becp;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public becf(QQAppInterface paramQQAppInterface, long paramLong, becp parambecp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Becp = parambecp;
    this.jdField_a_of_type_Long = paramLong;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Amop = new becg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amop);
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amop != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amop);
    }
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_Becp.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Becp.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Becp.e, this.jdField_a_of_type_Becp.g, this.jdField_a_of_type_Becp.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becf
 * JD-Core Version:    0.7.0.1
 */