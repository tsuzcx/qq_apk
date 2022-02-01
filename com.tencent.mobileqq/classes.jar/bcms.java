import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class bcms
{
  bcmv a;
  
  public bcms()
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
  
  public boolean a(File paramFile, bcmt parambcmt, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parambcmt, paramBoolean);
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.a != null) && (this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcms
 * JD-Core Version:    0.7.0.1
 */