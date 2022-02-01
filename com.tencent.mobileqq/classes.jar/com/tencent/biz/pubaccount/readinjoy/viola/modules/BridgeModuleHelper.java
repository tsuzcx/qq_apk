package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher;
import com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.AccountProfileInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui.ComponentAdapter;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate.OnTitleChangeListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class BridgeModuleHelper
{
  public static void A(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    paramJSONObject = paramJSONObject.optJSONArray("bids");
    ArrayList localArrayList;
    if (paramJSONObject != null) {
      localArrayList = new ArrayList();
    }
    try
    {
      while (i < paramJSONObject.length())
      {
        localArrayList.add(i, paramJSONObject.get(i).toString());
        i += 1;
      }
      HtmlOffline.a(localArrayList, ReadInJoyUtils.a(), new BridgeModuleHelper.13(paramBridgeModule, paramString), true, false);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BridgeModuleHelper", 2, "batchCheckUpdate error" + paramJSONObject.getMessage());
      paramBridgeModule.invokeErrorCallJS(paramString, null);
    }
  }
  
  public static void B(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.d("BridgeModuleHelper", 1, "Error in isCached, the param is null!");
      return;
    }
    paramJSONObject = HtmlOffline.a(paramJSONObject.optString("bid"));
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null) {}
    try
    {
      localJSONObject.put("result", true);
      localJSONObject.put("version", paramJSONObject);
      for (;;)
      {
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
        localJSONObject.put("result", false);
        localJSONObject.put("version", "");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BridgeModuleHelper", 2, "isCached,version:" + paramJSONObject);
        }
      }
    }
  }
  
  public static void C(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i = -1;
    if (paramJSONObject != null) {
      i = ViolaUtils.getInt(Integer.valueOf(paramJSONObject.optInt("allowCacheTime")));
    }
    if (a())
    {
      if (i > 0)
      {
        b(paramBridgeModule, "webview", paramString);
        return;
      }
      c(paramBridgeModule, "webview", paramString);
      return;
    }
    d(paramBridgeModule, paramString, "no authorize");
  }
  
  public static void D(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null)) {}
    ReadInJoyUserInfoModule localReadInJoyUserInfoModule;
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          return;
          localReadInJoyUserInfoModule = a();
        } while (localReadInJoyUserInfoModule == null);
        paramJSONObject = paramJSONObject.optJSONArray("uins");
      } while (paramJSONObject == null);
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    } while (localArrayList.isEmpty());
    localReadInJoyUserInfoModule.a(localArrayList, new BridgeModuleHelper.21(localArrayList, paramString, paramBridgeModule));
  }
  
  private static int a()
  {
    int i = 1;
    if (StudyModeManager.a()) {
      i = 8193;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    int i;
    if (paramInt == 5) {
      i = 4;
    }
    do
    {
      return i;
      if (paramInt == 11) {
        return 5;
      }
      if (paramInt == 6) {
        return 6;
      }
      if (paramInt == 12) {
        return 7;
      }
      if (paramInt == 13) {
        return 8;
      }
      i = paramInt;
    } while (paramInt >= 15);
    if (paramInt == 8) {
      return 2;
    }
    return 3;
  }
  
  private static int a(int paramInt, JSONObject paramJSONObject)
  {
    int j = 2;
    int i;
    if ((paramInt == 3) || (paramInt == 2)) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramInt == 4);
      i = j;
    } while (paramInt == 5);
    return paramJSONObject.optInt("type");
  }
  
  private static Intent a(ArticleInfo paramArticleInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, int paramInt3, String paramString5, int paramInt4)
  {
    Intent localIntent = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", paramArticleInfo);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("biu_rowkey", paramString1);
    }
    localIntent.putExtra("arg_from_type", paramInt1);
    localIntent.putExtra("arg_type", paramInt2);
    localIntent.putExtra("result_js_callback", paramString2);
    localIntent.putExtra("biu_src", paramInt4);
    localIntent.putExtra("feed_id", paramString3);
    localIntent.putExtra("feedsType", paramLong1);
    localIntent.putExtra("ugc_comment", paramString4);
    localIntent.putExtra("arg_account_id", paramLong2);
    localIntent.putExtra("arg_account_type", paramInt3);
    localIntent.putExtra("arg_source_url", paramString5);
    return localIntent;
  }
  
  public static ReadInJoyUserInfoModule a()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject == null) {
      return null;
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject == null) {
      return null;
    }
    return ((ReadInJoyLogicManager)localObject).a().a();
  }
  
  public static QQCustomDialog a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity;
    if (paramJSONObject != null)
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity != null) {}
    }
    else
    {
      return null;
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(localBaseActivity, 2131755842);
    localQQCustomDialog.setContentView(2131559060);
    localQQCustomDialog.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
    localQQCustomDialog.getMessageTextView().setMaxHeight(DisplayUtil.a(localBaseActivity, 200.0F));
    localQQCustomDialog.setTitle(paramJSONObject.optString("title"));
    localQQCustomDialog.setMessage(paramJSONObject.optString("text"));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    if (paramJSONObject.optBoolean("needOkBtn", true)) {
      localQQCustomDialog.setPositiveButton(paramJSONObject.optString("okBtnText", HardCodeUtil.a(2131701269)), new BridgeModuleHelper.4(paramJSONObject, paramBridgeModule, paramString));
    }
    if (paramJSONObject.optBoolean("needCancelBtn", true)) {
      localQQCustomDialog.setNegativeButton(paramJSONObject.optString("cancelBtnText", HardCodeUtil.a(2131701265)), new BridgeModuleHelper.5(paramJSONObject, paramBridgeModule, paramString));
    }
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 117: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    default: 
      return "";
    case 114: 
      return "showUGCEditPage";
    case 115: 
      return "showUGCVideoUploadPage";
    case 116: 
      return "showUGCVideoRecordPage";
    }
    return "showQAAskEditor";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentNickname();
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  private static HashMap<String, Object> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      HashMap localHashMap = new HashMap();
      if (TextUtils.isEmpty(paramJSONObject.optString("bgclr"))) {
        localHashMap.put(ViolaUiDelegate.d, paramJSONObject.optString("bgclr"));
      }
      if (TextUtils.isEmpty(paramJSONObject.optString("txtclr"))) {
        localHashMap.put(ViolaUiDelegate.c, paramJSONObject.optString("txtclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("titleclr"))) {
        localHashMap.put(ViolaUiDelegate.e, paramJSONObject.optString("titleclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("alpha"))) {
        localHashMap.put(ViolaUiDelegate.f, paramJSONObject.optString("alpha"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("statusBarColor"))) {
        localHashMap.put(ViolaUiDelegate.g, paramJSONObject.optString("statusBarColor"));
      }
      return localHashMap;
    }
    return null;
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = (QQAppInterface)ReadInJoyUtils.a();
    String str;
    if (localObject3 != null)
    {
      localObject1 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      str = ((QQAppInterface)localObject3).getAccount();
      if (localObject1 == null) {
        break label121;
      }
    }
    label121:
    Object localObject2;
    for (Object localObject1 = ((TicketManager)localObject1).getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());; localObject2 = null)
    {
      localObject3 = a((QQAppInterface)localObject3, str);
      try
      {
        localJSONObject.put("uin", str);
        localJSONObject.put("skey", localObject1);
        localJSONObject.put("nick", localObject3);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("BridgeModuleHelper", 2, "getReportInfo() JSONException" + localJSONException.getMessage());
        return localJSONObject;
      }
    }
  }
  
  private static void a(Activity paramActivity, int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    if (((QQAppInterface)ReadInJoyUtils.a() != null) && (paramActivity != null))
    {
      Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 25);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      localIntent.putExtra("key_from_kandian_uploadimg", true);
      String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "readinjoy_avatar_upload/");
      localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt3);
      localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt4);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt5);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt6);
      localIntent.putExtra("from", paramInt1);
      localIntent.putExtra("type", paramInt2);
      localIntent.putExtra("finish", true);
      localIntent.putExtra("callbackId", paramString);
      paramActivity.startActivityForResult(localIntent, paramByte);
      AlbumUtil.anim(paramActivity, false, true);
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  private static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    RIJJumpUtils.a(paramContext, paramString, paramBundle);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str1 = "";
    if (paramBundle.containsKey("cmd")) {
      str1 = paramBundle.getString("cmd");
    }
    String str2 = "";
    if (paramBundle.containsKey("data_error_msg")) {
      str2 = paramBundle.getString("data_error_msg");
    }
    int i = -1;
    if (paramBundle.containsKey("data_error_code")) {
      i = paramBundle.getInt("data_error_code");
    }
    QLog.e("BridgeModuleHelper", 1, "request web sso error, cmd: " + str1 + ", failMsg: " + str2 + ", errorCode: " + i);
  }
  
  private static void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, Intent paramIntent, long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, BridgeModule paramBridgeModule)
  {
    int i = paramJSONObject.optInt("hiddenBiuComponent");
    Object localObject = "";
    if (i == 1) {
      localObject = new String(Base64Util.decode(paramJSONObject.optString("newComment"), 2));
    }
    if (i == 1)
    {
      paramJSONObject = (JSONObject)localObject;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null)
      {
        paramJSONObject = (JSONObject)localObject;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() > 0) {
          paramJSONObject = (String)localObject + "//";
        }
      }
      paramJSONObject = "：" + paramJSONObject;
      localObject = (QQAppInterface)ReadInJoyUtils.a();
      if (localObject != null) {
        ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(ReadInJoyUtils.a(), paramLong1, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo, 0L, paramJSONObject, paramLong2, -1L, paramInt1, paramString, paramInt2, paramArticleInfo);
      }
      paramBridgeModule.onActivityResult(113, -1, paramIntent);
      return;
    }
    if (paramJSONObject.optInt("hideSuccessToast") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.putExtra("hideSuccessToast", bool);
      BaseActivity.sTopActivity.startActivityForResult(paramIntent, 113);
      BaseActivity.sTopActivity.overridePendingTransition(0, 0);
      return;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
    a(paramJSONObject, paramArticleInfo);
    paramArticleInfo.mTitle = new String(Base64Util.decode(paramString1, 0));
    paramArticleInfo.mSummary = "";
    if ((paramInt1 == 3) || (paramInt1 == 2))
    {
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramString1 = new SocializeFeedsInfo.UGCPicInfo();
      paramJSONObject = paramJSONObject.optJSONArray("ugcPicInfo");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramString1.c = paramJSONObject.getJSONObject(0).optString("ugcPicUrl");
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
      }
    }
    for (;;)
    {
      if (paramInt2 == 22)
      {
        paramJSONObject = new SocializeFeedsInfo.AccountProfileInfo();
        paramJSONObject.jdField_a_of_type_JavaLangString = paramString3;
        paramJSONObject.b = paramString4;
        paramJSONObject.c = paramString5;
        paramJSONObject.jdField_a_of_type_Long = paramLong;
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo = paramJSONObject;
      }
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = paramInt1;
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString = paramArticleInfo.mTitle;
      return;
      if ((paramInt1 == 4) || (paramInt1 == 5))
      {
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b = new ArrayList();
        paramString1 = new SocializeFeedsInfo.UGCVideoInfo();
        paramJSONObject = paramJSONObject.optJSONObject("ugcVideoInfo");
        if (paramJSONObject != null)
        {
          paramString1.d = paramJSONObject.optString("ugcVideoCoverUrl");
          paramString1.jdField_a_of_type_Long = paramJSONObject.optInt("ugcVideoDuration");
          paramString1.e = paramString2;
          paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.add(paramString1);
        }
      }
      else if (paramInt1 == 1)
      {
        paramArticleInfo.mFirstPagePicUrl = "";
      }
    }
  }
  
  public static void a(BridgeModule paramBridgeModule)
  {
    if ((paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).disableSwitcher();
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str1;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getStringExtra("arg_callback");
      } while (TextUtils.isEmpty(str1));
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("arg_result_json");
    } while (paramIntent == null);
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramIntent.put("retCode", 0);
      String str2 = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModuleHelper", 2, a(paramInt1) + " result:" + ReadInJoyDeliverUGCActivity.a(str2));
      }
      paramBridgeModule.invokeCallJS(str1, paramIntent);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 2, "callJsDeliverResult error:" + paramBridgeModule.getMessage());
      return;
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("retCode", paramInt2);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModuleHelper", 2, a(paramInt1) + " result:" + paramIntent);
      }
      paramBridgeModule.invokeErrorCallJS(str1, "result not ok");
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 2, "callJsDeliverResult fail error:" + paramBridgeModule.getMessage());
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, int paramInt, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arg_callback");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    long l1 = paramIntent.getLong("duration_time");
    long l2 = paramIntent.getLong("elapsed_time");
    boolean bool1 = paramIntent.getBoolean("profitable_flag", false);
    boolean bool2 = paramIntent.getBoolean("is_end", false);
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "motiveResult: durationTime = " + l1 + "elaspedTime = " + l2 + "profitable =" + bool1);
    }
    paramIntent = new JSONObject();
    if (paramInt == -1) {}
    for (;;)
    {
      try
      {
        paramIntent.put("retCode", 0);
        paramIntent.put("elapsedTime", l2);
        paramIntent.put("totalTime", l1);
        paramIntent.put("profitable", bool1);
        paramIntent.put("isEnd", bool2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      paramBridgeModule.invokeCallJS(str, paramIntent);
      return;
      paramIntent.put("retCode", -1);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, Intent paramIntent)
  {
    if ((paramIntent == null) || (BaseActivity.sTopActivity == null)) {}
    String str2;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str2));
    int i = paramIntent.getIntExtra("result_code", -1);
    if (i == 0)
    {
      if (Looper.myLooper() == null) {
        Looper.prepare();
      }
      new Handler(BaseActivity.sTopActivity.getMainLooper()).postDelayed(new BridgeModuleHelper.20(), 200L);
    }
    String str1 = "";
    if (paramIntent.hasExtra("result_msg")) {
      str1 = paramIntent.getStringExtra("result_msg");
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("retCode", i);
      paramIntent.put("msg", str1);
      paramBridgeModule.invokeCallJS(str2, paramIntent);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      paramBridgeModule.printStackTrace();
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (RIJXTabFrameUtils.a.a()) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("result", i);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
      }
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "isInkanDianTab exception e = ", paramBridgeModule);
    }
  }
  
  private static void a(BridgeModule paramBridgeModule, String paramString, File paramFile)
  {
    Bundle localBundle = new Bundle();
    paramFile = new DownloadTask(paramString, paramFile);
    paramFile.d = 60L;
    ((DownloaderFactory)ReadInJoyUtils.a().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(paramFile, new BridgeModuleHelper.8(paramBridgeModule, paramString), localBundle);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    String str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", GalleryReportedUtils.a(paramBridgeModule.getViolaInstance().getActivity()));
        localJSONObject.put("os", "1");
        localJSONObject.put("uin", String.valueOf(ReadInJoyUtils.a()));
        localJSONObject.put("rowkey", paramString1);
        if (paramInt1 >= 0) {
          localJSONObject.put("source", String.valueOf(paramInt1));
        }
        localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
        localJSONObject.put("vid", paramString2);
        if (paramBoolean) {
          localJSONObject.put("cancel", "1");
        }
        if (paramInt2 >= 0) {
          localJSONObject.put("sourcefrom", String.valueOf(paramInt2));
        }
        if (paramInt3 >= 0) {
          localJSONObject.put("share_unit", String.valueOf(paramInt3));
        }
        if (paramInt4 != 4) {
          continue;
        }
        localJSONObject.put("type", 3);
        paramBridgeModule = localJSONObject.toString();
      }
      catch (Exception paramString1)
      {
        JSONObject localJSONObject;
        paramBridgeModule = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BridgeModuleHelper", 2, "shareReport:" + paramString1.toString());
        paramBridgeModule = str;
        continue;
        if (paramInt4 != 11) {
          continue;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString5, "", paramBridgeModule.a().a(), false);
      }
      paramBridgeModule = new VideoR5.Builder(paramBridgeModule);
      if (paramInt4 != 4) {
        continue;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString4, paramString3, paramBridgeModule.a().a(), false);
      return;
      if (paramInt4 == 11) {
        localJSONObject.put("type", 4);
      }
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, String paramString3)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          paramBridgeModule.invokeErrorCallJS(paramString2, HardCodeUtil.a(2131701270));
        }
      }
      else
      {
        if ((paramString1.contains("weishi")) || (paramString1.contains("weishi://feed"))) {
          if (WeishiGuideUtils.a(localBaseActivity)) {
            VideoFeedsWeiShiUtils.a(localBaseActivity, "video_type_videopublic");
          }
        }
        while (!TextUtils.isEmpty(paramString2))
        {
          paramBridgeModule.invokeCallJS(paramString2, null);
          return;
          QQToast.a(localBaseActivity, -1, HardCodeUtil.a(2131701276), 0).b(localBaseActivity.getResources().getDimensionPixelSize(2131299166));
          VideoFeedsWeiShiUtils.b(localBaseActivity, "video_type_videopublic");
          continue;
          if (!ReadInJoyAdUtils.a(localBaseActivity, paramString1))
          {
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW");
            String str = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              str = RIJJumpUtils.a(0);
            }
            localIntent.putExtra("big_brother_source_key", str);
            localIntent.putExtra("big_brother_ref_source_key", RIJJumpUtils.a(0));
            localIntent.setData(Uri.parse(paramString1));
            localBaseActivity.startActivity(localIntent);
          }
        }
      }
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    boolean bool;
    if (("weishi://feed".equals(paramString1)) || ("weishi".equals(paramString1))) {
      bool = WeishiGuideUtils.a(localBaseActivity);
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        if (!bool) {
          break label122;
        }
        paramString1.put("result", i);
        if (!paramBoolean) {
          break label128;
        }
        paramBridgeModule.invokeCallJS(paramString2, paramString1);
        return;
      }
      catch (JSONException paramBridgeModule) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("BridgeModuleHelper", 2, "hasApp error" + paramBridgeModule.getMessage());
      return;
      bool = PackageUtil.a(localBaseActivity, paramString1);
      continue;
      label122:
      i = 0;
    }
    label128:
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString2, paramString1, true);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    paramBridgeModule = new BridgeModuleHelper.15(paramBridgeModule, paramString);
    if (localBaseActivity == null)
    {
      paramBridgeModule.a(null, new GdtAdError(5));
      return;
    }
    paramString = paramJSONObject.optString("posId", "1041305064862972");
    long l1 = paramJSONObject.optLong("publicId", 0L);
    long l2 = paramJSONObject.optLong("articleId", 0L);
    int i = paramJSONObject.optInt("sourceFrom", 0);
    int j = paramJSONObject.optInt("shareRate", 0);
    ReadInJoyMotiveAdModule.a().a(localBaseActivity, paramString, l1, l2, i, j, paramBridgeModule);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback before");
    AdThreadManager.INSTANCE.post(new BridgeModuleHelper.14(paramJSONObject, paramBoolean, paramBridgeModule, paramString), 4);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localJSONObject = a();
      if (paramBoolean) {
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      }
    }
    else
    {
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = paramJSONObject.optJSONArray("imageIDs");
        int k = paramJSONObject.optInt("index");
        String str1 = paramJSONObject.optString("srcID");
        boolean bool1 = paramJSONObject.optBoolean("isNotShowIndex", true);
        boolean bool2 = paramJSONObject.optBoolean("showTitle", false);
        String str2 = new String(Base64Util.decode(paramJSONObject.optString("title", ""), 0));
        String str3 = paramJSONObject.optString("articleUrl", "");
        boolean bool3 = paramJSONObject.optBoolean("isReport", false);
        long l1 = paramJSONObject.optLong("touin");
        long l2 = paramJSONObject.optLong("feeds_id");
        int m = paramJSONObject.optInt("feeds_type");
        long l3 = paramJSONObject.optLong("articleId");
        int n = paramJSONObject.optInt("source");
        int i = 0;
        if (localObject2 != null) {
          i = ((JSONArray)localObject2).length();
        }
        if (Boolean.valueOf(bool3).booleanValue())
        {
          Object localObject1 = new PublicAccountShowPictureReport();
          ((PublicAccountShowPictureReport)localObject1).parse(paramJSONObject);
          paramJSONObject = (JSONObject)localObject1;
          if (QLog.isColorLevel()) {
            QLog.d("BridgeModuleHelper", 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
          }
          if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BridgeModuleHelper", 2, "imageList is null or length is 0");
            }
            paramBridgeModule.invokeErrorCallJS(paramString, "imageList is null or length is 0");
            return;
          }
          localObject1 = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            ((ArrayList)localObject1).add(((JSONArray)localObject2).get(j).toString());
            j += 1;
            continue;
          }
          localObject2 = paramBridgeModule.getViolaInstance().getActivity();
          if (localObject2 == null) {
            break;
          }
          Intent localIntent = new Intent((Context)localObject2, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", k);
          localBundle.putStringArrayList("seqNum", (ArrayList)localObject1);
          localBundle.putBoolean("needBottomBar", false);
          localBundle.putBoolean("IS_EDIT", false);
          localBundle.putBoolean("is_use_path", true);
          localBundle.putBoolean("is_show_action", true);
          localBundle.putBoolean("is_not_show_index", bool1);
          localBundle.putBoolean("is_grid_image_report", true);
          localBundle.putString("to_uin", Long.toString(l1));
          localBundle.putString("feeds_id", Long.toString(l2));
          localBundle.putString("article_id", Long.toString(l3));
          localBundle.putString("scroll_image_r5", RIJTransMergeKanDianReport.a(i, -1, Integer.toString(n), m, "", "", null));
          localBundle.putString("read_article_r5", RIJTransMergeKanDianReport.a(i, -1, Integer.toString(n), m, "", null));
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("src_id", str1);
          }
          if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
          {
            localBundle.putBoolean("is_show_content_url", true);
            localBundle.putString("article_url", str3);
            localBundle.putString("article_title", str2);
          }
          if ((paramJSONObject != null) && (paramJSONObject.isReport)) {
            localBundle.putString("PublicAccountShowPictureReport", paramJSONObject.toString());
          }
          localIntent.putExtras(localBundle);
          ((Activity)localObject2).startActivityForResult(localIntent, 100);
          paramBridgeModule.invokeCallJS(paramString, null);
          return;
        }
      }
      catch (Exception paramBridgeModule)
      {
        paramBridgeModule.printStackTrace();
        return;
      }
      paramJSONObject = null;
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    if (paramFragment == null) {
      paramFragment = paramBridgeModule.getViolaInstance().getFragment();
    }
    for (;;)
    {
      if (paramFragment == null) {}
      label120:
      for (;;)
      {
        return;
        if ((paramFragment instanceof ViolaFragment)) {}
        for (paramFragment = ((ViolaFragment)paramFragment).getTtileChangelistener();; paramFragment = null)
        {
          if (paramFragment == null) {
            break label120;
          }
          String str = paramJSONObject.optString("position");
          paramJSONObject = paramJSONObject.optString("text");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          if (str.equals("right"))
          {
            paramFragment.a(paramJSONObject, new BridgeModuleHelper.17(paramBridgeModule, paramString));
            return;
          }
          if (!str.equals("left")) {
            break;
          }
          paramFragment.b(paramJSONObject, new BridgeModuleHelper.18(paramBridgeModule, paramString));
          return;
        }
      }
    }
  }
  
  public static void a(WebSsoBody.WebSsoResponseBody paramWebSsoResponseBody, Bundle paramBundle)
  {
    if ((paramWebSsoResponseBody == null) || (paramBundle == null)) {
      return;
    }
    String str = "";
    if (paramBundle.containsKey("cmd")) {
      str = paramBundle.getString("cmd");
    }
    paramBundle = "";
    if (paramWebSsoResponseBody.data != null) {
      paramBundle = paramWebSsoResponseBody.data.get();
    }
    int i = -1;
    if (paramWebSsoResponseBody.ret != null) {
      i = paramWebSsoResponseBody.ret.get();
    }
    QLog.d("BridgeModuleHelper", 2, "request web sso success, cmd: " + str + ", ret: " + i + ", data: " + paramBundle);
  }
  
  private static void a(File paramFile, String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new BridgeModuleHelper.19(paramString, paramFile));
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString));
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        paramString.startActivity(localIntent);
      }
    }
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(BaseActivity.sTopActivity, paramString, paramBundle);
    }
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    int k = 0;
    int j = 0;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Object localObject = "";
    String str2 = "";
    for (;;)
    {
      try
      {
        int i = paramJSONObject.optInt("orientation");
        j = k;
        String str1;
        QLog.e("BridgeModuleHelper", 1, "showMotiveAd e", paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        try
        {
          str1 = paramJSONObject.optString("adInfo");
          localObject = str1;
          j = k;
          k = paramJSONObject.optInt("rewardTime", 0);
          localObject = str1;
          j = k;
          paramJSONObject = paramJSONObject.optString("rewardText");
          j = k;
          localObject = str1;
          ReadInJoyMotiveAdModule.a().a(localBaseActivity, i, (String)localObject, j, paramString, paramJSONObject);
          return;
        }
        catch (Exception paramJSONObject)
        {
          break label95;
        }
        paramJSONObject = paramJSONObject;
        i = 0;
      }
      label95:
      paramJSONObject = str2;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      ViolaAccessHelper.a(localBaseActivity, paramJSONObject);
    }
  }
  
  private static void a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ugcAtLevelList");
    if (paramJSONObject != null)
    {
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
          Object localObject = paramJSONObject.getJSONObject(i);
          localBiuCommentInfo.mUin = Long.valueOf(((JSONObject)localObject).optLong("uin"));
          localBiuCommentInfo.mOrigBiuComment = new String(Base64Util.decode(((JSONObject)localObject).optString("comment"), 0));
          localBiuCommentInfo.mBiuComment = localBiuCommentInfo.mOrigBiuComment;
          localBiuCommentInfo.mBiuTime = ((JSONObject)localObject).optInt("biuTime");
          localBiuCommentInfo.mFeedsType = ((JSONObject)localObject).optInt("feeds_type", 1);
          localBiuCommentInfo.mOpType = ((JSONObject)localObject).optInt("op_type");
          String str1 = ((JSONObject)localObject).optString("jumpName");
          String str2 = ((JSONObject)localObject).optString("jumpUrl");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            localBiuCommentInfo.jumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(Base64Util.decode(str1, 0)), str2);
          }
          try
          {
            localObject = ((JSONObject)localObject).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localBiuCommentInfo.mFeedId = Long.valueOf(new BigInteger((String)localObject).longValue());
            }
            paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo, long paramLong1, long paramLong2)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.getJSONArray("biuLevelList");
      paramArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong1);
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b = Long.valueOf(paramLong2);
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    } while (paramJSONObject == null);
    int i = 0;
    while (i < paramJSONObject.length())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
      Object localObject = paramJSONObject.getJSONObject(i);
      localBiuCommentInfo.mUin = Long.valueOf(((JSONObject)localObject).optLong("uin"));
      localBiuCommentInfo.mOrigBiuComment = new String(Base64Util.decode(((JSONObject)localObject).optString("comment"), 0));
      localBiuCommentInfo.mBiuComment = localBiuCommentInfo.mOrigBiuComment;
      localBiuCommentInfo.mBiuTime = ((JSONObject)localObject).optInt("biuTime");
      localBiuCommentInfo.mFeedsType = ((JSONObject)localObject).optInt("feeds_type", 1);
      localBiuCommentInfo.mOpType = ((JSONObject)localObject).optInt("op_type");
      String str1 = ((JSONObject)localObject).optString("jumpName");
      String str2 = ((JSONObject)localObject).optString("jumpUrl");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        localBiuCommentInfo.jumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(Base64Util.decode(str1, 0)), str2);
      }
      try
      {
        localObject = ((JSONObject)localObject).optString("feedsId");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBiuCommentInfo.mFeedId = Long.valueOf(new BigInteger((String)localObject).longValue());
        }
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = true;
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    Object localObject = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    int i;
    if (paramJSONObject.optInt("isQuestion", 0) == 1) {
      i = 1;
    }
    for (;;)
    {
      int j;
      int k;
      if (paramJSONObject.optInt("isAnswer", 0) == 1)
      {
        j = 1;
        k = paramJSONObject.optInt("adtag");
      }
      try
      {
        paramJSONObject = new String(Base64Util.decode((String)localObject, 0));
        localObject = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverUGCActivity.class);
        ((Intent)localObject).putExtra("arg_topic_id", str1);
        if ((i != 0) || (j != 0))
        {
          i = 1;
          if (i != 0) {
            break label240;
          }
          bool1 = true;
          ((Intent)localObject).putExtra("support_topic", bool1);
          if (i != 0) {
            break label246;
          }
          bool1 = bool2;
          ((Intent)localObject).putExtra("support_linkify", bool1);
          ((Intent)localObject).putExtra("arg_topic_name", paramJSONObject);
          ((Intent)localObject).putExtra("arg_ad_tag", k);
          ((Intent)localObject).putExtra("arg_callback", paramString);
          ((Intent)localObject).putExtra("arg_ugc_edit_cookie", str2);
          BaseActivity.sTopActivity.startActivityForResult((Intent)localObject, 114);
          return;
          i = 0;
          continue;
          j = 0;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = (JSONObject)localObject;
          continue;
          i = 0;
          continue;
          label240:
          boolean bool1 = false;
          continue;
          label246:
          bool1 = false;
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    int n = paramJSONObject.optInt("type", 1);
    int j;
    if (paramJSONObject.has("width")) {
      j = paramJSONObject.optInt("width");
    }
    for (int i = DisplayUtil.a(localBaseActivity, j / 2);; i = 640)
    {
      int m;
      if (paramJSONObject.has("height")) {
        m = paramJSONObject.optInt("height");
      }
      for (int k = DisplayUtil.a(localBaseActivity, m / 2);; k = 640)
      {
        a(paramActivity, 1, n, (byte)118, i, k, j, m, paramString);
        return;
        m = 640;
      }
      j = 640;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, BridgeModule paramBridgeModule)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    try
    {
      localObject8 = paramJSONObject.optString("title");
      localObject3 = paramJSONObject.optString("sourceName");
      localObject1 = paramJSONObject.optString("sourceUrl");
      localObject7 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject7 = "";
      }
      l2 = 0L;
      l3 = 0L;
      l4 = 0L;
      l7 = 0L;
      l11 = 0L;
      localObject6 = "";
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject4;
      label573:
      String str1;
      String str2;
      JSONObject localJSONObject;
      label816:
      ViolaLogUtils.e("BridgeModuleHelper", paramJSONObject.getMessage());
      return;
    }
    try
    {
      localObject1 = new String(Base64Util.decode((String)localObject8, 0));
    }
    catch (Exception localException1)
    {
      localObject2 = localObject3;
      localObject1 = "";
      localObject3 = localObject8;
      l10 = l11;
      localException1.printStackTrace();
      i = 0;
      localObject8 = localObject1;
      l1 = l4;
      Object localObject5 = localObject2;
      l4 = l10;
      localObject1 = localObject6;
      localObject2 = localObject8;
      l5 = l3;
      break label573;
      n = a(k);
      a((ArticleInfo)localObject8, paramJSONObject, a((ArticleInfo)localObject8, (String)localObject1, k, j, paramString, (String)localObject2, m, (String)localObject3, l4, i, (String)localObject7, n), l2, l5, n, (String)localObject1, m, paramBridgeModule);
      return;
    }
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject3, 0));
    }
    catch (Exception localException2)
    {
      localObject8 = localObject1;
      localObject1 = "";
      localObject2 = localObject3;
      l10 = l11;
      localObject3 = localObject8;
      break label897;
    }
    try
    {
      localObject3 = paramJSONObject.optString("feedsId");
      localObject4 = paramJSONObject.optString("rowkey");
      localObject6 = localObject4;
      l1 = l2;
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l3;
      l5 = l2;
    }
    catch (Exception localException3)
    {
      localObject8 = "";
      localObject3 = localObject1;
      localObject1 = localObject8;
      l10 = l11;
      break label897;
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        l10 = l11;
        l9 = l7;
        l8 = l4;
        l6 = l3;
        l5 = l2;
        l1 = new BigInteger((String)localObject3).longValue();
      }
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l3;
      l5 = l1;
      localObject4 = paramJSONObject.optString("ariticleId");
      l2 = l3;
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l3;
      l5 = l1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        l10 = l11;
        l9 = l7;
        l8 = l4;
        l6 = l3;
        l5 = l1;
        l2 = new BigInteger((String)localObject4).longValue();
      }
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l2;
      l5 = l1;
      localObject4 = paramJSONObject.optString("originFeedsId");
      l3 = l4;
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l2;
      l5 = l1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        l10 = l11;
        l9 = l7;
        l8 = l4;
        l6 = l2;
        l5 = l1;
        l3 = new BigInteger((String)localObject4).longValue();
      }
      l10 = l11;
      l9 = l7;
      l8 = l3;
      l6 = l2;
      l5 = l1;
      localObject4 = paramJSONObject.optString("businessId");
      l4 = l7;
      l10 = l11;
      l9 = l7;
      l8 = l3;
      l6 = l2;
      l5 = l1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        l10 = l11;
        l9 = l7;
        l8 = l3;
        l6 = l2;
        l5 = l1;
        l4 = new BigInteger((String)localObject4).longValue();
      }
      l10 = l11;
      l9 = l4;
      l8 = l3;
      l6 = l2;
      l5 = l1;
      l7 = paramJSONObject.optLong("accountID");
      l10 = l7;
      l9 = l4;
      l8 = l3;
      l6 = l2;
      l5 = l1;
      i = paramJSONObject.optInt("accountType");
      l5 = l2;
      l2 = l1;
      l1 = l7;
      localObject4 = localObject2;
      localObject8 = localObject1;
      l7 = l4;
      localObject2 = localObject3;
      localObject1 = localObject6;
      l4 = l1;
      localObject3 = localObject8;
      l1 = l3;
      l3 = paramJSONObject.optLong("originFeedsType", 1L);
      j = paramJSONObject.optInt("type");
      k = paramJSONObject.optInt("adtag");
      str1 = paramJSONObject.optString("picurl");
      n = paramJSONObject.optInt("duration");
      str2 = new String(Base64Util.decode(paramJSONObject.optString("accountDesc"), 0));
      m = paramJSONObject.optInt("feedsType", 1);
      localObject8 = new ArticleInfo();
      ((ArticleInfo)localObject8).mArticleID = l5;
      ((ArticleInfo)localObject8).mTitle = ((String)localObject3);
      ((ArticleInfo)localObject8).mSubscribeName = ((String)localObject4);
      ((ArticleInfo)localObject8).mFirstPagePicUrl = str1;
      ((ArticleInfo)localObject8).mVideoDuration = n;
      ((ArticleInfo)localObject8).mFeedId = l2;
      ((ArticleInfo)localObject8).mSummary = str2;
      ((ArticleInfo)localObject8).businessId = l7;
      ((ArticleInfo)localObject8).mFeedType = m;
      ((ArticleInfo)localObject8).innerUniqueID = ((String)localObject1);
      a(paramJSONObject, (ArticleInfo)localObject8, l1, l3);
      localJSONObject = paramJSONObject.optJSONObject("ugcInfo");
      if ((localJSONObject == null) || (!RIJItemViewType.a(m, l3))) {
        break label1065;
      }
      localObject6 = localJSONObject.optString("ugcComment");
      j = localJSONObject.optInt("ugcType", 0);
      a((ArticleInfo)localObject8, localJSONObject, (String)localObject6, j, k, (String)localObject3, (String)localObject4, str1, str2, l4);
      j = a(j, paramJSONObject);
      localObject3 = localObject6;
    }
    catch (Exception localException4)
    {
      localObject8 = localObject1;
      localObject1 = localObject3;
      l7 = l9;
      l4 = l8;
      l3 = l6;
      localObject3 = localObject8;
      l2 = l5;
      break label897;
      localObject3 = "";
      break label816;
    }
    ((ArticleInfo)localObject8).mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
    ((ArticleInfo)localObject8).mSocialFeedInfo.c = "";
    ((ArticleInfo)localObject8).mSocialFeedInfo.b = "";
    if (a(k, (String)localObject7, (ArticleInfo)localObject8))
    {
      QLog.d("BridgeModuleHelper", 1, "web page share but core info empty !");
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a()
  {
    if (!VersionUtils.k()) {}
    BaseActivity localBaseActivity;
    do
    {
      return true;
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return false;
      }
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
  
  private static boolean a(int paramInt, String paramString, ArticleInfo paramArticleInfo)
  {
    return (paramInt == 23) && ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramArticleInfo.mSubscribeName)));
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = DeviceInfoUtil.f();
    String str2 = DeviceInfoUtil.a();
    try
    {
      localJSONObject.put("imsi", ReadInJoyUtils.c());
      localJSONObject.put("androidID", str1);
      localJSONObject.put("identifier", str2);
      localJSONObject.put("qimei", UserAction.getQIMEI());
      localJSONObject.put("qua", QZoneHelper.getQUA());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b(BridgeModule paramBridgeModule, int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt == -1) {}
    for (int i = 0;; i = -1)
    {
      if (paramIntent == null) {
        return;
      }
      String str1 = paramIntent.getStringExtra("result_js_callback");
      String str2 = paramIntent.getStringExtra("feed_id");
      long l = paramIntent.getLongExtra("feedsType", 1L);
      if ((str1 != null) && (str2 != null)) {
        paramIntent = new JSONObject();
      }
      try
      {
        paramIntent.put("feedsId", str2);
        paramIntent.put("retCode", i);
        paramIntent.put("feedsType", l);
        paramBridgeModule.invokeCallJS(str1, paramIntent);
        paramBridgeModule = ReadInJoyShareHelperV2.ShareReport.a;
        if (paramInt == -1) {
          bool = true;
        }
        paramBridgeModule.a(bool);
        return;
      }
      catch (Exception paramBridgeModule)
      {
        for (;;)
        {
          QLog.e("BridgeModuleHelper", 2, "dealBiuResult error:" + paramBridgeModule.getMessage());
        }
      }
    }
  }
  
  private static void b(BridgeModule paramBridgeModule, SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.mLocation == null)) {
      return;
    }
    double d1 = paramSosoLbsInfo.mLocation.mLat02;
    double d2 = 1000000;
    double d3 = paramSosoLbsInfo.mLocation.mLon02;
    double d4 = 1000000;
    double d5 = paramSosoLbsInfo.mLocation.mLat02;
    double d6 = paramSosoLbsInfo.mLocation.mLon02;
    String str;
    if (paramSosoLbsInfo.mLocation.city != null)
    {
      str = paramSosoLbsInfo.mLocation.city;
      if (paramSosoLbsInfo.mLocation.cityCode == null) {
        break label243;
      }
    }
    label243:
    for (paramSosoLbsInfo = paramSosoLbsInfo.mLocation.cityCode;; paramSosoLbsInfo = "")
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("authroized", true);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ret", 0).put("latitude", d1 * d2).put("longitude", d3 * d4).put("origin_latitude", d5).put("origin_longitude", d6).put("city", str).put("cityCode", paramSosoLbsInfo).put("status", localJSONObject1);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject2.toString());
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        QLog.e("BridgeModuleHelper", 1, "fireLocationSuccessCallbackError: " + paramBridgeModule.getMessage());
        return;
      }
      str = "";
      break;
    }
  }
  
  private static void b(BridgeModule paramBridgeModule, File paramFile)
  {
    paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    if ((paramBridgeModule == null) || (paramBridgeModule.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    ForwardBaseOption.a(paramBridgeModule, (Intent)localObject, 18);
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!ReadInJoyHelper.s()) {
          continue;
        }
        i = 1;
        localJSONObject.put("result", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
      i = 0;
    }
  }
  
  private static void b(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(paramString1);
    if ((paramString1 != null) && (paramString1.mLocation != null))
    {
      b(paramBridgeModule, paramString1, paramString2);
      return;
    }
    d(paramBridgeModule, paramString2, "fail to get locationInfo from cache");
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("res", 1);
      paramJSONObject = paramJSONObject.optString("miniAppUrl");
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(localBaseActivity, paramJSONObject, 2103, null))
      {
        localJSONObject.put("res", 0);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = b();
    if (paramBoolean)
    {
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = paramBridgeModule.getViolaInstance().getActivity();
    if ((paramJSONObject != null) && (localActivity != null)) {}
    try
    {
      long l = paramJSONObject.getLong("puin");
      paramJSONObject = new ActivityURIRequest(localActivity, "/pubaccount/detail");
      paramJSONObject.extra().putString("uin", "" + l);
      paramJSONObject.extra().putBoolean("from_js", true);
      QRoute.startUri(paramJSONObject, null);
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("BridgeModuleHelper", 2, "openAccountPageMore->error:" + paramBridgeModule);
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("?client=androidQQ");
        ((StringBuilder)localObject).append("&version=8.5.5.5105");
        ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
        ((StringBuilder)localObject).append("&uin=" + ReadInJoyUtils.a());
        paramString = EmosmUtils.a("VIP_xingying", ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("BridgeModuleHelper", 2, "saveImageToLocal imageUrl=" + paramString);
        }
        localObject = System.currentTimeMillis() + ".jpg";
        a(new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), (String)localObject), paramString);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BridgeModuleHelper", 2, "saveImageToLocal imageUrl error=" + paramString.getMessage());
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("code");
    Object localObject3 = paramJSONObject.optJSONObject("params");
    Object localObject1;
    Object localObject2;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
    {
      paramJSONObject = ((JSONObject)localObject3).optJSONObject("r2");
      localObject1 = ((JSONObject)localObject3).optJSONObject("r3");
      localObject2 = ((JSONObject)localObject3).optJSONObject("r4");
      localObject3 = ((JSONObject)localObject3).optJSONObject("r5");
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (paramJSONObject == null) {
        break label129;
      }
      paramJSONObject = paramJSONObject.toString();
      if (localObject1 == null) {
        break label135;
      }
      localObject1 = ((JSONObject)localObject1).toString();
      label90:
      if (localObject2 == null) {
        break label141;
      }
      localObject2 = ((JSONObject)localObject2).toString();
      label99:
      if (localObject3 == null) {
        break label147;
      }
    }
    label129:
    label135:
    label141:
    label147:
    for (localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, null, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
      return;
      paramJSONObject = "";
      break;
      localObject1 = "";
      break label90;
      localObject2 = "";
      break label99;
    }
  }
  
  public static void b(JSONObject paramJSONObject, String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        String str = paramJSONObject.optString("rowkey", "");
        int j = paramJSONObject.optInt("maxSelect");
        int k = paramJSONObject.optInt("maxCount");
        Object localObject = paramJSONObject.optString("invitedUins", "[]");
        paramJSONObject = new StringBuilder();
        if ((localObject != null) && (((String)localObject).trim().length() > 0))
        {
          localObject = new JSONArray(((String)localObject).trim());
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramJSONObject.append(((JSONArray)localObject).get(i));
            if (i >= ((JSONArray)localObject).length() - 1) {
              break label260;
            }
            paramJSONObject.append(",");
            break label260;
          }
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("opentype", 1);
        ((Intent)localObject).putExtra("filterUins", paramJSONObject.toString());
        ((Intent)localObject).putExtra("maxSelect", j);
        if (k > 0) {
          ((Intent)localObject).putExtra("maxCount", k);
        }
        ((Intent)localObject).putExtra("rowkey", str);
        ((Intent)localObject).putExtra("callback", paramString);
        PublicFragmentActivity.a(BaseActivity.sTopActivity, (Intent)localObject, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BridgeModuleHelper", 2, "selectAndInviteFriend e = " + paramJSONObject);
        }
        paramJSONObject.printStackTrace();
        return;
      }
      label260:
      i += 1;
    }
  }
  
  public static void b(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {}
    int n;
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      localObject = ((Context)localObject).getResources().getDisplayMetrics();
      n = paramJSONObject.optInt("type");
      i = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
      j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 200.0D);
      k = 750;
      m = 416;
      if (n == 1)
      {
        j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
        m = 160;
        k = 160;
        i = j;
      }
    } while ((n != 1) && (n != 2));
    a(paramActivity, 2, 0, (byte)121, i, j, k, m, paramString);
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, BridgeModule paramBridgeModule)
  {
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, paramJSONObject, true);
  }
  
  public static JSONObject c()
  {
    int k = HttpUtil.getNetWorkType();
    String str = HttpUtil.getNetWorkTypeByStr();
    int j = 0;
    Object localObject = DeviceInfoUtil.b();
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = j;
      if (((String)localObject).length() > 5)
      {
        i = j;
        if (((String)localObject).startsWith("460"))
        {
          localObject = ((String)localObject).substring(3, 5);
          if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07"))) {
            break label145;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("type", k);
        ((JSONObject)localObject).put("radio", str);
        ((JSONObject)localObject).put("carriertype", i);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        label145:
        localJSONException.printStackTrace();
      }
      if ((((String)localObject).equals("01")) || (((String)localObject).equals("06")) || (((String)localObject).equals("09")))
      {
        i = 2;
      }
      else if ((((String)localObject).equals("03")) || (((String)localObject).equals("05")))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (((String)localObject).equals("20")) {
          i = 4;
        }
      }
    }
    return localObject;
  }
  
  public static void c(BridgeModule paramBridgeModule, String paramString)
  {
    QLog.i("BridgeModuleHelper", 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    ProtoUtils.a(ReadInJoyUtils.a(), new BridgeModuleHelper.2(paramBridgeModule, paramString), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  private static void c(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new BridgeModuleHelper.16(paramString1, paramBridgeModule, paramString2));
  }
  
  public static void c(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    paramBridgeModule.invokeCallJS(paramString, c());
  }
  
  public static void c(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      String str = paramJSONObject.getString("feeds_id");
      paramJSONObject = paramJSONObject.optString("feeds_type", "1");
      ReadInJoyLogicEngine.a().a(str, Integer.valueOf(paramJSONObject).intValue());
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("BridgeModuleHelper", 2, "openAccountPageMore->error:" + paramBridgeModule);
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  public static void c(JSONObject paramJSONObject)
  {
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.optString("apkUrl") != null) && (paramJSONObject.optInt("action", -1) != -1))
    {
      i = paramJSONObject.optInt("action", -1);
      if (i != 1) {
        break label45;
      }
      d(paramJSONObject);
    }
    label45:
    do
    {
      return;
      if (i == 2)
      {
        e(paramJSONObject);
        return;
      }
    } while (i != 3);
    f(paramJSONObject);
  }
  
  public static void c(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramJSONObject.optJSONObject("param") != null) {
      localBundle.putString("param", paramJSONObject.optJSONObject("param").toString());
    }
    ViolaAccessHelper.a(BaseActivity.sTopActivity, "", paramString, localBundle);
  }
  
  public static void d(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = paramBridgeModule.getViolaInstance().getFragment();
    boolean bool;
    if (localObject != null)
    {
      bool = ((Fragment)localObject).getUserVisibleHint();
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("result", bool);
      paramBridgeModule.invokeCallJS(paramString, localObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BridgeModuleHelper", 2, "pageVisibility error" + paramBridgeModule.getMessage());
    }
  }
  
  private static void d(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramString2 = paramBridgeModule.getFailInvokeObj(paramString2);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", 1).put("authroized", false);
        paramString2.put("data", localJSONObject);
        paramBridgeModule.invokeJS(paramString1, paramString2);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        QLog.e("BridgeModuleHelper", 1, "fireLocationErrorCallbackError: " + paramBridgeModule.getMessage());
        return;
      }
      paramString2 = "";
    }
  }
  
  public static void d(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = true;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        long l = paramJSONObject.getLong("followUin");
        int i = paramJSONObject.getInt("followInfo");
        if ((i == 2) || (i == 1))
        {
          paramJSONObject = ReadInJoyLogicEngineEventDispatcher.a();
          if (i != 2) {
            break label118;
          }
          paramJSONObject.b(l, bool);
          ThreadManager.post(new BridgeModuleHelper.1(l, i), 8, null, true);
        }
        paramBridgeModule.invokeCallJS(paramString, null);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BridgeModuleHelper", 2, "openAccountPageMore -> error:" + paramBridgeModule);
        return;
      }
      paramBridgeModule.invokeErrorCallJS(paramString, "params error");
      return;
      label118:
      bool = false;
    }
  }
  
  public static void d(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadManagerV2.a().a(paramJSONObject);
    }
  }
  
  public static void e(BridgeModule paramBridgeModule, String paramString)
  {
    Fragment localFragment = paramBridgeModule.getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label33;
      }
      ((ViolaFragment)localFragment).doOnBackPressed();
    }
    for (;;)
    {
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
      label33:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  public static void e(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      int i = paramJSONObject.getInt("topicId");
      int j = paramJSONObject.getInt("followInfo");
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModuleHelper", 2, "topic id = " + i + "\t follow info =" + j);
      }
      if (!ReadInJoyLogicEngine.a().a(i, j)) {
        ReadInJoyLogicEngine.a().d(i, j);
      }
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("BridgeModuleHelper", 2, "openAccountPageMore->error:" + paramBridgeModule);
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  public static void e(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.d = paramJSONObject;
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      localDownloadInfo.a();
      DownloadManagerV2.a().b(localDownloadInfo);
    }
  }
  
  public static void f(BridgeModule paramBridgeModule, String paramString)
  {
    Fragment localFragment = paramBridgeModule.getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label81;
      }
      if (((ViolaFragment)localFragment).getCommonSuspensionGestureLayout() == null) {
        break label71;
      }
      if (!((ViolaFragment)localFragment).getCommonSuspensionGestureLayout().a()) {
        break label56;
      }
      localFragment.getActivity().doOnBackPressed();
    }
    for (;;)
    {
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
      label56:
      ((ViolaFragment)localFragment).getCommonSuspensionGestureLayout().a(0, 3);
      continue;
      label71:
      localFragment.getActivity().doOnBackPressed();
      continue;
      label81:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  public static void f(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("feedsId");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      QLog.d("BridgeModuleHelper", 2, "showVisibleUserList feedsId " + paramJSONObject);
      Intent localIntent = new Intent();
      localIntent.putExtra("feeds_id", new BigInteger(paramJSONObject).longValue());
      PublicFragmentActivity.a(localBaseActivity, localIntent, ReadInJoyPrivacyListFragment.class);
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
  }
  
  public static void f(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadManagerV2.a().b(paramJSONObject, true);
    }
  }
  
  public static void g(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = paramBridgeModule.getViolaInstance();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ViolaInstance)localObject).getFragment();
    } while (!(localObject instanceof ViolaFragment));
    ((ViolaFragment)localObject).setTitleContainerClick(new BridgeModuleHelper.7(paramBridgeModule, paramString));
  }
  
  public static void g(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (BiuBehaviour.a() == 1)
        {
          paramJSONObject = "fastBiu";
          String str;
          if (BiuBehaviour.b() == 1)
          {
            str = "fastBiu";
            localJSONObject.put("retCode", 0);
            localJSONObject.put("click", paramJSONObject);
            localJSONObject.put("longClick", str);
            if (!TextUtils.isEmpty(paramString)) {
              paramBridgeModule.invokeCallJS(paramString, localJSONObject);
            }
          }
          else
          {
            str = "normalBiu";
            continue;
          }
          return;
        }
      }
      catch (JSONException paramBridgeModule)
      {
        QLog.e("BridgeModuleHelper", 1, "[getBiuTriggerType] ", paramBridgeModule);
      }
      paramJSONObject = "normalBiu";
    }
  }
  
  public static void g(JSONObject paramJSONObject)
  {
    try
    {
      GdtLog.a("BridgeModuleHelper", paramJSONObject.toString());
      GdtC2SReporter.a(paramJSONObject.optInt("operationType"), paramJSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      return;
    }
    catch (Exception paramJSONObject)
    {
      GdtLog.d("BridgeModuleHelper", "handleJsCallRequest", paramJSONObject);
    }
  }
  
  public static void h(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = paramBridgeModule.getViolaInstance().getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(ReadInJoyUtils.a().getApplication(), 1, HardCodeUtil.a(2131701275), 0).a();
      return;
    }
    localObject = new File(AbsDownloader.getFilePath(paramString));
    if (((File)localObject).exists())
    {
      b(paramBridgeModule, (File)localObject);
      return;
    }
    a(paramBridgeModule, paramString, (File)localObject);
  }
  
  public static void h(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (AppInterface)ReadInJoyUtils.a();
    localObject = paramBridgeModule.getViolaInstance().getFragment();
    if (localObject != null) {}
    for (paramBridgeModule = ((Fragment)localObject).getActivity(); paramBridgeModule == null; paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity()) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    int i = paramJSONObject.optInt("adtag");
    paramJSONObject.optInt("mode");
    paramJSONObject.optString("vid");
    paramJSONObject.optString("videourl");
    paramJSONObject.optString("coverurl");
    paramJSONObject.optString("md5");
    localObject = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    try
    {
      paramJSONObject = new String(Base64Util.decode((String)localObject, 0));
      if (RIJUGCDianDian.a() >= 2)
      {
        QQToast.a(paramBridgeModule, 0, paramBridgeModule.getString(2131718219), 0).b(paramBridgeModule.getResources().getDimensionPixelSize(2131299166));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = (JSONObject)localObject;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("arg_topic_id", str1);
      ((Bundle)localObject).putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
      ((Bundle)localObject).putString("arg_topic_id", str1);
      ((Bundle)localObject).putString("arg_topic_name", paramJSONObject);
      ((Bundle)localObject).putInt("arg_ad_tag", i);
      ((Bundle)localObject).putString("arg_callback", paramString);
      ((Bundle)localObject).putString("arg_ugc_edit_cookie", str2);
      ReadInJoyCaptureLauncher.a(paramBridgeModule, (Bundle)localObject, (byte)116);
      RIJUGCDianDian.a("2", "2");
    }
  }
  
  public static void h(JSONObject paramJSONObject) {}
  
  public static void i(BridgeModule paramBridgeModule, String paramString)
  {
    int i = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 1;
      }
      localJSONObject.put("isNightMode", i);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      paramBridgeModule.printStackTrace();
    }
  }
  
  public static void i(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramBridgeModule.getViolaInstance().getFragment() != null) {}
    for (paramBridgeModule = paramBridgeModule.getViolaInstance().getFragment().getActivity(); paramBridgeModule == null; paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity()) {
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    localObject1 = paramJSONObject.optString("placeholder");
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("BridgeModuleHelper", 1, "showCommentEditor | comment_placeholder decode error! | comment_placeholder: " + (String)localObject1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "showCommentEditor | comment_placeholder after decode: " + (String)localObject1);
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      localObject3 = new String(Base64Util.decode((String)localObject2, 0));
      localObject2 = localObject3;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject3;
        QLog.e("BridgeModuleHelper", 1, "showCommentEditor | defaultTxt decode error! | defaultTxt: " + localException1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "showCommentEditor | defaultTxt after decode: " + (String)localObject2);
    }
    localObject3 = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      ((Intent)localObject3).putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    QLog.d("BridgeModuleHelper", 2, "#showCommentEditor bridge isPgcAuthor = " + paramJSONObject.optBoolean("isPgcAuthor", false));
    ((Intent)localObject3).putExtra("comment_type", false);
    ((Intent)localObject3).putExtra("arg_comment_enable_anonymous", bool1);
    ((Intent)localObject3).putExtra("arg_comment_placeholder", (String)localObject1);
    ((Intent)localObject3).putExtra("arg_comment_default_txt", (String)localObject2);
    ((Intent)localObject3).putExtra("arg_comment_max_length", i);
    ((Intent)localObject3).putExtra("arg_comment_comment_type", j);
    ((Intent)localObject3).putExtra("arg_comment_source_type", k);
    ((Intent)localObject3).putExtra("arg_callback", paramString);
    ((Intent)localObject3).putExtra("arg_comment_open_at", m);
    ((Intent)localObject3).putExtra("comment_can_biu", bool2);
    ((Intent)localObject3).putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      ((Intent)localObject3).putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    ReadInJoyCommentEntrance.a(paramBridgeModule, (Intent)localObject3, 117);
  }
  
  public static void i(JSONObject paramJSONObject)
  {
    float f2 = 100.0F;
    String str;
    boolean bool;
    if (!TextUtils.isEmpty(paramJSONObject.optString("url", "")))
    {
      str = paramJSONObject.optString("url", "");
      bool = paramJSONObject.optBoolean("isGif", false);
      if (!paramJSONObject.has("width")) {
        break label163;
      }
    }
    label163:
    for (float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("width"), 750);; f1 = 100.0F)
    {
      if (paramJSONObject.has("height")) {
        f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("height"), 750);
      }
      paramJSONObject = URLDrawable.getDrawable(str, ComponentAdapter.a(bool, (int)f1, (int)f2));
      QLog.d("BridgeModuleHelper", 2, "preload image, ur: " + str + ".isGif:" + bool + ",reqWidth:" + f1 + ",reqHeight:" + f2);
      paramJSONObject.startDownload();
      return;
    }
  }
  
  public static void j(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      return;
    }
    localObject = DeviceInfoUtil.a((Context)localObject);
    String str = DeviceInfoUtil.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qqVersion", str);
      localJSONObject.put("qqBuild", localObject);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "[getClientInfo]: " + paramBridgeModule.getMessage());
    }
  }
  
  public static void j(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramBridgeModule.getViolaInstance().getFragment() != null) {}
    for (paramBridgeModule = paramBridgeModule.getViolaInstance().getFragment().getActivity(); (paramBridgeModule == null) || (paramJSONObject == null); paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity()) {
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    localObject1 = paramJSONObject.optString("placeholder");
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("BridgeModuleHelper", 1, "showCommentEditorNative | comment_placeholder decode error! | comment_placeholder: " + (String)localObject1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "showCommentEditorNative | comment_placeholder after decode: " + (String)localObject1);
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      str1 = new String(Base64Util.decode((String)localObject2, 0));
      localObject2 = str1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1;
        String str2;
        int n;
        int i1;
        String str5;
        String str3;
        long l;
        String str4;
        Intent localIntent;
        QLog.e("BridgeModuleHelper", 1, "showCommentEditorNative | defaultTxt decode error! | defaultTxt: " + localException1);
        continue;
        paramJSONObject = new SubCommentCreateData(i1, str5);
        paramJSONObject.a(str3);
        paramJSONObject.b(localException2);
        paramJSONObject.c(str2);
        paramJSONObject.a(l);
        paramJSONObject.e(str4);
        paramJSONObject.b(n);
        localIntent.putExtra("comment_create_data", paramJSONObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "showCommentEditorNative | defaultTxt after decode: " + (String)localObject2);
    }
    str1 = paramJSONObject.optString("rowkey");
    str2 = paramJSONObject.optString("articleId");
    n = paramJSONObject.optInt("scene");
    i1 = paramJSONObject.optInt("entry");
    str5 = paramJSONObject.optString("businessInfo");
    str3 = paramJSONObject.optString("firstCommentId");
    l = paramJSONObject.optLong("repliedSubAuthorId");
    str4 = paramJSONObject.optString("repliedSubCommentId");
    localIntent = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      localIntent.putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    QLog.d("BridgeModuleHelper", 2, "#showCommentEditorNative bridge isPgcAuthor = " + paramJSONObject.optBoolean("isPgcAuthor", false));
    localIntent.putExtra("comment_type", false);
    localIntent.putExtra("arg_comment_enable_anonymous", bool1);
    localIntent.putExtra("arg_comment_placeholder", (String)localObject1);
    localIntent.putExtra("arg_comment_default_txt", (String)localObject2);
    localIntent.putExtra("arg_comment_max_length", i);
    localIntent.putExtra("arg_comment_comment_type", j);
    localIntent.putExtra("arg_comment_source_type", k);
    localIntent.putExtra("arg_callback", paramString);
    localIntent.putExtra("arg_comment_open_at", m);
    localIntent.putExtra("comment_can_biu", bool2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      localIntent.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    if (str3.isEmpty())
    {
      paramJSONObject = new FirstCommentCreateData(i1, str5);
      paramJSONObject.b(str1);
      paramJSONObject.c(str2);
      paramJSONObject.b(n);
      localIntent.putExtra("comment_create_data", paramJSONObject);
      ReadInJoyCommentEntrance.a(paramBridgeModule, localIntent, 126);
      return;
    }
  }
  
  public static void k(BridgeModule paramBridgeModule, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", CUKingCardHelper.a());
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "getCUKingStatus error e = ", paramBridgeModule);
    }
  }
  
  public static void k(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("type", 0);
    boolean bool1 = paramJSONObject.optBoolean("blackScene", false);
    boolean bool2 = paramJSONObject.optBoolean("isNightMode", false);
    String str = paramJSONObject.optString("avatarUrl", "");
    int j = paramJSONObject.optInt("bizType", 1);
    paramJSONObject = paramJSONObject.optString("uniqueID", "");
    RIJPushNotifyManager.a.a().a(i, bool1, bool2, str, j, paramJSONObject, new BridgeModuleHelper.3(paramBridgeModule, paramString));
  }
  
  public static void l(BridgeModule paramBridgeModule, String paramString)
  {
    ThreadManager.post(new BridgeModuleHelper.9(paramBridgeModule, paramString), 8, null, true);
  }
  
  public static void l(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = paramJSONObject.optString("key");
    int i = paramJSONObject.optInt("id", -1);
    if ((i == -1) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = Aladdin.getConfig(i).getAll();
        if (localObject2 != null)
        {
          localObject1 = new JSONObject();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue().toString());
          }
          paramJSONObject.put("value", localObject1);
        }
      }
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "[getALDConfig]: " + paramBridgeModule.getMessage());
      return;
    }
    for (;;)
    {
      b(paramJSONObject, paramString, paramBridgeModule);
      return;
      paramJSONObject.put("value", Aladdin.getConfig(i).getString((String)localObject1, ""));
    }
  }
  
  public static void m(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recommendFlag", a());
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void m(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getApplication();
    String str = paramJSONObject.optString("text");
    int i = paramJSONObject.optInt("iconMode", 2);
    if (!TextUtils.isEmpty(str))
    {
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        i = 2;
      }
      for (;;)
      {
        QQToast.a((Context)localObject, i, str, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299166));
        paramBridgeModule.invokeCallJS(paramString, new JSONObject());
        return;
        i = 0;
        continue;
        i = 2;
        continue;
        i = 1;
        continue;
        i = 6;
      }
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "text为null!!");
  }
  
  public static void n(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", true);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BridgeModuleHelper", 2, "Error in isMobileQQ");
        }
      }
    }
  }
  
  public static void n(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str1;
    if (paramJSONObject != null)
    {
      str1 = paramJSONObject.optString("url");
      String str2 = paramJSONObject.optString("businessId", null);
      if (!TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(str2)) {
          break label77;
        }
        paramJSONObject = new Bundle();
        paramJSONObject.putString("big_brother_source_key", str2);
        paramJSONObject.putString("big_brother_ref_source_key", RIJJumpUtils.a(0));
      }
    }
    for (;;)
    {
      a(str1, paramJSONObject);
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
      label77:
      paramJSONObject = null;
    }
  }
  
  public static void o(BridgeModule paramBridgeModule, String paramString)
  {
    boolean bool = true;
    if (paramBridgeModule.getViolaInstance() != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (CUKingCardHelper.a() == 1)
        {
          localJSONObject.put("value", bool);
          ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, localJSONObject, true);
          return;
        }
      }
      catch (JSONException paramBridgeModule)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BridgeModuleHelper", 2, "isKindCard error" + paramBridgeModule.getMessage());
      }
      bool = false;
    }
  }
  
  public static void o(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramBridgeModule.getViolaInstance() == null) {}
    Fragment localFragment;
    String str1;
    do
    {
      do
      {
        return;
        localFragment = paramBridgeModule.getViolaInstance().getFragment();
      } while ((localFragment == null) || (!(localFragment instanceof ViolaFragment)));
      String str2 = paramJSONObject.optString("title");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramJSONObject.optString("text");
      }
    } while (TextUtils.isEmpty(str1));
    ((ViolaFragment)localFragment).setTitle(str1);
    paramBridgeModule.invokeCallJS(paramString, new JSONObject());
  }
  
  public static void p(BridgeModule paramBridgeModule, String paramString)
  {
    paramBridgeModule = paramBridgeModule.getViolaInstance().getContext();
    if ((paramBridgeModule == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      Object localObject = VideoFeedsWeiShiUtils.b(paramString);
      if (localObject != null)
      {
        ((DownloadInfo)localObject).a();
        DownloadManagerV2.a().b((DownloadInfo)localObject);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new Intent(paramBridgeModule, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", RIJJumpUtils.a(0));
        ((Intent)localObject).putExtra("url", paramString.optString("url"));
        paramBridgeModule.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramBridgeModule) {}
    } while (!QLog.isColorLevel());
    QLog.e("BridgeModuleHelper", 2, "downloadApp error" + paramBridgeModule.getMessage());
  }
  
  public static void p(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    BaseActivity localBaseActivity;
    do
    {
      return;
      localBaseActivity = BaseActivity.sTopActivity;
    } while (localBaseActivity == null);
    ViolaAccessHelper.a(localBaseActivity, paramJSONObject, new BridgeModuleHelper.6(paramBridgeModule, paramString));
  }
  
  public static void q(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = a(paramJSONObject);
    if (paramJSONObject != null)
    {
      Fragment localFragment = paramBridgeModule.getViolaInstance().getFragment();
      if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
      {
        ((ViolaFragment)localFragment).setTitleConf(paramJSONObject, null);
        paramBridgeModule.invokeCallJS(paramString, null);
      }
    }
  }
  
  public static void r(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("enable", true);
    if ((paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).enableFlingRight(bool);
      paramBridgeModule.invokeCallJS(paramString, new JSONObject());
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, HardCodeUtil.a(2131701278));
  }
  
  public static void s(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString("imageUrl");
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        h(paramBridgeModule, paramJSONObject);
        localJSONObject.put("retCode", 0);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
      }
      localJSONObject.put("retCode", 1);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      QQToast.a(ReadInJoyUtils.a().getApplication(), 1, HardCodeUtil.a(2131701279), 0).a();
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "sharePicMessage exception e = ", paramBridgeModule);
    }
  }
  
  public static void t(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).updateViolaPageByData(paramJSONObject);
    }
  }
  
  public static void u(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    int j;
    int i;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      localObject = DownloadManagerV2.a().b(paramJSONObject);
      j = -1;
      i = 0;
      if (localObject != null)
      {
        j = ((DownloadInfo)localObject).a();
        i = ((DownloadInfo)localObject).f;
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", j);
      ((JSONObject)localObject).put("data", i);
      paramBridgeModule.invokeCallJS(paramString, localObject);
      ViolaLogUtils.d("BridgeModuleHelper", "downloadApk getDownloadApkState :" + j + " ,apkUrl : " + paramJSONObject);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "getDownloadApkState error:" + paramBridgeModule.getMessage());
      }
    }
  }
  
  public static void v(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localObject == null) || (localBaseActivity == null)) {}
    StringBuilder localStringBuilder1;
    label243:
    label255:
    do
    {
      return;
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(paramJSONObject.optString("id")).append("|").append(paramJSONObject.optString("subid")).append("|").append(paramJSONObject.optString("content")).append("|").append("ANDROID").append("|").append("8.5.5.5105").append("|").append(DeviceInfoUtil.e()).append("|").append(((QQAppInterface)localObject).getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
      if (TextUtils.isEmpty(DeviceInfoUtil.a(localBaseActivity).c))
      {
        localObject = "未知";
        localStringBuilder2 = localStringBuilder2.append((String)localObject).append("|");
        if (!TextUtils.isEmpty(DeviceInfoUtil.a(localBaseActivity).jdField_a_of_type_JavaLangString)) {
          break label243;
        }
      }
      for (localObject = "未知";; localObject = DeviceInfoUtil.a(localBaseActivity).jdField_a_of_type_JavaLangString)
      {
        localStringBuilder2.append((String)localObject);
        if (!paramJSONObject.optBoolean("isall", false)) {
          break label255;
        }
        QLog.w("ViolaLog", 1, localStringBuilder1.toString());
        paramBridgeModule.invokeCallJS(paramString, null);
        return;
        localObject = DeviceInfoUtil.a(localBaseActivity).c;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ViolaLog", 2, localStringBuilder1.toString());
    paramBridgeModule.invokeCallJS(paramString, null);
  }
  
  public static void w(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("imageIDs");
      int j = paramJSONObject.optInt("index");
      Object localObject2 = paramJSONObject.optString("srcID", "1");
      Object localObject1 = localObject2;
      if ("1".equals(localObject2)) {
        localObject1 = "4";
      }
      boolean bool = paramJSONObject.optBoolean("isNotShowIndex", true);
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BridgeModuleHelper", 2, "imageList is null or length is 0");
        }
      }
      else
      {
        paramJSONObject = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          paramJSONObject.add(localJSONArray.get(i).toString());
          i += 1;
        }
        localObject2 = paramBridgeModule.getViolaInstance().getActivity();
        if (localObject2 != null)
        {
          TroopNoticeJsHandler.a((Activity)localObject2, j, paramJSONObject, null, null, false, bool, (String)localObject1, 100, null, null, null, null, "", true);
          paramBridgeModule.invokeCallJS(paramString, null);
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("BridgeModuleHelper", 2, "showPicture error" + paramJSONObject.getMessage());
        paramBridgeModule.invokeErrorCallJS(paramString, null);
      }
    }
  }
  
  public static void x(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = paramBridgeModule.getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (!CheckPermission.isHasStoragePermission(localActivity))
    {
      CheckPermission.requestSDCardPermission((AppActivity)localActivity, new BridgeModuleHelper.10(paramBridgeModule, paramJSONObject, paramString));
      return;
    }
    y(paramBridgeModule, paramJSONObject, paramString);
  }
  
  public static void y(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("content");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append("?client=androidQQ");
      ((StringBuilder)localObject).append("&version=8.5.5.5105");
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
      ((StringBuilder)localObject).append("&uin=" + ReadInJoyUtils.a());
      paramJSONObject = EmosmUtils.a("VIP_xingying", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModuleHelper", 2, "saveImage imageUrl=" + paramJSONObject);
      }
      localObject = System.currentTimeMillis() + ".jpg";
      ThreadManager.executeOnNetWorkThread(new BridgeModuleHelper.11(paramJSONObject, new File(AppConstants.SDCARD_IMG_SAVE, (String)localObject), paramBridgeModule, paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BridgeModuleHelper", 2, "saveImage imageUrl error=" + paramJSONObject.getMessage());
      }
      paramBridgeModule.invokeErrorCallJS(paramString, "saveImage error");
    }
  }
  
  public static void z(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    ViolaAccessHelper.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new BridgeModuleHelper.12(paramBridgeModule, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper
 * JD-Core Version:    0.7.0.1
 */