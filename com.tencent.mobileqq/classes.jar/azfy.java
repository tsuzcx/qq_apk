import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import kotlin.Pair;

public class azfy
  extends azba
{
  azew a;
  private String e = "";
  private String f = "";
  
  public azfy(long paramLong, azbb paramazbb, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Azew = new azfz(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Azew);
    this.e = bgzv.c(bhaa.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin()).constellation);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698145);
    this.jdField_a_of_type_Boolean = false;
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698132);
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
    this.e = ((String)azfx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, this.e).getSecond());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      azbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    azev.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1040);
  }
  
  public void b()
  {
    Friends localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    azes.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localFriends.constellationJumpUrl, 4015);
    azcl.a("0X800AF4D");
  }
  
  public void c()
  {
    azes.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "VAL_FROM_STATUS_SETTING");
    azcl.a("0X800AF97");
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azew);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfy
 * JD-Core Version:    0.7.0.1
 */