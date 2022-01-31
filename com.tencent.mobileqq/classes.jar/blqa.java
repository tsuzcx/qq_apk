import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blqa
  implements blqb
{
  private File a;
  
  public void a()
  {
    try
    {
      blqf localblqf = (blqf)blmf.a().c(10);
      localblqf.a(this.a);
      localblqf.a(7000.0F);
      localblqf.c();
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
 * Qualified Name:     blqa
 * JD-Core Version:    0.7.0.1
 */