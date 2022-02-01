import android.content.Intent;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.manager.Manager;

public class awtl
  implements Manager
{
  public static String a;
  public static String b = "extra_notify_msg";
  public Intent a;
  public RecentItemPullActivePush a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForText jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QQ";
  }
  
  public awtl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush == null) {
      return 0;
    }
    return 1;
  }
  
  public MessageForText a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)bcsa.a(-1000));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msgtype = -1000;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop = 9653;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.isread = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = AppConstants.PULL_ACTIVE_PUSH_UIN;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = AppConstants.PULL_ACTIVE_PUSH_UIN;
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = this.jdField_a_of_type_AndroidContentIntent.getStringExtra(b);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.time;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.mTitleName))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.mTitleName;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.time) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.time;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush = null;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush == null)
    {
      localObject = new RecentUser(AppConstants.PULL_ACTIVE_PUSH_UIN, 9653);
      ((RecentUser)localObject).msgType = -1000;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush = new RecentItemPullActivePush((RecentUser)localObject);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = paramIntent.getStringExtra(b);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.a((String)localObject, l);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtl
 * JD-Core Version:    0.7.0.1
 */