import android.os.Build.VERSION;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class bnos
{
  bnov a;
  
  public bnos()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, bnot parambnot, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parambnot, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnos
 * JD-Core Version:    0.7.0.1
 */