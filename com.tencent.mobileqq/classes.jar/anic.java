import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.DownloadJobContext;
import cooperation.weiyun.sdk.download.WyDownloader.DownloadServerInfoCallback;
import cooperation.weiyun.sdk.download.processor.UrlFetcher;
import cooperation.weiyun.sdk.download.processor.UrlFetcher.UrlFetcherCallback;

public class anic
  implements WyDownloader.DownloadServerInfoCallback
{
  public anic(UrlFetcher paramUrlFetcher, String paramString, long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt) {}
  
  public void a(DownloadFile paramDownloadFile, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramDownloadFile == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramDownloadFile.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (paramDownloadFile.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile$DownloadServerInfo == null)
      {
        UrlFetcher.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher).a(this.jdField_a_of_type_Long, 1810024, "");
        return;
      }
      UrlFetcher.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher).a(this.jdField_a_of_type_Long, paramDownloadFile.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile$DownloadServerInfo);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext.a()))
    {
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext.d(true);
      paramDownloadFile = Message.obtain();
      paramDownloadFile.what = 1;
      paramDownloadFile.obj = this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext;
      paramDownloadFile.arg1 = this.jdField_a_of_type_Int;
      UrlFetcher.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher).sendMessageDelayed(paramDownloadFile, 1000L);
      return;
    }
    UrlFetcher.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher).a(this.jdField_a_of_type_Long, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anic
 * JD-Core Version:    0.7.0.1
 */