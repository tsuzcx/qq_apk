import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ShareManager.2;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.ShareTransitiveFragment;
import com.tencent.qqmini.sdk.utils.MiniProgramShareUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.concurrent.TimeUnit;

public class bgjo
{
  private static bgjo jdField_a_of_type_Bgjo = new bgjo();
  private final ChannelProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private final ShareProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  public static bgjo a()
  {
    return jdField_a_of_type_Bgjo;
  }
  
  private AsyncResult a(InnerShareData paramInnerShareData)
  {
    return new bgjp(this, paramInnerShareData);
  }
  
  private void a(String paramString, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, null, 60, paramDownloadListener);
  }
  
  private void d(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.jdField_a_of_type_AndroidAppActivity;
    ThreadManager.c().post(new ShareManager.2(this, localActivity, paramInnerShareData));
  }
  
  private void e(InnerShareData paramInnerShareData)
  {
    if (!paramInnerShareData.isLocalPic) {
      QMLog.w("ShareManager", "shareLocalPicMessage. not local pic");
    }
    do
    {
      return;
      if (paramInnerShareData.sharePicPath == null)
      {
        QMLog.w("ShareManager", "shareLocalPicMessage. local pic is null");
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy.isShareTargetAvailable(paramInnerShareData.jdField_a_of_type_AndroidAppActivity, paramInnerShareData.shareTarget));
    if (paramInnerShareData.shareInMiniProcess)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy.share(paramInnerShareData.jdField_a_of_type_AndroidAppActivity, paramInnerShareData);
      return;
    }
    ShareTransitiveFragment.a(paramInnerShareData.jdField_a_of_type_AndroidAppActivity, paramInnerShareData);
  }
  
  public void a(InnerShareData paramInnerShareData)
  {
    if (QUAUtil.isQQApp())
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy.onJsShareAppMessage(paramInnerShareData);
      return;
    }
    b(paramInnerShareData);
  }
  
  public void b(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null)
    {
      QMLog.e("ShareManager", "Failed to create newShareInfoRequest");
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("ShareManager", "newShareInfoRequest. title=" + paramInnerShareData.title + ",sharePicPath=" + paramInnerShareData.sharePicPath + ",entryPath=" + paramInnerShareData.jdField_a_of_type_JavaLangString);
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.a();
    if (localMiniAppInfo == null)
    {
      QMLog.e("ShareManager", "newShareInfoRequest. mini app info is null!");
      return;
    }
    String str2 = paramInnerShareData.summary;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyChannelProxy.getShareInfo(MiniProgramShareUtils.newShareInfoRequest(localMiniAppInfo.appId, paramInnerShareData.summary, str1, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.jdField_a_of_type_JavaLangString, localMiniAppInfo.iconUrl, null, localMiniAppInfo.verType, localMiniAppInfo.versionId, paramInnerShareData.a(), paramInnerShareData.jdField_a_of_type_Boolean, paramInnerShareData.b, null, paramInnerShareData.c, paramInnerShareData.d, paramInnerShareData.e), a(paramInnerShareData));
  }
  
  public void c(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null)
    {
      QMLog.e("ShareManager", "Failed to shareAppPictureMessage. shareData is null");
      return;
    }
    QMLog.d("ShareManager", "shareAppPictureMessage. shareData=" + paramInnerShareData);
    if (paramInnerShareData.isLocalPic)
    {
      e(paramInnerShareData);
      return;
    }
    d(paramInnerShareData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjo
 * JD-Core Version:    0.7.0.1
 */