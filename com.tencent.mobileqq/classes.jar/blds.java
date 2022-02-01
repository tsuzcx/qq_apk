import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class blds
  implements PluginManagerUpdater
{
  private final File a;
  
  public blds()
  {
    String str = bldz.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("IliveCdnPmUpdater", 2, "new IliveCdnPmUpdater file = " + str);
    }
    this.a = new File(str);
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
    return anvy.a(16).submit(new bldu(this, paramFile));
  }
  
  public Future<File> update()
  {
    return anvy.a(16).submit(new bldt(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blds
 * JD-Core Version:    0.7.0.1
 */