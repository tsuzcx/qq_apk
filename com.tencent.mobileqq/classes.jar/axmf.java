import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class axmf
{
  axmi a;
  
  public axmf()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (this.a.a());
  }
  
  public boolean a(File paramFile, axmg paramaxmg, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, paramaxmg, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axmf
 * JD-Core Version:    0.7.0.1
 */