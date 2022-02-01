import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import java.io.File;
import java.io.OutputStream;

public class beyv
  extends beqz
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(antf.aZ);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return AlbumThumbManager.getInstance(BaseApplicationImpl.getContext()).getThumb(paramDownloadParams.url, new beyw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyv
 * JD-Core Version:    0.7.0.1
 */