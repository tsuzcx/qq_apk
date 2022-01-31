import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class awmx
{
  awna a;
  
  public awmx()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (this.a.a());
  }
  
  public boolean a(File paramFile, awmy paramawmy, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, paramawmy, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awmx
 * JD-Core Version:    0.7.0.1
 */