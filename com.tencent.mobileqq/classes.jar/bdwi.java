import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class bdwi
  implements bdwl
{
  private final File a;
  
  public bdwi(String paramString)
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
    return aoik.a(16).submit(new bdwk(this, paramFile));
  }
  
  public Future<File> update()
  {
    return aoik.a(16).submit(new bdwj(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwi
 * JD-Core Version:    0.7.0.1
 */