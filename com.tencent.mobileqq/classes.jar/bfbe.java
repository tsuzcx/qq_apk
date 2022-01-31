import android.content.Context;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

@behk(a="PageCreateTask")
public class bfbe
  extends bffk
{
  public bfbe(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public void a()
  {
    if (a().getRuntime() == null)
    {
      betc.c("ServiceInitTask", "runtime is null!");
      c();
      return;
    }
    behs localbehs = a().getRuntime().a();
    if (!(localbehs instanceof AppBrandPageContainer))
    {
      betc.c("ServiceInitTask", "PageContainer type is incorrect! page=" + localbehs);
      c();
      return;
    }
    try
    {
      ((AppBrandPageContainer)localbehs).a(null);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("ServiceInitTask", "pageContainer init exception!", localThrowable);
      a(10, "Page创建失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbe
 * JD-Core Version:    0.7.0.1
 */