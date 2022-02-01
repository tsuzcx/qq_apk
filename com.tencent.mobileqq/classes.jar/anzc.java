import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class anzc
  extends beqz
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      paramOutputStream = (String)paramDownloadParams.tag;
      paramDownloadParams = antf.bl;
      paramDownloadParams = new File(paramDownloadParams + Utils.Crc64String(paramOutputStream));
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
      if (bihw.a(new bihu(paramOutputStream, paramDownloadParams), null) == 0) {
        return paramDownloadParams;
      }
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("funnypic_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (Integer.valueOf(paramURLDrawableHandler).intValue() == 2)) {
        return new bhyp(paramFile, true, f, 3);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzc
 * JD-Core Version:    0.7.0.1
 */