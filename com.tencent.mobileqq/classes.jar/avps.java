import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class avps
  extends ayog
{
  protected BaseApplicationImpl a;
  
  public avps(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams != null) && (paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      paramOutputStream = (String)paramDownloadParams.tag;
      paramDownloadParams = new File(ajsf.bc);
      paramDownloadParams.mkdirs();
      paramDownloadParams = new File(paramDownloadParams, Utils.Crc64String(paramOutputStream));
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
      if (bbwi.a(new bbwg(paramOutputStream, paramDownloadParams), null) == 0) {
        return paramDownloadParams;
      }
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams != null) && (paramFile != null))
    {
      paramDownloadParams = paramDownloadParams.getHeader("isCircle");
      if (paramDownloadParams != null)
      {
        paramDownloadParams = paramDownloadParams.getValue();
        if (!TextUtils.isEmpty(paramDownloadParams))
        {
          int j = Integer.valueOf(paramDownloadParams).intValue();
          int i = 90;
          if (this.a != null) {
            i = bawz.a(this.a, 30.0F);
          }
          paramDownloadParams = bbdr.a(paramFile.getAbsolutePath(), i, i);
          paramFile = paramDownloadParams;
          if (j == 1)
          {
            if (paramDownloadParams != null) {
              paramFile = bbdr.a(paramDownloadParams, paramDownloadParams.getWidth(), paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
            }
          }
          else {
            return paramFile;
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avps
 * JD-Core Version:    0.7.0.1
 */