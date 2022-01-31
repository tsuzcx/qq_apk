import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blum
  implements blun
{
  private File a;
  
  public void a()
  {
    try
    {
      blur localblur = (blur)blqr.a().c(10);
      localblur.a(this.a);
      localblur.a(7000.0F);
      localblur.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HumVoiceRecognizer", 2, "recognize: invoked. info: throwable = " + localThrowable);
    }
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blum
 * JD-Core Version:    0.7.0.1
 */