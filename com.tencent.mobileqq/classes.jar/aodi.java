import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;

public class aodi
  extends anzi
{
  protected void a()
  {
    super.a();
    if (this.d >= anzg.a().a / 12000L)
    {
      CoreService.stopTempService();
      this.a.c();
      this.d = 0L;
    }
  }
  
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
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.a.b();
    CoreService.startTempService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aodi
 * JD-Core Version:    0.7.0.1
 */