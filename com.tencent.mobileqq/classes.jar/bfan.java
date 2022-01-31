import android.content.Context;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

@begt(a="PageCreateTask")
public class bfan
  extends bfet
{
  public bfan(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public void a()
  {
    if (a().getRuntime() == null)
    {
      besl.c("ServiceInitTask", "runtime is null!");
      c();
      return;
    }
    behb localbehb = a().getRuntime().a();
    if (!(localbehb instanceof AppBrandPageContainer))
    {
      besl.c("ServiceInitTask", "PageContainer type is incorrect! page=" + localbehb);
      c();
      return;
    }
    try
    {
      ((AppBrandPageContainer)localbehb).a(null);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("ServiceInitTask", "pageContainer init exception!", localThrowable);
      a(10, "Page创建失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfan
 * JD-Core Version:    0.7.0.1
 */