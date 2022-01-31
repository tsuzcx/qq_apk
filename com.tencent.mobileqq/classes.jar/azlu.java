import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class azlu
{
  azlx a;
  
  public azlu()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return false;
  }
  
  public boolean a(File paramFile, azlv paramazlv, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, paramazlv, paramBoolean);
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.a != null) && (this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlu
 * JD-Core Version:    0.7.0.1
 */