import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import java.util.List;
import java.util.Map;

class bgnp
  implements DownloaderProxy.DownloadListener
{
  bgnp(bgno parambgno, bgnr parambgnr, MiniAppBaseInfo paramMiniAppBaseInfo, boolean paramBoolean) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bgnr != null) {
      this.jdField_a_of_type_Bgnr.a(null, paramInt, paramString);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    paramMap = bgno.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo, this.jdField_a_of_type_Boolean);
    if ((!bgoa.a(paramString, paramMap)) && (this.jdField_a_of_type_Bgnr != null)) {
      this.jdField_a_of_type_Bgnr.a(null, -1, "");
    }
    paramString = bgod.a(paramMap, null, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo);
    if (this.jdField_a_of_type_Bgnr != null) {
      this.jdField_a_of_type_Bgnr.a(paramString, 0, "加载成功");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnp
 * JD-Core Version:    0.7.0.1
 */