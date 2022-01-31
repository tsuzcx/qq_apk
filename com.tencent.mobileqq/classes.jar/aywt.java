import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class aywt
  implements ayww
{
  aywt(ayws paramayws) {}
  
  public Bitmap a(URL paramURL)
  {
    String str = paramURL.getPath();
    try
    {
      Bitmap localBitmap = ayws.a(this.a, str);
      paramURL = localBitmap;
      if (localBitmap == null) {
        paramURL = ayws.b(this.a, str);
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
 * Qualified Name:     aywt
 * JD-Core Version:    0.7.0.1
 */