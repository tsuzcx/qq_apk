import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class assk
  implements asrz
{
  public String a()
  {
    return awsl.a;
  }
  
  public void a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(5L, "font.diycard.android." + paramInt, "HiBoomDownloader");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assk
 * JD-Core Version:    0.7.0.1
 */