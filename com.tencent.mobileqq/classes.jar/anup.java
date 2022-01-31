import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import java.io.File;

public class anup
  implements Runnable
{
  DownloadTask jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
  MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener;
  
  public anup(DownloadTask paramDownloadTask, MusicDownloadListener paramMusicDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = paramDownloadTask;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = paramMusicDownloadListener;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloader", 2, "begin download " + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a);
    }
    if ((Utils.a()) && (Utils.b() < 20971520L))
    {
      if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener != null) {
        this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a, false);
      }
      QLog.e("QQMusicDownloader", 1, "download err no space");
    }
    long l1;
    int i;
    long l2;
    do
    {
      return;
      File localFile = new File(SdkContext.a().a().a().a());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      l1 = SystemClock.uptimeMillis();
      i = DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("QQMusicDownloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anup
 * JD-Core Version:    0.7.0.1
 */