import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;

public class axzu
  extends axup
{
  private ayaa a;
  
  public axzu(long paramLong, axuq paramaxuq, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramaxuq, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Ayaa = new axzy(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Ayaa);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697883);
    this.jdField_a_of_type_Boolean = true;
    Friends localFriends = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    this.jdField_b_of_type_JavaLangString = axvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, false);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((axvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).b(8, localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new axzv(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    while (!paramBoolean) {
      return;
    }
    ((axvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).a(9);
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new axzx(this, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramOnlineStatusPermissionItem);
  }
  
  public void b()
  {
    Object localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    apzf localapzf = (apzf)apub.a().a(652);
    if ((localapzf != null) && (localapzf.a != null) && (!TextUtils.isEmpty(localapzf.a.jdField_a_of_type_JavaLangString)) && (axvv.a((Friends)localObject)))
    {
      localObject = localapzf.a.jdField_a_of_type_JavaLangString + ((Friends)localObject).adCode;
      axyg.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject, 4015);
      axvz.a("0X800AF98");
    }
  }
  
  protected void d()
  {
    super.d();
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new axzw(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzu
 * JD-Core Version:    0.7.0.1
 */