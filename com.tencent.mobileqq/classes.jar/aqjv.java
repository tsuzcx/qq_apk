import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class aqjv
  implements PluginManagerUpdater
{
  private final File a;
  
  public aqjv(String paramString)
  {
    this.a = new File("/data/local/tmp/" + paramString + "PluginManager.apk");
  }
  
  public File getLatest()
  {
    if (this.a.exists()) {
      return this.a;
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return ajtb.a(16).submit(new aqjx(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ajtb.a(16).submit(new aqjw(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqjv
 * JD-Core Version:    0.7.0.1
 */