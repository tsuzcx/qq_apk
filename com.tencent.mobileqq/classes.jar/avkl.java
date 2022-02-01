import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class avkl
  implements avka
{
  public String a()
  {
    return azsp.a;
  }
  
  public void a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((VasQuickUpdateManager)localAppRuntime.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(5L, "font.diycard.android." + paramInt, "HiBoomDownloader");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkl
 * JD-Core Version:    0.7.0.1
 */