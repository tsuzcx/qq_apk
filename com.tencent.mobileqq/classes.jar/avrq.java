import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class avrq
  implements PluginManagerUpdater
{
  private final File a;
  
  public avrq(String paramString)
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
    return ThreadManagerExecutor.getExecutorService(16).submit(new avrs(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new avrr(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrq
 * JD-Core Version:    0.7.0.1
 */