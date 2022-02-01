import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import java.util.ArrayList;

public class ayqj
  extends ayoo
{
  private ayqb a;
  
  public ayqj(long paramLong, ayop paramayop, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramayop, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_Ayqb = ((aypj)paramQQAppInterface.getManager(369)).a();
    this.jdField_a_of_type_Ayqb.a(new ayqk(this));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697647);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Ayqb.a(null);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ArrayList localArrayList;
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Ayop == null)
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
      ayps.a(localQQAppInterface, paramOnlineStatusPermissionItem, localArrayList, paramBoolean);
      return;
      localArrayList = this.jdField_a_of_type_Ayop.a();
      break;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Ayqb.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqj
 * JD-Core Version:    0.7.0.1
 */