import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import java.util.ArrayList;

public class azjc
  extends azhh
{
  private aziu a;
  
  public azjc(long paramLong, azhi paramazhi, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Aziu = ((azic)paramQQAppInterface.getManager(369)).a();
    this.jdField_a_of_type_Aziu.a(new azjd(this));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697731);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aziu.a(null);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ArrayList localArrayList;
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Azhi == null)
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
      azil.a(localQQAppInterface, paramOnlineStatusPermissionItem, localArrayList, paramBoolean);
      return;
      localArrayList = this.jdField_a_of_type_Azhi.a();
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
    this.jdField_a_of_type_Aziu.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjc
 * JD-Core Version:    0.7.0.1
 */