import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.cache.FileStorageHandler;
import cooperation.qzone.cache.FileStorageHandler.Collector;
import java.util.Collection;
import java.util.Iterator;

public class anbl
  implements ThreadPool.Job
{
  public anbl(FileStorageHandler paramFileStorageHandler, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (FileCacheService)paramJobContext.next();
        int i = ((FileCacheService)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((FileCacheService)localObject).a();
        this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbl
 * JD-Core Version:    0.7.0.1
 */