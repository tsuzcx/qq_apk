import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class axwm
  implements axwp
{
  axwm(axwl paramaxwl) {}
  
  public Bitmap a(URL paramURL)
  {
    String str = paramURL.getPath();
    try
    {
      Bitmap localBitmap = axwl.a(this.a, str);
      paramURL = localBitmap;
      if (localBitmap == null) {
        paramURL = axwl.b(this.a, str);
      }
      return paramURL;
    }
    catch (Throwable paramURL)
    {
      QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwm
 * JD-Core Version:    0.7.0.1
 */