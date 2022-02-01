import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import kotlin.Pair;

public class azme
  extends azhh
{
  azlc a;
  private String e = "";
  private String f = "";
  
  public azme(long paramLong, azhi paramazhi, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Azlc = new azmf(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Azlc);
    this.e = bhhu.c(bhhz.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin()).constellation);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697716);
    this.jdField_a_of_type_Boolean = false;
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697703);
    if (!TextUtils.isEmpty(this.f))
    {
      this.jdField_b_of_type_JavaLangString = (this.e + " | " + this.f);
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.e;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.e = ((String)azmd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, this.e).getSecond());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      azia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    azlb.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1040);
  }
  
  public void b()
  {
    Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    azky.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localFriends.constellationJumpUrl, 4015);
    azir.a("0X800AF4D");
  }
  
  public void c()
  {
    azky.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "VAL_FROM_STATUS_SETTING");
    azir.a("0X800AF97");
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azlc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azme
 * JD-Core Version:    0.7.0.1
 */