import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class anvq
  extends AbsDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("funnypic_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (Integer.valueOf(paramURLDrawableHandler).intValue() == 2)) {
        return new bhnu(paramFile, true, f, 3);
      }
    }
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      paramOutputStream = (String)paramDownloadParams.tag;
      paramDownloadParams = AppConstants.SDCARD_IMG_FAVORITE;
      paramDownloadParams = new File(paramDownloadParams + Utils.Crc64String(paramOutputStream));
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
      if (bhyq.a(new bhyo(paramOutputStream, paramDownloadParams), null) == 0) {
        return paramDownloadParams;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvq
 * JD-Core Version:    0.7.0.1
 */