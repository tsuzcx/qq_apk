import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ayqd
  implements aywy
{
  ayqd(ayqb paramayqb) {}
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    if (paramURL == null) {
      paramURL = null;
    }
    for (;;)
    {
      return paramURL;
      String str = paramURL.path;
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = this.a.a(str);
        paramURL = localBitmap;
        if (localBitmap == null)
        {
          paramURL = this.a.b(str);
          return paramURL;
        }
      }
      catch (Throwable paramURL)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqd
 * JD-Core Version:    0.7.0.1
 */