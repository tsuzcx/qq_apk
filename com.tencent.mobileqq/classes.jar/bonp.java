import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bonp
  implements bonr
{
  private File a;
  
  public void a()
  {
    try
    {
      bonv localbonv = (bonv)bojv.a().c(10);
      localbonv.a(this.a);
      localbonv.c();
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
 * Qualified Name:     bonp
 * JD-Core Version:    0.7.0.1
 */