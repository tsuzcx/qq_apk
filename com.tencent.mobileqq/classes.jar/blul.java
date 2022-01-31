import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blul
  implements blun
{
  private File a;
  
  public void a()
  {
    try
    {
      blur localblur = (blur)blqr.a().c(10);
      localblur.a(this.a);
      localblur.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HumSongRecognizer", 2, "recognize: Failed. info: exception = ", localThrowable);
    }
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blul
 * JD-Core Version:    0.7.0.1
 */