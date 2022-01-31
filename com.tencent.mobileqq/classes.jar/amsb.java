import android.content.Context;
import cooperation.weiyun.sdk.download.WyDownloader;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadListener;
import cooperation.weiyun.utils.SoHelper.SoListener;
import java.io.File;

public final class amsb
  implements WyDownloader.IDownloadListener
{
  public amsb(String paramString1, String paramString2, SoHelper.SoListener paramSoListener, Context paramContext, File paramFile1, File paramFile2) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener != null) {
      this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener.a(paramLong, paramFloat);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (paramBoolean) {
      WyDownloader.a().a("http://dldir1.qq.com/weiyun/android/qq/librarySize1002.txt", this.jdField_a_of_type_JavaLangString, "SoHelper", new amsc(this));
    }
    while (this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener == null) {
      return;
    }
    this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener.a(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsb
 * JD-Core Version:    0.7.0.1
 */