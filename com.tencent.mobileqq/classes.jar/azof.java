import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class azof
  extends akil
{
  azof(azoc paramazoc) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Akil);
    if (this.a.jdField_a_of_type_Azol != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Azol.b(paramInt2, "");
      }
      this.a.jdField_a_of_type_Azol = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Akil);
    if (this.a.jdField_a_of_type_Azol != null)
    {
      if (paramInt1 == 8)
      {
        this.a.jdField_a_of_type_Azol.b(0, paramString);
        this.a.a(paramString, true, "");
        ((akhp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString));
      }
      this.a.jdField_a_of_type_Azol = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azof
 * JD-Core Version:    0.7.0.1
 */