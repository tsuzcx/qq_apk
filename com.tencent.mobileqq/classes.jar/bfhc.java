import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bfhc
  extends aofu
{
  bfhc(bfgz parambfgz) {}
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Aofu);
    if (this.a.jdField_a_of_type_Bfhi != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_Bfhi.onInviteComplete(paramInt2, "");
      }
      this.a.jdField_a_of_type_Bfhi = null;
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Aofu);
    if (paramInt1 == 8)
    {
      if (this.a.jdField_a_of_type_Bfhi != null) {
        this.a.jdField_a_of_type_Bfhi.onInviteComplete(0, paramString);
      }
      this.a.a(paramString, true, "");
      ((aoep)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.parseLong(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhc
 * JD-Core Version:    0.7.0.1
 */