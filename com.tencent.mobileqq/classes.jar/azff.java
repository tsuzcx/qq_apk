import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class azff
{
  public azff(AccountOnlineStateActivity paramAccountOnlineStateActivity, boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    bhlq.a(AccountOnlineStateActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountOnlineStateActivity), 2131697714, 2131697715);
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
 * Qualified Name:     azff
 * JD-Core Version:    0.7.0.1
 */