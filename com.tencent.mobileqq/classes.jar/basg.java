import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class basg
  implements bazg
{
  basg(basf parambasf) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    LocalMediaInfo localLocalMediaInfo = this.a.a(paramURL);
    if (localLocalMediaInfo == null) {}
    for (;;)
    {
      return null;
      paramURL = new BitmapFactory.Options();
      paramURL.inDensity = 160;
      paramURL.inTargetDensity = 160;
      paramURL.inScreenDensity = 160;
      try
      {
        paramURL = BitmapFactory.decodeFile(localLocalMediaInfo.path, paramURL);
        if (paramURL == null) {
          continue;
        }
        return ThumbnailUtils.extractThumbnail(paramURL, localLocalMediaInfo.thumbWidth, localLocalMediaInfo.thumbHeight, 2);
      }
      catch (OutOfMemoryError paramURL)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", paramURL);
          }
          paramURL = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basg
 * JD-Core Version:    0.7.0.1
 */