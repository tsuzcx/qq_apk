import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class avkk
  implements avka
{
  public String a()
  {
    return avjz.b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((VasQuickUpdateManager)((AppRuntime)localObject).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
      localObject = ((avkh)((AppRuntime)localObject).getManager(QQManagerFactory.HIBOOM_MANAGER)).a(paramInt);
      ((avkg)localObject).b = true;
      ((avkg)localObject).c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkk
 * JD-Core Version:    0.7.0.1
 */