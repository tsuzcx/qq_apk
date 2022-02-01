import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import java.util.ArrayList;

public class azcw
  extends azba
{
  private azco a;
  
  public azcw(long paramLong, azbb paramazbb, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Azco = ((azbv)paramQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a();
    this.jdField_a_of_type_Azco.a(new azcx(this));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698160);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Azco.a(null);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ArrayList localArrayList;
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Azbb == null)
    {
      localArrayList = null;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      azcf.a(localQQAppInterface, paramOnlineStatusPermissionItem, localArrayList, paramBoolean);
      return;
      localArrayList = this.jdField_a_of_type_Azbb.a();
      break;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Azco.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcw
 * JD-Core Version:    0.7.0.1
 */