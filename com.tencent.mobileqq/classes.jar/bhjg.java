import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bhjg
  implements bhjh
{
  private File a;
  
  public void a()
  {
    try
    {
      bhjl localbhjl = (bhjl)bhfm.a().c(10);
      localbhjl.a(this.a);
      localbhjl.a(7000.0F);
      localbhjl.c();
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
 * Qualified Name:     bhjg
 * JD-Core Version:    0.7.0.1
 */