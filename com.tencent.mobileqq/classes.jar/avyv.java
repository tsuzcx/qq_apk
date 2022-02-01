import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class avyv
  implements PluginManagerUpdater
{
  private final File a;
  
  public avyv(String paramString)
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
    return aoik.a(16).submit(new avyx(this, paramFile));
  }
  
  public Future<File> update()
  {
    return aoik.a(16).submit(new avyw(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyv
 * JD-Core Version:    0.7.0.1
 */