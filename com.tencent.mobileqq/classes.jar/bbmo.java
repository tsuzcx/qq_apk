import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bbmo
  extends amab
{
  bbmo(bbml parambbml) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Amab);
    if (this.a.jdField_a_of_type_Bbmu != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Bbmu.b(paramInt2, "");
      }
      this.a.jdField_a_of_type_Bbmu = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Amab);
    if (this.a.jdField_a_of_type_Bbmu != null)
    {
      if (paramInt1 == 8)
      {
        this.a.jdField_a_of_type_Bbmu.b(0, paramString);
        this.a.a(paramString, true, "");
        ((alzf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString));
      }
      this.a.jdField_a_of_type_Bbmu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmo
 * JD-Core Version:    0.7.0.1
 */