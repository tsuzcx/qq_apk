import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class aypt
  extends aoiy
{
  long jdField_a_of_type_Long;
  ajey jdField_a_of_type_Ajey = null;
  ayqd jdField_a_of_type_Ayqd;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aypt(QQAppInterface paramQQAppInterface, long paramLong, ayqd paramayqd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayqd = paramayqd;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajey = new aypu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
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
    if (this.jdField_a_of_type_Ayqd.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Ayqd.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Ayqd.e, this.jdField_a_of_type_Ayqd.g, this.jdField_a_of_type_Ayqd.h);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajey != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aypt
 * JD-Core Version:    0.7.0.1
 */