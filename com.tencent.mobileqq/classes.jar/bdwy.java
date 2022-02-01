import com.tencent.mobileqq.app.ThreadManagerExecutor;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class bdwy
  implements bdxb
{
  private final File a;
  
  public bdwy(String paramString)
  {
    this.a = new File(String.format("/data/local/tmp/%sPluginManager.apk", new Object[] { paramString }));
  }
  
  public boolean a()
  {
    return this.a.exists();
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
    return ThreadManagerExecutor.getExecutorService(16).submit(new bdxa(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new bdwz(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwy
 * JD-Core Version:    0.7.0.1
 */