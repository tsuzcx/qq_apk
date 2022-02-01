import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bonq
  implements bonr
{
  private File a;
  
  public void a()
  {
    try
    {
      bonv localbonv = (bonv)bojv.a().c(10);
      localbonv.a(this.a);
      localbonv.a(7000.0F);
      localbonv.c();
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
 * Qualified Name:     bonq
 * JD-Core Version:    0.7.0.1
 */