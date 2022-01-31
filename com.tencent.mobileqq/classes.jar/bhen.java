import android.content.Context;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

@bglp(a="PageCreateTask")
public class bhen
  extends bhlw
{
  public bhen(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public void a()
  {
    if (a().getRuntime() == null)
    {
      QMLog.w("ServiceInitTask", "runtime is null!");
      c();
      return;
    }
    bglx localbglx = a().getRuntime().a();
    if (!(localbglx instanceof AppBrandPageContainer))
    {
      QMLog.w("ServiceInitTask", "PageContainer type is incorrect! page=" + localbglx);
      c();
      return;
    }
    try
    {
      ((AppBrandPageContainer)localbglx).a(null);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ServiceInitTask", "pageContainer init exception!", localThrowable);
      a(10, "Page创建失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhen
 * JD-Core Version:    0.7.0.1
 */