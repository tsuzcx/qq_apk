import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blpz
  implements blqb
{
  private File a;
  
  public void a()
  {
    try
    {
      blqf localblqf = (blqf)blmf.a().c(10);
      localblqf.a(this.a);
      localblqf.c();
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
 * Qualified Name:     blpz
 * JD-Core Version:    0.7.0.1
 */