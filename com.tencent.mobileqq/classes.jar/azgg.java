import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;

public class azgg
  extends azba
{
  private azgm a;
  
  public azgg(long paramLong, azbb paramazbb, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Azgm = new azgk(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Azgm);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698166);
    this.jdField_a_of_type_Boolean = true;
    Friends localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    this.jdField_b_of_type_JavaLangString = azch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, false);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((azbv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).b(8, localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azgh(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    while (!paramBoolean) {
      return;
    }
    ((azbv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(9);
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramBoolean)
    {
      a(paramOnlineStatusPermissionItem);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azgj(this, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramOnlineStatusPermissionItem);
  }
  
  public void b()
  {
    Object localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    arci localarci = (arci)aqxe.a().a(652);
    if ((localarci != null) && (localarci.a != null) && (!TextUtils.isEmpty(localarci.a.jdField_a_of_type_JavaLangString)) && (azch.a((Friends)localObject)))
    {
      localObject = localarci.a.jdField_a_of_type_JavaLangString + ((Friends)localObject).adCode;
      azes.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject, 4015);
      azcl.a("0X800AF98");
    }
  }
  
  protected void d()
  {
    super.d();
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azgi(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azgm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgg
 * JD-Core Version:    0.7.0.1
 */