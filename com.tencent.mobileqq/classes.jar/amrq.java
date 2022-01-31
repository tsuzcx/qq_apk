import android.text.TextUtils;
import android.util.Log;
import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;
import cooperation.weiyun.sdk.download.WyDownloader;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadListener;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadStatusListener;
import java.io.File;

public class amrq
  implements WyDownloader.IDownloadListener
{
  public amrq(WyDownloader paramWyDownloader, WyDownloader.IDownloadStatusListener paramIDownloadStatusListener, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    DownloadJobContext.StatusInfo localStatusInfo = new DownloadJobContext.StatusInfo();
    localStatusInfo.c = paramString;
    localStatusInfo.jdField_a_of_type_Int = 2;
    localStatusInfo.jdField_b_of_type_Long = (paramFloat);
    localStatusInfo.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener.a(paramString, this.jdField_a_of_type_Int, localStatusInfo, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    DownloadJobContext.StatusInfo localStatusInfo;
    for (int i = 1;; i = 0)
    {
      localStatusInfo = new DownloadJobContext.StatusInfo();
      localStatusInfo.jdField_b_of_type_JavaLangString = paramString2;
      localStatusInfo.c = paramString1;
      localStatusInfo.jdField_b_of_type_Int = paramInt;
      localStatusInfo.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localStatusInfo.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener.a(paramString1, this.jdField_a_of_type_Int, localStatusInfo, true);
      return;
    }
    localStatusInfo.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener.a(paramString1, this.jdField_a_of_type_Int, localStatusInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrq
 * JD-Core Version:    0.7.0.1
 */