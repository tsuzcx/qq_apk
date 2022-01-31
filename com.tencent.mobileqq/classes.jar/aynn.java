import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aynn
  extends ajuc
{
  aynn(aynk paramaynk) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ajuc);
    if (this.a.jdField_a_of_type_Aynt != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Aynt.b(paramInt2, "");
      }
      this.a.jdField_a_of_type_Aynt = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ajuc);
    if (this.a.jdField_a_of_type_Aynt != null)
    {
      if (paramInt1 == 8)
      {
        this.a.jdField_a_of_type_Aynt.b(0, paramString);
        this.a.a(paramString, true, "");
        ((ajtg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString));
      }
      this.a.jdField_a_of_type_Aynt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aynn
 * JD-Core Version:    0.7.0.1
 */