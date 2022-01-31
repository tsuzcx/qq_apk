import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import com.tencent.qqmini.sdk.core.manager.ShareManager.2;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;
import java.util.Map;

public class bgjr
  implements DownloaderProxy.DownloadListener
{
  public bgjr(ShareManager.2 param2, ProgressDialog paramProgressDialog) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.e("ShareManager", "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    if (paramString != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      if (paramInt == 0) {
        bgnf.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerShareManager$2.jdField_a_of_type_AndroidAppActivity, 1, "网络异常，图片分享失败", 1).b(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerShareManager$2.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297248));
      }
      if (paramInt == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerShareManager$2.jdField_a_of_type_ComTencentQqminiSdkCoreModelInnerShareData.isLocalPic = true;
      this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerShareManager$2.jdField_a_of_type_ComTencentQqminiSdkCoreModelInnerShareData.sharePicPath = paramString;
      bgjo.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerShareManager$2.this$0, this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerShareManager$2.jdField_a_of_type_ComTencentQqminiSdkCoreModelInnerShareData);
      return;
    }
    QMLog.e("ShareManager", "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjr
 * JD-Core Version:    0.7.0.1
 */