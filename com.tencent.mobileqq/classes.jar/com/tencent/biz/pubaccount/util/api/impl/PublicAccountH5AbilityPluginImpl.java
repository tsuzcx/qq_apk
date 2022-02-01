package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationReadInJoy;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.biz.fastweb.CallJs;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityPluginImpl
  extends WebViewPlugin
  implements IPublicAccountH5AbilityPlugin
{
  public static final int CODE_QRCODE = 1;
  public static final String FILEPATH = "filepath";
  public static final String FROM_PUBH5 = "from_pub5";
  public static final String KEY_VIDEO_DIR = "video_dir";
  public static final String KEY_VIDEO_DURATION = "video_duration";
  public static final byte OPENCAMERA = 112;
  public static final byte OPENIMG = 111;
  public static final int PHOTO_CLIP_BANNER_H = 200;
  public static final int PHOTO_CLIP_BANNER_W = 360;
  public static final int PHOTO_CLIP_HEAD_SIZE = 360;
  public static final int PHOTO_CLIP_SIZE = 640;
  public static final int PHOTO_TAGGET_BANNER_W = 750;
  public static final int PHOTO_TARGET_BANNER_H = 416;
  public static final int PHOTO_TARGET_HEAD_SIZE = 160;
  static final int REFUSE_EVENT = 1000;
  static final String TAG = "PublicAccountH5AbilityPlugin";
  public static String appIdStr;
  static Map<String, ArrayList<String>> authorizedLists;
  static final boolean isAllowedToRecorder = false;
  static HashMap<String, String> localIdMap = new HashMap();
  static HashMap<Integer, String> map = new HashMap();
  static Map<String, ArrayList<String>> needAuthorizedLists;
  public static String playEndCallback;
  public static String playStartCallback;
  public static String recordStartCallback;
  public static String recordStopCallback;
  public static String selectAndTopicPicCallback;
  public static String selectAndUploadAvatarCallback;
  public static String voicePlayEndCallback;
  public static String voiceRecorderEndCallback;
  public int CMD_FOR_MEDIAID = 1281;
  public int CMD_FOR_UUID = 1282;
  public int RET_CODE_FOR_READINJOY_VIDEO_CANCEL = 1;
  public int RET_CODE_FOR_READINJOY_VIDEO_ERROR = -1;
  public int RET_CODE_FOR_READINJOY_VIDEO_SUCCESS = 0;
  Activity activity;
  AppInterface app;
  String authCallback;
  String callback;
  String cameraCallback = "";
  String cameraPath = "";
  String cameraUUid = "";
  ArrayList<PublicAccountH5AbilityPluginImpl.DownloadBeen> downloadBeensList = new ArrayList();
  TroopMemberApiClient mClient = null;
  private Handler mHandler = new PublicAccountH5AbilityPluginImpl.1(this, Looper.getMainLooper());
  AtomicBoolean mInited = new AtomicBoolean(false);
  ProgressDialog mPd;
  IVideoFeedsIPCClient mVideoIPCClient = null;
  IVideoWebPreDownload mVideoWebPreDownload = null;
  int needResult = -1;
  String pUin = "";
  ActionSheet paActionSheet;
  PublicAccountH5AbilityPttImpl ptt;
  boolean refuseConfig = false;
  int scanType = -1;
  String uin;
  ArrayList<PublicAccountH5AbilityPluginImpl.UploadBeen> uploadBeensList = new ArrayList();
  
  static
  {
    map.put(Integer.valueOf(0), "publicAccountNew.getPicture");
    map.put(Integer.valueOf(1), "troopNotice.showPicture");
    map.put(Integer.valueOf(2), "qbizApi.getNetworkType");
    map.put(Integer.valueOf(3), "ui.closeWebViews");
    map.put(Integer.valueOf(4), "ui.setOnShareQQFriendHandler");
    map.put(Integer.valueOf(5), "ui.setOnShareQZoneHandler");
    map.put(Integer.valueOf(6), "ui.setOnShareWXFriendHandler");
    map.put(Integer.valueOf(7), "ui.setOnShareWXTimelineHandler");
    map.put(Integer.valueOf(8), "publicAccount.getLocation");
    map.put(Integer.valueOf(10), "publicAccountNew.hideMenuItems");
    map.put(Integer.valueOf(11), "publicAccountNew.showMenuItems");
    map.put(Integer.valueOf(12), "publicAccountNew.hideAllNonBaseMenuItem");
    map.put(Integer.valueOf(13), "publicAccountNew.showAllNonBaseMenuItem");
    map.put(Integer.valueOf(14), "publicAccountNew.showWebPanel");
    map.put(Integer.valueOf(15), "publicAccountNew.scanQRCode");
    map.put(Integer.valueOf(16), "publicAccountNew.setRightButtonState");
    map.put(Integer.valueOf(17), "publicAccountNew.uploadImage");
    map.put(Integer.valueOf(18), "publicAccountNew.downloadImage");
    map.put(Integer.valueOf(20), "publicAccountNew.hideWebToolbar");
    map.put(Integer.valueOf(21), "publicAccountNew.showWebToolbar");
    map.put(Integer.valueOf(30), "wallet.publicPay");
    map.put(Integer.valueOf(40), "publicAccountNew.startRecord");
    map.put(Integer.valueOf(41), "publicAccountNew.stopRecord");
    map.put(Integer.valueOf(42), "publicAccountNew.playVoice");
    map.put(Integer.valueOf(43), "publicAccountNew.pauseVoice");
    map.put(Integer.valueOf(44), "publicAccountNew.stopVoice");
    map.put(Integer.valueOf(45), "publicAccountNew.uploadVoice");
    map.put(Integer.valueOf(46), "publicAccountNew.downloadVoice");
    map.put(Integer.valueOf(47), "publicAccountNew.onVoiceRecordEnd");
    map.put(Integer.valueOf(48), "publicAccountNew.onVoicePlayEnd");
    map.put(Integer.valueOf(49), "publicAccountNew.selectAndUploadAvatar");
    map.put(Integer.valueOf(50), "publicAccountNew.addPreDownloadVideo");
    map.put(Integer.valueOf(51), "publicAccountNew.stopPreDownloadVideo");
    authorizedLists = new HashMap();
    needAuthorizedLists = new HashMap();
  }
  
  public PublicAccountH5AbilityPluginImpl()
  {
    this.mPluginNameSpace = "publicAccountNew";
  }
  
  public static void getAppType(CallJs paramCallJs, String paramString)
  {
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_get_app_type_action", new Bundle(), new PublicAccountH5AbilityPluginImpl.12(paramCallJs, paramString));
  }
  
  public static void getUserInfoIpc(long paramLong, CallJs paramCallJs, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_get_user_info_action", localBundle, new PublicAccountH5AbilityPluginImpl.13(paramCallJs, paramString));
  }
  
  private void handleInviteFriendResult(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (this.activity == null) {
        return;
      }
      String str = paramIntent.getStringExtra("arg_callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      int i = paramIntent.getIntExtra("result_code", -1);
      if (i == 0) {
        this.mHandler.postDelayed(new PublicAccountH5AbilityPluginImpl.15(this), 200L);
      }
      if (paramIntent.hasExtra("result_msg")) {
        paramIntent = paramIntent.getStringExtra("result_msg");
      } else {
        paramIntent = "";
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", i);
        localJSONObject.put("msg", paramIntent);
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      callJs(str, new String[] { localJSONObject.toString() });
    }
  }
  
  private void innerOpenCameraCaptureActivity(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (((IRIJUGCDianDian)QRoute.api(IRIJUGCDianDian.class)).getVideoUploadTaskSize() >= 2)
    {
      paramString1 = this.activity;
      QQToast.makeText(paramString1, 0, paramString1.getString(2131915357), 0).show(this.activity.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    paramString4 = new Bundle();
    paramString4.putString("arg_topic_id", paramString1);
    paramString4.putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
    paramString4.putString("arg_topic_id", paramString1);
    paramString4.putString("arg_topic_name", paramString2);
    paramString4.putInt("arg_ad_tag", paramInt1);
    paramString4.putString("arg_callback", paramString3);
    paramString4.putString("arg_ugc_edit_cookie", paramString8);
    ((IReadInJoyCaptureLauncher)QRoute.api(IReadInJoyCaptureLauncher.class)).launchFromWebForResult(this, this.mRuntime.d(), paramString4, (byte)116);
    ((IRIJUGCDianDian)QRoute.api(IRIJUGCDianDian.class)).secondClassDeliverOperationReport("2", "2");
  }
  
  public static int[] intToCharArray(int paramInt)
  {
    int[] arrayOfInt = new int[32];
    int i = 0;
    while (i < 32)
    {
      arrayOfInt[(31 - i)] = (paramInt >> i & 0x1);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static void remove(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (((String)paramArrayList.get(i)).equals(paramString))
      {
        paramArrayList.remove(i);
        return;
      }
      i += 1;
    }
  }
  
  public static void reportT(String... paramVarArgs)
  {
    Object localObject = "";
    QLog.i("PublicAccountH5AbilityPlugin", 1, "[reportT]");
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        String str1 = paramVarArgs.optString("code");
        paramVarArgs = paramVarArgs.optJSONObject("params");
        if ((!TextUtils.isEmpty(str1)) && (paramVarArgs != null))
        {
          String str2 = paramVarArgs.optString("r2", "");
          String str3 = paramVarArgs.optString("r3", "");
          String str4 = paramVarArgs.optString("r4", "");
          JSONObject localJSONObject = paramVarArgs.optJSONObject("r5");
          IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          paramVarArgs = (String[])localObject;
          if (localJSONObject != null) {
            paramVarArgs = localJSONObject.toString();
          }
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, null, str1, str1, 0, 0, str2, str3, str4, paramVarArgs, false);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("[reportT], code = ");
          paramVarArgs.append(str1);
          paramVarArgs.append(", r5 = ");
          paramVarArgs.append(localJSONObject);
          QLog.i("PublicAccountH5AbilityPlugin", 1, paramVarArgs.toString());
          return;
        }
      }
      catch (Throwable paramVarArgs)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[reportT] t = ");
        ((StringBuilder)localObject).append(paramVarArgs);
        QLog.e("PublicAccountH5AbilityPlugin", 1, ((StringBuilder)localObject).toString());
        return;
      }
      catch (JSONException paramVarArgs)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[reportT] json e = ");
        ((StringBuilder)localObject).append(paramVarArgs);
        QLog.e("PublicAccountH5AbilityPlugin", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void selectAndInviteFriend(String paramString, String... paramVarArgs)
  {
    int i;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (this.activity != null)) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("selectAndInviteFriend param json:");
          paramString.append(((JSONObject)localObject1).toString());
          QLog.i("PublicAccountH5AbilityPlugin", 2, paramString.toString());
        }
        paramString = ((JSONObject)localObject1).optString("rowkey", "");
        int j = ((JSONObject)localObject1).optInt("maxSelect");
        int k = ((JSONObject)localObject1).optInt("maxCount");
        paramVarArgs = ((JSONObject)localObject1).optString("callback", "");
        Object localObject2 = ((JSONObject)localObject1).optString("invitedUins", "[]");
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0))
        {
          localObject2 = new JSONArray(((String)localObject2).trim());
          if (i < ((JSONArray)localObject2).length())
          {
            ((StringBuilder)localObject1).append(((JSONArray)localObject2).get(i));
            if (i >= ((JSONArray)localObject2).length() - 1) {
              break label355;
            }
            ((StringBuilder)localObject1).append(",");
            break label355;
          }
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("opentype", 1);
        ((Intent)localObject2).putExtra("filterUins", ((StringBuilder)localObject1).toString());
        ((Intent)localObject2).putExtra("maxSelect", j);
        if (k > 0) {
          ((Intent)localObject2).putExtra("maxCount", k);
        }
        ((Intent)localObject2).putExtra("rowkey", paramString);
        ((Intent)localObject2).putExtra("callback", paramVarArgs);
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoySelectMemberAQFragmentForResult(this.activity, (Intent)localObject2);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("selectAndInviteFriend e = ");
          paramVarArgs.append(paramString);
          QLog.e("PublicAccountH5AbilityPlugin", 2, paramVarArgs.toString());
        }
        paramString.printStackTrace();
      }
      return;
      label355:
      i += 1;
    }
  }
  
  private void sharePictureToWeChat(String paramString)
  {
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    if (!NetworkUtil.isNetworkAvailable(this.mRuntime.d()))
    {
      QRUtils.a(1, 2131890731);
      return;
    }
    localObject = new QQProgressDialog(this.mRuntime.d());
    ((QQProgressDialog)localObject).c(2131891516);
    ((QQProgressDialog)localObject).show();
    ThreadManager.executeOnSubThread(new PublicAccountH5AbilityPluginImpl.26(this, paramString, localBundle, (QQProgressDialog)localObject));
  }
  
  private void showPicture(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("imageIDs");
        int k = ((JSONObject)localObject2).optInt("index");
        String str1 = ((JSONObject)localObject2).optString("srcID");
        boolean bool1 = ((JSONObject)localObject2).optBoolean("isNotShowIndex", true);
        boolean bool2 = ((JSONObject)localObject2).optBoolean("showTitle", false);
        String str2 = new String(Base64Util.decode(((JSONObject)localObject2).optString("title", ""), 0));
        String str3 = ((JSONObject)localObject2).optString("articleUrl", "");
        boolean bool3 = ((JSONObject)localObject2).optBoolean("isReport", false);
        long l1 = ((JSONObject)localObject2).optLong("touin");
        long l2 = ((JSONObject)localObject2).optLong("feeds_id");
        int m = ((JSONObject)localObject2).optInt("feeds_type");
        long l3 = ((JSONObject)localObject2).optLong("articleId");
        int n = ((JSONObject)localObject2).optInt("source");
        if (localObject1 == null) {
          break label664;
        }
        i = ((JSONArray)localObject1).length();
        if (!Boolean.valueOf(bool3).booleanValue()) {
          break label669;
        }
        paramString = new PublicAccountShowPictureReport();
        paramString.parse((JSONObject)localObject2);
        bool3 = QLog.isColorLevel();
        if (bool3) {
          QLog.d("PublicAccountH5AbilityPlugin", 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
        }
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
        {
          localObject2 = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).get(j).toString());
            j += 1;
            continue;
          }
          if (this.activity != null)
          {
            localObject1 = new Intent(this.activity, TroopAvatarWallPreviewActivity.class);
            Bundle localBundle = new Bundle();
            localBundle.putInt("index", k);
            localBundle.putStringArrayList("seqNum", (ArrayList)localObject2);
            localBundle.putBoolean("needBottomBar", false);
            localBundle.putBoolean("IS_EDIT", false);
            localBundle.putBoolean("is_use_path", true);
            localBundle.putBoolean("is_show_action", true);
            localBundle.putBoolean("is_not_show_index", bool1);
            localBundle.putBoolean("is_grid_image_report", true);
            localBundle.putString("to_uin", Long.toString(l1));
            localBundle.putString("feeds_id", Long.toString(l2));
            localBundle.putString("article_id", Long.toString(l3));
            localBundle.putString("scroll_image_r5", ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transGridImageClickR5(i, -1, Integer.toString(n), m, "", "", null));
            localBundle.putString("read_article_r5", ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transReadArticleClickR5(i, -1, Integer.toString(n), m, "", null));
            if (!TextUtils.isEmpty(str1)) {
              localBundle.putString("src_id", str1);
            }
            if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
            {
              localBundle.putBoolean("is_show_content_url", true);
              localBundle.putString("article_url", str3);
              localBundle.putString("article_title", str2);
            }
            if ((paramString != null) && (paramString.isReport)) {
              localBundle.putString("PublicAccountShowPictureReport", paramString.toString());
            }
            ((Intent)localObject1).putExtras(localBundle);
            this.activity.startActivityForResult((Intent)localObject1, 100);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountH5AbilityPlugin", 2, "imageList is null or length is 0");
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label664:
      int i = 0;
      continue;
      label669:
      paramString = null;
    }
  }
  
  /* Error */
  public static void showReadInJoyNativeCommentView(JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 823
    //   4: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 11
    //   9: aload_0
    //   10: ldc_w 713
    //   13: iconst_3
    //   14: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   17: istore_2
    //   18: aload_0
    //   19: ldc_w 827
    //   22: ldc 230
    //   24: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 17
    //   29: aload_0
    //   30: ldc_w 829
    //   33: iconst_m1
    //   34: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   37: istore_3
    //   38: aload_0
    //   39: ldc_w 831
    //   42: iconst_m1
    //   43: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   46: istore 4
    //   48: aload_0
    //   49: ldc_w 686
    //   52: ldc 230
    //   54: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 13
    //   59: aload_0
    //   60: ldc_w 833
    //   63: ldc 230
    //   65: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 18
    //   70: aload_0
    //   71: ldc_w 835
    //   74: ldc 230
    //   76: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: astore 12
    //   81: aload_0
    //   82: ldc_w 837
    //   85: ldc2_w 838
    //   88: invokevirtual 842	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   91: lstore 7
    //   93: aload_0
    //   94: ldc_w 844
    //   97: ldc 230
    //   99: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 19
    //   104: aload_0
    //   105: ldc_w 846
    //   108: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 15
    //   113: aload_0
    //   114: ldc_w 848
    //   117: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 16
    //   122: aload_0
    //   123: ldc_w 850
    //   126: invokevirtual 852	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   129: istore 9
    //   131: aload_0
    //   132: ldc_w 854
    //   135: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   138: istore 5
    //   140: aload_0
    //   141: ldc_w 856
    //   144: iconst_0
    //   145: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   148: istore 6
    //   150: aload_0
    //   151: ldc_w 858
    //   154: iconst_1
    //   155: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   158: istore 10
    //   160: new 537	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   167: astore_0
    //   168: aload_0
    //   169: ldc_w 860
    //   172: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: aload 11
    //   179: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_0
    //   184: ldc_w 862
    //   187: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_0
    //   192: iload_2
    //   193: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_0
    //   198: ldc_w 867
    //   201: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_0
    //   206: aload 17
    //   208: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_0
    //   213: ldc_w 869
    //   216: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_0
    //   221: iload_3
    //   222: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_0
    //   227: ldc_w 871
    //   230: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_0
    //   235: iload 4
    //   237: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_0
    //   242: ldc_w 873
    //   245: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_0
    //   250: aload 13
    //   252: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_0
    //   257: ldc_w 875
    //   260: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_0
    //   265: aload 18
    //   267: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_0
    //   272: ldc_w 877
    //   275: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_0
    //   280: aload 12
    //   282: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_0
    //   287: ldc_w 879
    //   290: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_0
    //   295: lload 7
    //   297: invokevirtual 882	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_0
    //   302: ldc_w 884
    //   305: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_0
    //   310: aload 19
    //   312: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: astore_0
    //   321: ldc 45
    //   323: iconst_1
    //   324: aload_0
    //   325: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: new 285	android/os/Bundle
    //   331: dup
    //   332: invokespecial 286	android/os/Bundle:<init>	()V
    //   335: astore 14
    //   337: aload 14
    //   339: ldc_w 886
    //   342: new 888	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData
    //   345: dup
    //   346: aload 19
    //   348: iload_3
    //   349: aload 17
    //   351: iload 4
    //   353: aload 13
    //   355: aload 18
    //   357: aload 12
    //   359: lload 7
    //   361: invokespecial 891	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:<init>	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   364: invokevirtual 895	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   367: aload 14
    //   369: ldc_w 713
    //   372: iload_2
    //   373: invokevirtual 450	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   376: aload 14
    //   378: ldc_w 897
    //   381: aload 15
    //   383: invokevirtual 423	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 14
    //   388: ldc_w 899
    //   391: aload 16
    //   393: invokevirtual 423	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload 14
    //   398: ldc_w 850
    //   401: iload 9
    //   403: invokevirtual 760	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   406: aload 14
    //   408: ldc_w 854
    //   411: iload 5
    //   413: invokevirtual 450	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   416: aload 14
    //   418: ldc_w 901
    //   421: iload_1
    //   422: invokevirtual 450	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   425: aload 14
    //   427: ldc_w 858
    //   430: iload 10
    //   432: invokevirtual 760	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   435: new 903	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData
    //   438: dup
    //   439: invokespecial 904	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:<init>	()V
    //   442: astore 17
    //   444: aload 17
    //   446: aload 15
    //   448: putfield 906	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:a	Ljava/lang/String;
    //   451: aload 17
    //   453: aload 16
    //   455: putfield 909	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:b	Ljava/lang/String;
    //   458: aload 17
    //   460: iload 9
    //   462: putfield 911	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:c	Z
    //   465: aload 17
    //   467: iconst_1
    //   468: putfield 913	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:d	Z
    //   471: new 537	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   478: astore_0
    //   479: aload_0
    //   480: ldc_w 915
    //   483: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_0
    //   488: aload 15
    //   490: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_0
    //   495: ldc_w 917
    //   498: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_0
    //   503: aload 16
    //   505: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_0
    //   510: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: astore_0
    //   514: ldc 45
    //   516: iconst_1
    //   517: aload_0
    //   518: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: getstatic 923	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   524: astore 15
    //   526: aconst_null
    //   527: astore_0
    //   528: aload 13
    //   530: ifnull +100 -> 630
    //   533: new 369	java/lang/String
    //   536: dup
    //   537: aload 13
    //   539: iconst_0
    //   540: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   543: invokespecial 695	java/lang/String:<init>	([B)V
    //   546: astore_0
    //   547: goto +3 -> 550
    //   550: ldc_w 925
    //   553: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   556: checkcast 925	com/tencent/mobileqq/kandian/biz/common/baseui/api/IReadInJoyAtlasCommentFragmentLauncher
    //   559: astore 13
    //   561: iload 6
    //   563: iconst_1
    //   564: if_icmpne +69 -> 633
    //   567: iconst_1
    //   568: istore 9
    //   570: goto +3 -> 573
    //   573: aload 13
    //   575: aload 15
    //   577: aload 11
    //   579: aload_0
    //   580: aconst_null
    //   581: aload 12
    //   583: aload 17
    //   585: iconst_0
    //   586: iload 9
    //   588: aload 14
    //   590: invokeinterface 929 10 0
    //   595: return
    //   596: astore_0
    //   597: goto +16 -> 613
    //   600: astore_0
    //   601: goto +12 -> 613
    //   604: astore_0
    //   605: goto +8 -> 613
    //   608: astore_0
    //   609: goto +4 -> 613
    //   612: astore_0
    //   613: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +13 -> 629
    //   619: ldc 45
    //   621: iconst_2
    //   622: aload_0
    //   623: invokestatic 933	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   626: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: return
    //   630: goto -80 -> 550
    //   633: iconst_0
    //   634: istore 9
    //   636: goto -63 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	paramJSONObject	JSONObject
    //   0	639	1	paramInt	int
    //   17	356	2	i	int
    //   37	312	3	j	int
    //   46	306	4	k	int
    //   138	274	5	m	int
    //   148	417	6	n	int
    //   91	269	7	l	long
    //   129	506	9	bool1	boolean
    //   158	273	10	bool2	boolean
    //   7	571	11	str1	String
    //   79	503	12	str2	String
    //   57	517	13	localObject1	Object
    //   335	254	14	localBundle	Bundle
    //   111	465	15	localObject2	Object
    //   120	384	16	str3	String
    //   27	557	17	localObject3	Object
    //   68	288	18	str4	String
    //   102	245	19	str5	String
    // Exception table:
    //   from	to	target	type
    //   514	526	596	java/lang/Exception
    //   533	547	596	java/lang/Exception
    //   550	561	596	java/lang/Exception
    //   573	595	596	java/lang/Exception
    //   337	514	600	java/lang/Exception
    //   321	337	604	java/lang/Exception
    //   81	321	608	java/lang/Exception
    //   0	81	612	java/lang/Exception
  }
  
  public static void updateUserInfoIPC(String paramString)
  {
    try
    {
      localObject = new JSONObject(paramString).optJSONArray("uinList");
      paramString = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramString.add(((JSONArray)localObject).getString(i));
        i += 1;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("uinList", paramString);
      QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_update_user_info", (Bundle)localObject, null);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[updateUserInfo] e = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("PublicAccountH5AbilityPlugin", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void cancleAllUploadAndDownloadTask()
  {
    TroopMemberApiClient localTroopMemberApiClient = this.mClient;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.j();
    }
    this.uploadBeensList.clear();
    this.downloadBeensList.clear();
    this.cameraPath = "";
    this.cameraCallback = "";
    this.cameraUUid = "";
  }
  
  void cancleProgressDailog()
  {
    ProgressDialog localProgressDialog = this.mPd;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.mPd.cancel();
    }
  }
  
  public void choosePicture(int paramInt1, int paramInt2)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.activity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localActivityURIRequest.extra().putString("PhotoConst.CUSTOM_SENDBTN_TEXT", HardCodeUtil.a(2131899883));
    if (paramInt2 == 1) {
      localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", 2);
    } else if (paramInt2 == 2) {
      localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    }
    if (paramInt2 == 0)
    {
      localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", true);
      localActivityURIRequest.extra().putBoolean("PhotoConst.quality_count_tv", true);
    }
    else
    {
      localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", false);
      localActivityURIRequest.extra().putBoolean("PhotoConst.quality_count_tv", false);
    }
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.activity.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
    if (this.mRuntime.f() != null) {
      WebViewUtil.a(this, localActivityURIRequest, (byte)111, this.mRuntime.f());
    }
  }
  
  void cleanConfig(String paramString)
  {
    this.pUin = "";
    if (paramString != null) {
      authorizedLists.remove(paramString);
    }
  }
  
  public boolean contains(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (((String)paramArrayList.get(i)).equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void downloadShortVideoFilterSo()
  {
    if (this.mClient == null) {
      this.mClient = TroopMemberApiClient.a();
    }
    this.mClient.i();
  }
  
  public ArrayList<String> getMenuHideNameList()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
    if (localSwiftBrowserShareMenuHandler != null) {
      return localSwiftBrowserShareMenuHandler.i;
    }
    return null;
  }
  
  public WebViewPlugin.PluginRuntime getRuntime()
  {
    return this.mRuntime;
  }
  
  public String getUserInfoFailStr(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("retCode", Integer.valueOf(-1));
      localJSONObject.putOpt("retMsg", paramString);
    }
    catch (JSONException paramString)
    {
      QLog.d("PublicAccountH5AbilityPlugin", 1, paramString.getMessage());
    }
    return localJSONObject.toString();
  }
  
  public String getUserInfoJson(Object paramObject)
  {
    Object localObject = (ReadInJoyUserInfo)paramObject;
    paramObject = new JSONObject();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("accountType", Integer.valueOf(((ReadInJoyUserInfo)localObject).accountType));
        localJSONObject.putOpt("uin", ((ReadInJoyUserInfo)localObject).uin);
        paramObject.putOpt("accountInfo", localJSONObject);
        paramObject.putOpt("nickName", ((ReadInJoyUserInfo)localObject).nick);
        localJSONObject = new JSONObject();
        localJSONObject.putOpt("faceType", Integer.valueOf(((ReadInJoyUserInfo)localObject).faceType));
        localJSONObject.putOpt("timeStamp", Long.valueOf(((ReadInJoyUserInfo)localObject).timestamp));
        localJSONObject.putOpt("faceFlag", Integer.valueOf(((ReadInJoyUserInfo)localObject).faceFlag));
        localJSONObject.putOpt("url", ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getResultFaceUrl((ReadInJoyUserInfo)localObject));
        localJSONObject.putOpt("sysID", Integer.valueOf(((ReadInJoyUserInfo)localObject).systemID));
        paramObject.putOpt("headerInfo", localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.putOpt("ccLevel", Integer.valueOf(((ReadInJoyUserInfo)localObject).accountLevel));
        localJSONObject.putOpt("iconUrlSmall", ((ReadInJoyUserInfo)localObject).smallIconUrl);
        localJSONObject.putOpt("iconUrlLarge", ((ReadInJoyUserInfo)localObject).largeIconUrl);
        paramObject.putOpt("accountLevelInfo", localJSONObject);
        localJSONObject = new JSONObject();
        if (!((ReadInJoyUserInfo)localObject).isLiving()) {
          break label401;
        }
        i = 1;
        localJSONObject.putOpt("isLiving", Integer.valueOf(i));
        localJSONObject.putOpt("source", Integer.valueOf(((ReadInJoyUserInfo)localObject).getLiveSource()));
        localJSONObject.putOpt("url", ((ReadInJoyUserInfo)localObject).getLiveUrl());
        paramObject.putOpt("liveStatusInfo", localJSONObject);
        paramObject.putOpt("retCode", Integer.valueOf(0));
        paramObject.putOpt("retMsg", "");
        localObject = paramObject.toString();
        return localObject;
      }
      catch (Exception localException1)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, localException1.getMessage());
        try
        {
          paramObject.putOpt("retCode", Integer.valueOf(-1));
          paramObject.putOpt("retMsg", localException1.getMessage());
        }
        catch (Exception localException2)
        {
          QLog.e("PublicAccountH5AbilityPlugin", 1, localException2.getMessage());
        }
      }
      return paramObject.toString();
      label401:
      int i = 0;
    }
  }
  
  public Object getWebResponse(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = (String)localIdMap.get(paramString);
      if (paramString == null) {
        return null;
      }
      InputStream localInputStream = CrmUtils.a(SafeBitmapFactory.decodeFile(paramString));
      paramString = localObject;
      if (localInputStream != null) {
        paramString = new WebResourceResponse("image/png", "UTF-8", localInputStream);
      }
      return paramString;
    }
    catch (OutOfMemoryError|Exception paramString) {}
    return null;
  }
  
  public WebViewPlugin getWebViewPlugin()
  {
    return this;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (paramMap != null)
      {
        int i = ((Integer)paramMap.get("requestCode")).intValue();
        if ((i == 1) || (i == 113) || (i == 114) || (i == 115) || (i == 116) || (i == 117) || (i == 118) || (i == 119) || (i == 122))
        {
          int j = ((Integer)paramMap.get("resultCode")).intValue();
          onActivityResult((Intent)paramMap.get("data"), (byte)i, j);
          return true;
        }
      }
    }
    else if (paramLong == 8589934597L) {
      onPause();
    }
    return false;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 260
    //   3: aload_3
    //   4: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   7: istore 14
    //   9: iconst_0
    //   10: istore 15
    //   12: iconst_0
    //   13: istore 9
    //   15: iload 14
    //   17: ifeq +14078 -> 14095
    //   20: ldc_w 1192
    //   23: aload 4
    //   25: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   28: ifeq +125 -> 153
    //   31: aload 5
    //   33: ifnull +90 -> 123
    //   36: aload 5
    //   38: arraylength
    //   39: ifle +84 -> 123
    //   42: new 353	org/json/JSONObject
    //   45: dup
    //   46: aload 5
    //   48: iconst_0
    //   49: aaload
    //   50: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: ldc_w 577
    //   56: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +47 -> 111
    //   67: new 353	org/json/JSONObject
    //   70: dup
    //   71: invokespecial 354	org/json/JSONObject:<init>	()V
    //   74: astore_2
    //   75: aload_2
    //   76: ldc_w 356
    //   79: iconst_0
    //   80: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_2
    //   85: ldc_w 361
    //   88: ldc_w 1194
    //   91: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload_0
    //   96: aload_1
    //   97: iconst_1
    //   98: anewarray 369	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: aload_2
    //   104: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   107: aastore
    //   108: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 1196	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:openLocation	()V
    //   115: goto +8 -> 123
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   123: aconst_null
    //   124: ldc_w 1198
    //   127: ldc_w 1200
    //   130: ldc 230
    //   132: ldc_w 1202
    //   135: ldc_w 1202
    //   138: iconst_0
    //   139: iconst_0
    //   140: ldc 230
    //   142: ldc 230
    //   144: ldc 230
    //   146: ldc 230
    //   148: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   151: iconst_1
    //   152: ireturn
    //   153: ldc_w 1209
    //   156: aload 4
    //   158: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   161: ifeq +55 -> 216
    //   164: aload 5
    //   166: ifnull +48 -> 214
    //   169: aload 5
    //   171: arraylength
    //   172: ifle +42 -> 214
    //   175: new 353	org/json/JSONObject
    //   178: dup
    //   179: aload 5
    //   181: iconst_0
    //   182: aaload
    //   183: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   186: ldc_w 297
    //   189: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_1
    //   193: ldc 230
    //   195: aload_1
    //   196: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +15 -> 214
    //   202: aload_0
    //   203: aload_1
    //   204: invokevirtual 1211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showOfficialAccountProfile	(Ljava/lang/String;)V
    //   207: iconst_1
    //   208: ireturn
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: ldc_w 1213
    //   219: aload 4
    //   221: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   224: ifeq +96 -> 320
    //   227: aload 5
    //   229: ifnull +89 -> 318
    //   232: aload 5
    //   234: arraylength
    //   235: ifle +83 -> 318
    //   238: new 353	org/json/JSONObject
    //   241: dup
    //   242: aload 5
    //   244: iconst_0
    //   245: aaload
    //   246: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   249: ldc_w 577
    //   252: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: astore_1
    //   256: aload_1
    //   257: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: ifne +47 -> 307
    //   263: new 353	org/json/JSONObject
    //   266: dup
    //   267: invokespecial 354	org/json/JSONObject:<init>	()V
    //   270: astore_2
    //   271: aload_2
    //   272: ldc_w 356
    //   275: iconst_0
    //   276: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 361
    //   284: ldc_w 1194
    //   287: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload_0
    //   292: aload_1
    //   293: iconst_1
    //   294: anewarray 369	java/lang/String
    //   297: dup
    //   298: iconst_0
    //   299: aload_2
    //   300: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   303: aastore
    //   304: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   307: aload_0
    //   308: invokevirtual 1215	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showWebPanel	()V
    //   311: iconst_1
    //   312: ireturn
    //   313: astore_1
    //   314: aload_1
    //   315: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   318: iconst_1
    //   319: ireturn
    //   320: ldc_w 1217
    //   323: aload 4
    //   325: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   328: ifeq +109 -> 437
    //   331: aload 5
    //   333: ifnull +102 -> 435
    //   336: aload 5
    //   338: arraylength
    //   339: ifle +96 -> 435
    //   342: new 353	org/json/JSONObject
    //   345: dup
    //   346: aload 5
    //   348: iconst_0
    //   349: aaload
    //   350: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   353: astore_1
    //   354: aload_1
    //   355: ldc_w 1219
    //   358: invokevirtual 852	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   361: istore 14
    //   363: aload_1
    //   364: ldc_w 577
    //   367: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   370: astore_1
    //   371: aload_1
    //   372: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +47 -> 422
    //   378: new 353	org/json/JSONObject
    //   381: dup
    //   382: invokespecial 354	org/json/JSONObject:<init>	()V
    //   385: astore_2
    //   386: aload_2
    //   387: ldc_w 356
    //   390: iconst_0
    //   391: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   394: pop
    //   395: aload_2
    //   396: ldc_w 361
    //   399: ldc_w 1194
    //   402: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   405: pop
    //   406: aload_0
    //   407: aload_1
    //   408: iconst_1
    //   409: anewarray 369	java/lang/String
    //   412: dup
    //   413: iconst_0
    //   414: aload_2
    //   415: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   418: aastore
    //   419: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   422: aload_0
    //   423: iload 14
    //   425: invokevirtual 1221	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:setRightButtonState	(Z)V
    //   428: iconst_1
    //   429: ireturn
    //   430: astore_1
    //   431: aload_1
    //   432: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   435: iconst_1
    //   436: ireturn
    //   437: ldc_w 1223
    //   440: aload 4
    //   442: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   445: ifeq +180 -> 625
    //   448: aload 5
    //   450: ifnull +145 -> 595
    //   453: aload 5
    //   455: arraylength
    //   456: ifle +139 -> 595
    //   459: new 353	org/json/JSONObject
    //   462: dup
    //   463: aload 5
    //   465: iconst_0
    //   466: aaload
    //   467: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   470: astore_2
    //   471: aload_2
    //   472: ldc_w 577
    //   475: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore_1
    //   479: aload_2
    //   480: ldc_w 1225
    //   483: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   486: astore_3
    //   487: new 247	java/util/ArrayList
    //   490: dup
    //   491: invokespecial 248	java/util/ArrayList:<init>	()V
    //   494: astore_2
    //   495: aload_3
    //   496: ifnull +35 -> 531
    //   499: iconst_0
    //   500: istore 6
    //   502: iload 6
    //   504: aload_3
    //   505: invokevirtual 591	org/json/JSONArray:length	()I
    //   508: if_icmpge +23 -> 531
    //   511: aload_2
    //   512: aload_3
    //   513: iload 6
    //   515: invokevirtual 1227	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   518: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   521: pop
    //   522: iload 6
    //   524: iconst_1
    //   525: iadd
    //   526: istore 6
    //   528: goto -26 -> 502
    //   531: aload_1
    //   532: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   535: ifne +47 -> 582
    //   538: new 353	org/json/JSONObject
    //   541: dup
    //   542: invokespecial 354	org/json/JSONObject:<init>	()V
    //   545: astore_3
    //   546: aload_3
    //   547: ldc_w 356
    //   550: iconst_0
    //   551: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   554: pop
    //   555: aload_3
    //   556: ldc_w 361
    //   559: ldc_w 1194
    //   562: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload_0
    //   567: aload_1
    //   568: iconst_1
    //   569: anewarray 369	java/lang/String
    //   572: dup
    //   573: iconst_0
    //   574: aload_3
    //   575: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   578: aastore
    //   579: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   582: aload_0
    //   583: aload_2
    //   584: invokevirtual 1230	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:hideMenuItems	(Ljava/util/ArrayList;)V
    //   587: goto +8 -> 595
    //   590: astore_1
    //   591: aload_1
    //   592: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   595: aconst_null
    //   596: ldc_w 1198
    //   599: ldc_w 1200
    //   602: ldc 230
    //   604: ldc_w 1232
    //   607: ldc_w 1232
    //   610: iconst_0
    //   611: iconst_0
    //   612: ldc 230
    //   614: ldc 230
    //   616: ldc 230
    //   618: ldc 230
    //   620: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   623: iconst_1
    //   624: ireturn
    //   625: ldc_w 1234
    //   628: aload 4
    //   630: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   633: ifeq +180 -> 813
    //   636: aload 5
    //   638: ifnull +145 -> 783
    //   641: aload 5
    //   643: arraylength
    //   644: ifle +139 -> 783
    //   647: new 353	org/json/JSONObject
    //   650: dup
    //   651: aload 5
    //   653: iconst_0
    //   654: aaload
    //   655: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   658: astore_2
    //   659: aload_2
    //   660: ldc_w 577
    //   663: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   666: astore_1
    //   667: aload_2
    //   668: ldc_w 1225
    //   671: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   674: astore_3
    //   675: new 247	java/util/ArrayList
    //   678: dup
    //   679: invokespecial 248	java/util/ArrayList:<init>	()V
    //   682: astore_2
    //   683: aload_3
    //   684: ifnull +35 -> 719
    //   687: iconst_0
    //   688: istore 6
    //   690: iload 6
    //   692: aload_3
    //   693: invokevirtual 591	org/json/JSONArray:length	()I
    //   696: if_icmpge +23 -> 719
    //   699: aload_2
    //   700: aload_3
    //   701: iload 6
    //   703: invokevirtual 1227	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   706: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   709: pop
    //   710: iload 6
    //   712: iconst_1
    //   713: iadd
    //   714: istore 6
    //   716: goto -26 -> 690
    //   719: aload_1
    //   720: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   723: ifne +47 -> 770
    //   726: new 353	org/json/JSONObject
    //   729: dup
    //   730: invokespecial 354	org/json/JSONObject:<init>	()V
    //   733: astore_3
    //   734: aload_3
    //   735: ldc_w 356
    //   738: iconst_0
    //   739: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload_3
    //   744: ldc_w 361
    //   747: ldc_w 1194
    //   750: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   753: pop
    //   754: aload_0
    //   755: aload_1
    //   756: iconst_1
    //   757: anewarray 369	java/lang/String
    //   760: dup
    //   761: iconst_0
    //   762: aload_3
    //   763: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   766: aastore
    //   767: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   770: aload_0
    //   771: aload_2
    //   772: invokevirtual 1236	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showMenuItems	(Ljava/util/ArrayList;)V
    //   775: goto +8 -> 783
    //   778: astore_1
    //   779: aload_1
    //   780: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   783: aconst_null
    //   784: ldc_w 1198
    //   787: ldc_w 1200
    //   790: ldc 230
    //   792: ldc_w 1238
    //   795: ldc_w 1238
    //   798: iconst_0
    //   799: iconst_0
    //   800: ldc 230
    //   802: ldc 230
    //   804: ldc 230
    //   806: ldc 230
    //   808: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   811: iconst_1
    //   812: ireturn
    //   813: ldc_w 1240
    //   816: aload 4
    //   818: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   821: ifeq +125 -> 946
    //   824: aload 5
    //   826: ifnull +90 -> 916
    //   829: aload 5
    //   831: arraylength
    //   832: ifle +84 -> 916
    //   835: new 353	org/json/JSONObject
    //   838: dup
    //   839: aload 5
    //   841: iconst_0
    //   842: aaload
    //   843: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   846: ldc_w 577
    //   849: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   852: astore_1
    //   853: aload_1
    //   854: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   857: ifne +47 -> 904
    //   860: new 353	org/json/JSONObject
    //   863: dup
    //   864: invokespecial 354	org/json/JSONObject:<init>	()V
    //   867: astore_2
    //   868: aload_2
    //   869: ldc_w 356
    //   872: iconst_0
    //   873: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   876: pop
    //   877: aload_2
    //   878: ldc_w 361
    //   881: ldc_w 1194
    //   884: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   887: pop
    //   888: aload_0
    //   889: aload_1
    //   890: iconst_1
    //   891: anewarray 369	java/lang/String
    //   894: dup
    //   895: iconst_0
    //   896: aload_2
    //   897: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   900: aastore
    //   901: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   904: aload_0
    //   905: invokevirtual 1242	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:hideAllNonBaseMenuItem	()V
    //   908: goto +8 -> 916
    //   911: astore_1
    //   912: aload_1
    //   913: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   916: aconst_null
    //   917: ldc_w 1198
    //   920: ldc_w 1200
    //   923: ldc 230
    //   925: ldc_w 1244
    //   928: ldc_w 1244
    //   931: iconst_0
    //   932: iconst_0
    //   933: ldc 230
    //   935: ldc 230
    //   937: ldc 230
    //   939: ldc 230
    //   941: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   944: iconst_1
    //   945: ireturn
    //   946: ldc_w 1246
    //   949: aload 4
    //   951: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   954: ifeq +125 -> 1079
    //   957: aload 5
    //   959: ifnull +90 -> 1049
    //   962: aload 5
    //   964: arraylength
    //   965: ifle +84 -> 1049
    //   968: new 353	org/json/JSONObject
    //   971: dup
    //   972: aload 5
    //   974: iconst_0
    //   975: aaload
    //   976: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   979: ldc_w 577
    //   982: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   985: astore_1
    //   986: aload_1
    //   987: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   990: ifne +47 -> 1037
    //   993: new 353	org/json/JSONObject
    //   996: dup
    //   997: invokespecial 354	org/json/JSONObject:<init>	()V
    //   1000: astore_2
    //   1001: aload_2
    //   1002: ldc_w 356
    //   1005: iconst_0
    //   1006: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1009: pop
    //   1010: aload_2
    //   1011: ldc_w 361
    //   1014: ldc_w 1194
    //   1017: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1020: pop
    //   1021: aload_0
    //   1022: aload_1
    //   1023: iconst_1
    //   1024: anewarray 369	java/lang/String
    //   1027: dup
    //   1028: iconst_0
    //   1029: aload_2
    //   1030: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1033: aastore
    //   1034: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1037: aload_0
    //   1038: invokevirtual 1248	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showAllNonBaseMenuItem	()V
    //   1041: goto +8 -> 1049
    //   1044: astore_1
    //   1045: aload_1
    //   1046: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   1049: aconst_null
    //   1050: ldc_w 1198
    //   1053: ldc_w 1200
    //   1056: ldc 230
    //   1058: ldc_w 1250
    //   1061: ldc_w 1250
    //   1064: iconst_0
    //   1065: iconst_0
    //   1066: ldc 230
    //   1068: ldc 230
    //   1070: ldc 230
    //   1072: ldc 230
    //   1074: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1077: iconst_1
    //   1078: ireturn
    //   1079: ldc_w 1252
    //   1082: aload 4
    //   1084: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1087: ifeq +125 -> 1212
    //   1090: aload 5
    //   1092: ifnull +90 -> 1182
    //   1095: aload 5
    //   1097: arraylength
    //   1098: ifle +84 -> 1182
    //   1101: new 353	org/json/JSONObject
    //   1104: dup
    //   1105: aload 5
    //   1107: iconst_0
    //   1108: aaload
    //   1109: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1112: ldc_w 577
    //   1115: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1118: astore_1
    //   1119: aload_1
    //   1120: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1123: ifne +47 -> 1170
    //   1126: new 353	org/json/JSONObject
    //   1129: dup
    //   1130: invokespecial 354	org/json/JSONObject:<init>	()V
    //   1133: astore_2
    //   1134: aload_2
    //   1135: ldc_w 356
    //   1138: iconst_0
    //   1139: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1142: pop
    //   1143: aload_2
    //   1144: ldc_w 361
    //   1147: ldc_w 1194
    //   1150: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1153: pop
    //   1154: aload_0
    //   1155: aload_1
    //   1156: iconst_1
    //   1157: anewarray 369	java/lang/String
    //   1160: dup
    //   1161: iconst_0
    //   1162: aload_2
    //   1163: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1166: aastore
    //   1167: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1170: aload_0
    //   1171: invokevirtual 1254	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showWebToolbar	()V
    //   1174: goto +8 -> 1182
    //   1177: astore_1
    //   1178: aload_1
    //   1179: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   1182: aconst_null
    //   1183: ldc_w 1198
    //   1186: ldc_w 1200
    //   1189: ldc 230
    //   1191: ldc_w 1256
    //   1194: ldc_w 1256
    //   1197: iconst_0
    //   1198: iconst_0
    //   1199: ldc 230
    //   1201: ldc 230
    //   1203: ldc 230
    //   1205: ldc 230
    //   1207: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1210: iconst_1
    //   1211: ireturn
    //   1212: ldc_w 1258
    //   1215: aload 4
    //   1217: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1220: ifeq +125 -> 1345
    //   1223: aload 5
    //   1225: ifnull +90 -> 1315
    //   1228: aload 5
    //   1230: arraylength
    //   1231: ifle +84 -> 1315
    //   1234: new 353	org/json/JSONObject
    //   1237: dup
    //   1238: aload 5
    //   1240: iconst_0
    //   1241: aaload
    //   1242: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1245: ldc_w 577
    //   1248: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1251: astore_1
    //   1252: aload_1
    //   1253: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1256: ifne +47 -> 1303
    //   1259: new 353	org/json/JSONObject
    //   1262: dup
    //   1263: invokespecial 354	org/json/JSONObject:<init>	()V
    //   1266: astore_2
    //   1267: aload_2
    //   1268: ldc_w 356
    //   1271: iconst_0
    //   1272: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1275: pop
    //   1276: aload_2
    //   1277: ldc_w 361
    //   1280: ldc_w 1194
    //   1283: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1286: pop
    //   1287: aload_0
    //   1288: aload_1
    //   1289: iconst_1
    //   1290: anewarray 369	java/lang/String
    //   1293: dup
    //   1294: iconst_0
    //   1295: aload_2
    //   1296: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1299: aastore
    //   1300: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1303: aload_0
    //   1304: invokevirtual 1260	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:hideWebToolbar	()V
    //   1307: goto +8 -> 1315
    //   1310: astore_1
    //   1311: aload_1
    //   1312: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   1315: aconst_null
    //   1316: ldc_w 1198
    //   1319: ldc_w 1200
    //   1322: ldc 230
    //   1324: ldc_w 1262
    //   1327: ldc_w 1262
    //   1330: iconst_0
    //   1331: iconst_0
    //   1332: ldc 230
    //   1334: ldc 230
    //   1336: ldc 230
    //   1338: ldc 230
    //   1340: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1343: iconst_1
    //   1344: ireturn
    //   1345: ldc_w 1264
    //   1348: aload 4
    //   1350: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1353: ifeq +358 -> 1711
    //   1356: aload 5
    //   1358: ifnull +310 -> 1668
    //   1361: aload 5
    //   1363: arraylength
    //   1364: ifle +304 -> 1668
    //   1367: new 353	org/json/JSONObject
    //   1370: dup
    //   1371: aload 5
    //   1373: iconst_0
    //   1374: aaload
    //   1375: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1378: astore_1
    //   1379: aload_1
    //   1380: ldc_w 577
    //   1383: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1386: astore_2
    //   1387: aload_1
    //   1388: ldc_w 1266
    //   1391: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1394: astore_3
    //   1395: aload_1
    //   1396: ldc_w 1268
    //   1399: iconst_1
    //   1400: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1403: istore 6
    //   1405: getstatic 197	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:localIdMap	Ljava/util/HashMap;
    //   1408: aload_3
    //   1409: invokevirtual 1137	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1412: checkcast 369	java/lang/String
    //   1415: astore_1
    //   1416: new 1270	java/io/File
    //   1419: dup
    //   1420: aload_1
    //   1421: invokespecial 1271	java/io/File:<init>	(Ljava/lang/String;)V
    //   1424: astore 4
    //   1426: aload 4
    //   1428: invokevirtual 1274	java/io/File:exists	()Z
    //   1431: ifne +48 -> 1479
    //   1434: aload_0
    //   1435: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1438: astore_2
    //   1439: new 537	java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   1446: astore_3
    //   1447: aload_3
    //   1448: ldc_w 1275
    //   1451: invokestatic 982	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1454: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: pop
    //   1458: aload_3
    //   1459: aload_1
    //   1460: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: aload_2
    //   1465: aload_3
    //   1466: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: iconst_0
    //   1470: invokestatic 1278	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1473: invokevirtual 1281	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   1476: pop
    //   1477: iconst_1
    //   1478: ireturn
    //   1479: aload 4
    //   1481: invokevirtual 1283	java/io/File:length	()J
    //   1484: ldc2_w 1284
    //   1487: lcmp
    //   1488: ifle +45 -> 1533
    //   1491: aload_0
    //   1492: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1495: astore_2
    //   1496: new 537	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   1503: astore_3
    //   1504: aload_3
    //   1505: ldc_w 1287
    //   1508: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: pop
    //   1512: aload_3
    //   1513: aload_1
    //   1514: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: pop
    //   1518: aload_2
    //   1519: aload_3
    //   1520: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: iconst_0
    //   1524: invokestatic 1278	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1527: invokevirtual 1281	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   1530: pop
    //   1531: iconst_1
    //   1532: ireturn
    //   1533: aload_0
    //   1534: getfield 250	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uploadBeensList	Ljava/util/ArrayList;
    //   1537: invokevirtual 1291	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1540: astore 4
    //   1542: aload 4
    //   1544: invokeinterface 1296 1 0
    //   1549: ifeq +51 -> 1600
    //   1552: aload 4
    //   1554: invokeinterface 1300 1 0
    //   1559: checkcast 1302	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen
    //   1562: astore 5
    //   1564: aload_3
    //   1565: ifnull -23 -> 1542
    //   1568: aload_3
    //   1569: aload 5
    //   1571: getfield 1303	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:b	Ljava/lang/String;
    //   1574: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1577: ifeq -35 -> 1542
    //   1580: aload_0
    //   1581: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1584: ldc_w 1304
    //   1587: invokestatic 982	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1590: iconst_0
    //   1591: invokestatic 1278	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1594: invokevirtual 1281	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   1597: pop
    //   1598: iconst_1
    //   1599: ireturn
    //   1600: new 1302	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen
    //   1603: dup
    //   1604: invokespecial 1305	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:<init>	()V
    //   1607: astore 4
    //   1609: aload 4
    //   1611: aload_2
    //   1612: putfield 1306	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:a	Ljava/lang/String;
    //   1615: aload 4
    //   1617: aload_3
    //   1618: putfield 1303	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:b	Ljava/lang/String;
    //   1621: aload 4
    //   1623: iload 6
    //   1625: putfield 1308	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:c	I
    //   1628: aload_0
    //   1629: getfield 250	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uploadBeensList	Ljava/util/ArrayList;
    //   1632: aload 4
    //   1634: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1637: pop
    //   1638: aload_0
    //   1639: getfield 250	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uploadBeensList	Ljava/util/ArrayList;
    //   1642: invokevirtual 480	java/util/ArrayList:size	()I
    //   1645: iconst_1
    //   1646: if_icmpne +15 -> 1661
    //   1649: aload_0
    //   1650: iload 6
    //   1652: aload_1
    //   1653: iconst_1
    //   1654: aload_2
    //   1655: invokevirtual 1312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:startUpload	(ILjava/lang/String;ZLjava/lang/String;)V
    //   1658: goto +10 -> 1668
    //   1661: iconst_1
    //   1662: ireturn
    //   1663: astore_1
    //   1664: aload_1
    //   1665: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   1668: ldc_w 531
    //   1671: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1674: checkcast 531	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   1677: aconst_null
    //   1678: ldc_w 1198
    //   1681: ldc_w 1200
    //   1684: ldc 230
    //   1686: ldc_w 1314
    //   1689: ldc_w 1314
    //   1692: iconst_0
    //   1693: iconst_2
    //   1694: ldc_w 1316
    //   1697: ldc 230
    //   1699: ldc 230
    //   1701: ldc 230
    //   1703: iconst_0
    //   1704: invokeinterface 1320 14 0
    //   1709: iconst_1
    //   1710: ireturn
    //   1711: ldc_w 1322
    //   1714: aload 4
    //   1716: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1719: ifeq +246 -> 1965
    //   1722: aload 5
    //   1724: ifnull +210 -> 1934
    //   1727: aload 5
    //   1729: arraylength
    //   1730: ifle +204 -> 1934
    //   1733: new 353	org/json/JSONObject
    //   1736: dup
    //   1737: aload 5
    //   1739: iconst_0
    //   1740: aaload
    //   1741: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1744: astore_3
    //   1745: aload_3
    //   1746: ldc_w 577
    //   1749: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1752: astore_1
    //   1753: aload_3
    //   1754: ldc_w 1324
    //   1757: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1760: astore_2
    //   1761: aload_3
    //   1762: ldc_w 1268
    //   1765: iconst_1
    //   1766: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1769: istore 6
    //   1771: ldc 230
    //   1773: aload_1
    //   1774: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1777: ifne +135 -> 1912
    //   1780: ldc 230
    //   1782: aload_2
    //   1783: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1786: ifeq +6 -> 1792
    //   1789: goto +123 -> 1912
    //   1792: aload_0
    //   1793: getfield 252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:downloadBeensList	Ljava/util/ArrayList;
    //   1796: invokevirtual 1291	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1799: astore_3
    //   1800: aload_3
    //   1801: invokeinterface 1296 1 0
    //   1806: ifeq +50 -> 1856
    //   1809: aload_3
    //   1810: invokeinterface 1300 1 0
    //   1815: checkcast 1326	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen
    //   1818: astore 4
    //   1820: aload_2
    //   1821: ifnull -21 -> 1800
    //   1824: aload_2
    //   1825: aload 4
    //   1827: getfield 1327	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:b	Ljava/lang/String;
    //   1830: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1833: ifeq -33 -> 1800
    //   1836: aload_0
    //   1837: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1840: ldc_w 1328
    //   1843: invokestatic 982	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1846: iconst_0
    //   1847: invokestatic 1278	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1850: invokevirtual 1281	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   1853: pop
    //   1854: iconst_1
    //   1855: ireturn
    //   1856: new 1326	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen
    //   1859: dup
    //   1860: invokespecial 1329	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:<init>	()V
    //   1863: astore_3
    //   1864: aload_3
    //   1865: aload_1
    //   1866: putfield 1330	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:a	Ljava/lang/String;
    //   1869: aload_3
    //   1870: aload_2
    //   1871: putfield 1327	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:b	Ljava/lang/String;
    //   1874: aload_3
    //   1875: iload 6
    //   1877: putfield 1331	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:c	I
    //   1880: aload_0
    //   1881: getfield 252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:downloadBeensList	Ljava/util/ArrayList;
    //   1884: aload_3
    //   1885: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1888: pop
    //   1889: aload_0
    //   1890: getfield 252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:downloadBeensList	Ljava/util/ArrayList;
    //   1893: invokevirtual 480	java/util/ArrayList:size	()I
    //   1896: iconst_1
    //   1897: if_icmpne +12216 -> 14113
    //   1900: aload_0
    //   1901: aload_2
    //   1902: iload 6
    //   1904: iconst_1
    //   1905: aload_1
    //   1906: invokevirtual 1335	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sendMediaIdForUuidRequest	(Ljava/lang/String;IZLjava/lang/String;)V
    //   1909: goto +25 -> 1934
    //   1912: aload_0
    //   1913: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1916: ldc_w 1337
    //   1919: iconst_0
    //   1920: invokestatic 1278	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1923: invokevirtual 1281	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   1926: pop
    //   1927: iconst_1
    //   1928: ireturn
    //   1929: astore_1
    //   1930: aload_1
    //   1931: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   1934: aconst_null
    //   1935: ldc_w 1198
    //   1938: ldc_w 1200
    //   1941: ldc 230
    //   1943: ldc_w 1339
    //   1946: ldc_w 1339
    //   1949: iconst_0
    //   1950: iconst_2
    //   1951: ldc_w 1316
    //   1954: ldc 230
    //   1956: ldc 230
    //   1958: ldc 230
    //   1960: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1963: iconst_1
    //   1964: ireturn
    //   1965: ldc_w 1341
    //   1968: aload 4
    //   1970: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1973: ifeq +341 -> 2314
    //   1976: aload 5
    //   1978: ifnull +334 -> 2312
    //   1981: aload 5
    //   1983: arraylength
    //   1984: ifle +328 -> 2312
    //   1987: new 353	org/json/JSONObject
    //   1990: dup
    //   1991: aload 5
    //   1993: iconst_0
    //   1994: aaload
    //   1995: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1998: astore_2
    //   1999: aload_2
    //   2000: ldc_w 577
    //   2003: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2006: astore_1
    //   2007: aload_2
    //   2008: ldc_w 1266
    //   2011: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2014: astore_3
    //   2015: aload_2
    //   2016: ldc_w 1268
    //   2019: iconst_1
    //   2020: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2023: istore 6
    //   2025: aload_3
    //   2026: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2029: istore 14
    //   2031: iload 14
    //   2033: ifeq +58 -> 2091
    //   2036: new 353	org/json/JSONObject
    //   2039: dup
    //   2040: invokespecial 354	org/json/JSONObject:<init>	()V
    //   2043: astore_2
    //   2044: aload_2
    //   2045: ldc_w 356
    //   2048: iconst_m1
    //   2049: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2052: pop
    //   2053: aload_2
    //   2054: ldc_w 361
    //   2057: ldc_w 1343
    //   2060: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2063: pop
    //   2064: aload_0
    //   2065: aload_1
    //   2066: iconst_1
    //   2067: anewarray 369	java/lang/String
    //   2070: dup
    //   2071: iconst_0
    //   2072: aload_2
    //   2073: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2076: aastore
    //   2077: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2080: goto +196 -> 2276
    //   2083: astore_1
    //   2084: aload_1
    //   2085: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2088: goto +188 -> 2276
    //   2091: aload_0
    //   2092: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2095: ifnonnull +26 -> 2121
    //   2098: aload_0
    //   2099: new 1347	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   2102: dup
    //   2103: aload_0
    //   2104: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   2107: aload_0
    //   2108: getfield 1348	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   2111: aload_0
    //   2112: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2115: invokespecial 1351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   2118: putfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2121: aload_0
    //   2122: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2125: aload_3
    //   2126: invokevirtual 1354	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   2129: astore_2
    //   2130: new 1270	java/io/File
    //   2133: dup
    //   2134: aload_2
    //   2135: invokespecial 1271	java/io/File:<init>	(Ljava/lang/String;)V
    //   2138: astore_3
    //   2139: aload_3
    //   2140: invokevirtual 1274	java/io/File:exists	()Z
    //   2143: ifne +58 -> 2201
    //   2146: new 353	org/json/JSONObject
    //   2149: dup
    //   2150: invokespecial 354	org/json/JSONObject:<init>	()V
    //   2153: astore_2
    //   2154: aload_2
    //   2155: ldc_w 356
    //   2158: iconst_m1
    //   2159: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2162: pop
    //   2163: aload_2
    //   2164: ldc_w 361
    //   2167: ldc_w 1343
    //   2170: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2173: pop
    //   2174: aload_0
    //   2175: aload_1
    //   2176: iconst_1
    //   2177: anewarray 369	java/lang/String
    //   2180: dup
    //   2181: iconst_0
    //   2182: aload_2
    //   2183: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2186: aastore
    //   2187: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2190: goto +86 -> 2276
    //   2193: astore_1
    //   2194: aload_1
    //   2195: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2198: goto +78 -> 2276
    //   2201: aload_3
    //   2202: invokevirtual 1283	java/io/File:length	()J
    //   2205: ldc2_w 1355
    //   2208: lcmp
    //   2209: ifle +58 -> 2267
    //   2212: new 353	org/json/JSONObject
    //   2215: dup
    //   2216: invokespecial 354	org/json/JSONObject:<init>	()V
    //   2219: astore_2
    //   2220: aload_2
    //   2221: ldc_w 356
    //   2224: iconst_m1
    //   2225: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2228: pop
    //   2229: aload_2
    //   2230: ldc_w 361
    //   2233: ldc_w 1358
    //   2236: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2239: pop
    //   2240: goto +8 -> 2248
    //   2243: astore_3
    //   2244: aload_3
    //   2245: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2248: aload_0
    //   2249: aload_1
    //   2250: iconst_1
    //   2251: anewarray 369	java/lang/String
    //   2254: dup
    //   2255: iconst_0
    //   2256: aload_2
    //   2257: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2260: aastore
    //   2261: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2264: goto +12 -> 2276
    //   2267: aload_0
    //   2268: iload 6
    //   2270: aload_2
    //   2271: iconst_0
    //   2272: aload_1
    //   2273: invokevirtual 1312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:startUpload	(ILjava/lang/String;ZLjava/lang/String;)V
    //   2276: aconst_null
    //   2277: ldc_w 1198
    //   2280: ldc_w 1200
    //   2283: ldc 230
    //   2285: ldc_w 1360
    //   2288: ldc_w 1360
    //   2291: iconst_0
    //   2292: iconst_2
    //   2293: ldc_w 1316
    //   2296: ldc 230
    //   2298: ldc 230
    //   2300: ldc 230
    //   2302: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2305: iconst_1
    //   2306: ireturn
    //   2307: astore_1
    //   2308: aload_1
    //   2309: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2312: iconst_1
    //   2313: ireturn
    //   2314: ldc_w 1362
    //   2317: aload 4
    //   2319: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2322: ifeq +165 -> 2487
    //   2325: aload 5
    //   2327: ifnull +158 -> 2485
    //   2330: aload 5
    //   2332: arraylength
    //   2333: ifle +152 -> 2485
    //   2336: new 353	org/json/JSONObject
    //   2339: dup
    //   2340: aload 5
    //   2342: iconst_0
    //   2343: aaload
    //   2344: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2347: astore_2
    //   2348: aload_2
    //   2349: ldc_w 577
    //   2352: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2355: astore_1
    //   2356: aload_2
    //   2357: ldc_w 1324
    //   2360: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2363: astore_3
    //   2364: aload_2
    //   2365: ldc_w 1268
    //   2368: iconst_1
    //   2369: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2372: istore 6
    //   2374: aload_3
    //   2375: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2378: istore 14
    //   2380: iload 14
    //   2382: ifeq +58 -> 2440
    //   2385: new 353	org/json/JSONObject
    //   2388: dup
    //   2389: invokespecial 354	org/json/JSONObject:<init>	()V
    //   2392: astore_2
    //   2393: aload_2
    //   2394: ldc_w 356
    //   2397: iconst_m1
    //   2398: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2401: pop
    //   2402: aload_2
    //   2403: ldc_w 361
    //   2406: ldc_w 1364
    //   2409: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2412: pop
    //   2413: aload_0
    //   2414: aload_1
    //   2415: iconst_1
    //   2416: anewarray 369	java/lang/String
    //   2419: dup
    //   2420: iconst_0
    //   2421: aload_2
    //   2422: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2425: aastore
    //   2426: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2429: goto +20 -> 2449
    //   2432: astore_1
    //   2433: aload_1
    //   2434: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2437: goto +12 -> 2449
    //   2440: aload_0
    //   2441: aload_3
    //   2442: iload 6
    //   2444: iconst_0
    //   2445: aload_1
    //   2446: invokevirtual 1335	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sendMediaIdForUuidRequest	(Ljava/lang/String;IZLjava/lang/String;)V
    //   2449: aconst_null
    //   2450: ldc_w 1198
    //   2453: ldc_w 1200
    //   2456: ldc 230
    //   2458: ldc_w 1366
    //   2461: ldc_w 1366
    //   2464: iconst_0
    //   2465: iconst_2
    //   2466: ldc_w 1316
    //   2469: ldc 230
    //   2471: ldc 230
    //   2473: ldc 230
    //   2475: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2478: iconst_1
    //   2479: ireturn
    //   2480: astore_1
    //   2481: aload_1
    //   2482: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2485: iconst_1
    //   2486: ireturn
    //   2487: ldc_w 1368
    //   2490: aload 4
    //   2492: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2495: ifeq +237 -> 2732
    //   2498: aload 5
    //   2500: ifnull +230 -> 2730
    //   2503: aload 5
    //   2505: arraylength
    //   2506: ifle +224 -> 2730
    //   2509: new 353	org/json/JSONObject
    //   2512: dup
    //   2513: aload 5
    //   2515: iconst_0
    //   2516: aaload
    //   2517: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2520: astore_3
    //   2521: aload_3
    //   2522: ldc_w 577
    //   2525: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2528: astore_1
    //   2529: aload_3
    //   2530: ldc_w 1370
    //   2533: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2536: istore 6
    //   2538: iload 6
    //   2540: bipush 9
    //   2542: if_icmpgt +11573 -> 14115
    //   2545: iload 6
    //   2547: istore 8
    //   2549: iload 6
    //   2551: iconst_1
    //   2552: if_icmpge +6 -> 2558
    //   2555: goto +11560 -> 14115
    //   2558: aload_3
    //   2559: ldc_w 1372
    //   2562: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2565: astore_2
    //   2566: aload_3
    //   2567: ldc_w 1374
    //   2570: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2573: astore_3
    //   2574: aload_3
    //   2575: ifnull +11547 -> 14122
    //   2578: aload_3
    //   2579: invokevirtual 591	org/json/JSONArray:length	()I
    //   2582: iconst_1
    //   2583: if_icmpne +11539 -> 14122
    //   2586: aload_3
    //   2587: iconst_0
    //   2588: invokevirtual 1227	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2591: astore_3
    //   2592: ldc_w 1376
    //   2595: aload_3
    //   2596: invokevirtual 1379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2599: ifeq +9 -> 2608
    //   2602: iconst_1
    //   2603: istore 6
    //   2605: goto +19 -> 2624
    //   2608: ldc_w 1381
    //   2611: aload_3
    //   2612: invokevirtual 1379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2615: ifeq +11507 -> 14122
    //   2618: iconst_2
    //   2619: istore 6
    //   2621: goto +3 -> 2624
    //   2624: iload 9
    //   2626: istore 7
    //   2628: aload_2
    //   2629: ifnull +54 -> 2683
    //   2632: iload 9
    //   2634: istore 7
    //   2636: aload_2
    //   2637: invokevirtual 591	org/json/JSONArray:length	()I
    //   2640: iconst_1
    //   2641: if_icmpne +42 -> 2683
    //   2644: aload_2
    //   2645: iconst_0
    //   2646: invokevirtual 1227	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2649: astore_2
    //   2650: ldc_w 1383
    //   2653: aload_2
    //   2654: invokevirtual 1379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2657: ifeq +9 -> 2666
    //   2660: iconst_1
    //   2661: istore 7
    //   2663: goto +20 -> 2683
    //   2666: iload 9
    //   2668: istore 7
    //   2670: ldc_w 1385
    //   2673: aload_2
    //   2674: invokevirtual 1379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2677: ifeq +6 -> 2683
    //   2680: iconst_2
    //   2681: istore 7
    //   2683: aload_0
    //   2684: iload 6
    //   2686: iload 7
    //   2688: aload_1
    //   2689: iload 8
    //   2691: invokevirtual 1389	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showPAactionSheet	(IILjava/lang/String;I)V
    //   2694: aconst_null
    //   2695: ldc_w 1198
    //   2698: ldc_w 1200
    //   2701: ldc 230
    //   2703: ldc_w 1391
    //   2706: ldc_w 1391
    //   2709: iconst_0
    //   2710: iconst_2
    //   2711: ldc_w 1316
    //   2714: ldc 230
    //   2716: ldc 230
    //   2718: ldc 230
    //   2720: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2723: iconst_1
    //   2724: ireturn
    //   2725: astore_1
    //   2726: aload_1
    //   2727: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2730: iconst_1
    //   2731: ireturn
    //   2732: ldc_w 1393
    //   2735: aload 4
    //   2737: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2740: ifeq +118 -> 2858
    //   2743: aload 5
    //   2745: ifnull +111 -> 2856
    //   2748: aload 5
    //   2750: arraylength
    //   2751: ifle +105 -> 2856
    //   2754: new 353	org/json/JSONObject
    //   2757: dup
    //   2758: aload 5
    //   2760: iconst_0
    //   2761: aaload
    //   2762: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2765: ldc_w 577
    //   2768: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2771: putstatic 1395	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStartCallback	Ljava/lang/String;
    //   2774: getstatic 1395	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStartCallback	Ljava/lang/String;
    //   2777: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2780: ifne +40 -> 2820
    //   2783: aload_0
    //   2784: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2787: ifnonnull +26 -> 2813
    //   2790: aload_0
    //   2791: new 1347	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   2794: dup
    //   2795: aload_0
    //   2796: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   2799: aload_0
    //   2800: getfield 1348	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   2803: aload_0
    //   2804: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2807: invokespecial 1351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   2810: putfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2813: aload_0
    //   2814: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2817: invokevirtual 1397	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:startRecord	()V
    //   2820: aconst_null
    //   2821: ldc_w 1198
    //   2824: ldc_w 1200
    //   2827: ldc 230
    //   2829: ldc_w 1399
    //   2832: ldc_w 1399
    //   2835: iconst_0
    //   2836: iconst_2
    //   2837: ldc_w 1316
    //   2840: ldc 230
    //   2842: ldc 230
    //   2844: ldc 230
    //   2846: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2849: iconst_1
    //   2850: ireturn
    //   2851: astore_1
    //   2852: aload_1
    //   2853: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2856: iconst_1
    //   2857: ireturn
    //   2858: ldc_w 1401
    //   2861: aload 4
    //   2863: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2866: ifeq +153 -> 3019
    //   2869: aload 5
    //   2871: ifnull +146 -> 3017
    //   2874: aload 5
    //   2876: arraylength
    //   2877: ifle +140 -> 3017
    //   2880: new 353	org/json/JSONObject
    //   2883: dup
    //   2884: aload 5
    //   2886: iconst_0
    //   2887: aaload
    //   2888: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2891: ldc_w 577
    //   2894: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2897: putstatic 1403	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStopCallback	Ljava/lang/String;
    //   2900: aload_0
    //   2901: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2904: ifnull +23 -> 2927
    //   2907: aload_0
    //   2908: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2911: invokevirtual 1406	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:isRecorderRecording	()Z
    //   2914: ifeq +13 -> 2927
    //   2917: aload_0
    //   2918: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2921: invokevirtual 1408	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:stopRecord	()V
    //   2924: goto +57 -> 2981
    //   2927: new 353	org/json/JSONObject
    //   2930: dup
    //   2931: invokespecial 354	org/json/JSONObject:<init>	()V
    //   2934: astore_1
    //   2935: aload_1
    //   2936: ldc_w 356
    //   2939: iconst_m1
    //   2940: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2943: pop
    //   2944: aload_1
    //   2945: ldc_w 361
    //   2948: ldc_w 1410
    //   2951: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2954: pop
    //   2955: aload_0
    //   2956: getstatic 1403	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStopCallback	Ljava/lang/String;
    //   2959: iconst_1
    //   2960: anewarray 369	java/lang/String
    //   2963: dup
    //   2964: iconst_0
    //   2965: aload_1
    //   2966: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2969: aastore
    //   2970: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2973: goto +8 -> 2981
    //   2976: astore_1
    //   2977: aload_1
    //   2978: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   2981: aconst_null
    //   2982: ldc_w 1198
    //   2985: ldc_w 1200
    //   2988: ldc 230
    //   2990: ldc_w 1412
    //   2993: ldc_w 1412
    //   2996: iconst_0
    //   2997: iconst_2
    //   2998: ldc_w 1316
    //   3001: ldc 230
    //   3003: ldc 230
    //   3005: ldc 230
    //   3007: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3010: iconst_1
    //   3011: ireturn
    //   3012: astore_1
    //   3013: aload_1
    //   3014: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3017: iconst_1
    //   3018: ireturn
    //   3019: ldc_w 1414
    //   3022: aload 4
    //   3024: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3027: ifeq +378 -> 3405
    //   3030: aload 5
    //   3032: ifnull +371 -> 3403
    //   3035: aload 5
    //   3037: arraylength
    //   3038: ifle +365 -> 3403
    //   3041: new 353	org/json/JSONObject
    //   3044: dup
    //   3045: aload 5
    //   3047: iconst_0
    //   3048: aaload
    //   3049: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3052: astore_1
    //   3053: aload_1
    //   3054: ldc_w 577
    //   3057: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3060: putstatic 1416	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3063: aload_1
    //   3064: ldc_w 1266
    //   3067: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3070: astore_1
    //   3071: getstatic 1416	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3074: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3077: ifne +290 -> 3367
    //   3080: aload_1
    //   3081: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3084: ifne +229 -> 3313
    //   3087: aload_0
    //   3088: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3091: ifnull +15 -> 3106
    //   3094: aload_0
    //   3095: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3098: invokevirtual 1419	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:isPlaying	()Z
    //   3101: ifeq +5 -> 3106
    //   3104: iconst_1
    //   3105: ireturn
    //   3106: aload_0
    //   3107: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3110: ifnonnull +26 -> 3136
    //   3113: aload_0
    //   3114: new 1347	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   3117: dup
    //   3118: aload_0
    //   3119: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3122: aload_0
    //   3123: getfield 1348	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   3126: aload_0
    //   3127: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3130: invokespecial 1351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   3133: putfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3136: aload_0
    //   3137: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3140: aload_1
    //   3141: invokevirtual 1354	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   3144: astore_2
    //   3145: new 353	org/json/JSONObject
    //   3148: dup
    //   3149: invokespecial 354	org/json/JSONObject:<init>	()V
    //   3152: astore_1
    //   3153: new 1270	java/io/File
    //   3156: dup
    //   3157: aload_2
    //   3158: invokespecial 1271	java/io/File:<init>	(Ljava/lang/String;)V
    //   3161: invokevirtual 1274	java/io/File:exists	()Z
    //   3164: ifeq +71 -> 3235
    //   3167: aload_0
    //   3168: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3171: aload_2
    //   3172: invokevirtual 1421	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:playVoice	(Ljava/lang/String;)V
    //   3175: aload_1
    //   3176: ldc_w 356
    //   3179: iconst_0
    //   3180: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3183: pop
    //   3184: aload_1
    //   3185: ldc_w 361
    //   3188: ldc_w 1423
    //   3191: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3194: pop
    //   3195: goto +8 -> 3203
    //   3198: astore_2
    //   3199: aload_2
    //   3200: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3203: aconst_null
    //   3204: ldc_w 1198
    //   3207: ldc_w 1200
    //   3210: ldc 230
    //   3212: ldc_w 1425
    //   3215: ldc_w 1425
    //   3218: iconst_0
    //   3219: iconst_0
    //   3220: ldc_w 1316
    //   3223: ldc 230
    //   3225: ldc 230
    //   3227: ldc 230
    //   3229: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3232: goto +60 -> 3292
    //   3235: aload_1
    //   3236: ldc_w 356
    //   3239: iconst_m1
    //   3240: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3243: pop
    //   3244: aload_1
    //   3245: ldc_w 361
    //   3248: ldc_w 1343
    //   3251: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3254: pop
    //   3255: goto +8 -> 3263
    //   3258: astore_2
    //   3259: aload_2
    //   3260: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3263: aconst_null
    //   3264: ldc_w 1198
    //   3267: ldc_w 1200
    //   3270: ldc 230
    //   3272: ldc_w 1425
    //   3275: ldc_w 1425
    //   3278: iconst_0
    //   3279: iconst_m1
    //   3280: ldc_w 1316
    //   3283: ldc 230
    //   3285: ldc 230
    //   3287: ldc 230
    //   3289: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3292: aload_0
    //   3293: getstatic 1416	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3296: iconst_1
    //   3297: anewarray 369	java/lang/String
    //   3300: dup
    //   3301: iconst_0
    //   3302: aload_1
    //   3303: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3306: aastore
    //   3307: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3310: goto +57 -> 3367
    //   3313: new 353	org/json/JSONObject
    //   3316: dup
    //   3317: invokespecial 354	org/json/JSONObject:<init>	()V
    //   3320: astore_1
    //   3321: aload_1
    //   3322: ldc_w 356
    //   3325: iconst_m1
    //   3326: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3329: pop
    //   3330: aload_1
    //   3331: ldc_w 361
    //   3334: ldc_w 1427
    //   3337: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3340: pop
    //   3341: aload_0
    //   3342: getstatic 1416	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3345: iconst_1
    //   3346: anewarray 369	java/lang/String
    //   3349: dup
    //   3350: iconst_0
    //   3351: aload_1
    //   3352: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3355: aastore
    //   3356: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3359: goto +8 -> 3367
    //   3362: astore_1
    //   3363: aload_1
    //   3364: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3367: aconst_null
    //   3368: ldc_w 1198
    //   3371: ldc_w 1200
    //   3374: ldc 230
    //   3376: ldc_w 1425
    //   3379: ldc_w 1425
    //   3382: iconst_0
    //   3383: iconst_2
    //   3384: ldc_w 1316
    //   3387: ldc 230
    //   3389: ldc 230
    //   3391: ldc 230
    //   3393: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3396: iconst_1
    //   3397: ireturn
    //   3398: astore_1
    //   3399: aload_1
    //   3400: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3403: iconst_1
    //   3404: ireturn
    //   3405: ldc_w 1429
    //   3408: aload 4
    //   3410: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3413: ifeq +224 -> 3637
    //   3416: aload 5
    //   3418: ifnull +217 -> 3635
    //   3421: aload 5
    //   3423: arraylength
    //   3424: ifle +211 -> 3635
    //   3427: new 353	org/json/JSONObject
    //   3430: dup
    //   3431: aload 5
    //   3433: iconst_0
    //   3434: aaload
    //   3435: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3438: astore_2
    //   3439: aload_2
    //   3440: ldc_w 577
    //   3443: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3446: astore_1
    //   3447: aload_2
    //   3448: ldc_w 1266
    //   3451: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3454: astore_2
    //   3455: aload_2
    //   3456: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3459: ifne +140 -> 3599
    //   3462: aload_0
    //   3463: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3466: ifnonnull +26 -> 3492
    //   3469: aload_0
    //   3470: new 1347	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   3473: dup
    //   3474: aload_0
    //   3475: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3478: aload_0
    //   3479: getfield 1348	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   3482: aload_0
    //   3483: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3486: invokespecial 1351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   3489: putfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3492: aload_0
    //   3493: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3496: aload_2
    //   3497: invokevirtual 1354	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   3500: pop
    //   3501: aload_0
    //   3502: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3505: invokevirtual 1419	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:isPlaying	()Z
    //   3508: ifeq +91 -> 3599
    //   3511: aload_0
    //   3512: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3515: invokevirtual 1431	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:pauseVoice	()V
    //   3518: new 353	org/json/JSONObject
    //   3521: dup
    //   3522: invokespecial 354	org/json/JSONObject:<init>	()V
    //   3525: astore_2
    //   3526: aload_2
    //   3527: ldc_w 356
    //   3530: iconst_0
    //   3531: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3534: pop
    //   3535: aload_2
    //   3536: ldc_w 361
    //   3539: ldc_w 1423
    //   3542: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3545: pop
    //   3546: aload_0
    //   3547: aload_1
    //   3548: iconst_1
    //   3549: anewarray 369	java/lang/String
    //   3552: dup
    //   3553: iconst_0
    //   3554: aload_2
    //   3555: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3558: aastore
    //   3559: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3562: goto +8 -> 3570
    //   3565: astore_1
    //   3566: aload_1
    //   3567: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3570: aconst_null
    //   3571: ldc_w 1198
    //   3574: ldc_w 1200
    //   3577: ldc 230
    //   3579: ldc_w 1433
    //   3582: ldc_w 1433
    //   3585: iconst_0
    //   3586: iconst_0
    //   3587: ldc_w 1316
    //   3590: ldc 230
    //   3592: ldc 230
    //   3594: ldc 230
    //   3596: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3599: aconst_null
    //   3600: ldc_w 1198
    //   3603: ldc_w 1200
    //   3606: ldc 230
    //   3608: ldc_w 1433
    //   3611: ldc_w 1433
    //   3614: iconst_0
    //   3615: iconst_2
    //   3616: ldc_w 1316
    //   3619: ldc 230
    //   3621: ldc 230
    //   3623: ldc 230
    //   3625: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3628: iconst_1
    //   3629: ireturn
    //   3630: astore_1
    //   3631: aload_1
    //   3632: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3635: iconst_1
    //   3636: ireturn
    //   3637: ldc_w 1435
    //   3640: aload 4
    //   3642: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3645: ifeq +164 -> 3809
    //   3648: aload 5
    //   3650: ifnull +157 -> 3807
    //   3653: aload 5
    //   3655: arraylength
    //   3656: ifle +151 -> 3807
    //   3659: new 353	org/json/JSONObject
    //   3662: dup
    //   3663: aload 5
    //   3665: iconst_0
    //   3666: aaload
    //   3667: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3670: astore_1
    //   3671: aload_1
    //   3672: ldc_w 577
    //   3675: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3678: putstatic 1437	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playEndCallback	Ljava/lang/String;
    //   3681: aload_1
    //   3682: ldc_w 1266
    //   3685: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3688: astore_1
    //   3689: aload_1
    //   3690: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3693: ifne +78 -> 3771
    //   3696: aload_0
    //   3697: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3700: ifnonnull +26 -> 3726
    //   3703: aload_0
    //   3704: new 1347	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   3707: dup
    //   3708: aload_0
    //   3709: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3712: aload_0
    //   3713: getfield 1348	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   3716: aload_0
    //   3717: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3720: invokespecial 1351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   3723: putfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3726: aload_0
    //   3727: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3730: aload_1
    //   3731: invokevirtual 1354	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   3734: pop
    //   3735: aload_0
    //   3736: getfield 1345	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3739: invokevirtual 1439	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:stopVoice	()V
    //   3742: aconst_null
    //   3743: ldc_w 1198
    //   3746: ldc_w 1200
    //   3749: ldc 230
    //   3751: ldc_w 1441
    //   3754: ldc_w 1441
    //   3757: iconst_0
    //   3758: iconst_0
    //   3759: ldc_w 1316
    //   3762: ldc 230
    //   3764: ldc 230
    //   3766: ldc 230
    //   3768: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3771: aconst_null
    //   3772: ldc_w 1198
    //   3775: ldc_w 1200
    //   3778: ldc 230
    //   3780: ldc_w 1441
    //   3783: ldc_w 1441
    //   3786: iconst_0
    //   3787: iconst_2
    //   3788: ldc_w 1316
    //   3791: ldc 230
    //   3793: ldc 230
    //   3795: ldc 230
    //   3797: invokestatic 1207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3800: iconst_1
    //   3801: ireturn
    //   3802: astore_1
    //   3803: aload_1
    //   3804: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3807: iconst_1
    //   3808: ireturn
    //   3809: ldc_w 1443
    //   3812: aload 4
    //   3814: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3817: ifeq +43 -> 3860
    //   3820: aload 5
    //   3822: ifnull +36 -> 3858
    //   3825: aload 5
    //   3827: arraylength
    //   3828: ifle +30 -> 3858
    //   3831: new 353	org/json/JSONObject
    //   3834: dup
    //   3835: aload 5
    //   3837: iconst_0
    //   3838: aaload
    //   3839: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3842: ldc_w 577
    //   3845: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3848: putstatic 1445	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:voiceRecorderEndCallback	Ljava/lang/String;
    //   3851: iconst_1
    //   3852: ireturn
    //   3853: astore_1
    //   3854: aload_1
    //   3855: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3858: iconst_1
    //   3859: ireturn
    //   3860: ldc_w 1447
    //   3863: aload 4
    //   3865: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3868: ifeq +43 -> 3911
    //   3871: aload 5
    //   3873: ifnull +36 -> 3909
    //   3876: aload 5
    //   3878: arraylength
    //   3879: ifle +30 -> 3909
    //   3882: new 353	org/json/JSONObject
    //   3885: dup
    //   3886: aload 5
    //   3888: iconst_0
    //   3889: aaload
    //   3890: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3893: ldc_w 577
    //   3896: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3899: putstatic 1449	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:voicePlayEndCallback	Ljava/lang/String;
    //   3902: iconst_1
    //   3903: ireturn
    //   3904: astore_1
    //   3905: aload_1
    //   3906: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   3909: iconst_1
    //   3910: ireturn
    //   3911: ldc_w 1451
    //   3914: aload 4
    //   3916: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3919: ifeq +154 -> 4073
    //   3922: aload 5
    //   3924: ifnull +147 -> 4071
    //   3927: aload 5
    //   3929: arraylength
    //   3930: ifle +141 -> 4071
    //   3933: new 353	org/json/JSONObject
    //   3936: dup
    //   3937: aload 5
    //   3939: iconst_0
    //   3940: aaload
    //   3941: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3944: astore_1
    //   3945: aload_1
    //   3946: ldc_w 577
    //   3949: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3952: putstatic 1453	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndUploadAvatarCallback	Ljava/lang/String;
    //   3955: aload_1
    //   3956: ldc_w 1455
    //   3959: iconst_1
    //   3960: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3963: istore 10
    //   3965: aload_1
    //   3966: ldc_w 1457
    //   3969: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3972: ifeq +10156 -> 14128
    //   3975: aload_1
    //   3976: ldc_w 1457
    //   3979: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3982: istore 7
    //   3984: aload_0
    //   3985: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3988: iload 7
    //   3990: iconst_2
    //   3991: idiv
    //   3992: i2f
    //   3993: invokestatic 1465	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   3996: istore 6
    //   3998: goto +3 -> 4001
    //   4001: aload_1
    //   4002: ldc_w 1467
    //   4005: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4008: ifeq +10133 -> 14141
    //   4011: aload_1
    //   4012: ldc_w 1467
    //   4015: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4018: istore 8
    //   4020: aload_0
    //   4021: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   4024: iload 8
    //   4026: iconst_2
    //   4027: idiv
    //   4028: i2f
    //   4029: invokestatic 1465	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   4032: istore 9
    //   4034: goto +3 -> 4037
    //   4037: aload_0
    //   4038: iconst_1
    //   4039: iload 10
    //   4041: bipush 118
    //   4043: iload 6
    //   4045: iload 9
    //   4047: iload 7
    //   4049: iload 8
    //   4051: invokevirtual 1471	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectPhotoFromGallery	(IIBIIII)V
    //   4054: iconst_1
    //   4055: ireturn
    //   4056: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4059: ifeq +12 -> 4071
    //   4062: ldc 45
    //   4064: iconst_2
    //   4065: ldc_w 1473
    //   4068: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4071: iconst_1
    //   4072: ireturn
    //   4073: ldc_w 1475
    //   4076: aload 4
    //   4078: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4081: ifeq +191 -> 4272
    //   4084: iload 15
    //   4086: istore 14
    //   4088: aload 5
    //   4090: ifnull +132 -> 4222
    //   4093: iload 15
    //   4095: istore 14
    //   4097: aload 5
    //   4099: arraylength
    //   4100: ifle +122 -> 4222
    //   4103: invokestatic 1481	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4106: invokevirtual 1484	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   4109: invokevirtual 1488	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   4112: astore_1
    //   4113: new 353	org/json/JSONObject
    //   4116: dup
    //   4117: aload 5
    //   4119: iconst_0
    //   4120: aaload
    //   4121: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4124: astore_2
    //   4125: aload_2
    //   4126: ldc_w 577
    //   4129: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4132: putstatic 1490	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndTopicPicCallback	Ljava/lang/String;
    //   4135: aload_2
    //   4136: ldc_w 1455
    //   4139: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4142: istore 10
    //   4144: aload_1
    //   4145: getfield 1495	android/util/DisplayMetrics:widthPixels	I
    //   4148: ldc2_w 1496
    //   4151: invokestatic 1503	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4154: istore 6
    //   4156: aload_1
    //   4157: getfield 1495	android/util/DisplayMetrics:widthPixels	I
    //   4160: ldc2_w 1504
    //   4163: invokestatic 1503	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4166: istore 7
    //   4168: iload 10
    //   4170: iconst_1
    //   4171: if_icmpne +9983 -> 14154
    //   4174: aload_1
    //   4175: getfield 1495	android/util/DisplayMetrics:widthPixels	I
    //   4178: ldc2_w 1496
    //   4181: invokestatic 1503	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4184: istore 6
    //   4186: iload 6
    //   4188: istore 7
    //   4190: sipush 160
    //   4193: istore 8
    //   4195: sipush 160
    //   4198: istore 9
    //   4200: goto +9964 -> 14164
    //   4203: aload_0
    //   4204: iconst_2
    //   4205: iconst_0
    //   4206: bipush 121
    //   4208: iload 6
    //   4210: iload 7
    //   4212: iload 8
    //   4214: iload 9
    //   4216: invokevirtual 1471	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectPhotoFromGallery	(IIBIIII)V
    //   4219: iconst_1
    //   4220: istore 14
    //   4222: new 537	java/lang/StringBuilder
    //   4225: dup
    //   4226: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   4229: astore_1
    //   4230: aload_1
    //   4231: ldc_w 1507
    //   4234: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4237: pop
    //   4238: aload_1
    //   4239: aload 5
    //   4241: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4244: pop
    //   4245: aload_1
    //   4246: ldc_w 1509
    //   4249: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4252: pop
    //   4253: aload_1
    //   4254: iload 14
    //   4256: invokevirtual 1512	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4259: pop
    //   4260: ldc 45
    //   4262: iconst_1
    //   4263: aload_1
    //   4264: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4267: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4270: iconst_1
    //   4271: ireturn
    //   4272: ldc_w 1514
    //   4275: aload 4
    //   4277: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4280: ifeq +202 -> 4482
    //   4283: aload_0
    //   4284: getfield 228	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:refuseConfig	Z
    //   4287: ifeq +5 -> 4292
    //   4290: iconst_1
    //   4291: ireturn
    //   4292: aload 5
    //   4294: ifnull +9801 -> 14095
    //   4297: aload 5
    //   4299: arraylength
    //   4300: ifle +9795 -> 14095
    //   4303: new 353	org/json/JSONObject
    //   4306: dup
    //   4307: aload 5
    //   4309: iconst_0
    //   4310: aaload
    //   4311: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4314: astore_2
    //   4315: aload_2
    //   4316: ldc_w 1516
    //   4319: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4322: putstatic 1518	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:appIdStr	Ljava/lang/String;
    //   4325: aload_2
    //   4326: ldc_w 1520
    //   4329: ldc_w 1522
    //   4332: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4335: pop
    //   4336: aload_0
    //   4337: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4340: invokevirtual 1525	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   4343: astore_1
    //   4344: aload_1
    //   4345: ifnull +9838 -> 14183
    //   4348: aload_1
    //   4349: invokevirtual 1530	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   4352: astore_1
    //   4353: goto +3 -> 4356
    //   4356: aload_2
    //   4357: ldc_w 1088
    //   4360: aload_1
    //   4361: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4364: pop
    //   4365: aload_2
    //   4366: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4369: astore_3
    //   4370: aload_0
    //   4371: aload_2
    //   4372: ldc_w 577
    //   4375: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4378: putfield 1532	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:authCallback	Ljava/lang/String;
    //   4381: aload_2
    //   4382: ldc_w 1534
    //   4385: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   4388: astore_2
    //   4389: new 247	java/util/ArrayList
    //   4392: dup
    //   4393: invokespecial 248	java/util/ArrayList:<init>	()V
    //   4396: astore 4
    //   4398: aload_2
    //   4399: ifnull +41 -> 4440
    //   4402: aload 4
    //   4404: invokevirtual 950	java/util/ArrayList:clear	()V
    //   4407: iconst_0
    //   4408: istore 6
    //   4410: iload 6
    //   4412: aload_2
    //   4413: invokevirtual 591	org/json/JSONArray:length	()I
    //   4416: if_icmpge +24 -> 4440
    //   4419: aload 4
    //   4421: aload_2
    //   4422: iload 6
    //   4424: invokevirtual 1227	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   4427: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4430: pop
    //   4431: iload 6
    //   4433: iconst_1
    //   4434: iadd
    //   4435: istore 6
    //   4437: goto -27 -> 4410
    //   4440: getstatic 193	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:authorizedLists	Ljava/util/Map;
    //   4443: aload_1
    //   4444: invokeinterface 1022 2 0
    //   4449: pop
    //   4450: getstatic 195	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:needAuthorizedLists	Ljava/util/Map;
    //   4453: aload_1
    //   4454: aload 4
    //   4456: invokeinterface 1535 3 0
    //   4461: pop
    //   4462: aload_1
    //   4463: ifnull +9 -> 4472
    //   4466: aload_0
    //   4467: aload_1
    //   4468: aload_3
    //   4469: invokevirtual 1538	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sendAuthRequest	(Ljava/lang/String;Ljava/lang/String;)V
    //   4472: iconst_1
    //   4473: ireturn
    //   4474: astore_1
    //   4475: aload_1
    //   4476: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   4479: goto +9616 -> 14095
    //   4482: ldc_w 1540
    //   4485: aload 4
    //   4487: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4490: ifeq +120 -> 4610
    //   4493: new 353	org/json/JSONObject
    //   4496: dup
    //   4497: aload 5
    //   4499: iconst_0
    //   4500: aaload
    //   4501: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4504: astore_2
    //   4505: aload_2
    //   4506: ldc_w 577
    //   4509: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4512: astore_1
    //   4513: aload_2
    //   4514: ldc_w 1542
    //   4517: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4520: istore 6
    //   4522: aload_0
    //   4523: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4526: invokevirtual 1011	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:f	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   4529: checkcast 1544	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   4532: astore_2
    //   4533: aload_2
    //   4534: ifnull +32 -> 4566
    //   4537: aload_2
    //   4538: invokevirtual 1548	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyleHandler	()Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4541: ifnull +25 -> 4566
    //   4544: aload_2
    //   4545: invokevirtual 1548	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyleHandler	()Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4548: getfield 1554	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:g	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   4551: ifnull +15 -> 4566
    //   4554: aload_2
    //   4555: invokevirtual 1548	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyleHandler	()Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4558: getfield 1554	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:g	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   4561: iload 6
    //   4563: invokevirtual 1558	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:a	(I)V
    //   4566: new 353	org/json/JSONObject
    //   4569: dup
    //   4570: invokespecial 354	org/json/JSONObject:<init>	()V
    //   4573: astore_2
    //   4574: aload_2
    //   4575: ldc_w 356
    //   4578: iconst_0
    //   4579: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4582: pop
    //   4583: aload_0
    //   4584: aload_1
    //   4585: iconst_1
    //   4586: anewarray 369	java/lang/String
    //   4589: dup
    //   4590: iconst_0
    //   4591: aload_2
    //   4592: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4595: aastore
    //   4596: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4599: goto +9496 -> 14095
    //   4602: astore_1
    //   4603: aload_1
    //   4604: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   4607: goto +9488 -> 14095
    //   4610: ldc_w 1560
    //   4613: aload 4
    //   4615: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4618: ifeq +377 -> 4995
    //   4621: aload 5
    //   4623: ifnull +370 -> 4993
    //   4626: aload 5
    //   4628: arraylength
    //   4629: ifle +364 -> 4993
    //   4632: new 353	org/json/JSONObject
    //   4635: dup
    //   4636: aload 5
    //   4638: iconst_0
    //   4639: aaload
    //   4640: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4643: astore_2
    //   4644: aload_2
    //   4645: ldc_w 577
    //   4648: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4651: astore_1
    //   4652: aload_2
    //   4653: ldc_w 1088
    //   4656: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4659: astore_3
    //   4660: aload_1
    //   4661: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4664: ifne +329 -> 4993
    //   4667: aload_3
    //   4668: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4671: ifne +322 -> 4993
    //   4674: new 353	org/json/JSONObject
    //   4677: dup
    //   4678: invokespecial 354	org/json/JSONObject:<init>	()V
    //   4681: astore_2
    //   4682: aload_2
    //   4683: ldc_w 356
    //   4686: iconst_0
    //   4687: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4690: pop
    //   4691: aload_2
    //   4692: ldc_w 361
    //   4695: ldc_w 1194
    //   4698: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4701: pop
    //   4702: aload_3
    //   4703: invokestatic 1564	com/tencent/biz/pubaccount/util/PreloadManager:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4706: astore_3
    //   4707: aload_3
    //   4708: ifnull +9480 -> 14188
    //   4711: new 1270	java/io/File
    //   4714: dup
    //   4715: getstatic 1569	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   4718: aload_3
    //   4719: invokespecial 1571	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   4722: invokevirtual 1274	java/io/File:exists	()Z
    //   4725: ifeq +9463 -> 14188
    //   4728: iconst_1
    //   4729: istore 14
    //   4731: goto +3 -> 4734
    //   4734: aload_2
    //   4735: ldc_w 1573
    //   4738: iload 14
    //   4740: invokevirtual 1576	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4743: pop
    //   4744: invokestatic 1580	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4747: invokevirtual 1583	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   4750: astore_3
    //   4751: aload_3
    //   4752: ifnull +241 -> 4993
    //   4755: aload_3
    //   4756: ldc_w 1585
    //   4759: invokevirtual 1591	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   4762: checkcast 1593	com/tencent/common/app/AppInterface
    //   4765: astore_3
    //   4766: aload_3
    //   4767: ifnull +226 -> 4993
    //   4770: invokestatic 1481	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4773: astore 4
    //   4775: new 537	java/lang/StringBuilder
    //   4778: dup
    //   4779: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   4782: astore 5
    //   4784: aload 5
    //   4786: ldc_w 1595
    //   4789: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4792: pop
    //   4793: aload 5
    //   4795: aload_3
    //   4796: invokevirtual 1598	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4799: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4802: pop
    //   4803: aload 4
    //   4805: aload 5
    //   4807: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4810: iconst_4
    //   4811: invokevirtual 1602	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   4814: astore_3
    //   4815: aload_3
    //   4816: ifnull +177 -> 4993
    //   4819: aload_3
    //   4820: ldc_w 1604
    //   4823: iconst_0
    //   4824: invokeinterface 1609 3 0
    //   4829: istore 14
    //   4831: aload_3
    //   4832: ldc_w 1611
    //   4835: iconst_0
    //   4836: invokeinterface 1609 3 0
    //   4841: istore 15
    //   4843: aload_3
    //   4844: ldc_w 1613
    //   4847: iconst_0
    //   4848: invokeinterface 1609 3 0
    //   4853: istore 16
    //   4855: aload_3
    //   4856: ldc_w 1615
    //   4859: iconst_0
    //   4860: invokeinterface 1609 3 0
    //   4865: istore 17
    //   4867: aload_3
    //   4868: ldc_w 1617
    //   4871: iconst_0
    //   4872: invokeinterface 1609 3 0
    //   4877: istore 18
    //   4879: aload_2
    //   4880: ldc_w 1619
    //   4883: iload 14
    //   4885: invokevirtual 1576	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4888: pop
    //   4889: aload_2
    //   4890: ldc_w 1621
    //   4893: iload 15
    //   4895: invokevirtual 1576	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4898: pop
    //   4899: aload_2
    //   4900: ldc_w 1623
    //   4903: iload 16
    //   4905: invokevirtual 1576	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4908: pop
    //   4909: aload_2
    //   4910: ldc_w 1625
    //   4913: iload 17
    //   4915: invokevirtual 1576	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4918: pop
    //   4919: aload_2
    //   4920: ldc_w 1627
    //   4923: iload 18
    //   4925: invokevirtual 1576	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4928: pop
    //   4929: aload_0
    //   4930: aload_1
    //   4931: iconst_1
    //   4932: anewarray 369	java/lang/String
    //   4935: dup
    //   4936: iconst_0
    //   4937: aload_2
    //   4938: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4941: aastore
    //   4942: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4945: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4948: ifeq +45 -> 4993
    //   4951: new 537	java/lang/StringBuilder
    //   4954: dup
    //   4955: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   4958: astore_1
    //   4959: aload_1
    //   4960: ldc_w 1560
    //   4963: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4966: pop
    //   4967: aload_1
    //   4968: aload_2
    //   4969: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4972: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4975: pop
    //   4976: ldc 45
    //   4978: iconst_2
    //   4979: aload_1
    //   4980: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4983: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4986: iconst_1
    //   4987: ireturn
    //   4988: astore_1
    //   4989: aload_1
    //   4990: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   4993: iconst_1
    //   4994: ireturn
    //   4995: ldc_w 1629
    //   4998: aload 4
    //   5000: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5003: ifeq +80 -> 5083
    //   5006: aload_0
    //   5007: iconst_4
    //   5008: invokespecial 1036	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5011: checkcast 1038	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler
    //   5014: astore_1
    //   5015: aload_1
    //   5016: ifnull +50 -> 5066
    //   5019: aload_0
    //   5020: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5023: invokevirtual 1011	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:f	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   5026: astore_2
    //   5027: aload_2
    //   5028: ifnull +38 -> 5066
    //   5031: aload_2
    //   5032: invokeinterface 1634 1 0
    //   5037: aload_1
    //   5038: getfield 1638	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:h	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5041: ifnull +25 -> 5066
    //   5044: aload_1
    //   5045: getfield 1638	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:h	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5048: getfield 1643	com/tencent/mobileqq/utils/ShareActionSheetBuilder:f	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5051: ifnull +15 -> 5066
    //   5054: aload_1
    //   5055: getfield 1638	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:h	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5058: getfield 1643	com/tencent/mobileqq/utils/ShareActionSheetBuilder:f	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5061: bipush 8
    //   5063: invokevirtual 1648	com/tencent/biz/widgets/ElasticHorScrView:setVisibility	(I)V
    //   5066: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5069: ifeq +12 -> 5081
    //   5072: ldc 45
    //   5074: iconst_2
    //   5075: ldc_w 1629
    //   5078: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5081: iconst_1
    //   5082: ireturn
    //   5083: ldc_w 1650
    //   5086: aload 4
    //   5088: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5091: ifeq +146 -> 5237
    //   5094: new 353	org/json/JSONObject
    //   5097: dup
    //   5098: invokespecial 354	org/json/JSONObject:<init>	()V
    //   5101: astore_1
    //   5102: ldc_w 1652
    //   5105: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5108: checkcast 1652	com/tencent/mobileqq/kandian/biz/biu/api/IBiuBehaviour
    //   5111: invokeinterface 1655 1 0
    //   5116: astore_2
    //   5117: ldc_w 1652
    //   5120: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5123: checkcast 1652	com/tencent/mobileqq/kandian/biz/biu/api/IBiuBehaviour
    //   5126: invokeinterface 1658 1 0
    //   5131: astore_3
    //   5132: aload_1
    //   5133: ldc_w 356
    //   5136: iconst_0
    //   5137: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   5140: pop
    //   5141: aload_1
    //   5142: ldc_w 1660
    //   5145: aload_2
    //   5146: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5149: pop
    //   5150: aload_1
    //   5151: ldc_w 1662
    //   5154: aload_3
    //   5155: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5158: pop
    //   5159: aload 5
    //   5161: ifnull +52 -> 5213
    //   5164: aload 5
    //   5166: arraylength
    //   5167: ifle +46 -> 5213
    //   5170: new 353	org/json/JSONObject
    //   5173: dup
    //   5174: aload 5
    //   5176: iconst_0
    //   5177: aaload
    //   5178: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5181: ldc_w 577
    //   5184: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5187: astore_2
    //   5188: aload_2
    //   5189: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5192: ifne +43 -> 5235
    //   5195: aload_0
    //   5196: aload_2
    //   5197: iconst_1
    //   5198: anewarray 369	java/lang/String
    //   5201: dup
    //   5202: iconst_0
    //   5203: aload_1
    //   5204: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5207: aastore
    //   5208: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5211: iconst_1
    //   5212: ireturn
    //   5213: ldc 45
    //   5215: iconst_1
    //   5216: ldc_w 1664
    //   5219: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5222: iconst_1
    //   5223: ireturn
    //   5224: astore_1
    //   5225: ldc 45
    //   5227: iconst_1
    //   5228: ldc_w 1666
    //   5231: aload_1
    //   5232: invokestatic 1669	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5235: iconst_1
    //   5236: ireturn
    //   5237: ldc_w 1671
    //   5240: aload 4
    //   5242: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5245: ifeq +158 -> 5403
    //   5248: aload 5
    //   5250: ifnull +151 -> 5401
    //   5253: aload 5
    //   5255: arraylength
    //   5256: ifle +145 -> 5401
    //   5259: new 353	org/json/JSONObject
    //   5262: dup
    //   5263: aload 5
    //   5265: iconst_0
    //   5266: aaload
    //   5267: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5270: astore_1
    //   5271: aload_1
    //   5272: ldc_w 577
    //   5275: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5278: astore_2
    //   5279: aload_2
    //   5280: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5283: ifne +36 -> 5319
    //   5286: aload_0
    //   5287: aload_2
    //   5288: iconst_1
    //   5289: anewarray 369	java/lang/String
    //   5292: dup
    //   5293: iconst_0
    //   5294: ldc_w 1673
    //   5297: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5300: checkcast 1673	com/tencent/mobileqq/kandian/base/utils/api/IKBPDUtils
    //   5303: aload_0
    //   5304: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5307: invokevirtual 1676	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   5310: invokeinterface 1680 2 0
    //   5315: aastore
    //   5316: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5319: new 537	java/lang/StringBuilder
    //   5322: dup
    //   5323: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   5326: astore_2
    //   5327: aload_2
    //   5328: ldc 230
    //   5330: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5333: pop
    //   5334: aload_2
    //   5335: aload_1
    //   5336: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5339: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5342: pop
    //   5343: aload_2
    //   5344: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5347: astore_1
    //   5348: goto +33 -> 5381
    //   5351: astore_1
    //   5352: new 537	java/lang/StringBuilder
    //   5355: dup
    //   5356: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   5359: astore_2
    //   5360: aload_2
    //   5361: ldc 230
    //   5363: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5366: pop
    //   5367: aload_2
    //   5368: aload_1
    //   5369: invokevirtual 1681	org/json/JSONException:toString	()Ljava/lang/String;
    //   5372: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5375: pop
    //   5376: aload_2
    //   5377: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5380: astore_1
    //   5381: ldc 45
    //   5383: iconst_1
    //   5384: iconst_2
    //   5385: anewarray 730	java/lang/Object
    //   5388: dup
    //   5389: iconst_0
    //   5390: ldc_w 1666
    //   5393: aastore
    //   5394: dup
    //   5395: iconst_1
    //   5396: aload_1
    //   5397: aastore
    //   5398: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5401: iconst_1
    //   5402: ireturn
    //   5403: ldc_w 1683
    //   5406: aload 4
    //   5408: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5411: ifeq +160 -> 5571
    //   5414: aload 5
    //   5416: ifnull +153 -> 5569
    //   5419: aload 5
    //   5421: arraylength
    //   5422: ifle +147 -> 5569
    //   5425: new 353	org/json/JSONObject
    //   5428: dup
    //   5429: aload 5
    //   5431: iconst_0
    //   5432: aaload
    //   5433: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5436: astore_1
    //   5437: aload_1
    //   5438: ldc_w 577
    //   5441: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5444: astore_2
    //   5445: aload_1
    //   5446: ldc_w 1685
    //   5449: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5452: astore_3
    //   5453: aload_2
    //   5454: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5457: ifne +30 -> 5487
    //   5460: aload_0
    //   5461: aload_2
    //   5462: iconst_1
    //   5463: anewarray 369	java/lang/String
    //   5466: dup
    //   5467: iconst_0
    //   5468: ldc_w 1687
    //   5471: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5474: checkcast 1687	com/tencent/mobileqq/kandian/biz/common/api/IAchilles
    //   5477: aload_3
    //   5478: invokeinterface 1690 2 0
    //   5483: aastore
    //   5484: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5487: new 537	java/lang/StringBuilder
    //   5490: dup
    //   5491: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   5494: astore_2
    //   5495: aload_2
    //   5496: ldc 230
    //   5498: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5501: pop
    //   5502: aload_2
    //   5503: aload_1
    //   5504: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5507: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5510: pop
    //   5511: aload_2
    //   5512: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5515: astore_1
    //   5516: goto +33 -> 5549
    //   5519: astore_1
    //   5520: new 537	java/lang/StringBuilder
    //   5523: dup
    //   5524: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   5527: astore_2
    //   5528: aload_2
    //   5529: ldc 230
    //   5531: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5534: pop
    //   5535: aload_2
    //   5536: aload_1
    //   5537: invokevirtual 1691	java/lang/Exception:toString	()Ljava/lang/String;
    //   5540: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5543: pop
    //   5544: aload_2
    //   5545: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5548: astore_1
    //   5549: ldc 45
    //   5551: iconst_1
    //   5552: iconst_2
    //   5553: anewarray 730	java/lang/Object
    //   5556: dup
    //   5557: iconst_0
    //   5558: ldc_w 1666
    //   5561: aastore
    //   5562: dup
    //   5563: iconst_1
    //   5564: aload_1
    //   5565: aastore
    //   5566: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5569: iconst_1
    //   5570: ireturn
    //   5571: ldc_w 1693
    //   5574: aload 4
    //   5576: invokevirtual 1379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5579: ifeq +155 -> 5734
    //   5582: aload 5
    //   5584: ifnull +148 -> 5732
    //   5587: aload 5
    //   5589: arraylength
    //   5590: ifle +142 -> 5732
    //   5593: new 353	org/json/JSONObject
    //   5596: dup
    //   5597: aload 5
    //   5599: iconst_0
    //   5600: aaload
    //   5601: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5604: astore_1
    //   5605: aload_1
    //   5606: ldc_w 577
    //   5609: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5612: astore_2
    //   5613: aload_1
    //   5614: ldc_w 1685
    //   5617: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5620: astore_3
    //   5621: aload_2
    //   5622: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5625: ifne +25 -> 5650
    //   5628: ldc_w 1687
    //   5631: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5634: checkcast 1687	com/tencent/mobileqq/kandian/biz/common/api/IAchilles
    //   5637: aload_2
    //   5638: aload_3
    //   5639: aload_0
    //   5640: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5643: iconst_0
    //   5644: invokeinterface 1697 5 0
    //   5649: pop
    //   5650: new 537	java/lang/StringBuilder
    //   5653: dup
    //   5654: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   5657: astore_2
    //   5658: aload_2
    //   5659: ldc 230
    //   5661: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5664: pop
    //   5665: aload_2
    //   5666: aload_1
    //   5667: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5670: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5673: pop
    //   5674: aload_2
    //   5675: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5678: astore_1
    //   5679: goto +33 -> 5712
    //   5682: astore_1
    //   5683: new 537	java/lang/StringBuilder
    //   5686: dup
    //   5687: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   5690: astore_2
    //   5691: aload_2
    //   5692: ldc 230
    //   5694: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5697: pop
    //   5698: aload_2
    //   5699: aload_1
    //   5700: invokevirtual 1691	java/lang/Exception:toString	()Ljava/lang/String;
    //   5703: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5706: pop
    //   5707: aload_2
    //   5708: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5711: astore_1
    //   5712: ldc 45
    //   5714: iconst_1
    //   5715: iconst_2
    //   5716: anewarray 730	java/lang/Object
    //   5719: dup
    //   5720: iconst_0
    //   5721: ldc_w 1666
    //   5724: aastore
    //   5725: dup
    //   5726: iconst_1
    //   5727: aload_1
    //   5728: aastore
    //   5729: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5732: iconst_1
    //   5733: ireturn
    //   5734: ldc_w 1699
    //   5737: aload 4
    //   5739: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5742: ifeq +70 -> 5812
    //   5745: aload 5
    //   5747: ifnull +8348 -> 14095
    //   5750: aload 5
    //   5752: arraylength
    //   5753: ifle +8342 -> 14095
    //   5756: new 353	org/json/JSONObject
    //   5759: dup
    //   5760: aload 5
    //   5762: iconst_0
    //   5763: aaload
    //   5764: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5767: ldc_w 1701
    //   5770: iconst_1
    //   5771: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5774: istore 14
    //   5776: ldc_w 1703
    //   5779: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5782: checkcast 1703	com/tencent/mobileqq/kandian/biz/push/api/IRIJPushNotifyManager
    //   5785: iload 14
    //   5787: ldc_w 1705
    //   5790: invokeinterface 1709 3 0
    //   5795: goto +8300 -> 14095
    //   5798: astore_1
    //   5799: ldc 45
    //   5801: iconst_1
    //   5802: aload_1
    //   5803: invokevirtual 1681	org/json/JSONException:toString	()Ljava/lang/String;
    //   5806: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5809: goto +8286 -> 14095
    //   5812: ldc_w 1711
    //   5815: aload 4
    //   5817: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5820: ifeq +144 -> 5964
    //   5823: aload 5
    //   5825: ifnull +8270 -> 14095
    //   5828: aload 5
    //   5830: arraylength
    //   5831: ifle +8264 -> 14095
    //   5834: new 353	org/json/JSONObject
    //   5837: dup
    //   5838: aload 5
    //   5840: iconst_0
    //   5841: aaload
    //   5842: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5845: astore_3
    //   5846: aload_3
    //   5847: ldc_w 1455
    //   5850: iconst_0
    //   5851: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5854: istore 6
    //   5856: aload_3
    //   5857: ldc_w 1713
    //   5860: iconst_0
    //   5861: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5864: istore 14
    //   5866: aload_3
    //   5867: ldc_w 1715
    //   5870: iconst_0
    //   5871: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5874: istore 15
    //   5876: aload_3
    //   5877: ldc_w 1717
    //   5880: ldc 230
    //   5882: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5885: astore_1
    //   5886: aload_3
    //   5887: ldc_w 1719
    //   5890: iconst_1
    //   5891: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5894: istore 7
    //   5896: aload_3
    //   5897: ldc_w 1721
    //   5900: ldc 230
    //   5902: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5905: astore_2
    //   5906: aload_3
    //   5907: ldc_w 577
    //   5910: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5913: astore_3
    //   5914: ldc_w 1703
    //   5917: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5920: checkcast 1703	com/tencent/mobileqq/kandian/biz/push/api/IRIJPushNotifyManager
    //   5923: iload 6
    //   5925: iload 14
    //   5927: iload 15
    //   5929: aload_1
    //   5930: iload 7
    //   5932: aload_2
    //   5933: new 1723	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$5
    //   5936: dup
    //   5937: aload_0
    //   5938: aload_3
    //   5939: invokespecial 1726	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$5:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;)V
    //   5942: invokeinterface 1730 8 0
    //   5947: goto +8148 -> 14095
    //   5950: astore_1
    //   5951: ldc 45
    //   5953: iconst_1
    //   5954: aload_1
    //   5955: invokevirtual 1681	org/json/JSONException:toString	()Ljava/lang/String;
    //   5958: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5961: goto +8134 -> 14095
    //   5964: ldc_w 1732
    //   5967: aload 4
    //   5969: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5972: ifeq +2696 -> 8668
    //   5975: aload 5
    //   5977: ifnull +8118 -> 14095
    //   5980: aload 5
    //   5982: arraylength
    //   5983: ifle +8112 -> 14095
    //   5986: new 353	org/json/JSONObject
    //   5989: dup
    //   5990: aload 5
    //   5992: iconst_0
    //   5993: aaload
    //   5994: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5997: astore 43
    //   5999: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6002: istore 14
    //   6004: iload 14
    //   6006: ifeq +50 -> 6056
    //   6009: new 537	java/lang/StringBuilder
    //   6012: dup
    //   6013: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   6016: astore_1
    //   6017: aload_1
    //   6018: ldc_w 1734
    //   6021: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6024: pop
    //   6025: aload_1
    //   6026: aload 43
    //   6028: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   6031: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6034: pop
    //   6035: ldc 45
    //   6037: iconst_2
    //   6038: aload_1
    //   6039: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6042: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6045: goto +11 -> 6056
    //   6048: astore_1
    //   6049: goto +2542 -> 8591
    //   6052: astore_1
    //   6053: goto +2534 -> 8587
    //   6056: aload 43
    //   6058: ldc_w 686
    //   6061: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6064: astore 31
    //   6066: aload 43
    //   6068: ldc_w 833
    //   6071: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6074: astore 5
    //   6076: aload 43
    //   6078: ldc_w 1736
    //   6081: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6084: astore_1
    //   6085: aload_1
    //   6086: astore 34
    //   6088: aload_1
    //   6089: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6092: ifeq +6 -> 6098
    //   6095: aload_2
    //   6096: astore 34
    //   6098: aload 43
    //   6100: ldc_w 1738
    //   6103: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6106: istore 11
    //   6108: iload 11
    //   6110: iconst_1
    //   6111: if_icmpne +27 -> 6138
    //   6114: new 369	java/lang/String
    //   6117: dup
    //   6118: aload 43
    //   6120: ldc_w 1740
    //   6123: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6126: iconst_2
    //   6127: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6130: invokespecial 695	java/lang/String:<init>	([B)V
    //   6133: astore 4
    //   6135: goto +7 -> 6142
    //   6138: ldc 230
    //   6140: astore 4
    //   6142: new 369	java/lang/String
    //   6145: dup
    //   6146: aload 31
    //   6148: iconst_0
    //   6149: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6152: invokespecial 695	java/lang/String:<init>	([B)V
    //   6155: astore_2
    //   6156: new 369	java/lang/String
    //   6159: dup
    //   6160: aload 5
    //   6162: iconst_0
    //   6163: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6166: invokespecial 695	java/lang/String:<init>	([B)V
    //   6169: astore_1
    //   6170: aload 43
    //   6172: ldc_w 1742
    //   6175: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6178: astore 5
    //   6180: aload 43
    //   6182: ldc_w 568
    //   6185: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6188: astore_3
    //   6189: aload 5
    //   6191: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6194: istore 14
    //   6196: iload 14
    //   6198: ifne +35 -> 6233
    //   6201: new 1744	java/math/BigInteger
    //   6204: dup
    //   6205: aload 5
    //   6207: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6210: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6213: lstore 19
    //   6215: goto +21 -> 6236
    //   6218: astore 31
    //   6220: aload 5
    //   6222: astore 32
    //   6224: aload_2
    //   6225: astore 5
    //   6227: aload 32
    //   6229: astore_2
    //   6230: goto +325 -> 6555
    //   6233: lconst_0
    //   6234: lstore 19
    //   6236: aload 43
    //   6238: ldc_w 1750
    //   6241: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6244: astore 31
    //   6246: aload 31
    //   6248: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6251: istore 14
    //   6253: iload 14
    //   6255: ifne +25 -> 6280
    //   6258: new 1744	java/math/BigInteger
    //   6261: dup
    //   6262: aload 31
    //   6264: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6267: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6270: lstore 21
    //   6272: goto +11 -> 6283
    //   6275: astore 31
    //   6277: goto +173 -> 6450
    //   6280: lconst_0
    //   6281: lstore 21
    //   6283: aload 43
    //   6285: ldc_w 1752
    //   6288: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6291: astore 31
    //   6293: aload 31
    //   6295: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6298: ifne +20 -> 6318
    //   6301: new 1744	java/math/BigInteger
    //   6304: dup
    //   6305: aload 31
    //   6307: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6310: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6313: lstore 23
    //   6315: goto +6 -> 6321
    //   6318: lconst_0
    //   6319: lstore 23
    //   6321: aload 43
    //   6323: ldc_w 1754
    //   6326: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6329: astore 31
    //   6331: aload 31
    //   6333: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6336: ifne +20 -> 6356
    //   6339: new 1744	java/math/BigInteger
    //   6342: dup
    //   6343: aload 31
    //   6345: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6348: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6351: lstore 25
    //   6353: goto +6 -> 6359
    //   6356: lconst_0
    //   6357: lstore 25
    //   6359: aload 43
    //   6361: ldc_w 1756
    //   6364: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6367: lstore 27
    //   6369: aload 43
    //   6371: ldc_w 1058
    //   6374: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6377: istore 8
    //   6379: lload 21
    //   6381: lstore 29
    //   6383: aload_2
    //   6384: astore 37
    //   6386: aload 5
    //   6388: astore 36
    //   6390: lload 23
    //   6392: lstore 21
    //   6394: lload 25
    //   6396: lstore 23
    //   6398: lload 29
    //   6400: lstore 25
    //   6402: aload_3
    //   6403: astore 35
    //   6405: goto +195 -> 6600
    //   6408: astore 31
    //   6410: lload 23
    //   6412: lstore 29
    //   6414: lload 25
    //   6416: lstore 23
    //   6418: goto +52 -> 6470
    //   6421: astore 31
    //   6423: lload 23
    //   6425: lstore 29
    //   6427: lload 25
    //   6429: lstore 23
    //   6431: goto +36 -> 6467
    //   6434: astore 31
    //   6436: lload 23
    //   6438: lstore 29
    //   6440: goto +24 -> 6464
    //   6443: astore 31
    //   6445: goto +16 -> 6461
    //   6448: astore 31
    //   6450: goto +8 -> 6458
    //   6453: astore 31
    //   6455: lconst_0
    //   6456: lstore 19
    //   6458: lconst_0
    //   6459: lstore 21
    //   6461: lconst_0
    //   6462: lstore 29
    //   6464: lconst_0
    //   6465: lstore 23
    //   6467: lconst_0
    //   6468: lstore 27
    //   6470: aload 5
    //   6472: astore 32
    //   6474: aload 31
    //   6476: astore 5
    //   6478: aload_2
    //   6479: astore 31
    //   6481: aload 32
    //   6483: astore_2
    //   6484: lload 21
    //   6486: lstore 25
    //   6488: lload 29
    //   6490: lstore 21
    //   6492: goto +90 -> 6582
    //   6495: astore_3
    //   6496: goto +7 -> 6503
    //   6499: astore_3
    //   6500: aload 5
    //   6502: astore_1
    //   6503: aload_3
    //   6504: astore 5
    //   6506: ldc 230
    //   6508: astore 32
    //   6510: aload 32
    //   6512: astore_3
    //   6513: lconst_0
    //   6514: lstore 19
    //   6516: lconst_0
    //   6517: lstore 25
    //   6519: lconst_0
    //   6520: lstore 21
    //   6522: lconst_0
    //   6523: lstore 23
    //   6525: lconst_0
    //   6526: lstore 27
    //   6528: aload_2
    //   6529: astore 31
    //   6531: aload 32
    //   6533: astore_2
    //   6534: goto +48 -> 6582
    //   6537: astore 32
    //   6539: ldc 230
    //   6541: astore_2
    //   6542: aload_2
    //   6543: astore_3
    //   6544: aload 5
    //   6546: astore_1
    //   6547: aload 31
    //   6549: astore 5
    //   6551: aload 32
    //   6553: astore 31
    //   6555: lconst_0
    //   6556: lstore 27
    //   6558: lconst_0
    //   6559: lstore 23
    //   6561: lconst_0
    //   6562: lstore 21
    //   6564: lconst_0
    //   6565: lstore 25
    //   6567: lconst_0
    //   6568: lstore 19
    //   6570: aload 31
    //   6572: astore 32
    //   6574: aload 5
    //   6576: astore 31
    //   6578: aload 32
    //   6580: astore 5
    //   6582: aload 5
    //   6584: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   6587: iconst_0
    //   6588: istore 8
    //   6590: aload_3
    //   6591: astore 35
    //   6593: aload_2
    //   6594: astore 36
    //   6596: aload 31
    //   6598: astore 37
    //   6600: aload 43
    //   6602: ldc_w 1758
    //   6605: lconst_1
    //   6606: invokevirtual 842	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   6609: lstore 29
    //   6611: aload 43
    //   6613: ldc_w 1455
    //   6616: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6619: istore 9
    //   6621: aload 43
    //   6623: ldc_w 1760
    //   6626: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6629: istore 12
    //   6631: aload 43
    //   6633: ldc_w 1762
    //   6636: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6639: astore 31
    //   6641: aload 43
    //   6643: ldc_w 837
    //   6646: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6649: istore 7
    //   6651: aload 43
    //   6653: ldc_w 577
    //   6656: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6659: astore 44
    //   6661: aload 43
    //   6663: ldc_w 1764
    //   6666: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6669: astore_3
    //   6670: ldc_w 1742
    //   6673: astore 5
    //   6675: ldc_w 297
    //   6678: astore_2
    //   6679: new 369	java/lang/String
    //   6682: dup
    //   6683: aload_3
    //   6684: iconst_0
    //   6685: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6688: invokespecial 695	java/lang/String:<init>	([B)V
    //   6691: astore 42
    //   6693: aload 43
    //   6695: ldc_w 829
    //   6698: iconst_1
    //   6699: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6702: istore 6
    //   6704: ldc_w 1766
    //   6707: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6710: checkcast 1766	com/tencent/mobileqq/kandian/biz/feeds/api/IArticleInfoFactory
    //   6713: invokeinterface 1770 1 0
    //   6718: astore 45
    //   6720: aload 45
    //   6722: lload 25
    //   6724: putfield 1775	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   6727: aload 45
    //   6729: aload 37
    //   6731: putfield 1778	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   6734: aload 45
    //   6736: aload_1
    //   6737: putfield 1781	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   6740: aload 45
    //   6742: aload 31
    //   6744: putfield 1784	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   6747: aload 45
    //   6749: iload 7
    //   6751: putfield 1787	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   6754: aload 45
    //   6756: lload 19
    //   6758: putfield 1790	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   6761: aload 45
    //   6763: aload 42
    //   6765: putfield 1793	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   6768: aload 45
    //   6770: lload 23
    //   6772: putfield 1795	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:businessId	J
    //   6775: aload 45
    //   6777: iload 6
    //   6779: putfield 1798	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedType	I
    //   6782: aload 43
    //   6784: ldc_w 1800
    //   6787: invokevirtual 1803	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6790: astore_3
    //   6791: goto +45 -> 6836
    //   6794: astore_3
    //   6795: new 537	java/lang/StringBuilder
    //   6798: dup
    //   6799: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   6802: astore 32
    //   6804: aload 32
    //   6806: ldc_w 1805
    //   6809: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6812: pop
    //   6813: aload 32
    //   6815: aload_3
    //   6816: invokevirtual 1681	org/json/JSONException:toString	()Ljava/lang/String;
    //   6819: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6822: pop
    //   6823: ldc 45
    //   6825: iconst_1
    //   6826: aload 32
    //   6828: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6831: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6834: aconst_null
    //   6835: astore_3
    //   6836: aload 45
    //   6838: new 1807	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo
    //   6841: dup
    //   6842: invokespecial 1808	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:<init>	()V
    //   6845: putfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   6848: aload 45
    //   6850: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   6853: new 1814	com/tencent/mobileqq/kandian/repo/handler/BiuInfo
    //   6856: dup
    //   6857: invokespecial 1815	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:<init>	()V
    //   6860: putfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   6863: aload 45
    //   6865: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   6868: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   6871: lload 21
    //   6873: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6876: putfield 1822	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:b	Ljava/lang/Long;
    //   6879: aload 45
    //   6881: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   6884: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   6887: lload 29
    //   6889: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6892: putfield 1824	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:c	Ljava/lang/Long;
    //   6895: aload 45
    //   6897: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   6900: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   6903: new 247	java/util/ArrayList
    //   6906: dup
    //   6907: invokespecial 248	java/util/ArrayList:<init>	()V
    //   6910: putfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   6913: aload 42
    //   6915: astore 38
    //   6917: lload 19
    //   6919: lstore 21
    //   6921: lload 25
    //   6923: lstore 23
    //   6925: aload_1
    //   6926: astore 33
    //   6928: aload 31
    //   6930: astore 39
    //   6932: aload 5
    //   6934: astore 40
    //   6936: aload_2
    //   6937: astore 32
    //   6939: aload_3
    //   6940: ifnull +340 -> 7280
    //   6943: iconst_0
    //   6944: istore 7
    //   6946: aload_3
    //   6947: astore 41
    //   6949: aload 31
    //   6951: astore_3
    //   6952: aload_1
    //   6953: astore 31
    //   6955: aload 42
    //   6957: astore_1
    //   6958: aload_1
    //   6959: astore 38
    //   6961: lload 19
    //   6963: lstore 21
    //   6965: lload 25
    //   6967: lstore 23
    //   6969: aload 31
    //   6971: astore 33
    //   6973: aload_3
    //   6974: astore 39
    //   6976: aload 5
    //   6978: astore 40
    //   6980: aload_2
    //   6981: astore 32
    //   6983: iload 7
    //   6985: aload 41
    //   6987: invokevirtual 591	org/json/JSONArray:length	()I
    //   6990: if_icmpge +290 -> 7280
    //   6993: new 1829	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo
    //   6996: dup
    //   6997: invokespecial 1830	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:<init>	()V
    //   7000: astore 32
    //   7002: aload 41
    //   7004: iload 7
    //   7006: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7009: astore 33
    //   7011: aload 32
    //   7013: aload 33
    //   7015: aload_2
    //   7016: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   7019: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7022: putfield 1837	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mUin	Ljava/lang/Long;
    //   7025: aload 32
    //   7027: new 369	java/lang/String
    //   7030: dup
    //   7031: aload 33
    //   7033: ldc_w 1839
    //   7036: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7039: iconst_0
    //   7040: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7043: invokespecial 695	java/lang/String:<init>	([B)V
    //   7046: putfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   7049: aload 32
    //   7051: aload 32
    //   7053: getfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   7056: putfield 1845	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   7059: aload 32
    //   7061: aload 33
    //   7063: ldc_w 1847
    //   7066: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7069: putfield 1850	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuTime	I
    //   7072: aload 32
    //   7074: aload 33
    //   7076: ldc_w 709
    //   7079: iconst_1
    //   7080: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7083: putfield 1853	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedsType	I
    //   7086: aload 32
    //   7088: aload 33
    //   7090: ldc_w 1855
    //   7093: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7096: putfield 1858	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOpType	I
    //   7099: aload 33
    //   7101: ldc_w 1860
    //   7104: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7107: astore 38
    //   7109: aload 33
    //   7111: ldc_w 1862
    //   7114: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7117: astore 39
    //   7119: aload 38
    //   7121: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7124: ifne +42 -> 7166
    //   7127: aload 39
    //   7129: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7132: ifne +34 -> 7166
    //   7135: aload 32
    //   7137: new 1864	com/tencent/mobileqq/kandian/repo/handler/JumpInfo
    //   7140: dup
    //   7141: lconst_0
    //   7142: new 369	java/lang/String
    //   7145: dup
    //   7146: aload 38
    //   7148: iconst_0
    //   7149: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7152: invokespecial 695	java/lang/String:<init>	([B)V
    //   7155: aload 39
    //   7157: invokespecial 1867	com/tencent/mobileqq/kandian/repo/handler/JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   7160: putfield 1871	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:jumpInfo	Lcom/tencent/mobileqq/kandian/repo/handler/JumpInfo;
    //   7163: goto +3 -> 7166
    //   7166: aload 33
    //   7168: aload 5
    //   7170: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7173: astore 33
    //   7175: aload 33
    //   7177: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7180: ifne +68 -> 7248
    //   7183: aload 32
    //   7185: new 1744	java/math/BigInteger
    //   7188: dup
    //   7189: aload 33
    //   7191: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7194: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   7197: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7200: putfield 1873	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   7203: goto +45 -> 7248
    //   7206: astore 33
    //   7208: new 537	java/lang/StringBuilder
    //   7211: dup
    //   7212: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   7215: astore 38
    //   7217: aload 38
    //   7219: ldc_w 1805
    //   7222: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7225: pop
    //   7226: aload 38
    //   7228: aload 33
    //   7230: invokevirtual 1691	java/lang/Exception:toString	()Ljava/lang/String;
    //   7233: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7236: pop
    //   7237: ldc 45
    //   7239: iconst_1
    //   7240: aload 38
    //   7242: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7245: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7248: aload 45
    //   7250: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7253: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   7256: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   7259: aload 32
    //   7261: invokeinterface 1876 2 0
    //   7266: pop
    //   7267: iload 7
    //   7269: iconst_1
    //   7270: iadd
    //   7271: istore 7
    //   7273: goto -315 -> 6958
    //   7276: astore_1
    //   7277: goto +1353 -> 8630
    //   7280: aload 33
    //   7282: astore_1
    //   7283: aload 32
    //   7285: astore_2
    //   7286: aload 43
    //   7288: ldc_w 1878
    //   7291: invokevirtual 518	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7294: astore 32
    //   7296: aload 32
    //   7298: ifnull +736 -> 8034
    //   7301: ldc_w 1880
    //   7304: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   7307: checkcast 1880	com/tencent/mobileqq/kandian/repo/common/api/IRIJItemViewTypeUtils
    //   7310: iload 6
    //   7312: lload 29
    //   7314: invokeinterface 1884 4 0
    //   7319: ifeq +715 -> 8034
    //   7322: aload 45
    //   7324: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7327: new 1886	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo
    //   7330: dup
    //   7331: invokespecial 1887	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:<init>	()V
    //   7334: putfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7337: aload 32
    //   7339: ldc_w 1893
    //   7342: iconst_0
    //   7343: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7346: istore 13
    //   7348: aload 32
    //   7350: ldc_w 1895
    //   7353: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7356: astore 31
    //   7358: aload 32
    //   7360: ldc_w 1897
    //   7363: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7366: astore_3
    //   7367: aload_1
    //   7368: astore 5
    //   7370: iload 6
    //   7372: istore 7
    //   7374: aload_3
    //   7375: ifnull +346 -> 7721
    //   7378: aload 45
    //   7380: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7383: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7386: new 1814	com/tencent/mobileqq/kandian/repo/handler/BiuInfo
    //   7389: dup
    //   7390: invokespecial 1815	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:<init>	()V
    //   7393: putfield 1899	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:h	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   7396: aload 45
    //   7398: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7401: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7404: getfield 1899	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:h	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   7407: new 247	java/util/ArrayList
    //   7410: dup
    //   7411: invokespecial 248	java/util/ArrayList:<init>	()V
    //   7414: putfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   7417: iconst_0
    //   7418: istore 10
    //   7420: aload_1
    //   7421: astore 5
    //   7423: iload 6
    //   7425: istore 7
    //   7427: iload 10
    //   7429: aload_3
    //   7430: invokevirtual 591	org/json/JSONArray:length	()I
    //   7433: if_icmpge +288 -> 7721
    //   7436: new 1829	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo
    //   7439: dup
    //   7440: invokespecial 1830	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:<init>	()V
    //   7443: astore 5
    //   7445: aload_3
    //   7446: iload 10
    //   7448: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7451: astore 33
    //   7453: aload 5
    //   7455: aload 33
    //   7457: aload_2
    //   7458: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   7461: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7464: putfield 1837	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mUin	Ljava/lang/Long;
    //   7467: aload 5
    //   7469: new 369	java/lang/String
    //   7472: dup
    //   7473: aload 33
    //   7475: ldc_w 1839
    //   7478: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7481: iconst_0
    //   7482: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7485: invokespecial 695	java/lang/String:<init>	([B)V
    //   7488: putfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   7491: aload 5
    //   7493: aload 5
    //   7495: getfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   7498: putfield 1845	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   7501: aload 5
    //   7503: aload 33
    //   7505: ldc_w 1847
    //   7508: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7511: putfield 1850	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuTime	I
    //   7514: aload 5
    //   7516: aload 33
    //   7518: ldc_w 709
    //   7521: iconst_1
    //   7522: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7525: putfield 1853	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedsType	I
    //   7528: aload 5
    //   7530: aload 33
    //   7532: ldc_w 1855
    //   7535: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7538: putfield 1858	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOpType	I
    //   7541: aload 33
    //   7543: ldc_w 1860
    //   7546: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7549: astore 41
    //   7551: aload 33
    //   7553: ldc_w 1862
    //   7556: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7559: astore 42
    //   7561: aload 41
    //   7563: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7566: ifne +42 -> 7608
    //   7569: aload 42
    //   7571: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7574: ifne +34 -> 7608
    //   7577: aload 5
    //   7579: new 1864	com/tencent/mobileqq/kandian/repo/handler/JumpInfo
    //   7582: dup
    //   7583: lconst_0
    //   7584: new 369	java/lang/String
    //   7587: dup
    //   7588: aload 41
    //   7590: iconst_0
    //   7591: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7594: invokespecial 695	java/lang/String:<init>	([B)V
    //   7597: aload 42
    //   7599: invokespecial 1867	com/tencent/mobileqq/kandian/repo/handler/JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   7602: putfield 1871	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:jumpInfo	Lcom/tencent/mobileqq/kandian/repo/handler/JumpInfo;
    //   7605: goto +3 -> 7608
    //   7608: aload 33
    //   7610: aload 40
    //   7612: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7615: astore 33
    //   7617: aload 33
    //   7619: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7622: ifne +68 -> 7690
    //   7625: aload 5
    //   7627: new 1744	java/math/BigInteger
    //   7630: dup
    //   7631: aload 33
    //   7633: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7636: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   7639: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7642: putfield 1873	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   7645: goto +45 -> 7690
    //   7648: astore 33
    //   7650: new 537	java/lang/StringBuilder
    //   7653: dup
    //   7654: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   7657: astore 41
    //   7659: aload 41
    //   7661: ldc_w 1805
    //   7664: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7667: pop
    //   7668: aload 41
    //   7670: aload 33
    //   7672: invokevirtual 1691	java/lang/Exception:toString	()Ljava/lang/String;
    //   7675: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7678: pop
    //   7679: ldc 45
    //   7681: iconst_1
    //   7682: aload 41
    //   7684: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7687: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7690: aload 45
    //   7692: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7695: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7698: getfield 1899	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:h	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   7701: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   7704: aload 5
    //   7706: invokeinterface 1876 2 0
    //   7711: pop
    //   7712: iload 10
    //   7714: iconst_1
    //   7715: iadd
    //   7716: istore 10
    //   7718: goto -298 -> 7420
    //   7721: aload 45
    //   7723: new 369	java/lang/String
    //   7726: dup
    //   7727: aload 31
    //   7729: iconst_0
    //   7730: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7733: invokespecial 695	java/lang/String:<init>	([B)V
    //   7736: putfield 1778	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   7739: ldc 230
    //   7741: astore_1
    //   7742: aload 45
    //   7744: aload_1
    //   7745: putfield 1793	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   7748: iload 13
    //   7750: iconst_3
    //   7751: if_icmpeq +114 -> 7865
    //   7754: iload 13
    //   7756: iconst_2
    //   7757: if_icmpne +6437 -> 14194
    //   7760: goto +105 -> 7865
    //   7763: iload 13
    //   7765: iconst_1
    //   7766: if_icmpne +6443 -> 14209
    //   7769: aload 45
    //   7771: aload_1
    //   7772: putfield 1784	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   7775: goto +6434 -> 14209
    //   7778: aload 45
    //   7780: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7783: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7786: new 247	java/util/ArrayList
    //   7789: dup
    //   7790: invokespecial 248	java/util/ArrayList:<init>	()V
    //   7793: putfield 1901	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:c	Ljava/util/ArrayList;
    //   7796: new 1903	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo
    //   7799: dup
    //   7800: invokespecial 1904	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:<init>	()V
    //   7803: astore_1
    //   7804: aload 32
    //   7806: ldc_w 1906
    //   7809: invokevirtual 518	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7812: astore_2
    //   7813: aload_2
    //   7814: ifnull +6402 -> 14216
    //   7817: aload_1
    //   7818: aload_2
    //   7819: ldc_w 1908
    //   7822: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7825: putfield 1910	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:d	Ljava/lang/String;
    //   7828: aload_1
    //   7829: aload_2
    //   7830: ldc_w 1912
    //   7833: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7836: i2l
    //   7837: putfield 1914	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:g	J
    //   7840: aload_1
    //   7841: aload 37
    //   7843: putfield 1916	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:e	Ljava/lang/String;
    //   7846: aload 45
    //   7848: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7851: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7854: getfield 1901	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:c	Ljava/util/ArrayList;
    //   7857: aload_1
    //   7858: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7861: pop
    //   7862: goto +6354 -> 14216
    //   7865: aload 45
    //   7867: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7870: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7873: new 247	java/util/ArrayList
    //   7876: dup
    //   7877: invokespecial 248	java/util/ArrayList:<init>	()V
    //   7880: putfield 1918	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   7883: new 1920	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo
    //   7886: dup
    //   7887: invokespecial 1921	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo:<init>	()V
    //   7890: astore_1
    //   7891: aload 32
    //   7893: ldc_w 1923
    //   7896: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7899: astore_2
    //   7900: aload_2
    //   7901: ifnull +6321 -> 14222
    //   7904: aload_2
    //   7905: invokevirtual 591	org/json/JSONArray:length	()I
    //   7908: ifle +6314 -> 14222
    //   7911: aload_1
    //   7912: aload_2
    //   7913: iconst_0
    //   7914: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7917: ldc_w 1925
    //   7920: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7923: putfield 1926	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo:e	Ljava/lang/String;
    //   7926: aload 45
    //   7928: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7931: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7934: getfield 1918	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   7937: aload_1
    //   7938: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7941: pop
    //   7942: goto +6280 -> 14222
    //   7945: iload 12
    //   7947: bipush 22
    //   7949: if_icmpne +6279 -> 14228
    //   7952: new 1928	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo
    //   7955: dup
    //   7956: invokespecial 1929	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:<init>	()V
    //   7959: astore_1
    //   7960: aload_1
    //   7961: aload 5
    //   7963: putfield 1931	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:c	Ljava/lang/String;
    //   7966: aload_1
    //   7967: aload 39
    //   7969: putfield 1932	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:d	Ljava/lang/String;
    //   7972: aload_1
    //   7973: aload 38
    //   7975: putfield 1933	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:e	Ljava/lang/String;
    //   7978: aload_1
    //   7979: lload 27
    //   7981: putfield 1935	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:a	J
    //   7984: aload 45
    //   7986: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   7989: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   7992: aload_1
    //   7993: putfield 1939	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:k	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo;
    //   7996: goto +3 -> 7999
    //   7999: aload 45
    //   8001: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8004: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   8007: iload 13
    //   8009: putfield 1941	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:a	I
    //   8012: aload 45
    //   8014: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8017: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   8020: aload 45
    //   8022: getfield 1778	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   8025: putfield 1943	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:f	Ljava/lang/String;
    //   8028: aload 31
    //   8030: astore_1
    //   8031: goto +14 -> 8045
    //   8034: ldc 230
    //   8036: astore_1
    //   8037: iload 6
    //   8039: istore 7
    //   8041: iload 9
    //   8043: istore 6
    //   8045: iload 12
    //   8047: istore 9
    //   8049: aload 45
    //   8051: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8054: ldc 230
    //   8056: putfield 1944	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:e	Ljava/lang/String;
    //   8059: aload 45
    //   8061: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8064: ldc 230
    //   8066: putfield 1946	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:g	Ljava/lang/String;
    //   8069: aload 45
    //   8071: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8074: ldc 230
    //   8076: putfield 1947	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:f	Ljava/lang/String;
    //   8079: aload_0
    //   8080: astore_3
    //   8081: new 316	android/content/Intent
    //   8084: dup
    //   8085: aload_3
    //   8086: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8089: ldc_w 1949
    //   8092: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8095: checkcast 1949	com/tencent/mobileqq/kandian/biz/ugc/api/IRIJDeliverUGCUtils
    //   8098: invokeinterface 1952 1 0
    //   8103: invokespecial 748	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8106: astore_2
    //   8107: aload_2
    //   8108: ldc_w 1954
    //   8111: aload 45
    //   8113: invokevirtual 1957	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   8116: pop
    //   8117: aload 35
    //   8119: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8122: ifne +6109 -> 14231
    //   8125: aload_2
    //   8126: ldc_w 1959
    //   8129: aload 35
    //   8131: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8134: pop
    //   8135: goto +3 -> 8138
    //   8138: aload_2
    //   8139: ldc_w 1961
    //   8142: iload 9
    //   8144: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8147: pop
    //   8148: aload_2
    //   8149: ldc_w 1963
    //   8152: iload 6
    //   8154: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8157: pop
    //   8158: aload_2
    //   8159: ldc_w 1965
    //   8162: aload 44
    //   8164: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8167: pop
    //   8168: iconst_3
    //   8169: istore 6
    //   8171: iload 9
    //   8173: iconst_5
    //   8174: if_icmpne +6060 -> 14234
    //   8177: iconst_4
    //   8178: istore 6
    //   8180: goto +3 -> 8183
    //   8183: aload_2
    //   8184: ldc_w 1967
    //   8187: iload 6
    //   8189: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8192: pop
    //   8193: aload_2
    //   8194: ldc_w 1969
    //   8197: aload 36
    //   8199: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8202: pop
    //   8203: aload_2
    //   8204: ldc_w 829
    //   8207: iload 7
    //   8209: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8212: pop
    //   8213: aload_2
    //   8214: ldc_w 1971
    //   8217: aload_1
    //   8218: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8221: pop
    //   8222: aload_2
    //   8223: ldc_w 1973
    //   8226: lload 27
    //   8228: invokevirtual 1976	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8231: pop
    //   8232: aload_2
    //   8233: ldc_w 1978
    //   8236: iload 8
    //   8238: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8241: pop
    //   8242: aload_2
    //   8243: ldc_w 1980
    //   8246: aload 34
    //   8248: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8251: pop
    //   8252: iload 9
    //   8254: bipush 23
    //   8256: if_icmpne +33 -> 8289
    //   8259: aload 34
    //   8261: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8264: ifne +14 -> 8278
    //   8267: aload 45
    //   8269: getfield 1781	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   8272: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8275: ifeq +14 -> 8289
    //   8278: ldc 45
    //   8280: iconst_1
    //   8281: ldc_w 1982
    //   8284: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8287: iconst_0
    //   8288: ireturn
    //   8289: iload 11
    //   8291: iconst_1
    //   8292: if_icmpne +183 -> 8475
    //   8295: aload 45
    //   8297: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8300: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   8303: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   8306: ifnull +5997 -> 14303
    //   8309: aload 45
    //   8311: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8314: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   8317: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   8320: invokeinterface 1983 1 0
    //   8325: ifle +5978 -> 14303
    //   8328: new 537	java/lang/StringBuilder
    //   8331: dup
    //   8332: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   8335: astore_1
    //   8336: aload_1
    //   8337: aload 4
    //   8339: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8342: pop
    //   8343: aload_1
    //   8344: ldc_w 1985
    //   8347: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8350: pop
    //   8351: aload_1
    //   8352: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8355: astore_1
    //   8356: goto +3 -> 8359
    //   8359: aload_1
    //   8360: astore_2
    //   8361: aload_1
    //   8362: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8365: ifeq +7 -> 8372
    //   8368: ldc_w 1987
    //   8371: astore_2
    //   8372: new 537	java/lang/StringBuilder
    //   8375: dup
    //   8376: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   8379: astore_1
    //   8380: aload_1
    //   8381: ldc_w 1989
    //   8384: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8387: pop
    //   8388: aload_1
    //   8389: aload_2
    //   8390: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8393: pop
    //   8394: aload_1
    //   8395: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8398: astore_1
    //   8399: invokestatic 1994	com/tencent/mobileqq/kandian/repo/feeds/ReadInJoyLogicEngineEventDispatcher:a	()Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyLogicEngineEventDispatcher;
    //   8402: new 1996	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver
    //   8405: dup
    //   8406: aload_3
    //   8407: aload 44
    //   8409: iload 7
    //   8411: invokespecial 1999	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;I)V
    //   8414: invokevirtual 2002	com/tencent/mobileqq/kandian/repo/feeds/ReadInJoyLogicEngineEventDispatcher:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;)V
    //   8417: aload_3
    //   8418: getfield 2004	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:app	Lcom/tencent/common/app/AppInterface;
    //   8421: checkcast 2006	com/tencent/mobileqq/app/BrowserAppInterface
    //   8424: invokevirtual 2009	com/tencent/mobileqq/app/BrowserAppInterface:c	()Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManager;
    //   8427: invokeinterface 2015 1 0
    //   8432: aload_3
    //   8433: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8436: invokevirtual 1676	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   8439: invokevirtual 2018	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   8442: lload 21
    //   8444: aload 45
    //   8446: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   8449: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   8452: lconst_0
    //   8453: aload_1
    //   8454: lload 23
    //   8456: ldc2_w 838
    //   8459: iload 6
    //   8461: aload 35
    //   8463: iload 7
    //   8465: aload 45
    //   8467: invokeinterface 2023 17 0
    //   8472: goto +2613 -> 11085
    //   8475: aload_2
    //   8476: ldc_w 1967
    //   8479: iconst_4
    //   8480: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8483: pop
    //   8484: aload_2
    //   8485: ldc_w 1961
    //   8488: iconst_0
    //   8489: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8492: pop
    //   8493: aload_2
    //   8494: ldc_w 2025
    //   8497: iconst_0
    //   8498: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8501: pop
    //   8502: aload_2
    //   8503: ldc_w 829
    //   8506: iconst_1
    //   8507: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8510: pop
    //   8511: aload_2
    //   8512: ldc_w 2027
    //   8515: iconst_0
    //   8516: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8519: pop
    //   8520: aload_2
    //   8521: ldc_w 2032
    //   8524: iconst_1
    //   8525: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8528: pop
    //   8529: aload_2
    //   8530: ldc_w 2034
    //   8533: iconst_1
    //   8534: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8537: pop
    //   8538: aload_2
    //   8539: ldc_w 2036
    //   8542: lload 21
    //   8544: invokevirtual 1976	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8547: pop
    //   8548: aload_3
    //   8549: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8552: aload_2
    //   8553: bipush 113
    //   8555: invokevirtual 815	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   8558: aload_3
    //   8559: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8562: iconst_0
    //   8563: iconst_0
    //   8564: invokevirtual 2039	android/app/Activity:overridePendingTransition	(II)V
    //   8567: goto +2518 -> 11085
    //   8570: astore_1
    //   8571: goto +20 -> 8591
    //   8574: astore_1
    //   8575: goto +12 -> 8587
    //   8578: astore_1
    //   8579: goto +12 -> 8591
    //   8582: astore_1
    //   8583: goto +4 -> 8587
    //   8586: astore_1
    //   8587: goto +43 -> 8630
    //   8590: astore_1
    //   8591: new 537	java/lang/StringBuilder
    //   8594: dup
    //   8595: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   8598: astore_2
    //   8599: aload_2
    //   8600: ldc_w 2041
    //   8603: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8606: pop
    //   8607: aload_2
    //   8608: aload_1
    //   8609: invokevirtual 2042	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   8612: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8615: pop
    //   8616: ldc 45
    //   8618: iconst_1
    //   8619: aload_2
    //   8620: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8623: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8626: goto +2459 -> 11085
    //   8629: astore_2
    //   8630: new 537	java/lang/StringBuilder
    //   8633: dup
    //   8634: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   8637: astore_2
    //   8638: aload_2
    //   8639: ldc_w 2044
    //   8642: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8645: pop
    //   8646: aload_2
    //   8647: aload_1
    //   8648: invokevirtual 1681	org/json/JSONException:toString	()Ljava/lang/String;
    //   8651: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8654: pop
    //   8655: ldc 45
    //   8657: iconst_1
    //   8658: aload_2
    //   8659: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8662: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8665: goto +2420 -> 11085
    //   8668: ldc_w 297
    //   8671: astore 40
    //   8673: aload_0
    //   8674: astore_3
    //   8675: ldc_w 2046
    //   8678: aload 4
    //   8680: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   8683: ifeq +2405 -> 11088
    //   8686: aload 5
    //   8688: ifnull +2397 -> 11085
    //   8691: aload 5
    //   8693: arraylength
    //   8694: ifle +2391 -> 11085
    //   8697: aload_3
    //   8698: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8701: instanceof 2048
    //   8704: ifeq +2381 -> 11085
    //   8707: new 353	org/json/JSONObject
    //   8710: dup
    //   8711: aload 5
    //   8713: iconst_0
    //   8714: aaload
    //   8715: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8718: astore 41
    //   8720: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8723: istore 14
    //   8725: iload 14
    //   8727: ifeq +46 -> 8773
    //   8730: new 537	java/lang/StringBuilder
    //   8733: dup
    //   8734: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   8737: astore_1
    //   8738: aload_1
    //   8739: ldc_w 1734
    //   8742: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8745: pop
    //   8746: aload_1
    //   8747: aload 41
    //   8749: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8752: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8755: pop
    //   8756: ldc 45
    //   8758: iconst_2
    //   8759: aload_1
    //   8760: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8763: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8766: goto +7 -> 8773
    //   8769: astore_1
    //   8770: goto +2308 -> 11078
    //   8773: aload 41
    //   8775: ldc_w 686
    //   8778: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8781: astore 5
    //   8783: aload 41
    //   8785: ldc_w 833
    //   8788: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8791: astore 4
    //   8793: aload 41
    //   8795: ldc_w 1736
    //   8798: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8801: astore_1
    //   8802: aload_1
    //   8803: astore 32
    //   8805: aload_1
    //   8806: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8809: ifeq +6 -> 8815
    //   8812: aload_2
    //   8813: astore 32
    //   8815: aload 41
    //   8817: ldc_w 1738
    //   8820: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8823: istore 11
    //   8825: iload 11
    //   8827: iconst_1
    //   8828: if_icmpne +26 -> 8854
    //   8831: new 369	java/lang/String
    //   8834: dup
    //   8835: aload 41
    //   8837: ldc_w 1740
    //   8840: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8843: iconst_2
    //   8844: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   8847: invokespecial 695	java/lang/String:<init>	([B)V
    //   8850: astore_3
    //   8851: goto +6 -> 8857
    //   8854: ldc 230
    //   8856: astore_3
    //   8857: new 369	java/lang/String
    //   8860: dup
    //   8861: aload 5
    //   8863: iconst_0
    //   8864: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   8867: invokespecial 695	java/lang/String:<init>	([B)V
    //   8870: astore_2
    //   8871: new 369	java/lang/String
    //   8874: dup
    //   8875: aload 4
    //   8877: iconst_0
    //   8878: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   8881: invokespecial 695	java/lang/String:<init>	([B)V
    //   8884: astore_1
    //   8885: aload 41
    //   8887: ldc_w 1742
    //   8890: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8893: astore 33
    //   8895: aload 41
    //   8897: ldc_w 568
    //   8900: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8903: astore 4
    //   8905: aload 33
    //   8907: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8910: istore 14
    //   8912: iload 14
    //   8914: ifne +54 -> 8968
    //   8917: new 1744	java/math/BigInteger
    //   8920: dup
    //   8921: aload 33
    //   8923: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8926: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   8929: lstore 19
    //   8931: goto +40 -> 8971
    //   8934: astore 31
    //   8936: aload 4
    //   8938: astore 34
    //   8940: lconst_0
    //   8941: lstore 19
    //   8943: lconst_0
    //   8944: lstore 25
    //   8946: lconst_0
    //   8947: lstore 21
    //   8949: lconst_0
    //   8950: lstore 23
    //   8952: lconst_0
    //   8953: lstore 27
    //   8955: aload 33
    //   8957: astore 4
    //   8959: aload_2
    //   8960: astore 5
    //   8962: aload 34
    //   8964: astore_2
    //   8965: goto +320 -> 9285
    //   8968: lconst_0
    //   8969: lstore 19
    //   8971: aload 41
    //   8973: ldc_w 1750
    //   8976: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8979: astore 5
    //   8981: aload 5
    //   8983: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8986: istore 14
    //   8988: iload 14
    //   8990: ifne +25 -> 9015
    //   8993: new 1744	java/math/BigInteger
    //   8996: dup
    //   8997: aload 5
    //   8999: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9002: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   9005: lstore 21
    //   9007: goto +11 -> 9018
    //   9010: astore 5
    //   9012: goto +173 -> 9185
    //   9015: lconst_0
    //   9016: lstore 21
    //   9018: aload 41
    //   9020: ldc_w 1752
    //   9023: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9026: astore 5
    //   9028: aload 5
    //   9030: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9033: ifne +20 -> 9053
    //   9036: new 1744	java/math/BigInteger
    //   9039: dup
    //   9040: aload 5
    //   9042: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9045: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   9048: lstore 23
    //   9050: goto +6 -> 9056
    //   9053: lconst_0
    //   9054: lstore 23
    //   9056: aload 41
    //   9058: ldc_w 1754
    //   9061: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9064: astore 5
    //   9066: aload 5
    //   9068: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9071: ifne +20 -> 9091
    //   9074: new 1744	java/math/BigInteger
    //   9077: dup
    //   9078: aload 5
    //   9080: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9083: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   9086: lstore 25
    //   9088: goto +6 -> 9094
    //   9091: lconst_0
    //   9092: lstore 25
    //   9094: aload 41
    //   9096: ldc_w 1756
    //   9099: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9102: lstore 27
    //   9104: aload 41
    //   9106: ldc_w 1058
    //   9109: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9112: istore 8
    //   9114: lload 21
    //   9116: lstore 29
    //   9118: aload_1
    //   9119: astore 34
    //   9121: aload_2
    //   9122: astore 35
    //   9124: lload 23
    //   9126: lstore 21
    //   9128: lload 25
    //   9130: lstore 23
    //   9132: lload 29
    //   9134: lstore 25
    //   9136: aload 4
    //   9138: astore 31
    //   9140: goto +167 -> 9307
    //   9143: astore 31
    //   9145: lload 23
    //   9147: lstore 29
    //   9149: lload 25
    //   9151: lstore 23
    //   9153: goto +56 -> 9209
    //   9156: astore 5
    //   9158: lload 23
    //   9160: lstore 29
    //   9162: lload 25
    //   9164: lstore 23
    //   9166: goto +36 -> 9202
    //   9169: astore 5
    //   9171: lload 23
    //   9173: lstore 29
    //   9175: goto +24 -> 9199
    //   9178: astore 5
    //   9180: goto +16 -> 9196
    //   9183: astore 5
    //   9185: goto +8 -> 9193
    //   9188: astore 5
    //   9190: lconst_0
    //   9191: lstore 19
    //   9193: lconst_0
    //   9194: lstore 21
    //   9196: lconst_0
    //   9197: lstore 29
    //   9199: lconst_0
    //   9200: lstore 23
    //   9202: lconst_0
    //   9203: lstore 27
    //   9205: aload 5
    //   9207: astore 31
    //   9209: aload 4
    //   9211: astore 34
    //   9213: aload 33
    //   9215: astore 4
    //   9217: aload_2
    //   9218: astore 5
    //   9220: aload 34
    //   9222: astore_2
    //   9223: lload 21
    //   9225: lstore 25
    //   9227: lload 29
    //   9229: lstore 21
    //   9231: goto +54 -> 9285
    //   9234: astore 4
    //   9236: goto +12 -> 9248
    //   9239: astore 5
    //   9241: aload 4
    //   9243: astore_1
    //   9244: aload 5
    //   9246: astore 4
    //   9248: aload 4
    //   9250: astore 31
    //   9252: aload_2
    //   9253: astore 5
    //   9255: goto +8 -> 9263
    //   9258: astore 31
    //   9260: aload 4
    //   9262: astore_1
    //   9263: ldc 230
    //   9265: astore 4
    //   9267: aload 4
    //   9269: astore_2
    //   9270: lconst_0
    //   9271: lstore 19
    //   9273: lconst_0
    //   9274: lstore 25
    //   9276: lconst_0
    //   9277: lstore 21
    //   9279: lconst_0
    //   9280: lstore 23
    //   9282: lconst_0
    //   9283: lstore 27
    //   9285: aload 31
    //   9287: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   9290: iconst_0
    //   9291: istore 8
    //   9293: aload_2
    //   9294: astore 31
    //   9296: aload 5
    //   9298: astore 35
    //   9300: aload_1
    //   9301: astore 34
    //   9303: aload 4
    //   9305: astore 33
    //   9307: aload 41
    //   9309: ldc_w 1758
    //   9312: lconst_1
    //   9313: invokevirtual 842	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   9316: lstore 29
    //   9318: aload 41
    //   9320: ldc_w 1455
    //   9323: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9326: istore 9
    //   9328: aload 41
    //   9330: ldc_w 1760
    //   9333: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9336: istore 12
    //   9338: aload 41
    //   9340: ldc_w 1762
    //   9343: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9346: astore 39
    //   9348: aload 41
    //   9350: ldc_w 837
    //   9353: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9356: istore 7
    //   9358: aload 41
    //   9360: ldc_w 577
    //   9363: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9366: astore 42
    //   9368: aload 41
    //   9370: ldc_w 1764
    //   9373: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9376: astore_2
    //   9377: ldc_w 1742
    //   9380: astore_1
    //   9381: new 369	java/lang/String
    //   9384: dup
    //   9385: aload_2
    //   9386: iconst_0
    //   9387: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9390: invokespecial 695	java/lang/String:<init>	([B)V
    //   9393: astore 4
    //   9395: aload 41
    //   9397: ldc_w 829
    //   9400: iconst_1
    //   9401: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9404: istore 6
    //   9406: ldc_w 1766
    //   9409: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   9412: checkcast 1766	com/tencent/mobileqq/kandian/biz/feeds/api/IArticleInfoFactory
    //   9415: invokeinterface 1770 1 0
    //   9420: astore 43
    //   9422: aload 43
    //   9424: lload 25
    //   9426: putfield 1775	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   9429: aload 43
    //   9431: aload 35
    //   9433: putfield 1778	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   9436: aload 43
    //   9438: aload 34
    //   9440: putfield 1781	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   9443: aload 43
    //   9445: aload 39
    //   9447: putfield 1784	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   9450: aload 43
    //   9452: iload 7
    //   9454: putfield 1787	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   9457: aload 43
    //   9459: lload 19
    //   9461: putfield 1790	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   9464: aload 43
    //   9466: aload 4
    //   9468: putfield 1793	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   9471: aload 43
    //   9473: lload 23
    //   9475: putfield 1795	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:businessId	J
    //   9478: aload 43
    //   9480: iload 6
    //   9482: putfield 1798	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedType	I
    //   9485: aload 41
    //   9487: ldc_w 1800
    //   9490: invokevirtual 1803	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9493: astore_2
    //   9494: goto +10 -> 9504
    //   9497: astore_2
    //   9498: aload_2
    //   9499: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   9502: aconst_null
    //   9503: astore_2
    //   9504: aload 43
    //   9506: new 1807	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo
    //   9509: dup
    //   9510: invokespecial 1808	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:<init>	()V
    //   9513: putfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9516: aload 43
    //   9518: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9521: new 1814	com/tencent/mobileqq/kandian/repo/handler/BiuInfo
    //   9524: dup
    //   9525: invokespecial 1815	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:<init>	()V
    //   9528: putfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   9531: aload 43
    //   9533: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9536: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   9539: lload 21
    //   9541: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9544: putfield 1822	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:b	Ljava/lang/Long;
    //   9547: aload 43
    //   9549: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9552: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   9555: lload 29
    //   9557: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9560: putfield 1824	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:c	Ljava/lang/Long;
    //   9563: aload 43
    //   9565: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9568: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   9571: new 247	java/util/ArrayList
    //   9574: dup
    //   9575: invokespecial 248	java/util/ArrayList:<init>	()V
    //   9578: putfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   9581: lload 19
    //   9583: lstore 21
    //   9585: lload 25
    //   9587: lstore 23
    //   9589: aload 39
    //   9591: astore 5
    //   9593: aload 4
    //   9595: astore 36
    //   9597: aload_1
    //   9598: astore 37
    //   9600: aload_2
    //   9601: ifnull +288 -> 9889
    //   9604: iconst_0
    //   9605: istore 7
    //   9607: aload_2
    //   9608: astore 38
    //   9610: aload 39
    //   9612: astore_2
    //   9613: lload 19
    //   9615: lstore 21
    //   9617: lload 25
    //   9619: lstore 23
    //   9621: aload_2
    //   9622: astore 5
    //   9624: aload 4
    //   9626: astore 36
    //   9628: aload_1
    //   9629: astore 37
    //   9631: iload 7
    //   9633: aload 38
    //   9635: invokevirtual 591	org/json/JSONArray:length	()I
    //   9638: if_icmpge +251 -> 9889
    //   9641: new 1829	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo
    //   9644: dup
    //   9645: invokespecial 1830	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:<init>	()V
    //   9648: astore 5
    //   9650: aload 38
    //   9652: iload 7
    //   9654: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9657: astore 36
    //   9659: aload 5
    //   9661: aload 36
    //   9663: aload 40
    //   9665: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9668: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9671: putfield 1837	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mUin	Ljava/lang/Long;
    //   9674: aload 5
    //   9676: new 369	java/lang/String
    //   9679: dup
    //   9680: aload 36
    //   9682: ldc_w 1839
    //   9685: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9688: iconst_0
    //   9689: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9692: invokespecial 695	java/lang/String:<init>	([B)V
    //   9695: putfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   9698: aload 5
    //   9700: aload 5
    //   9702: getfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   9705: putfield 1845	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   9708: aload 5
    //   9710: aload 36
    //   9712: ldc_w 1847
    //   9715: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9718: putfield 1850	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuTime	I
    //   9721: aload 5
    //   9723: aload 36
    //   9725: ldc_w 709
    //   9728: iconst_1
    //   9729: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9732: putfield 1853	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedsType	I
    //   9735: aload 5
    //   9737: aload 36
    //   9739: ldc_w 1855
    //   9742: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9745: putfield 1858	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOpType	I
    //   9748: aload 36
    //   9750: ldc_w 1860
    //   9753: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9756: astore 37
    //   9758: aload 36
    //   9760: ldc_w 1862
    //   9763: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9766: astore 39
    //   9768: aload 37
    //   9770: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9773: ifne +42 -> 9815
    //   9776: aload 39
    //   9778: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9781: ifne +34 -> 9815
    //   9784: aload 5
    //   9786: new 1864	com/tencent/mobileqq/kandian/repo/handler/JumpInfo
    //   9789: dup
    //   9790: lconst_0
    //   9791: new 369	java/lang/String
    //   9794: dup
    //   9795: aload 37
    //   9797: iconst_0
    //   9798: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9801: invokespecial 695	java/lang/String:<init>	([B)V
    //   9804: aload 39
    //   9806: invokespecial 1867	com/tencent/mobileqq/kandian/repo/handler/JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   9809: putfield 1871	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:jumpInfo	Lcom/tencent/mobileqq/kandian/repo/handler/JumpInfo;
    //   9812: goto +3 -> 9815
    //   9815: aload 36
    //   9817: aload_1
    //   9818: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9821: astore 36
    //   9823: aload 36
    //   9825: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9828: ifne +33 -> 9861
    //   9831: aload 5
    //   9833: new 1744	java/math/BigInteger
    //   9836: dup
    //   9837: aload 36
    //   9839: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9842: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   9845: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9848: putfield 1873	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   9851: goto +10 -> 9861
    //   9854: astore 36
    //   9856: aload 36
    //   9858: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   9861: aload 43
    //   9863: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9866: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   9869: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   9872: aload 5
    //   9874: invokeinterface 1876 2 0
    //   9879: pop
    //   9880: iload 7
    //   9882: iconst_1
    //   9883: iadd
    //   9884: istore 7
    //   9886: goto -273 -> 9613
    //   9889: aload 5
    //   9891: astore_1
    //   9892: aload 41
    //   9894: ldc_w 1878
    //   9897: invokevirtual 518	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9900: astore_2
    //   9901: aload_2
    //   9902: ifnull +4444 -> 14346
    //   9905: ldc_w 1880
    //   9908: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   9911: checkcast 1880	com/tencent/mobileqq/kandian/repo/common/api/IRIJItemViewTypeUtils
    //   9914: iload 6
    //   9916: lload 29
    //   9918: invokeinterface 1884 4 0
    //   9923: ifeq +4423 -> 14346
    //   9926: aload 43
    //   9928: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9931: new 1886	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo
    //   9934: dup
    //   9935: invokespecial 1887	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:<init>	()V
    //   9938: putfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   9941: aload_2
    //   9942: ldc_w 1893
    //   9945: iconst_0
    //   9946: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9949: istore 13
    //   9951: aload_2
    //   9952: ldc_w 1895
    //   9955: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9958: astore 41
    //   9960: aload_2
    //   9961: ldc_w 1897
    //   9964: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9967: astore 38
    //   9969: aload_2
    //   9970: astore 39
    //   9972: iload 6
    //   9974: istore 7
    //   9976: aload_1
    //   9977: astore 5
    //   9979: aload 38
    //   9981: ifnull +321 -> 10302
    //   9984: aload 43
    //   9986: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   9989: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   9992: new 1814	com/tencent/mobileqq/kandian/repo/handler/BiuInfo
    //   9995: dup
    //   9996: invokespecial 1815	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:<init>	()V
    //   9999: putfield 1899	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:h	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   10002: aload 43
    //   10004: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10007: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10010: getfield 1899	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:h	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   10013: new 247	java/util/ArrayList
    //   10016: dup
    //   10017: invokespecial 248	java/util/ArrayList:<init>	()V
    //   10020: putfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   10023: iconst_0
    //   10024: istore 10
    //   10026: aload 40
    //   10028: astore 4
    //   10030: aload_2
    //   10031: astore 39
    //   10033: iload 6
    //   10035: istore 7
    //   10037: aload_1
    //   10038: astore 5
    //   10040: iload 10
    //   10042: aload 38
    //   10044: invokevirtual 591	org/json/JSONArray:length	()I
    //   10047: if_icmpge +255 -> 10302
    //   10050: new 1829	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo
    //   10053: dup
    //   10054: invokespecial 1830	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:<init>	()V
    //   10057: astore 5
    //   10059: aload 38
    //   10061: iload 10
    //   10063: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   10066: astore 39
    //   10068: aload 5
    //   10070: aload 39
    //   10072: aload 4
    //   10074: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   10077: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10080: putfield 1837	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mUin	Ljava/lang/Long;
    //   10083: aload 5
    //   10085: new 369	java/lang/String
    //   10088: dup
    //   10089: aload 39
    //   10091: ldc_w 1839
    //   10094: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10097: iconst_0
    //   10098: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   10101: invokespecial 695	java/lang/String:<init>	([B)V
    //   10104: putfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   10107: aload 5
    //   10109: aload 5
    //   10111: getfield 1842	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   10114: putfield 1845	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   10117: aload 5
    //   10119: aload 39
    //   10121: ldc_w 1847
    //   10124: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10127: putfield 1850	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuTime	I
    //   10130: aload 5
    //   10132: aload 39
    //   10134: ldc_w 709
    //   10137: iconst_1
    //   10138: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   10141: putfield 1853	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedsType	I
    //   10144: aload 5
    //   10146: aload 39
    //   10148: ldc_w 1855
    //   10151: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10154: putfield 1858	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOpType	I
    //   10157: aload 39
    //   10159: ldc_w 1860
    //   10162: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10165: astore 40
    //   10167: aload 39
    //   10169: ldc_w 1862
    //   10172: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10175: astore 44
    //   10177: aload 40
    //   10179: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10182: ifne +42 -> 10224
    //   10185: aload 44
    //   10187: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10190: ifne +34 -> 10224
    //   10193: aload 5
    //   10195: new 1864	com/tencent/mobileqq/kandian/repo/handler/JumpInfo
    //   10198: dup
    //   10199: lconst_0
    //   10200: new 369	java/lang/String
    //   10203: dup
    //   10204: aload 40
    //   10206: iconst_0
    //   10207: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   10210: invokespecial 695	java/lang/String:<init>	([B)V
    //   10213: aload 44
    //   10215: invokespecial 1867	com/tencent/mobileqq/kandian/repo/handler/JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   10218: putfield 1871	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:jumpInfo	Lcom/tencent/mobileqq/kandian/repo/handler/JumpInfo;
    //   10221: goto +3 -> 10224
    //   10224: aload 39
    //   10226: aload 37
    //   10228: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10231: astore 39
    //   10233: aload 39
    //   10235: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10238: ifne +33 -> 10271
    //   10241: aload 5
    //   10243: new 1744	java/math/BigInteger
    //   10246: dup
    //   10247: aload 39
    //   10249: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   10252: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   10255: invokestatic 1082	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10258: putfield 1873	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   10261: goto +10 -> 10271
    //   10264: astore 39
    //   10266: aload 39
    //   10268: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   10271: aload 43
    //   10273: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10276: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10279: getfield 1899	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:h	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   10282: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   10285: aload 5
    //   10287: invokeinterface 1876 2 0
    //   10292: pop
    //   10293: iload 10
    //   10295: iconst_1
    //   10296: iadd
    //   10297: istore 10
    //   10299: goto -269 -> 10030
    //   10302: aload 43
    //   10304: new 369	java/lang/String
    //   10307: dup
    //   10308: aload 41
    //   10310: iconst_0
    //   10311: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   10314: invokespecial 695	java/lang/String:<init>	([B)V
    //   10317: putfield 1778	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   10320: ldc 230
    //   10322: astore_1
    //   10323: aload 43
    //   10325: aload_1
    //   10326: putfield 1793	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   10329: iload 13
    //   10331: iconst_3
    //   10332: if_icmpeq +114 -> 10446
    //   10335: iload 13
    //   10337: iconst_2
    //   10338: if_icmpne +3971 -> 14309
    //   10341: goto +105 -> 10446
    //   10344: iload 13
    //   10346: iconst_1
    //   10347: if_icmpne +3977 -> 14324
    //   10350: aload 43
    //   10352: aload_1
    //   10353: putfield 1784	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   10356: goto +3968 -> 14324
    //   10359: aload 43
    //   10361: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10364: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10367: new 247	java/util/ArrayList
    //   10370: dup
    //   10371: invokespecial 248	java/util/ArrayList:<init>	()V
    //   10374: putfield 1901	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:c	Ljava/util/ArrayList;
    //   10377: new 1903	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo
    //   10380: dup
    //   10381: invokespecial 1904	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:<init>	()V
    //   10384: astore_1
    //   10385: aload 39
    //   10387: ldc_w 1906
    //   10390: invokevirtual 518	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10393: astore_2
    //   10394: aload_2
    //   10395: ifnull +3936 -> 14331
    //   10398: aload_1
    //   10399: aload_2
    //   10400: ldc_w 1908
    //   10403: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10406: putfield 1910	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:d	Ljava/lang/String;
    //   10409: aload_1
    //   10410: aload_2
    //   10411: ldc_w 1912
    //   10414: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10417: i2l
    //   10418: putfield 1914	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:g	J
    //   10421: aload_1
    //   10422: aload 35
    //   10424: putfield 1916	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:e	Ljava/lang/String;
    //   10427: aload 43
    //   10429: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10432: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10435: getfield 1901	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:c	Ljava/util/ArrayList;
    //   10438: aload_1
    //   10439: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10442: pop
    //   10443: goto +3888 -> 14331
    //   10446: aload 43
    //   10448: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10451: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10454: new 247	java/util/ArrayList
    //   10457: dup
    //   10458: invokespecial 248	java/util/ArrayList:<init>	()V
    //   10461: putfield 1918	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   10464: new 1920	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo
    //   10467: dup
    //   10468: invokespecial 1921	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo:<init>	()V
    //   10471: astore_1
    //   10472: aload 39
    //   10474: ldc_w 1923
    //   10477: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10480: astore_2
    //   10481: aload_2
    //   10482: ifnull +3855 -> 14337
    //   10485: aload_2
    //   10486: invokevirtual 591	org/json/JSONArray:length	()I
    //   10489: ifle +3848 -> 14337
    //   10492: aload_1
    //   10493: aload_2
    //   10494: iconst_0
    //   10495: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   10498: ldc_w 1925
    //   10501: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10504: putfield 1926	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo:e	Ljava/lang/String;
    //   10507: aload 43
    //   10509: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10512: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10515: getfield 1918	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   10518: aload_1
    //   10519: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10522: pop
    //   10523: goto +3814 -> 14337
    //   10526: iload 12
    //   10528: bipush 22
    //   10530: if_icmpne +3813 -> 14343
    //   10533: new 1928	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo
    //   10536: dup
    //   10537: invokespecial 1929	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:<init>	()V
    //   10540: astore_1
    //   10541: aload_1
    //   10542: aload 34
    //   10544: putfield 1931	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:c	Ljava/lang/String;
    //   10547: aload_1
    //   10548: aload 5
    //   10550: putfield 1932	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:d	Ljava/lang/String;
    //   10553: aload_1
    //   10554: aload 36
    //   10556: putfield 1933	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:e	Ljava/lang/String;
    //   10559: aload_1
    //   10560: lload 27
    //   10562: putfield 1935	com/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo:a	J
    //   10565: aload 43
    //   10567: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10570: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10573: aload_1
    //   10574: putfield 1939	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:k	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AccountProfileInfo;
    //   10577: goto +3 -> 10580
    //   10580: aload 43
    //   10582: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10585: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10588: iload 13
    //   10590: putfield 1941	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:a	I
    //   10593: aload 43
    //   10595: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10598: getfield 1891	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:s	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   10601: aload 43
    //   10603: getfield 1778	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   10606: putfield 1943	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:f	Ljava/lang/String;
    //   10609: aload 41
    //   10611: astore_1
    //   10612: goto +3 -> 10615
    //   10615: iload 12
    //   10617: istore 9
    //   10619: aload 43
    //   10621: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10624: ldc 230
    //   10626: putfield 1944	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:e	Ljava/lang/String;
    //   10629: aload 43
    //   10631: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10634: ldc 230
    //   10636: putfield 1946	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:g	Ljava/lang/String;
    //   10639: aload 43
    //   10641: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10644: ldc 230
    //   10646: putfield 1947	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:f	Ljava/lang/String;
    //   10649: new 316	android/content/Intent
    //   10652: dup
    //   10653: aload_0
    //   10654: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   10657: ldc_w 1949
    //   10660: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   10663: checkcast 1949	com/tencent/mobileqq/kandian/biz/ugc/api/IRIJDeliverUGCUtils
    //   10666: invokeinterface 1952 1 0
    //   10671: invokespecial 748	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   10674: astore_2
    //   10675: aload_2
    //   10676: ldc_w 1954
    //   10679: aload 43
    //   10681: invokevirtual 1957	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   10684: pop
    //   10685: aload 31
    //   10687: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10690: ifne +3670 -> 14360
    //   10693: aload_2
    //   10694: ldc_w 1959
    //   10697: aload 31
    //   10699: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10702: pop
    //   10703: goto +3 -> 10706
    //   10706: aload_2
    //   10707: ldc_w 1961
    //   10710: iload 9
    //   10712: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10715: pop
    //   10716: aload_2
    //   10717: ldc_w 1963
    //   10720: iload 6
    //   10722: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10725: pop
    //   10726: aload_2
    //   10727: ldc_w 1965
    //   10730: aload 42
    //   10732: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10735: pop
    //   10736: iconst_3
    //   10737: istore 6
    //   10739: iload 9
    //   10741: iconst_5
    //   10742: if_icmpne +3621 -> 14363
    //   10745: iconst_4
    //   10746: istore 6
    //   10748: goto +3 -> 10751
    //   10751: aload_2
    //   10752: ldc_w 1967
    //   10755: iload 6
    //   10757: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10760: pop
    //   10761: aload_2
    //   10762: ldc_w 1969
    //   10765: aload 33
    //   10767: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10770: pop
    //   10771: aload_2
    //   10772: ldc_w 829
    //   10775: iload 7
    //   10777: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10780: pop
    //   10781: aload_2
    //   10782: ldc_w 1971
    //   10785: aload_1
    //   10786: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10789: pop
    //   10790: aload_2
    //   10791: ldc_w 1973
    //   10794: lload 27
    //   10796: invokevirtual 1976	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   10799: pop
    //   10800: aload_2
    //   10801: ldc_w 1978
    //   10804: iload 8
    //   10806: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10809: pop
    //   10810: aload_2
    //   10811: ldc_w 1980
    //   10814: aload 32
    //   10816: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10819: pop
    //   10820: iload 9
    //   10822: bipush 23
    //   10824: if_icmpne +3611 -> 14435
    //   10827: aload 32
    //   10829: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10832: ifne +17 -> 10849
    //   10835: aload 43
    //   10837: getfield 1781	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   10840: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10843: ifeq +3589 -> 14432
    //   10846: goto +3 -> 10849
    //   10849: ldc 45
    //   10851: iconst_1
    //   10852: ldc_w 1982
    //   10855: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10858: iconst_0
    //   10859: ireturn
    //   10860: iload 11
    //   10862: iconst_1
    //   10863: if_icmpne +184 -> 11047
    //   10866: aload 43
    //   10868: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10871: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   10874: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   10877: ifnull +3561 -> 14438
    //   10880: aload 43
    //   10882: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   10885: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   10888: getfield 1827	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:a	Ljava/util/List;
    //   10891: invokeinterface 1983 1 0
    //   10896: ifle +3542 -> 14438
    //   10899: new 537	java/lang/StringBuilder
    //   10902: dup
    //   10903: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   10906: astore_1
    //   10907: aload_1
    //   10908: aload_3
    //   10909: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10912: pop
    //   10913: aload_1
    //   10914: ldc_w 1985
    //   10917: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10920: pop
    //   10921: aload_1
    //   10922: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10925: astore_1
    //   10926: goto +3 -> 10929
    //   10929: aload_1
    //   10930: astore_2
    //   10931: aload_1
    //   10932: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10935: ifeq +7 -> 10942
    //   10938: ldc_w 1987
    //   10941: astore_2
    //   10942: new 537	java/lang/StringBuilder
    //   10945: dup
    //   10946: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   10949: astore_1
    //   10950: aload_1
    //   10951: ldc_w 1989
    //   10954: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10957: pop
    //   10958: aload_1
    //   10959: aload_2
    //   10960: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10963: pop
    //   10964: aload_1
    //   10965: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10968: astore_1
    //   10969: aload_0
    //   10970: getfield 2004	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:app	Lcom/tencent/common/app/AppInterface;
    //   10973: checkcast 2006	com/tencent/mobileqq/app/BrowserAppInterface
    //   10976: invokevirtual 2009	com/tencent/mobileqq/app/BrowserAppInterface:c	()Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManager;
    //   10979: astore_2
    //   10980: invokestatic 1994	com/tencent/mobileqq/kandian/repo/feeds/ReadInJoyLogicEngineEventDispatcher:a	()Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyLogicEngineEventDispatcher;
    //   10983: new 1996	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver
    //   10986: dup
    //   10987: aload_0
    //   10988: aload 42
    //   10990: iload 7
    //   10992: invokespecial 1999	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;I)V
    //   10995: invokevirtual 2002	com/tencent/mobileqq/kandian/repo/feeds/ReadInJoyLogicEngineEventDispatcher:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;)V
    //   10998: aload_2
    //   10999: invokeinterface 2015 1 0
    //   11004: aload_0
    //   11005: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11008: invokevirtual 1676	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   11011: invokevirtual 2018	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   11014: lload 21
    //   11016: aload 43
    //   11018: getfield 1812	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   11021: getfield 1819	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:n	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   11024: lconst_0
    //   11025: aload_1
    //   11026: lload 23
    //   11028: ldc2_w 838
    //   11031: iload 6
    //   11033: aload 31
    //   11035: iload 7
    //   11037: aload 43
    //   11039: invokeinterface 2023 17 0
    //   11044: goto +3051 -> 14095
    //   11047: aload_0
    //   11048: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11051: aload_2
    //   11052: bipush 113
    //   11054: invokevirtual 815	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   11057: aload_0
    //   11058: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11061: iconst_0
    //   11062: iconst_0
    //   11063: invokevirtual 2039	android/app/Activity:overridePendingTransition	(II)V
    //   11066: goto +3029 -> 14095
    //   11069: astore_1
    //   11070: goto +8 -> 11078
    //   11073: astore_1
    //   11074: goto +4 -> 11078
    //   11077: astore_1
    //   11078: aload_1
    //   11079: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   11082: goto +3013 -> 14095
    //   11085: goto +3010 -> 14095
    //   11088: ldc 230
    //   11090: astore_1
    //   11091: ldc_w 2050
    //   11094: aload 4
    //   11096: invokevirtual 1190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   11099: ifeq +56 -> 11155
    //   11102: aload 5
    //   11104: ifnull +2991 -> 14095
    //   11107: aload 5
    //   11109: arraylength
    //   11110: ifle +2985 -> 14095
    //   11113: aload_3
    //   11114: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11117: instanceof 2048
    //   11120: ifeq +2975 -> 14095
    //   11123: ldc_w 2052
    //   11126: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   11129: checkcast 2052	com/tencent/mobileqq/kandian/biz/account/api/IRIJUserProtoUtils
    //   11132: aload_3
    //   11133: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11136: new 2054	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$6
    //   11139: dup
    //   11140: aload_3
    //   11141: aload 5
    //   11143: invokespecial 2057	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$6:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;[Ljava/lang/String;)V
    //   11146: invokeinterface 2061 3 0
    //   11151: pop
    //   11152: goto +2943 -> 14095
    //   11155: ldc_w 2063
    //   11158: aload 4
    //   11160: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11163: ifeq +106 -> 11269
    //   11166: new 353	org/json/JSONObject
    //   11169: dup
    //   11170: aload 5
    //   11172: iconst_0
    //   11173: aaload
    //   11174: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11177: astore_1
    //   11178: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11181: ifeq +2914 -> 14095
    //   11184: new 537	java/lang/StringBuilder
    //   11187: dup
    //   11188: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   11191: astore_2
    //   11192: aload_2
    //   11193: ldc_w 2065
    //   11196: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11199: pop
    //   11200: aload_2
    //   11201: aload_1
    //   11202: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11205: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11208: pop
    //   11209: ldc_w 2067
    //   11212: iconst_2
    //   11213: aload_2
    //   11214: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11217: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11220: goto +2875 -> 14095
    //   11223: astore_1
    //   11224: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11227: ifeq +2868 -> 14095
    //   11230: new 537	java/lang/StringBuilder
    //   11233: dup
    //   11234: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   11237: astore_2
    //   11238: aload_2
    //   11239: ldc_w 2069
    //   11242: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11245: pop
    //   11246: aload_2
    //   11247: aload_1
    //   11248: invokevirtual 1131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   11251: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11254: pop
    //   11255: ldc_w 2067
    //   11258: iconst_2
    //   11259: aload_2
    //   11260: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11263: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11266: goto +2829 -> 14095
    //   11269: ldc_w 2071
    //   11272: aload 4
    //   11274: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11277: ifeq +35 -> 11312
    //   11280: ldc_w 2052
    //   11283: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   11286: checkcast 2052	com/tencent/mobileqq/kandian/biz/account/api/IRIJUserProtoUtils
    //   11289: aload_3
    //   11290: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11293: new 2073	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$7
    //   11296: dup
    //   11297: aload_3
    //   11298: aload 5
    //   11300: invokespecial 2074	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$7:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;[Ljava/lang/String;)V
    //   11303: invokeinterface 2061 3 0
    //   11308: pop
    //   11309: goto +2786 -> 14095
    //   11312: ldc_w 2076
    //   11315: aload 4
    //   11317: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11320: ifeq +62 -> 11382
    //   11323: new 353	org/json/JSONObject
    //   11326: dup
    //   11327: aload 5
    //   11329: iconst_0
    //   11330: aaload
    //   11331: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11334: ldc_w 2078
    //   11337: invokevirtual 2080	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11340: astore_1
    //   11341: aload_1
    //   11342: invokestatic 326	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11345: ifeq +21 -> 11366
    //   11348: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11351: ifeq +2744 -> 14095
    //   11354: ldc 45
    //   11356: iconst_2
    //   11357: ldc_w 2082
    //   11360: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11363: goto +2732 -> 14095
    //   11366: aload_3
    //   11367: aload_1
    //   11368: invokespecial 2084	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sharePictureToWeChat	(Ljava/lang/String;)V
    //   11371: goto +2724 -> 14095
    //   11374: astore_1
    //   11375: aload_1
    //   11376: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   11379: goto +2716 -> 14095
    //   11382: ldc_w 2086
    //   11385: aload 4
    //   11387: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11390: ifeq +109 -> 11499
    //   11393: new 353	org/json/JSONObject
    //   11396: dup
    //   11397: aload 5
    //   11399: iconst_0
    //   11400: aaload
    //   11401: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11404: astore_1
    //   11405: aload_1
    //   11406: ldc_w 2088
    //   11409: invokevirtual 2091	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11412: istore 6
    //   11414: aload_1
    //   11415: ldc_w 2093
    //   11418: invokevirtual 2091	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11421: istore 7
    //   11423: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11426: ifeq +51 -> 11477
    //   11429: new 537	java/lang/StringBuilder
    //   11432: dup
    //   11433: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   11436: astore_1
    //   11437: aload_1
    //   11438: ldc_w 2095
    //   11441: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11444: pop
    //   11445: aload_1
    //   11446: iload 6
    //   11448: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11451: pop
    //   11452: aload_1
    //   11453: ldc_w 2097
    //   11456: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11459: pop
    //   11460: aload_1
    //   11461: iload 7
    //   11463: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11466: pop
    //   11467: ldc 45
    //   11469: iconst_2
    //   11470: aload_1
    //   11471: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11474: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11477: aload_3
    //   11478: getfield 209	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11481: iload 6
    //   11483: iload 7
    //   11485: invokevirtual 2098	com/tencent/biz/troop/TroopMemberApiClient:a	(II)V
    //   11488: goto +2607 -> 14095
    //   11491: astore_1
    //   11492: aload_1
    //   11493: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   11496: goto +2599 -> 14095
    //   11499: ldc_w 2100
    //   11502: aload 4
    //   11504: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11507: ifeq +567 -> 12074
    //   11510: new 353	org/json/JSONObject
    //   11513: dup
    //   11514: aload 5
    //   11516: iconst_0
    //   11517: aaload
    //   11518: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11521: astore 4
    //   11523: aload 4
    //   11525: ldc_w 2102
    //   11528: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11531: ifeq +2912 -> 14443
    //   11534: aload 4
    //   11536: ldc_w 2102
    //   11539: invokevirtual 852	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11542: istore 14
    //   11544: goto +3 -> 11547
    //   11547: aload 4
    //   11549: ldc_w 858
    //   11552: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11555: ifeq +2894 -> 14449
    //   11558: aload 4
    //   11560: ldc_w 858
    //   11563: invokevirtual 852	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11566: istore 15
    //   11568: goto +3 -> 11571
    //   11571: aload 4
    //   11573: ldc_w 2104
    //   11576: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11579: ifeq +2876 -> 14455
    //   11582: aload 4
    //   11584: ldc_w 2104
    //   11587: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11590: astore_2
    //   11591: new 537	java/lang/StringBuilder
    //   11594: dup
    //   11595: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   11598: astore_3
    //   11599: aload_3
    //   11600: ldc_w 2106
    //   11603: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11606: pop
    //   11607: aload_3
    //   11608: aload_2
    //   11609: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11612: pop
    //   11613: ldc 45
    //   11615: iconst_2
    //   11616: aload_3
    //   11617: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11620: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11623: new 369	java/lang/String
    //   11626: dup
    //   11627: aload_2
    //   11628: iconst_0
    //   11629: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   11632: invokespecial 695	java/lang/String:<init>	([B)V
    //   11635: astore_3
    //   11636: aload_3
    //   11637: astore_2
    //   11638: goto +8 -> 11646
    //   11641: astore_3
    //   11642: aload_3
    //   11643: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   11646: new 537	java/lang/StringBuilder
    //   11649: dup
    //   11650: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   11653: astore_3
    //   11654: aload_3
    //   11655: ldc_w 2108
    //   11658: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11661: pop
    //   11662: aload_3
    //   11663: aload_2
    //   11664: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11667: pop
    //   11668: ldc 45
    //   11670: iconst_2
    //   11671: aload_3
    //   11672: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11675: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11678: goto +3 -> 11681
    //   11681: aload 4
    //   11683: ldc_w 2110
    //   11686: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11689: ifeq +35 -> 11724
    //   11692: aload 4
    //   11694: ldc_w 2110
    //   11697: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11700: astore_1
    //   11701: new 369	java/lang/String
    //   11704: dup
    //   11705: aload_1
    //   11706: iconst_0
    //   11707: invokestatic 692	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   11710: invokespecial 695	java/lang/String:<init>	([B)V
    //   11713: astore_3
    //   11714: aload_3
    //   11715: astore_1
    //   11716: goto +8 -> 11724
    //   11719: astore_3
    //   11720: aload_3
    //   11721: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   11724: aload 4
    //   11726: ldc_w 2112
    //   11729: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11732: ifeq +2728 -> 14460
    //   11735: aload 4
    //   11737: ldc_w 2112
    //   11740: iconst_m1
    //   11741: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11744: istore 6
    //   11746: goto +3 -> 11749
    //   11749: aload 4
    //   11751: ldc_w 2114
    //   11754: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11757: ifeq +2709 -> 14466
    //   11760: aload 4
    //   11762: ldc_w 2114
    //   11765: iconst_0
    //   11766: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11769: istore 7
    //   11771: goto +3 -> 11774
    //   11774: aload 4
    //   11776: ldc_w 1374
    //   11779: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11782: ifeq +2690 -> 14472
    //   11785: aload 4
    //   11787: ldc_w 1374
    //   11790: iconst_0
    //   11791: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11794: istore 8
    //   11796: goto +3 -> 11799
    //   11799: aload 4
    //   11801: ldc_w 577
    //   11804: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11807: astore 5
    //   11809: aload 4
    //   11811: ldc_w 2116
    //   11814: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11817: astore 31
    //   11819: aload 4
    //   11821: ldc_w 2118
    //   11824: iconst_0
    //   11825: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11828: istore 9
    //   11830: new 316	android/content/Intent
    //   11833: dup
    //   11834: invokespecial 595	android/content/Intent:<init>	()V
    //   11837: astore_3
    //   11838: aload 4
    //   11840: ldc_w 2120
    //   11843: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11846: istore 16
    //   11848: iload 16
    //   11850: ifeq +22 -> 11872
    //   11853: aload_3
    //   11854: ldc_w 2120
    //   11857: aload 4
    //   11859: ldc_w 2120
    //   11862: invokevirtual 852	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11865: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11868: pop
    //   11869: goto +3 -> 11872
    //   11872: new 537	java/lang/StringBuilder
    //   11875: dup
    //   11876: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   11879: astore 32
    //   11881: aload 32
    //   11883: ldc_w 2122
    //   11886: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11889: pop
    //   11890: aload 32
    //   11892: aload 4
    //   11894: ldc_w 2120
    //   11897: iconst_0
    //   11898: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   11901: invokevirtual 1512	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11904: pop
    //   11905: ldc 45
    //   11907: iconst_2
    //   11908: aload 32
    //   11910: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11913: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11916: aload_3
    //   11917: ldc_w 2124
    //   11920: iconst_0
    //   11921: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11924: pop
    //   11925: aload_3
    //   11926: ldc_w 2126
    //   11929: iload 14
    //   11931: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11934: pop
    //   11935: aload_3
    //   11936: ldc_w 2104
    //   11939: aload_2
    //   11940: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11943: pop
    //   11944: aload_3
    //   11945: ldc_w 2110
    //   11948: aload_1
    //   11949: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11952: pop
    //   11953: aload_3
    //   11954: ldc_w 2112
    //   11957: iload 6
    //   11959: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11962: pop
    //   11963: aload_3
    //   11964: ldc_w 2114
    //   11967: iload 7
    //   11969: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11972: pop
    //   11973: aload_3
    //   11974: ldc_w 1374
    //   11977: iload 8
    //   11979: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11982: pop
    //   11983: aload_3
    //   11984: ldc_w 314
    //   11987: aload 5
    //   11989: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11992: pop
    //   11993: aload_3
    //   11994: ldc_w 2128
    //   11997: iload 9
    //   11999: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12002: pop
    //   12003: aload_3
    //   12004: ldc_w 2130
    //   12007: iload 15
    //   12009: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12012: pop
    //   12013: aload_3
    //   12014: ldc_w 2132
    //   12017: iconst_1
    //   12018: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12021: pop
    //   12022: aload 31
    //   12024: ifnull +16 -> 12040
    //   12027: aload_3
    //   12028: ldc_w 2134
    //   12031: aload 31
    //   12033: invokevirtual 2135	org/json/JSONArray:toString	()Ljava/lang/String;
    //   12036: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12039: pop
    //   12040: ldc_w 2137
    //   12043: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   12046: checkcast 2137	com/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentEntranceUtils
    //   12049: astore_1
    //   12050: aload_1
    //   12051: aload_0
    //   12052: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   12055: aload_3
    //   12056: bipush 117
    //   12058: invokeinterface 2141 4 0
    //   12063: goto +2032 -> 14095
    //   12066: astore_1
    //   12067: aload_1
    //   12068: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   12071: goto +2024 -> 14095
    //   12074: ldc_w 2142
    //   12077: aload 4
    //   12079: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12082: ifeq +14 -> 12096
    //   12085: aload_3
    //   12086: aload 5
    //   12088: iconst_0
    //   12089: aaload
    //   12090: invokespecial 2144	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showPicture	(Ljava/lang/String;)V
    //   12093: goto +2002 -> 14095
    //   12096: ldc_w 2146
    //   12099: aload 4
    //   12101: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12104: ifeq +124 -> 12228
    //   12107: new 353	org/json/JSONObject
    //   12110: dup
    //   12111: aload 5
    //   12113: iconst_0
    //   12114: aaload
    //   12115: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12118: ldc_w 577
    //   12121: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12124: astore_2
    //   12125: new 316	android/content/Intent
    //   12128: dup
    //   12129: invokespecial 595	android/content/Intent:<init>	()V
    //   12132: astore_1
    //   12133: aload_1
    //   12134: ldc_w 2148
    //   12137: aload 5
    //   12139: iconst_0
    //   12140: aaload
    //   12141: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12144: pop
    //   12145: aload_3
    //   12146: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   12149: aload_1
    //   12150: ldc_w 2150
    //   12153: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   12156: checkcast 2150	com/tencent/mobileqq/kandian/ad/api/IRIJAdService
    //   12159: invokeinterface 2153 1 0
    //   12164: invokestatic 2158	com/tencent/mobileqq/activity/PublicTransFragmentActivity:b	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   12167: aload_3
    //   12168: aload_2
    //   12169: iconst_1
    //   12170: anewarray 369	java/lang/String
    //   12173: dup
    //   12174: iconst_0
    //   12175: new 353	org/json/JSONObject
    //   12178: dup
    //   12179: invokespecial 354	org/json/JSONObject:<init>	()V
    //   12182: ldc_w 356
    //   12185: iconst_0
    //   12186: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12189: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12192: aastore
    //   12193: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12196: goto +1899 -> 14095
    //   12199: astore_1
    //   12200: goto +6 -> 12206
    //   12203: astore_1
    //   12204: aconst_null
    //   12205: astore_2
    //   12206: aload_1
    //   12207: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   12210: aload_3
    //   12211: aload_2
    //   12212: iconst_1
    //   12213: anewarray 369	java/lang/String
    //   12216: dup
    //   12217: iconst_0
    //   12218: ldc_w 2160
    //   12221: aastore
    //   12222: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12225: goto +1870 -> 14095
    //   12228: ldc_w 2162
    //   12231: aload 4
    //   12233: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12236: ifeq +149 -> 12385
    //   12239: new 353	org/json/JSONObject
    //   12242: dup
    //   12243: aload 5
    //   12245: iconst_0
    //   12246: aaload
    //   12247: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12250: astore_1
    //   12251: aload_1
    //   12252: ldc_w 577
    //   12255: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12258: astore_2
    //   12259: aload_1
    //   12260: ldc_w 2164
    //   12263: invokevirtual 672	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   12266: astore_1
    //   12267: new 247	java/util/ArrayList
    //   12270: dup
    //   12271: invokespecial 248	java/util/ArrayList:<init>	()V
    //   12274: astore 4
    //   12276: iconst_0
    //   12277: istore 6
    //   12279: iload 6
    //   12281: aload_1
    //   12282: invokevirtual 591	org/json/JSONArray:length	()I
    //   12285: if_icmpge +30 -> 12315
    //   12288: aload 4
    //   12290: aload_1
    //   12291: iload 6
    //   12293: invokevirtual 1834	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   12296: ldc_w 1088
    //   12299: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12302: invokevirtual 743	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   12305: pop
    //   12306: iload 6
    //   12308: iconst_1
    //   12309: iadd
    //   12310: istore 6
    //   12312: goto -33 -> 12279
    //   12315: aload_3
    //   12316: getfield 209	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12319: aload 4
    //   12321: invokevirtual 2166	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/util/ArrayList;)V
    //   12324: aload_3
    //   12325: aload_2
    //   12326: iconst_1
    //   12327: anewarray 369	java/lang/String
    //   12330: dup
    //   12331: iconst_0
    //   12332: new 353	org/json/JSONObject
    //   12335: dup
    //   12336: invokespecial 354	org/json/JSONObject:<init>	()V
    //   12339: ldc_w 356
    //   12342: iconst_0
    //   12343: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12346: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12349: aastore
    //   12350: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12353: goto -157 -> 12196
    //   12356: astore_1
    //   12357: goto +6 -> 12363
    //   12360: astore_1
    //   12361: aconst_null
    //   12362: astore_2
    //   12363: aload_1
    //   12364: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   12367: aload_3
    //   12368: aload_2
    //   12369: iconst_1
    //   12370: anewarray 369	java/lang/String
    //   12373: dup
    //   12374: iconst_0
    //   12375: ldc_w 2160
    //   12378: aastore
    //   12379: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12382: goto +1713 -> 14095
    //   12385: ldc_w 2168
    //   12388: aload 4
    //   12390: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12393: ifeq +259 -> 12652
    //   12396: new 353	org/json/JSONObject
    //   12399: dup
    //   12400: aload 5
    //   12402: iconst_0
    //   12403: aaload
    //   12404: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12407: astore_2
    //   12408: aload_2
    //   12409: ldc_w 577
    //   12412: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12415: astore 4
    //   12417: aload_2
    //   12418: ldc_w 2170
    //   12421: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12424: ifeq +12 -> 12436
    //   12427: aload_2
    //   12428: ldc_w 2170
    //   12431: aload_1
    //   12432: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12435: pop
    //   12436: aload_2
    //   12437: ldc_w 2172
    //   12440: invokevirtual 1460	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12443: ifeq +2039 -> 14482
    //   12446: aload_2
    //   12447: ldc_w 2172
    //   12450: aload_1
    //   12451: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12454: astore_2
    //   12455: goto +3 -> 12458
    //   12458: ldc_w 2174
    //   12461: aload_2
    //   12462: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12465: ifeq +86 -> 12551
    //   12468: aload_3
    //   12469: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;
    //   12472: ldc_w 2176
    //   12475: aconst_null
    //   12476: invokeinterface 2181 3 0
    //   12481: ldc_w 2183
    //   12484: aload_1
    //   12485: invokevirtual 2185	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12488: astore_2
    //   12489: aload_1
    //   12490: aload_2
    //   12491: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12494: istore 14
    //   12496: iload 14
    //   12498: ifne +1597 -> 14095
    //   12501: new 353	org/json/JSONObject
    //   12504: dup
    //   12505: aload_2
    //   12506: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12509: astore_1
    //   12510: aload_3
    //   12511: aload 4
    //   12513: iconst_1
    //   12514: anewarray 369	java/lang/String
    //   12517: dup
    //   12518: iconst_0
    //   12519: new 353	org/json/JSONObject
    //   12522: dup
    //   12523: invokespecial 354	org/json/JSONObject:<init>	()V
    //   12526: ldc_w 2187
    //   12529: aload_1
    //   12530: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12533: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12536: aastore
    //   12537: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12540: goto +1555 -> 14095
    //   12543: astore_1
    //   12544: aload_1
    //   12545: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   12548: goto +1547 -> 14095
    //   12551: ldc_w 2189
    //   12554: aload_2
    //   12555: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12558: ifeq +1537 -> 14095
    //   12561: aload_3
    //   12562: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;
    //   12565: ldc_w 2191
    //   12568: aconst_null
    //   12569: invokeinterface 2181 3 0
    //   12574: ldc_w 2193
    //   12577: aload_1
    //   12578: invokevirtual 2185	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12581: astore_2
    //   12582: aload_1
    //   12583: aload_2
    //   12584: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12587: istore 14
    //   12589: iload 14
    //   12591: ifne +1504 -> 14095
    //   12594: new 353	org/json/JSONObject
    //   12597: dup
    //   12598: aload_2
    //   12599: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12602: astore_1
    //   12603: aload_3
    //   12604: aload 4
    //   12606: iconst_1
    //   12607: anewarray 369	java/lang/String
    //   12610: dup
    //   12611: iconst_0
    //   12612: new 353	org/json/JSONObject
    //   12615: dup
    //   12616: invokespecial 354	org/json/JSONObject:<init>	()V
    //   12619: ldc_w 2187
    //   12622: aload_1
    //   12623: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12626: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12629: aastore
    //   12630: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12633: goto +1462 -> 14095
    //   12636: astore_1
    //   12637: aload_1
    //   12638: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   12641: goto +1454 -> 14095
    //   12644: astore_1
    //   12645: aload_1
    //   12646: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   12649: goto +1446 -> 14095
    //   12652: ldc_w 2195
    //   12655: aload 4
    //   12657: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12660: ifeq +211 -> 12871
    //   12663: new 353	org/json/JSONObject
    //   12666: dup
    //   12667: aload 5
    //   12669: iconst_0
    //   12670: aaload
    //   12671: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12674: astore_1
    //   12675: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12678: ifeq +35 -> 12713
    //   12681: new 537	java/lang/StringBuilder
    //   12684: dup
    //   12685: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   12688: astore_2
    //   12689: aload_2
    //   12690: ldc_w 2197
    //   12693: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12696: pop
    //   12697: aload_2
    //   12698: aload_1
    //   12699: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12702: pop
    //   12703: ldc 45
    //   12705: iconst_2
    //   12706: aload_2
    //   12707: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12710: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12713: aload_1
    //   12714: ldc_w 2199
    //   12717: invokevirtual 2202	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   12720: lstore 19
    //   12722: aload_1
    //   12723: ldc_w 2093
    //   12726: invokevirtual 2091	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   12729: istore 6
    //   12731: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12734: ifeq +51 -> 12785
    //   12737: new 537	java/lang/StringBuilder
    //   12740: dup
    //   12741: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   12744: astore_1
    //   12745: aload_1
    //   12746: ldc_w 2095
    //   12749: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12752: pop
    //   12753: aload_1
    //   12754: lload 19
    //   12756: invokevirtual 882	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12759: pop
    //   12760: aload_1
    //   12761: ldc_w 2097
    //   12764: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12767: pop
    //   12768: aload_1
    //   12769: iload 6
    //   12771: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12774: pop
    //   12775: ldc 45
    //   12777: iconst_2
    //   12778: aload_1
    //   12779: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12782: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12785: aload_3
    //   12786: getfield 209	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12789: lload 19
    //   12791: iload 6
    //   12793: invokevirtual 2205	com/tencent/biz/troop/TroopMemberApiClient:a	(JI)V
    //   12796: aload_3
    //   12797: getfield 458	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12800: invokevirtual 464	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   12803: iconst_m1
    //   12804: new 316	android/content/Intent
    //   12807: dup
    //   12808: invokespecial 595	android/content/Intent:<init>	()V
    //   12811: ldc_w 2093
    //   12814: iload 6
    //   12816: invokevirtual 601	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12819: invokevirtual 2209	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   12822: goto +1273 -> 14095
    //   12825: astore_1
    //   12826: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12829: ifeq +35 -> 12864
    //   12832: new 537	java/lang/StringBuilder
    //   12835: dup
    //   12836: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   12839: astore_2
    //   12840: aload_2
    //   12841: ldc_w 2211
    //   12844: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12847: pop
    //   12848: aload_2
    //   12849: aload_1
    //   12850: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12853: pop
    //   12854: ldc 45
    //   12856: iconst_2
    //   12857: aload_2
    //   12858: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12861: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12864: aload_1
    //   12865: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   12868: goto +1227 -> 14095
    //   12871: ldc_w 2212
    //   12874: aload 4
    //   12876: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12879: ifeq +14 -> 12893
    //   12882: aload_3
    //   12883: aload 4
    //   12885: aload 5
    //   12887: invokespecial 2214	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndInviteFriend	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12890: goto +1205 -> 14095
    //   12893: ldc_w 2216
    //   12896: aload 4
    //   12898: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12901: ifeq +203 -> 13104
    //   12904: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12907: ifeq +12 -> 12919
    //   12910: ldc 45
    //   12912: iconst_2
    //   12913: ldc_w 2218
    //   12916: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12919: aload_3
    //   12920: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;
    //   12923: ifnonnull +21 -> 12944
    //   12926: aload_3
    //   12927: ldc_w 2220
    //   12930: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   12933: checkcast 2220	com/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownloadFactory
    //   12936: invokeinterface 2224 1 0
    //   12941: putfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;
    //   12944: aload_3
    //   12945: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;
    //   12948: astore_1
    //   12949: aload_1
    //   12950: new 2226	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$8
    //   12953: dup
    //   12954: aload_3
    //   12955: invokespecial 2227	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$8:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   12958: invokeinterface 2232 2 0
    //   12963: new 353	org/json/JSONObject
    //   12966: dup
    //   12967: aload 5
    //   12969: iconst_0
    //   12970: aaload
    //   12971: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12974: astore_2
    //   12975: aload_2
    //   12976: ldc_w 577
    //   12979: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12982: astore_3
    //   12983: aload_2
    //   12984: ldc_w 2234
    //   12987: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12990: astore 4
    //   12992: aload_2
    //   12993: ldc_w 2236
    //   12996: iconst_m1
    //   12997: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13000: istore 6
    //   13002: aload_2
    //   13003: ldc 22
    //   13005: iconst_0
    //   13006: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13009: istore 7
    //   13011: aload_2
    //   13012: ldc_w 2238
    //   13015: iconst_0
    //   13016: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13019: istore 8
    //   13021: aload_2
    //   13022: ldc_w 2240
    //   13025: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13028: astore 5
    //   13030: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13033: ifeq +42 -> 13075
    //   13036: new 537	java/lang/StringBuilder
    //   13039: dup
    //   13040: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   13043: astore 31
    //   13045: aload 31
    //   13047: ldc_w 2242
    //   13050: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13053: pop
    //   13054: aload 31
    //   13056: aload_2
    //   13057: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13060: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13063: pop
    //   13064: ldc 45
    //   13066: iconst_2
    //   13067: aload 31
    //   13069: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13072: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13075: aload_1
    //   13076: aload 4
    //   13078: iload 6
    //   13080: iload 7
    //   13082: i2l
    //   13083: iload 8
    //   13085: aload 5
    //   13087: aload_3
    //   13088: invokeinterface 2245 8 0
    //   13093: goto +1002 -> 14095
    //   13096: astore_1
    //   13097: aload_1
    //   13098: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   13101: goto +994 -> 14095
    //   13104: ldc_w 2247
    //   13107: aload 4
    //   13109: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13112: ifeq +36 -> 13148
    //   13115: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13118: ifeq +12 -> 13130
    //   13121: ldc 45
    //   13123: iconst_2
    //   13124: ldc_w 2249
    //   13127: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13130: aload_3
    //   13131: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;
    //   13134: astore_1
    //   13135: aload_1
    //   13136: ifnull +959 -> 14095
    //   13139: aload_1
    //   13140: invokeinterface 2251 1 0
    //   13145: goto +950 -> 14095
    //   13148: ldc_w 2253
    //   13151: aload 4
    //   13153: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13156: ifeq +85 -> 13241
    //   13159: new 285	android/os/Bundle
    //   13162: dup
    //   13163: invokespecial 286	android/os/Bundle:<init>	()V
    //   13166: astore_2
    //   13167: new 353	org/json/JSONObject
    //   13170: dup
    //   13171: aload 5
    //   13173: iconst_0
    //   13174: aaload
    //   13175: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13178: astore 5
    //   13180: aload 5
    //   13182: ldc_w 1088
    //   13185: invokevirtual 2080	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13188: astore 4
    //   13190: aload 5
    //   13192: ldc_w 2255
    //   13195: aload_1
    //   13196: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13199: astore_1
    //   13200: aload_2
    //   13201: ldc_w 1088
    //   13204: aload 4
    //   13206: invokevirtual 423	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   13209: aload_2
    //   13210: ldc_w 2255
    //   13213: aload_1
    //   13214: invokevirtual 423	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   13217: aload_3
    //   13218: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;
    //   13221: ifnull +874 -> 14095
    //   13224: aload_3
    //   13225: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;
    //   13228: ldc_w 2257
    //   13231: aload_2
    //   13232: invokeinterface 2181 3 0
    //   13237: pop
    //   13238: goto +857 -> 14095
    //   13241: ldc_w 2259
    //   13244: aload 4
    //   13246: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13249: ifeq +93 -> 13342
    //   13252: new 353	org/json/JSONObject
    //   13255: dup
    //   13256: aload 5
    //   13258: iconst_0
    //   13259: aaload
    //   13260: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13263: ldc_w 1742
    //   13266: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13269: astore_1
    //   13270: new 537	java/lang/StringBuilder
    //   13273: dup
    //   13274: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   13277: astore_2
    //   13278: aload_2
    //   13279: ldc_w 2261
    //   13282: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13285: pop
    //   13286: aload_2
    //   13287: aload_1
    //   13288: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13291: pop
    //   13292: ldc 45
    //   13294: iconst_2
    //   13295: aload_2
    //   13296: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13299: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13302: ldc_w 608
    //   13305: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   13308: checkcast 608	com/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyActivityHelper
    //   13311: aload_3
    //   13312: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   13315: new 1744	java/math/BigInteger
    //   13318: dup
    //   13319: aload_1
    //   13320: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   13323: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   13326: invokeinterface 2265 4 0
    //   13331: goto +764 -> 14095
    //   13334: astore_1
    //   13335: aload_1
    //   13336: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   13339: goto +756 -> 14095
    //   13342: ldc_w 2267
    //   13345: aload 4
    //   13347: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13350: ifeq +220 -> 13570
    //   13353: new 353	org/json/JSONObject
    //   13356: dup
    //   13357: aload 5
    //   13359: iconst_0
    //   13360: aaload
    //   13361: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13364: astore_2
    //   13365: aload_2
    //   13366: ldc_w 2269
    //   13369: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13372: istore 6
    //   13374: aload_2
    //   13375: ldc_w 2271
    //   13378: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13381: astore 4
    //   13383: aload_2
    //   13384: ldc_w 1173
    //   13387: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13390: astore 5
    //   13392: aload_2
    //   13393: ldc_w 577
    //   13396: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13399: astore 31
    //   13401: iload 6
    //   13403: iconst_1
    //   13404: if_icmpeq +1100 -> 14504
    //   13407: iload 6
    //   13409: iconst_2
    //   13410: if_icmpeq +1087 -> 14497
    //   13413: iload 6
    //   13415: iconst_3
    //   13416: if_icmpeq +1074 -> 14490
    //   13419: ldc_w 2273
    //   13422: astore_1
    //   13423: goto +1064 -> 14487
    //   13426: new 537	java/lang/StringBuilder
    //   13429: dup
    //   13430: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   13433: astore 32
    //   13435: aload 32
    //   13437: ldc_w 2275
    //   13440: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13443: pop
    //   13444: aload 32
    //   13446: iload 6
    //   13448: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13451: pop
    //   13452: aload 32
    //   13454: ldc_w 2277
    //   13457: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13460: pop
    //   13461: aload 32
    //   13463: aload 4
    //   13465: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13468: pop
    //   13469: aload 32
    //   13471: ldc_w 2277
    //   13474: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13477: pop
    //   13478: aload 32
    //   13480: aload 5
    //   13482: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13485: pop
    //   13486: ldc 45
    //   13488: iconst_1
    //   13489: aload 32
    //   13491: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13494: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13497: ldc_w 531
    //   13500: invokestatic 385	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   13503: checkcast 531	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   13506: aconst_null
    //   13507: ldc 230
    //   13509: aload_1
    //   13510: aload_1
    //   13511: iconst_0
    //   13512: iconst_0
    //   13513: ldc 230
    //   13515: ldc 230
    //   13517: aload 4
    //   13519: aload_2
    //   13520: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13523: iconst_0
    //   13524: invokeinterface 535 12 0
    //   13529: aload_3
    //   13530: aload 31
    //   13532: iconst_1
    //   13533: anewarray 369	java/lang/String
    //   13536: dup
    //   13537: iconst_0
    //   13538: new 353	org/json/JSONObject
    //   13541: dup
    //   13542: invokespecial 354	org/json/JSONObject:<init>	()V
    //   13545: ldc_w 356
    //   13548: iconst_0
    //   13549: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   13552: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13555: aastore
    //   13556: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13559: goto +536 -> 14095
    //   13562: astore_1
    //   13563: aload_1
    //   13564: invokevirtual 367	org/json/JSONException:printStackTrace	()V
    //   13567: goto +528 -> 14095
    //   13570: ldc_w 2278
    //   13573: aload 4
    //   13575: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13578: ifeq +60 -> 13638
    //   13581: new 353	org/json/JSONObject
    //   13584: dup
    //   13585: aload 5
    //   13587: iconst_0
    //   13588: aaload
    //   13589: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13592: ldc_w 577
    //   13595: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13598: astore_1
    //   13599: aload_3
    //   13600: new 353	org/json/JSONObject
    //   13603: dup
    //   13604: aload 5
    //   13606: iconst_0
    //   13607: aaload
    //   13608: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13611: aload_1
    //   13612: new 2280	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$9
    //   13615: dup
    //   13616: aload_3
    //   13617: invokespecial 2281	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$9:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   13620: invokevirtual 2284	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showReadInJoyNativeCommentView	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   13623: iconst_1
    //   13624: ireturn
    //   13625: astore_1
    //   13626: ldc 45
    //   13628: iconst_1
    //   13629: ldc_w 2286
    //   13632: aload_1
    //   13633: invokestatic 1669	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13636: iconst_1
    //   13637: ireturn
    //   13638: ldc_w 2288
    //   13641: aload 4
    //   13643: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13646: ifeq +211 -> 13857
    //   13649: invokestatic 2291	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13652: ifne +15 -> 13667
    //   13655: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13658: ifeq +6 -> 13664
    //   13661: goto +6 -> 13667
    //   13664: goto +24 -> 13688
    //   13667: ldc 45
    //   13669: iconst_1
    //   13670: iconst_2
    //   13671: anewarray 730	java/lang/Object
    //   13674: dup
    //   13675: iconst_0
    //   13676: ldc_w 2293
    //   13679: aastore
    //   13680: dup
    //   13681: iconst_1
    //   13682: aload 5
    //   13684: aastore
    //   13685: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   13688: aload 5
    //   13690: ifnull +153 -> 13843
    //   13693: aload 5
    //   13695: arraylength
    //   13696: ifle +147 -> 13843
    //   13699: new 353	org/json/JSONObject
    //   13702: dup
    //   13703: aload 5
    //   13705: iconst_0
    //   13706: aaload
    //   13707: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13710: ldc_w 2295
    //   13713: invokevirtual 574	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13716: istore 6
    //   13718: iload 6
    //   13720: ifne +59 -> 13779
    //   13723: invokestatic 2291	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13726: ifne +12 -> 13738
    //   13729: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13732: ifeq +779 -> 14511
    //   13735: goto +3 -> 13738
    //   13738: ldc 45
    //   13740: iconst_1
    //   13741: ldc_w 2297
    //   13744: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13747: aload_3
    //   13748: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   13751: iconst_m1
    //   13752: new 316	android/content/Intent
    //   13755: dup
    //   13756: invokespecial 595	android/content/Intent:<init>	()V
    //   13759: ldc_w 2299
    //   13762: iconst_1
    //   13763: invokevirtual 2030	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   13766: invokevirtual 2209	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   13769: aload_3
    //   13770: getfield 312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   13773: invokevirtual 2302	android/app/Activity:finish	()V
    //   13776: goto +67 -> 13843
    //   13779: invokestatic 2291	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13782: ifne +9 -> 13791
    //   13785: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13788: ifeq +55 -> 13843
    //   13791: new 537	java/lang/StringBuilder
    //   13794: dup
    //   13795: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   13798: astore_1
    //   13799: aload_1
    //   13800: ldc_w 2304
    //   13803: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13806: pop
    //   13807: aload_1
    //   13808: iload 6
    //   13810: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13813: pop
    //   13814: ldc 45
    //   13816: iconst_1
    //   13817: aload_1
    //   13818: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13821: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13824: goto +19 -> 13843
    //   13827: astore_1
    //   13828: invokestatic 2291	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13831: ifne +14 -> 13845
    //   13834: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13837: ifeq +6 -> 13843
    //   13840: goto +5 -> 13845
    //   13843: iconst_1
    //   13844: ireturn
    //   13845: ldc 45
    //   13847: iconst_1
    //   13848: ldc_w 2306
    //   13851: aload_1
    //   13852: invokestatic 1669	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13855: iconst_1
    //   13856: ireturn
    //   13857: ldc_w 2308
    //   13860: aload 4
    //   13862: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13865: ifeq +57 -> 13922
    //   13868: ldc 45
    //   13870: iconst_1
    //   13871: ldc_w 2310
    //   13874: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13877: new 353	org/json/JSONObject
    //   13880: dup
    //   13881: aload 5
    //   13883: iconst_0
    //   13884: aaload
    //   13885: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13888: ldc_w 577
    //   13891: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13894: astore_1
    //   13895: new 2312	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$10
    //   13898: dup
    //   13899: aload_3
    //   13900: invokespecial 2313	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$10:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   13903: aload_1
    //   13904: invokestatic 2315	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:getAppType	(Lcom/tencent/mobileqq/kandian/biz/fastweb/CallJs;Ljava/lang/String;)V
    //   13907: iconst_1
    //   13908: ireturn
    //   13909: astore_1
    //   13910: ldc 45
    //   13912: iconst_1
    //   13913: aload_1
    //   13914: invokevirtual 1131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13917: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13920: iconst_1
    //   13921: ireturn
    //   13922: ldc_w 2317
    //   13925: aload 4
    //   13927: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13930: ifeq +92 -> 14022
    //   13933: ldc 45
    //   13935: iconst_1
    //   13936: ldc_w 2319
    //   13939: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13942: new 353	org/json/JSONObject
    //   13945: dup
    //   13946: aload 5
    //   13948: iconst_0
    //   13949: aaload
    //   13950: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13953: astore_1
    //   13954: aload_1
    //   13955: aload 40
    //   13957: invokevirtual 705	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   13960: lstore 19
    //   13962: aload_1
    //   13963: ldc_w 577
    //   13966: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13969: astore_1
    //   13970: lload 19
    //   13972: new 2321	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$11
    //   13975: dup
    //   13976: aload_3
    //   13977: invokespecial 2322	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$11:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   13980: aload_1
    //   13981: invokestatic 2324	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:getUserInfoIpc	(JLcom/tencent/mobileqq/kandian/biz/fastweb/CallJs;Ljava/lang/String;)V
    //   13984: iconst_1
    //   13985: ireturn
    //   13986: astore_1
    //   13987: ldc 45
    //   13989: iconst_1
    //   13990: aload_1
    //   13991: invokevirtual 1131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13994: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13997: aload_3
    //   13998: aload_3
    //   13999: getfield 2326	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callback	Ljava/lang/String;
    //   14002: iconst_1
    //   14003: anewarray 369	java/lang/String
    //   14006: dup
    //   14007: iconst_0
    //   14008: aload_3
    //   14009: aload_1
    //   14010: invokevirtual 1131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14013: invokevirtual 2328	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:getUserInfoFailStr	(Ljava/lang/String;)Ljava/lang/String;
    //   14016: aastore
    //   14017: invokevirtual 377	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14020: iconst_1
    //   14021: ireturn
    //   14022: ldc_w 2330
    //   14025: aload 4
    //   14027: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14030: ifeq +47 -> 14077
    //   14033: new 537	java/lang/StringBuilder
    //   14036: dup
    //   14037: invokespecial 538	java/lang/StringBuilder:<init>	()V
    //   14040: astore_1
    //   14041: aload_1
    //   14042: ldc_w 2332
    //   14045: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14048: pop
    //   14049: aload_1
    //   14050: aload 5
    //   14052: iconst_0
    //   14053: aaload
    //   14054: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14057: pop
    //   14058: ldc 45
    //   14060: iconst_1
    //   14061: aload_1
    //   14062: invokevirtual 550	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14065: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14068: aload 5
    //   14070: iconst_0
    //   14071: aaload
    //   14072: invokestatic 2334	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:updateUserInfoIPC	(Ljava/lang/String;)V
    //   14075: iconst_1
    //   14076: ireturn
    //   14077: ldc_w 2335
    //   14080: aload 4
    //   14082: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14085: ifeq +10 -> 14095
    //   14088: aload 5
    //   14090: invokestatic 2337	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:reportT	([Ljava/lang/String;)V
    //   14093: iconst_1
    //   14094: ireturn
    //   14095: iconst_0
    //   14096: ireturn
    //   14097: astore_1
    //   14098: goto -10042 -> 4056
    //   14101: astore_1
    //   14102: iload 15
    //   14104: istore 14
    //   14106: goto -9884 -> 4222
    //   14109: astore_1
    //   14110: goto -15 -> 14095
    //   14113: iconst_1
    //   14114: ireturn
    //   14115: bipush 9
    //   14117: istore 8
    //   14119: goto -11561 -> 2558
    //   14122: iconst_0
    //   14123: istore 6
    //   14125: goto -11501 -> 2624
    //   14128: sipush 640
    //   14131: istore 6
    //   14133: sipush 640
    //   14136: istore 7
    //   14138: goto -10137 -> 4001
    //   14141: sipush 640
    //   14144: istore 9
    //   14146: sipush 640
    //   14149: istore 8
    //   14151: goto -10114 -> 4037
    //   14154: sipush 750
    //   14157: istore 8
    //   14159: sipush 416
    //   14162: istore 9
    //   14164: iload 10
    //   14166: iconst_1
    //   14167: if_icmpeq -9964 -> 4203
    //   14170: iload 15
    //   14172: istore 14
    //   14174: iload 10
    //   14176: iconst_2
    //   14177: if_icmpne -9955 -> 4222
    //   14180: goto -9977 -> 4203
    //   14183: aconst_null
    //   14184: astore_1
    //   14185: goto -9829 -> 4356
    //   14188: iconst_0
    //   14189: istore 14
    //   14191: goto -9457 -> 4734
    //   14194: iload 13
    //   14196: iconst_4
    //   14197: if_icmpeq -6419 -> 7778
    //   14200: iload 13
    //   14202: iconst_5
    //   14203: if_icmpne -6440 -> 7763
    //   14206: goto -6428 -> 7778
    //   14209: iload 9
    //   14211: istore 6
    //   14213: goto -6268 -> 7945
    //   14216: iconst_2
    //   14217: istore 6
    //   14219: goto -6274 -> 7945
    //   14222: iconst_1
    //   14223: istore 6
    //   14225: goto -6280 -> 7945
    //   14228: goto -6229 -> 7999
    //   14231: goto -6093 -> 8138
    //   14234: iload 9
    //   14236: bipush 11
    //   14238: if_icmpne +9 -> 14247
    //   14241: iconst_5
    //   14242: istore 6
    //   14244: goto -6061 -> 8183
    //   14247: iload 9
    //   14249: bipush 6
    //   14251: if_icmpne +10 -> 14261
    //   14254: bipush 6
    //   14256: istore 6
    //   14258: goto -6075 -> 8183
    //   14261: iload 9
    //   14263: bipush 12
    //   14265: if_icmpne +10 -> 14275
    //   14268: bipush 7
    //   14270: istore 6
    //   14272: goto -6089 -> 8183
    //   14275: iload 9
    //   14277: bipush 13
    //   14279: if_icmpne +10 -> 14289
    //   14282: bipush 8
    //   14284: istore 6
    //   14286: goto -6103 -> 8183
    //   14289: iload 9
    //   14291: bipush 15
    //   14293: if_icmplt -6110 -> 8183
    //   14296: iload 9
    //   14298: istore 6
    //   14300: goto -6117 -> 8183
    //   14303: aload 4
    //   14305: astore_1
    //   14306: goto -5947 -> 8359
    //   14309: iload 13
    //   14311: iconst_4
    //   14312: if_icmpeq -3953 -> 10359
    //   14315: iload 13
    //   14317: iconst_5
    //   14318: if_icmpne -3974 -> 10344
    //   14321: goto -3962 -> 10359
    //   14324: iload 9
    //   14326: istore 6
    //   14328: goto -3802 -> 10526
    //   14331: iconst_2
    //   14332: istore 6
    //   14334: goto -3808 -> 10526
    //   14337: iconst_1
    //   14338: istore 6
    //   14340: goto -3814 -> 10526
    //   14343: goto -3763 -> 10580
    //   14346: iload 6
    //   14348: istore 7
    //   14350: ldc 230
    //   14352: astore_1
    //   14353: iload 9
    //   14355: istore 6
    //   14357: goto -3742 -> 10615
    //   14360: goto -3654 -> 10706
    //   14363: iload 9
    //   14365: bipush 11
    //   14367: if_icmpne +9 -> 14376
    //   14370: iconst_5
    //   14371: istore 6
    //   14373: goto -3622 -> 10751
    //   14376: iload 9
    //   14378: bipush 6
    //   14380: if_icmpne +10 -> 14390
    //   14383: bipush 6
    //   14385: istore 6
    //   14387: goto -3636 -> 10751
    //   14390: iload 9
    //   14392: bipush 12
    //   14394: if_icmpne +10 -> 14404
    //   14397: bipush 7
    //   14399: istore 6
    //   14401: goto -3650 -> 10751
    //   14404: iload 9
    //   14406: bipush 13
    //   14408: if_icmpne +10 -> 14418
    //   14411: bipush 8
    //   14413: istore 6
    //   14415: goto -3664 -> 10751
    //   14418: iload 9
    //   14420: bipush 15
    //   14422: if_icmplt -3671 -> 10751
    //   14425: iload 9
    //   14427: istore 6
    //   14429: goto -3678 -> 10751
    //   14432: goto -3572 -> 10860
    //   14435: goto -3575 -> 10860
    //   14438: aload_3
    //   14439: astore_1
    //   14440: goto -3511 -> 10929
    //   14443: iconst_0
    //   14444: istore 14
    //   14446: goto -2899 -> 11547
    //   14449: iconst_1
    //   14450: istore 15
    //   14452: goto -2881 -> 11571
    //   14455: aload_1
    //   14456: astore_2
    //   14457: goto -2776 -> 11681
    //   14460: iconst_m1
    //   14461: istore 6
    //   14463: goto -2714 -> 11749
    //   14466: iconst_0
    //   14467: istore 7
    //   14469: goto -2695 -> 11774
    //   14472: iconst_0
    //   14473: istore 8
    //   14475: goto -2676 -> 11799
    //   14478: astore_1
    //   14479: goto -2412 -> 12067
    //   14482: aload_1
    //   14483: astore_2
    //   14484: goto -2026 -> 12458
    //   14487: goto -1061 -> 13426
    //   14490: ldc_w 2339
    //   14493: astore_1
    //   14494: goto -7 -> 14487
    //   14497: ldc_w 2341
    //   14500: astore_1
    //   14501: goto -14 -> 14487
    //   14504: ldc_w 2343
    //   14507: astore_1
    //   14508: goto -21 -> 14487
    //   14511: goto -764 -> 13747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	14514	0	this	PublicAccountH5AbilityPluginImpl
    //   0	14514	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	14514	2	paramString1	String
    //   0	14514	3	paramString2	String
    //   0	14514	4	paramString3	String
    //   0	14514	5	paramVarArgs	String[]
    //   500	7960	6	i	int
    //   2626	5838	7	j	int
    //   2547	5690	8	k	int
    //   13	8244	9	m	int
    //   3963	3754	10	n	int
    //   6106	2187	11	i1	int
    //   6629	1417	12	i2	int
    //   7346	662	13	i3	int
    //   7	6247	14	bool1	boolean
    //   10	5918	15	bool2	boolean
    //   4853	51	16	bool3	boolean
    //   4865	49	17	bool4	boolean
    //   4877	47	18	bool5	boolean
    //   6213	749	19	l1	long
    //   6270	2273	21	l2	long
    //   6313	2142	23	l3	long
    //   6351	615	25	l4	long
    //   6367	1860	27	l5	long
    //   6381	932	29	l6	long
    //   6064	83	31	str1	String
    //   6218	1	31	localException1	Exception
    //   6244	19	31	str2	String
    //   6275	1	31	localException2	Exception
    //   6291	53	31	str3	String
    //   6408	1	31	localException3	Exception
    //   6421	1	31	localException4	Exception
    //   6434	1	31	localException5	Exception
    //   6443	1	31	localException6	Exception
    //   6448	1	31	localException7	Exception
    //   6453	22	31	localException8	Exception
    //   6479	1550	31	localObject1	Object
    //   6222	310	32	localObject2	Object
    //   6537	15	32	localException9	Exception
    //   6572	1320	32	localObject3	Object
    //   6926	264	33	localObject4	Object
    //   7206	75	33	localException10	Exception
    //   7451	181	33	localObject5	Object
    //   7648	23	33	localException11	Exception
    //   6086	2174	34	localObject6	Object
    //   6403	2059	35	str4	String
    //   6388	1810	36	localObject7	Object
    //   6384	1458	37	localObject8	Object
    //   6915	1059	38	localObject9	Object
    //   6930	1038	39	localObject10	Object
    //   6934	677	40	arrayOfString	String[]
    //   6947	736	41	localObject11	Object
    //   6691	907	42	str5	String
    //   5997	1290	43	localJSONObject	JSONObject
    //   6659	1749	44	str6	String
    //   6718	1748	45	localAbsBaseArticleInfo	com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo
    // Exception table:
    //   from	to	target	type
    //   42	111	118	org/json/JSONException
    //   111	115	118	org/json/JSONException
    //   175	207	209	org/json/JSONException
    //   238	307	313	org/json/JSONException
    //   307	311	313	org/json/JSONException
    //   342	422	430	org/json/JSONException
    //   422	428	430	org/json/JSONException
    //   459	495	590	org/json/JSONException
    //   502	522	590	org/json/JSONException
    //   531	582	590	org/json/JSONException
    //   582	587	590	org/json/JSONException
    //   647	683	778	org/json/JSONException
    //   690	710	778	org/json/JSONException
    //   719	770	778	org/json/JSONException
    //   770	775	778	org/json/JSONException
    //   835	904	911	org/json/JSONException
    //   904	908	911	org/json/JSONException
    //   968	1037	1044	org/json/JSONException
    //   1037	1041	1044	org/json/JSONException
    //   1101	1170	1177	org/json/JSONException
    //   1170	1174	1177	org/json/JSONException
    //   1234	1303	1310	org/json/JSONException
    //   1303	1307	1310	org/json/JSONException
    //   1367	1477	1663	org/json/JSONException
    //   1479	1531	1663	org/json/JSONException
    //   1533	1542	1663	org/json/JSONException
    //   1542	1564	1663	org/json/JSONException
    //   1568	1598	1663	org/json/JSONException
    //   1600	1658	1663	org/json/JSONException
    //   1733	1789	1929	org/json/JSONException
    //   1792	1800	1929	org/json/JSONException
    //   1800	1820	1929	org/json/JSONException
    //   1824	1854	1929	org/json/JSONException
    //   1856	1909	1929	org/json/JSONException
    //   1912	1927	1929	org/json/JSONException
    //   2036	2080	2083	org/json/JSONException
    //   2154	2190	2193	org/json/JSONException
    //   2220	2240	2243	org/json/JSONException
    //   1987	2031	2307	org/json/JSONException
    //   2084	2088	2307	org/json/JSONException
    //   2091	2121	2307	org/json/JSONException
    //   2121	2154	2307	org/json/JSONException
    //   2194	2198	2307	org/json/JSONException
    //   2201	2220	2307	org/json/JSONException
    //   2244	2248	2307	org/json/JSONException
    //   2248	2264	2307	org/json/JSONException
    //   2267	2276	2307	org/json/JSONException
    //   2276	2305	2307	org/json/JSONException
    //   2385	2429	2432	org/json/JSONException
    //   2336	2380	2480	org/json/JSONException
    //   2433	2437	2480	org/json/JSONException
    //   2440	2449	2480	org/json/JSONException
    //   2449	2478	2480	org/json/JSONException
    //   2509	2538	2725	org/json/JSONException
    //   2558	2574	2725	org/json/JSONException
    //   2578	2602	2725	org/json/JSONException
    //   2608	2618	2725	org/json/JSONException
    //   2636	2660	2725	org/json/JSONException
    //   2670	2680	2725	org/json/JSONException
    //   2683	2723	2725	org/json/JSONException
    //   2754	2813	2851	org/json/JSONException
    //   2813	2820	2851	org/json/JSONException
    //   2820	2849	2851	org/json/JSONException
    //   2927	2973	2976	org/json/JSONException
    //   2880	2924	3012	org/json/JSONException
    //   2977	2981	3012	org/json/JSONException
    //   2981	3010	3012	org/json/JSONException
    //   3175	3195	3198	org/json/JSONException
    //   3235	3255	3258	org/json/JSONException
    //   3321	3359	3362	org/json/JSONException
    //   3041	3104	3398	org/json/JSONException
    //   3106	3136	3398	org/json/JSONException
    //   3136	3175	3398	org/json/JSONException
    //   3199	3203	3398	org/json/JSONException
    //   3203	3232	3398	org/json/JSONException
    //   3259	3263	3398	org/json/JSONException
    //   3263	3292	3398	org/json/JSONException
    //   3292	3310	3398	org/json/JSONException
    //   3313	3321	3398	org/json/JSONException
    //   3363	3367	3398	org/json/JSONException
    //   3367	3396	3398	org/json/JSONException
    //   3526	3562	3565	org/json/JSONException
    //   3427	3492	3630	org/json/JSONException
    //   3492	3526	3630	org/json/JSONException
    //   3566	3570	3630	org/json/JSONException
    //   3570	3599	3630	org/json/JSONException
    //   3599	3628	3630	org/json/JSONException
    //   3659	3726	3802	org/json/JSONException
    //   3726	3771	3802	org/json/JSONException
    //   3771	3800	3802	org/json/JSONException
    //   3831	3851	3853	org/json/JSONException
    //   3882	3902	3904	org/json/JSONException
    //   4303	4344	4474	org/json/JSONException
    //   4348	4353	4474	org/json/JSONException
    //   4356	4398	4474	org/json/JSONException
    //   4402	4407	4474	org/json/JSONException
    //   4410	4431	4474	org/json/JSONException
    //   4440	4462	4474	org/json/JSONException
    //   4466	4472	4474	org/json/JSONException
    //   4493	4533	4602	org/json/JSONException
    //   4537	4566	4602	org/json/JSONException
    //   4566	4599	4602	org/json/JSONException
    //   4632	4707	4988	org/json/JSONException
    //   4711	4728	4988	org/json/JSONException
    //   4734	4751	4988	org/json/JSONException
    //   4755	4766	4988	org/json/JSONException
    //   4770	4815	4988	org/json/JSONException
    //   4819	4986	4988	org/json/JSONException
    //   5102	5159	5224	org/json/JSONException
    //   5164	5211	5224	org/json/JSONException
    //   5213	5222	5224	org/json/JSONException
    //   5259	5319	5351	org/json/JSONException
    //   5319	5348	5351	org/json/JSONException
    //   5425	5487	5519	java/lang/Exception
    //   5487	5516	5519	java/lang/Exception
    //   5593	5650	5682	java/lang/Exception
    //   5650	5679	5682	java/lang/Exception
    //   5756	5795	5798	org/json/JSONException
    //   5834	5947	5950	org/json/JSONException
    //   6009	6045	6048	java/lang/NumberFormatException
    //   6114	6135	6048	java/lang/NumberFormatException
    //   6142	6156	6048	java/lang/NumberFormatException
    //   6156	6170	6048	java/lang/NumberFormatException
    //   6170	6189	6048	java/lang/NumberFormatException
    //   6189	6196	6048	java/lang/NumberFormatException
    //   6201	6215	6048	java/lang/NumberFormatException
    //   6236	6253	6048	java/lang/NumberFormatException
    //   6258	6272	6048	java/lang/NumberFormatException
    //   6283	6315	6048	java/lang/NumberFormatException
    //   6321	6353	6048	java/lang/NumberFormatException
    //   6359	6369	6048	java/lang/NumberFormatException
    //   6369	6379	6048	java/lang/NumberFormatException
    //   6009	6045	6052	org/json/JSONException
    //   6114	6135	6052	org/json/JSONException
    //   6142	6156	6052	org/json/JSONException
    //   6156	6170	6052	org/json/JSONException
    //   6170	6189	6052	org/json/JSONException
    //   6189	6196	6052	org/json/JSONException
    //   6201	6215	6052	org/json/JSONException
    //   6236	6253	6052	org/json/JSONException
    //   6258	6272	6052	org/json/JSONException
    //   6283	6315	6052	org/json/JSONException
    //   6321	6353	6052	org/json/JSONException
    //   6359	6369	6052	org/json/JSONException
    //   6369	6379	6052	org/json/JSONException
    //   6201	6215	6218	java/lang/Exception
    //   6258	6272	6275	java/lang/Exception
    //   6369	6379	6408	java/lang/Exception
    //   6359	6369	6421	java/lang/Exception
    //   6321	6353	6434	java/lang/Exception
    //   6283	6315	6443	java/lang/Exception
    //   6236	6253	6448	java/lang/Exception
    //   6189	6196	6453	java/lang/Exception
    //   6170	6189	6495	java/lang/Exception
    //   6156	6170	6499	java/lang/Exception
    //   6142	6156	6537	java/lang/Exception
    //   6782	6791	6794	org/json/JSONException
    //   7166	7203	7206	java/lang/Exception
    //   6983	7163	7276	org/json/JSONException
    //   7166	7203	7276	org/json/JSONException
    //   7208	7248	7276	org/json/JSONException
    //   7248	7267	7276	org/json/JSONException
    //   7301	7367	7276	org/json/JSONException
    //   7378	7417	7276	org/json/JSONException
    //   7427	7605	7276	org/json/JSONException
    //   7608	7645	7276	org/json/JSONException
    //   7650	7690	7276	org/json/JSONException
    //   7690	7712	7276	org/json/JSONException
    //   7721	7739	7276	org/json/JSONException
    //   7742	7748	7276	org/json/JSONException
    //   7769	7775	7276	org/json/JSONException
    //   7778	7813	7276	org/json/JSONException
    //   7817	7862	7276	org/json/JSONException
    //   7865	7900	7276	org/json/JSONException
    //   7904	7942	7276	org/json/JSONException
    //   7952	7996	7276	org/json/JSONException
    //   7999	8028	7276	org/json/JSONException
    //   7608	7645	7648	java/lang/Exception
    //   8081	8135	8570	java/lang/NumberFormatException
    //   8138	8168	8570	java/lang/NumberFormatException
    //   8183	8252	8570	java/lang/NumberFormatException
    //   8259	8278	8570	java/lang/NumberFormatException
    //   8278	8287	8570	java/lang/NumberFormatException
    //   8295	8356	8570	java/lang/NumberFormatException
    //   8361	8368	8570	java/lang/NumberFormatException
    //   8372	8472	8570	java/lang/NumberFormatException
    //   8475	8567	8570	java/lang/NumberFormatException
    //   8081	8135	8574	org/json/JSONException
    //   8138	8168	8574	org/json/JSONException
    //   8183	8252	8574	org/json/JSONException
    //   8259	8278	8574	org/json/JSONException
    //   8278	8287	8574	org/json/JSONException
    //   8295	8356	8574	org/json/JSONException
    //   8361	8368	8574	org/json/JSONException
    //   8372	8472	8574	org/json/JSONException
    //   8475	8567	8574	org/json/JSONException
    //   6600	6670	8578	java/lang/NumberFormatException
    //   6679	6704	8578	java/lang/NumberFormatException
    //   6704	6782	8578	java/lang/NumberFormatException
    //   6782	6791	8578	java/lang/NumberFormatException
    //   6795	6834	8578	java/lang/NumberFormatException
    //   6836	6913	8578	java/lang/NumberFormatException
    //   6983	7163	8578	java/lang/NumberFormatException
    //   7166	7203	8578	java/lang/NumberFormatException
    //   7208	7248	8578	java/lang/NumberFormatException
    //   7248	7267	8578	java/lang/NumberFormatException
    //   7286	7296	8578	java/lang/NumberFormatException
    //   7301	7367	8578	java/lang/NumberFormatException
    //   7378	7417	8578	java/lang/NumberFormatException
    //   7427	7605	8578	java/lang/NumberFormatException
    //   7608	7645	8578	java/lang/NumberFormatException
    //   7650	7690	8578	java/lang/NumberFormatException
    //   7690	7712	8578	java/lang/NumberFormatException
    //   7721	7739	8578	java/lang/NumberFormatException
    //   7742	7748	8578	java/lang/NumberFormatException
    //   7769	7775	8578	java/lang/NumberFormatException
    //   7778	7813	8578	java/lang/NumberFormatException
    //   7817	7862	8578	java/lang/NumberFormatException
    //   7865	7900	8578	java/lang/NumberFormatException
    //   7904	7942	8578	java/lang/NumberFormatException
    //   7952	7996	8578	java/lang/NumberFormatException
    //   7999	8028	8578	java/lang/NumberFormatException
    //   8049	8079	8578	java/lang/NumberFormatException
    //   6600	6670	8582	org/json/JSONException
    //   6679	6704	8582	org/json/JSONException
    //   6704	6782	8582	org/json/JSONException
    //   6795	6834	8582	org/json/JSONException
    //   6836	6913	8582	org/json/JSONException
    //   7286	7296	8582	org/json/JSONException
    //   8049	8079	8582	org/json/JSONException
    //   5986	6004	8586	org/json/JSONException
    //   6056	6085	8586	org/json/JSONException
    //   6088	6095	8586	org/json/JSONException
    //   6098	6108	8586	org/json/JSONException
    //   6582	6587	8586	org/json/JSONException
    //   5986	6004	8590	java/lang/NumberFormatException
    //   6056	6085	8590	java/lang/NumberFormatException
    //   6088	6095	8590	java/lang/NumberFormatException
    //   6098	6108	8590	java/lang/NumberFormatException
    //   6582	6587	8590	java/lang/NumberFormatException
    //   8730	8766	8769	org/json/JSONException
    //   8831	8851	8769	org/json/JSONException
    //   8857	8871	8769	org/json/JSONException
    //   8871	8885	8769	org/json/JSONException
    //   8885	8905	8769	org/json/JSONException
    //   8905	8912	8769	org/json/JSONException
    //   8917	8931	8769	org/json/JSONException
    //   8971	8988	8769	org/json/JSONException
    //   8993	9007	8769	org/json/JSONException
    //   9018	9050	8769	org/json/JSONException
    //   9056	9088	8769	org/json/JSONException
    //   9094	9104	8769	org/json/JSONException
    //   9104	9114	8769	org/json/JSONException
    //   8917	8931	8934	java/lang/Exception
    //   8993	9007	9010	java/lang/Exception
    //   9104	9114	9143	java/lang/Exception
    //   9094	9104	9156	java/lang/Exception
    //   9056	9088	9169	java/lang/Exception
    //   9018	9050	9178	java/lang/Exception
    //   8971	8988	9183	java/lang/Exception
    //   8905	8912	9188	java/lang/Exception
    //   8885	8905	9234	java/lang/Exception
    //   8871	8885	9239	java/lang/Exception
    //   8857	8871	9258	java/lang/Exception
    //   9485	9494	9497	org/json/JSONException
    //   9815	9851	9854	java/lang/Exception
    //   10224	10261	10264	java/lang/Exception
    //   10649	10703	11069	org/json/JSONException
    //   10706	10736	11069	org/json/JSONException
    //   10751	10820	11069	org/json/JSONException
    //   10827	10846	11069	org/json/JSONException
    //   10849	10858	11069	org/json/JSONException
    //   10866	10926	11069	org/json/JSONException
    //   10931	10938	11069	org/json/JSONException
    //   10942	11044	11069	org/json/JSONException
    //   11047	11066	11069	org/json/JSONException
    //   9307	9377	11073	org/json/JSONException
    //   9381	9406	11073	org/json/JSONException
    //   9406	9485	11073	org/json/JSONException
    //   9498	9502	11073	org/json/JSONException
    //   9504	9581	11073	org/json/JSONException
    //   9631	9812	11073	org/json/JSONException
    //   9815	9851	11073	org/json/JSONException
    //   9856	9861	11073	org/json/JSONException
    //   9861	9880	11073	org/json/JSONException
    //   9892	9901	11073	org/json/JSONException
    //   9905	9969	11073	org/json/JSONException
    //   9984	10023	11073	org/json/JSONException
    //   10040	10221	11073	org/json/JSONException
    //   10224	10261	11073	org/json/JSONException
    //   10266	10271	11073	org/json/JSONException
    //   10271	10293	11073	org/json/JSONException
    //   10302	10320	11073	org/json/JSONException
    //   10323	10329	11073	org/json/JSONException
    //   10350	10356	11073	org/json/JSONException
    //   10359	10394	11073	org/json/JSONException
    //   10398	10443	11073	org/json/JSONException
    //   10446	10481	11073	org/json/JSONException
    //   10485	10523	11073	org/json/JSONException
    //   10533	10577	11073	org/json/JSONException
    //   10580	10609	11073	org/json/JSONException
    //   10619	10649	11073	org/json/JSONException
    //   8697	8725	11077	org/json/JSONException
    //   8773	8802	11077	org/json/JSONException
    //   8805	8812	11077	org/json/JSONException
    //   8815	8825	11077	org/json/JSONException
    //   9285	9290	11077	org/json/JSONException
    //   11166	11220	11223	java/lang/Exception
    //   11323	11363	11374	org/json/JSONException
    //   11366	11371	11374	org/json/JSONException
    //   11393	11477	11491	org/json/JSONException
    //   11477	11488	11491	org/json/JSONException
    //   11623	11636	11641	java/lang/Exception
    //   11701	11714	11719	java/lang/Exception
    //   11510	11544	12066	org/json/JSONException
    //   11547	11568	12066	org/json/JSONException
    //   11571	11623	12066	org/json/JSONException
    //   11623	11636	12066	org/json/JSONException
    //   11642	11646	12066	org/json/JSONException
    //   11646	11678	12066	org/json/JSONException
    //   11681	11701	12066	org/json/JSONException
    //   11701	11714	12066	org/json/JSONException
    //   11720	11724	12066	org/json/JSONException
    //   11724	11746	12066	org/json/JSONException
    //   11749	11771	12066	org/json/JSONException
    //   11774	11796	12066	org/json/JSONException
    //   11799	11848	12066	org/json/JSONException
    //   12050	12063	12066	org/json/JSONException
    //   12125	12196	12199	java/lang/Exception
    //   12107	12125	12203	java/lang/Exception
    //   12259	12276	12356	java/lang/Exception
    //   12279	12306	12356	java/lang/Exception
    //   12315	12353	12356	java/lang/Exception
    //   12239	12259	12360	java/lang/Exception
    //   12501	12540	12543	org/json/JSONException
    //   12594	12633	12636	org/json/JSONException
    //   12396	12436	12644	org/json/JSONException
    //   12436	12455	12644	org/json/JSONException
    //   12458	12496	12644	org/json/JSONException
    //   12544	12548	12644	org/json/JSONException
    //   12551	12589	12644	org/json/JSONException
    //   12637	12641	12644	org/json/JSONException
    //   12663	12713	12825	org/json/JSONException
    //   12713	12785	12825	org/json/JSONException
    //   12785	12822	12825	org/json/JSONException
    //   12949	13075	13096	org/json/JSONException
    //   13075	13093	13096	org/json/JSONException
    //   13252	13331	13334	org/json/JSONException
    //   13353	13401	13562	org/json/JSONException
    //   13426	13559	13562	org/json/JSONException
    //   13581	13623	13625	org/json/JSONException
    //   13693	13718	13827	org/json/JSONException
    //   13723	13735	13827	org/json/JSONException
    //   13738	13747	13827	org/json/JSONException
    //   13747	13776	13827	org/json/JSONException
    //   13779	13791	13827	org/json/JSONException
    //   13791	13824	13827	org/json/JSONException
    //   13877	13907	13909	java/lang/Exception
    //   13942	13984	13986	java/lang/Exception
    //   3933	3998	14097	org/json/JSONException
    //   4001	4034	14097	org/json/JSONException
    //   4037	4054	14097	org/json/JSONException
    //   4103	4168	14101	org/json/JSONException
    //   4174	4186	14101	org/json/JSONException
    //   4203	4219	14101	org/json/JSONException
    //   13167	13238	14109	org/json/JSONException
    //   11853	11869	14478	org/json/JSONException
    //   11872	12022	14478	org/json/JSONException
    //   12027	12040	14478	org/json/JSONException
    //   12040	12050	14478	org/json/JSONException
  }
  
  public boolean hasConfig(String paramString)
  {
    return authorizedLists.containsKey(paramString);
  }
  
  public boolean hasRight(String paramString1, String paramString2)
  {
    if (!authorizedLists.containsKey(paramString1)) {
      return false;
    }
    paramString1 = (ArrayList)authorizedLists.get(paramString1);
    if ("QQApi.shareMsg".equals(paramString2))
    {
      if ((!contains(paramString1, "ui.setOnShareQQFriendHandler")) && (!contains(paramString1, "ui.ui.setOnShareQZoneHandler")) && (!contains(paramString1, "ui.ui.setOnShareWXFriendHandler"))) {
        return contains(paramString1, "ui.setOnShareWXTimelineHandler");
      }
      return true;
    }
    if (contains(paramString1, paramString2))
    {
      if ("qbizApi.getNetworkType".equals(paramString2))
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
        return true;
      }
      if ("publicAccount.getLocation".equals(paramString2))
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
        return true;
      }
      if ("ui.closeWebViews".equals(paramString2))
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
        return true;
      }
      if ("troopNotice.showPicture".equals(paramString2)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
      }
      return true;
    }
    return false;
  }
  
  public void hideAllNonBaseMenuItem()
  {
    getMenuHideNameList().clear();
    getMenuHideNameList().add("menuItem:share:qq");
    getMenuHideNameList().add("menuItem:share:QZone");
    getMenuHideNameList().add("menuItem:share:appMessage");
    getMenuHideNameList().add("menuItem:share:timeline");
    getMenuHideNameList().add("menuItem:openWithQQBrowser");
    getMenuHideNameList().add("menuItem:openWithSafari");
    getMenuHideNameList().add("menuItem:favorite");
    getMenuHideNameList().add("menuItem:copyUrl");
    getMenuHideNameList().add("menuItem:exportTencentDocs");
  }
  
  public void hideMenuItems(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!contains(getMenuHideNameList(), str)) {
        getMenuHideNameList().add(str);
      }
    }
  }
  
  public void hideWebToolbar() {}
  
  void init()
  {
    if (this.mInited.compareAndSet(false, true))
    {
      this.mClient = TroopMemberApiClient.a();
      this.mClient.e();
    }
    if (this.mVideoIPCClient == null) {
      this.mVideoIPCClient = ((IVideoFeedsIPCClient)QRoute.api(IVideoFeedsIPCClient.class));
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    boolean bool = false;
    if (paramByte == 1)
    {
      if (paramIntent != null)
      {
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("retCode", 0);
          ((JSONObject)localObject1).put("msg", "Success");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        paramIntent = paramIntent.getStringExtra("scanResult");
        if (this.needResult == 1)
        {
          try
          {
            ((JSONObject)localObject1).put("scanResult", paramIntent);
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
        }
        if (!TextUtils.isEmpty(this.callback)) {
          callJs(this.callback, new String[] { ((JSONObject)localObject1).toString() });
        }
      }
      this.needResult = -1;
      this.scanType = -1;
      return;
    }
    Object localObject1 = "";
    Object localObject2;
    if (paramByte == 112)
    {
      paramIntent = new File(this.cameraPath);
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      try
      {
        if (paramIntent.exists())
        {
          ThreadManager.getFileThreadHandler().post(new PublicAccountH5AbilityPluginImpl.2(this, (JSONArray)localObject2, (JSONObject)localObject1));
          return;
        }
        ((JSONObject)localObject1).put("retCode", 1);
        ((JSONObject)localObject1).put("msg", "cancel");
        ((JSONObject)localObject1).put("sourceType", "camera");
        callJs(this.cameraCallback, new String[] { ((JSONObject)localObject1).toString() });
        this.cameraPath = "";
        this.cameraCallback = "";
        this.cameraUUid = "";
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    Object localObject3;
    if (paramByte == 111)
    {
      localObject2 = new JSONObject();
      localObject3 = new JSONArray();
      if (paramIntent != null) {
        localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        if (((ArrayList)localObject1).size() != 0)
        {
          if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) != 0) {
            continue;
          }
          paramInt = 1;
          if (paramInt == 0) {
            continue;
          }
          ThreadManager.getFileThreadHandler().post(new PublicAccountH5AbilityPluginImpl.3(this, (ArrayList)localObject1, (JSONArray)localObject3, (JSONObject)localObject2));
          return;
          if (paramInt < ((ArrayList)localObject1).size())
          {
            paramIntent = UUID.randomUUID();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mqqpa://resourceid/");
            localStringBuilder.append(paramIntent.toString());
            paramIntent = localStringBuilder.toString();
            ((JSONArray)localObject3).put(paramInt, paramIntent);
            localIdMap.put(paramIntent, ((ArrayList)localObject1).get(paramInt));
            paramInt += 1;
            continue;
          }
          ((JSONObject)localObject2).put("value", localObject3);
          ((JSONObject)localObject2).put("retCode", 0);
          ((JSONObject)localObject2).put("msg", "Success");
          ((JSONObject)localObject2).put("sourceType", "album");
          callJs(this.cameraCallback, new String[] { ((JSONObject)localObject2).toString() });
          this.cameraCallback = "";
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
          return;
        }
        ((JSONObject)localObject2).put("retCode", 1);
        ((JSONObject)localObject2).put("msg", "");
        ((JSONObject)localObject2).put("sourceType", "album");
        callJs(this.cameraCallback, new String[] { ((JSONObject)localObject2).toString() });
        this.cameraCallback = "";
        return;
      }
      catch (JSONException paramIntent)
      {
        int i;
        int j;
        continue;
      }
      paramIntent.printStackTrace();
      return;
      if (paramByte == 113)
      {
        if (paramInt == -1) {
          i = 0;
        } else {
          i = -1;
        }
        if (paramIntent == null) {
          return;
        }
        localObject1 = paramIntent.getStringExtra("result_js_callback");
        localObject2 = paramIntent.getStringExtra("feed_id");
        j = paramIntent.getIntExtra("feedsType", 1);
        if ((localObject1 != null) && (localObject2 != null)) {
          paramIntent = new JSONObject();
        }
      }
      try
      {
        paramIntent.put("feedsId", localObject2);
        paramIntent.put("retCode", i);
        paramIntent.put("feedsType", j);
        callJs((String)localObject1, new String[] { paramIntent.toString() });
      }
      catch (Exception paramIntent)
      {
        continue;
      }
      paramIntent = (IShareReport)QRoute.api(IShareReport.class);
      if (paramInt == -1) {
        bool = true;
      }
      paramIntent.reportResult(bool);
      return;
      if ((paramByte != 114) && (paramByte != 115) && (paramByte != 116) && (paramByte != 122)) {
        if ((paramByte != 118) && (paramByte != 121)) {
          if (paramByte == 117)
          {
            if (paramIntent == null) {
              return;
            }
            localObject1 = paramIntent.getStringExtra("arg_callback");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              return;
            }
            if (paramInt == 1699)
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putParcelable("action_update_biu_and_comment_request", paramIntent);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_update_biu_and_comment_request_action", (Bundle)localObject2, new PublicAccountH5AbilityPluginImpl.4(this, (String)localObject1));
              return;
            }
            paramIntent = paramIntent.getStringExtra("arg_result_json");
            if (paramIntent == null) {}
          }
        }
      }
      try
      {
        paramIntent = new JSONObject(paramIntent);
        continue;
        paramIntent = new JSONObject();
        if (paramInt == -1) {
          paramIntent.put("retCode", 0);
        } else {
          paramIntent.put("retCode", -1);
        }
        paramIntent = paramIntent.toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showCommentEditor result:");
          ((StringBuilder)localObject2).append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent));
          QLog.d("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject2).toString());
        }
        callJs((String)localObject1, new String[] { paramIntent });
        return;
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (paramByte == 119)
      {
        handleInviteFriendResult(paramIntent);
        return;
        if (paramByte != 118)
        {
          if (paramByte == 121) {
            localObject1 = selectAndTopicPicCallback;
          }
        }
        else {
          localObject1 = selectAndUploadAvatarCallback;
        }
        if (paramIntent == null)
        {
          if (paramInt == 0) {
            try
            {
              paramIntent = new JSONObject();
              paramIntent.put("retCode", 1);
              paramIntent.put("msg", HardCodeUtil.a(2131906555));
              paramIntent = paramIntent.toString();
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("selectAndUploadAvatar  result:");
                ((StringBuilder)localObject2).append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent));
                QLog.d("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject2).toString());
              }
              callJs((String)localObject1, new String[] { paramIntent });
              return;
            }
            catch (Exception paramIntent)
            {
              if (QLog.isColorLevel()) {
                QLog.e("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramIntent));
              }
            }
          }
          return;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        if (paramInt == -1)
        {
          localObject2 = paramIntent.getBundleExtra("Bundle");
          if (localObject2 != null)
          {
            paramInt = ((Bundle)localObject2).getInt("retCode");
            paramIntent = ((Bundle)localObject2).getString("url");
            localObject2 = ((Bundle)localObject2).getString("msg");
            try
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("retCode", paramInt);
              ((JSONObject)localObject3).put("url", paramIntent);
              ((JSONObject)localObject3).put("msg", localObject2);
              paramIntent = ((JSONObject)localObject3).toString();
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("selectAndUploadAvatar  result:");
                ((StringBuilder)localObject2).append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent));
                QLog.d("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject2).toString());
              }
              callJs((String)localObject1, new String[] { paramIntent });
              return;
            }
            catch (Exception paramIntent)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            QLog.e("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramIntent));
          }
        }
        else
        {
          try
          {
            paramIntent = new JSONObject();
            paramIntent.put("retCode", -1);
            paramIntent = paramIntent.toString();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(" selectAndUploadAvatar result:");
              ((StringBuilder)localObject1).append(paramIntent);
              QLog.d("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject1).toString());
            }
            callJs(this.callback, new String[] { paramIntent });
            return;
          }
          catch (Exception paramIntent)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          QLog.e("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramIntent));
          return;
          if (paramIntent == null) {
            return;
          }
          localObject2 = paramIntent.getStringExtra("arg_callback");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            return;
          }
          if (paramByte != 122) {
            switch (paramByte)
            {
            default: 
              break;
            case 116: 
              localObject1 = "showUGCVideoRecordPage";
              break;
            case 115: 
              localObject1 = "showUGCVideoUploadPage";
              break;
            case 114: 
              localObject1 = "showUGCEditPage";
              break;
            }
          } else {
            localObject1 = "showQAAskEditor";
          }
          if (paramInt == -1)
          {
            paramIntent = paramIntent.getStringExtra("arg_result_json");
            if (paramIntent != null)
            {
              paramIntent = new JSONObject(paramIntent);
              paramIntent.put("retCode", 0);
              paramIntent = paramIntent.toString();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append(" result:");
                ((StringBuilder)localObject3).append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent));
                QLog.d("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject3).toString());
              }
              callJs((String)localObject2, new String[] { paramIntent });
            }
          }
          else
          {
            paramIntent = new JSONObject();
            paramIntent.put("retCode", -1);
            paramIntent = paramIntent.toString();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(" result:");
              ((StringBuilder)localObject3).append(paramIntent);
              QLog.d("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject3).toString());
            }
            callJs((String)localObject2, new String[] { paramIntent });
          }
        }
      }
      return;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.app = this.mRuntime.b();
      this.activity = this.mRuntime.d();
      this.uin = this.app.getAccount();
    }
    init();
  }
  
  protected void onDestroy()
  {
    if (this.mRuntime != null)
    {
      localObject = this.mRuntime.a();
      if (localObject != null) {
        cleanConfig(((CustomWebView)localObject).getUrl());
      }
    }
    super.onDestroy();
    if (this.mInited.get())
    {
      cancleAllUploadAndDownloadTask();
      localObject = this.mClient;
      if (localObject != null) {
        ((TroopMemberApiClient)localObject).f();
      }
      getMenuHideNameList().clear();
      localObject = this.ptt;
      if (localObject != null) {
        ((PublicAccountH5AbilityPttImpl)localObject).cancelPttRecorderAndPlayTask();
      }
    }
    Object localObject = this.mVideoWebPreDownload;
    if (localObject != null)
    {
      ((IVideoWebPreDownload)localObject).b();
      this.mVideoWebPreDownload = null;
    }
  }
  
  protected void onPause()
  {
    PublicAccountH5AbilityPttImpl localPublicAccountH5AbilityPttImpl = this.ptt;
    if (localPublicAccountH5AbilityPttImpl != null) {
      localPublicAccountH5AbilityPttImpl.cancelPttRecorderAndPlayTask();
    }
  }
  
  public void openLocation()
  {
    Object localObject = this.activity;
    if (localObject == null) {
      return;
    }
    localObject = new Intent((Context)localObject, PoiMapActivity.class).putExtra("uin", this.uin);
    this.activity.startActivity((Intent)localObject);
    this.mClient.g();
  }
  
  public void selectPhotoFromGallery(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.activity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 25);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.a);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.a);
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyUploadAvatarFragmentClazz().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localActivityURIRequest.extra().putBoolean("key_from_kandian_uploadimg", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("readinjoy_avatar_upload/");
    localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = localStringBuilder.toString();
    localActivityURIRequest.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
    localActivityURIRequest.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_WIDTH", paramInt3);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_HEIGHT", paramInt4);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_WIDTH", paramInt5);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_HEIGHT", paramInt6);
    localActivityURIRequest.extra().putInt("from", paramInt1);
    localActivityURIRequest.extra().putInt("type", paramInt2);
    if (this.mRuntime.f() != null)
    {
      paramInt1 = this.mRuntime.f().switchRequestCode(this, paramByte);
      localActivityURIRequest.extra().putString("keyAction", "actionSelectPicture");
      localActivityURIRequest.extra().putInt("requestCode", paramInt1);
    }
    localActivityURIRequest.setRequestCode(paramByte);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.activity, false, true);
  }
  
  void sendAuthRequest(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.8.17,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("鉴权body为:  ");
      localStringBuilder.append(paramString2);
      QLog.i("PublicAccountH5AbilityPlugin", 2, localStringBuilder.toString());
    }
    localNewIntent.setObserver(new PublicAccountH5AbilityPluginImpl.18(this, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.app.startServlet(localNewIntent);
  }
  
  void sendMediaIdForUuidRequest(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.8.17,3,0");
    localJSApiWebServerRequest.cmd.set(this.CMD_FOR_UUID);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.pUin);
      localJSONObject.put("mediaid", paramString1);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localJSApiWebServerRequest.body.set(localJSONObject.toString());
    localNewIntent.setObserver(new PublicAccountH5AbilityPluginImpl.17(this, paramString2, paramInt, paramBoolean, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.app.startServlet(localNewIntent);
  }
  
  void sendUuidForMediaIdRequest(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.8.17,3,0");
    localJSApiWebServerRequest.cmd.set(this.CMD_FOR_MEDIAID);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.pUin);
      if (paramBoolean)
      {
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      else
      {
        localJSONObject.put("type", "4");
        if (this.ptt == null) {
          this.ptt = new PublicAccountH5AbilityPttImpl(this.activity, this.uin, this.mRuntime);
        }
        this.ptt.checkFileInfo();
        localJSONObject.put("file_uuid", paramString1);
        Object localObject = this.ptt;
        localJSONObject.put("file_md5", PublicAccountH5AbilityPttImpl.getMd5ForPtt());
        localObject = this.ptt;
        localJSONObject.put("file_name", PublicAccountH5AbilityPttImpl.getFileNameForPtt());
        localObject = this.ptt;
        localJSONObject.put("file_size", PublicAccountH5AbilityPttImpl.getFileSizeForPtt());
        localObject = this.ptt;
        localJSONObject.put("file_time", PublicAccountH5AbilityPttImpl.getTimeForPtt());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendUuidForMediaIdRequest file_uuid = ");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(" file_md5=");
          paramString1 = this.ptt;
          ((StringBuilder)localObject).append(PublicAccountH5AbilityPttImpl.getMd5ForPtt());
          ((StringBuilder)localObject).append(" file_name:");
          paramString1 = this.ptt;
          ((StringBuilder)localObject).append(PublicAccountH5AbilityPttImpl.getFileNameForPtt());
          ((StringBuilder)localObject).append(" file_size=");
          paramString1 = this.ptt;
          ((StringBuilder)localObject).append(PublicAccountH5AbilityPttImpl.getFileSizeForPtt());
          ((StringBuilder)localObject).append(" file_time=");
          paramString1 = this.ptt;
          ((StringBuilder)localObject).append(PublicAccountH5AbilityPttImpl.getTimeForPtt());
          QLog.i("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    localJSApiWebServerRequest.body.set(localJSONObject.toString());
    localNewIntent.setObserver(new PublicAccountH5AbilityPluginImpl.16(this, paramBoolean, paramString2));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.app.startServlet(localNewIntent);
  }
  
  public void setRightButtonState(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
    if (this.mRuntime.f() != null) {
      this.mRuntime.f().getWebTitleBarInterface().e(paramBoolean);
    }
  }
  
  public void showAllNonBaseMenuItem()
  {
    getMenuHideNameList().clear();
  }
  
  public void showMenuItems(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      remove(getMenuHideNameList(), str);
    }
  }
  
  public void showOfficialAccountProfile(String paramString)
  {
    Object localObject = this.activity;
    if (localObject == null) {
      return;
    }
    localObject = new ActivityURIRequest((Context)localObject, "/pubaccount/detail");
    ((ActivityURIRequest)localObject).extra().putString("uin", paramString);
    ((ActivityURIRequest)localObject).extra().putBoolean("fromBrowser", true);
    QRoute.startUri((URIRequest)localObject, null);
  }
  
  public void showPAactionSheet(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.paActionSheet == null) {
      this.paActionSheet = ((ActionSheet)ActionSheetHelper.b(this.activity, null));
    }
    Object localObject = LayoutInflater.from(this.activity).inflate(2131627640, null);
    this.paActionSheet.setActionContentView((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131433436);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131433434);
    localObject = (TextView)((View)localObject).findViewById(2131433471);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    else if (paramInt1 == 2)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView1.setVisibility(8);
    }
    if (!this.paActionSheet.isShowing()) {
      this.paActionSheet.show();
    }
    localTextView1.setOnClickListener(new PublicAccountH5AbilityPluginImpl.19(this, paramString));
    localTextView2.setOnClickListener(new PublicAccountH5AbilityPluginImpl.20(this, paramInt3, paramInt2, paramString));
    ((TextView)localObject).setOnClickListener(new PublicAccountH5AbilityPluginImpl.21(this));
  }
  
  void showProgressDialog()
  {
    try
    {
      if (this.mPd != null)
      {
        cancleProgressDailog();
      }
      else
      {
        this.mPd = new ProgressDialog(this.activity, 2131953338);
        this.mPd.setCancelable(true);
        this.mPd.show();
        this.mPd.setContentView(2131625585);
        ((TextView)this.mPd.findViewById(2131440191)).setText(HardCodeUtil.a(2131906575));
      }
      if (!this.mPd.isShowing()) {
        this.mPd.show();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void showReadInJoyNativeCommentView(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    paramObject = (CallCommentJs)paramObject;
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.e();
    showReadInJoyNativeCommentView(paramJSONObject, localTroopMemberApiClient.e(new PublicAccountH5AbilityPluginImpl.14(this, paramObject, paramString)));
  }
  
  public void showWebPanel()
  {
    if (this.mRuntime.f() != null) {
      this.mRuntime.f().showActionSheet();
    }
  }
  
  public void showWebToolbar() {}
  
  void startDownload(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str2 = this.pUin;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2)) {}
    }
    else
    {
      str1 = "12345678";
    }
    try
    {
      Long.parseLong(str1);
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    String str1 = "12345678";
    if ((this.mClient != null) && (!"".equals(paramString1))) {
      this.mClient.b(paramString1, paramInt, str1, paramBoolean, new PublicAccountH5AbilityPluginImpl.24(this, paramBoolean, paramString3, paramString2), new PublicAccountH5AbilityPluginImpl.25(this));
    }
  }
  
  void startNextDownloadTask(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.downloadBeensList.iterator();
      while (localIterator.hasNext())
      {
        PublicAccountH5AbilityPluginImpl.DownloadBeen localDownloadBeen = (PublicAccountH5AbilityPluginImpl.DownloadBeen)localIterator.next();
        if (paramString.equals(localDownloadBeen.b)) {
          localArrayList.add(localDownloadBeen);
        }
      }
      this.downloadBeensList.removeAll(localArrayList);
    }
    if (this.downloadBeensList.size() > 0)
    {
      paramString = (PublicAccountH5AbilityPluginImpl.DownloadBeen)this.downloadBeensList.get(0);
      sendMediaIdForUuidRequest(paramString.b, paramString.c, true, paramString.a);
    }
  }
  
  void startNextUploadTask(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("pic_local_path");
    if (paramBundle != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = localIdMap.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (paramBundle.equals(((Map.Entry)localObject3).getValue())) {
          ((ArrayList)localObject1).add((String)((Map.Entry)localObject3).getKey());
        }
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.uploadBeensList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          PublicAccountH5AbilityPluginImpl.UploadBeen localUploadBeen = (PublicAccountH5AbilityPluginImpl.UploadBeen)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localUploadBeen.b)) {
            paramBundle.add(localUploadBeen);
          }
        }
      }
      this.uploadBeensList.removeAll(paramBundle);
      if (this.uploadBeensList.size() > 0)
      {
        paramBundle = (PublicAccountH5AbilityPluginImpl.UploadBeen)this.uploadBeensList.get(0);
        localObject1 = (String)localIdMap.get(paramBundle.b);
        startUpload(paramBundle.c, (String)localObject1, true, paramBundle.a);
      }
    }
  }
  
  void startUpload(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = this.pUin;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!"".equals(localObject2)) {}
    }
    else
    {
      localObject1 = "12345678";
    }
    try
    {
      Long.parseLong((String)localObject1);
    }
    catch (Exception localException)
    {
      label39:
      StringBuilder localStringBuilder;
      break label39;
    }
    Object localObject1 = "12345678";
    if ((this.mClient != null) && (!"".equals(paramString1)))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("HttpUtil.getNetWorkType()");
        ((StringBuilder)localObject2).append(HttpUtil.getNetWorkType());
        QLog.d("PAH5Manager", 2, ((StringBuilder)localObject2).toString());
      }
      if (HttpUtil.getNetWorkType() != 1)
      {
        localObject2 = new File(paramString1);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("size");
          localStringBuilder.append(((File)localObject2).length());
          QLog.d("PAH5Manager", 2, localStringBuilder.toString());
        }
        if (((File)localObject2).length() > 204800L) {
          QQToast.makeText(this.activity, "你已离开wifi环境", 0).show();
        }
      }
      this.mClient.a(paramString1, paramInt, (String)localObject1, paramBoolean, new PublicAccountH5AbilityPluginImpl.22(this, paramString2, paramBoolean), new PublicAccountH5AbilityPluginImpl.23(this));
    }
  }
  
  public void takePicture()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("c2bCAM/");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      callJs(this.cameraCallback, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    this.cameraUUid = UUID.randomUUID().toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.cameraUUid);
    localStringBuilder.append(".jpg");
    this.cameraPath = localStringBuilder.toString();
    localObject = new Intent();
    FileProvider7Helper.setSystemCapture(this.activity, new File(this.cameraPath), (Intent)localObject);
    try
    {
      startActivityForResult((Intent)localObject, (byte)112);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl
 * JD-Core Version:    0.7.0.1
 */