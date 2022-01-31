import android.content.Context;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

@bghi(a="PageCreateTask")
public class bhag
  extends bhhp
{
  public bhag(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public void a()
  {
    if (a().getRuntime() == null)
    {
      QMLog.w("ServiceInitTask", "runtime is null!");
      c();
      return;
    }
    bghq localbghq = a().getRuntime().a();
    if (!(localbghq instanceof AppBrandPageContainer))
    {
      QMLog.w("ServiceInitTask", "PageContainer type is incorrect! page=" + localbghq);
      c();
      return;
    }
    try
    {
      ((AppBrandPageContainer)localbghq).a(null);
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
 * Qualified Name:     bhag
 * JD-Core Version:    0.7.0.1
 */