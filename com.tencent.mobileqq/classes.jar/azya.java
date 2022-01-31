import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class azya
  implements azyd
{
  private final File a;
  
  public azya(String paramString)
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
    return alza.a(16).submit(new azyc(this, paramFile));
  }
  
  public Future<File> update()
  {
    return alza.a(16).submit(new azyb(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azya
 * JD-Core Version:    0.7.0.1
 */