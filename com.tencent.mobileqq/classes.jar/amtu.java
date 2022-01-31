import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat.ResultCallback;
import cooperation.plugin.PluginInstaller;
import java.io.File;

public class amtu
  implements Dex2Oat.ResultCallback
{
  public amtu(PluginInstaller paramPluginInstaller) {}
  
  public void a(File paramFile1, File paramFile2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "dex2Oat onStart " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
  
  public void a(File paramFile1, File paramFile2, File paramFile3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "dex2Oat onSuccess " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
  
  public void a(File paramFile1, File paramFile2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "preDex2Oat onFailed " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtu
 * JD-Core Version:    0.7.0.1
 */