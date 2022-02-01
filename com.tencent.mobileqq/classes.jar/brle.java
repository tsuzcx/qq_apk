import android.os.Build.VERSION;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class brle
{
  brlh a;
  
  public brle()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, brlf parambrlf, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parambrlf, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brle
 * JD-Core Version:    0.7.0.1
 */