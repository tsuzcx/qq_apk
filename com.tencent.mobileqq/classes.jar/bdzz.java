import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bdzz
  extends andd
{
  bdzz(bdzw parambdzw) {}
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Andd);
    if (this.a.jdField_a_of_type_Beaf != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Beaf.onInviteComplete(paramInt2, "");
      }
      this.a.jdField_a_of_type_Beaf = null;
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Andd);
    if (paramInt1 == 8)
    {
      if (this.a.jdField_a_of_type_Beaf != null) {
        this.a.jdField_a_of_type_Beaf.onInviteComplete(0, paramString);
      }
      this.a.a(paramString, true, "");
      ((anca)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).b(Long.parseLong(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzz
 * JD-Core Version:    0.7.0.1
 */