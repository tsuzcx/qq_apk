import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;

public abstract class axup
{
  public long a;
  protected axuq a;
  protected BaseActivity a;
  protected QQAppInterface a;
  public String a;
  public boolean a;
  public String b;
  protected boolean b = true;
  public String c;
  public String d = "";
  
  public axup(long paramLong, axuq paramaxuq, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Axuq = paramaxuq;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.b = paramBoolean;
  }
  
  public abstract void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem);
  
  public boolean a()
  {
    return true;
  }
  
  public abstract void b();
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axup
 * JD-Core Version:    0.7.0.1
 */