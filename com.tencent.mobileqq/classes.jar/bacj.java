import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class bacj
  implements bacm
{
  private final File a;
  
  public bacj(String paramString)
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
    return amdp.a(16).submit(new bacl(this, paramFile));
  }
  
  public Future<File> update()
  {
    return amdp.a(16).submit(new back(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacj
 * JD-Core Version:    0.7.0.1
 */