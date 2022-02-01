import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import mqq.app.AppRuntime;

public class anxt
  extends anvw
{
  protected void a()
  {
    super.a();
    if (this.c >= anvu.a().a(this.a.jdField_a_of_type_Array2dOfLong, this.a.jdField_a_of_type_Int, this.a.b, MemoryManager.getMemory(Process.myPid())) / 12000L) {
      this.a.a(7, null);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.d != 1L);
        MemoryManager.getInstance().reportMemory("LITE_GUARD");
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (localObject == null);
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER);
    } while (localObject == null);
    ((PreDownloadScheduler)localObject).onAppLiteStart(true);
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
  
  protected void b()
  {
    if (this.c > 2L) {
      this.c -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    CoreService.startCoreService(anvu.a().a);
    this.a.b();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(3, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anxt
 * JD-Core Version:    0.7.0.1
 */