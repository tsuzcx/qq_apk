import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bjdy
  implements bjdz
{
  private File a;
  
  public void a()
  {
    try
    {
      bjed localbjed = (bjed)bjae.a().c(10);
      localbjed.a(this.a);
      localbjed.a(7000.0F);
      localbjed.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdy
 * JD-Core Version:    0.7.0.1
 */