import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class beri
  extends anxg
{
  beri(berf paramberf) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Anxg);
    if (this.a.jdField_a_of_type_Bero != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Bero.b(paramInt2, "");
      }
      this.a.jdField_a_of_type_Bero = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Anxg);
    if (paramInt1 == 8)
    {
      if (this.a.jdField_a_of_type_Bero != null) {
        this.a.jdField_a_of_type_Bero.b(0, paramString);
      }
      this.a.a(paramString, true, "");
      ((anwd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beri
 * JD-Core Version:    0.7.0.1
 */