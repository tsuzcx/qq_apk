import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.downloadListTaskListener;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aopm
  implements INetEngine.INetEngineListener
{
  public aopm(VideoFilterListDownloader paramVideoFilterListDownloader) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    float f1 = 1.0F;
    Object localObject = (FilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    int i;
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramNetResp.b + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).jdField_a_of_type_JavaLangString);
      i = VideoFilterListDownloader.a(this.a, 0, 1);
      if (VideoFilterListDownloader.a(this.a) != null)
      {
        if (i != 0) {
          break label336;
        }
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener leftcount ==0 ");
        paramNetResp = (VideoFilterListDownloader.downloadListTaskListener)VideoFilterListDownloader.a(this.a).jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramNetResp != null)
        {
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener onFinished ");
          paramNetResp.a(VideoFilterListDownloader.a(this.a).b, VideoFilterListDownloader.a(this.a).c);
        }
        QLog.i("VideoFilterListDownloader", 2, "taskImpling set null  ");
        VideoFilterListDownloader.a(this.a);
        VideoFilterListDownloader.b(this.a);
      }
    }
    label336:
    do
    {
      for (;;)
      {
        return;
        if (!((FilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
        {
          QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
          FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
          i = VideoFilterListDownloader.a(this.a, 0, 1);
          break;
        }
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + ((FilterDesc)localObject).e + ((FilterDesc)localObject).jdField_a_of_type_JavaLangString);
        i = VideoFilterListDownloader.a(this.a, 1, 0);
        try
        {
          localObject = CaptureVideoFilterManager.b;
          FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, (String)localObject, false);
          FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
        }
        catch (IOException paramNetResp)
        {
          paramNetResp.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
        }
      }
      break;
      paramNetResp = (VideoFilterListDownloader.downloadListTaskListener)VideoFilterListDownloader.a(this.a).jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((paramNetResp == null) || (aopl.a(VideoFilterListDownloader.a(this.a)) == null) || (aopl.a(VideoFilterListDownloader.a(this.a)).size() <= 0));
    float f2 = (aopl.a(VideoFilterListDownloader.a(this.a)).size() - VideoFilterListDownloader.a(this.a).jdField_a_of_type_Int) / aopl.a(VideoFilterListDownloader.a(this.a)).size();
    if (f2 > 1.0F) {}
    for (;;)
    {
      QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener progress = " + f1);
      paramNetResp.a(f1);
      return;
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aopm
 * JD-Core Version:    0.7.0.1
 */