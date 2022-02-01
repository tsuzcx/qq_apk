import android.os.Build.VERSION;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class bqjs
{
  bqjv a;
  
  public bqjs()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, bqjt parambqjt, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parambqjt, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjs
 * JD-Core Version:    0.7.0.1
 */