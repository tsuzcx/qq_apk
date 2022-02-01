import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bfqp
  extends aojs
{
  bfqp(bfqm parambfqm) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Aojs);
    if (this.a.jdField_a_of_type_Bfqv != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Bfqv.b(paramInt2, "");
      }
      this.a.jdField_a_of_type_Bfqv = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Aojs);
    if (paramInt1 == 8)
    {
      if (this.a.jdField_a_of_type_Bfqv != null) {
        this.a.jdField_a_of_type_Bfqv.b(0, paramString);
      }
      this.a.a(paramString, true, "");
      ((aoip)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqp
 * JD-Core Version:    0.7.0.1
 */