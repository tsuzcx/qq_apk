import android.os.Build.VERSION;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class bpue
{
  bpuh a;
  
  public bpue()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, bpuf parambpuf, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parambpuf, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpue
 * JD-Core Version:    0.7.0.1
 */