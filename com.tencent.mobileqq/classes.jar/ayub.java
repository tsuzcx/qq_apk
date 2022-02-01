import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;

public class ayub
  extends ayoo
{
  private ayuf a;
  
  public ayub(long paramLong, ayop paramayop, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramayop, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Ayuf = new ayud(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Ayuf);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697653);
    this.jdField_a_of_type_Boolean = true;
    Friends localFriends = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    this.jdField_b_of_type_JavaLangString = aypu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new ayuc(this, paramBoolean), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    while (!paramBoolean) {
      return;
    }
    ((aypj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).a(9);
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    ((aypj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).b(8, localIntent);
  }
  
  public void b()
  {
    Object localObject = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    aqqh localaqqh = (aqqh)aqlk.a().a(652);
    if ((localaqqh != null) && (localaqqh.a != null) && (!TextUtils.isEmpty(localaqqh.a.jdField_a_of_type_JavaLangString)) && (aypu.a((Friends)localObject)))
    {
      localObject = localaqqh.a.jdField_a_of_type_JavaLangString + ((Friends)localObject).adCode;
      aysf.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject, 4015);
      aypy.a("0X800AF98");
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayuf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayub
 * JD-Core Version:    0.7.0.1
 */