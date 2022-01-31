import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;
import java.util.Map;

class bgrd
  implements DownloaderProxy.DownloadListener
{
  bgrd(bgrb parambgrb, bgrg parambgrg, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, long paramLong) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bgrg != null)
    {
      this.jdField_a_of_type_Bgrg.a(null, 1, "下载失败");
      QMLog.d("ApkgManager", "onDownloadFailed() called with: statusCode = [" + paramInt + "], errorMsg = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bgrb.a(this.jdField_a_of_type_Bgrb, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.c, this.d, this.jdField_a_of_type_Bgrg);
    bgrb.jdField_a_of_type_Long = System.currentTimeMillis() - this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrd
 * JD-Core Version:    0.7.0.1
 */