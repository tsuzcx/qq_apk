import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;

public class azmm
  extends azhh
{
  private azms a;
  
  public azmm(long paramLong, azhi paramazhi, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Azms = new azmq(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Azms);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697737);
    this.jdField_a_of_type_Boolean = true;
    Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    this.jdField_b_of_type_JavaLangString = azin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, false);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((azic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).b(8, localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azmn(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    while (!paramBoolean) {
      return;
    }
    ((azic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).a(9);
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azmp(this, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramOnlineStatusPermissionItem);
  }
  
  public void b()
  {
    Object localObject = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    arfp localarfp = (arfp)aran.a().a(652);
    if ((localarfp != null) && (localarfp.a != null) && (!TextUtils.isEmpty(localarfp.a.jdField_a_of_type_JavaLangString)) && (azin.a((Friends)localObject)))
    {
      localObject = localarfp.a.jdField_a_of_type_JavaLangString + ((Friends)localObject).adCode;
      azky.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject, 4015);
      azir.a("0X800AF98");
    }
  }
  
  protected void d()
  {
    super.d();
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azmo(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azms);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmm
 * JD-Core Version:    0.7.0.1
 */