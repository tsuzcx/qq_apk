import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class beyy
  implements bezb
{
  beyy(beyx parambeyx) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    String str = paramURL.getPath();
    try
    {
      Bitmap localBitmap = beyx.a(this.a, str);
      paramURL = localBitmap;
      if (localBitmap == null) {
        paramURL = beyx.b(this.a, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyy
 * JD-Core Version:    0.7.0.1
 */