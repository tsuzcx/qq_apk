import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class arec
  implements PluginManagerUpdater
{
  private final File a;
  
  public arec(String paramString)
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
    return akhk.a(16).submit(new aree(this, paramFile));
  }
  
  public Future<File> update()
  {
    return akhk.a(16).submit(new ared(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arec
 * JD-Core Version:    0.7.0.1
 */