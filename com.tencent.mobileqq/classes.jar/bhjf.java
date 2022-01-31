import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bhjf
  implements bhjh
{
  private File a;
  
  public void a()
  {
    try
    {
      bhjl localbhjl = (bhjl)bhfm.a().c(10);
      localbhjl.a(this.a);
      localbhjl.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhjf
 * JD-Core Version:    0.7.0.1
 */