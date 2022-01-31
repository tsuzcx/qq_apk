import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bjep
  implements bjeq
{
  private File a;
  
  public void a()
  {
    try
    {
      bjeu localbjeu = (bjeu)bjav.a().c(10);
      localbjeu.a(this.a);
      localbjeu.a(7000.0F);
      localbjeu.c();
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
 * Qualified Name:     bjep
 * JD-Core Version:    0.7.0.1
 */