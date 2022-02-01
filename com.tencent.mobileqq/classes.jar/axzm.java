import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import kotlin.Pair;

public class axzm
  extends axup
{
  axyk a;
  private String e = "";
  private String f = "";
  
  public axzm(long paramLong, axuq paramaxuq, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramaxuq, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Axyk = new axzn(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Axyk);
    this.e = bfre.c(bfrj.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin()).constellation);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697862);
    this.jdField_a_of_type_Boolean = false;
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697849);
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
    this.e = ((String)axzl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, this.e).getSecond());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      axvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    axyj.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1040);
  }
  
  public void b()
  {
    Friends localFriends = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    axyg.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localFriends.constellationJumpUrl, 4015);
    axvz.a("0X800AF4D");
  }
  
  public void c()
  {
    axyg.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "VAL_FROM_STATUS_SETTING");
    axvz.a("0X800AF97");
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axyk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzm
 * JD-Core Version:    0.7.0.1
 */