import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class bash
  implements bazg
{
  bash(basf parambasf) {}
  
  public Bitmap getBitmap(URL paramURL)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bash
 * JD-Core Version:    0.7.0.1
 */