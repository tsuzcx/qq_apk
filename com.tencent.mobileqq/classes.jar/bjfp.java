import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.3;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.4;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.6;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import cooperation.qzone.share.QZoneShareActivity;
import eipc.EIPCClient;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

@ProxyService(proxy=ShareProxy.class)
public class bjfp
  implements ShareProxy
{
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + localObject.length);
    int i = 0;
    while ((i < 10) && (localObject.length > 32768))
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(0.7F, 0.7F);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + localObject.length);
      i += 1;
    }
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + localObject.length);
    return BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3)
  {
    if (paramInt == 3) {
      WXShareHelper.getInstance().shareWebPageToWXFriend(String.valueOf(System.currentTimeMillis()), paramString1, paramBitmap, "QQ小程序 · " + paramString2, paramString3);
    }
    for (;;)
    {
      paramString1 = new Bundle();
      paramString1.putParcelable("MiniAppInfoForSDK", paramMiniAppInfo);
      QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", "mini_record_wx_share_miniapp_for_sdk", paramString1);
      return;
      if (paramInt == 4) {
        WXShareHelper.getInstance().shareWebPageToWXFriendCircle(String.valueOf(System.currentTimeMillis()), "QQ小程序 · " + paramString2 + ": " + paramString1, paramBitmap, "", paramString3);
      }
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(paramMiniAppInfo, paramInt, paramString1, paramString2, ImageUtil.drawableToBitmap(paramActivity.getResources().getDrawable(2130848333)), paramString3);
  }
  
  private void a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label44;
      }
      xvv.b("ShareProxyImpl", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      xvv.b("ShareProxyImpl", "start load URLDrawable.");
    }
  }
  
  private void e(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null) {
      return;
    }
    switch (paramInnerShareData.shareTarget)
    {
    case 2: 
    default: 
      return;
    case 0: 
      ShareUtils.startSharePicToQQ(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath);
      return;
    case 1: 
      ShareUtils.startSharePicToQzone(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath, paramInnerShareData.getMiniAppInfo().name);
      return;
    case 3: 
      ShareUtils.startSharePicToWeChat(paramInnerShareData.fromActivity, ShareUtils.getFileUri(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath), true);
      return;
    case 4: 
      ShareUtils.startSharePicToWeChat(paramInnerShareData.fromActivity, ShareUtils.getFileUri(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath), false);
      return;
    }
    ShareUtils.startSharePicToQQ(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath, paramInnerShareData.shareChatModel);
  }
  
  private void f(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null) {
      return;
    }
    MiniProgramShareUtils.shareUpdatableMsg(paramInnerShareData.fromActivity, paramInnerShareData.getMiniAppId(), paramInnerShareData.getMiniAppInfo().verType, paramInnerShareData.templateId, paramInnerShareData.event, paramInnerShareData.callbackId);
  }
  
  public void a(InnerShareData paramInnerShareData)
  {
    if ((paramInnerShareData == null) || (paramInnerShareData.fromActivity == null))
    {
      QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. shareData or activity is null");
      return;
    }
    if (!(paramInnerShareData.fromActivity instanceof GameActivity1)) {
      QLog.e("ShareProxyImpl", 1, "shareQQArk. not GameActivity1");
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. miniAppInfo is null");
      return;
    }
    bjfq localbjfq = new bjfq(this, paramInnerShareData);
    Object localObject;
    com.tencent.mobileqq.mini.sdk.ShareChatModel localShareChatModel;
    label153:
    int i;
    if (paramInnerShareData.entryModel != null)
    {
      localObject = new com.tencent.mobileqq.mini.sdk.EntryModel(paramInnerShareData.entryModel.type, paramInnerShareData.entryModel.uin, paramInnerShareData.entryModel.name, paramInnerShareData.entryModel.isAdmin);
      if (paramInnerShareData.shareChatModel == null) {
        break label471;
      }
      localShareChatModel = new com.tencent.mobileqq.mini.sdk.ShareChatModel(paramInnerShareData.shareChatModel.type, paramInnerShareData.shareChatModel.uin, paramInnerShareData.shareChatModel.name);
      localObject = new MiniArkShareModelBuilder().setAppId(localMiniAppInfo.appId).setTitle(localMiniAppInfo.name).setDescription(paramInnerShareData.summary).setShareScene(paramInnerShareData.shareScene).setShareTemplateType(1).setShareBusinessType(localMiniAppInfo.getReportType()).setPicUrl(paramInnerShareData.sharePicPath).setVidUrl(null).setJumpUrl(paramInnerShareData.entryPath).setIconUrl(localMiniAppInfo.iconUrl).setVersionType(localMiniAppInfo.verType).setVersionId(localMiniAppInfo.versionId).setWebURL(paramInnerShareData.webURL).setTemplateId(paramInnerShareData.templateId).setTemplateData(paramInnerShareData.templateData).setEntryModel((com.tencent.mobileqq.mini.sdk.EntryModel)localObject).setShareChatModel(localShareChatModel).setShareTarget(paramInnerShareData.shareTarget).setRcvOpenId(paramInnerShareData.recvOpenId).createMiniArkShareModel();
      int j = 0;
      i = j;
      if (!StringUtil.isEmpty(((MiniArkShareModel)localObject).getTemplateId()))
      {
        i = j;
        if (!StringUtil.isEmpty(((MiniArkShareModel)localObject).getTemplateData())) {
          i = 2;
        }
      }
      if (TextUtils.isEmpty(((MiniArkShareModel)localObject).getRcvOpenId())) {
        break label477;
      }
      i = 5;
    }
    label471:
    label477:
    for (;;)
    {
      MiniAppCmdUtil.getInstance().getShareInfo(MiniProgramShareUtils.newShareInfoRequest(((MiniArkShareModel)localObject).getAppId(), ((MiniArkShareModel)localObject).getTitle(), ((MiniArkShareModel)localObject).getDescription(), (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), ((MiniArkShareModel)localObject).getShareScene(), ((MiniArkShareModel)localObject).getShareTemplateType(), ((MiniArkShareModel)localObject).getShareBusinessType(), ((MiniArkShareModel)localObject).getPicUrl(), ((MiniArkShareModel)localObject).getVidUrl(), ((MiniArkShareModel)localObject).getJumpUrl(), ((MiniArkShareModel)localObject).getIconUrl(), paramInnerShareData.extInfo, ((MiniArkShareModel)localObject).getVersionType(), ((MiniArkShareModel)localObject).getVersionId(), i, paramInnerShareData.withShareTicket, ((MiniArkShareModel)localObject).getWebURL(), ((MiniArkShareModel)localObject).getAppidRich(), ((MiniArkShareModel)localObject).getTemplateId(), ((MiniArkShareModel)localObject).getTemplateData(), ((MiniArkShareModel)localObject).getRcvOpenId()), new bjfr(this, i, paramInnerShareData, (MiniArkShareModel)localObject, localbjfq));
      return;
      localObject = null;
      break;
      localShareChatModel = null;
      break label153;
    }
  }
  
  public void b(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    String str;
    Intent localIntent;
    if (StringUtil.isEmpty(paramInnerShareData.summary))
    {
      str = localMiniAppInfo.desc;
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
      localIntent.putExtra("isSharedFromMiniProgram", true);
      localIntent.putExtra("miniShareParamAppId", localMiniAppInfo.appId);
      localIntent.putExtra("miniShareParamTitle", localMiniAppInfo.name);
      localIntent.putExtra("miniShareParamDescription", str);
      localIntent.putExtra("miniShareParamShareScene", 1);
      localIntent.putExtra("miniShareParamTemplateType", 1);
      localIntent.putExtra("miniShareParamBusinessType", localMiniAppInfo.getReportType());
      localIntent.putExtra("miniShareParamPicUrl", paramInnerShareData.sharePicPath);
      localIntent.putExtra("miniShareParamJumpUrl", paramInnerShareData.entryPath);
      localIntent.putExtra("miniShareParamIconUrl", localMiniAppInfo.iconUrl);
      localIntent.putExtra("miniShareParamVersionType", localMiniAppInfo.verType);
      localIntent.putExtra("miniShareParamVersionId", localMiniAppInfo.versionId);
      if (paramInnerShareData.shareSource != 11) {
        break label239;
      }
    }
    label239:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("miniShareIsFromInnerButton", bool);
      localActivity.startActivity(localIntent);
      return;
      str = paramInnerShareData.summary;
      break;
    }
  }
  
  public void c(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    if (!WXShareHelper.getInstance().isWXinstalled())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.3(this, localActivity));
      return;
    }
    if (!WXShareHelper.getInstance().isWXsupportApi())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.4(this, localActivity));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startShareToWeChat. title=" + paramInnerShareData.summary + ",sharePicPath=" + paramInnerShareData.sharePicPath + ",entryPath=" + paramInnerShareData.entryPath);
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    String str2 = paramInnerShareData.summary;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    int i = paramInnerShareData.getShareType();
    MiniProgramShareUtils.shareAsWeChatMsg(localMiniAppInfo.appId, localMiniAppInfo.name, str1, 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.entryPath, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, null, i, new bjft(this, localActivity, paramInnerShareData, localMiniAppInfo, i, str1));
  }
  
  public void d(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    ThreadManager.getUIHandler().post(new ShareProxyImpl.6(this, localActivity, paramInnerShareData));
  }
  
  public int getDefaultShareTarget()
  {
    return 0;
  }
  
  public boolean isShareTargetAvailable(Context paramContext, int paramInt)
  {
    return true;
  }
  
  public void onJsShareAppMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QLog.w("ShareProxyImpl", 1, "onJsShareAppMessage. Unknown type of data");
      return;
    }
    QLog.d("ShareProxyImpl", 1, "onJsShareAppMessage. data = " + paramObject);
    paramObject = (InnerShareData)paramObject;
    switch (paramObject.shareTarget)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      a(paramObject);
      return;
    case 1: 
      b(paramObject);
      return;
    case 3: 
    case 4: 
      c(paramObject);
      return;
    }
    f(paramObject);
  }
  
  public void onJsShareAppPictureMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QLog.w("ShareProxyImpl", 1, "onJsShareAppPictureMessage. Unknown type of data");
      return;
    }
    QLog.d("ShareProxyImpl", 1, "onJsShareAppMessage. data = " + paramObject);
    paramObject = (InnerShareData)paramObject;
    if (paramObject.isLocalPic)
    {
      e(paramObject);
      return;
    }
    d(paramObject);
  }
  
  public void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void share(Activity paramActivity, ShareData paramShareData) {}
  
  public void sharePic(Activity paramActivity, ShareData paramShareData)
  {
    if ((paramActivity == null) || (paramShareData == null) || (TextUtils.isEmpty(paramShareData.sharePicPath))) {
      return;
    }
    switch (paramShareData.shareTarget)
    {
    default: 
      return;
    }
    ShareUtils.startSharePicToQQ(paramActivity, paramShareData.sharePicPath);
  }
  
  public void showSharePanel(IMiniAppContext paramIMiniAppContext)
  {
    ((MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class)).onCapsuleButtonMoreClick(paramIMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfp
 * JD-Core Version:    0.7.0.1
 */