import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import java.io.File;
import java.util.List;
import java.util.Map;

class bdpm
  implements DownloaderProxy.DownloadListener
{
  bdpm(bdpl parambdpl, ITDownloadListener paramITDownloadListener, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener.onFail(this.jdField_a_of_type_JavaLangString, paramInt, null);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener.onProgress(this.jdField_a_of_type_JavaLangString, paramLong2, paramFloat);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    boolean bool = new File(this.b).exists();
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener != null)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener.onSuccess(this.jdField_a_of_type_JavaLangString, paramInt, null, bdeu.a().e(this.b));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkDownloadITDownloadListener.onFail(this.jdField_a_of_type_JavaLangString, 5, "target file not exists");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpm
 * JD-Core Version:    0.7.0.1
 */