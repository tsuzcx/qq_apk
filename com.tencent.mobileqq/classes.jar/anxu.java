import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import mqq.app.AppRuntime;

public class anxu
  extends anvw
{
  protected void a(String paramString)
  {
    GuardManager localGuardManager = this.a;
    if ("com.tencent.mobileqq".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.a(i, paramString);
      return;
    }
  }
  
  protected void b()
  {
    this.a.a(6, "fake_p_msg");
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    this.a.c();
    this.a.b(true);
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(4, anvu.a().a, 0L);
    CoreService.stopCoreService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anxu
 * JD-Core Version:    0.7.0.1
 */