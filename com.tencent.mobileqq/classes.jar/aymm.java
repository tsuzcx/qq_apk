import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class aymm
{
  public aymm(AccountOnlineStateActivity paramAccountOnlineStateActivity, boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    bglp.a(AccountOnlineStateActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountOnlineStateActivity), 2131697630, 2131697631);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    AccountOnlineStateActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountOnlineStateActivity).a(this.jdField_a_of_type_Boolean);
    AccountOnlineStateActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountOnlineStateActivity).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
    AccountOnlineStateActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountOnlineStateActivity).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymm
 * JD-Core Version:    0.7.0.1
 */