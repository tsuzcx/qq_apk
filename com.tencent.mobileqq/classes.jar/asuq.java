import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class asuq
  implements PluginManagerUpdater
{
  private final File a;
  
  public asuq(String paramString)
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
    return alza.a(16).submit(new asus(this, paramFile));
  }
  
  public Future<File> update()
  {
    return alza.a(16).submit(new asur(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuq
 * JD-Core Version:    0.7.0.1
 */