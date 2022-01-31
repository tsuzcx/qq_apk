import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class aywv
  implements aywy
{
  aywv(aywu paramaywu) {}
  
  public Bitmap a(URL paramURL)
  {
    String str = paramURL.getPath();
    try
    {
      Bitmap localBitmap = aywu.a(this.a, str);
      paramURL = localBitmap;
      if (localBitmap == null) {
        paramURL = aywu.b(this.a, str);
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
 * Qualified Name:     aywv
 * JD-Core Version:    0.7.0.1
 */