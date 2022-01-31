import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileStorageHandler.Collector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public final class amtv
  implements FileStorageHandler.Collector
{
  public Collection a()
  {
    synchronized ()
    {
      if (CacheManager.a().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(CacheManager.a().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtv
 * JD-Core Version:    0.7.0.1
 */