import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class bauu
  implements baux
{
  bauu(baut parambaut) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    String str = paramURL.getPath();
    try
    {
      Bitmap localBitmap = baut.a(this.a, str);
      paramURL = localBitmap;
      if (localBitmap == null) {
        paramURL = baut.b(this.a, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauu
 * JD-Core Version:    0.7.0.1
 */