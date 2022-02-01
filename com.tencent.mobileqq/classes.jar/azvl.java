import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class azvl
  extends AbsDownloader
{
  protected BaseApplicationImpl a;
  
  public azvl(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
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
            i = DisplayUtil.dip2px(this.a, 30.0F);
          }
          paramDownloadParams = bfvo.a(paramFile.getAbsolutePath(), i, i);
          paramFile = paramDownloadParams;
          if (j == 1)
          {
            if (paramDownloadParams != null) {
              paramFile = bfvo.a(paramDownloadParams, paramDownloadParams.getWidth(), paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
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
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams != null) && (paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      paramOutputStream = (String)paramDownloadParams.tag;
      paramDownloadParams = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
      try
      {
        paramDownloadParams = new File(paramDownloadParams);
        paramDownloadParams.mkdirs();
        paramDownloadParams = new File(paramDownloadParams, Utils.Crc64String(paramOutputStream));
        if (paramDownloadParams.exists()) {
          return paramDownloadParams;
        }
        int i = bgog.a(new bgoe(paramOutputStream, paramDownloadParams), null);
        if (i == 0) {
          return paramDownloadParams;
        }
      }
      catch (Exception paramOutputStream)
      {
        QLog.e("AbsDownloader", 1, "download exception " + paramOutputStream);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvl
 * JD-Core Version:    0.7.0.1
 */