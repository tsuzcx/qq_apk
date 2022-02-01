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
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallJs;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
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
  public static String appIdStr = null;
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
  VideoFeedsIPCClient mVideoIPCClient = null;
  VideoWebPreDownload mVideoWebPreDownload = null;
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
  
  public static void getAppType(BridgeModule.CallJs paramCallJs, String paramString)
  {
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_get_app_type_action", new Bundle(), new PublicAccountH5AbilityPluginImpl.12(paramCallJs, paramString));
  }
  
  public static void getUserInfoIpc(long paramLong, BridgeModule.CallJs paramCallJs, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_get_user_info_action", localBundle, new PublicAccountH5AbilityPluginImpl.13(paramCallJs, paramString));
  }
  
  private void handleInviteFriendResult(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.activity == null)) {}
    String str2;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str2));
    int i = paramIntent.getIntExtra("result_code", -1);
    if (i == 0) {
      this.mHandler.postDelayed(new PublicAccountH5AbilityPluginImpl.15(this), 200L);
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
      callJs(str2, new String[] { paramIntent.toString() });
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
  
  private void innerOpenCameraCaptureActivity(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (RIJUGCDianDian.a() >= 2)
    {
      QQToast.a(this.activity, 0, this.activity.getString(2131718219), 0).b(this.activity.getResources().getDimensionPixelSize(2131299166));
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
    ReadInJoyCaptureLauncher.a(this, this.mRuntime.a(), paramString4, (byte)116);
    RIJUGCDianDian.a("2", "2");
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
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
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
  }
  
  private void selectAndInviteFriend(String paramString, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (this.activity != null)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend param json:" + ((JSONObject)localObject1).toString());
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
              break label337;
            }
            ((StringBuilder)localObject1).append(",");
            break label337;
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
        PublicFragmentActivity.a(this.activity, (Intent)localObject2, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend e = " + paramString);
        }
        paramString.printStackTrace();
        return;
      }
      label337:
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
    if (!NetworkUtil.g(this.mRuntime.a()))
    {
      QRUtils.a(1, 2131693237);
      return;
    }
    localObject = new QQProgressDialog(this.mRuntime.a());
    ((QQProgressDialog)localObject).c(2131693940);
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
        int i = 0;
        if (localObject1 != null) {
          i = ((JSONArray)localObject1).length();
        }
        if (Boolean.valueOf(bool3).booleanValue())
        {
          paramString = new PublicAccountShowPictureReport();
          paramString.parse((JSONObject)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountH5AbilityPlugin", 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
          }
          if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountH5AbilityPlugin", 2, "imageList is null or length is 0");
            return;
          }
          localObject2 = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).get(j).toString());
            j += 1;
            continue;
          }
          if (this.activity == null) {
            break;
          }
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
          if ((paramString != null) && (paramString.isReport)) {
            localBundle.putString("PublicAccountShowPictureReport", paramString.toString());
          }
          ((Intent)localObject1).putExtras(localBundle);
          this.activity.startActivityForResult((Intent)localObject1, 100);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = null;
    }
  }
  
  public static void showReadInJoyNativeCommentView(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      int n;
      try
      {
        str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str5 = paramJSONObject.optString("sourceName", "");
        str2 = paramJSONObject.optString("picUrl", "");
        long l = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        localObject1 = paramJSONObject.optString("commentID");
        String str4 = paramJSONObject.optString("subCommentID");
        bool1 = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        n = paramJSONObject.optInt("showType", 0);
        boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
        QLog.d("PublicAccountH5AbilityPlugin", 1, "startShowComment  uniqueKey = " + str1 + "source = " + i + "feedsId = " + (String)localObject2 + " feedsType=" + j + "adTag = " + k + "title = " + str3 + "sourceName = " + str5 + "picUrl =" + str2 + "duration = " + l + "articleId =" + str6);
        localBundle = new Bundle();
        localBundle.putSerializable("commonCommentData", new CommonCommentData(str6, j, (String)localObject2, k, str3, str5, str2, l));
        localBundle.putInt("source", i);
        localBundle.putString("commentId", (String)localObject1);
        localBundle.putString("subCommentId", str4);
        localBundle.putBoolean("isAwesome", bool1);
        localBundle.putInt("jumpType", m);
        localBundle.putInt("seq", paramInt);
        localBundle.putBoolean("canBiu", bool2);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((AnchorData)localObject2).jdField_b_of_type_JavaLangString = str4;
        ((AnchorData)localObject2).jdField_a_of_type_Boolean = bool1;
        ((AnchorData)localObject2).jdField_b_of_type_Boolean = true;
        QLog.d("PublicAccountH5AbilityPlugin", 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str4);
        localObject1 = BaseActivity.sTopActivity;
        if (str3 == null) {
          break label535;
        }
        paramJSONObject = new String(Base64Util.decode(str3, 0));
      }
      catch (Exception paramJSONObject)
      {
        String str1;
        Object localObject2;
        String str2;
        Object localObject1;
        Bundle localBundle;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramJSONObject));
        return;
      }
      ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, paramJSONObject, null, str2, (AnchorData)localObject2, false, bool1, localBundle);
      return;
      boolean bool1 = false;
      continue;
      label535:
      paramJSONObject = null;
      if (n == 1) {
        bool1 = true;
      }
    }
  }
  
  public static void updateUserInfoIPC(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).optJSONArray("uinList");
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
      QLog.e("PublicAccountH5AbilityPlugin", 1, "[updateUserInfo] e = " + paramString);
    }
  }
  
  public void cancleAllUploadAndDownloadTask()
  {
    if (this.mClient != null) {
      this.mClient.f();
    }
    this.uploadBeensList.clear();
    this.downloadBeensList.clear();
    this.cameraPath = "";
    this.cameraCallback = "";
    this.cameraUUid = "";
  }
  
  void cancleProgressDailog()
  {
    if ((this.mPd != null) && (this.mPd.isShowing())) {
      this.mPd.cancel();
    }
  }
  
  public void choosePicture(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.activity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localIntent.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", HardCodeUtil.a(2131708753));
    if (paramInt2 == 1)
    {
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 2);
      if (paramInt2 != 0) {
        break label168;
      }
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.quality_count_tv", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.activity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      if (this.mRuntime.a() != null) {
        WebViewUtil.a(this, localIntent, (byte)111, this.mRuntime.a());
      }
      return;
      if (paramInt2 != 2) {
        break;
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label168:
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.putExtra("PhotoConst.quality_count_tv", false);
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
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i)).equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void downloadShortVideoFilterSo()
  {
    if (this.mClient == null) {
      this.mClient = TroopMemberApiClient.a();
    }
    this.mClient.e();
  }
  
  public ArrayList<String> getMenuHideNameList()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
    if (localSwiftBrowserShareMenuHandler != null) {
      return localSwiftBrowserShareMenuHandler.jdField_a_of_type_JavaUtilArrayList;
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
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.d("PublicAccountH5AbilityPlugin", 1, paramString.getMessage());
      }
    }
  }
  
  public String getUserInfoJson(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    int i = 0;
    JSONObject localJSONObject1 = new JSONObject();
    if (paramReadInJoyUserInfo != null) {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("accountType", Integer.valueOf(paramReadInJoyUserInfo.accountType));
        localJSONObject2.putOpt("uin", paramReadInJoyUserInfo.uin);
        localJSONObject1.putOpt("accountInfo", localJSONObject2);
        localJSONObject1.putOpt("nickName", paramReadInJoyUserInfo.nick);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("faceType", Integer.valueOf(paramReadInJoyUserInfo.faceType));
        localJSONObject2.putOpt("timeStamp", Long.valueOf(paramReadInJoyUserInfo.timestamp));
        localJSONObject2.putOpt("faceFlag", Integer.valueOf(paramReadInJoyUserInfo.faceFlag));
        localJSONObject2.putOpt("url", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
        localJSONObject2.putOpt("sysID", Integer.valueOf(paramReadInJoyUserInfo.systemID));
        localJSONObject1.putOpt("headerInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("ccLevel", Integer.valueOf(paramReadInJoyUserInfo.accountLevel));
        localJSONObject2.putOpt("iconUrlSmall", paramReadInJoyUserInfo.smallIconUrl);
        localJSONObject2.putOpt("iconUrlLarge", paramReadInJoyUserInfo.largeIconUrl);
        localJSONObject1.putOpt("accountLevelInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        if (paramReadInJoyUserInfo.isLiving()) {
          i = 1;
        }
        localJSONObject2.putOpt("isLiving", Integer.valueOf(i));
        localJSONObject2.putOpt("source", Integer.valueOf(paramReadInJoyUserInfo.getLiveSource()));
        localJSONObject2.putOpt("url", paramReadInJoyUserInfo.getLiveUrl());
        localJSONObject1.putOpt("liveStatusInfo", localJSONObject2);
        localJSONObject1.putOpt("retCode", Integer.valueOf(0));
        localJSONObject1.putOpt("retMsg", "");
        paramReadInJoyUserInfo = localJSONObject1.toString();
        return paramReadInJoyUserInfo;
      }
      catch (Exception paramReadInJoyUserInfo)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, paramReadInJoyUserInfo.getMessage());
      }
    }
    try
    {
      localJSONObject1.putOpt("retCode", Integer.valueOf(-1));
      localJSONObject1.putOpt("retMsg", paramReadInJoyUserInfo.getMessage());
      return localJSONObject1.toString();
    }
    catch (Exception paramReadInJoyUserInfo)
    {
      for (;;)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, paramReadInJoyUserInfo.getMessage());
      }
    }
  }
  
  public WebResourceResponse getWebResponse(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (String)localIdMap.get(paramString);
        if (paramString == null) {
          return null;
        }
        paramString = CrmUtils.a(SafeBitmapFactory.decodeFile(paramString));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/png", "UTF-8", paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  public WebViewPlugin getWebViewPlugin()
  {
    return this;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
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
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: aload_3
    //   4: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   7: ifeq +4484 -> 4491
    //   10: ldc_w 1141
    //   13: aload 4
    //   15: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifeq +125 -> 143
    //   21: aload 5
    //   23: ifnull +82 -> 105
    //   26: aload 5
    //   28: arraylength
    //   29: ifle +76 -> 105
    //   32: new 355	org/json/JSONObject
    //   35: dup
    //   36: aload 5
    //   38: iconst_0
    //   39: aaload
    //   40: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: ldc_w 525
    //   46: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +47 -> 101
    //   57: new 355	org/json/JSONObject
    //   60: dup
    //   61: invokespecial 356	org/json/JSONObject:<init>	()V
    //   64: astore_2
    //   65: aload_2
    //   66: ldc_w 358
    //   69: iconst_0
    //   70: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_2
    //   75: ldc_w 363
    //   78: ldc_w 1143
    //   81: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_0
    //   86: aload_1
    //   87: iconst_1
    //   88: anewarray 368	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: aload_2
    //   94: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   97: aastore
    //   98: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 1145	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:openLocation	()V
    //   105: aconst_null
    //   106: ldc_w 1147
    //   109: ldc_w 1149
    //   112: ldc 232
    //   114: ldc_w 1151
    //   117: ldc_w 1151
    //   120: iconst_0
    //   121: iconst_0
    //   122: ldc 232
    //   124: ldc 232
    //   126: ldc 232
    //   128: ldc 232
    //   130: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   140: goto -35 -> 105
    //   143: ldc_w 1158
    //   146: aload 4
    //   148: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   151: ifeq +56 -> 207
    //   154: aload 5
    //   156: ifnull +41 -> 197
    //   159: aload 5
    //   161: arraylength
    //   162: ifle +35 -> 197
    //   165: new 355	org/json/JSONObject
    //   168: dup
    //   169: aload 5
    //   171: iconst_0
    //   172: aaload
    //   173: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   176: ldc_w 299
    //   179: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_1
    //   183: ldc 232
    //   185: aload_1
    //   186: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifne +8 -> 197
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 1160	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showOfficialAccountProfile	(Ljava/lang/String;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: ldc_w 1162
    //   210: aload 4
    //   212: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   215: ifeq +97 -> 312
    //   218: aload 5
    //   220: ifnull +82 -> 302
    //   223: aload 5
    //   225: arraylength
    //   226: ifle +76 -> 302
    //   229: new 355	org/json/JSONObject
    //   232: dup
    //   233: aload 5
    //   235: iconst_0
    //   236: aaload
    //   237: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   240: ldc_w 525
    //   243: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_1
    //   247: aload_1
    //   248: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +47 -> 298
    //   254: new 355	org/json/JSONObject
    //   257: dup
    //   258: invokespecial 356	org/json/JSONObject:<init>	()V
    //   261: astore_2
    //   262: aload_2
    //   263: ldc_w 358
    //   266: iconst_0
    //   267: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   270: pop
    //   271: aload_2
    //   272: ldc_w 363
    //   275: ldc_w 1143
    //   278: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   281: pop
    //   282: aload_0
    //   283: aload_1
    //   284: iconst_1
    //   285: anewarray 368	java/lang/String
    //   288: dup
    //   289: iconst_0
    //   290: aload_2
    //   291: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   294: aastore
    //   295: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   298: aload_0
    //   299: invokevirtual 1164	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showWebPanel	()V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   309: goto -7 -> 302
    //   312: ldc_w 1166
    //   315: aload 4
    //   317: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   320: ifeq +110 -> 430
    //   323: aload 5
    //   325: ifnull +95 -> 420
    //   328: aload 5
    //   330: arraylength
    //   331: ifle +89 -> 420
    //   334: new 355	org/json/JSONObject
    //   337: dup
    //   338: aload 5
    //   340: iconst_0
    //   341: aaload
    //   342: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   345: astore_1
    //   346: aload_1
    //   347: ldc_w 1168
    //   350: invokevirtual 808	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   353: istore 13
    //   355: aload_1
    //   356: ldc_w 525
    //   359: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore_1
    //   363: aload_1
    //   364: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   367: ifne +47 -> 414
    //   370: new 355	org/json/JSONObject
    //   373: dup
    //   374: invokespecial 356	org/json/JSONObject:<init>	()V
    //   377: astore_2
    //   378: aload_2
    //   379: ldc_w 358
    //   382: iconst_0
    //   383: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload_2
    //   388: ldc_w 363
    //   391: ldc_w 1143
    //   394: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload_0
    //   399: aload_1
    //   400: iconst_1
    //   401: anewarray 368	java/lang/String
    //   404: dup
    //   405: iconst_0
    //   406: aload_2
    //   407: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   410: aastore
    //   411: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   414: aload_0
    //   415: iload 13
    //   417: invokevirtual 1170	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:setRightButtonState	(Z)V
    //   420: iconst_1
    //   421: ireturn
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   427: goto -7 -> 420
    //   430: ldc_w 1172
    //   433: aload 4
    //   435: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   438: ifeq +180 -> 618
    //   441: aload 5
    //   443: ifnull +137 -> 580
    //   446: aload 5
    //   448: arraylength
    //   449: ifle +131 -> 580
    //   452: new 355	org/json/JSONObject
    //   455: dup
    //   456: aload 5
    //   458: iconst_0
    //   459: aaload
    //   460: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   463: astore_2
    //   464: aload_2
    //   465: ldc_w 525
    //   468: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   471: astore_1
    //   472: aload_2
    //   473: ldc_w 1174
    //   476: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   479: astore_3
    //   480: new 249	java/util/ArrayList
    //   483: dup
    //   484: invokespecial 250	java/util/ArrayList:<init>	()V
    //   487: astore_2
    //   488: aload_3
    //   489: ifnull +35 -> 524
    //   492: iconst_0
    //   493: istore 6
    //   495: iload 6
    //   497: aload_3
    //   498: invokevirtual 539	org/json/JSONArray:length	()I
    //   501: if_icmpge +23 -> 524
    //   504: aload_2
    //   505: aload_3
    //   506: iload 6
    //   508: invokevirtual 1176	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   511: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   514: pop
    //   515: iload 6
    //   517: iconst_1
    //   518: iadd
    //   519: istore 6
    //   521: goto -26 -> 495
    //   524: aload_1
    //   525: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   528: ifne +47 -> 575
    //   531: new 355	org/json/JSONObject
    //   534: dup
    //   535: invokespecial 356	org/json/JSONObject:<init>	()V
    //   538: astore_3
    //   539: aload_3
    //   540: ldc_w 358
    //   543: iconst_0
    //   544: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload_3
    //   549: ldc_w 363
    //   552: ldc_w 1143
    //   555: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   558: pop
    //   559: aload_0
    //   560: aload_1
    //   561: iconst_1
    //   562: anewarray 368	java/lang/String
    //   565: dup
    //   566: iconst_0
    //   567: aload_3
    //   568: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   571: aastore
    //   572: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   575: aload_0
    //   576: aload_2
    //   577: invokevirtual 1179	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:hideMenuItems	(Ljava/util/ArrayList;)V
    //   580: aconst_null
    //   581: ldc_w 1147
    //   584: ldc_w 1149
    //   587: ldc 232
    //   589: ldc_w 1181
    //   592: ldc_w 1181
    //   595: iconst_0
    //   596: iconst_0
    //   597: ldc 232
    //   599: ldc 232
    //   601: ldc 232
    //   603: ldc 232
    //   605: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   608: iconst_1
    //   609: ireturn
    //   610: astore_1
    //   611: aload_1
    //   612: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   615: goto -35 -> 580
    //   618: ldc_w 1183
    //   621: aload 4
    //   623: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   626: ifeq +180 -> 806
    //   629: aload 5
    //   631: ifnull +137 -> 768
    //   634: aload 5
    //   636: arraylength
    //   637: ifle +131 -> 768
    //   640: new 355	org/json/JSONObject
    //   643: dup
    //   644: aload 5
    //   646: iconst_0
    //   647: aaload
    //   648: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   651: astore_2
    //   652: aload_2
    //   653: ldc_w 525
    //   656: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   659: astore_1
    //   660: aload_2
    //   661: ldc_w 1174
    //   664: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   667: astore_3
    //   668: new 249	java/util/ArrayList
    //   671: dup
    //   672: invokespecial 250	java/util/ArrayList:<init>	()V
    //   675: astore_2
    //   676: aload_3
    //   677: ifnull +35 -> 712
    //   680: iconst_0
    //   681: istore 6
    //   683: iload 6
    //   685: aload_3
    //   686: invokevirtual 539	org/json/JSONArray:length	()I
    //   689: if_icmpge +23 -> 712
    //   692: aload_2
    //   693: aload_3
    //   694: iload 6
    //   696: invokevirtual 1176	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   699: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   702: pop
    //   703: iload 6
    //   705: iconst_1
    //   706: iadd
    //   707: istore 6
    //   709: goto -26 -> 683
    //   712: aload_1
    //   713: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   716: ifne +47 -> 763
    //   719: new 355	org/json/JSONObject
    //   722: dup
    //   723: invokespecial 356	org/json/JSONObject:<init>	()V
    //   726: astore_3
    //   727: aload_3
    //   728: ldc_w 358
    //   731: iconst_0
    //   732: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   735: pop
    //   736: aload_3
    //   737: ldc_w 363
    //   740: ldc_w 1143
    //   743: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   746: pop
    //   747: aload_0
    //   748: aload_1
    //   749: iconst_1
    //   750: anewarray 368	java/lang/String
    //   753: dup
    //   754: iconst_0
    //   755: aload_3
    //   756: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   759: aastore
    //   760: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   763: aload_0
    //   764: aload_2
    //   765: invokevirtual 1185	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showMenuItems	(Ljava/util/ArrayList;)V
    //   768: aconst_null
    //   769: ldc_w 1147
    //   772: ldc_w 1149
    //   775: ldc 232
    //   777: ldc_w 1187
    //   780: ldc_w 1187
    //   783: iconst_0
    //   784: iconst_0
    //   785: ldc 232
    //   787: ldc 232
    //   789: ldc 232
    //   791: ldc 232
    //   793: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   796: iconst_1
    //   797: ireturn
    //   798: astore_1
    //   799: aload_1
    //   800: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   803: goto -35 -> 768
    //   806: ldc_w 1189
    //   809: aload 4
    //   811: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   814: ifeq +125 -> 939
    //   817: aload 5
    //   819: ifnull +82 -> 901
    //   822: aload 5
    //   824: arraylength
    //   825: ifle +76 -> 901
    //   828: new 355	org/json/JSONObject
    //   831: dup
    //   832: aload 5
    //   834: iconst_0
    //   835: aaload
    //   836: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   839: ldc_w 525
    //   842: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   845: astore_1
    //   846: aload_1
    //   847: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   850: ifne +47 -> 897
    //   853: new 355	org/json/JSONObject
    //   856: dup
    //   857: invokespecial 356	org/json/JSONObject:<init>	()V
    //   860: astore_2
    //   861: aload_2
    //   862: ldc_w 358
    //   865: iconst_0
    //   866: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   869: pop
    //   870: aload_2
    //   871: ldc_w 363
    //   874: ldc_w 1143
    //   877: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   880: pop
    //   881: aload_0
    //   882: aload_1
    //   883: iconst_1
    //   884: anewarray 368	java/lang/String
    //   887: dup
    //   888: iconst_0
    //   889: aload_2
    //   890: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   893: aastore
    //   894: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   897: aload_0
    //   898: invokevirtual 1191	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:hideAllNonBaseMenuItem	()V
    //   901: aconst_null
    //   902: ldc_w 1147
    //   905: ldc_w 1149
    //   908: ldc 232
    //   910: ldc_w 1193
    //   913: ldc_w 1193
    //   916: iconst_0
    //   917: iconst_0
    //   918: ldc 232
    //   920: ldc 232
    //   922: ldc 232
    //   924: ldc 232
    //   926: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   929: iconst_1
    //   930: ireturn
    //   931: astore_1
    //   932: aload_1
    //   933: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   936: goto -35 -> 901
    //   939: ldc_w 1195
    //   942: aload 4
    //   944: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   947: ifeq +125 -> 1072
    //   950: aload 5
    //   952: ifnull +82 -> 1034
    //   955: aload 5
    //   957: arraylength
    //   958: ifle +76 -> 1034
    //   961: new 355	org/json/JSONObject
    //   964: dup
    //   965: aload 5
    //   967: iconst_0
    //   968: aaload
    //   969: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   972: ldc_w 525
    //   975: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   978: astore_1
    //   979: aload_1
    //   980: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   983: ifne +47 -> 1030
    //   986: new 355	org/json/JSONObject
    //   989: dup
    //   990: invokespecial 356	org/json/JSONObject:<init>	()V
    //   993: astore_2
    //   994: aload_2
    //   995: ldc_w 358
    //   998: iconst_0
    //   999: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1002: pop
    //   1003: aload_2
    //   1004: ldc_w 363
    //   1007: ldc_w 1143
    //   1010: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1013: pop
    //   1014: aload_0
    //   1015: aload_1
    //   1016: iconst_1
    //   1017: anewarray 368	java/lang/String
    //   1020: dup
    //   1021: iconst_0
    //   1022: aload_2
    //   1023: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1026: aastore
    //   1027: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1030: aload_0
    //   1031: invokevirtual 1197	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showAllNonBaseMenuItem	()V
    //   1034: aconst_null
    //   1035: ldc_w 1147
    //   1038: ldc_w 1149
    //   1041: ldc 232
    //   1043: ldc_w 1199
    //   1046: ldc_w 1199
    //   1049: iconst_0
    //   1050: iconst_0
    //   1051: ldc 232
    //   1053: ldc 232
    //   1055: ldc 232
    //   1057: ldc 232
    //   1059: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1062: iconst_1
    //   1063: ireturn
    //   1064: astore_1
    //   1065: aload_1
    //   1066: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   1069: goto -35 -> 1034
    //   1072: ldc_w 1201
    //   1075: aload 4
    //   1077: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1080: ifeq +125 -> 1205
    //   1083: aload 5
    //   1085: ifnull +82 -> 1167
    //   1088: aload 5
    //   1090: arraylength
    //   1091: ifle +76 -> 1167
    //   1094: new 355	org/json/JSONObject
    //   1097: dup
    //   1098: aload 5
    //   1100: iconst_0
    //   1101: aaload
    //   1102: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1105: ldc_w 525
    //   1108: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1111: astore_1
    //   1112: aload_1
    //   1113: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne +47 -> 1163
    //   1119: new 355	org/json/JSONObject
    //   1122: dup
    //   1123: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1126: astore_2
    //   1127: aload_2
    //   1128: ldc_w 358
    //   1131: iconst_0
    //   1132: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1135: pop
    //   1136: aload_2
    //   1137: ldc_w 363
    //   1140: ldc_w 1143
    //   1143: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1146: pop
    //   1147: aload_0
    //   1148: aload_1
    //   1149: iconst_1
    //   1150: anewarray 368	java/lang/String
    //   1153: dup
    //   1154: iconst_0
    //   1155: aload_2
    //   1156: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1159: aastore
    //   1160: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1163: aload_0
    //   1164: invokevirtual 1203	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showWebToolbar	()V
    //   1167: aconst_null
    //   1168: ldc_w 1147
    //   1171: ldc_w 1149
    //   1174: ldc 232
    //   1176: ldc_w 1205
    //   1179: ldc_w 1205
    //   1182: iconst_0
    //   1183: iconst_0
    //   1184: ldc 232
    //   1186: ldc 232
    //   1188: ldc 232
    //   1190: ldc 232
    //   1192: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1195: iconst_1
    //   1196: ireturn
    //   1197: astore_1
    //   1198: aload_1
    //   1199: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   1202: goto -35 -> 1167
    //   1205: ldc_w 1207
    //   1208: aload 4
    //   1210: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1213: ifeq +125 -> 1338
    //   1216: aload 5
    //   1218: ifnull +82 -> 1300
    //   1221: aload 5
    //   1223: arraylength
    //   1224: ifle +76 -> 1300
    //   1227: new 355	org/json/JSONObject
    //   1230: dup
    //   1231: aload 5
    //   1233: iconst_0
    //   1234: aaload
    //   1235: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1238: ldc_w 525
    //   1241: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1244: astore_1
    //   1245: aload_1
    //   1246: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1249: ifne +47 -> 1296
    //   1252: new 355	org/json/JSONObject
    //   1255: dup
    //   1256: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1259: astore_2
    //   1260: aload_2
    //   1261: ldc_w 358
    //   1264: iconst_0
    //   1265: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1268: pop
    //   1269: aload_2
    //   1270: ldc_w 363
    //   1273: ldc_w 1143
    //   1276: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1279: pop
    //   1280: aload_0
    //   1281: aload_1
    //   1282: iconst_1
    //   1283: anewarray 368	java/lang/String
    //   1286: dup
    //   1287: iconst_0
    //   1288: aload_2
    //   1289: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1292: aastore
    //   1293: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1296: aload_0
    //   1297: invokevirtual 1209	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:hideWebToolbar	()V
    //   1300: aconst_null
    //   1301: ldc_w 1147
    //   1304: ldc_w 1149
    //   1307: ldc 232
    //   1309: ldc_w 1211
    //   1312: ldc_w 1211
    //   1315: iconst_0
    //   1316: iconst_0
    //   1317: ldc 232
    //   1319: ldc 232
    //   1321: ldc 232
    //   1323: ldc 232
    //   1325: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1328: iconst_1
    //   1329: ireturn
    //   1330: astore_1
    //   1331: aload_1
    //   1332: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   1335: goto -35 -> 1300
    //   1338: ldc_w 1213
    //   1341: aload 4
    //   1343: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1346: ifeq +347 -> 1693
    //   1349: aload 5
    //   1351: ifnull +289 -> 1640
    //   1354: aload 5
    //   1356: arraylength
    //   1357: ifle +283 -> 1640
    //   1360: new 355	org/json/JSONObject
    //   1363: dup
    //   1364: aload 5
    //   1366: iconst_0
    //   1367: aaload
    //   1368: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1371: astore_3
    //   1372: aload_3
    //   1373: ldc_w 525
    //   1376: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1379: astore_1
    //   1380: aload_3
    //   1381: ldc_w 1215
    //   1384: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1387: astore_2
    //   1388: aload_3
    //   1389: ldc_w 1217
    //   1392: iconst_1
    //   1393: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1396: istore 6
    //   1398: getstatic 199	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:localIdMap	Ljava/util/HashMap;
    //   1401: aload_2
    //   1402: invokevirtual 1086	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1405: checkcast 368	java/lang/String
    //   1408: astore_3
    //   1409: new 1219	java/io/File
    //   1412: dup
    //   1413: aload_3
    //   1414: invokespecial 1220	java/io/File:<init>	(Ljava/lang/String;)V
    //   1417: astore 4
    //   1419: aload 4
    //   1421: ifnull +11 -> 1432
    //   1424: aload 4
    //   1426: invokevirtual 1223	java/io/File:exists	()Z
    //   1429: ifne +40 -> 1469
    //   1432: aload_0
    //   1433: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1436: new 498	java/lang/StringBuilder
    //   1439: dup
    //   1440: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1443: ldc_w 1224
    //   1446: invokestatic 931	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1449: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: aload_3
    //   1453: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1459: iconst_0
    //   1460: invokestatic 1227	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1463: invokevirtual 1230	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1466: pop
    //   1467: iconst_1
    //   1468: ireturn
    //   1469: aload 4
    //   1471: invokevirtual 1232	java/io/File:length	()J
    //   1474: ldc2_w 1233
    //   1477: lcmp
    //   1478: ifle +37 -> 1515
    //   1481: aload_0
    //   1482: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1485: new 498	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1492: ldc_w 1236
    //   1495: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: aload_3
    //   1499: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: iconst_0
    //   1506: invokestatic 1227	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1509: invokevirtual 1230	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1512: pop
    //   1513: iconst_1
    //   1514: ireturn
    //   1515: aload_0
    //   1516: getfield 252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uploadBeensList	Ljava/util/ArrayList;
    //   1519: invokevirtual 1240	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1522: astore 4
    //   1524: aload 4
    //   1526: invokeinterface 1245 1 0
    //   1531: ifeq +51 -> 1582
    //   1534: aload 4
    //   1536: invokeinterface 1249 1 0
    //   1541: checkcast 1251	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen
    //   1544: astore 5
    //   1546: aload_2
    //   1547: ifnull -23 -> 1524
    //   1550: aload_2
    //   1551: aload 5
    //   1553: getfield 1252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1556: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1559: ifeq -35 -> 1524
    //   1562: aload_0
    //   1563: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1566: ldc_w 1253
    //   1569: invokestatic 931	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1572: iconst_0
    //   1573: invokestatic 1227	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1576: invokevirtual 1230	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1579: pop
    //   1580: iconst_1
    //   1581: ireturn
    //   1582: new 1251	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen
    //   1585: dup
    //   1586: invokespecial 1254	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:<init>	()V
    //   1589: astore 4
    //   1591: aload 4
    //   1593: aload_1
    //   1594: putfield 1255	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1597: aload 4
    //   1599: aload_2
    //   1600: putfield 1252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1603: aload 4
    //   1605: iload 6
    //   1607: putfield 1257	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$UploadBeen:jdField_a_of_type_Int	I
    //   1610: aload_0
    //   1611: getfield 252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uploadBeensList	Ljava/util/ArrayList;
    //   1614: aload 4
    //   1616: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1619: pop
    //   1620: aload_0
    //   1621: getfield 252	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uploadBeensList	Ljava/util/ArrayList;
    //   1624: invokevirtual 472	java/util/ArrayList:size	()I
    //   1627: iconst_1
    //   1628: if_icmpne +55 -> 1683
    //   1631: aload_0
    //   1632: iload 6
    //   1634: aload_3
    //   1635: iconst_1
    //   1636: aload_1
    //   1637: invokevirtual 1261	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:startUpload	(ILjava/lang/String;ZLjava/lang/String;)V
    //   1640: ldc_w 1263
    //   1643: invokestatic 1269	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1646: checkcast 1263	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   1649: aconst_null
    //   1650: ldc_w 1147
    //   1653: ldc_w 1149
    //   1656: ldc 232
    //   1658: ldc_w 1271
    //   1661: ldc_w 1271
    //   1664: iconst_0
    //   1665: iconst_2
    //   1666: ldc_w 1273
    //   1669: ldc 232
    //   1671: ldc 232
    //   1673: ldc 232
    //   1675: iconst_0
    //   1676: invokeinterface 1277 14 0
    //   1681: iconst_1
    //   1682: ireturn
    //   1683: iconst_1
    //   1684: ireturn
    //   1685: astore_1
    //   1686: aload_1
    //   1687: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   1690: goto -50 -> 1640
    //   1693: ldc_w 1279
    //   1696: aload 4
    //   1698: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1701: ifeq +245 -> 1946
    //   1704: aload 5
    //   1706: ifnull +199 -> 1905
    //   1709: aload 5
    //   1711: arraylength
    //   1712: ifle +193 -> 1905
    //   1715: new 355	org/json/JSONObject
    //   1718: dup
    //   1719: aload 5
    //   1721: iconst_0
    //   1722: aaload
    //   1723: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1726: astore_3
    //   1727: aload_3
    //   1728: ldc_w 525
    //   1731: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1734: astore_1
    //   1735: aload_3
    //   1736: ldc_w 1281
    //   1739: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1742: astore_2
    //   1743: aload_3
    //   1744: ldc_w 1217
    //   1747: iconst_1
    //   1748: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1751: istore 6
    //   1753: ldc 232
    //   1755: aload_1
    //   1756: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1759: ifne +12 -> 1771
    //   1762: ldc 232
    //   1764: aload_2
    //   1765: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1768: ifeq +20 -> 1788
    //   1771: aload_0
    //   1772: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1775: ldc_w 1283
    //   1778: iconst_0
    //   1779: invokestatic 1227	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1782: invokevirtual 1230	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1785: pop
    //   1786: iconst_1
    //   1787: ireturn
    //   1788: aload_0
    //   1789: getfield 254	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:downloadBeensList	Ljava/util/ArrayList;
    //   1792: invokevirtual 1240	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1795: astore_3
    //   1796: aload_3
    //   1797: invokeinterface 1245 1 0
    //   1802: ifeq +50 -> 1852
    //   1805: aload_3
    //   1806: invokeinterface 1249 1 0
    //   1811: checkcast 1285	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen
    //   1814: astore 4
    //   1816: aload_2
    //   1817: ifnull -21 -> 1796
    //   1820: aload_2
    //   1821: aload 4
    //   1823: getfield 1286	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1826: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1829: ifeq -33 -> 1796
    //   1832: aload_0
    //   1833: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   1836: ldc_w 1287
    //   1839: invokestatic 931	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1842: iconst_0
    //   1843: invokestatic 1227	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1846: invokevirtual 1230	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1849: pop
    //   1850: iconst_1
    //   1851: ireturn
    //   1852: new 1285	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen
    //   1855: dup
    //   1856: invokespecial 1288	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:<init>	()V
    //   1859: astore_3
    //   1860: aload_3
    //   1861: aload_1
    //   1862: putfield 1289	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1865: aload_3
    //   1866: aload_2
    //   1867: putfield 1286	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1870: aload_3
    //   1871: iload 6
    //   1873: putfield 1290	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$DownloadBeen:jdField_a_of_type_Int	I
    //   1876: aload_0
    //   1877: getfield 254	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:downloadBeensList	Ljava/util/ArrayList;
    //   1880: aload_3
    //   1881: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1884: pop
    //   1885: aload_0
    //   1886: getfield 254	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:downloadBeensList	Ljava/util/ArrayList;
    //   1889: invokevirtual 472	java/util/ArrayList:size	()I
    //   1892: iconst_1
    //   1893: if_icmpne +43 -> 1936
    //   1896: aload_0
    //   1897: aload_2
    //   1898: iload 6
    //   1900: iconst_1
    //   1901: aload_1
    //   1902: invokevirtual 1294	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sendMediaIdForUuidRequest	(Ljava/lang/String;IZLjava/lang/String;)V
    //   1905: aconst_null
    //   1906: ldc_w 1147
    //   1909: ldc_w 1149
    //   1912: ldc 232
    //   1914: ldc_w 1296
    //   1917: ldc_w 1296
    //   1920: iconst_0
    //   1921: iconst_2
    //   1922: ldc_w 1273
    //   1925: ldc 232
    //   1927: ldc 232
    //   1929: ldc 232
    //   1931: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1934: iconst_1
    //   1935: ireturn
    //   1936: iconst_1
    //   1937: ireturn
    //   1938: astore_1
    //   1939: aload_1
    //   1940: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   1943: goto -38 -> 1905
    //   1946: ldc_w 1298
    //   1949: aload 4
    //   1951: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1954: ifeq +343 -> 2297
    //   1957: aload 5
    //   1959: ifnull +11943 -> 13902
    //   1962: aload 5
    //   1964: arraylength
    //   1965: ifle +11937 -> 13902
    //   1968: new 355	org/json/JSONObject
    //   1971: dup
    //   1972: aload 5
    //   1974: iconst_0
    //   1975: aaload
    //   1976: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1979: astore_2
    //   1980: aload_2
    //   1981: ldc_w 525
    //   1984: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1987: astore_1
    //   1988: aload_2
    //   1989: ldc_w 1215
    //   1992: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1995: astore_3
    //   1996: aload_2
    //   1997: ldc_w 1217
    //   2000: iconst_1
    //   2001: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2004: istore 6
    //   2006: aload_3
    //   2007: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2010: istore 13
    //   2012: iload 13
    //   2014: ifeq +95 -> 2109
    //   2017: new 355	org/json/JSONObject
    //   2020: dup
    //   2021: invokespecial 356	org/json/JSONObject:<init>	()V
    //   2024: astore_2
    //   2025: aload_2
    //   2026: ldc_w 358
    //   2029: iconst_m1
    //   2030: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2033: pop
    //   2034: aload_2
    //   2035: ldc_w 363
    //   2038: ldc_w 1300
    //   2041: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2044: pop
    //   2045: aload_0
    //   2046: aload_1
    //   2047: iconst_1
    //   2048: anewarray 368	java/lang/String
    //   2051: dup
    //   2052: iconst_0
    //   2053: aload_2
    //   2054: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2057: aastore
    //   2058: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2061: aconst_null
    //   2062: ldc_w 1147
    //   2065: ldc_w 1149
    //   2068: ldc 232
    //   2070: ldc_w 1302
    //   2073: ldc_w 1302
    //   2076: iconst_0
    //   2077: iconst_2
    //   2078: ldc_w 1273
    //   2081: ldc 232
    //   2083: ldc 232
    //   2085: ldc 232
    //   2087: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2090: goto +11812 -> 13902
    //   2093: astore_1
    //   2094: aload_1
    //   2095: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2098: goto -37 -> 2061
    //   2101: astore_1
    //   2102: aload_1
    //   2103: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2106: goto +11796 -> 13902
    //   2109: aload_0
    //   2110: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2113: ifnonnull +26 -> 2139
    //   2116: aload_0
    //   2117: new 1306	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   2120: dup
    //   2121: aload_0
    //   2122: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   2125: aload_0
    //   2126: getfield 1307	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   2129: aload_0
    //   2130: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2133: invokespecial 1310	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   2136: putfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2139: aload_0
    //   2140: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2143: aload_3
    //   2144: invokevirtual 1313	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   2147: astore_2
    //   2148: new 1219	java/io/File
    //   2151: dup
    //   2152: aload_2
    //   2153: invokespecial 1220	java/io/File:<init>	(Ljava/lang/String;)V
    //   2156: astore_3
    //   2157: aload_3
    //   2158: invokevirtual 1223	java/io/File:exists	()Z
    //   2161: ifne +58 -> 2219
    //   2164: new 355	org/json/JSONObject
    //   2167: dup
    //   2168: invokespecial 356	org/json/JSONObject:<init>	()V
    //   2171: astore_2
    //   2172: aload_2
    //   2173: ldc_w 358
    //   2176: iconst_m1
    //   2177: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2180: pop
    //   2181: aload_2
    //   2182: ldc_w 363
    //   2185: ldc_w 1300
    //   2188: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2191: pop
    //   2192: aload_0
    //   2193: aload_1
    //   2194: iconst_1
    //   2195: anewarray 368	java/lang/String
    //   2198: dup
    //   2199: iconst_0
    //   2200: aload_2
    //   2201: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2204: aastore
    //   2205: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2208: goto -147 -> 2061
    //   2211: astore_1
    //   2212: aload_1
    //   2213: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2216: goto -155 -> 2061
    //   2219: aload_3
    //   2220: invokevirtual 1232	java/io/File:length	()J
    //   2223: ldc2_w 1314
    //   2226: lcmp
    //   2227: ifle +58 -> 2285
    //   2230: new 355	org/json/JSONObject
    //   2233: dup
    //   2234: invokespecial 356	org/json/JSONObject:<init>	()V
    //   2237: astore_2
    //   2238: aload_2
    //   2239: ldc_w 358
    //   2242: iconst_m1
    //   2243: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2246: pop
    //   2247: aload_2
    //   2248: ldc_w 363
    //   2251: ldc_w 1317
    //   2254: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2257: pop
    //   2258: aload_0
    //   2259: aload_1
    //   2260: iconst_1
    //   2261: anewarray 368	java/lang/String
    //   2264: dup
    //   2265: iconst_0
    //   2266: aload_2
    //   2267: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2270: aastore
    //   2271: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2274: goto -213 -> 2061
    //   2277: astore_3
    //   2278: aload_3
    //   2279: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2282: goto -24 -> 2258
    //   2285: aload_0
    //   2286: iload 6
    //   2288: aload_2
    //   2289: iconst_0
    //   2290: aload_1
    //   2291: invokevirtual 1261	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:startUpload	(ILjava/lang/String;ZLjava/lang/String;)V
    //   2294: goto -233 -> 2061
    //   2297: ldc_w 1319
    //   2300: aload 4
    //   2302: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2305: ifeq +167 -> 2472
    //   2308: aload 5
    //   2310: ifnull +11594 -> 13904
    //   2313: aload 5
    //   2315: arraylength
    //   2316: ifle +11588 -> 13904
    //   2319: new 355	org/json/JSONObject
    //   2322: dup
    //   2323: aload 5
    //   2325: iconst_0
    //   2326: aaload
    //   2327: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2330: astore_2
    //   2331: aload_2
    //   2332: ldc_w 525
    //   2335: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2338: astore_1
    //   2339: aload_2
    //   2340: ldc_w 1281
    //   2343: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2346: astore_3
    //   2347: aload_2
    //   2348: ldc_w 1217
    //   2351: iconst_1
    //   2352: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2355: istore 6
    //   2357: aload_3
    //   2358: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2361: istore 13
    //   2363: iload 13
    //   2365: ifeq +95 -> 2460
    //   2368: new 355	org/json/JSONObject
    //   2371: dup
    //   2372: invokespecial 356	org/json/JSONObject:<init>	()V
    //   2375: astore_2
    //   2376: aload_2
    //   2377: ldc_w 358
    //   2380: iconst_m1
    //   2381: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2384: pop
    //   2385: aload_2
    //   2386: ldc_w 363
    //   2389: ldc_w 1321
    //   2392: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2395: pop
    //   2396: aload_0
    //   2397: aload_1
    //   2398: iconst_1
    //   2399: anewarray 368	java/lang/String
    //   2402: dup
    //   2403: iconst_0
    //   2404: aload_2
    //   2405: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2408: aastore
    //   2409: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2412: aconst_null
    //   2413: ldc_w 1147
    //   2416: ldc_w 1149
    //   2419: ldc 232
    //   2421: ldc_w 1323
    //   2424: ldc_w 1323
    //   2427: iconst_0
    //   2428: iconst_2
    //   2429: ldc_w 1273
    //   2432: ldc 232
    //   2434: ldc 232
    //   2436: ldc 232
    //   2438: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2441: goto +11463 -> 13904
    //   2444: astore_1
    //   2445: aload_1
    //   2446: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2449: goto -37 -> 2412
    //   2452: astore_1
    //   2453: aload_1
    //   2454: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2457: goto +11447 -> 13904
    //   2460: aload_0
    //   2461: aload_3
    //   2462: iload 6
    //   2464: iconst_0
    //   2465: aload_1
    //   2466: invokevirtual 1294	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sendMediaIdForUuidRequest	(Ljava/lang/String;IZLjava/lang/String;)V
    //   2469: goto -57 -> 2412
    //   2472: ldc_w 1325
    //   2475: aload 4
    //   2477: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2480: ifeq +239 -> 2719
    //   2483: aload 5
    //   2485: ifnull +11428 -> 13913
    //   2488: aload 5
    //   2490: arraylength
    //   2491: ifle +11422 -> 13913
    //   2494: new 355	org/json/JSONObject
    //   2497: dup
    //   2498: aload 5
    //   2500: iconst_0
    //   2501: aaload
    //   2502: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2505: astore_3
    //   2506: aload_3
    //   2507: ldc_w 525
    //   2510: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2513: astore_1
    //   2514: aload_3
    //   2515: ldc_w 1327
    //   2518: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2521: istore 8
    //   2523: iload 8
    //   2525: bipush 9
    //   2527: if_icmpgt +11379 -> 13906
    //   2530: iload 8
    //   2532: iconst_1
    //   2533: if_icmpge +11366 -> 13899
    //   2536: goto +11370 -> 13906
    //   2539: aload_3
    //   2540: ldc_w 1329
    //   2543: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2546: astore_2
    //   2547: aload_3
    //   2548: ldc_w 1331
    //   2551: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2554: astore_3
    //   2555: aload_3
    //   2556: ifnull +11337 -> 13893
    //   2559: aload_3
    //   2560: invokevirtual 539	org/json/JSONArray:length	()I
    //   2563: iconst_1
    //   2564: if_icmpne +11329 -> 13893
    //   2567: aload_3
    //   2568: iconst_0
    //   2569: invokevirtual 1176	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2572: astore_3
    //   2573: ldc_w 1333
    //   2576: aload_3
    //   2577: invokevirtual 1336	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2580: ifeq +91 -> 2671
    //   2583: iconst_1
    //   2584: istore 6
    //   2586: iconst_0
    //   2587: istore 9
    //   2589: iload 9
    //   2591: istore 7
    //   2593: aload_2
    //   2594: ifnull +34 -> 2628
    //   2597: iload 9
    //   2599: istore 7
    //   2601: aload_2
    //   2602: invokevirtual 539	org/json/JSONArray:length	()I
    //   2605: iconst_1
    //   2606: if_icmpne +22 -> 2628
    //   2609: aload_2
    //   2610: iconst_0
    //   2611: invokevirtual 1176	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2614: astore_2
    //   2615: ldc_w 1338
    //   2618: aload_2
    //   2619: invokevirtual 1336	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2622: ifeq +65 -> 2687
    //   2625: iconst_1
    //   2626: istore 7
    //   2628: aload_0
    //   2629: iload 6
    //   2631: iload 7
    //   2633: aload_1
    //   2634: iload 8
    //   2636: invokevirtual 1342	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showPAactionSheet	(IILjava/lang/String;I)V
    //   2639: aconst_null
    //   2640: ldc_w 1147
    //   2643: ldc_w 1149
    //   2646: ldc 232
    //   2648: ldc_w 1344
    //   2651: ldc_w 1344
    //   2654: iconst_0
    //   2655: iconst_2
    //   2656: ldc_w 1273
    //   2659: ldc 232
    //   2661: ldc 232
    //   2663: ldc 232
    //   2665: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2668: goto +11245 -> 13913
    //   2671: ldc_w 1346
    //   2674: aload_3
    //   2675: invokevirtual 1336	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2678: ifeq +11215 -> 13893
    //   2681: iconst_2
    //   2682: istore 6
    //   2684: goto -98 -> 2586
    //   2687: ldc_w 1348
    //   2690: aload_2
    //   2691: invokevirtual 1336	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2694: istore 13
    //   2696: iload 9
    //   2698: istore 7
    //   2700: iload 13
    //   2702: ifeq -74 -> 2628
    //   2705: iconst_2
    //   2706: istore 7
    //   2708: goto -80 -> 2628
    //   2711: astore_1
    //   2712: aload_1
    //   2713: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2716: goto +11197 -> 13913
    //   2719: ldc_w 1350
    //   2722: aload 4
    //   2724: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2727: ifeq +119 -> 2846
    //   2730: aload 5
    //   2732: ifnull +104 -> 2836
    //   2735: aload 5
    //   2737: arraylength
    //   2738: ifle +98 -> 2836
    //   2741: new 355	org/json/JSONObject
    //   2744: dup
    //   2745: aload 5
    //   2747: iconst_0
    //   2748: aaload
    //   2749: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2752: ldc_w 525
    //   2755: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2758: putstatic 1352	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStartCallback	Ljava/lang/String;
    //   2761: getstatic 1352	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStartCallback	Ljava/lang/String;
    //   2764: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2767: ifne +40 -> 2807
    //   2770: aload_0
    //   2771: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2774: ifnonnull +26 -> 2800
    //   2777: aload_0
    //   2778: new 1306	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   2781: dup
    //   2782: aload_0
    //   2783: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   2786: aload_0
    //   2787: getfield 1307	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   2790: aload_0
    //   2791: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2794: invokespecial 1310	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   2797: putfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2800: aload_0
    //   2801: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2804: invokevirtual 1354	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:startRecord	()V
    //   2807: aconst_null
    //   2808: ldc_w 1147
    //   2811: ldc_w 1149
    //   2814: ldc 232
    //   2816: ldc_w 1356
    //   2819: ldc_w 1356
    //   2822: iconst_0
    //   2823: iconst_2
    //   2824: ldc_w 1273
    //   2827: ldc 232
    //   2829: ldc 232
    //   2831: ldc 232
    //   2833: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2836: iconst_1
    //   2837: ireturn
    //   2838: astore_1
    //   2839: aload_1
    //   2840: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2843: goto -7 -> 2836
    //   2846: ldc_w 1358
    //   2849: aload 4
    //   2851: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2854: ifeq +154 -> 3008
    //   2857: aload 5
    //   2859: ifnull +82 -> 2941
    //   2862: aload 5
    //   2864: arraylength
    //   2865: ifle +76 -> 2941
    //   2868: new 355	org/json/JSONObject
    //   2871: dup
    //   2872: aload 5
    //   2874: iconst_0
    //   2875: aaload
    //   2876: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2879: ldc_w 525
    //   2882: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2885: putstatic 1360	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStopCallback	Ljava/lang/String;
    //   2888: aload_0
    //   2889: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2892: ifnull +51 -> 2943
    //   2895: aload_0
    //   2896: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2899: invokevirtual 1363	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:isRecorderRecording	()Z
    //   2902: ifeq +41 -> 2943
    //   2905: aload_0
    //   2906: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   2909: invokevirtual 1365	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:stopRecord	()V
    //   2912: aconst_null
    //   2913: ldc_w 1147
    //   2916: ldc_w 1149
    //   2919: ldc 232
    //   2921: ldc_w 1367
    //   2924: ldc_w 1367
    //   2927: iconst_0
    //   2928: iconst_2
    //   2929: ldc_w 1273
    //   2932: ldc 232
    //   2934: ldc 232
    //   2936: ldc 232
    //   2938: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2941: iconst_1
    //   2942: ireturn
    //   2943: new 355	org/json/JSONObject
    //   2946: dup
    //   2947: invokespecial 356	org/json/JSONObject:<init>	()V
    //   2950: astore_1
    //   2951: aload_1
    //   2952: ldc_w 358
    //   2955: iconst_m1
    //   2956: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2959: pop
    //   2960: aload_1
    //   2961: ldc_w 363
    //   2964: ldc_w 1369
    //   2967: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2970: pop
    //   2971: aload_0
    //   2972: getstatic 1360	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:recordStopCallback	Ljava/lang/String;
    //   2975: iconst_1
    //   2976: anewarray 368	java/lang/String
    //   2979: dup
    //   2980: iconst_0
    //   2981: aload_1
    //   2982: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2985: aastore
    //   2986: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2989: goto -77 -> 2912
    //   2992: astore_1
    //   2993: aload_1
    //   2994: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   2997: goto -85 -> 2912
    //   3000: astore_1
    //   3001: aload_1
    //   3002: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3005: goto -64 -> 2941
    //   3008: ldc_w 1371
    //   3011: aload 4
    //   3013: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3016: ifeq +380 -> 3396
    //   3019: aload 5
    //   3021: ifnull +10894 -> 13915
    //   3024: aload 5
    //   3026: arraylength
    //   3027: ifle +10888 -> 13915
    //   3030: new 355	org/json/JSONObject
    //   3033: dup
    //   3034: aload 5
    //   3036: iconst_0
    //   3037: aaload
    //   3038: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3041: astore_1
    //   3042: aload_1
    //   3043: ldc_w 525
    //   3046: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3049: putstatic 1373	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3052: aload_1
    //   3053: ldc_w 1215
    //   3056: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3059: astore_1
    //   3060: getstatic 1373	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3063: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3066: ifne +165 -> 3231
    //   3069: aload_1
    //   3070: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3073: ifne +266 -> 3339
    //   3076: aload_0
    //   3077: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3080: ifnull +15 -> 3095
    //   3083: aload_0
    //   3084: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3087: invokevirtual 1376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:isPlaying	()Z
    //   3090: ifeq +5 -> 3095
    //   3093: iconst_1
    //   3094: ireturn
    //   3095: aload_0
    //   3096: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3099: ifnonnull +26 -> 3125
    //   3102: aload_0
    //   3103: new 1306	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   3106: dup
    //   3107: aload_0
    //   3108: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3111: aload_0
    //   3112: getfield 1307	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   3115: aload_0
    //   3116: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3119: invokespecial 1310	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   3122: putfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3125: aload_0
    //   3126: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3129: aload_1
    //   3130: invokevirtual 1313	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   3133: astore_2
    //   3134: new 355	org/json/JSONObject
    //   3137: dup
    //   3138: invokespecial 356	org/json/JSONObject:<init>	()V
    //   3141: astore_1
    //   3142: new 1219	java/io/File
    //   3145: dup
    //   3146: aload_2
    //   3147: invokespecial 1220	java/io/File:<init>	(Ljava/lang/String;)V
    //   3150: invokevirtual 1223	java/io/File:exists	()Z
    //   3153: ifeq +126 -> 3279
    //   3156: aload_0
    //   3157: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3160: aload_2
    //   3161: invokevirtual 1378	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:playVoice	(Ljava/lang/String;)V
    //   3164: aload_1
    //   3165: ldc_w 358
    //   3168: iconst_0
    //   3169: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3172: pop
    //   3173: aload_1
    //   3174: ldc_w 363
    //   3177: ldc_w 1380
    //   3180: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3183: pop
    //   3184: aconst_null
    //   3185: ldc_w 1147
    //   3188: ldc_w 1149
    //   3191: ldc 232
    //   3193: ldc_w 1382
    //   3196: ldc_w 1382
    //   3199: iconst_0
    //   3200: iconst_0
    //   3201: ldc_w 1273
    //   3204: ldc 232
    //   3206: ldc 232
    //   3208: ldc 232
    //   3210: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3213: aload_0
    //   3214: getstatic 1373	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3217: iconst_1
    //   3218: anewarray 368	java/lang/String
    //   3221: dup
    //   3222: iconst_0
    //   3223: aload_1
    //   3224: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3227: aastore
    //   3228: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3231: aconst_null
    //   3232: ldc_w 1147
    //   3235: ldc_w 1149
    //   3238: ldc 232
    //   3240: ldc_w 1382
    //   3243: ldc_w 1382
    //   3246: iconst_0
    //   3247: iconst_2
    //   3248: ldc_w 1273
    //   3251: ldc 232
    //   3253: ldc 232
    //   3255: ldc 232
    //   3257: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3260: goto +10655 -> 13915
    //   3263: astore_2
    //   3264: aload_2
    //   3265: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3268: goto -84 -> 3184
    //   3271: astore_1
    //   3272: aload_1
    //   3273: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3276: goto +10639 -> 13915
    //   3279: aload_1
    //   3280: ldc_w 358
    //   3283: iconst_m1
    //   3284: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3287: pop
    //   3288: aload_1
    //   3289: ldc_w 363
    //   3292: ldc_w 1300
    //   3295: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3298: pop
    //   3299: aconst_null
    //   3300: ldc_w 1147
    //   3303: ldc_w 1149
    //   3306: ldc 232
    //   3308: ldc_w 1382
    //   3311: ldc_w 1382
    //   3314: iconst_0
    //   3315: iconst_m1
    //   3316: ldc_w 1273
    //   3319: ldc 232
    //   3321: ldc 232
    //   3323: ldc 232
    //   3325: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3328: goto -115 -> 3213
    //   3331: astore_2
    //   3332: aload_2
    //   3333: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3336: goto -37 -> 3299
    //   3339: new 355	org/json/JSONObject
    //   3342: dup
    //   3343: invokespecial 356	org/json/JSONObject:<init>	()V
    //   3346: astore_1
    //   3347: aload_1
    //   3348: ldc_w 358
    //   3351: iconst_m1
    //   3352: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3355: pop
    //   3356: aload_1
    //   3357: ldc_w 363
    //   3360: ldc_w 1384
    //   3363: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3366: pop
    //   3367: aload_0
    //   3368: getstatic 1373	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playStartCallback	Ljava/lang/String;
    //   3371: iconst_1
    //   3372: anewarray 368	java/lang/String
    //   3375: dup
    //   3376: iconst_0
    //   3377: aload_1
    //   3378: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3381: aastore
    //   3382: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3385: goto -154 -> 3231
    //   3388: astore_1
    //   3389: aload_1
    //   3390: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3393: goto -162 -> 3231
    //   3396: ldc_w 1386
    //   3399: aload 4
    //   3401: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3404: ifeq +226 -> 3630
    //   3407: aload 5
    //   3409: ifnull +10508 -> 13917
    //   3412: aload 5
    //   3414: arraylength
    //   3415: ifle +10502 -> 13917
    //   3418: new 355	org/json/JSONObject
    //   3421: dup
    //   3422: aload 5
    //   3424: iconst_0
    //   3425: aaload
    //   3426: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3429: astore_2
    //   3430: aload_2
    //   3431: ldc_w 525
    //   3434: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3437: astore_1
    //   3438: aload_2
    //   3439: ldc_w 1215
    //   3442: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3445: astore_2
    //   3446: aload_2
    //   3447: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3450: ifne +132 -> 3582
    //   3453: aload_0
    //   3454: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3457: ifnonnull +26 -> 3483
    //   3460: aload_0
    //   3461: new 1306	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   3464: dup
    //   3465: aload_0
    //   3466: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3469: aload_0
    //   3470: getfield 1307	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   3473: aload_0
    //   3474: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3477: invokespecial 1310	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   3480: putfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3483: aload_0
    //   3484: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3487: aload_2
    //   3488: invokevirtual 1313	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   3491: pop
    //   3492: aload_0
    //   3493: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3496: invokevirtual 1376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:isPlaying	()Z
    //   3499: ifeq +83 -> 3582
    //   3502: aload_0
    //   3503: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3506: invokevirtual 1388	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:pauseVoice	()V
    //   3509: new 355	org/json/JSONObject
    //   3512: dup
    //   3513: invokespecial 356	org/json/JSONObject:<init>	()V
    //   3516: astore_2
    //   3517: aload_2
    //   3518: ldc_w 358
    //   3521: iconst_0
    //   3522: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3525: pop
    //   3526: aload_2
    //   3527: ldc_w 363
    //   3530: ldc_w 1380
    //   3533: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3536: pop
    //   3537: aload_0
    //   3538: aload_1
    //   3539: iconst_1
    //   3540: anewarray 368	java/lang/String
    //   3543: dup
    //   3544: iconst_0
    //   3545: aload_2
    //   3546: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3549: aastore
    //   3550: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3553: aconst_null
    //   3554: ldc_w 1147
    //   3557: ldc_w 1149
    //   3560: ldc 232
    //   3562: ldc_w 1390
    //   3565: ldc_w 1390
    //   3568: iconst_0
    //   3569: iconst_0
    //   3570: ldc_w 1273
    //   3573: ldc 232
    //   3575: ldc 232
    //   3577: ldc 232
    //   3579: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3582: aconst_null
    //   3583: ldc_w 1147
    //   3586: ldc_w 1149
    //   3589: ldc 232
    //   3591: ldc_w 1390
    //   3594: ldc_w 1390
    //   3597: iconst_0
    //   3598: iconst_2
    //   3599: ldc_w 1273
    //   3602: ldc 232
    //   3604: ldc 232
    //   3606: ldc 232
    //   3608: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3611: goto +10306 -> 13917
    //   3614: astore_1
    //   3615: aload_1
    //   3616: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3619: goto -66 -> 3553
    //   3622: astore_1
    //   3623: aload_1
    //   3624: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3627: goto +10290 -> 13917
    //   3630: ldc_w 1392
    //   3633: aload 4
    //   3635: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3638: ifeq +165 -> 3803
    //   3641: aload 5
    //   3643: ifnull +150 -> 3793
    //   3646: aload 5
    //   3648: arraylength
    //   3649: ifle +144 -> 3793
    //   3652: new 355	org/json/JSONObject
    //   3655: dup
    //   3656: aload 5
    //   3658: iconst_0
    //   3659: aaload
    //   3660: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3663: astore_1
    //   3664: aload_1
    //   3665: ldc_w 525
    //   3668: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3671: putstatic 1394	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:playEndCallback	Ljava/lang/String;
    //   3674: aload_1
    //   3675: ldc_w 1215
    //   3678: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3681: astore_1
    //   3682: aload_1
    //   3683: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3686: ifne +78 -> 3764
    //   3689: aload_0
    //   3690: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3693: ifnonnull +26 -> 3719
    //   3696: aload_0
    //   3697: new 1306	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl
    //   3700: dup
    //   3701: aload_0
    //   3702: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   3705: aload_0
    //   3706: getfield 1307	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:uin	Ljava/lang/String;
    //   3709: aload_0
    //   3710: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3713: invokespecial 1310	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:<init>	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;)V
    //   3716: putfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3719: aload_0
    //   3720: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3723: aload_1
    //   3724: invokevirtual 1313	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:getLocalPathFromIdForPtt	(Ljava/lang/String;)Ljava/lang/String;
    //   3727: pop
    //   3728: aload_0
    //   3729: getfield 1304	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:ptt	Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl;
    //   3732: invokevirtual 1396	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPttImpl:stopVoice	()V
    //   3735: aconst_null
    //   3736: ldc_w 1147
    //   3739: ldc_w 1149
    //   3742: ldc 232
    //   3744: ldc_w 1398
    //   3747: ldc_w 1398
    //   3750: iconst_0
    //   3751: iconst_0
    //   3752: ldc_w 1273
    //   3755: ldc 232
    //   3757: ldc 232
    //   3759: ldc 232
    //   3761: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3764: aconst_null
    //   3765: ldc_w 1147
    //   3768: ldc_w 1149
    //   3771: ldc 232
    //   3773: ldc_w 1398
    //   3776: ldc_w 1398
    //   3779: iconst_0
    //   3780: iconst_2
    //   3781: ldc_w 1273
    //   3784: ldc 232
    //   3786: ldc 232
    //   3788: ldc 232
    //   3790: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3793: iconst_1
    //   3794: ireturn
    //   3795: astore_1
    //   3796: aload_1
    //   3797: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3800: goto -7 -> 3793
    //   3803: ldc_w 1400
    //   3806: aload 4
    //   3808: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3811: ifeq +44 -> 3855
    //   3814: aload 5
    //   3816: ifnull +29 -> 3845
    //   3819: aload 5
    //   3821: arraylength
    //   3822: ifle +23 -> 3845
    //   3825: new 355	org/json/JSONObject
    //   3828: dup
    //   3829: aload 5
    //   3831: iconst_0
    //   3832: aaload
    //   3833: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3836: ldc_w 525
    //   3839: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3842: putstatic 1402	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:voiceRecorderEndCallback	Ljava/lang/String;
    //   3845: iconst_1
    //   3846: ireturn
    //   3847: astore_1
    //   3848: aload_1
    //   3849: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3852: goto -7 -> 3845
    //   3855: ldc_w 1404
    //   3858: aload 4
    //   3860: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3863: ifeq +44 -> 3907
    //   3866: aload 5
    //   3868: ifnull +29 -> 3897
    //   3871: aload 5
    //   3873: arraylength
    //   3874: ifle +23 -> 3897
    //   3877: new 355	org/json/JSONObject
    //   3880: dup
    //   3881: aload 5
    //   3883: iconst_0
    //   3884: aaload
    //   3885: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3888: ldc_w 525
    //   3891: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3894: putstatic 1406	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:voicePlayEndCallback	Ljava/lang/String;
    //   3897: iconst_1
    //   3898: ireturn
    //   3899: astore_1
    //   3900: aload_1
    //   3901: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   3904: goto -7 -> 3897
    //   3907: ldc_w 1408
    //   3910: aload 4
    //   3912: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3915: ifeq +170 -> 4085
    //   3918: aload 5
    //   3920: ifnull +144 -> 4064
    //   3923: aload 5
    //   3925: arraylength
    //   3926: ifle +138 -> 4064
    //   3929: new 355	org/json/JSONObject
    //   3932: dup
    //   3933: aload 5
    //   3935: iconst_0
    //   3936: aaload
    //   3937: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3940: astore_1
    //   3941: aload_1
    //   3942: ldc_w 525
    //   3945: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3948: putstatic 1410	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndUploadAvatarCallback	Ljava/lang/String;
    //   3951: aload_1
    //   3952: ldc_w 1412
    //   3955: iconst_1
    //   3956: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3959: istore 10
    //   3961: sipush 640
    //   3964: istore 6
    //   3966: sipush 640
    //   3969: istore 7
    //   3971: sipush 640
    //   3974: istore 8
    //   3976: sipush 640
    //   3979: istore 9
    //   3981: aload_1
    //   3982: ldc_w 1414
    //   3985: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3988: ifeq +26 -> 4014
    //   3991: aload_1
    //   3992: ldc_w 1414
    //   3995: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3998: istore 7
    //   4000: aload_0
    //   4001: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   4004: iload 7
    //   4006: iconst_2
    //   4007: idiv
    //   4008: i2f
    //   4009: invokestatic 1422	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   4012: istore 6
    //   4014: aload_1
    //   4015: ldc_w 1424
    //   4018: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4021: ifeq +26 -> 4047
    //   4024: aload_1
    //   4025: ldc_w 1424
    //   4028: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4031: istore 9
    //   4033: aload_0
    //   4034: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   4037: iload 9
    //   4039: iconst_2
    //   4040: idiv
    //   4041: i2f
    //   4042: invokestatic 1422	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   4045: istore 8
    //   4047: aload_0
    //   4048: iconst_1
    //   4049: iload 10
    //   4051: bipush 118
    //   4053: iload 6
    //   4055: iload 8
    //   4057: iload 7
    //   4059: iload 9
    //   4061: invokevirtual 1428	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectPhotoFromGallery	(IIBIIII)V
    //   4064: iconst_1
    //   4065: ireturn
    //   4066: astore_1
    //   4067: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4070: ifeq -6 -> 4064
    //   4073: ldc 45
    //   4075: iconst_2
    //   4076: ldc_w 1430
    //   4079: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4082: goto -18 -> 4064
    //   4085: ldc_w 1432
    //   4088: aload 4
    //   4090: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4093: ifeq +194 -> 4287
    //   4096: iconst_0
    //   4097: istore 14
    //   4099: iload 14
    //   4101: istore 13
    //   4103: aload 5
    //   4105: ifnull +142 -> 4247
    //   4108: iload 14
    //   4110: istore 13
    //   4112: aload 5
    //   4114: arraylength
    //   4115: ifle +132 -> 4247
    //   4118: invokestatic 1438	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4121: invokevirtual 1441	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   4124: invokevirtual 1445	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   4127: astore_1
    //   4128: new 355	org/json/JSONObject
    //   4131: dup
    //   4132: aload 5
    //   4134: iconst_0
    //   4135: aaload
    //   4136: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4139: astore_2
    //   4140: aload_2
    //   4141: ldc_w 525
    //   4144: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4147: putstatic 1447	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndTopicPicCallback	Ljava/lang/String;
    //   4150: aload_2
    //   4151: ldc_w 1412
    //   4154: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4157: istore 10
    //   4159: aload_1
    //   4160: getfield 1452	android/util/DisplayMetrics:widthPixels	I
    //   4163: ldc2_w 1453
    //   4166: invokestatic 1460	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4169: istore 6
    //   4171: aload_1
    //   4172: getfield 1452	android/util/DisplayMetrics:widthPixels	I
    //   4175: ldc2_w 1461
    //   4178: invokestatic 1460	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4181: istore 7
    //   4183: sipush 750
    //   4186: istore 8
    //   4188: sipush 416
    //   4191: istore 9
    //   4193: iload 10
    //   4195: iconst_1
    //   4196: if_icmpne +9723 -> 13919
    //   4199: aload_1
    //   4200: getfield 1452	android/util/DisplayMetrics:widthPixels	I
    //   4203: ldc2_w 1453
    //   4206: invokestatic 1460	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4209: istore 7
    //   4211: sipush 160
    //   4214: istore 9
    //   4216: sipush 160
    //   4219: istore 8
    //   4221: iload 7
    //   4223: istore 6
    //   4225: goto +9694 -> 13919
    //   4228: aload_0
    //   4229: iconst_2
    //   4230: iconst_0
    //   4231: bipush 121
    //   4233: iload 6
    //   4235: iload 7
    //   4237: iload 8
    //   4239: iload 9
    //   4241: invokevirtual 1428	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectPhotoFromGallery	(IIBIIII)V
    //   4244: iconst_1
    //   4245: istore 13
    //   4247: ldc 45
    //   4249: iconst_1
    //   4250: new 498	java/lang/StringBuilder
    //   4253: dup
    //   4254: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   4257: ldc_w 1464
    //   4260: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4263: aload 5
    //   4265: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4268: ldc_w 1466
    //   4271: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4274: iload 13
    //   4276: invokevirtual 1469	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4279: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4282: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4285: iconst_1
    //   4286: ireturn
    //   4287: ldc_w 1471
    //   4290: aload 4
    //   4292: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4295: ifeq +198 -> 4493
    //   4298: aload_0
    //   4299: getfield 230	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:refuseConfig	Z
    //   4302: ifeq +5 -> 4307
    //   4305: iconst_1
    //   4306: ireturn
    //   4307: aload 5
    //   4309: ifnull +182 -> 4491
    //   4312: aload 5
    //   4314: arraylength
    //   4315: ifle +176 -> 4491
    //   4318: new 355	org/json/JSONObject
    //   4321: dup
    //   4322: aload 5
    //   4324: iconst_0
    //   4325: aaload
    //   4326: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4329: astore_2
    //   4330: aload_2
    //   4331: ldc_w 1473
    //   4334: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4337: putstatic 110	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:appIdStr	Ljava/lang/String;
    //   4340: aload_2
    //   4341: ldc_w 1475
    //   4344: ldc_w 1477
    //   4347: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4350: pop
    //   4351: aload_0
    //   4352: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4355: invokevirtual 1480	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   4358: astore_1
    //   4359: aload_1
    //   4360: ifnull +9522 -> 13882
    //   4363: aload_1
    //   4364: invokevirtual 1485	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   4367: astore_1
    //   4368: aload_2
    //   4369: ldc_w 1039
    //   4372: aload_1
    //   4373: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4376: pop
    //   4377: aload_2
    //   4378: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4381: astore_3
    //   4382: aload_0
    //   4383: aload_2
    //   4384: ldc_w 525
    //   4387: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4390: putfield 1487	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:authCallback	Ljava/lang/String;
    //   4393: aload_2
    //   4394: ldc_w 1489
    //   4397: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   4400: astore_2
    //   4401: new 249	java/util/ArrayList
    //   4404: dup
    //   4405: invokespecial 250	java/util/ArrayList:<init>	()V
    //   4408: astore 4
    //   4410: aload_2
    //   4411: ifnull +41 -> 4452
    //   4414: aload 4
    //   4416: invokevirtual 904	java/util/ArrayList:clear	()V
    //   4419: iconst_0
    //   4420: istore 6
    //   4422: iload 6
    //   4424: aload_2
    //   4425: invokevirtual 539	org/json/JSONArray:length	()I
    //   4428: if_icmpge +24 -> 4452
    //   4431: aload 4
    //   4433: aload_2
    //   4434: iload 6
    //   4436: invokevirtual 1176	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   4439: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4442: pop
    //   4443: iload 6
    //   4445: iconst_1
    //   4446: iadd
    //   4447: istore 6
    //   4449: goto -27 -> 4422
    //   4452: getstatic 195	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:authorizedLists	Ljava/util/Map;
    //   4455: aload_1
    //   4456: invokeinterface 973 2 0
    //   4461: pop
    //   4462: getstatic 197	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:needAuthorizedLists	Ljava/util/Map;
    //   4465: aload_1
    //   4466: aload 4
    //   4468: invokeinterface 1490 3 0
    //   4473: pop
    //   4474: aload_1
    //   4475: ifnull +9 -> 4484
    //   4478: aload_0
    //   4479: aload_1
    //   4480: aload_3
    //   4481: invokevirtual 1493	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sendAuthRequest	(Ljava/lang/String;Ljava/lang/String;)V
    //   4484: iconst_1
    //   4485: ireturn
    //   4486: astore_1
    //   4487: aload_1
    //   4488: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   4491: iconst_0
    //   4492: ireturn
    //   4493: ldc_w 1495
    //   4496: aload 4
    //   4498: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4501: ifeq +120 -> 4621
    //   4504: new 355	org/json/JSONObject
    //   4507: dup
    //   4508: aload 5
    //   4510: iconst_0
    //   4511: aaload
    //   4512: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4515: astore_2
    //   4516: aload_2
    //   4517: ldc_w 525
    //   4520: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4523: astore_1
    //   4524: aload_2
    //   4525: ldc_w 1497
    //   4528: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4531: istore 6
    //   4533: aload_0
    //   4534: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4537: invokevirtual 962	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   4540: checkcast 1499	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   4543: astore_2
    //   4544: aload_2
    //   4545: ifnull +32 -> 4577
    //   4548: aload_2
    //   4549: getfield 1503	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4552: ifnull +25 -> 4577
    //   4555: aload_2
    //   4556: getfield 1503	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4559: getfield 1508	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   4562: ifnull +15 -> 4577
    //   4565: aload_2
    //   4566: getfield 1503	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4569: getfield 1508	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   4572: iload 6
    //   4574: invokevirtual 1512	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:a	(I)V
    //   4577: new 355	org/json/JSONObject
    //   4580: dup
    //   4581: invokespecial 356	org/json/JSONObject:<init>	()V
    //   4584: astore_2
    //   4585: aload_2
    //   4586: ldc_w 358
    //   4589: iconst_0
    //   4590: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4593: pop
    //   4594: aload_0
    //   4595: aload_1
    //   4596: iconst_1
    //   4597: anewarray 368	java/lang/String
    //   4600: dup
    //   4601: iconst_0
    //   4602: aload_2
    //   4603: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4606: aastore
    //   4607: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4610: goto -119 -> 4491
    //   4613: astore_1
    //   4614: aload_1
    //   4615: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   4618: goto -127 -> 4491
    //   4621: ldc_w 1514
    //   4624: aload 4
    //   4626: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4629: ifeq +366 -> 4995
    //   4632: aload 5
    //   4634: ifnull +351 -> 4985
    //   4637: aload 5
    //   4639: arraylength
    //   4640: ifle +345 -> 4985
    //   4643: new 355	org/json/JSONObject
    //   4646: dup
    //   4647: aload 5
    //   4649: iconst_0
    //   4650: aaload
    //   4651: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4654: astore_2
    //   4655: aload_2
    //   4656: ldc_w 525
    //   4659: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4662: astore_1
    //   4663: aload_2
    //   4664: ldc_w 1039
    //   4667: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4670: astore_3
    //   4671: aload_1
    //   4672: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4675: ifne +310 -> 4985
    //   4678: aload_3
    //   4679: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4682: ifne +303 -> 4985
    //   4685: new 355	org/json/JSONObject
    //   4688: dup
    //   4689: invokespecial 356	org/json/JSONObject:<init>	()V
    //   4692: astore_2
    //   4693: aload_2
    //   4694: ldc_w 358
    //   4697: iconst_0
    //   4698: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4701: pop
    //   4702: aload_2
    //   4703: ldc_w 363
    //   4706: ldc_w 1143
    //   4709: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4712: pop
    //   4713: iconst_0
    //   4714: istore 14
    //   4716: aload_3
    //   4717: invokestatic 1518	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4720: astore_3
    //   4721: iload 14
    //   4723: istore 13
    //   4725: aload_3
    //   4726: ifnull +27 -> 4753
    //   4729: iload 14
    //   4731: istore 13
    //   4733: new 1219	java/io/File
    //   4736: dup
    //   4737: getstatic 1523	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   4740: aload_3
    //   4741: invokespecial 1525	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   4744: invokevirtual 1223	java/io/File:exists	()Z
    //   4747: ifeq +6 -> 4753
    //   4750: iconst_1
    //   4751: istore 13
    //   4753: aload_2
    //   4754: ldc_w 1527
    //   4757: iload 13
    //   4759: invokevirtual 1530	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4762: pop
    //   4763: invokestatic 1534	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4766: invokevirtual 1537	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   4769: astore_3
    //   4770: aload_3
    //   4771: ifnull +214 -> 4985
    //   4774: aload_3
    //   4775: ldc_w 1539
    //   4778: invokevirtual 1545	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   4781: checkcast 1547	com/tencent/common/app/AppInterface
    //   4784: astore_3
    //   4785: aload_3
    //   4786: ifnull +199 -> 4985
    //   4789: invokestatic 1438	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4792: new 498	java/lang/StringBuilder
    //   4795: dup
    //   4796: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   4799: ldc_w 1549
    //   4802: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4805: aload_3
    //   4806: invokevirtual 1552	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4809: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4812: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4815: iconst_4
    //   4816: invokevirtual 1556	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   4819: astore_3
    //   4820: aload_3
    //   4821: ifnull +164 -> 4985
    //   4824: aload_3
    //   4825: ldc_w 1558
    //   4828: iconst_0
    //   4829: invokeinterface 1563 3 0
    //   4834: istore 13
    //   4836: aload_3
    //   4837: ldc_w 1565
    //   4840: iconst_0
    //   4841: invokeinterface 1563 3 0
    //   4846: istore 14
    //   4848: aload_3
    //   4849: ldc_w 1567
    //   4852: iconst_0
    //   4853: invokeinterface 1563 3 0
    //   4858: istore 15
    //   4860: aload_3
    //   4861: ldc_w 1569
    //   4864: iconst_0
    //   4865: invokeinterface 1563 3 0
    //   4870: istore 16
    //   4872: aload_3
    //   4873: ldc_w 1571
    //   4876: iconst_0
    //   4877: invokeinterface 1563 3 0
    //   4882: istore 17
    //   4884: aload_2
    //   4885: ldc_w 1573
    //   4888: iload 13
    //   4890: invokevirtual 1530	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4893: pop
    //   4894: aload_2
    //   4895: ldc_w 1575
    //   4898: iload 14
    //   4900: invokevirtual 1530	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4903: pop
    //   4904: aload_2
    //   4905: ldc_w 1577
    //   4908: iload 15
    //   4910: invokevirtual 1530	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4913: pop
    //   4914: aload_2
    //   4915: ldc_w 1579
    //   4918: iload 16
    //   4920: invokevirtual 1530	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4923: pop
    //   4924: aload_2
    //   4925: ldc_w 1581
    //   4928: iload 17
    //   4930: invokevirtual 1530	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4933: pop
    //   4934: aload_0
    //   4935: aload_1
    //   4936: iconst_1
    //   4937: anewarray 368	java/lang/String
    //   4940: dup
    //   4941: iconst_0
    //   4942: aload_2
    //   4943: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4946: aastore
    //   4947: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4950: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4953: ifeq +32 -> 4985
    //   4956: ldc 45
    //   4958: iconst_2
    //   4959: new 498	java/lang/StringBuilder
    //   4962: dup
    //   4963: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   4966: ldc_w 1514
    //   4969: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4972: aload_2
    //   4973: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4976: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4979: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4982: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4985: iconst_1
    //   4986: ireturn
    //   4987: astore_1
    //   4988: aload_1
    //   4989: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   4992: goto -7 -> 4985
    //   4995: ldc_w 1583
    //   4998: aload 4
    //   5000: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5003: ifeq +80 -> 5083
    //   5006: aload_0
    //   5007: iconst_4
    //   5008: invokespecial 987	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5011: checkcast 989	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler
    //   5014: astore_1
    //   5015: aload_1
    //   5016: ifnull +50 -> 5066
    //   5019: aload_0
    //   5020: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5023: invokevirtual 962	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   5026: astore_2
    //   5027: aload_2
    //   5028: ifnull +38 -> 5066
    //   5031: aload_2
    //   5032: invokeinterface 1588 1 0
    //   5037: aload_1
    //   5038: getfield 1591	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5041: ifnull +25 -> 5066
    //   5044: aload_1
    //   5045: getfield 1591	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5048: getfield 1596	com/tencent/mobileqq/utils/ShareActionSheetBuilder:b	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5051: ifnull +15 -> 5066
    //   5054: aload_1
    //   5055: getfield 1591	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5058: getfield 1596	com/tencent/mobileqq/utils/ShareActionSheetBuilder:b	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5061: bipush 8
    //   5063: invokevirtual 1601	com/tencent/biz/widgets/ElasticHorScrView:setVisibility	(I)V
    //   5066: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5069: ifeq +12 -> 5081
    //   5072: ldc 45
    //   5074: iconst_2
    //   5075: ldc_w 1583
    //   5078: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5081: iconst_1
    //   5082: ireturn
    //   5083: ldc_w 1603
    //   5086: aload 4
    //   5088: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5091: ifeq +141 -> 5232
    //   5094: new 355	org/json/JSONObject
    //   5097: dup
    //   5098: invokespecial 356	org/json/JSONObject:<init>	()V
    //   5101: astore_3
    //   5102: invokestatic 1606	com/tencent/biz/pubaccount/readinjoy/biu/BiuBehaviour:a	()I
    //   5105: iconst_1
    //   5106: if_icmpne +8830 -> 13936
    //   5109: ldc_w 1608
    //   5112: astore_1
    //   5113: invokestatic 1610	com/tencent/biz/pubaccount/readinjoy/biu/BiuBehaviour:b	()I
    //   5116: iconst_1
    //   5117: if_icmpne +8826 -> 13943
    //   5120: ldc_w 1608
    //   5123: astore_2
    //   5124: aload_3
    //   5125: ldc_w 358
    //   5128: iconst_0
    //   5129: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   5132: pop
    //   5133: aload_3
    //   5134: ldc_w 1612
    //   5137: aload_1
    //   5138: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5141: pop
    //   5142: aload_3
    //   5143: ldc_w 1614
    //   5146: aload_2
    //   5147: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5150: pop
    //   5151: aload 5
    //   5153: ifnull +53 -> 5206
    //   5156: aload 5
    //   5158: arraylength
    //   5159: ifle +47 -> 5206
    //   5162: new 355	org/json/JSONObject
    //   5165: dup
    //   5166: aload 5
    //   5168: iconst_0
    //   5169: aaload
    //   5170: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5173: ldc_w 525
    //   5176: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5179: astore_1
    //   5180: aload_1
    //   5181: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5184: ifne +8750 -> 13934
    //   5187: aload_0
    //   5188: aload_1
    //   5189: iconst_1
    //   5190: anewarray 368	java/lang/String
    //   5193: dup
    //   5194: iconst_0
    //   5195: aload_3
    //   5196: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5199: aastore
    //   5200: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5203: goto +8731 -> 13934
    //   5206: ldc 45
    //   5208: iconst_1
    //   5209: ldc_w 1616
    //   5212: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5215: goto +8719 -> 13934
    //   5218: astore_1
    //   5219: ldc 45
    //   5221: iconst_1
    //   5222: ldc_w 1618
    //   5225: aload_1
    //   5226: invokestatic 1621	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5229: goto +8705 -> 13934
    //   5232: ldc_w 1623
    //   5235: aload 4
    //   5237: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5240: ifeq +135 -> 5375
    //   5243: aload 5
    //   5245: ifnull +101 -> 5346
    //   5248: aload 5
    //   5250: arraylength
    //   5251: ifle +95 -> 5346
    //   5254: new 355	org/json/JSONObject
    //   5257: dup
    //   5258: aload 5
    //   5260: iconst_0
    //   5261: aaload
    //   5262: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5265: astore_1
    //   5266: aload_1
    //   5267: ldc_w 525
    //   5270: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5273: astore_2
    //   5274: aload_2
    //   5275: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5278: ifne +25 -> 5303
    //   5281: aload_0
    //   5282: aload_2
    //   5283: iconst_1
    //   5284: anewarray 368	java/lang/String
    //   5287: dup
    //   5288: iconst_0
    //   5289: aload_0
    //   5290: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5293: invokevirtual 1626	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   5296: invokestatic 1631	com/tencent/biz/pubaccount/readinjoy/common/KBPDUtils:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   5299: aastore
    //   5300: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5303: new 498	java/lang/StringBuilder
    //   5306: dup
    //   5307: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5310: ldc 232
    //   5312: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5315: aload_1
    //   5316: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5319: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5322: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5325: astore_1
    //   5326: ldc 45
    //   5328: iconst_1
    //   5329: iconst_2
    //   5330: anewarray 687	java/lang/Object
    //   5333: dup
    //   5334: iconst_0
    //   5335: ldc_w 1618
    //   5338: aastore
    //   5339: dup
    //   5340: iconst_1
    //   5341: aload_1
    //   5342: aastore
    //   5343: invokestatic 697	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5346: iconst_1
    //   5347: ireturn
    //   5348: astore_1
    //   5349: new 498	java/lang/StringBuilder
    //   5352: dup
    //   5353: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5356: ldc 232
    //   5358: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5361: aload_1
    //   5362: invokevirtual 1632	org/json/JSONException:toString	()Ljava/lang/String;
    //   5365: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5368: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5371: astore_1
    //   5372: goto -46 -> 5326
    //   5375: ldc_w 1634
    //   5378: aload 4
    //   5380: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5383: ifeq +137 -> 5520
    //   5386: aload 5
    //   5388: ifnull +103 -> 5491
    //   5391: aload 5
    //   5393: arraylength
    //   5394: ifle +97 -> 5491
    //   5397: new 355	org/json/JSONObject
    //   5400: dup
    //   5401: aload 5
    //   5403: iconst_0
    //   5404: aaload
    //   5405: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5408: astore_1
    //   5409: aload_1
    //   5410: ldc_w 525
    //   5413: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5416: astore_2
    //   5417: aload_1
    //   5418: ldc_w 1636
    //   5421: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5424: astore_3
    //   5425: aload_2
    //   5426: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5429: ifne +19 -> 5448
    //   5432: aload_0
    //   5433: aload_2
    //   5434: iconst_1
    //   5435: anewarray 368	java/lang/String
    //   5438: dup
    //   5439: iconst_0
    //   5440: aload_3
    //   5441: invokestatic 1639	com/tencent/biz/pubaccount/util/Achilles:a	(Ljava/lang/String;)Ljava/lang/String;
    //   5444: aastore
    //   5445: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5448: new 498	java/lang/StringBuilder
    //   5451: dup
    //   5452: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5455: ldc 232
    //   5457: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5460: aload_1
    //   5461: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5464: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5467: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5470: astore_1
    //   5471: ldc 45
    //   5473: iconst_1
    //   5474: iconst_2
    //   5475: anewarray 687	java/lang/Object
    //   5478: dup
    //   5479: iconst_0
    //   5480: ldc_w 1618
    //   5483: aastore
    //   5484: dup
    //   5485: iconst_1
    //   5486: aload_1
    //   5487: aastore
    //   5488: invokestatic 697	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5491: iconst_1
    //   5492: ireturn
    //   5493: astore_1
    //   5494: new 498	java/lang/StringBuilder
    //   5497: dup
    //   5498: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5501: ldc 232
    //   5503: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5506: aload_1
    //   5507: invokevirtual 1640	java/lang/Exception:toString	()Ljava/lang/String;
    //   5510: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5513: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5516: astore_1
    //   5517: goto -46 -> 5471
    //   5520: ldc_w 1642
    //   5523: aload 4
    //   5525: invokevirtual 1336	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5528: ifeq +137 -> 5665
    //   5531: aload 5
    //   5533: ifnull +100 -> 5633
    //   5536: aload 5
    //   5538: arraylength
    //   5539: ifle +94 -> 5633
    //   5542: new 355	org/json/JSONObject
    //   5545: dup
    //   5546: aload 5
    //   5548: iconst_0
    //   5549: aaload
    //   5550: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5553: astore_1
    //   5554: aload_1
    //   5555: ldc_w 525
    //   5558: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5561: astore_2
    //   5562: aload_1
    //   5563: ldc_w 1636
    //   5566: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5569: astore_3
    //   5570: aload_2
    //   5571: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5574: ifne +16 -> 5590
    //   5577: aload_2
    //   5578: aload_3
    //   5579: aload_0
    //   5580: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5583: iconst_0
    //   5584: invokestatic 1645	com/tencent/biz/pubaccount/util/Achilles:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;Z)Z
    //   5587: ifeq +48 -> 5635
    //   5590: new 498	java/lang/StringBuilder
    //   5593: dup
    //   5594: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5597: ldc 232
    //   5599: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5602: aload_1
    //   5603: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5606: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5609: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5612: astore_1
    //   5613: ldc 45
    //   5615: iconst_1
    //   5616: iconst_2
    //   5617: anewarray 687	java/lang/Object
    //   5620: dup
    //   5621: iconst_0
    //   5622: ldc_w 1618
    //   5625: aastore
    //   5626: dup
    //   5627: iconst_1
    //   5628: aload_1
    //   5629: aastore
    //   5630: invokestatic 697	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5633: iconst_1
    //   5634: ireturn
    //   5635: goto -45 -> 5590
    //   5638: astore_1
    //   5639: new 498	java/lang/StringBuilder
    //   5642: dup
    //   5643: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5646: ldc 232
    //   5648: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5651: aload_1
    //   5652: invokevirtual 1640	java/lang/Exception:toString	()Ljava/lang/String;
    //   5655: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5658: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5661: astore_1
    //   5662: goto -49 -> 5613
    //   5665: ldc_w 1647
    //   5668: aload 4
    //   5670: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5673: ifeq +65 -> 5738
    //   5676: aload 5
    //   5678: ifnull -1187 -> 4491
    //   5681: aload 5
    //   5683: arraylength
    //   5684: ifle -1193 -> 4491
    //   5687: new 355	org/json/JSONObject
    //   5690: dup
    //   5691: aload 5
    //   5693: iconst_0
    //   5694: aaload
    //   5695: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5698: ldc_w 1649
    //   5701: iconst_1
    //   5702: invokevirtual 639	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5705: istore 13
    //   5707: getstatic 1654	com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager:a	Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager$Companion;
    //   5710: invokevirtual 1659	com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager$Companion:a	()Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager;
    //   5713: iload 13
    //   5715: ldc_w 1661
    //   5718: invokevirtual 1664	com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager:a	(ZLjava/lang/String;)V
    //   5721: goto -1230 -> 4491
    //   5724: astore_1
    //   5725: ldc 45
    //   5727: iconst_1
    //   5728: aload_1
    //   5729: invokevirtual 1632	org/json/JSONException:toString	()Ljava/lang/String;
    //   5732: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5735: goto -1244 -> 4491
    //   5738: ldc_w 1666
    //   5741: aload 4
    //   5743: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5746: ifeq +139 -> 5885
    //   5749: aload 5
    //   5751: ifnull -1260 -> 4491
    //   5754: aload 5
    //   5756: arraylength
    //   5757: ifle -1266 -> 4491
    //   5760: new 355	org/json/JSONObject
    //   5763: dup
    //   5764: aload 5
    //   5766: iconst_0
    //   5767: aaload
    //   5768: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5771: astore_3
    //   5772: aload_3
    //   5773: ldc_w 1412
    //   5776: iconst_0
    //   5777: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5780: istore 6
    //   5782: aload_3
    //   5783: ldc_w 1668
    //   5786: iconst_0
    //   5787: invokevirtual 639	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5790: istore 13
    //   5792: aload_3
    //   5793: ldc_w 1670
    //   5796: iconst_0
    //   5797: invokevirtual 639	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5800: istore 14
    //   5802: aload_3
    //   5803: ldc_w 1672
    //   5806: ldc 232
    //   5808: invokevirtual 516	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5811: astore_1
    //   5812: aload_3
    //   5813: ldc_w 1674
    //   5816: iconst_1
    //   5817: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5820: istore 7
    //   5822: aload_3
    //   5823: ldc_w 1676
    //   5826: ldc 232
    //   5828: invokevirtual 516	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5831: astore_2
    //   5832: aload_3
    //   5833: ldc_w 525
    //   5836: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5839: astore_3
    //   5840: getstatic 1654	com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager:a	Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager$Companion;
    //   5843: invokevirtual 1659	com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager$Companion:a	()Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager;
    //   5846: iload 6
    //   5848: iload 13
    //   5850: iload 14
    //   5852: aload_1
    //   5853: iload 7
    //   5855: aload_2
    //   5856: new 1678	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$5
    //   5859: dup
    //   5860: aload_0
    //   5861: aload_3
    //   5862: invokespecial 1681	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$5:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;)V
    //   5865: invokevirtual 1684	com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager:a	(IZZLjava/lang/String;ILjava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager$IPushNotifyDialogCallback;)V
    //   5868: goto -1377 -> 4491
    //   5871: astore_1
    //   5872: ldc 45
    //   5874: iconst_1
    //   5875: aload_1
    //   5876: invokevirtual 1632	org/json/JSONException:toString	()Ljava/lang/String;
    //   5879: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5882: goto -1391 -> 4491
    //   5885: ldc_w 1686
    //   5888: aload 4
    //   5890: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5893: ifeq +2567 -> 8460
    //   5896: aload 5
    //   5898: ifnull -1407 -> 4491
    //   5901: aload 5
    //   5903: arraylength
    //   5904: ifle -1413 -> 4491
    //   5907: new 355	org/json/JSONObject
    //   5910: dup
    //   5911: aload 5
    //   5913: iconst_0
    //   5914: aaload
    //   5915: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5918: astore 43
    //   5920: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5923: ifeq +33 -> 5956
    //   5926: ldc 45
    //   5928: iconst_2
    //   5929: new 498	java/lang/StringBuilder
    //   5932: dup
    //   5933: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   5936: ldc_w 1688
    //   5939: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5942: aload 43
    //   5944: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5947: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5950: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5953: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5956: aload 43
    //   5958: ldc_w 643
    //   5961: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5964: astore 42
    //   5966: aload 43
    //   5968: ldc_w 789
    //   5971: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5974: astore_3
    //   5975: aload 43
    //   5977: ldc_w 1690
    //   5980: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5983: astore 41
    //   5985: aload 41
    //   5987: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5990: ifeq +7960 -> 13950
    //   5993: aload_2
    //   5994: astore 41
    //   5996: aload 43
    //   5998: ldc_w 1692
    //   6001: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6004: istore 10
    //   6006: ldc 232
    //   6008: astore 5
    //   6010: iload 10
    //   6012: iconst_1
    //   6013: if_icmpne +24 -> 6037
    //   6016: new 368	java/lang/String
    //   6019: dup
    //   6020: aload 43
    //   6022: ldc_w 1694
    //   6025: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6028: iconst_2
    //   6029: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6032: invokespecial 652	java/lang/String:<init>	([B)V
    //   6035: astore 5
    //   6037: lconst_0
    //   6038: lstore 18
    //   6040: lconst_0
    //   6041: lstore 22
    //   6043: lconst_0
    //   6044: lstore 24
    //   6046: lconst_0
    //   6047: lstore 36
    //   6049: lconst_0
    //   6050: lstore 38
    //   6052: ldc 232
    //   6054: astore 40
    //   6056: new 368	java/lang/String
    //   6059: dup
    //   6060: aload 42
    //   6062: iconst_0
    //   6063: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6066: invokespecial 652	java/lang/String:<init>	([B)V
    //   6069: astore_1
    //   6070: new 368	java/lang/String
    //   6073: dup
    //   6074: aload_3
    //   6075: iconst_0
    //   6076: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6079: invokespecial 652	java/lang/String:<init>	([B)V
    //   6082: astore_2
    //   6083: aload 43
    //   6085: ldc_w 1696
    //   6088: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6091: astore_3
    //   6092: aload 43
    //   6094: ldc_w 512
    //   6097: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6100: astore 4
    //   6102: aload 4
    //   6104: astore 40
    //   6106: lload 18
    //   6108: lstore 20
    //   6110: lload 38
    //   6112: lstore 34
    //   6114: lload 36
    //   6116: lstore 32
    //   6118: lload 24
    //   6120: lstore 30
    //   6122: lload 22
    //   6124: lstore 28
    //   6126: lload 18
    //   6128: lstore 26
    //   6130: aload_3
    //   6131: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6134: ifne +36 -> 6170
    //   6137: lload 38
    //   6139: lstore 34
    //   6141: lload 36
    //   6143: lstore 32
    //   6145: lload 24
    //   6147: lstore 30
    //   6149: lload 22
    //   6151: lstore 28
    //   6153: lload 18
    //   6155: lstore 26
    //   6157: new 1698	java/math/BigInteger
    //   6160: dup
    //   6161: aload_3
    //   6162: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6165: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   6168: lstore 20
    //   6170: lload 38
    //   6172: lstore 34
    //   6174: lload 36
    //   6176: lstore 32
    //   6178: lload 24
    //   6180: lstore 30
    //   6182: lload 22
    //   6184: lstore 28
    //   6186: lload 20
    //   6188: lstore 26
    //   6190: aload 43
    //   6192: ldc_w 1704
    //   6195: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6198: astore 4
    //   6200: lload 22
    //   6202: lstore 18
    //   6204: lload 38
    //   6206: lstore 34
    //   6208: lload 36
    //   6210: lstore 32
    //   6212: lload 24
    //   6214: lstore 30
    //   6216: lload 22
    //   6218: lstore 28
    //   6220: lload 20
    //   6222: lstore 26
    //   6224: aload 4
    //   6226: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6229: ifne +37 -> 6266
    //   6232: lload 38
    //   6234: lstore 34
    //   6236: lload 36
    //   6238: lstore 32
    //   6240: lload 24
    //   6242: lstore 30
    //   6244: lload 22
    //   6246: lstore 28
    //   6248: lload 20
    //   6250: lstore 26
    //   6252: new 1698	java/math/BigInteger
    //   6255: dup
    //   6256: aload 4
    //   6258: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6261: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   6264: lstore 18
    //   6266: lload 38
    //   6268: lstore 34
    //   6270: lload 36
    //   6272: lstore 32
    //   6274: lload 24
    //   6276: lstore 30
    //   6278: lload 18
    //   6280: lstore 28
    //   6282: lload 20
    //   6284: lstore 26
    //   6286: aload 43
    //   6288: ldc_w 1706
    //   6291: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6294: astore 4
    //   6296: lload 24
    //   6298: lstore 22
    //   6300: lload 38
    //   6302: lstore 34
    //   6304: lload 36
    //   6306: lstore 32
    //   6308: lload 24
    //   6310: lstore 30
    //   6312: lload 18
    //   6314: lstore 28
    //   6316: lload 20
    //   6318: lstore 26
    //   6320: aload 4
    //   6322: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6325: ifne +37 -> 6362
    //   6328: lload 38
    //   6330: lstore 34
    //   6332: lload 36
    //   6334: lstore 32
    //   6336: lload 24
    //   6338: lstore 30
    //   6340: lload 18
    //   6342: lstore 28
    //   6344: lload 20
    //   6346: lstore 26
    //   6348: new 1698	java/math/BigInteger
    //   6351: dup
    //   6352: aload 4
    //   6354: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6357: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   6360: lstore 22
    //   6362: lload 38
    //   6364: lstore 34
    //   6366: lload 36
    //   6368: lstore 32
    //   6370: lload 22
    //   6372: lstore 30
    //   6374: lload 18
    //   6376: lstore 28
    //   6378: lload 20
    //   6380: lstore 26
    //   6382: aload 43
    //   6384: ldc_w 1708
    //   6387: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6390: astore 4
    //   6392: lload 36
    //   6394: lstore 24
    //   6396: lload 38
    //   6398: lstore 34
    //   6400: lload 36
    //   6402: lstore 32
    //   6404: lload 22
    //   6406: lstore 30
    //   6408: lload 18
    //   6410: lstore 28
    //   6412: lload 20
    //   6414: lstore 26
    //   6416: aload 4
    //   6418: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6421: ifne +37 -> 6458
    //   6424: lload 38
    //   6426: lstore 34
    //   6428: lload 36
    //   6430: lstore 32
    //   6432: lload 22
    //   6434: lstore 30
    //   6436: lload 18
    //   6438: lstore 28
    //   6440: lload 20
    //   6442: lstore 26
    //   6444: new 1698	java/math/BigInteger
    //   6447: dup
    //   6448: aload 4
    //   6450: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6453: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   6456: lstore 24
    //   6458: lload 38
    //   6460: lstore 34
    //   6462: lload 24
    //   6464: lstore 32
    //   6466: lload 22
    //   6468: lstore 30
    //   6470: lload 18
    //   6472: lstore 28
    //   6474: lload 20
    //   6476: lstore 26
    //   6478: aload 43
    //   6480: ldc_w 1710
    //   6483: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6486: lstore 36
    //   6488: lload 36
    //   6490: lstore 34
    //   6492: lload 24
    //   6494: lstore 32
    //   6496: lload 22
    //   6498: lstore 30
    //   6500: lload 18
    //   6502: lstore 28
    //   6504: lload 20
    //   6506: lstore 26
    //   6508: aload 43
    //   6510: ldc_w 1007
    //   6513: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6516: istore 7
    //   6518: lload 24
    //   6520: lstore 32
    //   6522: aload_3
    //   6523: astore 42
    //   6525: aload 40
    //   6527: astore_3
    //   6528: lload 20
    //   6530: lstore 26
    //   6532: lload 22
    //   6534: lstore 24
    //   6536: lload 36
    //   6538: lstore 20
    //   6540: lload 18
    //   6542: lstore 22
    //   6544: aload_1
    //   6545: astore 4
    //   6547: aload 42
    //   6549: astore_1
    //   6550: lload 26
    //   6552: lstore 18
    //   6554: aload 43
    //   6556: ldc_w 1712
    //   6559: lconst_1
    //   6560: invokevirtual 798	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   6563: lstore 26
    //   6565: aload 43
    //   6567: ldc_w 1412
    //   6570: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6573: istore 6
    //   6575: aload 43
    //   6577: ldc_w 1714
    //   6580: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6583: istore 9
    //   6585: aload 43
    //   6587: ldc_w 1716
    //   6590: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6593: astore 45
    //   6595: aload 43
    //   6597: ldc_w 793
    //   6600: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6603: istore 8
    //   6605: aload 43
    //   6607: ldc_w 525
    //   6610: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6613: astore 42
    //   6615: new 368	java/lang/String
    //   6618: dup
    //   6619: aload 43
    //   6621: ldc_w 1718
    //   6624: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6627: iconst_0
    //   6628: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6631: invokespecial 652	java/lang/String:<init>	([B)V
    //   6634: astore 46
    //   6636: aload 43
    //   6638: ldc_w 785
    //   6641: iconst_1
    //   6642: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6645: istore 11
    //   6647: new 1720	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   6650: dup
    //   6651: invokespecial 1721	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:<init>	()V
    //   6654: astore 44
    //   6656: aload 44
    //   6658: lload 22
    //   6660: putfield 1724	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   6663: aload 44
    //   6665: aload 4
    //   6667: putfield 1727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   6670: aload 44
    //   6672: aload_2
    //   6673: putfield 1730	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   6676: aload 44
    //   6678: aload 45
    //   6680: putfield 1733	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   6683: aload 44
    //   6685: iload 8
    //   6687: putfield 1736	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   6690: aload 44
    //   6692: lload 18
    //   6694: putfield 1739	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   6697: aload 44
    //   6699: aload 46
    //   6701: putfield 1742	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   6704: aload 44
    //   6706: lload 32
    //   6708: putfield 1744	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:businessId	J
    //   6711: aload 44
    //   6713: iload 11
    //   6715: putfield 1747	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   6718: aload 43
    //   6720: ldc_w 1749
    //   6723: invokevirtual 1752	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6726: astore 40
    //   6728: aload 44
    //   6730: new 1754	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo
    //   6733: dup
    //   6734: invokespecial 1755	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:<init>	()V
    //   6737: putfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6740: aload 44
    //   6742: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6745: new 1761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo
    //   6748: dup
    //   6749: invokespecial 1762	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:<init>	()V
    //   6752: putfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   6755: aload 44
    //   6757: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6760: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   6763: lload 24
    //   6765: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6768: putfield 1768	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   6771: aload 44
    //   6773: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6776: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   6779: lload 26
    //   6781: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6784: putfield 1770	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:b	Ljava/lang/Long;
    //   6787: aload 44
    //   6789: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6792: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   6795: new 249	java/util/ArrayList
    //   6798: dup
    //   6799: invokespecial 250	java/util/ArrayList:<init>	()V
    //   6802: putfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6805: aload 40
    //   6807: ifnull +387 -> 7194
    //   6810: iconst_0
    //   6811: istore 8
    //   6813: iload 8
    //   6815: aload 40
    //   6817: invokevirtual 539	org/json/JSONArray:length	()I
    //   6820: if_icmpge +374 -> 7194
    //   6823: new 1775	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   6826: dup
    //   6827: invokespecial 1776	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   6830: astore 47
    //   6832: aload 40
    //   6834: iload 8
    //   6836: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6839: astore 48
    //   6841: aload 47
    //   6843: aload 48
    //   6845: ldc_w 299
    //   6848: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6851: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6854: putfield 1783	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mUin	Ljava/lang/Long;
    //   6857: aload 47
    //   6859: new 368	java/lang/String
    //   6862: dup
    //   6863: aload 48
    //   6865: ldc_w 1785
    //   6868: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6871: iconst_0
    //   6872: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6875: invokespecial 652	java/lang/String:<init>	([B)V
    //   6878: putfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   6881: aload 47
    //   6883: aload 47
    //   6885: getfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   6888: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   6891: aload 47
    //   6893: aload 48
    //   6895: ldc_w 1793
    //   6898: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6901: putfield 1796	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuTime	I
    //   6904: aload 47
    //   6906: aload 48
    //   6908: ldc_w 666
    //   6911: iconst_1
    //   6912: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6915: putfield 1799	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedsType	I
    //   6918: aload 47
    //   6920: aload 48
    //   6922: ldc_w 1801
    //   6925: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6928: putfield 1804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOpType	I
    //   6931: aload 48
    //   6933: ldc_w 1806
    //   6936: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6939: astore 49
    //   6941: aload 48
    //   6943: ldc_w 1808
    //   6946: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6949: astore 50
    //   6951: aload 49
    //   6953: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6956: ifne +39 -> 6995
    //   6959: aload 50
    //   6961: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6964: ifne +31 -> 6995
    //   6967: aload 47
    //   6969: new 1810	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   6972: dup
    //   6973: lconst_0
    //   6974: new 368	java/lang/String
    //   6977: dup
    //   6978: aload 49
    //   6980: iconst_0
    //   6981: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   6984: invokespecial 652	java/lang/String:<init>	([B)V
    //   6987: aload 50
    //   6989: invokespecial 1813	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   6992: putfield 1817	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   6995: iload 10
    //   6997: iconst_1
    //   6998: if_icmpne +3 -> 7001
    //   7001: aload 48
    //   7003: ldc_w 1696
    //   7006: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7009: astore 48
    //   7011: aload 48
    //   7013: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7016: ifne +23 -> 7039
    //   7019: aload 47
    //   7021: new 1698	java/math/BigInteger
    //   7024: dup
    //   7025: aload 48
    //   7027: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7030: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   7033: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7036: putfield 1819	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   7039: aload 44
    //   7041: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7044: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   7047: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7050: aload 47
    //   7052: invokeinterface 1822 2 0
    //   7057: pop
    //   7058: iload 8
    //   7060: iconst_1
    //   7061: iadd
    //   7062: istore 8
    //   7064: goto -251 -> 6813
    //   7067: aload 4
    //   7069: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   7072: iconst_0
    //   7073: istore 7
    //   7075: lload 34
    //   7077: lstore 20
    //   7079: aload_3
    //   7080: astore 4
    //   7082: aload 40
    //   7084: astore_3
    //   7085: goto -531 -> 6554
    //   7088: astore 40
    //   7090: ldc 45
    //   7092: iconst_1
    //   7093: new 498	java/lang/StringBuilder
    //   7096: dup
    //   7097: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   7100: ldc_w 1824
    //   7103: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7106: aload 40
    //   7108: invokevirtual 1632	org/json/JSONException:toString	()Ljava/lang/String;
    //   7111: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7114: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7117: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7120: aconst_null
    //   7121: astore 40
    //   7123: goto -395 -> 6728
    //   7126: astore 48
    //   7128: ldc 45
    //   7130: iconst_1
    //   7131: new 498	java/lang/StringBuilder
    //   7134: dup
    //   7135: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   7138: ldc_w 1824
    //   7141: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7144: aload 48
    //   7146: invokevirtual 1640	java/lang/Exception:toString	()Ljava/lang/String;
    //   7149: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7152: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7155: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7158: goto -119 -> 7039
    //   7161: astore_1
    //   7162: ldc 45
    //   7164: iconst_1
    //   7165: new 498	java/lang/StringBuilder
    //   7168: dup
    //   7169: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   7172: ldc_w 1826
    //   7175: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7178: aload_1
    //   7179: invokevirtual 1632	org/json/JSONException:toString	()Ljava/lang/String;
    //   7182: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7185: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7188: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7191: goto -2700 -> 4491
    //   7194: aload 43
    //   7196: ldc_w 1828
    //   7199: invokevirtual 1832	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7202: astore 43
    //   7204: ldc 232
    //   7206: astore 40
    //   7208: aload 43
    //   7210: ifnull +6666 -> 13876
    //   7213: iload 11
    //   7215: lload 26
    //   7217: invokestatic 1837	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJItemViewType:a	(IJ)Z
    //   7220: ifeq +6656 -> 13876
    //   7223: aload 44
    //   7225: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7228: new 1839	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo
    //   7231: dup
    //   7232: invokespecial 1840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:<init>	()V
    //   7235: putfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7238: aload 43
    //   7240: ldc_w 1845
    //   7243: iconst_0
    //   7244: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7247: istore 12
    //   7249: aload 43
    //   7251: ldc_w 1847
    //   7254: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7257: astore 40
    //   7259: aload 43
    //   7261: ldc_w 1849
    //   7264: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7267: astore 47
    //   7269: aload 47
    //   7271: ifnull +364 -> 7635
    //   7274: aload 44
    //   7276: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7279: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7282: new 1761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo
    //   7285: dup
    //   7286: invokespecial 1762	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:<init>	()V
    //   7289: putfield 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   7292: aload 44
    //   7294: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7297: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7300: getfield 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   7303: new 249	java/util/ArrayList
    //   7306: dup
    //   7307: invokespecial 250	java/util/ArrayList:<init>	()V
    //   7310: putfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7313: iconst_0
    //   7314: istore 8
    //   7316: iload 8
    //   7318: aload 47
    //   7320: invokevirtual 539	org/json/JSONArray:length	()I
    //   7323: if_icmpge +312 -> 7635
    //   7326: new 1775	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   7329: dup
    //   7330: invokespecial 1776	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   7333: astore 48
    //   7335: aload 47
    //   7337: iload 8
    //   7339: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7342: astore 49
    //   7344: aload 48
    //   7346: aload 49
    //   7348: ldc_w 299
    //   7351: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   7354: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7357: putfield 1783	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mUin	Ljava/lang/Long;
    //   7360: aload 48
    //   7362: new 368	java/lang/String
    //   7365: dup
    //   7366: aload 49
    //   7368: ldc_w 1785
    //   7371: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7374: iconst_0
    //   7375: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7378: invokespecial 652	java/lang/String:<init>	([B)V
    //   7381: putfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   7384: aload 48
    //   7386: aload 48
    //   7388: getfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   7391: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   7394: aload 48
    //   7396: aload 49
    //   7398: ldc_w 1793
    //   7401: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7404: putfield 1796	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuTime	I
    //   7407: aload 48
    //   7409: aload 49
    //   7411: ldc_w 666
    //   7414: iconst_1
    //   7415: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7418: putfield 1799	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedsType	I
    //   7421: aload 48
    //   7423: aload 49
    //   7425: ldc_w 1801
    //   7428: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7431: putfield 1804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOpType	I
    //   7434: aload 49
    //   7436: ldc_w 1806
    //   7439: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7442: astore 50
    //   7444: aload 49
    //   7446: ldc_w 1808
    //   7449: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7452: astore 51
    //   7454: aload 50
    //   7456: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7459: ifne +39 -> 7498
    //   7462: aload 51
    //   7464: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7467: ifne +31 -> 7498
    //   7470: aload 48
    //   7472: new 1810	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   7475: dup
    //   7476: lconst_0
    //   7477: new 368	java/lang/String
    //   7480: dup
    //   7481: aload 50
    //   7483: iconst_0
    //   7484: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7487: invokespecial 652	java/lang/String:<init>	([B)V
    //   7490: aload 51
    //   7492: invokespecial 1813	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   7495: putfield 1817	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   7498: aload 49
    //   7500: ldc_w 1696
    //   7503: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7506: astore 49
    //   7508: aload 49
    //   7510: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7513: ifne +23 -> 7536
    //   7516: aload 48
    //   7518: new 1698	java/math/BigInteger
    //   7521: dup
    //   7522: aload 49
    //   7524: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7527: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   7530: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7533: putfield 1819	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   7536: aload 44
    //   7538: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7541: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7544: getfield 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   7547: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7550: aload 48
    //   7552: invokeinterface 1822 2 0
    //   7557: pop
    //   7558: iload 8
    //   7560: iconst_1
    //   7561: iadd
    //   7562: istore 8
    //   7564: goto -248 -> 7316
    //   7567: astore 49
    //   7569: ldc 45
    //   7571: iconst_1
    //   7572: new 498	java/lang/StringBuilder
    //   7575: dup
    //   7576: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   7579: ldc_w 1824
    //   7582: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7585: aload 49
    //   7587: invokevirtual 1640	java/lang/Exception:toString	()Ljava/lang/String;
    //   7590: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7593: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7596: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7599: goto -63 -> 7536
    //   7602: astore_1
    //   7603: ldc 45
    //   7605: iconst_1
    //   7606: new 498	java/lang/StringBuilder
    //   7609: dup
    //   7610: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   7613: ldc_w 1852
    //   7616: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7619: aload_1
    //   7620: invokevirtual 1853	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   7623: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7626: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7629: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7632: goto -3141 -> 4491
    //   7635: aload 44
    //   7637: new 368	java/lang/String
    //   7640: dup
    //   7641: aload 40
    //   7643: iconst_0
    //   7644: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   7647: invokespecial 652	java/lang/String:<init>	([B)V
    //   7650: putfield 1727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   7653: aload 44
    //   7655: ldc 232
    //   7657: putfield 1742	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   7660: iload 12
    //   7662: iconst_3
    //   7663: if_icmpeq +9 -> 7672
    //   7666: iload 12
    //   7668: iconst_2
    //   7669: if_icmpne +6311 -> 13980
    //   7672: aload 44
    //   7674: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7677: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7680: new 249	java/util/ArrayList
    //   7683: dup
    //   7684: invokespecial 250	java/util/ArrayList:<init>	()V
    //   7687: putfield 1854	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7690: new 1856	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCPicInfo
    //   7693: dup
    //   7694: invokespecial 1857	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCPicInfo:<init>	()V
    //   7697: astore 4
    //   7699: aload 43
    //   7701: ldc_w 1859
    //   7704: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7707: astore 43
    //   7709: aload 43
    //   7711: ifnull +6263 -> 13974
    //   7714: aload 43
    //   7716: invokevirtual 539	org/json/JSONArray:length	()I
    //   7719: ifle +6255 -> 13974
    //   7722: aload 4
    //   7724: aload 43
    //   7726: iconst_0
    //   7727: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7730: ldc_w 1861
    //   7733: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7736: putfield 1863	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCPicInfo:c	Ljava/lang/String;
    //   7739: aload 44
    //   7741: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7744: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7747: getfield 1854	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7750: aload 4
    //   7752: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7755: pop
    //   7756: goto +6218 -> 13974
    //   7759: iload 9
    //   7761: bipush 22
    //   7763: if_icmpne +52 -> 7815
    //   7766: new 1865	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo
    //   7769: dup
    //   7770: invokespecial 1866	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:<init>	()V
    //   7773: astore 4
    //   7775: aload 4
    //   7777: aload_2
    //   7778: putfield 1867	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7781: aload 4
    //   7783: aload 45
    //   7785: putfield 1868	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7788: aload 4
    //   7790: aload 46
    //   7792: putfield 1869	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:c	Ljava/lang/String;
    //   7795: aload 4
    //   7797: lload 20
    //   7799: putfield 1871	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:jdField_a_of_type_Long	J
    //   7802: aload 44
    //   7804: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7807: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7810: aload 4
    //   7812: putfield 1874	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo;
    //   7815: aload 44
    //   7817: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7820: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7823: iload 12
    //   7825: putfield 1875	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_Int	I
    //   7828: aload 44
    //   7830: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7833: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   7836: aload 44
    //   7838: getfield 1727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   7841: putfield 1876	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7844: aload 40
    //   7846: astore_2
    //   7847: aload 44
    //   7849: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7852: ldc 232
    //   7854: putfield 1877	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7857: aload 44
    //   7859: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7862: ldc 232
    //   7864: putfield 1878	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:c	Ljava/lang/String;
    //   7867: aload 44
    //   7869: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7872: ldc 232
    //   7874: putfield 1879	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7877: new 318	android/content/Intent
    //   7880: dup
    //   7881: aload_0
    //   7882: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   7885: ldc_w 1881
    //   7888: invokespecial 710	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7891: astore 4
    //   7893: aload 4
    //   7895: ldc_w 1883
    //   7898: aload 44
    //   7900: invokevirtual 1886	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   7903: pop
    //   7904: aload_3
    //   7905: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7908: ifne +13 -> 7921
    //   7911: aload 4
    //   7913: ldc_w 1888
    //   7916: aload_3
    //   7917: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7920: pop
    //   7921: aload 4
    //   7923: ldc_w 1890
    //   7926: iload 9
    //   7928: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7931: pop
    //   7932: aload 4
    //   7934: ldc_w 1892
    //   7937: iload 6
    //   7939: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7942: pop
    //   7943: aload 4
    //   7945: ldc_w 1894
    //   7948: aload 42
    //   7950: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7953: pop
    //   7954: iconst_3
    //   7955: istore 6
    //   7957: iload 9
    //   7959: iconst_5
    //   7960: if_icmpne +6044 -> 14004
    //   7963: iconst_4
    //   7964: istore 6
    //   7966: aload 4
    //   7968: ldc_w 1896
    //   7971: iload 6
    //   7973: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7976: pop
    //   7977: aload 4
    //   7979: ldc_w 1898
    //   7982: aload_1
    //   7983: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7986: pop
    //   7987: aload 4
    //   7989: ldc_w 785
    //   7992: iload 11
    //   7994: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7997: pop
    //   7998: aload 4
    //   8000: ldc_w 1900
    //   8003: aload_2
    //   8004: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8007: pop
    //   8008: aload 4
    //   8010: ldc_w 1902
    //   8013: lload 20
    //   8015: invokevirtual 1905	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8018: pop
    //   8019: aload 4
    //   8021: ldc_w 1907
    //   8024: iload 7
    //   8026: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8029: pop
    //   8030: aload 4
    //   8032: ldc_w 1909
    //   8035: aload 41
    //   8037: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8040: pop
    //   8041: iload 9
    //   8043: bipush 23
    //   8045: if_icmpne +145 -> 8190
    //   8048: aload 41
    //   8050: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8053: ifne +14 -> 8067
    //   8056: aload 44
    //   8058: getfield 1730	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   8061: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8064: ifeq +126 -> 8190
    //   8067: ldc 45
    //   8069: iconst_1
    //   8070: ldc_w 1911
    //   8073: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8076: iconst_0
    //   8077: ireturn
    //   8078: aload 44
    //   8080: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8083: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   8086: new 249	java/util/ArrayList
    //   8089: dup
    //   8090: invokespecial 250	java/util/ArrayList:<init>	()V
    //   8093: putfield 1913	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   8096: new 1915	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo
    //   8099: dup
    //   8100: invokespecial 1916	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:<init>	()V
    //   8103: astore 47
    //   8105: aload 43
    //   8107: ldc_w 1918
    //   8110: invokevirtual 1832	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   8113: astore 43
    //   8115: aload 43
    //   8117: ifnull +5878 -> 13995
    //   8120: aload 47
    //   8122: aload 43
    //   8124: ldc_w 1920
    //   8127: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8130: putfield 1922	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:d	Ljava/lang/String;
    //   8133: aload 47
    //   8135: aload 43
    //   8137: ldc_w 1924
    //   8140: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8143: i2l
    //   8144: putfield 1925	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:jdField_a_of_type_Long	J
    //   8147: aload 47
    //   8149: aload 4
    //   8151: putfield 1927	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:e	Ljava/lang/String;
    //   8154: aload 44
    //   8156: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8159: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   8162: getfield 1913	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   8165: aload 47
    //   8167: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8170: pop
    //   8171: goto +5824 -> 13995
    //   8174: iload 12
    //   8176: iconst_1
    //   8177: if_icmpne +5824 -> 14001
    //   8180: aload 44
    //   8182: ldc 232
    //   8184: putfield 1733	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   8187: goto +5814 -> 14001
    //   8190: iload 10
    //   8192: iconst_1
    //   8193: if_icmpne +163 -> 8356
    //   8196: aload 44
    //   8198: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8201: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   8204: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8207: ifnull +5663 -> 13870
    //   8210: aload 44
    //   8212: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8215: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   8218: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8221: invokeinterface 1928 1 0
    //   8226: ifle +5644 -> 13870
    //   8229: new 498	java/lang/StringBuilder
    //   8232: dup
    //   8233: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   8236: aload 5
    //   8238: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8241: ldc_w 1930
    //   8244: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8247: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8250: astore_1
    //   8251: aload_1
    //   8252: astore_2
    //   8253: aload_1
    //   8254: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8257: ifeq +7 -> 8264
    //   8260: ldc_w 1932
    //   8263: astore_2
    //   8264: new 498	java/lang/StringBuilder
    //   8267: dup
    //   8268: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   8271: ldc_w 1934
    //   8274: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8277: aload_2
    //   8278: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8281: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8284: astore_1
    //   8285: invokestatic 1939	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngineEventDispatcher:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngineEventDispatcher;
    //   8288: new 1941	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver
    //   8291: dup
    //   8292: aload_0
    //   8293: aload 42
    //   8295: iload 11
    //   8297: invokespecial 1944	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;I)V
    //   8300: invokevirtual 1947	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngineEventDispatcher:a	(Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;)V
    //   8303: aload_0
    //   8304: getfield 1949	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:app	Lcom/tencent/common/app/AppInterface;
    //   8307: checkcast 1951	com/tencent/mobileqq/app/BrowserAppInterface
    //   8310: invokevirtual 1954	com/tencent/mobileqq/app/BrowserAppInterface:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicManager;
    //   8313: invokevirtual 1959	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine;
    //   8316: aload_0
    //   8317: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8320: invokevirtual 1626	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   8323: invokevirtual 1962	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   8326: lload 18
    //   8328: aload 44
    //   8330: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8333: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   8336: lconst_0
    //   8337: aload_1
    //   8338: lload 22
    //   8340: ldc2_w 794
    //   8343: iload 6
    //   8345: aload_3
    //   8346: iload 11
    //   8348: aload 44
    //   8350: invokevirtual 1967	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	(JJLcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;JLjava/lang/String;JJILjava/lang/String;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   8353: goto -3862 -> 4491
    //   8356: aload 4
    //   8358: ldc_w 1896
    //   8361: iconst_4
    //   8362: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8365: pop
    //   8366: aload 4
    //   8368: ldc_w 1890
    //   8371: iconst_0
    //   8372: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8375: pop
    //   8376: aload 4
    //   8378: ldc_w 1969
    //   8381: iconst_0
    //   8382: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8385: pop
    //   8386: aload 4
    //   8388: ldc_w 785
    //   8391: iconst_1
    //   8392: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8395: pop
    //   8396: aload 4
    //   8398: ldc_w 1971
    //   8401: iconst_0
    //   8402: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8405: pop
    //   8406: aload 4
    //   8408: ldc_w 1973
    //   8411: iconst_1
    //   8412: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8415: pop
    //   8416: aload 4
    //   8418: ldc_w 1975
    //   8421: iconst_1
    //   8422: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8425: pop
    //   8426: aload 4
    //   8428: ldc_w 1977
    //   8431: lload 18
    //   8433: invokevirtual 1905	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8436: pop
    //   8437: aload_0
    //   8438: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8441: aload 4
    //   8443: bipush 113
    //   8445: invokevirtual 775	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   8448: aload_0
    //   8449: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8452: iconst_0
    //   8453: iconst_0
    //   8454: invokevirtual 1980	android/app/Activity:overridePendingTransition	(II)V
    //   8457: goto -3966 -> 4491
    //   8460: ldc_w 1982
    //   8463: aload 4
    //   8465: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   8468: ifeq +2365 -> 10833
    //   8471: aload 5
    //   8473: ifnull -3982 -> 4491
    //   8476: aload 5
    //   8478: arraylength
    //   8479: ifle -3988 -> 4491
    //   8482: aload_0
    //   8483: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   8486: instanceof 1984
    //   8489: ifeq -3998 -> 4491
    //   8492: new 355	org/json/JSONObject
    //   8495: dup
    //   8496: aload 5
    //   8498: iconst_0
    //   8499: aaload
    //   8500: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8503: astore 43
    //   8505: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8508: ifeq +33 -> 8541
    //   8511: ldc 45
    //   8513: iconst_2
    //   8514: new 498	java/lang/StringBuilder
    //   8517: dup
    //   8518: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   8521: ldc_w 1688
    //   8524: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8527: aload 43
    //   8529: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8532: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8535: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8538: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8541: aload 43
    //   8543: ldc_w 643
    //   8546: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8549: astore 42
    //   8551: aload 43
    //   8553: ldc_w 789
    //   8556: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8559: astore_3
    //   8560: aload 43
    //   8562: ldc_w 1690
    //   8565: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8568: astore 41
    //   8570: aload 41
    //   8572: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8575: ifeq +5498 -> 14073
    //   8578: aload_2
    //   8579: astore 41
    //   8581: aload 43
    //   8583: ldc_w 1692
    //   8586: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8589: istore 10
    //   8591: ldc 232
    //   8593: astore 5
    //   8595: iload 10
    //   8597: iconst_1
    //   8598: if_icmpne +24 -> 8622
    //   8601: new 368	java/lang/String
    //   8604: dup
    //   8605: aload 43
    //   8607: ldc_w 1694
    //   8610: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8613: iconst_2
    //   8614: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   8617: invokespecial 652	java/lang/String:<init>	([B)V
    //   8620: astore 5
    //   8622: lconst_0
    //   8623: lstore 18
    //   8625: lconst_0
    //   8626: lstore 22
    //   8628: lconst_0
    //   8629: lstore 24
    //   8631: lconst_0
    //   8632: lstore 36
    //   8634: lconst_0
    //   8635: lstore 38
    //   8637: ldc 232
    //   8639: astore 40
    //   8641: new 368	java/lang/String
    //   8644: dup
    //   8645: aload 42
    //   8647: iconst_0
    //   8648: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   8651: invokespecial 652	java/lang/String:<init>	([B)V
    //   8654: astore_1
    //   8655: new 368	java/lang/String
    //   8658: dup
    //   8659: aload_3
    //   8660: iconst_0
    //   8661: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   8664: invokespecial 652	java/lang/String:<init>	([B)V
    //   8667: astore_2
    //   8668: aload 43
    //   8670: ldc_w 1696
    //   8673: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8676: astore_3
    //   8677: aload 43
    //   8679: ldc_w 512
    //   8682: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8685: astore 4
    //   8687: aload 4
    //   8689: astore 40
    //   8691: lload 18
    //   8693: lstore 20
    //   8695: lload 38
    //   8697: lstore 34
    //   8699: lload 36
    //   8701: lstore 32
    //   8703: lload 24
    //   8705: lstore 30
    //   8707: lload 22
    //   8709: lstore 28
    //   8711: lload 18
    //   8713: lstore 26
    //   8715: aload_3
    //   8716: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8719: ifne +36 -> 8755
    //   8722: lload 38
    //   8724: lstore 34
    //   8726: lload 36
    //   8728: lstore 32
    //   8730: lload 24
    //   8732: lstore 30
    //   8734: lload 22
    //   8736: lstore 28
    //   8738: lload 18
    //   8740: lstore 26
    //   8742: new 1698	java/math/BigInteger
    //   8745: dup
    //   8746: aload_3
    //   8747: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8750: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   8753: lstore 20
    //   8755: lload 38
    //   8757: lstore 34
    //   8759: lload 36
    //   8761: lstore 32
    //   8763: lload 24
    //   8765: lstore 30
    //   8767: lload 22
    //   8769: lstore 28
    //   8771: lload 20
    //   8773: lstore 26
    //   8775: aload 43
    //   8777: ldc_w 1704
    //   8780: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8783: astore 4
    //   8785: lload 22
    //   8787: lstore 18
    //   8789: lload 38
    //   8791: lstore 34
    //   8793: lload 36
    //   8795: lstore 32
    //   8797: lload 24
    //   8799: lstore 30
    //   8801: lload 22
    //   8803: lstore 28
    //   8805: lload 20
    //   8807: lstore 26
    //   8809: aload 4
    //   8811: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8814: ifne +37 -> 8851
    //   8817: lload 38
    //   8819: lstore 34
    //   8821: lload 36
    //   8823: lstore 32
    //   8825: lload 24
    //   8827: lstore 30
    //   8829: lload 22
    //   8831: lstore 28
    //   8833: lload 20
    //   8835: lstore 26
    //   8837: new 1698	java/math/BigInteger
    //   8840: dup
    //   8841: aload 4
    //   8843: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8846: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   8849: lstore 18
    //   8851: lload 38
    //   8853: lstore 34
    //   8855: lload 36
    //   8857: lstore 32
    //   8859: lload 24
    //   8861: lstore 30
    //   8863: lload 18
    //   8865: lstore 28
    //   8867: lload 20
    //   8869: lstore 26
    //   8871: aload 43
    //   8873: ldc_w 1706
    //   8876: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8879: astore 4
    //   8881: lload 24
    //   8883: lstore 22
    //   8885: lload 38
    //   8887: lstore 34
    //   8889: lload 36
    //   8891: lstore 32
    //   8893: lload 24
    //   8895: lstore 30
    //   8897: lload 18
    //   8899: lstore 28
    //   8901: lload 20
    //   8903: lstore 26
    //   8905: aload 4
    //   8907: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8910: ifne +37 -> 8947
    //   8913: lload 38
    //   8915: lstore 34
    //   8917: lload 36
    //   8919: lstore 32
    //   8921: lload 24
    //   8923: lstore 30
    //   8925: lload 18
    //   8927: lstore 28
    //   8929: lload 20
    //   8931: lstore 26
    //   8933: new 1698	java/math/BigInteger
    //   8936: dup
    //   8937: aload 4
    //   8939: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8942: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   8945: lstore 22
    //   8947: lload 38
    //   8949: lstore 34
    //   8951: lload 36
    //   8953: lstore 32
    //   8955: lload 22
    //   8957: lstore 30
    //   8959: lload 18
    //   8961: lstore 28
    //   8963: lload 20
    //   8965: lstore 26
    //   8967: aload 43
    //   8969: ldc_w 1708
    //   8972: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8975: astore 4
    //   8977: lload 36
    //   8979: lstore 24
    //   8981: lload 38
    //   8983: lstore 34
    //   8985: lload 36
    //   8987: lstore 32
    //   8989: lload 22
    //   8991: lstore 30
    //   8993: lload 18
    //   8995: lstore 28
    //   8997: lload 20
    //   8999: lstore 26
    //   9001: aload 4
    //   9003: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9006: ifne +37 -> 9043
    //   9009: lload 38
    //   9011: lstore 34
    //   9013: lload 36
    //   9015: lstore 32
    //   9017: lload 22
    //   9019: lstore 30
    //   9021: lload 18
    //   9023: lstore 28
    //   9025: lload 20
    //   9027: lstore 26
    //   9029: new 1698	java/math/BigInteger
    //   9032: dup
    //   9033: aload 4
    //   9035: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9038: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   9041: lstore 24
    //   9043: lload 38
    //   9045: lstore 34
    //   9047: lload 24
    //   9049: lstore 32
    //   9051: lload 22
    //   9053: lstore 30
    //   9055: lload 18
    //   9057: lstore 28
    //   9059: lload 20
    //   9061: lstore 26
    //   9063: aload 43
    //   9065: ldc_w 1710
    //   9068: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9071: lstore 36
    //   9073: lload 36
    //   9075: lstore 34
    //   9077: lload 24
    //   9079: lstore 32
    //   9081: lload 22
    //   9083: lstore 30
    //   9085: lload 18
    //   9087: lstore 28
    //   9089: lload 20
    //   9091: lstore 26
    //   9093: aload 43
    //   9095: ldc_w 1007
    //   9098: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9101: istore 7
    //   9103: lload 24
    //   9105: lstore 32
    //   9107: aload_3
    //   9108: astore 42
    //   9110: aload 40
    //   9112: astore_3
    //   9113: lload 20
    //   9115: lstore 26
    //   9117: lload 22
    //   9119: lstore 24
    //   9121: lload 36
    //   9123: lstore 20
    //   9125: lload 18
    //   9127: lstore 22
    //   9129: aload_1
    //   9130: astore 4
    //   9132: aload 42
    //   9134: astore_1
    //   9135: lload 26
    //   9137: lstore 18
    //   9139: aload 43
    //   9141: ldc_w 1712
    //   9144: lconst_1
    //   9145: invokevirtual 798	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   9148: lstore 26
    //   9150: aload 43
    //   9152: ldc_w 1412
    //   9155: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9158: istore 6
    //   9160: aload 43
    //   9162: ldc_w 1714
    //   9165: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9168: istore 9
    //   9170: aload 43
    //   9172: ldc_w 1716
    //   9175: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9178: astore 45
    //   9180: aload 43
    //   9182: ldc_w 793
    //   9185: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9188: istore 8
    //   9190: aload 43
    //   9192: ldc_w 525
    //   9195: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9198: astore 42
    //   9200: new 368	java/lang/String
    //   9203: dup
    //   9204: aload 43
    //   9206: ldc_w 1718
    //   9209: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9212: iconst_0
    //   9213: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9216: invokespecial 652	java/lang/String:<init>	([B)V
    //   9219: astore 46
    //   9221: aload 43
    //   9223: ldc_w 785
    //   9226: iconst_1
    //   9227: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9230: istore 11
    //   9232: new 1720	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   9235: dup
    //   9236: invokespecial 1721	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:<init>	()V
    //   9239: astore 44
    //   9241: aload 44
    //   9243: lload 22
    //   9245: putfield 1724	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   9248: aload 44
    //   9250: aload 4
    //   9252: putfield 1727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   9255: aload 44
    //   9257: aload_2
    //   9258: putfield 1730	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   9261: aload 44
    //   9263: aload 45
    //   9265: putfield 1733	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   9268: aload 44
    //   9270: iload 8
    //   9272: putfield 1736	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   9275: aload 44
    //   9277: lload 18
    //   9279: putfield 1739	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   9282: aload 44
    //   9284: aload 46
    //   9286: putfield 1742	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   9289: aload 44
    //   9291: lload 32
    //   9293: putfield 1744	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:businessId	J
    //   9296: aload 44
    //   9298: iload 11
    //   9300: putfield 1747	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   9303: aload 43
    //   9305: ldc_w 1749
    //   9308: invokevirtual 1752	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9311: astore 40
    //   9313: aload 44
    //   9315: new 1754	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo
    //   9318: dup
    //   9319: invokespecial 1755	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:<init>	()V
    //   9322: putfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9325: aload 44
    //   9327: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9330: new 1761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo
    //   9333: dup
    //   9334: invokespecial 1762	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:<init>	()V
    //   9337: putfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9340: aload 44
    //   9342: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9345: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9348: lload 24
    //   9350: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9353: putfield 1768	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9356: aload 44
    //   9358: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9361: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9364: lload 26
    //   9366: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9369: putfield 1770	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:b	Ljava/lang/Long;
    //   9372: aload 44
    //   9374: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9377: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9380: new 249	java/util/ArrayList
    //   9383: dup
    //   9384: invokespecial 250	java/util/ArrayList:<init>	()V
    //   9387: putfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9390: aload 40
    //   9392: ifnull +312 -> 9704
    //   9395: iconst_0
    //   9396: istore 8
    //   9398: iload 8
    //   9400: aload 40
    //   9402: invokevirtual 539	org/json/JSONArray:length	()I
    //   9405: if_icmpge +299 -> 9704
    //   9408: new 1775	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   9411: dup
    //   9412: invokespecial 1776	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   9415: astore 47
    //   9417: aload 40
    //   9419: iload 8
    //   9421: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9424: astore 48
    //   9426: aload 47
    //   9428: aload 48
    //   9430: ldc_w 299
    //   9433: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9436: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9439: putfield 1783	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mUin	Ljava/lang/Long;
    //   9442: aload 47
    //   9444: new 368	java/lang/String
    //   9447: dup
    //   9448: aload 48
    //   9450: ldc_w 1785
    //   9453: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9456: iconst_0
    //   9457: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9460: invokespecial 652	java/lang/String:<init>	([B)V
    //   9463: putfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   9466: aload 47
    //   9468: aload 47
    //   9470: getfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   9473: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   9476: aload 47
    //   9478: aload 48
    //   9480: ldc_w 1793
    //   9483: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9486: putfield 1796	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuTime	I
    //   9489: aload 47
    //   9491: aload 48
    //   9493: ldc_w 666
    //   9496: iconst_1
    //   9497: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9500: putfield 1799	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedsType	I
    //   9503: aload 47
    //   9505: aload 48
    //   9507: ldc_w 1801
    //   9510: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9513: putfield 1804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOpType	I
    //   9516: aload 48
    //   9518: ldc_w 1806
    //   9521: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9524: astore 49
    //   9526: aload 48
    //   9528: ldc_w 1808
    //   9531: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9534: astore 50
    //   9536: aload 49
    //   9538: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9541: ifne +39 -> 9580
    //   9544: aload 50
    //   9546: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9549: ifne +31 -> 9580
    //   9552: aload 47
    //   9554: new 1810	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   9557: dup
    //   9558: lconst_0
    //   9559: new 368	java/lang/String
    //   9562: dup
    //   9563: aload 49
    //   9565: iconst_0
    //   9566: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9569: invokespecial 652	java/lang/String:<init>	([B)V
    //   9572: aload 50
    //   9574: invokespecial 1813	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   9577: putfield 1817	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   9580: iload 10
    //   9582: iconst_1
    //   9583: if_icmpne +3 -> 9586
    //   9586: aload 48
    //   9588: ldc_w 1696
    //   9591: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9594: astore 48
    //   9596: aload 48
    //   9598: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9601: ifne +23 -> 9624
    //   9604: aload 47
    //   9606: new 1698	java/math/BigInteger
    //   9609: dup
    //   9610: aload 48
    //   9612: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9615: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   9618: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9621: putfield 1819	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   9624: aload 44
    //   9626: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9629: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9632: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9635: aload 47
    //   9637: invokeinterface 1822 2 0
    //   9642: pop
    //   9643: iload 8
    //   9645: iconst_1
    //   9646: iadd
    //   9647: istore 8
    //   9649: goto -251 -> 9398
    //   9652: aload 4
    //   9654: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   9657: iconst_0
    //   9658: istore 7
    //   9660: lload 34
    //   9662: lstore 20
    //   9664: aload_3
    //   9665: astore 4
    //   9667: aload 40
    //   9669: astore_3
    //   9670: goto -531 -> 9139
    //   9673: astore 40
    //   9675: aload 40
    //   9677: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   9680: aconst_null
    //   9681: astore 40
    //   9683: goto -370 -> 9313
    //   9686: astore 48
    //   9688: aload 48
    //   9690: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   9693: goto -69 -> 9624
    //   9696: astore_1
    //   9697: aload_1
    //   9698: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   9701: goto -5210 -> 4491
    //   9704: aload 43
    //   9706: ldc_w 1828
    //   9709: invokevirtual 1832	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9712: astore 43
    //   9714: ldc 232
    //   9716: astore 40
    //   9718: aload 43
    //   9720: ifnull +4144 -> 13864
    //   9723: iload 11
    //   9725: lload 26
    //   9727: invokestatic 1837	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJItemViewType:a	(IJ)Z
    //   9730: ifeq +4134 -> 13864
    //   9733: aload 44
    //   9735: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9738: new 1839	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo
    //   9741: dup
    //   9742: invokespecial 1840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:<init>	()V
    //   9745: putfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   9748: aload 43
    //   9750: ldc_w 1845
    //   9753: iconst_0
    //   9754: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9757: istore 12
    //   9759: aload 43
    //   9761: ldc_w 1847
    //   9764: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9767: astore 40
    //   9769: aload 43
    //   9771: ldc_w 1849
    //   9774: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9777: astore 47
    //   9779: aload 47
    //   9781: ifnull +306 -> 10087
    //   9784: aload 44
    //   9786: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9789: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   9792: new 1761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo
    //   9795: dup
    //   9796: invokespecial 1762	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:<init>	()V
    //   9799: putfield 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9802: aload 44
    //   9804: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9807: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   9810: getfield 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   9813: new 249	java/util/ArrayList
    //   9816: dup
    //   9817: invokespecial 250	java/util/ArrayList:<init>	()V
    //   9820: putfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9823: iconst_0
    //   9824: istore 8
    //   9826: iload 8
    //   9828: aload 47
    //   9830: invokevirtual 539	org/json/JSONArray:length	()I
    //   9833: if_icmpge +254 -> 10087
    //   9836: new 1775	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   9839: dup
    //   9840: invokespecial 1776	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   9843: astore 48
    //   9845: aload 47
    //   9847: iload 8
    //   9849: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9852: astore 49
    //   9854: aload 48
    //   9856: aload 49
    //   9858: ldc_w 299
    //   9861: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9864: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9867: putfield 1783	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mUin	Ljava/lang/Long;
    //   9870: aload 48
    //   9872: new 368	java/lang/String
    //   9875: dup
    //   9876: aload 49
    //   9878: ldc_w 1785
    //   9881: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9884: iconst_0
    //   9885: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9888: invokespecial 652	java/lang/String:<init>	([B)V
    //   9891: putfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   9894: aload 48
    //   9896: aload 48
    //   9898: getfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   9901: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   9904: aload 48
    //   9906: aload 49
    //   9908: ldc_w 1793
    //   9911: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9914: putfield 1796	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mBiuTime	I
    //   9917: aload 48
    //   9919: aload 49
    //   9921: ldc_w 666
    //   9924: iconst_1
    //   9925: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9928: putfield 1799	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedsType	I
    //   9931: aload 48
    //   9933: aload 49
    //   9935: ldc_w 1801
    //   9938: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9941: putfield 1804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mOpType	I
    //   9944: aload 49
    //   9946: ldc_w 1806
    //   9949: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9952: astore 50
    //   9954: aload 49
    //   9956: ldc_w 1808
    //   9959: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9962: astore 51
    //   9964: aload 50
    //   9966: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9969: ifne +39 -> 10008
    //   9972: aload 51
    //   9974: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9977: ifne +31 -> 10008
    //   9980: aload 48
    //   9982: new 1810	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   9985: dup
    //   9986: lconst_0
    //   9987: new 368	java/lang/String
    //   9990: dup
    //   9991: aload 50
    //   9993: iconst_0
    //   9994: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   9997: invokespecial 652	java/lang/String:<init>	([B)V
    //   10000: aload 51
    //   10002: invokespecial 1813	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   10005: putfield 1817	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   10008: aload 49
    //   10010: ldc_w 1696
    //   10013: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10016: astore 49
    //   10018: aload 49
    //   10020: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10023: ifne +23 -> 10046
    //   10026: aload 48
    //   10028: new 1698	java/math/BigInteger
    //   10031: dup
    //   10032: aload 49
    //   10034: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   10037: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   10040: invokestatic 1033	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10043: putfield 1819	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   10046: aload 44
    //   10048: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10051: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10054: getfield 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   10057: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10060: aload 48
    //   10062: invokeinterface 1822 2 0
    //   10067: pop
    //   10068: iload 8
    //   10070: iconst_1
    //   10071: iadd
    //   10072: istore 8
    //   10074: goto -248 -> 9826
    //   10077: astore 49
    //   10079: aload 49
    //   10081: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   10084: goto -38 -> 10046
    //   10087: aload 44
    //   10089: new 368	java/lang/String
    //   10092: dup
    //   10093: aload 40
    //   10095: iconst_0
    //   10096: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   10099: invokespecial 652	java/lang/String:<init>	([B)V
    //   10102: putfield 1727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   10105: aload 44
    //   10107: ldc 232
    //   10109: putfield 1742	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   10112: iload 12
    //   10114: iconst_3
    //   10115: if_icmpeq +9 -> 10124
    //   10118: iload 12
    //   10120: iconst_2
    //   10121: if_icmpne +3982 -> 14103
    //   10124: aload 44
    //   10126: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10129: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10132: new 249	java/util/ArrayList
    //   10135: dup
    //   10136: invokespecial 250	java/util/ArrayList:<init>	()V
    //   10139: putfield 1854	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10142: new 1856	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCPicInfo
    //   10145: dup
    //   10146: invokespecial 1857	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCPicInfo:<init>	()V
    //   10149: astore 4
    //   10151: aload 43
    //   10153: ldc_w 1859
    //   10156: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10159: astore 43
    //   10161: aload 43
    //   10163: ifnull +3934 -> 14097
    //   10166: aload 43
    //   10168: invokevirtual 539	org/json/JSONArray:length	()I
    //   10171: ifle +3926 -> 14097
    //   10174: aload 4
    //   10176: aload 43
    //   10178: iconst_0
    //   10179: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   10182: ldc_w 1861
    //   10185: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10188: putfield 1863	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCPicInfo:c	Ljava/lang/String;
    //   10191: aload 44
    //   10193: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10196: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10199: getfield 1854	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10202: aload 4
    //   10204: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10207: pop
    //   10208: goto +3889 -> 14097
    //   10211: iload 9
    //   10213: bipush 22
    //   10215: if_icmpne +52 -> 10267
    //   10218: new 1865	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo
    //   10221: dup
    //   10222: invokespecial 1866	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:<init>	()V
    //   10225: astore 4
    //   10227: aload 4
    //   10229: aload_2
    //   10230: putfield 1867	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10233: aload 4
    //   10235: aload 45
    //   10237: putfield 1868	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10240: aload 4
    //   10242: aload 46
    //   10244: putfield 1869	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:c	Ljava/lang/String;
    //   10247: aload 4
    //   10249: lload 20
    //   10251: putfield 1871	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo:jdField_a_of_type_Long	J
    //   10254: aload 44
    //   10256: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10259: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10262: aload 4
    //   10264: putfield 1874	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$AccountProfileInfo;
    //   10267: aload 44
    //   10269: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10272: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10275: iload 12
    //   10277: putfield 1875	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_Int	I
    //   10280: aload 44
    //   10282: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10285: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10288: aload 44
    //   10290: getfield 1727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   10293: putfield 1876	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10296: aload 40
    //   10298: astore_2
    //   10299: aload 44
    //   10301: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10304: ldc 232
    //   10306: putfield 1877	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10309: aload 44
    //   10311: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10314: ldc 232
    //   10316: putfield 1878	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:c	Ljava/lang/String;
    //   10319: aload 44
    //   10321: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10324: ldc 232
    //   10326: putfield 1879	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10329: new 318	android/content/Intent
    //   10332: dup
    //   10333: aload_0
    //   10334: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   10337: ldc_w 1881
    //   10340: invokespecial 710	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   10343: astore 4
    //   10345: aload 4
    //   10347: ldc_w 1883
    //   10350: aload 44
    //   10352: invokevirtual 1886	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   10355: pop
    //   10356: aload_3
    //   10357: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10360: ifne +13 -> 10373
    //   10363: aload 4
    //   10365: ldc_w 1888
    //   10368: aload_3
    //   10369: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10372: pop
    //   10373: aload 4
    //   10375: ldc_w 1890
    //   10378: iload 9
    //   10380: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10383: pop
    //   10384: aload 4
    //   10386: ldc_w 1892
    //   10389: iload 6
    //   10391: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10394: pop
    //   10395: aload 4
    //   10397: ldc_w 1894
    //   10400: aload 42
    //   10402: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10405: pop
    //   10406: iconst_3
    //   10407: istore 6
    //   10409: iload 9
    //   10411: iconst_5
    //   10412: if_icmpne +3715 -> 14127
    //   10415: iconst_4
    //   10416: istore 6
    //   10418: aload 4
    //   10420: ldc_w 1896
    //   10423: iload 6
    //   10425: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10428: pop
    //   10429: aload 4
    //   10431: ldc_w 1898
    //   10434: aload_1
    //   10435: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10438: pop
    //   10439: aload 4
    //   10441: ldc_w 785
    //   10444: iload 11
    //   10446: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10449: pop
    //   10450: aload 4
    //   10452: ldc_w 1900
    //   10455: aload_2
    //   10456: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10459: pop
    //   10460: aload 4
    //   10462: ldc_w 1902
    //   10465: lload 20
    //   10467: invokevirtual 1905	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   10470: pop
    //   10471: aload 4
    //   10473: ldc_w 1907
    //   10476: iload 7
    //   10478: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10481: pop
    //   10482: aload 4
    //   10484: ldc_w 1909
    //   10487: aload 41
    //   10489: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10492: pop
    //   10493: iload 9
    //   10495: bipush 23
    //   10497: if_icmpne +145 -> 10642
    //   10500: aload 41
    //   10502: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10505: ifne +14 -> 10519
    //   10508: aload 44
    //   10510: getfield 1730	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   10513: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10516: ifeq +126 -> 10642
    //   10519: ldc 45
    //   10521: iconst_1
    //   10522: ldc_w 1911
    //   10525: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10528: iconst_0
    //   10529: ireturn
    //   10530: aload 44
    //   10532: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10535: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10538: new 249	java/util/ArrayList
    //   10541: dup
    //   10542: invokespecial 250	java/util/ArrayList:<init>	()V
    //   10545: putfield 1913	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   10548: new 1915	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo
    //   10551: dup
    //   10552: invokespecial 1916	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:<init>	()V
    //   10555: astore 47
    //   10557: aload 43
    //   10559: ldc_w 1918
    //   10562: invokevirtual 1832	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10565: astore 43
    //   10567: aload 43
    //   10569: ifnull +3549 -> 14118
    //   10572: aload 47
    //   10574: aload 43
    //   10576: ldc_w 1920
    //   10579: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10582: putfield 1922	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:d	Ljava/lang/String;
    //   10585: aload 47
    //   10587: aload 43
    //   10589: ldc_w 1924
    //   10592: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10595: i2l
    //   10596: putfield 1925	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:jdField_a_of_type_Long	J
    //   10599: aload 47
    //   10601: aload 4
    //   10603: putfield 1927	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCVideoInfo:e	Ljava/lang/String;
    //   10606: aload 44
    //   10608: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10611: getfield 1843	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo;
    //   10614: getfield 1913	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   10617: aload 47
    //   10619: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10622: pop
    //   10623: goto +3495 -> 14118
    //   10626: iload 12
    //   10628: iconst_1
    //   10629: if_icmpne +3495 -> 14124
    //   10632: aload 44
    //   10634: ldc 232
    //   10636: putfield 1733	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   10639: goto +3485 -> 14124
    //   10642: iload 10
    //   10644: iconst_1
    //   10645: if_icmpne +165 -> 10810
    //   10648: aload 44
    //   10650: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10653: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   10656: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10659: ifnull +3199 -> 13858
    //   10662: aload 44
    //   10664: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10667: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   10670: getfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10673: invokeinterface 1928 1 0
    //   10678: ifle +3180 -> 13858
    //   10681: new 498	java/lang/StringBuilder
    //   10684: dup
    //   10685: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   10688: aload 5
    //   10690: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10693: ldc_w 1930
    //   10696: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10699: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10702: astore_1
    //   10703: aload_1
    //   10704: astore_2
    //   10705: aload_1
    //   10706: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10709: ifeq +7 -> 10716
    //   10712: ldc_w 1932
    //   10715: astore_2
    //   10716: new 498	java/lang/StringBuilder
    //   10719: dup
    //   10720: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   10723: ldc_w 1934
    //   10726: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10729: aload_2
    //   10730: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10733: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10736: astore_1
    //   10737: aload_0
    //   10738: getfield 1949	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:app	Lcom/tencent/common/app/AppInterface;
    //   10741: checkcast 1951	com/tencent/mobileqq/app/BrowserAppInterface
    //   10744: invokevirtual 1954	com/tencent/mobileqq/app/BrowserAppInterface:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicManager;
    //   10747: astore_2
    //   10748: invokestatic 1939	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngineEventDispatcher:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngineEventDispatcher;
    //   10751: new 1941	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver
    //   10754: dup
    //   10755: aload_0
    //   10756: aload 42
    //   10758: iload 11
    //   10760: invokespecial 1944	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$BiuObserver:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;I)V
    //   10763: invokevirtual 1947	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngineEventDispatcher:a	(Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;)V
    //   10766: aload_2
    //   10767: invokevirtual 1959	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine;
    //   10770: aload_0
    //   10771: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10774: invokevirtual 1626	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   10777: invokevirtual 1962	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   10780: lload 18
    //   10782: aload 44
    //   10784: getfield 1759	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10787: getfield 1765	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   10790: lconst_0
    //   10791: aload_1
    //   10792: lload 22
    //   10794: ldc2_w 794
    //   10797: iload 6
    //   10799: aload_3
    //   10800: iload 11
    //   10802: aload 44
    //   10804: invokevirtual 1967	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	(JJLcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;JLjava/lang/String;JJILjava/lang/String;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   10807: goto -6316 -> 4491
    //   10810: aload_0
    //   10811: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   10814: aload 4
    //   10816: bipush 113
    //   10818: invokevirtual 775	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   10821: aload_0
    //   10822: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   10825: iconst_0
    //   10826: iconst_0
    //   10827: invokevirtual 1980	android/app/Activity:overridePendingTransition	(II)V
    //   10830: goto -6339 -> 4491
    //   10833: ldc_w 1986
    //   10836: aload 4
    //   10838: invokevirtual 1139	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   10841: ifeq +48 -> 10889
    //   10844: aload 5
    //   10846: ifnull -6355 -> 4491
    //   10849: aload 5
    //   10851: arraylength
    //   10852: ifle -6361 -> 4491
    //   10855: aload_0
    //   10856: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   10859: instanceof 1984
    //   10862: ifeq -6371 -> 4491
    //   10865: aload_0
    //   10866: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   10869: checkcast 874	com/tencent/mobileqq/app/BaseActivity
    //   10872: new 1988	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$6
    //   10875: dup
    //   10876: aload_0
    //   10877: aload 5
    //   10879: invokespecial 1991	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$6:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;[Ljava/lang/String;)V
    //   10882: invokestatic 1996	com/tencent/biz/pubaccount/readinjoy/view/ReadInjoyUserProtocolWidget:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/Runnable;)Z
    //   10885: pop
    //   10886: goto -6395 -> 4491
    //   10889: ldc_w 1998
    //   10892: aload 4
    //   10894: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10897: ifeq +94 -> 10991
    //   10900: new 355	org/json/JSONObject
    //   10903: dup
    //   10904: aload 5
    //   10906: iconst_0
    //   10907: aaload
    //   10908: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10911: astore_1
    //   10912: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10915: ifeq -6424 -> 4491
    //   10918: ldc_w 2000
    //   10921: iconst_2
    //   10922: new 498	java/lang/StringBuilder
    //   10925: dup
    //   10926: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   10929: ldc_w 2002
    //   10932: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10935: aload_1
    //   10936: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10939: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10942: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10945: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10948: goto -6457 -> 4491
    //   10951: astore_1
    //   10952: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10955: ifeq -6464 -> 4491
    //   10958: ldc_w 2000
    //   10961: iconst_2
    //   10962: new 498	java/lang/StringBuilder
    //   10965: dup
    //   10966: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   10969: ldc_w 2004
    //   10972: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10975: aload_1
    //   10976: invokevirtual 1080	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   10979: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10982: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10985: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10988: goto -6497 -> 4491
    //   10991: ldc_w 2006
    //   10994: aload 4
    //   10996: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10999: ifeq +27 -> 11026
    //   11002: aload_0
    //   11003: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11006: checkcast 874	com/tencent/mobileqq/app/BaseActivity
    //   11009: new 2008	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$7
    //   11012: dup
    //   11013: aload_0
    //   11014: aload 5
    //   11016: invokespecial 2009	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$7:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;[Ljava/lang/String;)V
    //   11019: invokestatic 1996	com/tencent/biz/pubaccount/readinjoy/view/ReadInjoyUserProtocolWidget:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/Runnable;)Z
    //   11022: pop
    //   11023: goto -6532 -> 4491
    //   11026: ldc_w 2011
    //   11029: aload 4
    //   11031: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11034: ifeq +62 -> 11096
    //   11037: new 355	org/json/JSONObject
    //   11040: dup
    //   11041: aload 5
    //   11043: iconst_0
    //   11044: aaload
    //   11045: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11048: ldc_w 2013
    //   11051: invokevirtual 2015	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11054: astore_1
    //   11055: aload_1
    //   11056: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11059: ifeq +29 -> 11088
    //   11062: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11065: ifeq -6574 -> 4491
    //   11068: ldc 45
    //   11070: iconst_2
    //   11071: ldc_w 2017
    //   11074: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11077: goto -6586 -> 4491
    //   11080: astore_1
    //   11081: aload_1
    //   11082: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   11085: goto -6594 -> 4491
    //   11088: aload_0
    //   11089: aload_1
    //   11090: invokespecial 2019	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:sharePictureToWeChat	(Ljava/lang/String;)V
    //   11093: goto -6602 -> 4491
    //   11096: ldc_w 2021
    //   11099: aload 4
    //   11101: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11104: ifeq +99 -> 11203
    //   11107: new 355	org/json/JSONObject
    //   11110: dup
    //   11111: aload 5
    //   11113: iconst_0
    //   11114: aaload
    //   11115: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11118: astore_1
    //   11119: aload_1
    //   11120: ldc_w 2023
    //   11123: invokevirtual 2026	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11126: istore 6
    //   11128: aload_1
    //   11129: ldc_w 2028
    //   11132: invokevirtual 2026	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11135: istore 7
    //   11137: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11140: ifeq +41 -> 11181
    //   11143: ldc 45
    //   11145: iconst_2
    //   11146: new 498	java/lang/StringBuilder
    //   11149: dup
    //   11150: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   11153: ldc_w 2030
    //   11156: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11159: iload 6
    //   11161: invokevirtual 821	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11164: ldc_w 2032
    //   11167: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11170: iload 7
    //   11172: invokevirtual 821	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11175: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11178: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11181: aload_0
    //   11182: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11185: iload 6
    //   11187: iload 7
    //   11189: invokevirtual 2033	com/tencent/biz/troop/TroopMemberApiClient:a	(II)V
    //   11192: goto -6701 -> 4491
    //   11195: astore_1
    //   11196: aload_1
    //   11197: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   11200: goto -6709 -> 4491
    //   11203: ldc_w 2035
    //   11206: aload 4
    //   11208: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11211: ifeq +525 -> 11736
    //   11214: new 355	org/json/JSONObject
    //   11217: dup
    //   11218: aload 5
    //   11220: iconst_0
    //   11221: aaload
    //   11222: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11225: astore 4
    //   11227: aload 4
    //   11229: ldc_w 2037
    //   11232: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11235: ifeq +2617 -> 13852
    //   11238: aload 4
    //   11240: ldc_w 2037
    //   11243: invokevirtual 808	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11246: istore 13
    //   11248: aload 4
    //   11250: ldc_w 814
    //   11253: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11256: ifeq +2590 -> 13846
    //   11259: aload 4
    //   11261: ldc_w 814
    //   11264: invokevirtual 808	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11267: istore 14
    //   11269: aload 4
    //   11271: ldc_w 2039
    //   11274: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11277: ifeq +2563 -> 13840
    //   11280: aload 4
    //   11282: ldc_w 2039
    //   11285: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11288: astore_1
    //   11289: ldc 45
    //   11291: iconst_2
    //   11292: new 498	java/lang/StringBuilder
    //   11295: dup
    //   11296: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   11299: ldc_w 2041
    //   11302: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11305: aload_1
    //   11306: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11309: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11312: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11315: new 368	java/lang/String
    //   11318: dup
    //   11319: aload_1
    //   11320: iconst_0
    //   11321: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   11324: invokespecial 652	java/lang/String:<init>	([B)V
    //   11327: astore_2
    //   11328: aload_2
    //   11329: astore_1
    //   11330: ldc 45
    //   11332: iconst_2
    //   11333: new 498	java/lang/StringBuilder
    //   11336: dup
    //   11337: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   11340: ldc_w 2043
    //   11343: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11346: aload_1
    //   11347: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11350: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11353: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11356: aload_1
    //   11357: astore_2
    //   11358: aload 4
    //   11360: ldc_w 2045
    //   11363: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11366: ifeq +2468 -> 13834
    //   11369: aload 4
    //   11371: ldc_w 2045
    //   11374: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11377: astore_1
    //   11378: new 368	java/lang/String
    //   11381: dup
    //   11382: aload_1
    //   11383: iconst_0
    //   11384: invokestatic 649	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   11387: invokespecial 652	java/lang/String:<init>	([B)V
    //   11390: astore_3
    //   11391: aload_3
    //   11392: astore_1
    //   11393: aload 4
    //   11395: ldc_w 2047
    //   11398: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11401: ifeq +2427 -> 13828
    //   11404: aload 4
    //   11406: ldc_w 2047
    //   11409: iconst_m1
    //   11410: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11413: istore 6
    //   11415: aload 4
    //   11417: ldc_w 2049
    //   11420: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11423: ifeq +2399 -> 13822
    //   11426: aload 4
    //   11428: ldc_w 2049
    //   11431: iconst_0
    //   11432: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11435: istore 7
    //   11437: iconst_0
    //   11438: istore 8
    //   11440: aload 4
    //   11442: ldc_w 1331
    //   11445: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11448: ifeq +14 -> 11462
    //   11451: aload 4
    //   11453: ldc_w 1331
    //   11456: iconst_0
    //   11457: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11460: istore 8
    //   11462: aload 4
    //   11464: ldc_w 525
    //   11467: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11470: astore_3
    //   11471: aload 4
    //   11473: ldc_w 2051
    //   11476: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11479: astore 5
    //   11481: aload 4
    //   11483: ldc_w 2053
    //   11486: iconst_0
    //   11487: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11490: istore 9
    //   11492: new 318	android/content/Intent
    //   11495: dup
    //   11496: invokespecial 546	android/content/Intent:<init>	()V
    //   11499: astore 40
    //   11501: aload 4
    //   11503: ldc_w 2055
    //   11506: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11509: ifeq +20 -> 11529
    //   11512: aload 40
    //   11514: ldc_w 2057
    //   11517: aload 4
    //   11519: ldc_w 2055
    //   11522: invokevirtual 808	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11525: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11528: pop
    //   11529: ldc 45
    //   11531: iconst_2
    //   11532: new 498	java/lang/StringBuilder
    //   11535: dup
    //   11536: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   11539: ldc_w 2059
    //   11542: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11545: aload 4
    //   11547: ldc_w 2055
    //   11550: iconst_0
    //   11551: invokevirtual 639	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   11554: invokevirtual 1469	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11557: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11560: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11563: aload 40
    //   11565: ldc_w 2061
    //   11568: iconst_0
    //   11569: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11572: pop
    //   11573: aload 40
    //   11575: ldc_w 2063
    //   11578: iload 13
    //   11580: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11583: pop
    //   11584: aload 40
    //   11586: ldc_w 2065
    //   11589: aload_2
    //   11590: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11593: pop
    //   11594: aload 40
    //   11596: ldc_w 2067
    //   11599: aload_1
    //   11600: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11603: pop
    //   11604: aload 40
    //   11606: ldc_w 2069
    //   11609: iload 6
    //   11611: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11614: pop
    //   11615: aload 40
    //   11617: ldc_w 2071
    //   11620: iload 7
    //   11622: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11625: pop
    //   11626: aload 40
    //   11628: ldc_w 2073
    //   11631: iload 8
    //   11633: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11636: pop
    //   11637: aload 40
    //   11639: ldc_w 316
    //   11642: aload_3
    //   11643: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11646: pop
    //   11647: aload 40
    //   11649: ldc_w 2075
    //   11652: iload 9
    //   11654: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11657: pop
    //   11658: aload 40
    //   11660: ldc_w 2077
    //   11663: iload 14
    //   11665: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11668: pop
    //   11669: aload 40
    //   11671: ldc_w 2079
    //   11674: iconst_1
    //   11675: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11678: pop
    //   11679: aload 5
    //   11681: ifnull +17 -> 11698
    //   11684: aload 40
    //   11686: ldc_w 2081
    //   11689: aload 5
    //   11691: invokevirtual 2082	org/json/JSONArray:toString	()Ljava/lang/String;
    //   11694: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11697: pop
    //   11698: aload_0
    //   11699: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11702: aload 40
    //   11704: bipush 117
    //   11706: invokestatic 2087	com/tencent/biz/pubaccount/readinjoy/comment/base/ReadInJoyCommentEntrance:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   11709: goto -7218 -> 4491
    //   11712: astore_1
    //   11713: aload_1
    //   11714: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   11717: goto -7226 -> 4491
    //   11720: astore_2
    //   11721: aload_2
    //   11722: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   11725: goto -395 -> 11330
    //   11728: astore_3
    //   11729: aload_3
    //   11730: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   11733: goto -340 -> 11393
    //   11736: ldc_w 2088
    //   11739: aload 4
    //   11741: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11744: ifeq +14 -> 11758
    //   11747: aload_0
    //   11748: aload 5
    //   11750: iconst_0
    //   11751: aaload
    //   11752: invokespecial 2090	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showPicture	(Ljava/lang/String;)V
    //   11755: goto -7264 -> 4491
    //   11758: ldc_w 2092
    //   11761: aload 4
    //   11763: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11766: ifeq +117 -> 11883
    //   11769: aconst_null
    //   11770: astore_1
    //   11771: new 355	org/json/JSONObject
    //   11774: dup
    //   11775: aload 5
    //   11777: iconst_0
    //   11778: aaload
    //   11779: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11782: ldc_w 525
    //   11785: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11788: astore_2
    //   11789: aload_2
    //   11790: astore_1
    //   11791: new 318	android/content/Intent
    //   11794: dup
    //   11795: invokespecial 546	android/content/Intent:<init>	()V
    //   11798: astore_3
    //   11799: aload_2
    //   11800: astore_1
    //   11801: aload_3
    //   11802: ldc_w 2094
    //   11805: aload 5
    //   11807: iconst_0
    //   11808: aaload
    //   11809: invokevirtual 557	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11812: pop
    //   11813: aload_2
    //   11814: astore_1
    //   11815: aload_0
    //   11816: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   11819: aload_3
    //   11820: ldc_w 2096
    //   11823: invokestatic 2101	com/tencent/mobileqq/activity/PublicTransFragmentActivity:b	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   11826: aload_2
    //   11827: astore_1
    //   11828: aload_0
    //   11829: aload_2
    //   11830: iconst_1
    //   11831: anewarray 368	java/lang/String
    //   11834: dup
    //   11835: iconst_0
    //   11836: new 355	org/json/JSONObject
    //   11839: dup
    //   11840: invokespecial 356	org/json/JSONObject:<init>	()V
    //   11843: ldc_w 358
    //   11846: iconst_0
    //   11847: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11850: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11853: aastore
    //   11854: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11857: goto -7366 -> 4491
    //   11860: astore_2
    //   11861: aload_2
    //   11862: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   11865: aload_0
    //   11866: aload_1
    //   11867: iconst_1
    //   11868: anewarray 368	java/lang/String
    //   11871: dup
    //   11872: iconst_0
    //   11873: ldc_w 2103
    //   11876: aastore
    //   11877: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11880: goto -7389 -> 4491
    //   11883: ldc_w 2105
    //   11886: aload 4
    //   11888: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11891: ifeq +161 -> 12052
    //   11894: aconst_null
    //   11895: astore_2
    //   11896: aload_2
    //   11897: astore_1
    //   11898: new 355	org/json/JSONObject
    //   11901: dup
    //   11902: aload 5
    //   11904: iconst_0
    //   11905: aaload
    //   11906: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11909: astore_3
    //   11910: aload_2
    //   11911: astore_1
    //   11912: aload_3
    //   11913: ldc_w 525
    //   11916: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11919: astore_2
    //   11920: aload_2
    //   11921: astore_1
    //   11922: aload_3
    //   11923: ldc_w 2107
    //   11926: invokevirtual 627	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11929: astore_3
    //   11930: aload_2
    //   11931: astore_1
    //   11932: new 249	java/util/ArrayList
    //   11935: dup
    //   11936: invokespecial 250	java/util/ArrayList:<init>	()V
    //   11939: astore 4
    //   11941: iconst_0
    //   11942: istore 6
    //   11944: aload_2
    //   11945: astore_1
    //   11946: iload 6
    //   11948: aload_3
    //   11949: invokevirtual 539	org/json/JSONArray:length	()I
    //   11952: if_icmpge +32 -> 11984
    //   11955: aload_2
    //   11956: astore_1
    //   11957: aload 4
    //   11959: aload_3
    //   11960: iload 6
    //   11962: invokevirtual 1780	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   11965: ldc_w 1039
    //   11968: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11971: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   11974: pop
    //   11975: iload 6
    //   11977: iconst_1
    //   11978: iadd
    //   11979: istore 6
    //   11981: goto -37 -> 11944
    //   11984: aload_2
    //   11985: astore_1
    //   11986: aload_0
    //   11987: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11990: aload 4
    //   11992: invokevirtual 2109	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/util/ArrayList;)V
    //   11995: aload_2
    //   11996: astore_1
    //   11997: aload_0
    //   11998: aload_2
    //   11999: iconst_1
    //   12000: anewarray 368	java/lang/String
    //   12003: dup
    //   12004: iconst_0
    //   12005: new 355	org/json/JSONObject
    //   12008: dup
    //   12009: invokespecial 356	org/json/JSONObject:<init>	()V
    //   12012: ldc_w 358
    //   12015: iconst_0
    //   12016: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12019: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12022: aastore
    //   12023: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12026: goto -7535 -> 4491
    //   12029: astore_2
    //   12030: aload_2
    //   12031: invokevirtual 570	java/lang/Exception:printStackTrace	()V
    //   12034: aload_0
    //   12035: aload_1
    //   12036: iconst_1
    //   12037: anewarray 368	java/lang/String
    //   12040: dup
    //   12041: iconst_0
    //   12042: ldc_w 2103
    //   12045: aastore
    //   12046: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12049: goto -7558 -> 4491
    //   12052: ldc_w 2111
    //   12055: aload 4
    //   12057: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12060: ifeq +258 -> 12318
    //   12063: new 355	org/json/JSONObject
    //   12066: dup
    //   12067: aload 5
    //   12069: iconst_0
    //   12070: aaload
    //   12071: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12074: astore_3
    //   12075: aload_3
    //   12076: ldc_w 525
    //   12079: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12082: astore_2
    //   12083: aload_3
    //   12084: ldc_w 2113
    //   12087: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12090: ifeq +13 -> 12103
    //   12093: aload_3
    //   12094: ldc_w 2113
    //   12097: ldc 232
    //   12099: invokevirtual 516	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12102: pop
    //   12103: ldc 232
    //   12105: astore_1
    //   12106: aload_3
    //   12107: ldc_w 2115
    //   12110: invokevirtual 1417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12113: ifeq +13 -> 12126
    //   12116: aload_3
    //   12117: ldc_w 2115
    //   12120: ldc 232
    //   12122: invokevirtual 516	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12125: astore_1
    //   12126: ldc_w 2117
    //   12129: aload_1
    //   12130: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12133: ifeq +93 -> 12226
    //   12136: aload_0
    //   12137: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient;
    //   12140: ldc_w 2119
    //   12143: aconst_null
    //   12144: invokevirtual 2124	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12147: ldc_w 2126
    //   12150: ldc 232
    //   12152: invokevirtual 2128	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12155: astore_1
    //   12156: ldc 232
    //   12158: aload_1
    //   12159: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12162: istore 13
    //   12164: iload 13
    //   12166: ifne -7675 -> 4491
    //   12169: new 355	org/json/JSONObject
    //   12172: dup
    //   12173: aload_1
    //   12174: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12177: astore_1
    //   12178: aload_0
    //   12179: aload_2
    //   12180: iconst_1
    //   12181: anewarray 368	java/lang/String
    //   12184: dup
    //   12185: iconst_0
    //   12186: new 355	org/json/JSONObject
    //   12189: dup
    //   12190: invokespecial 356	org/json/JSONObject:<init>	()V
    //   12193: ldc_w 2130
    //   12196: aload_1
    //   12197: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12200: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12203: aastore
    //   12204: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12207: goto -7716 -> 4491
    //   12210: astore_1
    //   12211: aload_1
    //   12212: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   12215: goto -7724 -> 4491
    //   12218: astore_1
    //   12219: aload_1
    //   12220: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   12223: goto -7732 -> 4491
    //   12226: ldc_w 2132
    //   12229: aload_1
    //   12230: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12233: ifeq -7742 -> 4491
    //   12236: aload_0
    //   12237: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient;
    //   12240: ldc_w 2134
    //   12243: aconst_null
    //   12244: invokevirtual 2124	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12247: ldc_w 2136
    //   12250: ldc 232
    //   12252: invokevirtual 2128	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12255: astore_1
    //   12256: ldc 232
    //   12258: aload_1
    //   12259: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12262: istore 13
    //   12264: iload 13
    //   12266: ifne -7775 -> 4491
    //   12269: new 355	org/json/JSONObject
    //   12272: dup
    //   12273: aload_1
    //   12274: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12277: astore_1
    //   12278: aload_0
    //   12279: aload_2
    //   12280: iconst_1
    //   12281: anewarray 368	java/lang/String
    //   12284: dup
    //   12285: iconst_0
    //   12286: new 355	org/json/JSONObject
    //   12289: dup
    //   12290: invokespecial 356	org/json/JSONObject:<init>	()V
    //   12293: ldc_w 2130
    //   12296: aload_1
    //   12297: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12300: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12303: aastore
    //   12304: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12307: goto -7816 -> 4491
    //   12310: astore_1
    //   12311: aload_1
    //   12312: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   12315: goto -7824 -> 4491
    //   12318: ldc_w 2138
    //   12321: aload 4
    //   12323: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12326: ifeq +189 -> 12515
    //   12329: new 355	org/json/JSONObject
    //   12332: dup
    //   12333: aload 5
    //   12335: iconst_0
    //   12336: aaload
    //   12337: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12340: astore_1
    //   12341: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12344: ifeq +29 -> 12373
    //   12347: ldc 45
    //   12349: iconst_2
    //   12350: new 498	java/lang/StringBuilder
    //   12353: dup
    //   12354: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   12357: ldc_w 2140
    //   12360: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12363: aload_1
    //   12364: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12367: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12370: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12373: aload_1
    //   12374: ldc_w 2142
    //   12377: invokevirtual 2145	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   12380: lstore 18
    //   12382: aload_1
    //   12383: ldc_w 2028
    //   12386: invokevirtual 2026	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   12389: istore 6
    //   12391: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12394: ifeq +41 -> 12435
    //   12397: ldc 45
    //   12399: iconst_2
    //   12400: new 498	java/lang/StringBuilder
    //   12403: dup
    //   12404: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   12407: ldc_w 2030
    //   12410: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12413: lload 18
    //   12415: invokevirtual 838	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12418: ldc_w 2032
    //   12421: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12424: iload 6
    //   12426: invokevirtual 821	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12429: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12432: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12435: aload_0
    //   12436: getfield 211	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12439: lload 18
    //   12441: iload 6
    //   12443: invokevirtual 2148	com/tencent/biz/troop/TroopMemberApiClient:a	(JI)V
    //   12446: aload_0
    //   12447: getfield 451	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12450: invokevirtual 456	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   12453: iconst_m1
    //   12454: new 318	android/content/Intent
    //   12457: dup
    //   12458: invokespecial 546	android/content/Intent:<init>	()V
    //   12461: ldc_w 2028
    //   12464: iload 6
    //   12466: invokevirtual 552	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12469: invokevirtual 2152	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   12472: goto -7981 -> 4491
    //   12475: astore_1
    //   12476: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12479: ifeq +29 -> 12508
    //   12482: ldc 45
    //   12484: iconst_2
    //   12485: new 498	java/lang/StringBuilder
    //   12488: dup
    //   12489: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   12492: ldc_w 2154
    //   12495: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12498: aload_1
    //   12499: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12502: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12505: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12508: aload_1
    //   12509: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   12512: goto -8021 -> 4491
    //   12515: ldc_w 2155
    //   12518: aload 4
    //   12520: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12523: ifeq +14 -> 12537
    //   12526: aload_0
    //   12527: aload 4
    //   12529: aload 5
    //   12531: invokespecial 2157	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndInviteFriend	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12534: goto -8043 -> 4491
    //   12537: ldc_w 2159
    //   12540: aload 4
    //   12542: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12545: ifeq +182 -> 12727
    //   12548: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12551: ifeq +12 -> 12563
    //   12554: ldc 45
    //   12556: iconst_2
    //   12557: ldc_w 2161
    //   12560: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12563: aload_0
    //   12564: getfield 215	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload;
    //   12567: ifnonnull +14 -> 12581
    //   12570: aload_0
    //   12571: new 2163	com/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload
    //   12574: dup
    //   12575: invokespecial 2164	com/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload:<init>	()V
    //   12578: putfield 215	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload;
    //   12581: aload_0
    //   12582: getfield 215	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload;
    //   12585: astore_1
    //   12586: aload_1
    //   12587: new 2166	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$8
    //   12590: dup
    //   12591: aload_0
    //   12592: invokespecial 2167	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$8:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   12595: invokevirtual 2170	com/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload$CallbackListener;)V
    //   12598: new 355	org/json/JSONObject
    //   12601: dup
    //   12602: aload 5
    //   12604: iconst_0
    //   12605: aaload
    //   12606: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12609: astore_2
    //   12610: aload_2
    //   12611: ldc_w 525
    //   12614: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12617: astore_3
    //   12618: aload_2
    //   12619: ldc_w 2172
    //   12622: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12625: astore 4
    //   12627: aload_2
    //   12628: ldc_w 2174
    //   12631: iconst_m1
    //   12632: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12635: istore 6
    //   12637: aload_2
    //   12638: ldc 22
    //   12640: iconst_0
    //   12641: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12644: istore 7
    //   12646: aload_2
    //   12647: ldc_w 2176
    //   12650: iconst_0
    //   12651: invokevirtual 781	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12654: istore 8
    //   12656: aload_2
    //   12657: ldc_w 2178
    //   12660: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12663: astore 5
    //   12665: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12668: ifeq +32 -> 12700
    //   12671: ldc 45
    //   12673: iconst_2
    //   12674: new 498	java/lang/StringBuilder
    //   12677: dup
    //   12678: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   12681: ldc_w 2180
    //   12684: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12687: aload_2
    //   12688: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12691: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12694: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12697: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12700: aload_1
    //   12701: aload 4
    //   12703: iload 6
    //   12705: iload 7
    //   12707: i2l
    //   12708: iload 8
    //   12710: aload 5
    //   12712: aload_3
    //   12713: invokevirtual 2183	com/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload:a	(Ljava/lang/String;IJILjava/lang/String;Ljava/lang/String;)V
    //   12716: goto -8225 -> 4491
    //   12719: astore_1
    //   12720: aload_1
    //   12721: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   12724: goto -8233 -> 4491
    //   12727: ldc_w 2185
    //   12730: aload 4
    //   12732: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12735: ifeq +34 -> 12769
    //   12738: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12741: ifeq +12 -> 12753
    //   12744: ldc 45
    //   12746: iconst_2
    //   12747: ldc_w 2187
    //   12750: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12753: aload_0
    //   12754: getfield 215	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoWebPreDownload	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload;
    //   12757: astore_1
    //   12758: aload_1
    //   12759: ifnull -8268 -> 4491
    //   12762: aload_1
    //   12763: invokevirtual 2189	com/tencent/biz/pubaccount/readinjoy/video/VideoWebPreDownload:a	()V
    //   12766: goto -8275 -> 4491
    //   12769: ldc_w 2191
    //   12772: aload 4
    //   12774: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12777: ifeq +83 -> 12860
    //   12780: new 287	android/os/Bundle
    //   12783: dup
    //   12784: invokespecial 288	android/os/Bundle:<init>	()V
    //   12787: astore_1
    //   12788: new 355	org/json/JSONObject
    //   12791: dup
    //   12792: aload 5
    //   12794: iconst_0
    //   12795: aaload
    //   12796: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12799: astore_3
    //   12800: aload_3
    //   12801: ldc_w 1039
    //   12804: invokevirtual 2015	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12807: astore_2
    //   12808: aload_3
    //   12809: ldc_w 2193
    //   12812: ldc 232
    //   12814: invokevirtual 516	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12817: astore_3
    //   12818: aload_1
    //   12819: ldc_w 1039
    //   12822: aload_2
    //   12823: invokevirtual 418	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12826: aload_1
    //   12827: ldc_w 2193
    //   12830: aload_3
    //   12831: invokevirtual 418	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12834: aload_0
    //   12835: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient;
    //   12838: ifnull -8347 -> 4491
    //   12841: aload_0
    //   12842: getfield 213	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:mVideoIPCClient	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient;
    //   12845: ldc_w 2195
    //   12848: aload_1
    //   12849: invokevirtual 2124	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsIPCClient:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12852: pop
    //   12853: goto -8362 -> 4491
    //   12856: astore_1
    //   12857: goto -8366 -> 4491
    //   12860: ldc_w 2197
    //   12863: aload 4
    //   12865: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12868: ifeq +96 -> 12964
    //   12871: new 355	org/json/JSONObject
    //   12874: dup
    //   12875: aload 5
    //   12877: iconst_0
    //   12878: aaload
    //   12879: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12882: ldc_w 1696
    //   12885: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12888: astore_1
    //   12889: ldc 45
    //   12891: iconst_2
    //   12892: new 498	java/lang/StringBuilder
    //   12895: dup
    //   12896: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   12899: ldc_w 2199
    //   12902: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12905: aload_1
    //   12906: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12909: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12912: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12915: new 318	android/content/Intent
    //   12918: dup
    //   12919: invokespecial 546	android/content/Intent:<init>	()V
    //   12922: astore_2
    //   12923: aload_2
    //   12924: ldc_w 664
    //   12927: new 1698	java/math/BigInteger
    //   12930: dup
    //   12931: aload_1
    //   12932: invokespecial 1699	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   12935: invokevirtual 1702	java/math/BigInteger:longValue	()J
    //   12938: invokevirtual 1905	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   12941: pop
    //   12942: aload_0
    //   12943: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   12946: aload_2
    //   12947: ldc_w 2201
    //   12950: invokestatic 2203	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   12953: goto -8462 -> 4491
    //   12956: astore_1
    //   12957: aload_1
    //   12958: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   12961: goto -8470 -> 4491
    //   12964: ldc_w 2205
    //   12967: aload 4
    //   12969: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12972: ifeq +214 -> 13186
    //   12975: new 355	org/json/JSONObject
    //   12978: dup
    //   12979: aload 5
    //   12981: iconst_0
    //   12982: aaload
    //   12983: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12986: astore_2
    //   12987: aload_2
    //   12988: ldc_w 2207
    //   12991: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12994: istore 6
    //   12996: aload_2
    //   12997: ldc_w 2209
    //   13000: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13003: astore_3
    //   13004: aload_2
    //   13005: ldc_w 1122
    //   13008: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13011: astore 4
    //   13013: aload_2
    //   13014: ldc_w 525
    //   13017: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13020: astore 5
    //   13022: iload 6
    //   13024: tableswitch	default:+1172 -> 14196, 1:+148->13172, 2:+1179->14203, 3:+155->13179
    //   13053: aload_3
    //   13054: iconst_1
    //   13055: new 498	java/lang/StringBuilder
    //   13058: dup
    //   13059: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   13062: ldc_w 2211
    //   13065: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13068: iload 6
    //   13070: invokevirtual 821	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13073: ldc_w 2213
    //   13076: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13079: aload_3
    //   13080: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13083: ldc_w 2213
    //   13086: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13089: aload 4
    //   13091: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13094: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13097: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13100: ldc_w 1263
    //   13103: invokestatic 1269	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   13106: checkcast 1263	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   13109: aconst_null
    //   13110: ldc 232
    //   13112: aload_1
    //   13113: aload_1
    //   13114: iconst_0
    //   13115: iconst_0
    //   13116: ldc 232
    //   13118: ldc 232
    //   13120: aload_3
    //   13121: aload_2
    //   13122: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13125: iconst_0
    //   13126: invokeinterface 2217 12 0
    //   13131: aload_0
    //   13132: aload 5
    //   13134: iconst_1
    //   13135: anewarray 368	java/lang/String
    //   13138: dup
    //   13139: iconst_0
    //   13140: new 355	org/json/JSONObject
    //   13143: dup
    //   13144: invokespecial 356	org/json/JSONObject:<init>	()V
    //   13147: ldc_w 358
    //   13150: iconst_0
    //   13151: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   13154: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13157: aastore
    //   13158: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13161: goto -8670 -> 4491
    //   13164: astore_1
    //   13165: aload_1
    //   13166: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   13169: goto -8678 -> 4491
    //   13172: ldc_w 2219
    //   13175: astore_1
    //   13176: goto -124 -> 13052
    //   13179: ldc_w 2221
    //   13182: astore_1
    //   13183: goto -131 -> 13052
    //   13186: ldc_w 2222
    //   13189: aload 4
    //   13191: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13194: ifeq +61 -> 13255
    //   13197: new 355	org/json/JSONObject
    //   13200: dup
    //   13201: aload 5
    //   13203: iconst_0
    //   13204: aaload
    //   13205: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13208: ldc_w 525
    //   13211: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13214: astore_1
    //   13215: aload_0
    //   13216: new 355	org/json/JSONObject
    //   13219: dup
    //   13220: aload 5
    //   13222: iconst_0
    //   13223: aaload
    //   13224: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13227: aload_1
    //   13228: new 2224	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$9
    //   13231: dup
    //   13232: aload_0
    //   13233: invokespecial 2225	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$9:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   13236: invokevirtual 2228	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:showReadInJoyNativeCommentView	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule$CallCommentJs;)V
    //   13239: iconst_1
    //   13240: ireturn
    //   13241: astore_1
    //   13242: ldc 45
    //   13244: iconst_1
    //   13245: ldc_w 2230
    //   13248: aload_1
    //   13249: invokestatic 1621	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13252: goto -13 -> 13239
    //   13255: ldc_w 2232
    //   13258: aload 4
    //   13260: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13263: ifeq +192 -> 13455
    //   13266: invokestatic 2235	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13269: ifne +9 -> 13278
    //   13272: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13275: ifeq +24 -> 13299
    //   13278: ldc 45
    //   13280: iconst_1
    //   13281: iconst_2
    //   13282: anewarray 687	java/lang/Object
    //   13285: dup
    //   13286: iconst_0
    //   13287: ldc_w 2237
    //   13290: aastore
    //   13291: dup
    //   13292: iconst_1
    //   13293: aload 5
    //   13295: aastore
    //   13296: invokestatic 697	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   13299: aload 5
    //   13301: ifnull +909 -> 14210
    //   13304: aload 5
    //   13306: arraylength
    //   13307: ifle +903 -> 14210
    //   13310: new 355	org/json/JSONObject
    //   13313: dup
    //   13314: aload 5
    //   13316: iconst_0
    //   13317: aaload
    //   13318: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13321: ldc_w 2239
    //   13324: invokevirtual 522	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13327: istore 6
    //   13329: iload 6
    //   13331: ifne +56 -> 13387
    //   13334: invokestatic 2235	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13337: ifne +9 -> 13346
    //   13340: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13343: ifeq +12 -> 13355
    //   13346: ldc 45
    //   13348: iconst_1
    //   13349: ldc_w 2241
    //   13352: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13355: aload_0
    //   13356: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   13359: iconst_m1
    //   13360: new 318	android/content/Intent
    //   13363: dup
    //   13364: invokespecial 546	android/content/Intent:<init>	()V
    //   13367: ldc_w 2243
    //   13370: iconst_1
    //   13371: invokevirtual 938	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   13374: invokevirtual 2152	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   13377: aload_0
    //   13378: getfield 314	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:activity	Landroid/app/Activity;
    //   13381: invokevirtual 2246	android/app/Activity:finish	()V
    //   13384: goto +826 -> 14210
    //   13387: invokestatic 2235	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13390: ifne +9 -> 13399
    //   13393: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13396: ifeq +814 -> 14210
    //   13399: ldc 45
    //   13401: iconst_1
    //   13402: new 498	java/lang/StringBuilder
    //   13405: dup
    //   13406: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   13409: ldc_w 2248
    //   13412: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13415: iload 6
    //   13417: invokevirtual 821	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13420: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13423: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13426: goto +784 -> 14210
    //   13429: astore_1
    //   13430: invokestatic 2235	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13433: ifne +9 -> 13442
    //   13436: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13439: ifeq +771 -> 14210
    //   13442: ldc 45
    //   13444: iconst_1
    //   13445: ldc_w 2250
    //   13448: aload_1
    //   13449: invokestatic 1621	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13452: goto +758 -> 14210
    //   13455: ldc_w 2252
    //   13458: aload 4
    //   13460: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13463: ifeq +58 -> 13521
    //   13466: ldc 45
    //   13468: iconst_1
    //   13469: ldc_w 2254
    //   13472: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13475: new 355	org/json/JSONObject
    //   13478: dup
    //   13479: aload 5
    //   13481: iconst_0
    //   13482: aaload
    //   13483: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13486: ldc_w 525
    //   13489: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13492: astore_1
    //   13493: new 2256	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$10
    //   13496: dup
    //   13497: aload_0
    //   13498: invokespecial 2257	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$10:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   13501: aload_1
    //   13502: invokestatic 2259	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:getAppType	(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule$CallJs;Ljava/lang/String;)V
    //   13505: iconst_1
    //   13506: ireturn
    //   13507: astore_1
    //   13508: ldc 45
    //   13510: iconst_1
    //   13511: aload_1
    //   13512: invokevirtual 1080	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13515: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13518: goto -13 -> 13505
    //   13521: ldc_w 2261
    //   13524: aload 4
    //   13526: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13529: ifeq +94 -> 13623
    //   13532: ldc 45
    //   13534: iconst_1
    //   13535: ldc_w 2263
    //   13538: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13541: new 355	org/json/JSONObject
    //   13544: dup
    //   13545: aload 5
    //   13547: iconst_0
    //   13548: aaload
    //   13549: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13552: astore_1
    //   13553: aload_1
    //   13554: ldc_w 299
    //   13557: invokevirtual 662	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   13560: lstore 18
    //   13562: aload_1
    //   13563: ldc_w 525
    //   13566: invokevirtual 633	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13569: astore_1
    //   13570: lload 18
    //   13572: new 2265	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$11
    //   13575: dup
    //   13576: aload_0
    //   13577: invokespecial 2266	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$11:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;)V
    //   13580: aload_1
    //   13581: invokestatic 2268	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:getUserInfoIpc	(JLcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule$CallJs;Ljava/lang/String;)V
    //   13584: iconst_1
    //   13585: ireturn
    //   13586: astore_1
    //   13587: ldc 45
    //   13589: iconst_1
    //   13590: aload_1
    //   13591: invokevirtual 1080	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13594: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13597: aload_0
    //   13598: aload_0
    //   13599: getfield 2270	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callback	Ljava/lang/String;
    //   13602: iconst_1
    //   13603: anewarray 368	java/lang/String
    //   13606: dup
    //   13607: iconst_0
    //   13608: aload_0
    //   13609: aload_1
    //   13610: invokevirtual 1080	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13613: invokevirtual 2272	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:getUserInfoFailStr	(Ljava/lang/String;)Ljava/lang/String;
    //   13616: aastore
    //   13617: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13620: goto -36 -> 13584
    //   13623: ldc_w 2274
    //   13626: aload 4
    //   13628: invokevirtual 480	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13631: ifeq -9140 -> 4491
    //   13634: ldc 45
    //   13636: iconst_1
    //   13637: new 498	java/lang/StringBuilder
    //   13640: dup
    //   13641: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   13644: ldc_w 2276
    //   13647: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13650: aload 5
    //   13652: iconst_0
    //   13653: aaload
    //   13654: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13657: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13660: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13663: aload 5
    //   13665: iconst_0
    //   13666: aaload
    //   13667: invokestatic 2278	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:updateUserInfoIPC	(Ljava/lang/String;)V
    //   13670: iconst_1
    //   13671: ireturn
    //   13672: astore 4
    //   13674: aload_1
    //   13675: astore 42
    //   13677: ldc 232
    //   13679: astore_1
    //   13680: aload_3
    //   13681: astore_2
    //   13682: lload 38
    //   13684: lstore 34
    //   13686: lload 36
    //   13688: lstore 32
    //   13690: aload 42
    //   13692: astore_3
    //   13693: goto -4041 -> 9652
    //   13696: astore 4
    //   13698: ldc 232
    //   13700: astore 42
    //   13702: aload_1
    //   13703: astore_3
    //   13704: aload 42
    //   13706: astore_1
    //   13707: lload 38
    //   13709: lstore 34
    //   13711: lload 36
    //   13713: lstore 32
    //   13715: goto -4063 -> 9652
    //   13718: astore 4
    //   13720: aload_1
    //   13721: astore 42
    //   13723: aload_3
    //   13724: astore_1
    //   13725: lload 30
    //   13727: lstore 24
    //   13729: lload 28
    //   13731: lstore 22
    //   13733: lload 26
    //   13735: lstore 18
    //   13737: aload 42
    //   13739: astore_3
    //   13740: goto -4088 -> 9652
    //   13743: astore 4
    //   13745: aload_1
    //   13746: astore 42
    //   13748: ldc 232
    //   13750: astore_1
    //   13751: aload_3
    //   13752: astore_2
    //   13753: lload 38
    //   13755: lstore 34
    //   13757: lload 36
    //   13759: lstore 32
    //   13761: aload 42
    //   13763: astore_3
    //   13764: goto -6697 -> 7067
    //   13767: astore 4
    //   13769: ldc 232
    //   13771: astore 42
    //   13773: aload_1
    //   13774: astore_3
    //   13775: aload 42
    //   13777: astore_1
    //   13778: lload 38
    //   13780: lstore 34
    //   13782: lload 36
    //   13784: lstore 32
    //   13786: goto -6719 -> 7067
    //   13789: astore 4
    //   13791: aload_1
    //   13792: astore 42
    //   13794: aload_3
    //   13795: astore_1
    //   13796: lload 30
    //   13798: lstore 24
    //   13800: lload 28
    //   13802: lstore 22
    //   13804: lload 26
    //   13806: lstore 18
    //   13808: aload 42
    //   13810: astore_3
    //   13811: goto -6744 -> 7067
    //   13814: astore_1
    //   13815: iload 14
    //   13817: istore 13
    //   13819: goto -9572 -> 4247
    //   13822: iconst_0
    //   13823: istore 7
    //   13825: goto -2388 -> 11437
    //   13828: iconst_m1
    //   13829: istore 6
    //   13831: goto -2416 -> 11415
    //   13834: ldc 232
    //   13836: astore_1
    //   13837: goto -2444 -> 11393
    //   13840: ldc 232
    //   13842: astore_2
    //   13843: goto -2485 -> 11358
    //   13846: iconst_1
    //   13847: istore 14
    //   13849: goto -2580 -> 11269
    //   13852: iconst_0
    //   13853: istore 13
    //   13855: goto -2607 -> 11248
    //   13858: aload 5
    //   13860: astore_1
    //   13861: goto -3158 -> 10703
    //   13864: aload 40
    //   13866: astore_2
    //   13867: goto -3568 -> 10299
    //   13870: aload 5
    //   13872: astore_1
    //   13873: goto -5622 -> 8251
    //   13876: aload 40
    //   13878: astore_2
    //   13879: goto -6032 -> 7847
    //   13882: aconst_null
    //   13883: astore_1
    //   13884: goto -9516 -> 4368
    //   13887: iconst_0
    //   13888: istore 13
    //   13890: goto -9643 -> 4247
    //   13893: iconst_0
    //   13894: istore 6
    //   13896: goto -11310 -> 2586
    //   13899: goto -11360 -> 2539
    //   13902: iconst_1
    //   13903: ireturn
    //   13904: iconst_1
    //   13905: ireturn
    //   13906: bipush 9
    //   13908: istore 8
    //   13910: goto -11371 -> 2539
    //   13913: iconst_1
    //   13914: ireturn
    //   13915: iconst_1
    //   13916: ireturn
    //   13917: iconst_1
    //   13918: ireturn
    //   13919: iload 10
    //   13921: iconst_1
    //   13922: if_icmpeq -9694 -> 4228
    //   13925: iload 10
    //   13927: iconst_2
    //   13928: if_icmpne -41 -> 13887
    //   13931: goto -9703 -> 4228
    //   13934: iconst_1
    //   13935: ireturn
    //   13936: ldc_w 2280
    //   13939: astore_1
    //   13940: goto -8827 -> 5113
    //   13943: ldc_w 2280
    //   13946: astore_2
    //   13947: goto -8823 -> 5124
    //   13950: goto -7954 -> 5996
    //   13953: astore 4
    //   13955: aload_3
    //   13956: astore_2
    //   13957: ldc 232
    //   13959: astore_1
    //   13960: lload 38
    //   13962: lstore 34
    //   13964: lload 36
    //   13966: lstore 32
    //   13968: aload 42
    //   13970: astore_3
    //   13971: goto -6904 -> 7067
    //   13974: iconst_1
    //   13975: istore 6
    //   13977: goto -6218 -> 7759
    //   13980: iload 12
    //   13982: iconst_4
    //   13983: if_icmpeq -5905 -> 8078
    //   13986: iload 12
    //   13988: iconst_5
    //   13989: if_icmpne -5815 -> 8174
    //   13992: goto -5914 -> 8078
    //   13995: iconst_2
    //   13996: istore 6
    //   13998: goto -6239 -> 7759
    //   14001: goto -6242 -> 7759
    //   14004: iload 9
    //   14006: bipush 11
    //   14008: if_icmpne +9 -> 14017
    //   14011: iconst_5
    //   14012: istore 6
    //   14014: goto -6048 -> 7966
    //   14017: iload 9
    //   14019: bipush 6
    //   14021: if_icmpne +10 -> 14031
    //   14024: bipush 6
    //   14026: istore 6
    //   14028: goto -6062 -> 7966
    //   14031: iload 9
    //   14033: bipush 12
    //   14035: if_icmpne +10 -> 14045
    //   14038: bipush 7
    //   14040: istore 6
    //   14042: goto -6076 -> 7966
    //   14045: iload 9
    //   14047: bipush 13
    //   14049: if_icmpne +10 -> 14059
    //   14052: bipush 8
    //   14054: istore 6
    //   14056: goto -6090 -> 7966
    //   14059: iload 9
    //   14061: bipush 15
    //   14063: if_icmplt -6097 -> 7966
    //   14066: iload 9
    //   14068: istore 6
    //   14070: goto -6104 -> 7966
    //   14073: goto -5492 -> 8581
    //   14076: astore 4
    //   14078: aload_3
    //   14079: astore_2
    //   14080: ldc 232
    //   14082: astore_1
    //   14083: lload 38
    //   14085: lstore 34
    //   14087: lload 36
    //   14089: lstore 32
    //   14091: aload 42
    //   14093: astore_3
    //   14094: goto -4442 -> 9652
    //   14097: iconst_1
    //   14098: istore 6
    //   14100: goto -3889 -> 10211
    //   14103: iload 12
    //   14105: iconst_4
    //   14106: if_icmpeq -3576 -> 10530
    //   14109: iload 12
    //   14111: iconst_5
    //   14112: if_icmpne -3486 -> 10626
    //   14115: goto -3585 -> 10530
    //   14118: iconst_2
    //   14119: istore 6
    //   14121: goto -3910 -> 10211
    //   14124: goto -3913 -> 10211
    //   14127: iload 9
    //   14129: bipush 11
    //   14131: if_icmpne +9 -> 14140
    //   14134: iconst_5
    //   14135: istore 6
    //   14137: goto -3719 -> 10418
    //   14140: iload 9
    //   14142: bipush 6
    //   14144: if_icmpne +10 -> 14154
    //   14147: bipush 6
    //   14149: istore 6
    //   14151: goto -3733 -> 10418
    //   14154: iload 9
    //   14156: bipush 12
    //   14158: if_icmpne +10 -> 14168
    //   14161: bipush 7
    //   14163: istore 6
    //   14165: goto -3747 -> 10418
    //   14168: iload 9
    //   14170: bipush 13
    //   14172: if_icmpne +10 -> 14182
    //   14175: bipush 8
    //   14177: istore 6
    //   14179: goto -3761 -> 10418
    //   14182: iload 9
    //   14184: bipush 15
    //   14186: if_icmplt -3768 -> 10418
    //   14189: iload 9
    //   14191: istore 6
    //   14193: goto -3775 -> 10418
    //   14196: ldc_w 2282
    //   14199: astore_1
    //   14200: goto -1148 -> 13052
    //   14203: ldc_w 2284
    //   14206: astore_1
    //   14207: goto -1155 -> 13052
    //   14210: iconst_1
    //   14211: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	14212	0	this	PublicAccountH5AbilityPluginImpl
    //   0	14212	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	14212	2	paramString1	String
    //   0	14212	3	paramString2	String
    //   0	14212	4	paramString3	String
    //   0	14212	5	paramVarArgs	String[]
    //   493	13699	6	i	int
    //   2591	11233	7	j	int
    //   2521	11388	8	k	int
    //   2587	11603	9	m	int
    //   3959	9970	10	n	int
    //   6645	4156	11	i1	int
    //   7247	6866	12	i2	int
    //   353	13536	13	bool1	boolean
    //   4097	9751	14	bool2	boolean
    //   4858	51	15	bool3	boolean
    //   4870	49	16	bool4	boolean
    //   4882	47	17	bool5	boolean
    //   6038	7769	18	l1	long
    //   6108	4358	20	l2	long
    //   6041	7762	22	l3	long
    //   6044	7755	24	l4	long
    //   6128	7677	26	l5	long
    //   6124	7677	28	l6	long
    //   6120	7677	30	l7	long
    //   6116	7974	32	l8	long
    //   6112	7974	34	l9	long
    //   6047	8041	36	l10	long
    //   6050	8034	38	l11	long
    //   6054	1029	40	localObject1	Object
    //   7088	19	40	localJSONException1	JSONException
    //   7121	2547	40	localObject2	Object
    //   9673	3	40	localJSONException2	JSONException
    //   9681	4196	40	localObject3	Object
    //   5983	4518	41	str1	String
    //   5964	8128	42	localObject4	Object
    //   5918	4670	43	localObject5	Object
    //   6654	4149	44	localArticleInfo	com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
    //   6593	3643	45	str2	String
    //   6634	3609	46	str3	String
    //   6830	3788	47	localObject6	Object
    //   6839	187	48	localObject7	Object
    //   7126	19	48	localException1	Exception
    //   7333	2278	48	localObject8	Object
    //   9686	3	48	localException2	Exception
    //   9843	218	48	localBiuCommentInfo	com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo
    //   6939	584	49	localObject9	Object
    //   7567	19	49	localException3	Exception
    //   9524	509	49	localObject10	Object
    //   10077	3	49	localException4	Exception
    //   6949	3043	50	str4	String
    //   7452	2549	51	str5	String
    // Exception table:
    //   from	to	target	type
    //   32	101	135	org/json/JSONException
    //   101	105	135	org/json/JSONException
    //   165	197	199	org/json/JSONException
    //   229	298	304	org/json/JSONException
    //   298	302	304	org/json/JSONException
    //   334	414	422	org/json/JSONException
    //   414	420	422	org/json/JSONException
    //   452	488	610	org/json/JSONException
    //   495	515	610	org/json/JSONException
    //   524	575	610	org/json/JSONException
    //   575	580	610	org/json/JSONException
    //   640	676	798	org/json/JSONException
    //   683	703	798	org/json/JSONException
    //   712	763	798	org/json/JSONException
    //   763	768	798	org/json/JSONException
    //   828	897	931	org/json/JSONException
    //   897	901	931	org/json/JSONException
    //   961	1030	1064	org/json/JSONException
    //   1030	1034	1064	org/json/JSONException
    //   1094	1163	1197	org/json/JSONException
    //   1163	1167	1197	org/json/JSONException
    //   1227	1296	1330	org/json/JSONException
    //   1296	1300	1330	org/json/JSONException
    //   1360	1419	1685	org/json/JSONException
    //   1424	1432	1685	org/json/JSONException
    //   1432	1467	1685	org/json/JSONException
    //   1469	1513	1685	org/json/JSONException
    //   1515	1524	1685	org/json/JSONException
    //   1524	1546	1685	org/json/JSONException
    //   1550	1580	1685	org/json/JSONException
    //   1582	1640	1685	org/json/JSONException
    //   1715	1771	1938	org/json/JSONException
    //   1771	1786	1938	org/json/JSONException
    //   1788	1796	1938	org/json/JSONException
    //   1796	1816	1938	org/json/JSONException
    //   1820	1850	1938	org/json/JSONException
    //   1852	1905	1938	org/json/JSONException
    //   2017	2061	2093	org/json/JSONException
    //   1968	2012	2101	org/json/JSONException
    //   2061	2090	2101	org/json/JSONException
    //   2094	2098	2101	org/json/JSONException
    //   2109	2139	2101	org/json/JSONException
    //   2139	2172	2101	org/json/JSONException
    //   2212	2216	2101	org/json/JSONException
    //   2219	2238	2101	org/json/JSONException
    //   2258	2274	2101	org/json/JSONException
    //   2278	2282	2101	org/json/JSONException
    //   2285	2294	2101	org/json/JSONException
    //   2172	2208	2211	org/json/JSONException
    //   2238	2258	2277	org/json/JSONException
    //   2368	2412	2444	org/json/JSONException
    //   2319	2363	2452	org/json/JSONException
    //   2412	2441	2452	org/json/JSONException
    //   2445	2449	2452	org/json/JSONException
    //   2460	2469	2452	org/json/JSONException
    //   2494	2523	2711	org/json/JSONException
    //   2539	2555	2711	org/json/JSONException
    //   2559	2583	2711	org/json/JSONException
    //   2601	2625	2711	org/json/JSONException
    //   2628	2668	2711	org/json/JSONException
    //   2671	2681	2711	org/json/JSONException
    //   2687	2696	2711	org/json/JSONException
    //   2741	2800	2838	org/json/JSONException
    //   2800	2807	2838	org/json/JSONException
    //   2807	2836	2838	org/json/JSONException
    //   2943	2989	2992	org/json/JSONException
    //   2868	2912	3000	org/json/JSONException
    //   2912	2941	3000	org/json/JSONException
    //   2993	2997	3000	org/json/JSONException
    //   3164	3184	3263	org/json/JSONException
    //   3030	3093	3271	org/json/JSONException
    //   3095	3125	3271	org/json/JSONException
    //   3125	3164	3271	org/json/JSONException
    //   3184	3213	3271	org/json/JSONException
    //   3213	3231	3271	org/json/JSONException
    //   3231	3260	3271	org/json/JSONException
    //   3264	3268	3271	org/json/JSONException
    //   3299	3328	3271	org/json/JSONException
    //   3332	3336	3271	org/json/JSONException
    //   3339	3347	3271	org/json/JSONException
    //   3389	3393	3271	org/json/JSONException
    //   3279	3299	3331	org/json/JSONException
    //   3347	3385	3388	org/json/JSONException
    //   3517	3553	3614	org/json/JSONException
    //   3418	3483	3622	org/json/JSONException
    //   3483	3517	3622	org/json/JSONException
    //   3553	3582	3622	org/json/JSONException
    //   3582	3611	3622	org/json/JSONException
    //   3615	3619	3622	org/json/JSONException
    //   3652	3719	3795	org/json/JSONException
    //   3719	3764	3795	org/json/JSONException
    //   3764	3793	3795	org/json/JSONException
    //   3825	3845	3847	org/json/JSONException
    //   3877	3897	3899	org/json/JSONException
    //   3929	3961	4066	org/json/JSONException
    //   3981	4014	4066	org/json/JSONException
    //   4014	4047	4066	org/json/JSONException
    //   4047	4064	4066	org/json/JSONException
    //   4318	4359	4486	org/json/JSONException
    //   4363	4368	4486	org/json/JSONException
    //   4368	4410	4486	org/json/JSONException
    //   4414	4419	4486	org/json/JSONException
    //   4422	4443	4486	org/json/JSONException
    //   4452	4474	4486	org/json/JSONException
    //   4478	4484	4486	org/json/JSONException
    //   4504	4544	4613	org/json/JSONException
    //   4548	4577	4613	org/json/JSONException
    //   4577	4610	4613	org/json/JSONException
    //   4643	4713	4987	org/json/JSONException
    //   4716	4721	4987	org/json/JSONException
    //   4733	4750	4987	org/json/JSONException
    //   4753	4770	4987	org/json/JSONException
    //   4774	4785	4987	org/json/JSONException
    //   4789	4820	4987	org/json/JSONException
    //   4824	4985	4987	org/json/JSONException
    //   5102	5109	5218	org/json/JSONException
    //   5113	5120	5218	org/json/JSONException
    //   5124	5151	5218	org/json/JSONException
    //   5156	5203	5218	org/json/JSONException
    //   5206	5215	5218	org/json/JSONException
    //   5254	5303	5348	org/json/JSONException
    //   5303	5326	5348	org/json/JSONException
    //   5397	5448	5493	java/lang/Exception
    //   5448	5471	5493	java/lang/Exception
    //   5542	5590	5638	java/lang/Exception
    //   5590	5613	5638	java/lang/Exception
    //   5687	5721	5724	org/json/JSONException
    //   5760	5868	5871	org/json/JSONException
    //   6718	6728	7088	org/json/JSONException
    //   7001	7039	7126	java/lang/Exception
    //   5907	5956	7161	org/json/JSONException
    //   5956	5993	7161	org/json/JSONException
    //   5996	6006	7161	org/json/JSONException
    //   6016	6037	7161	org/json/JSONException
    //   6056	6070	7161	org/json/JSONException
    //   6070	6083	7161	org/json/JSONException
    //   6083	6102	7161	org/json/JSONException
    //   6130	6137	7161	org/json/JSONException
    //   6157	6170	7161	org/json/JSONException
    //   6190	6200	7161	org/json/JSONException
    //   6224	6232	7161	org/json/JSONException
    //   6252	6266	7161	org/json/JSONException
    //   6286	6296	7161	org/json/JSONException
    //   6320	6328	7161	org/json/JSONException
    //   6348	6362	7161	org/json/JSONException
    //   6382	6392	7161	org/json/JSONException
    //   6416	6424	7161	org/json/JSONException
    //   6444	6458	7161	org/json/JSONException
    //   6478	6488	7161	org/json/JSONException
    //   6508	6518	7161	org/json/JSONException
    //   6554	6718	7161	org/json/JSONException
    //   6728	6805	7161	org/json/JSONException
    //   6813	6995	7161	org/json/JSONException
    //   7001	7039	7161	org/json/JSONException
    //   7039	7058	7161	org/json/JSONException
    //   7067	7072	7161	org/json/JSONException
    //   7090	7120	7161	org/json/JSONException
    //   7128	7158	7161	org/json/JSONException
    //   7194	7204	7161	org/json/JSONException
    //   7213	7269	7161	org/json/JSONException
    //   7274	7313	7161	org/json/JSONException
    //   7316	7498	7161	org/json/JSONException
    //   7498	7536	7161	org/json/JSONException
    //   7536	7558	7161	org/json/JSONException
    //   7569	7599	7161	org/json/JSONException
    //   7635	7660	7161	org/json/JSONException
    //   7672	7709	7161	org/json/JSONException
    //   7714	7756	7161	org/json/JSONException
    //   7766	7815	7161	org/json/JSONException
    //   7815	7844	7161	org/json/JSONException
    //   7847	7921	7161	org/json/JSONException
    //   7921	7954	7161	org/json/JSONException
    //   7966	8041	7161	org/json/JSONException
    //   8048	8067	7161	org/json/JSONException
    //   8067	8076	7161	org/json/JSONException
    //   8078	8115	7161	org/json/JSONException
    //   8120	8171	7161	org/json/JSONException
    //   8180	8187	7161	org/json/JSONException
    //   8196	8251	7161	org/json/JSONException
    //   8253	8260	7161	org/json/JSONException
    //   8264	8353	7161	org/json/JSONException
    //   8356	8457	7161	org/json/JSONException
    //   7498	7536	7567	java/lang/Exception
    //   5907	5956	7602	java/lang/NumberFormatException
    //   5956	5993	7602	java/lang/NumberFormatException
    //   5996	6006	7602	java/lang/NumberFormatException
    //   6016	6037	7602	java/lang/NumberFormatException
    //   6056	6070	7602	java/lang/NumberFormatException
    //   6070	6083	7602	java/lang/NumberFormatException
    //   6083	6102	7602	java/lang/NumberFormatException
    //   6130	6137	7602	java/lang/NumberFormatException
    //   6157	6170	7602	java/lang/NumberFormatException
    //   6190	6200	7602	java/lang/NumberFormatException
    //   6224	6232	7602	java/lang/NumberFormatException
    //   6252	6266	7602	java/lang/NumberFormatException
    //   6286	6296	7602	java/lang/NumberFormatException
    //   6320	6328	7602	java/lang/NumberFormatException
    //   6348	6362	7602	java/lang/NumberFormatException
    //   6382	6392	7602	java/lang/NumberFormatException
    //   6416	6424	7602	java/lang/NumberFormatException
    //   6444	6458	7602	java/lang/NumberFormatException
    //   6478	6488	7602	java/lang/NumberFormatException
    //   6508	6518	7602	java/lang/NumberFormatException
    //   6554	6718	7602	java/lang/NumberFormatException
    //   6718	6728	7602	java/lang/NumberFormatException
    //   6728	6805	7602	java/lang/NumberFormatException
    //   6813	6995	7602	java/lang/NumberFormatException
    //   7001	7039	7602	java/lang/NumberFormatException
    //   7039	7058	7602	java/lang/NumberFormatException
    //   7067	7072	7602	java/lang/NumberFormatException
    //   7090	7120	7602	java/lang/NumberFormatException
    //   7128	7158	7602	java/lang/NumberFormatException
    //   7194	7204	7602	java/lang/NumberFormatException
    //   7213	7269	7602	java/lang/NumberFormatException
    //   7274	7313	7602	java/lang/NumberFormatException
    //   7316	7498	7602	java/lang/NumberFormatException
    //   7498	7536	7602	java/lang/NumberFormatException
    //   7536	7558	7602	java/lang/NumberFormatException
    //   7569	7599	7602	java/lang/NumberFormatException
    //   7635	7660	7602	java/lang/NumberFormatException
    //   7672	7709	7602	java/lang/NumberFormatException
    //   7714	7756	7602	java/lang/NumberFormatException
    //   7766	7815	7602	java/lang/NumberFormatException
    //   7815	7844	7602	java/lang/NumberFormatException
    //   7847	7921	7602	java/lang/NumberFormatException
    //   7921	7954	7602	java/lang/NumberFormatException
    //   7966	8041	7602	java/lang/NumberFormatException
    //   8048	8067	7602	java/lang/NumberFormatException
    //   8067	8076	7602	java/lang/NumberFormatException
    //   8078	8115	7602	java/lang/NumberFormatException
    //   8120	8171	7602	java/lang/NumberFormatException
    //   8180	8187	7602	java/lang/NumberFormatException
    //   8196	8251	7602	java/lang/NumberFormatException
    //   8253	8260	7602	java/lang/NumberFormatException
    //   8264	8353	7602	java/lang/NumberFormatException
    //   8356	8457	7602	java/lang/NumberFormatException
    //   9303	9313	9673	org/json/JSONException
    //   9586	9624	9686	java/lang/Exception
    //   8482	8541	9696	org/json/JSONException
    //   8541	8578	9696	org/json/JSONException
    //   8581	8591	9696	org/json/JSONException
    //   8601	8622	9696	org/json/JSONException
    //   8641	8655	9696	org/json/JSONException
    //   8655	8668	9696	org/json/JSONException
    //   8668	8687	9696	org/json/JSONException
    //   8715	8722	9696	org/json/JSONException
    //   8742	8755	9696	org/json/JSONException
    //   8775	8785	9696	org/json/JSONException
    //   8809	8817	9696	org/json/JSONException
    //   8837	8851	9696	org/json/JSONException
    //   8871	8881	9696	org/json/JSONException
    //   8905	8913	9696	org/json/JSONException
    //   8933	8947	9696	org/json/JSONException
    //   8967	8977	9696	org/json/JSONException
    //   9001	9009	9696	org/json/JSONException
    //   9029	9043	9696	org/json/JSONException
    //   9063	9073	9696	org/json/JSONException
    //   9093	9103	9696	org/json/JSONException
    //   9139	9303	9696	org/json/JSONException
    //   9313	9390	9696	org/json/JSONException
    //   9398	9580	9696	org/json/JSONException
    //   9586	9624	9696	org/json/JSONException
    //   9624	9643	9696	org/json/JSONException
    //   9652	9657	9696	org/json/JSONException
    //   9675	9680	9696	org/json/JSONException
    //   9688	9693	9696	org/json/JSONException
    //   9704	9714	9696	org/json/JSONException
    //   9723	9779	9696	org/json/JSONException
    //   9784	9823	9696	org/json/JSONException
    //   9826	10008	9696	org/json/JSONException
    //   10008	10046	9696	org/json/JSONException
    //   10046	10068	9696	org/json/JSONException
    //   10079	10084	9696	org/json/JSONException
    //   10087	10112	9696	org/json/JSONException
    //   10124	10161	9696	org/json/JSONException
    //   10166	10208	9696	org/json/JSONException
    //   10218	10267	9696	org/json/JSONException
    //   10267	10296	9696	org/json/JSONException
    //   10299	10373	9696	org/json/JSONException
    //   10373	10406	9696	org/json/JSONException
    //   10418	10493	9696	org/json/JSONException
    //   10500	10519	9696	org/json/JSONException
    //   10519	10528	9696	org/json/JSONException
    //   10530	10567	9696	org/json/JSONException
    //   10572	10623	9696	org/json/JSONException
    //   10632	10639	9696	org/json/JSONException
    //   10648	10703	9696	org/json/JSONException
    //   10705	10712	9696	org/json/JSONException
    //   10716	10807	9696	org/json/JSONException
    //   10810	10830	9696	org/json/JSONException
    //   10008	10046	10077	java/lang/Exception
    //   10900	10948	10951	java/lang/Exception
    //   11037	11077	11080	org/json/JSONException
    //   11088	11093	11080	org/json/JSONException
    //   11107	11181	11195	org/json/JSONException
    //   11181	11192	11195	org/json/JSONException
    //   11214	11248	11712	org/json/JSONException
    //   11248	11269	11712	org/json/JSONException
    //   11269	11315	11712	org/json/JSONException
    //   11315	11328	11712	org/json/JSONException
    //   11330	11356	11712	org/json/JSONException
    //   11358	11378	11712	org/json/JSONException
    //   11378	11391	11712	org/json/JSONException
    //   11393	11415	11712	org/json/JSONException
    //   11415	11437	11712	org/json/JSONException
    //   11440	11462	11712	org/json/JSONException
    //   11462	11529	11712	org/json/JSONException
    //   11529	11679	11712	org/json/JSONException
    //   11684	11698	11712	org/json/JSONException
    //   11698	11709	11712	org/json/JSONException
    //   11721	11725	11712	org/json/JSONException
    //   11729	11733	11712	org/json/JSONException
    //   11315	11328	11720	java/lang/Exception
    //   11378	11391	11728	java/lang/Exception
    //   11771	11789	11860	java/lang/Exception
    //   11791	11799	11860	java/lang/Exception
    //   11801	11813	11860	java/lang/Exception
    //   11815	11826	11860	java/lang/Exception
    //   11828	11857	11860	java/lang/Exception
    //   11898	11910	12029	java/lang/Exception
    //   11912	11920	12029	java/lang/Exception
    //   11922	11930	12029	java/lang/Exception
    //   11932	11941	12029	java/lang/Exception
    //   11946	11955	12029	java/lang/Exception
    //   11957	11975	12029	java/lang/Exception
    //   11986	11995	12029	java/lang/Exception
    //   11997	12026	12029	java/lang/Exception
    //   12169	12207	12210	org/json/JSONException
    //   12063	12103	12218	org/json/JSONException
    //   12106	12126	12218	org/json/JSONException
    //   12126	12164	12218	org/json/JSONException
    //   12211	12215	12218	org/json/JSONException
    //   12226	12264	12218	org/json/JSONException
    //   12311	12315	12218	org/json/JSONException
    //   12269	12307	12310	org/json/JSONException
    //   12329	12373	12475	org/json/JSONException
    //   12373	12435	12475	org/json/JSONException
    //   12435	12472	12475	org/json/JSONException
    //   12586	12700	12719	org/json/JSONException
    //   12700	12716	12719	org/json/JSONException
    //   12788	12853	12856	org/json/JSONException
    //   12871	12953	12956	org/json/JSONException
    //   12975	13022	13164	org/json/JSONException
    //   13052	13161	13164	org/json/JSONException
    //   13197	13239	13241	org/json/JSONException
    //   13304	13329	13429	org/json/JSONException
    //   13334	13346	13429	org/json/JSONException
    //   13346	13355	13429	org/json/JSONException
    //   13355	13384	13429	org/json/JSONException
    //   13387	13399	13429	org/json/JSONException
    //   13399	13426	13429	org/json/JSONException
    //   13475	13505	13507	java/lang/Exception
    //   13541	13584	13586	java/lang/Exception
    //   8655	8668	13672	java/lang/Exception
    //   8668	8687	13696	java/lang/Exception
    //   8715	8722	13718	java/lang/Exception
    //   8742	8755	13718	java/lang/Exception
    //   8775	8785	13718	java/lang/Exception
    //   8809	8817	13718	java/lang/Exception
    //   8837	8851	13718	java/lang/Exception
    //   8871	8881	13718	java/lang/Exception
    //   8905	8913	13718	java/lang/Exception
    //   8933	8947	13718	java/lang/Exception
    //   8967	8977	13718	java/lang/Exception
    //   9001	9009	13718	java/lang/Exception
    //   9029	9043	13718	java/lang/Exception
    //   9063	9073	13718	java/lang/Exception
    //   9093	9103	13718	java/lang/Exception
    //   6070	6083	13743	java/lang/Exception
    //   6083	6102	13767	java/lang/Exception
    //   6130	6137	13789	java/lang/Exception
    //   6157	6170	13789	java/lang/Exception
    //   6190	6200	13789	java/lang/Exception
    //   6224	6232	13789	java/lang/Exception
    //   6252	6266	13789	java/lang/Exception
    //   6286	6296	13789	java/lang/Exception
    //   6320	6328	13789	java/lang/Exception
    //   6348	6362	13789	java/lang/Exception
    //   6382	6392	13789	java/lang/Exception
    //   6416	6424	13789	java/lang/Exception
    //   6444	6458	13789	java/lang/Exception
    //   6478	6488	13789	java/lang/Exception
    //   6508	6518	13789	java/lang/Exception
    //   4118	4183	13814	org/json/JSONException
    //   4199	4211	13814	org/json/JSONException
    //   4228	4244	13814	org/json/JSONException
    //   6056	6070	13953	java/lang/Exception
    //   8641	8655	14076	java/lang/Exception
  }
  
  public boolean hasConfig(String paramString)
  {
    return authorizedLists.containsKey(paramString);
  }
  
  public boolean hasRight(String paramString1, String paramString2)
  {
    if (!authorizedLists.containsKey(paramString1)) {}
    do
    {
      do
      {
        return false;
        paramString1 = (ArrayList)authorizedLists.get(paramString1);
        if (!"QQApi.shareMsg".equals(paramString2)) {
          break;
        }
      } while ((!contains(paramString1, "ui.setOnShareQQFriendHandler")) && (!contains(paramString1, "ui.ui.setOnShareQZoneHandler")) && (!contains(paramString1, "ui.ui.setOnShareWXFriendHandler")) && (!contains(paramString1, "ui.setOnShareWXTimelineHandler")));
      return true;
    } while (!contains(paramString1, paramString2));
    if ("qbizApi.getNetworkType".equals(paramString2)) {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ("publicAccount.getLocation".equals(paramString2)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
      } else if ("ui.closeWebViews".equals(paramString2)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
      } else if ("troopNotice.showPicture".equals(paramString2)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
      }
    }
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
  
  public void hideWebToolbar()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().setBottomBarVisible(false);
    }
  }
  
  void init()
  {
    if (this.mInited.compareAndSet(false, true))
    {
      this.mClient = TroopMemberApiClient.a();
      this.mClient.a();
    }
    if (this.mVideoIPCClient == null) {
      this.mVideoIPCClient = VideoFeedsIPCClient.a();
    }
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 2340	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +152 -> 161
    //   12: aload_1
    //   13: ifnull +119 -> 132
    //   16: new 355	org/json/JSONObject
    //   19: dup
    //   20: invokespecial 356	org/json/JSONObject:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc_w 358
    //   30: iconst_0
    //   31: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 363
    //   40: ldc_w 1143
    //   43: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_1
    //   48: ldc_w 2342
    //   51: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 207	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:needResult	I
    //   59: iconst_1
    //   60: if_icmpne +42 -> 102
    //   63: aload 7
    //   65: ldc_w 2342
    //   68: aload_1
    //   69: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aconst_null
    //   74: ldc_w 1147
    //   77: ldc_w 1149
    //   80: ldc 232
    //   82: ldc_w 2344
    //   85: ldc_w 2344
    //   88: iconst_0
    //   89: iconst_0
    //   90: ldc_w 1273
    //   93: ldc 232
    //   95: ldc 232
    //   97: ldc 232
    //   99: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: getfield 2270	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callback	Ljava/lang/String;
    //   106: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 2270	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callback	Ljava/lang/String;
    //   117: iconst_1
    //   118: anewarray 368	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: aload 7
    //   125: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   128: aastore
    //   129: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   132: aload_0
    //   133: iconst_m1
    //   134: putfield 207	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:needResult	I
    //   137: aload_0
    //   138: iconst_m1
    //   139: putfield 209	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:scanType	I
    //   142: return
    //   143: astore 8
    //   145: aload 8
    //   147: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   150: goto -103 -> 47
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   158: goto -85 -> 73
    //   161: iload_2
    //   162: bipush 112
    //   164: if_icmpne +143 -> 307
    //   167: new 1219	java/io/File
    //   170: dup
    //   171: aload_0
    //   172: getfield 256	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraPath	Ljava/lang/String;
    //   175: invokespecial 1220	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: new 355	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 356	org/json/JSONObject:<init>	()V
    //   186: astore 7
    //   188: new 537	org/json/JSONArray
    //   191: dup
    //   192: invokespecial 2345	org/json/JSONArray:<init>	()V
    //   195: astore 8
    //   197: aload_1
    //   198: ifnull +36 -> 234
    //   201: aload_1
    //   202: invokevirtual 1223	java/io/File:exists	()Z
    //   205: ifeq +29 -> 234
    //   208: invokestatic 2349	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   211: new 2351	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$2
    //   214: dup
    //   215: aload_0
    //   216: aload 8
    //   218: aload 7
    //   220: invokespecial 2354	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$2:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    //   223: invokevirtual 2360	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   226: pop
    //   227: return
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   233: return
    //   234: aload 7
    //   236: ldc_w 358
    //   239: iconst_1
    //   240: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 7
    //   246: ldc_w 363
    //   249: ldc_w 2361
    //   252: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 7
    //   258: ldc_w 1331
    //   261: ldc_w 1333
    //   264: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 258	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraCallback	Ljava/lang/String;
    //   273: iconst_1
    //   274: anewarray 368	java/lang/String
    //   277: dup
    //   278: iconst_0
    //   279: aload 7
    //   281: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   284: aastore
    //   285: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   288: aload_0
    //   289: ldc 232
    //   291: putfield 256	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraPath	Ljava/lang/String;
    //   294: aload_0
    //   295: ldc 232
    //   297: putfield 258	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraCallback	Ljava/lang/String;
    //   300: aload_0
    //   301: ldc 232
    //   303: putfield 260	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraUUid	Ljava/lang/String;
    //   306: return
    //   307: iload_2
    //   308: bipush 111
    //   310: if_icmpne +327 -> 637
    //   313: new 355	org/json/JSONObject
    //   316: dup
    //   317: invokespecial 356	org/json/JSONObject:<init>	()V
    //   320: astore 8
    //   322: new 537	org/json/JSONArray
    //   325: dup
    //   326: invokespecial 2345	org/json/JSONArray:<init>	()V
    //   329: astore 9
    //   331: aload_1
    //   332: ifnull +93 -> 425
    //   335: aload_1
    //   336: ldc_w 2363
    //   339: invokevirtual 2367	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   342: astore 7
    //   344: iconst_0
    //   345: istore_3
    //   346: aload 7
    //   348: ifnull +11 -> 359
    //   351: aload 7
    //   353: invokevirtual 472	java/util/ArrayList:size	()I
    //   356: ifne +75 -> 431
    //   359: aload 8
    //   361: ldc_w 358
    //   364: iconst_1
    //   365: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload 8
    //   371: ldc_w 363
    //   374: ldc 232
    //   376: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   379: pop
    //   380: aload 8
    //   382: ldc_w 1331
    //   385: ldc_w 1346
    //   388: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload_0
    //   393: aload_0
    //   394: getfield 258	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraCallback	Ljava/lang/String;
    //   397: iconst_1
    //   398: anewarray 368	java/lang/String
    //   401: dup
    //   402: iconst_0
    //   403: aload 8
    //   405: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   408: aastore
    //   409: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   412: aload_0
    //   413: ldc 232
    //   415: putfield 258	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraCallback	Ljava/lang/String;
    //   418: return
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 379	org/json/JSONException:printStackTrace	()V
    //   424: return
    //   425: aconst_null
    //   426: astore 7
    //   428: goto -84 -> 344
    //   431: aload_1
    //   432: ldc_w 2369
    //   435: iconst_0
    //   436: invokevirtual 334	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   439: ifne +5 -> 444
    //   442: iconst_1
    //   443: istore_3
    //   444: iload_3
    //   445: ifeq +1291 -> 1736
    //   448: invokestatic 2349	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   451: new 2371	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$3
    //   454: dup
    //   455: aload_0
    //   456: aload 7
    //   458: aload 9
    //   460: aload 8
    //   462: invokespecial 2374	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$3:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/util/ArrayList;Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    //   465: invokevirtual 2360	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   468: pop
    //   469: return
    //   470: iload_3
    //   471: aload 7
    //   473: invokevirtual 472	java/util/ArrayList:size	()I
    //   476: if_icmpge +60 -> 536
    //   479: invokestatic 2380	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   482: astore_1
    //   483: new 498	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 2382
    //   493: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_1
    //   497: invokevirtual 2383	java/util/UUID:toString	()Ljava/lang/String;
    //   500: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: astore_1
    //   507: aload 9
    //   509: iload_3
    //   510: aload_1
    //   511: invokevirtual 2386	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   514: pop
    //   515: getstatic 199	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:localIdMap	Ljava/util/HashMap;
    //   518: aload_1
    //   519: aload 7
    //   521: iload_3
    //   522: invokevirtual 476	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   525: invokevirtual 129	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   528: pop
    //   529: iload_3
    //   530: iconst_1
    //   531: iadd
    //   532: istore_3
    //   533: goto -63 -> 470
    //   536: aload 8
    //   538: ldc_w 2388
    //   541: aload 9
    //   543: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   546: pop
    //   547: aload 8
    //   549: ldc_w 358
    //   552: iconst_0
    //   553: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload 8
    //   559: ldc_w 363
    //   562: ldc_w 1143
    //   565: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   568: pop
    //   569: aload 8
    //   571: ldc_w 1331
    //   574: ldc_w 1346
    //   577: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload_0
    //   582: aload_0
    //   583: getfield 258	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraCallback	Ljava/lang/String;
    //   586: iconst_1
    //   587: anewarray 368	java/lang/String
    //   590: dup
    //   591: iconst_0
    //   592: aload 8
    //   594: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   597: aastore
    //   598: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   601: aload_0
    //   602: ldc 232
    //   604: putfield 258	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:cameraCallback	Ljava/lang/String;
    //   607: aconst_null
    //   608: ldc_w 1147
    //   611: ldc_w 1149
    //   614: ldc 232
    //   616: ldc_w 1344
    //   619: ldc_w 1344
    //   622: iconst_0
    //   623: iconst_0
    //   624: ldc_w 1273
    //   627: ldc 232
    //   629: ldc 232
    //   631: ldc 232
    //   633: invokestatic 1156	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   636: return
    //   637: iload_2
    //   638: bipush 113
    //   640: if_icmpne +136 -> 776
    //   643: iconst_m1
    //   644: istore 4
    //   646: iload_3
    //   647: iconst_m1
    //   648: if_icmpne +6 -> 654
    //   651: iconst_0
    //   652: istore 4
    //   654: aload_1
    //   655: ifnull -513 -> 142
    //   658: aload_1
    //   659: ldc_w 1894
    //   662: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   665: astore 7
    //   667: aload_1
    //   668: ldc_w 1898
    //   671: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   674: astore 8
    //   676: aload_1
    //   677: ldc_w 785
    //   680: iconst_1
    //   681: invokevirtual 334	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   684: istore 5
    //   686: aload 7
    //   688: ifnull +63 -> 751
    //   691: aload 8
    //   693: ifnull +58 -> 751
    //   696: new 355	org/json/JSONObject
    //   699: dup
    //   700: invokespecial 356	org/json/JSONObject:<init>	()V
    //   703: astore_1
    //   704: aload_1
    //   705: ldc_w 1696
    //   708: aload 8
    //   710: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload_1
    //   715: ldc_w 358
    //   718: iload 4
    //   720: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload_1
    //   725: ldc_w 785
    //   728: iload 5
    //   730: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   733: pop
    //   734: aload_0
    //   735: aload 7
    //   737: iconst_1
    //   738: anewarray 368	java/lang/String
    //   741: dup
    //   742: iconst_0
    //   743: aload_1
    //   744: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   747: aastore
    //   748: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   751: getstatic 2393	com/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport:a	Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;
    //   754: astore_1
    //   755: iload_3
    //   756: iconst_m1
    //   757: if_icmpne +13 -> 770
    //   760: iconst_1
    //   761: istore 6
    //   763: aload_1
    //   764: iload 6
    //   766: invokevirtual 2395	com/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport:a	(Z)V
    //   769: return
    //   770: iconst_0
    //   771: istore 6
    //   773: goto -10 -> 763
    //   776: iload_2
    //   777: bipush 114
    //   779: if_icmpeq +21 -> 800
    //   782: iload_2
    //   783: bipush 115
    //   785: if_icmpeq +15 -> 800
    //   788: iload_2
    //   789: bipush 116
    //   791: if_icmpeq +9 -> 800
    //   794: iload_2
    //   795: bipush 122
    //   797: if_icmpne +292 -> 1089
    //   800: aload_1
    //   801: ifnull -659 -> 142
    //   804: aload_1
    //   805: ldc_w 316
    //   808: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   811: astore 9
    //   813: aload 9
    //   815: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   818: ifne -676 -> 142
    //   821: ldc 232
    //   823: astore 8
    //   825: aload 8
    //   827: astore 7
    //   829: iload_2
    //   830: tableswitch	default:+50 -> 880, 114:+151->981, 115:+159->989, 116:+167->997, 117:+54->884, 118:+54->884, 119:+54->884, 120:+54->884, 121:+54->884, 122:+175->1005
    //   881: iconst_5
    //   882: astore 7
    //   884: iload_3
    //   885: iconst_m1
    //   886: if_icmpne +127 -> 1013
    //   889: aload_1
    //   890: ldc_w 2397
    //   893: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   896: astore_1
    //   897: aload_1
    //   898: ifnull -756 -> 142
    //   901: new 355	org/json/JSONObject
    //   904: dup
    //   905: aload_1
    //   906: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   909: astore_1
    //   910: aload_1
    //   911: ldc_w 358
    //   914: iconst_0
    //   915: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   918: pop
    //   919: aload_1
    //   920: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   923: astore_1
    //   924: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +37 -> 964
    //   930: ldc 45
    //   932: iconst_2
    //   933: new 498	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   940: aload 7
    //   942: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: ldc_w 2399
    //   948: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload_1
    //   952: invokestatic 2402	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   955: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   964: aload_0
    //   965: aload 9
    //   967: iconst_1
    //   968: anewarray 368	java/lang/String
    //   971: dup
    //   972: iconst_0
    //   973: aload_1
    //   974: aastore
    //   975: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   978: return
    //   979: astore_1
    //   980: return
    //   981: ldc_w 1986
    //   984: astore 7
    //   986: goto -102 -> 884
    //   989: ldc_w 1998
    //   992: astore 7
    //   994: goto -110 -> 884
    //   997: ldc_w 2006
    //   1000: astore 7
    //   1002: goto -118 -> 884
    //   1005: ldc_w 2404
    //   1008: astore 7
    //   1010: goto -126 -> 884
    //   1013: new 355	org/json/JSONObject
    //   1016: dup
    //   1017: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1020: astore_1
    //   1021: aload_1
    //   1022: ldc_w 358
    //   1025: iconst_m1
    //   1026: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1029: pop
    //   1030: aload_1
    //   1031: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1034: astore_1
    //   1035: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1038: ifeq +34 -> 1072
    //   1041: ldc 45
    //   1043: iconst_2
    //   1044: new 498	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1051: aload 7
    //   1053: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc_w 2399
    //   1059: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload_1
    //   1063: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: aload_0
    //   1073: aload 9
    //   1075: iconst_1
    //   1076: anewarray 368	java/lang/String
    //   1079: dup
    //   1080: iconst_0
    //   1081: aload_1
    //   1082: aastore
    //   1083: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1086: return
    //   1087: astore_1
    //   1088: return
    //   1089: iload_2
    //   1090: bipush 118
    //   1092: if_icmpeq +9 -> 1101
    //   1095: iload_2
    //   1096: bipush 121
    //   1098: if_icmpne +432 -> 1530
    //   1101: ldc 232
    //   1103: astore 8
    //   1105: aload 8
    //   1107: astore 7
    //   1109: iload_2
    //   1110: tableswitch	default:+30 -> 1140, 118:+146->1256, 119:+34->1144, 120:+34->1144, 121:+154->1264
    //   1141: iconst_5
    //   1142: astore 7
    //   1144: aload_1
    //   1145: ifnonnull +127 -> 1272
    //   1148: iload_3
    //   1149: ifne -1007 -> 142
    //   1152: new 355	org/json/JSONObject
    //   1155: dup
    //   1156: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1159: astore_1
    //   1160: aload_1
    //   1161: ldc_w 358
    //   1164: iconst_1
    //   1165: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1168: pop
    //   1169: aload_1
    //   1170: ldc_w 363
    //   1173: ldc_w 2405
    //   1176: invokestatic 931	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1179: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1182: pop
    //   1183: aload_1
    //   1184: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1187: astore_1
    //   1188: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1191: ifeq +32 -> 1223
    //   1194: ldc 45
    //   1196: iconst_2
    //   1197: new 498	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 2407
    //   1207: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: aload_1
    //   1211: invokestatic 2402	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1214: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1220: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1223: aload_0
    //   1224: aload 7
    //   1226: iconst_1
    //   1227: anewarray 368	java/lang/String
    //   1230: dup
    //   1231: iconst_0
    //   1232: aload_1
    //   1233: aastore
    //   1234: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1237: return
    //   1238: astore_1
    //   1239: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1242: ifeq -1100 -> 142
    //   1245: ldc 45
    //   1247: iconst_2
    //   1248: aload_1
    //   1249: invokestatic 887	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1252: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1255: return
    //   1256: getstatic 1410	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndUploadAvatarCallback	Ljava/lang/String;
    //   1259: astore 7
    //   1261: goto -117 -> 1144
    //   1264: getstatic 1447	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:selectAndTopicPicCallback	Ljava/lang/String;
    //   1267: astore 7
    //   1269: goto -125 -> 1144
    //   1272: aload 7
    //   1274: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1277: ifne -1135 -> 142
    //   1280: iload_3
    //   1281: iconst_m1
    //   1282: if_icmpne +159 -> 1441
    //   1285: aload_1
    //   1286: ldc_w 2409
    //   1289: invokevirtual 2413	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1292: astore 8
    //   1294: aload 8
    //   1296: ifnull -1154 -> 142
    //   1299: aload 8
    //   1301: ldc_w 358
    //   1304: invokevirtual 2414	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1307: istore_3
    //   1308: aload 8
    //   1310: ldc_w 1039
    //   1313: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1316: astore_1
    //   1317: aload 8
    //   1319: ldc_w 363
    //   1322: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1325: astore 8
    //   1327: new 355	org/json/JSONObject
    //   1330: dup
    //   1331: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1334: astore 9
    //   1336: aload 9
    //   1338: ldc_w 358
    //   1341: iload_3
    //   1342: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1345: pop
    //   1346: aload 9
    //   1348: ldc_w 1039
    //   1351: aload_1
    //   1352: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1355: pop
    //   1356: aload 9
    //   1358: ldc_w 363
    //   1361: aload 8
    //   1363: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1366: pop
    //   1367: aload 9
    //   1369: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1372: astore_1
    //   1373: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1376: ifeq +32 -> 1408
    //   1379: ldc 45
    //   1381: iconst_2
    //   1382: new 498	java/lang/StringBuilder
    //   1385: dup
    //   1386: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1389: ldc_w 2407
    //   1392: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: aload_1
    //   1396: invokestatic 2402	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1399: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1408: aload_0
    //   1409: aload 7
    //   1411: iconst_1
    //   1412: anewarray 368	java/lang/String
    //   1415: dup
    //   1416: iconst_0
    //   1417: aload_1
    //   1418: aastore
    //   1419: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1422: return
    //   1423: astore_1
    //   1424: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1427: ifeq -1285 -> 142
    //   1430: ldc 45
    //   1432: iconst_2
    //   1433: aload_1
    //   1434: invokestatic 887	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1437: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1440: return
    //   1441: new 355	org/json/JSONObject
    //   1444: dup
    //   1445: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1448: astore_1
    //   1449: aload_1
    //   1450: ldc_w 358
    //   1453: iconst_m1
    //   1454: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1457: pop
    //   1458: aload_1
    //   1459: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1462: astore_1
    //   1463: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1466: ifeq +29 -> 1495
    //   1469: ldc 45
    //   1471: iconst_2
    //   1472: new 498	java/lang/StringBuilder
    //   1475: dup
    //   1476: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1479: ldc_w 2417
    //   1482: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: aload_1
    //   1486: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1495: aload_0
    //   1496: aload_0
    //   1497: getfield 2270	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callback	Ljava/lang/String;
    //   1500: iconst_1
    //   1501: anewarray 368	java/lang/String
    //   1504: dup
    //   1505: iconst_0
    //   1506: aload_1
    //   1507: aastore
    //   1508: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1511: return
    //   1512: astore_1
    //   1513: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1516: ifeq -1374 -> 142
    //   1519: ldc 45
    //   1521: iconst_2
    //   1522: aload_1
    //   1523: invokestatic 887	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1526: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1529: return
    //   1530: iload_2
    //   1531: bipush 117
    //   1533: if_icmpne +187 -> 1720
    //   1536: aload_1
    //   1537: ifnull -1395 -> 142
    //   1540: aload_1
    //   1541: ldc_w 316
    //   1544: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1547: astore 7
    //   1549: aload 7
    //   1551: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1554: ifne -1412 -> 142
    //   1557: iload_3
    //   1558: sipush 1699
    //   1561: if_icmpne +46 -> 1607
    //   1564: new 287	android/os/Bundle
    //   1567: dup
    //   1568: invokespecial 288	android/os/Bundle:<init>	()V
    //   1571: astore 8
    //   1573: aload 8
    //   1575: ldc_w 2419
    //   1578: aload_1
    //   1579: invokevirtual 2423	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1582: invokestatic 281	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   1585: ldc_w 283
    //   1588: ldc_w 2425
    //   1591: aload 8
    //   1593: new 2427	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$4
    //   1596: dup
    //   1597: aload_0
    //   1598: aload 7
    //   1600: invokespecial 2428	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl$4:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl;Ljava/lang/String;)V
    //   1603: invokevirtual 296	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   1606: return
    //   1607: aload_1
    //   1608: ldc_w 2397
    //   1611: invokevirtual 322	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1614: astore_1
    //   1615: aload_1
    //   1616: ifnull +81 -> 1697
    //   1619: new 355	org/json/JSONObject
    //   1622: dup
    //   1623: aload_1
    //   1624: invokespecial 490	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1627: astore_1
    //   1628: iload_3
    //   1629: iconst_m1
    //   1630: if_icmpne +78 -> 1708
    //   1633: aload_1
    //   1634: ldc_w 358
    //   1637: iconst_0
    //   1638: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1641: pop
    //   1642: aload_1
    //   1643: invokevirtual 372	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1646: astore_1
    //   1647: invokestatic 496	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1650: ifeq +32 -> 1682
    //   1653: ldc 45
    //   1655: iconst_2
    //   1656: new 498	java/lang/StringBuilder
    //   1659: dup
    //   1660: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   1663: ldc_w 2430
    //   1666: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: aload_1
    //   1670: invokestatic 2402	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1673: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1679: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1682: aload_0
    //   1683: aload 7
    //   1685: iconst_1
    //   1686: anewarray 368	java/lang/String
    //   1689: dup
    //   1690: iconst_0
    //   1691: aload_1
    //   1692: aastore
    //   1693: invokevirtual 376	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1696: return
    //   1697: new 355	org/json/JSONObject
    //   1700: dup
    //   1701: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1704: astore_1
    //   1705: goto -77 -> 1628
    //   1708: aload_1
    //   1709: ldc_w 358
    //   1712: iconst_m1
    //   1713: invokevirtual 361	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1716: pop
    //   1717: goto -75 -> 1642
    //   1720: iload_2
    //   1721: bipush 119
    //   1723: if_icmpne -1581 -> 142
    //   1726: aload_0
    //   1727: aload_1
    //   1728: invokespecial 2432	com/tencent/biz/pubaccount/util/api/impl/PublicAccountH5AbilityPluginImpl:handleInviteFriendResult	(Landroid/content/Intent;)V
    //   1731: return
    //   1732: astore_1
    //   1733: goto -982 -> 751
    //   1736: iconst_0
    //   1737: istore_3
    //   1738: goto -1268 -> 470
    //   1741: astore_1
    //   1742: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1743	0	this	PublicAccountH5AbilityPluginImpl
    //   0	1743	1	paramIntent	Intent
    //   0	1743	2	paramByte	byte
    //   0	1743	3	paramInt	int
    //   644	75	4	i	int
    //   684	45	5	j	int
    //   761	11	6	bool	boolean
    //   23	1661	7	localObject1	Object
    //   143	3	8	localJSONException	JSONException
    //   195	1397	8	localObject2	Object
    //   329	1039	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	47	143	org/json/JSONException
    //   63	73	153	org/json/JSONException
    //   201	227	228	org/json/JSONException
    //   234	306	228	org/json/JSONException
    //   351	359	419	org/json/JSONException
    //   359	418	419	org/json/JSONException
    //   431	442	419	org/json/JSONException
    //   448	469	419	org/json/JSONException
    //   470	529	419	org/json/JSONException
    //   536	636	419	org/json/JSONException
    //   901	964	979	java/lang/Exception
    //   964	978	979	java/lang/Exception
    //   1013	1072	1087	java/lang/Exception
    //   1072	1086	1087	java/lang/Exception
    //   1152	1223	1238	java/lang/Exception
    //   1223	1237	1238	java/lang/Exception
    //   1327	1408	1423	java/lang/Exception
    //   1408	1422	1423	java/lang/Exception
    //   1441	1495	1512	java/lang/Exception
    //   1495	1511	1512	java/lang/Exception
    //   704	751	1732	java/lang/Exception
    //   1619	1628	1741	java/lang/Exception
    //   1633	1642	1741	java/lang/Exception
    //   1642	1682	1741	java/lang/Exception
    //   1682	1696	1741	java/lang/Exception
    //   1697	1705	1741	java/lang/Exception
    //   1708	1717	1741	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.app = this.mRuntime.a();
      this.activity = this.mRuntime.a();
      this.uin = this.app.getAccount();
    }
    init();
  }
  
  public void onDestroy()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        cleanConfig(localCustomWebView.getUrl());
      }
    }
    super.onDestroy();
    if (this.mInited.get())
    {
      cancleAllUploadAndDownloadTask();
      if (this.mClient != null) {
        this.mClient.b();
      }
      getMenuHideNameList().clear();
      if (this.ptt != null) {
        this.ptt.cancelPttRecorderAndPlayTask();
      }
    }
    if (this.mVideoWebPreDownload != null)
    {
      this.mVideoWebPreDownload.b();
      this.mVideoWebPreDownload = null;
    }
  }
  
  protected void onPause()
  {
    if (this.ptt != null) {
      this.ptt.cancelPttRecorderAndPlayTask();
    }
  }
  
  public void openLocation()
  {
    if (this.activity == null) {
      return;
    }
    Intent localIntent = new Intent(this.activity, PoiMapActivity.class).putExtra("uin", this.uin);
    this.activity.startActivity(localIntent);
    this.mClient.c();
  }
  
  public void selectPhotoFromGallery(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intent localIntent = new Intent(this.activity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
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
    if (this.mRuntime.a() != null)
    {
      paramInt1 = this.mRuntime.a().switchRequestCode(this, paramByte);
      localIntent.putExtra("keyAction", "actionSelectPicture");
      localIntent.putExtra("requestCode", paramInt1);
    }
    startActivityForResult(localIntent, paramByte);
    AlbumUtil.anim(this.activity, false, true);
  }
  
  void sendAuthRequest(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.5.5,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + paramString2);
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
    localJSApiWebServerRequest.versionInfo.set("8.5.5,3,0");
    localJSApiWebServerRequest.cmd.set(this.CMD_FOR_UUID);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.pUin);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new PublicAccountH5AbilityPluginImpl.17(this, paramString2, paramInt, paramBoolean, paramString1));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.app.startServlet(localNewIntent);
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
  
  void sendUuidForMediaIdRequest(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.5.5,3,0");
    localJSApiWebServerRequest.cmd.set(this.CMD_FOR_MEDIAID);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("puin", this.pUin);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      catch (JSONException paramString1)
      {
        PublicAccountH5AbilityPttImpl localPublicAccountH5AbilityPttImpl;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new PublicAccountH5AbilityPluginImpl.16(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.app.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.ptt == null) {
        this.ptt = new PublicAccountH5AbilityPttImpl(this.activity, this.uin, this.mRuntime);
      }
      this.ptt.checkFileInfo();
      localJSONObject.put("file_uuid", paramString1);
      localPublicAccountH5AbilityPttImpl = this.ptt;
      localJSONObject.put("file_md5", PublicAccountH5AbilityPttImpl.getMd5ForPtt());
      localPublicAccountH5AbilityPttImpl = this.ptt;
      localJSONObject.put("file_name", PublicAccountH5AbilityPttImpl.getFileNameForPtt());
      localPublicAccountH5AbilityPttImpl = this.ptt;
      localJSONObject.put("file_size", PublicAccountH5AbilityPttImpl.getFileSizeForPtt());
      localPublicAccountH5AbilityPttImpl = this.ptt;
      localJSONObject.put("file_time", PublicAccountH5AbilityPttImpl.getTimeForPtt());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localPublicAccountH5AbilityPttImpl = this.ptt;
        paramString1 = paramString1.append(PublicAccountH5AbilityPttImpl.getMd5ForPtt()).append(" file_name:");
        localPublicAccountH5AbilityPttImpl = this.ptt;
        paramString1 = paramString1.append(PublicAccountH5AbilityPttImpl.getFileNameForPtt()).append(" file_size=");
        localPublicAccountH5AbilityPttImpl = this.ptt;
        paramString1 = paramString1.append(PublicAccountH5AbilityPttImpl.getFileSizeForPtt()).append(" file_time=");
        localPublicAccountH5AbilityPttImpl = this.ptt;
        QLog.i("PublicAccountH5AbilityPlugin", 2, PublicAccountH5AbilityPttImpl.getTimeForPtt());
      }
    }
  }
  
  public void setRightButtonState(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().setRightButton(paramBoolean);
      }
      return;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
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
    if (this.activity == null) {
      return;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.activity, "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", paramString);
    localActivityURIRequest.extra().putBoolean("fromBrowser", true);
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public void showPAactionSheet(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.paActionSheet == null) {
      this.paActionSheet = ((ActionSheet)ActionSheetHelper.a(this.activity, null));
    }
    Object localObject = LayoutInflater.from(this.activity).inflate(2131561443, null);
    this.paActionSheet.setActionContentView((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131367151);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131367149);
    localObject = (TextView)((View)localObject).findViewById(2131367231);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.paActionSheet.isShowing()) {
        this.paActionSheet.show();
      }
      localTextView1.setOnClickListener(new PublicAccountH5AbilityPluginImpl.19(this, paramString));
      localTextView2.setOnClickListener(new PublicAccountH5AbilityPluginImpl.20(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new PublicAccountH5AbilityPluginImpl.21(this));
      return;
      if (paramInt1 == 2)
      {
        ((TextView)localObject).setVisibility(8);
        localTextView1.setVisibility(8);
      }
    }
  }
  
  void showProgressDialog()
  {
    try
    {
      if (this.mPd != null) {
        cancleProgressDailog();
      }
      while (!this.mPd.isShowing())
      {
        this.mPd.show();
        return;
        this.mPd = new ReportProgressDialog(this.activity, 2131755842);
        this.mPd.setCancelable(true);
        this.mPd.show();
        this.mPd.setContentView(2131559683);
        ((TextView)this.mPd.findViewById(2131373066)).setText(HardCodeUtil.a(2131708793));
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void showReadInJoyNativeCommentView(JSONObject paramJSONObject, String paramString, BridgeModule.CallCommentJs paramCallCommentJs)
  {
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.a();
    showReadInJoyNativeCommentView(paramJSONObject, localTroopMemberApiClient.a(new PublicAccountH5AbilityPluginImpl.14(this, paramCallCommentJs, paramString)));
  }
  
  public void showWebPanel()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().showActionSheet();
    }
  }
  
  public void showWebToolbar()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().setBottomBarVisible(true);
    }
  }
  
  void startDownload(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str3 = this.pUin;
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3)) {}
    }
    else
    {
      str1 = "12345678";
    }
    try
    {
      Long.parseLong(str1);
      if ((this.mClient != null) && (!"".equals(paramString1))) {
        this.mClient.b(paramString1, paramInt, str1, paramBoolean, new PublicAccountH5AbilityPluginImpl.24(this, paramBoolean, paramString3, paramString2), new PublicAccountH5AbilityPluginImpl.25(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "12345678";
      }
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
        if (paramString.equals(localDownloadBeen.jdField_b_of_type_JavaLangString)) {
          localArrayList.add(localDownloadBeen);
        }
      }
      this.downloadBeensList.removeAll(localArrayList);
    }
    if (this.downloadBeensList.size() > 0)
    {
      paramString = (PublicAccountH5AbilityPluginImpl.DownloadBeen)this.downloadBeensList.get(0);
      sendMediaIdForUuidRequest(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramString.jdField_a_of_type_JavaLangString);
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
          if (((String)localObject2).equals(localUploadBeen.jdField_b_of_type_JavaLangString)) {
            paramBundle.add(localUploadBeen);
          }
        }
      }
      this.uploadBeensList.removeAll(paramBundle);
      if (this.uploadBeensList.size() > 0)
      {
        paramBundle = (PublicAccountH5AbilityPluginImpl.UploadBeen)this.uploadBeensList.get(0);
        localObject1 = (String)localIdMap.get(paramBundle.jdField_b_of_type_JavaLangString);
        startUpload(paramBundle.jdField_a_of_type_Int, (String)localObject1, true, paramBundle.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  void startUpload(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = this.pUin;
    Object localObject1;
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
      if ((this.mClient != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + HttpUtil.getNetWorkType());
        }
        if (HttpUtil.getNetWorkType() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            QQToast.a(this.activity, "你已离开wifi环境", 0).a();
          }
        }
        this.mClient.a(paramString1, paramInt, (String)localObject1, paramBoolean, new PublicAccountH5AbilityPluginImpl.22(this, paramString2, paramBoolean), new PublicAccountH5AbilityPluginImpl.23(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "12345678";
      }
    }
  }
  
  public void takePicture()
  {
    Object localObject = AppConstants.SDCARD_PATH + "c2bCAM/";
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
        callJs(this.cameraCallback, new String[] { ((JSONObject)localObject).toString() });
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
    this.cameraUUid = UUID.randomUUID().toString();
    this.cameraPath = ((String)localObject + this.cameraUUid + ".jpg");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl
 * JD-Core Version:    0.7.0.1
 */