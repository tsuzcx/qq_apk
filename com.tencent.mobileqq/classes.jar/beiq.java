import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import java.util.List;
import java.util.Map;

class beiq
  implements DownloaderProxy.DownloadListener
{
  beiq(beip parambeip, beis parambeis, MiniAppBaseInfo paramMiniAppBaseInfo, boolean paramBoolean) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Beis != null) {
      this.jdField_a_of_type_Beis.a(null, paramInt, paramString);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    paramMap = beip.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo, this.jdField_a_of_type_Boolean);
    if ((!beji.a(paramString, paramMap)) && (this.jdField_a_of_type_Beis != null)) {
      this.jdField_a_of_type_Beis.a(null, -1, "");
    }
    paramString = bejy.a(paramMap, null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo);
    if (this.jdField_a_of_type_Beis != null) {
      this.jdField_a_of_type_Beis.a(paramString, 0, "加载成功");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beiq
 * JD-Core Version:    0.7.0.1
 */