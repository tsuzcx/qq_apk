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

public class anmf
  implements Runnable
{
  MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public anmf(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = paramMusicDownloadListener;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView.Downloader", 2, "begin download " + this.jdField_a_of_type_JavaLangString + " " + this.b);
    }
    if ((Utils.a()) && (Utils.b() < 20971520L))
    {
      if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener != null) {
        this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(this.b, false);
      }
      QLog.e("MusicProviderView.Downloader", 1, "download err no space");
    }
    Object localObject;
    long l1;
    int i;
    long l2;
    do
    {
      return;
      localObject = new File(SdkContext.a().a().a().a());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      l1 = SystemClock.uptimeMillis();
      localObject = new DownloadTask(this.b, (File)localObject);
      ((DownloadTask)localObject).l = true;
      ((DownloadTask)localObject).b = 2;
      ((DownloadTask)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((DownloadTask)localObject).b(512);
      ((DownloadTask)localObject).a(this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
      i = DownloaderFactory.a((DownloadTask)localObject, null, null);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("MusicProviderView.Downloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((DownloadTask)localObject).jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmf
 * JD-Core Version:    0.7.0.1
 */