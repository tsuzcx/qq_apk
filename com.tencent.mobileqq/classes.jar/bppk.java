import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bppk
  implements bppm
{
  private File a;
  
  public void a()
  {
    try
    {
      bppq localbppq = (bppq)bplq.a().c(10);
      localbppq.a(this.a);
      localbppq.c();
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
 * Qualified Name:     bppk
 * JD-Core Version:    0.7.0.1
 */