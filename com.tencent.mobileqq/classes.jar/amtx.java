import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.cache.FileStorageHandler;
import cooperation.qzone.cache.FileStorageHandler.Collector;
import java.util.Collection;
import java.util.Iterator;

public class amtx
  implements ThreadPool.Job
{
  public amtx(FileStorageHandler paramFileStorageHandler, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        FileCacheService localFileCacheService = (FileCacheService)paramJobContext.next();
        int j = localFileCacheService.a(this.jdField_a_of_type_Boolean);
        String str = localFileCacheService.a();
        int i = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler, str);
        j = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler, j, i);
        this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localFileCacheService + ": remain=" + j);
      }
      if (FileStorageHandler.a(CacheManager.l()))
      {
        CacheManager.a(false, true);
        if (FileStorageHandler.a(CacheManager.l()))
        {
          CacheManager.a(true, true);
          FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtx
 * JD-Core Version:    0.7.0.1
 */