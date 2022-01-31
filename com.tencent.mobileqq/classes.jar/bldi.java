import android.os.Build.VERSION;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class bldi
{
  bldl a;
  
  public bldi()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, bldj parambldj, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parambldj, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bldi
 * JD-Core Version:    0.7.0.1
 */