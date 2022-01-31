import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class bbou
  extends aqsu
{
  long jdField_a_of_type_Long;
  alkl jdField_a_of_type_Alkl = null;
  bbpe jdField_a_of_type_Bbpe;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bbou(QQAppInterface paramQQAppInterface, long paramLong, bbpe parambbpe)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bbpe = parambbpe;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Alkl = new bbov(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
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
    if (this.jdField_a_of_type_Bbpe.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Bbpe.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.e, this.jdField_a_of_type_Bbpe.g, this.jdField_a_of_type_Bbpe.h);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbou
 * JD-Core Version:    0.7.0.1
 */