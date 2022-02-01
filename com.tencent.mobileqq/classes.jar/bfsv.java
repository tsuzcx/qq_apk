import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class bfsv
  extends atvf
{
  long jdField_a_of_type_Long;
  anua jdField_a_of_type_Anua = null;
  bftf jdField_a_of_type_Bftf;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bfsv(QQAppInterface paramQQAppInterface, long paramLong, bftf parambftf)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bftf = parambftf;
    this.jdField_a_of_type_Long = paramLong;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Anua = new bfsw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anua != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    }
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bftf.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_Bftf.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_Bftf.e, this.jdField_a_of_type_Bftf.g, this.jdField_a_of_type_Bftf.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsv
 * JD-Core Version:    0.7.0.1
 */