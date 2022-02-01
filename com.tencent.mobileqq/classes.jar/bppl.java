import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bppl
  implements bppm
{
  private File a;
  
  public void a()
  {
    try
    {
      bppq localbppq = (bppq)bplq.a().c(10);
      localbppq.a(this.a);
      localbppq.a(7000.0F);
      localbppq.c();
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
 * Qualified Name:     bppl
 * JD-Core Version:    0.7.0.1
 */