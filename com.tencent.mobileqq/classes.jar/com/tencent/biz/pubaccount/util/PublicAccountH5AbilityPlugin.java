package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mtx;
import mty;
import mtz;
import mua;
import mub;
import muc;
import mud;
import mue;
import muf;
import muh;
import mui;
import muj;
import muk;
import mum;
import mun;
import muo;
import mup;
import muq;
import mur;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityPlugin
  extends WebViewPlugin
{
  public static HashMap a;
  public static Map a;
  public static HashMap b;
  public static Map b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String j;
  public int a;
  public Activity a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  public Handler a;
  public VideoFeedsIPCClient a;
  PublicAccountH5AbilityForPtt jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ActionSheet a;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public int b;
  String jdField_b_of_type_JavaLangString;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  int c;
  int d;
  public int e;
  public int f;
  public String i = "";
  public String k;
  public String l = "";
  public String m = "";
  public String n = "";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "publicAccountNew.getPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "qbizApi.getNetworkType");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "ui.closeWebViews");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), "ui.setOnShareQQFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), "ui.setOnShareQZoneHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), "ui.setOnShareWXFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), "ui.setOnShareWXTimelineHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8), "publicAccount.getLocation");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), "publicAccountNew.hideMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "publicAccountNew.showMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "publicAccountNew.hideAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(13), "publicAccountNew.showAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), "publicAccountNew.showWebPanel");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), "publicAccountNew.scanQRCode");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(16), "publicAccountNew.setRightButtonState");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(17), "publicAccountNew.uploadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(18), "publicAccountNew.downloadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(20), "publicAccountNew.hideWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(21), "publicAccountNew.showWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(30), "wallet.publicPay");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(40), "publicAccountNew.startRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(41), "publicAccountNew.stopRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(42), "publicAccountNew.playVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(43), "publicAccountNew.pauseVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(44), "publicAccountNew.stopVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(45), "publicAccountNew.uploadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(46), "publicAccountNew.downloadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(47), "publicAccountNew.onVoiceRecordEnd");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(48), "publicAccountNew.onVoicePlayEnd");
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public PublicAccountH5AbilityPlugin()
  {
    this.jdField_a_of_type_Int = 1281;
    this.jdField_b_of_type_Int = 1282;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = null;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new mtx(this);
    this.mPluginNameSpace = "publicAccountNew";
  }
  
  public static WebResourceResponse a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString);
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
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(this.mRuntime.a(), ReadInJoyCameraCaptureActivity.class);
    localIntent.putExtra("arg_topic_id", paramString1);
    localIntent.putExtra("arg_topic_name", paramString2);
    localIntent.putExtra("arg_ad_tag", paramInt1);
    localIntent.putExtra("arg_callback", paramString3);
    localIntent.putExtra("OPEN_ACTIVITY_KEY_VID", paramString4);
    localIntent.putExtra("OPEN_ACTIVITY_KEY_MODE", paramInt2);
    localIntent.putExtra("OPEN_ACTIVITY_KEY_VIDEO_MD5", paramString7);
    localIntent.putExtra("OPEN_ACTIVITY_KEY_VIDEO_PATH", paramString5);
    localIntent.putExtra("OPEN_ACTIVITY_KEY_COVER_PATH", paramString6);
    startActivityForResult(localIntent, (byte)116);
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString))
        {
          paramArrayList.remove(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString1)) {}
    do
    {
      do
      {
        return false;
        paramString1 = (ArrayList)jdField_a_of_type_JavaUtilMap.get(paramString1);
        if (!"QQApi.shareMsg".equals(paramString2)) {
          break;
        }
      } while ((!a(paramString1, "ui.setOnShareQQFriendHandler")) && (!a(paramString1, "ui.ui.setOnShareQZoneHandler")) && (!a(paramString1, "ui.ui.setOnShareWXFriendHandler")) && (!a(paramString1, "ui.setOnShareWXTimelineHandler")));
      return true;
    } while (!a(paramString1, paramString2));
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
  
  public static boolean a(ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static int[] a(int paramInt)
  {
    int[] arrayOfInt = new int[32];
    int i1 = 0;
    while (i1 < 32)
    {
      arrayOfInt[(31 - i1)] = (paramInt >> i1 & 0x1);
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("imageIDs");
        int i3 = ((JSONObject)localObject2).optInt("index");
        String str1 = ((JSONObject)localObject2).optString("srcID");
        boolean bool1 = ((JSONObject)localObject2).optBoolean("isNotShowIndex", true);
        boolean bool2 = ((JSONObject)localObject2).optBoolean("showTitle", false);
        String str2 = new String(Base64Util.decode(((JSONObject)localObject2).optString("title", ""), 0));
        String str3 = ((JSONObject)localObject2).optString("articleUrl", "");
        boolean bool3 = ((JSONObject)localObject2).optBoolean("isReport", false);
        long l1 = ((JSONObject)localObject2).optLong("touin");
        long l2 = ((JSONObject)localObject2).optLong("feeds_id");
        int i4 = ((JSONObject)localObject2).optInt("feeds_type");
        long l3 = ((JSONObject)localObject2).optLong("articleId");
        int i5 = ((JSONObject)localObject2).optInt("source");
        if (localObject1 == null) {
          break label632;
        }
        i1 = ((JSONArray)localObject1).length();
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
          int i2 = 0;
          if (i2 < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).get(i2).toString());
            i2 += 1;
            continue;
          }
          if (this.jdField_a_of_type_AndroidAppActivity == null) {
            break;
          }
          localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", i3);
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
          localBundle.putString("scroll_image_r5", ReadInJoyUtils.a(i1, Integer.toString(i5), i4, "", ""));
          localBundle.putString("read_article_r5", ReadInJoyUtils.a(i1, Integer.toString(i5), i4, ""));
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
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 100);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = null;
      continue;
      label632:
      int i1 = 0;
    }
  }
  
  private void e(String paramString)
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
      QRUtils.a(1, 2131437295);
      return;
    }
    localObject = new QQProgressDialog(this.mRuntime.a());
    ((QQProgressDialog)localObject).c(2131435466);
    ((QQProgressDialog)localObject).show();
    ThreadManager.executeOnSubThread(new muf(this, paramString, localBundle, (QQProgressDialog)localObject));
  }
  
  public ArrayList a()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
    if (localSwiftBrowserShareMenuHandler != null) {
      return localSwiftBrowserShareMenuHandler.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = VideoFeedsIPCClient.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localIntent.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", "确定");
    if (paramInt2 == 1)
    {
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 2);
      if (paramInt2 != 0) {
        break label165;
      }
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.quality_count_tv", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().a(this, localIntent, (byte)111);
      }
      return;
      if (paramInt2 != 2) {
        break;
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label165:
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.putExtra("PhotoConst.quality_count_tv", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970481, null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131362087);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131370832);
    localObject = (TextView)((View)localObject).findViewById(2131370833);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      localTextView1.setOnClickListener(new mty(this, paramString));
      localTextView2.setOnClickListener(new mtz(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new mua(this));
      return;
      if (paramInt1 == 2)
      {
        ((TextView)localObject).setVisibility(8);
        localTextView1.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str3 = this.i;
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
      if ((this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) && (!"".equals(paramString1))) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramString1, paramInt, str1, paramBoolean, new mud(this, paramBoolean, paramString3, paramString2), new mue(this));
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
  
  void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = this.i;
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
      if ((this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + HttpUtil.a());
        }
        if (HttpUtil.a() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "你已离开wifi环境", 0).a();
          }
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramInt, (String)localObject1, paramBoolean, new mub(this, paramString2, paramBoolean), new muc(this));
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
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("pic_local_path");
    if (paramBundle != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
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
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          mur localmur = (mur)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localmur.jdField_b_of_type_JavaLangString)) {
            paramBundle.add(localmur);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramBundle);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        paramBundle = (mur)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramBundle.jdField_b_of_type_JavaLangString);
        a(paramBundle.jdField_a_of_type_Int, (String)localObject1, true, paramBundle.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  void a(String paramString)
  {
    this.i = "";
    if (paramString != null) {
      jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("7.6.0,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_b_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.i);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new muo(this, paramString2, paramInt, paramBoolean, paramString1));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
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
  
  void a(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("7.6.0,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + paramString2);
    }
    localNewIntent.setObserver(new mup(this, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("7.6.0,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_a_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("puin", this.i);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      catch (JSONException paramString1)
      {
        PublicAccountH5AbilityForPtt localPublicAccountH5AbilityForPtt;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new mun(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.h();
      localJSONObject.put("file_uuid", paramString1);
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_md5", PublicAccountH5AbilityForPtt.b());
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_name", PublicAccountH5AbilityForPtt.c());
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_size", PublicAccountH5AbilityForPtt.b());
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_time", PublicAccountH5AbilityForPtt.c());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        paramString1 = paramString1.append(PublicAccountH5AbilityForPtt.b()).append(" file_name:");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        paramString1 = paramString1.append(PublicAccountH5AbilityForPtt.c()).append(" file_size=");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        paramString1 = paramString1.append(PublicAccountH5AbilityForPtt.b()).append(" file_time=");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        QLog.i("PublicAccountH5AbilityPlugin", 2, PublicAccountH5AbilityForPtt.c());
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!a(a(), str)) {
        a().add(str);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().l(paramBoolean);
      }
      return;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.f();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("fromBrowser", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void b(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      a(a(), str);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PoiMapActivity.class).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c();
  }
  
  public void c(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        muq localmuq = (muq)localIterator.next();
        if (paramString.equals(localmuq.jdField_b_of_type_JavaLangString)) {
          localArrayList.add(localmuq);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      paramString = (muq)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      a(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramString.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void d()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().b();
    }
  }
  
  public void e()
  {
    a().clear();
    a().add("menuItem:share:qq");
    a().add("menuItem:share:QZone");
    a().add("menuItem:share:appMessage");
    a().add("menuItem:share:timeline");
    a().add("menuItem:openWithQQBrowser");
    a().add("menuItem:openWithSafari");
    a().add("menuItem:favorite");
    a().add("menuItem:copyUrl");
  }
  
  public void f()
  {
    a().clear();
  }
  
  public void g()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().a(false);
    }
  }
  
  public void h()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().a(true);
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (paramMap != null)
      {
        int i1 = ((Integer)paramMap.get("requestCode")).intValue();
        if ((i1 == 1) || (i1 == 113) || (i1 == 114) || (i1 == 115) || (i1 == 116) || (i1 == 117))
        {
          int i2 = ((Integer)paramMap.get("resultCode")).intValue();
          onActivityResult((Intent)paramMap.get("data"), (byte)i1, i2);
          return true;
        }
      }
    }
    else if (paramLong == 8589934597L) {
      b();
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1;
    if ("publicAccountNew".endsWith(paramString2))
    {
      if ("openLocation".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          c();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005869", "0X8005869", 0, 0, "", "", "", "");
        return true;
      }
      if ("showOfficialAccountProfile".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
          if (!"".equals(paramJsBridgeListener)) {
            b(paramJsBridgeListener);
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("showWebPanel".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          d();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("setRightButtonState".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          bool1 = paramJsBridgeListener.optBoolean("hidden");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          a(bool1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("hideMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i1 = 0;
            while (i1 < paramString2.length())
            {
              paramString1.add(paramString2.optString(i1));
              i1 += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          a(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586E", "0X800586E", 0, 0, "", "", "", "");
        return true;
      }
      if ("showMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i1 = 0;
            while (i1 < paramString2.length())
            {
              paramString1.add(paramString2.optString(i1));
              i1 += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          b(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586F", "0X800586F", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          e();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005870", "0X8005870", 0, 0, "", "", "", "");
        return true;
      }
      if ("showAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          f();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005871", "0X8005871", 0, 0, "", "", "", "");
        return true;
      }
      if ("showWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          h();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005898", "0X8005898", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          g();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005897", "0X8005897", 0, 0, "", "", "", "");
        return true;
      }
      if ("uploadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("localId");
          i1 = paramString2.optInt("isShowProgressTips", 1);
          paramString2 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString1);
          paramString3 = new File(paramString2);
          if ((paramString3 == null) || (!paramString3.exists()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "文件不存在" + paramString2, 0).a();
            return true;
          }
          if (paramString3.length() > 2097152L)
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择小于2M文件" + paramString2, 0).a();
            return true;
          }
          paramString3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramString3.hasNext())
          {
            paramVarArgs = (mur)paramString3.next();
            if ((paramString1 != null) && (paramString1.equals(paramVarArgs.jdField_b_of_type_JavaLangString)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "任务已经在上传队列", 0).a();
              return true;
            }
          }
          paramString3 = new mur();
          paramString3.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString3.jdField_b_of_type_JavaLangString = paramString1;
          paramString3.jdField_a_of_type_Int = i1;
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
            break label1665;
          }
          a(i1, paramString2, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, 2, "1", "", "", "", false);
        return true;
        label1665:
        return true;
      }
      if ("downloadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("serverId");
          i1 = paramString2.optInt("isShowProgressTips", 1);
          if (("".equals(paramJsBridgeListener)) || ("".equals(paramString1)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "callback or mediaId is null", 0).a();
            return true;
          }
          paramString2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          while (paramString2.hasNext())
          {
            paramString3 = (muq)paramString2.next();
            if ((paramString1 != null) && (paramString1.equals(paramString3.jdField_b_of_type_JavaLangString)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "任务已经在下载队列", 0).a();
              return true;
            }
          }
          paramString2 = new muq();
          paramString2.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString2.jdField_b_of_type_JavaLangString = paramString1;
          paramString2.jdField_a_of_type_Int = i1;
          this.jdField_b_of_type_JavaUtilArrayList.add(paramString2);
          if (this.jdField_b_of_type_JavaUtilArrayList.size() != 1) {
            break label1915;
          }
          a(paramString1, i1, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 2, "1", "", "", "");
        return true;
        label1915:
        return true;
      }
      if ("uploadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label8928;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("localId");
            i1 = paramString1.optInt("isShowProgressTips", 1);
            bool1 = TextUtils.isEmpty(paramString2);
            if (bool1) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "file not exists");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) {
              break label2118;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
          label2118:
          paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramString2);
          paramString2 = new File(paramString1);
          if (!paramString2.exists())
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "file not exists");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if (paramString2.length() > 5242880L)
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "请上传5MB以内的音频");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
          else
          {
            a(i1, paramString1, false, paramJsBridgeListener);
          }
        }
      }
      if ("downloadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label8930;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("serverId");
            i1 = paramString1.optInt("isShowProgressTips", 1);
            bool1 = TextUtils.isEmpty(paramString2);
            if (bool1) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "invalid serverId");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            a(paramString2, i1, false, paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("getPicture".endsWith(paramString3)) {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label8939;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("callback");
        i3 = paramString2.optInt("count");
        if (i3 > 9) {
          break label8932;
        }
        if (i3 >= 1) {
          break label8925;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        break;
      }
      paramString1 = paramString2.optJSONArray("sizeType");
      paramString2 = paramString2.optJSONArray("sourceType");
      if ((paramString2 != null) && (paramString2.length() == 1))
      {
        paramString2 = paramString2.optString(0);
        int i4;
        if ("camera".equalsIgnoreCase(paramString2))
        {
          i1 = 1;
          i4 = 0;
          i2 = i4;
          if (paramString1 != null)
          {
            i2 = i4;
            if (paramString1.length() == 1)
            {
              paramString1 = paramString1.optString(0);
              if (!"original".equalsIgnoreCase(paramString1)) {
                continue;
              }
              i2 = 1;
            }
          }
          a(i1, i2, paramJsBridgeListener, i3);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
          break;
        }
        else
        {
          if (!"album".equalsIgnoreCase(paramString2)) {
            break label8919;
          }
          i1 = 2;
          continue;
        }
        bool1 = "compressed".equalsIgnoreCase(paramString1);
        int i2 = i4;
        if (!bool1) {
          continue;
        }
        i2 = 2;
        continue;
        if ("startRecord".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            jdField_c_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).optString("callback");
            if (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString))
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b();
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          return true;
        }
        if ("stopRecord".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          for (;;)
          {
            try
            {
              jdField_d_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).optString("callback");
              if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.a())) {
                continue;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.c();
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 2, "1", "", "", "");
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              continue;
            }
            return true;
            try
            {
              paramJsBridgeListener = new JSONObject();
              paramJsBridgeListener.put("retCode", -1);
              paramJsBridgeListener.put("msg", "fail");
              callJs(jdField_d_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("playVoice".endsWith(paramString3))
        {
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            break label8941;
          }
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              jdField_e_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
              paramJsBridgeListener = paramJsBridgeListener.optString("localId");
              if (!TextUtils.isEmpty(jdField_e_of_type_JavaLangString))
              {
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  break label3318;
                }
                if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b())) {
                  return true;
                }
                if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                  this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
                }
                paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramJsBridgeListener);
                paramJsBridgeListener = new JSONObject();
                if (new File(paramString1).exists()) {
                  this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramString1);
                }
              }
              else
              {
                try
                {
                  paramJsBridgeListener.put("retCode", 0);
                  paramJsBridgeListener.put("msg", "success");
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 0, "1", "", "", "");
                  callJs(jdField_e_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 2, "1", "", "", "");
                }
                catch (JSONException paramString1)
                {
                  paramString1.printStackTrace();
                  continue;
                }
              }
              try
              {
                paramJsBridgeListener.put("retCode", -1);
                paramJsBridgeListener.put("msg", "file not exists");
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, -1, "1", "", "", "");
              }
              catch (JSONException paramString1)
              {
                for (;;)
                {
                  paramString1.printStackTrace();
                }
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            label3318:
            paramJsBridgeListener = new JSONObject();
            try
            {
              paramJsBridgeListener.put("retCode", -1);
              paramJsBridgeListener.put("msg", "missing arguments");
              callJs(jdField_e_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("pauseVoice".endsWith(paramString3))
        {
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            break label8943;
          }
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString1 = paramString1.optString("localId");
            if (!TextUtils.isEmpty(paramString1))
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramString1);
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b())
              {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.g();
                paramString1 = new JSONObject();
              }
            }
            try
            {
              paramString1.put("retCode", 0);
              paramString1.put("msg", "success");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 0, "1", "", "", "");
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 2, "1", "", "", "");
            }
            catch (JSONException paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
            if (!"stopVoice".endsWith(paramString3)) {
              break label3782;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            jdField_f_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
            paramJsBridgeListener = paramJsBridgeListener.optString("localId");
            if (!TextUtils.isEmpty(paramJsBridgeListener))
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramJsBridgeListener);
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.e();
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 0, "1", "", "", "");
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          return true;
        }
        label3782:
        if ("onVoiceRecordEnd".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            g = new JSONObject(paramVarArgs[0]).optString("callback");
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("onVoicePlayEnd".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            h = new JSONObject(paramVarArgs[0]).optString("callback");
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("config".endsWith(paramString3))
        {
          if (this.jdField_a_of_type_Boolean) {
            return true;
          }
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            j = paramString1.optString("appId");
            paramString1.put("appver", "7.6.0");
            paramJsBridgeListener = this.mRuntime.a();
            if (paramJsBridgeListener == null) {
              break label8914;
            }
            paramJsBridgeListener = paramJsBridgeListener.getUrl();
            paramString1.put("url", paramJsBridgeListener);
            paramString2 = paramString1.toString();
            this.k = paramString1.optString("callback");
            paramString1 = paramString1.optJSONArray("jsApiList");
            paramString3 = new ArrayList();
            if (paramString1 != null)
            {
              paramString3.clear();
              i1 = 0;
              if (i1 < paramString1.length())
              {
                paramString3.add(paramString1.optString(i1));
                i1 += 1;
                continue;
              }
            }
            jdField_a_of_type_JavaUtilMap.remove(paramJsBridgeListener);
            jdField_b_of_type_JavaUtilMap.put(paramJsBridgeListener, paramString3);
            if (paramJsBridgeListener != null) {
              a(paramJsBridgeListener, paramString2);
            }
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          long l2;
          long l3;
          long l5;
          long l4;
          for (;;)
          {
            return false;
            if ("isEnabledRightButton".endsWith(paramString3))
            {
              try
              {
                paramString1 = new JSONObject(paramVarArgs[0]);
                paramJsBridgeListener = paramString1.optString("callback");
                i1 = paramString1.optInt("status");
                if ((this.mRuntime.a() != null) && (this.mRuntime.a().a != null) && (this.mRuntime.a().a.a != null)) {
                  this.mRuntime.a().a.a.a(i1);
                }
                paramString1 = new JSONObject();
                paramString1.put("retCode", 0);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
            else
            {
              if ("reportpreloaddata".endsWith(paramString3))
              {
                if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
                try
                {
                  paramString1 = new JSONObject(paramVarArgs[0]);
                  paramJsBridgeListener = paramString1.optString("callback");
                  paramString2 = paramString1.optString("url");
                  if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString2)))
                  {
                    paramString1 = new JSONObject();
                    paramString1.put("retCode", 0);
                    paramString1.put("msg", "Success");
                    boolean bool2 = false;
                    paramString2 = PreloadManager.a(paramString2);
                    bool1 = bool2;
                    if (paramString2 != null)
                    {
                      bool1 = bool2;
                      if (new File(AppConstants.cn, paramString2).exists()) {
                        bool1 = true;
                      }
                    }
                    paramString1.put("hit", bool1);
                    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
                    if (paramString2 != null)
                    {
                      paramString2 = (AppInterface)paramString2.getAppRuntime("modular_web");
                      if (paramString2 != null)
                      {
                        paramString2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramString2.getCurrentAccountUin(), 4);
                        if (paramString2 != null)
                        {
                          bool1 = paramString2.getBoolean("kandian_feeds_preload", false);
                          bool2 = paramString2.getBoolean("kandian_feeds_preload_wifi", false);
                          boolean bool3 = paramString2.getBoolean("kandian_feeds_preload_4G", false);
                          boolean bool4 = paramString2.getBoolean("kandian_feeds_preload_3G", false);
                          boolean bool5 = paramString2.getBoolean("kandian_feeds_preload_2G", false);
                          paramString1.put("readInJoyPreload", bool1);
                          paramString1.put("readInJoyPreloadWifi", bool2);
                          paramString1.put("readInJoyPreload4G", bool3);
                          paramString1.put("readInJoyPreload3G", bool4);
                          paramString1.put("readInJoyPreload2G", bool5);
                          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                          if (QLog.isColorLevel()) {
                            QLog.i("PublicAccountH5AbilityPlugin", 2, "reportpreloaddata" + paramString1.toString());
                          }
                        }
                      }
                    }
                  }
                }
                catch (JSONException paramJsBridgeListener)
                {
                  for (;;)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                }
                return true;
              }
              if ("showOnlyShareMenu".endsWith(paramString3))
              {
                paramJsBridgeListener = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
                if (paramJsBridgeListener != null)
                {
                  paramString1 = this.mRuntime.a();
                  if (paramString1 != null)
                  {
                    paramString1.b();
                    if ((paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b != null)) {
                      paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b.setVisibility(8);
                    }
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.i("PublicAccountH5AbilityPlugin", 2, "showOnlyShareMenu");
                }
                return true;
              }
              Object localObject3;
              Object localObject1;
              if ("showMultiBiuEditPage".endsWith(paramString3))
              {
                if ((paramVarArgs != null) && (paramVarArgs.length > 0))
                {
                  long l1;
                  int i5;
                  for (;;)
                  {
                    try
                    {
                      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
                        break;
                      }
                      localObject3 = new JSONObject(paramVarArgs[0]);
                      if (QLog.isColorLevel()) {
                        QLog.i("PublicAccountH5AbilityPlugin", 2, "web json:" + ((JSONObject)localObject3).toString());
                      }
                      localObject2 = ((JSONObject)localObject3).optString("title");
                      paramString2 = ((JSONObject)localObject3).optString("sourceName");
                      i4 = ((JSONObject)localObject3).optInt("hiddenBiuComponent");
                      paramVarArgs = "";
                      if (i4 == 1) {
                        paramVarArgs = new String(Base64Util.decode(((JSONObject)localObject3).optString("newComment"), 2));
                      }
                      l2 = 0L;
                      l3 = 0L;
                      l7 = 0L;
                      l8 = 0L;
                      localObject1 = "";
                    }
                    catch (JSONException paramJsBridgeListener)
                    {
                      long l8;
                      Object localObject5;
                      paramJsBridgeListener.printStackTrace();
                    }
                    for (;;)
                    {
                      try
                      {
                        paramJsBridgeListener = new String(Base64Util.decode((String)localObject2, 0));
                      }
                      catch (Exception paramString3)
                      {
                        int i6;
                        Object localObject6;
                        Object localObject7;
                        paramString1 = paramString2;
                        paramJsBridgeListener = "";
                        l6 = l7;
                        paramString2 = (String)localObject2;
                        break;
                        i1 = 1;
                        continue;
                        if (i6 == 4) {
                          continue;
                        }
                        if (i6 != 5) {
                          continue;
                        }
                        continue;
                        i1 = 2;
                        continue;
                        continue;
                        if (i3 != 11) {
                          continue;
                        }
                        i1 = 5;
                        continue;
                        if (i3 != 6) {
                          continue;
                        }
                        i1 = 6;
                        continue;
                        if (i3 != 12) {
                          continue;
                        }
                        i1 = 7;
                        continue;
                        if (i3 != 13) {
                          continue;
                        }
                        i1 = 8;
                        continue;
                        i1 = i3;
                        if (i3 >= 15) {
                          continue;
                        }
                        i1 = 3;
                        continue;
                      }
                      try
                      {
                        paramString1 = new String(Base64Util.decode(paramString2, 0));
                      }
                      catch (Exception paramString3)
                      {
                        localObject2 = paramJsBridgeListener;
                        paramJsBridgeListener = "";
                        paramString1 = paramString2;
                        l6 = l7;
                        paramString2 = (String)localObject2;
                        break;
                      }
                    }
                    try
                    {
                      paramString2 = ((JSONObject)localObject3).optString("feedsId");
                      paramString3 = ((JSONObject)localObject3).optString("rowkey");
                      localObject1 = paramString3;
                      l1 = l2;
                      l6 = l7;
                      l5 = l3;
                      l4 = l2;
                    }
                    catch (Exception paramString3)
                    {
                      localObject2 = "";
                      paramString2 = paramJsBridgeListener;
                      paramJsBridgeListener = (JsBridgeListener)localObject2;
                      l6 = l7;
                      continue;
                    }
                    try
                    {
                      if (!TextUtils.isEmpty(paramString2))
                      {
                        l6 = l7;
                        l5 = l3;
                        l4 = l2;
                        l1 = new BigInteger(paramString2).longValue();
                      }
                      l6 = l7;
                      l5 = l3;
                      l4 = l1;
                      paramString3 = ((JSONObject)localObject3).optString("ariticleId");
                      l2 = l3;
                      l6 = l7;
                      l5 = l3;
                      l4 = l1;
                      if (!TextUtils.isEmpty(paramString3))
                      {
                        l6 = l7;
                        l5 = l3;
                        l4 = l1;
                        l2 = new BigInteger(paramString3).longValue();
                      }
                      l6 = l7;
                      l5 = l2;
                      l4 = l1;
                      paramString3 = ((JSONObject)localObject3).optString("originFeedsId");
                      l3 = l7;
                      l6 = l7;
                      l5 = l2;
                      l4 = l1;
                      if (!TextUtils.isEmpty(paramString3))
                      {
                        l6 = l7;
                        l5 = l2;
                        l4 = l1;
                        l3 = new BigInteger(paramString3).longValue();
                      }
                      l6 = l3;
                      l5 = l2;
                      l4 = l1;
                      paramString3 = ((JSONObject)localObject3).optString("businessId");
                      l7 = l8;
                      l6 = l3;
                      l5 = l2;
                      l4 = l1;
                      if (!TextUtils.isEmpty(paramString3))
                      {
                        l6 = l3;
                        l5 = l2;
                        l4 = l1;
                        l7 = new BigInteger(paramString3).longValue();
                      }
                      paramString3 = (String)localObject1;
                      l4 = l3;
                      localObject1 = paramString2;
                      paramString2 = paramString3;
                      paramString3 = paramJsBridgeListener;
                      l3 = l2;
                      l2 = l4;
                      paramJsBridgeListener = (JsBridgeListener)localObject1;
                      l4 = ((JSONObject)localObject3).optLong("originFeedsType", 1L);
                      i1 = ((JSONObject)localObject3).optInt("type");
                      i3 = ((JSONObject)localObject3).optInt("adtag");
                      localObject4 = ((JSONObject)localObject3).optString("picurl");
                      i2 = ((JSONObject)localObject3).optInt("duration");
                      localObject2 = ((JSONObject)localObject3).optString("callback");
                      localObject5 = new String(Base64Util.decode(((JSONObject)localObject3).optString("accountDesc"), 0));
                      i5 = ((JSONObject)localObject3).optInt("feedsType", 1);
                      localObject1 = new ArticleInfo();
                      ((ArticleInfo)localObject1).mArticleID = l3;
                      ((ArticleInfo)localObject1).mTitle = paramString3;
                      ((ArticleInfo)localObject1).mSubscribeName = paramString1;
                      ((ArticleInfo)localObject1).mFirstPagePicUrl = ((String)localObject4);
                      ((ArticleInfo)localObject1).mVideoDuration = i2;
                      ((ArticleInfo)localObject1).mFeedId = l1;
                      ((ArticleInfo)localObject1).mSummary = ((String)localObject5);
                      ((ArticleInfo)localObject1).businessId = l7;
                      ((ArticleInfo)localObject1).mFeedType = i5;
                    }
                    catch (Exception paramString3)
                    {
                      localObject2 = paramJsBridgeListener;
                      paramJsBridgeListener = paramString2;
                      l3 = l5;
                      l2 = l4;
                      paramString2 = (String)localObject2;
                      continue;
                      i2 = 0;
                      break label8013;
                      i1 = -1;
                      break label7991;
                      paramString1 = "";
                      break label7969;
                      paramJsBridgeListener = "";
                      break label7934;
                      bool1 = false;
                      break label7899;
                      paramJsBridgeListener = paramVarArgs;
                      break label6463;
                      paramString1 = "";
                      break label6244;
                    }
                    try
                    {
                      paramString1 = ((JSONObject)localObject3).getJSONArray("biuLevelList");
                      ((ArticleInfo)localObject1).mSocialFeedInfo = new SocializeFeedsInfo();
                      localObject4 = ((ArticleInfo)localObject1).mSocialFeedInfo;
                      localObject5 = ((ArticleInfo)localObject1).mSocialFeedInfo;
                      localObject5.getClass();
                      ((SocializeFeedsInfo)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo((SocializeFeedsInfo)localObject5);
                      ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(l2);
                      ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(l4);
                      ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
                      if (paramString1 == null) {
                        break label5728;
                      }
                      i2 = 0;
                      if (i2 >= paramString1.length()) {
                        break label5728;
                      }
                      localObject4 = ((ArticleInfo)localObject1).mSocialFeedInfo;
                      localObject4.getClass();
                      localObject4 = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject4);
                      localObject5 = paramString1.getJSONObject(i2);
                      ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject5).optLong("uin"));
                      ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_b_of_type_JavaLangString = new String(Base64Util.decode(((JSONObject)localObject5).optString("comment"), 0));
                      ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_a_of_type_Int = ((JSONObject)localObject5).optInt("biuTime");
                      ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_b_of_type_Int = ((JSONObject)localObject5).optInt("feeds_type", 1);
                      ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_c_of_type_Int = ((JSONObject)localObject5).optInt("op_type");
                      if (i4 == 1) {
                        ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_b_of_type_JavaLangString;
                      }
                    }
                    catch (JSONException paramString1)
                    {
                      try
                      {
                        localObject5 = ((JSONObject)localObject5).optString("feedsId");
                        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                          ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject5).longValue());
                        }
                        ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject4);
                        i2 += 1;
                        continue;
                        paramString3.printStackTrace();
                        l1 = l2;
                        l7 = l8;
                        l2 = l6;
                        paramString3 = paramString2;
                        paramString2 = (String)localObject1;
                        continue;
                        paramString1 = paramString1;
                        paramString1.printStackTrace();
                        paramString1 = null;
                      }
                      catch (Exception localException1)
                      {
                        localException1.printStackTrace();
                      }
                    }
                  }
                  continue;
                  label5728:
                  localObject3 = ((JSONObject)localObject3).optJSONObject("ugcInfo");
                  if ((localObject3 == null) || ((i5 != 4) && (i5 != 5) && ((i5 != 1) || ((l4 != 4L) && (l4 != 5L))))) {
                    break label8908;
                  }
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
                  i6 = ((JSONObject)localObject3).optInt("ugcType", 0);
                  paramString1 = ((JSONObject)localObject3).optString("ugcComment");
                  Object localObject4 = ((JSONObject)localObject3).optJSONArray("ugcAtLevelList");
                  if (localObject4 != null)
                  {
                    localObject6 = ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
                    localObject7 = ((ArticleInfo)localObject1).mSocialFeedInfo;
                    localObject7.getClass();
                    ((SocializeFeedsInfo.UGCFeedsInfo)localObject6).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo((SocializeFeedsInfo)localObject7);
                    ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
                    i2 = 0;
                    for (;;)
                    {
                      if (i2 < ((JSONArray)localObject4).length())
                      {
                        localObject6 = ((ArticleInfo)localObject1).mSocialFeedInfo;
                        localObject6.getClass();
                        localObject6 = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject6);
                        localObject7 = ((JSONArray)localObject4).getJSONObject(i2);
                        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject7).optLong("uin"));
                        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_b_of_type_JavaLangString = new String(Base64Util.decode(((JSONObject)localObject7).optString("comment"), 0));
                        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_a_of_type_Int = ((JSONObject)localObject7).optInt("biuTime");
                        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_b_of_type_Int = ((JSONObject)localObject7).optInt("feeds_type", 1);
                        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_c_of_type_Int = ((JSONObject)localObject7).optInt("op_type");
                        try
                        {
                          localObject7 = ((JSONObject)localObject7).optString("feedsId");
                          if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                            ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject7).longValue());
                          }
                          ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject6);
                          i2 += 1;
                        }
                        catch (Exception localException2)
                        {
                          for (;;)
                          {
                            localException2.printStackTrace();
                          }
                        }
                      }
                    }
                  }
                  ((ArticleInfo)localObject1).mTitle = new String(Base64Util.decode(paramString1, 0));
                  ((ArticleInfo)localObject1).mSummary = "";
                  if ((i6 != 3) && (i6 != 2)) {
                    break label8968;
                  }
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                  paramString3 = new SocializeFeedsInfo.UGCPicInfo();
                  localObject3 = ((JSONObject)localObject3).optJSONArray("ugcPicInfo");
                  if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
                    break label8962;
                  }
                  paramString3.jdField_c_of_type_JavaLangString = ((JSONArray)localObject3).getJSONObject(0).optString("ugcPicUrl");
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
                  break label8962;
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = i6;
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString = ((ArticleInfo)localObject1).mTitle;
                  label6244:
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
                  ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
                  paramString3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
                  paramString3.putExtra("arg_article_info", (Parcelable)localObject1);
                  if (!TextUtils.isEmpty(paramString2)) {
                    paramString3.putExtra("biu_rowkey", paramString2);
                  }
                  paramString3.putExtra("arg_from_type", i3);
                  paramString3.putExtra("arg_type", i1);
                  paramString3.putExtra("result_js_callback", (String)localObject2);
                  if (i3 != 5) {
                    break label8992;
                  }
                  i1 = 4;
                  paramString3.putExtra("biu_src", i1);
                  paramString3.putExtra("feed_id", paramJsBridgeListener);
                  paramString3.putExtra("feedsType", i5);
                  paramString3.putExtra("ugc_comment", paramString1);
                  if (i4 == 1)
                  {
                    if ((((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList == null) || (((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() <= 0)) {
                      break label8902;
                    }
                    paramJsBridgeListener = paramVarArgs + "//";
                    label6463:
                    paramJsBridgeListener = "：" + paramJsBridgeListener;
                    ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a().a(this.mRuntime.a().getLongAccountUin(), l1, ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo, 0L, paramJsBridgeListener, l3, -1L, i1, paramString2, i5, (ArticleInfo)localObject1);
                    continue;
                    ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
                    localObject4 = new SocializeFeedsInfo.UGCVideoInfo();
                    localObject3 = ((JSONObject)localObject3).optJSONObject("ugcVideoInfo");
                    if (localObject3 == null) {
                      break label8983;
                    }
                    ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_d_of_type_JavaLangString = ((JSONObject)localObject3).optString("ugcVideoCoverUrl");
                    ((SocializeFeedsInfo.UGCVideoInfo)localObject4).a = ((JSONObject)localObject3).optInt("ugcVideoDuration");
                    ((SocializeFeedsInfo.UGCVideoInfo)localObject4).jdField_e_of_type_JavaLangString = paramString3;
                    ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject4);
                    break label8983;
                    if (i6 != 1) {
                      break label8989;
                    }
                    ((ArticleInfo)localObject1).mFirstPagePicUrl = "";
                    break label8989;
                  }
                  else
                  {
                    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString3, 113);
                    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
                  }
                }
              }
              else
              {
                if ("showUGCEditPage".endsWith(paramString3))
                {
                  if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
                    continue;
                  }
                  try
                  {
                    if (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
                      continue;
                    }
                    paramString3 = new JSONObject(paramVarArgs[0]);
                    if (QLog.isColorLevel()) {
                      QLog.i("PublicAccountH5AbilityPlugin", 2, "showUGCEditPage param json:" + paramString3.toString());
                    }
                    paramString2 = paramString3.optString("topicId");
                    paramJsBridgeListener = paramString3.optString("topicName");
                    i1 = paramString3.optInt("adtag");
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    label6797:
                    paramJsBridgeListener.printStackTrace();
                  }
                  try
                  {
                    paramString1 = new String(Base64Util.decode(paramJsBridgeListener, 0));
                    paramJsBridgeListener = paramString1;
                  }
                  catch (Exception paramString1)
                  {
                    paramString1.printStackTrace();
                    break label6797;
                  }
                  paramString1 = paramString3.optString("callback");
                  paramString3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverUGCActivity.class);
                  paramString3.putExtra("arg_topic_id", paramString2);
                  paramString3.putExtra("arg_topic_name", paramJsBridgeListener);
                  paramString3.putExtra("arg_ad_tag", i1);
                  paramString3.putExtra("arg_callback", paramString1);
                  this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString3, 114);
                  continue;
                  continue;
                }
                if ("showUGCVideoUploadPage".equals(paramString3))
                {
                  label6993:
                  try
                  {
                    paramString3 = new JSONObject(paramVarArgs[0]);
                    if (QLog.isColorLevel()) {
                      QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoUploadPage() param json:" + paramString3.toString());
                    }
                    paramString2 = paramString3.optString("topicId");
                    paramJsBridgeListener = paramString3.optString("topicName");
                    i1 = paramString3.optInt("adtag");
                  }
                  catch (Exception paramJsBridgeListener) {}
                  try
                  {
                    paramString1 = new String(Base64Util.decode(paramJsBridgeListener, 0));
                    paramJsBridgeListener = paramString1;
                  }
                  catch (Exception paramString1)
                  {
                    paramString1.printStackTrace();
                    break label6993;
                  }
                  paramString1 = paramString3.optString("callback");
                  paramString3 = new Intent(this.mRuntime.a(), PhotoListActivity.class);
                  paramString3.putExtra("arg_topic_id", paramString2);
                  paramString3.putExtra("arg_topic_name", paramJsBridgeListener);
                  paramString3.putExtra("arg_ad_tag", i1);
                  paramString3.putExtra("arg_callback", paramString1);
                  paramString3.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
                  paramString3.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
                  paramString3.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000));
                  paramString3.putExtra("readinjoy_video", true);
                  paramString3.putExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
                  paramString3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "PublicAccountH5AbilityPlugin");
                  paramString3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                  startActivityForResult(paramString3, (byte)115);
                  PublicAccountReportUtils.a(null, "", "0X80081D3", "0X80081D3", 0, 0, "", "", "", VideoReporter.a(null), false);
                  continue;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoUploadPage() Exception=" + paramJsBridgeListener.getMessage());
                  continue;
                }
                if ("showUGCVideoRecordPage".equals(paramString3))
                {
                  if (!CaptureUtil.a())
                  {
                    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, "暂不支持该机型", null, this.jdField_a_of_type_AndroidAppActivity.getString(2131432999), new muj(this), null).show();
                    return false;
                  }
                  label7432:
                  try
                  {
                    localObject3 = new JSONObject(paramVarArgs[0]);
                    if (QLog.isColorLevel()) {
                      QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage param json:" + ((JSONObject)localObject3).toString());
                    }
                    paramString2 = ((JSONObject)localObject3).optString("topicId");
                    i1 = ((JSONObject)localObject3).optInt("adtag");
                    i2 = ((JSONObject)localObject3).optInt("mode");
                    paramString3 = ((JSONObject)localObject3).optString("vid");
                    paramVarArgs = ((JSONObject)localObject3).optString("videourl");
                    localObject1 = ((JSONObject)localObject3).optString("coverurl");
                    localObject2 = ((JSONObject)localObject3).optString("md5");
                    paramJsBridgeListener = ((JSONObject)localObject3).optString("topicName");
                  }
                  catch (Exception paramJsBridgeListener) {}
                  try
                  {
                    paramString1 = new String(Base64Util.decode(paramJsBridgeListener, 0));
                    paramJsBridgeListener = paramString1;
                  }
                  catch (Exception paramString1)
                  {
                    paramString1.printStackTrace();
                    break label7432;
                    a(paramString2, paramJsBridgeListener, i1, i2, (String)localObject3, paramString3, paramVarArgs, (String)localObject1, (String)localObject2);
                  }
                  localObject3 = ((JSONObject)localObject3).optString("callback");
                  bool1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage isSoReady=" + bool1);
                  }
                  if (!bool1)
                  {
                    paramString1 = new QQProgressDialog(this.mRuntime.a(), this.mRuntime.a().getResources().getDimensionPixelSize(2131558448));
                    paramString1.c(2131438887);
                    paramJsBridgeListener = new muk(this, paramString1, paramString2, paramJsBridgeListener, i1, i2, (String)localObject3, paramString3, paramVarArgs, (String)localObject1, (String)localObject2);
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a(paramJsBridgeListener);
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_CAMERA_CAPTURE_SO_DOWNLOAD", null);
                    paramString1.a(new mum(this, paramJsBridgeListener));
                    paramString1.show();
                    continue;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() Exception=" + paramJsBridgeListener.getMessage());
                  }
                }
                else if ("sharePicToWeChatCircle".equals(paramString3))
                {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("pictureUrl");
                    if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                      break label7738;
                    }
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("PublicAccountH5AbilityPlugin", 2, "url is null");
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                  continue;
                  label7738:
                  e(paramJsBridgeListener);
                }
                else if ("updateTopicCardFollowInfo".equals(paramString3))
                {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                    i1 = paramJsBridgeListener.getInt("topicId");
                    i2 = paramJsBridgeListener.getInt("followInfo");
                    if (QLog.isColorLevel()) {
                      QLog.d("PublicAccountH5AbilityPlugin", 2, "topic id = " + i1 + "\t follow info =" + i2);
                    }
                    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(i1, i2);
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                }
                else
                {
                  if ("showCommentEditor".equals(paramString3))
                  {
                    label7969:
                    label7991:
                    label8013:
                    try
                    {
                      paramString3 = new JSONObject(paramVarArgs[0]);
                      if (!paramString3.has("enableAnonymous")) {
                        break label8896;
                      }
                      bool1 = paramString3.optBoolean("enableAnonymous");
                      label7899:
                      if (!paramString3.has("placeholder")) {
                        break label8890;
                      }
                      paramJsBridgeListener = paramString3.optString("placeholder");
                    }
                    catch (JSONException paramJsBridgeListener)
                    {
                      label7934:
                      paramJsBridgeListener.printStackTrace();
                    }
                    try
                    {
                      paramString1 = new String(Base64Util.decode(paramJsBridgeListener, 0));
                      paramJsBridgeListener = paramString1;
                    }
                    catch (Exception paramString1)
                    {
                      paramString1.printStackTrace();
                      break label7934;
                    }
                    if (!paramString3.has("defaultTxt")) {
                      break label8884;
                    }
                    paramString1 = paramString3.optString("defaultTxt");
                    try
                    {
                      paramString2 = new String(Base64Util.decode(paramString1, 0));
                      paramString1 = paramString2;
                    }
                    catch (Exception paramString2)
                    {
                      for (;;)
                      {
                        paramString2.printStackTrace();
                      }
                    }
                    if (!paramString3.has("maxLength")) {
                      break label8878;
                    }
                    i1 = paramString3.optInt("maxLength", -1);
                    if (!paramString3.has("commentType")) {
                      break label8872;
                    }
                    i2 = paramString3.optInt("commentType", 0);
                    i3 = 0;
                    if (paramString3.has("sourceType")) {
                      i3 = paramString3.optInt("sourceType", 0);
                    }
                    paramString2 = paramString3.optString("callback");
                    paramVarArgs = paramString3.optJSONArray("defaultCommentAtLevel");
                    i4 = paramString3.optInt("openAt", 0);
                    paramString3 = new Intent();
                    paramString3.putExtra("arg_comment_enable_anonymous", bool1);
                    paramString3.putExtra("arg_comment_placeholder", paramJsBridgeListener);
                    paramString3.putExtra("arg_comment_default_txt", paramString1);
                    paramString3.putExtra("arg_comment_max_length", i1);
                    paramString3.putExtra("arg_comment_comment_type", i2);
                    paramString3.putExtra("arg_comment_source_type", i3);
                    paramString3.putExtra("arg_callback", paramString2);
                    paramString3.putExtra("arg_comment_open_at", i4);
                    paramString3.putExtra("public_fragment_window_feature", 1);
                    if (paramVarArgs != null) {
                      paramString3.putExtra("arg_comment_default_comment_at", paramVarArgs.toString());
                    }
                    PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramString3, ReadInJoyCommentComponentFragment.class, 117);
                    continue;
                    continue;
                  }
                  if ("showPicture".equals(paramString3))
                  {
                    d(paramVarArgs[0]);
                  }
                  else if ("showNativeAd".equals(paramString3))
                  {
                    paramJsBridgeListener = null;
                    try
                    {
                      paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
                      paramJsBridgeListener = paramString1;
                      paramString2 = new Intent();
                      paramJsBridgeListener = paramString1;
                      paramString2.putExtra("param_ad_json", paramVarArgs[0]);
                      paramJsBridgeListener = paramString1;
                      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramString2, ReadInJoyNativeAdFragment.class);
                      paramJsBridgeListener = paramString1;
                      callJs(paramString1, new String[] { new JSONObject().put("retCode", 0).toString() });
                    }
                    catch (Exception paramString1)
                    {
                      paramString1.printStackTrace();
                      callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
                    }
                  }
                  else if ("preloadNativeAdResource".equals(paramString3))
                  {
                    paramString1 = null;
                    paramJsBridgeListener = paramString1;
                    try
                    {
                      paramString2 = new JSONObject(paramVarArgs[0]);
                      paramJsBridgeListener = paramString1;
                      paramString1 = paramString2.optString("callback");
                      paramJsBridgeListener = paramString1;
                      paramString2 = paramString2.optJSONArray("resourceList");
                      paramJsBridgeListener = paramString1;
                      paramString3 = new ArrayList();
                      i1 = 0;
                      for (;;)
                      {
                        paramJsBridgeListener = paramString1;
                        if (i1 >= paramString2.length()) {
                          break;
                        }
                        paramJsBridgeListener = paramString1;
                        paramString3.add(paramString2.getJSONObject(i1).optString("url"));
                        i1 += 1;
                      }
                      paramJsBridgeListener = paramString1;
                      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramString3);
                      paramJsBridgeListener = paramString1;
                      callJs(paramString1, new String[] { new JSONObject().put("retCode", 0).toString() });
                    }
                    catch (Exception paramString1)
                    {
                      paramString1.printStackTrace();
                      callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
                    }
                  }
                  else if ("getLocalCache".equals(paramString3))
                  {
                    try
                    {
                      paramString2 = new JSONObject(paramVarArgs[0]);
                      paramString1 = paramString2.optString("callback");
                      if (paramString2.has("localkey")) {
                        paramString2.optString("localkey", "");
                      }
                      paramJsBridgeListener = "";
                      if (paramString2.has("scene")) {
                        paramJsBridgeListener = paramString2.optString("scene", "");
                      }
                      if (!"messageBox".equals(paramJsBridgeListener)) {
                        break label8721;
                      }
                      paramJsBridgeListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_GET_UNREAD_MESSAGE_BOX_DATA", null).getString("VALUE_UNREAD_MESSAGE_BOX_DATA", "");
                      bool1 = "".equals(paramJsBridgeListener);
                      if (bool1) {
                        continue;
                      }
                      try
                      {
                        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                        callJs(paramString1, new String[] { new JSONObject().put("retData", paramJsBridgeListener).toString() });
                      }
                      catch (JSONException paramJsBridgeListener)
                      {
                        paramJsBridgeListener.printStackTrace();
                      }
                    }
                    catch (JSONException paramJsBridgeListener)
                    {
                      paramJsBridgeListener.printStackTrace();
                    }
                    continue;
                    label8721:
                    if ("commentPage".equals(paramJsBridgeListener))
                    {
                      paramJsBridgeListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_GET_CLICK_COMMENT_ACTICLEINFO", null).getString("VALUE_CLICK_COMMENT_ACTICLEINFO", "");
                      bool1 = "".equals(paramJsBridgeListener);
                      if (!bool1) {
                        try
                        {
                          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                          callJs(paramString1, new String[] { new JSONObject().put("retData", paramJsBridgeListener).toString() });
                        }
                        catch (JSONException paramJsBridgeListener)
                        {
                          paramJsBridgeListener.printStackTrace();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          label8872:
          label8878:
          label8884:
          label8890:
          label8896:
          label8902:
          label8908:
          label8914:
          paramJsBridgeListener = null;
        }
      }
      label8919:
      i1 = 0;
      continue;
      label8925:
      continue;
      label8928:
      return true;
      label8930:
      return true;
      label8932:
      i3 = 9;
    }
    label8939:
    return true;
    label8941:
    return true;
    label8943:
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.l = "";
    this.m = "";
    this.n = "";
  }
  
  public void j()
  {
    Object localObject = AppConstants.aJ + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "c2bCAM/";
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
        callJs(this.m, new String[] { ((JSONObject)localObject).toString() });
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
    this.n = UUID.randomUUID().toString();
    this.l = ((String)localObject + this.n + ".jpg");
    localObject = Uri.fromFile(new File(this.l));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    try
    {
      startActivityForResult(localIntent, (byte)112);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        l();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624515);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381)).setText("正在处理");
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject1;
    if (paramByte == 1)
    {
      if (paramIntent != null) {
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("retCode", 0);
        ((JSONObject)localObject1).put("msg", "Success");
        paramIntent = paramIntent.getStringExtra("scanResult");
        if (this.jdField_c_of_type_Int != 1) {}
      }
      catch (JSONException localJSONException)
      {
        try
        {
          ((JSONObject)localObject1).put("scanResult", paramIntent);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
          }
          this.jdField_c_of_type_Int = -1;
          this.jdField_d_of_type_Int = -1;
          return;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
    }
    Object localObject2;
    if (paramByte == 112)
    {
      paramIntent = new File(this.l);
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      if (paramIntent != null) {
        try
        {
          if (paramIntent.exists())
          {
            ThreadManager.getFileThreadHandler().post(new muh(this, (JSONArray)localObject2, (JSONObject)localObject1));
            return;
          }
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      ((JSONObject)localObject1).put("retCode", 1);
      ((JSONObject)localObject1).put("msg", "cancel");
      ((JSONObject)localObject1).put("sourceType", "camera");
      callJs(this.m, new String[] { ((JSONObject)localObject1).toString() });
      this.l = "";
      this.m = "";
      this.n = "";
      return;
    }
    JSONArray localJSONArray;
    if (paramByte == 111)
    {
      localObject2 = new JSONObject();
      localJSONArray = new JSONArray();
      if (paramIntent != null) {}
      for (localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");; localObject1 = null)
      {
        paramInt = 0;
        if (localObject1 != null) {}
        try
        {
          if (((ArrayList)localObject1).size() != 0) {
            break;
          }
          ((JSONObject)localObject2).put("retCode", 1);
          ((JSONObject)localObject2).put("msg", "");
          ((JSONObject)localObject2).put("sourceType", "album");
          callJs(this.m, new String[] { ((JSONObject)localObject2).toString() });
          this.m = "";
          return;
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label1155;
      }
      ThreadManager.getFileThreadHandler().post(new mui(this, (ArrayList)localObject1, localJSONArray, (JSONObject)localObject2));
    }
    for (;;)
    {
      if (paramInt < ((ArrayList)localObject1).size())
      {
        paramIntent = UUID.randomUUID();
        paramIntent = "mqqpa://resourceid/" + paramIntent.toString();
        localJSONArray.put(paramInt, paramIntent);
        jdField_b_of_type_JavaUtilHashMap.put(paramIntent, ((ArrayList)localObject1).get(paramInt));
        paramInt += 1;
      }
      else
      {
        ((JSONObject)localObject2).put("value", localJSONArray);
        ((JSONObject)localObject2).put("retCode", 0);
        ((JSONObject)localObject2).put("msg", "Success");
        ((JSONObject)localObject2).put("sourceType", "album");
        callJs(this.m, new String[] { ((JSONObject)localObject2).toString() });
        this.m = "";
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
        return;
        if (paramByte == 113)
        {
          int i1 = -1;
          if (paramInt == -1) {
            i1 = 0;
          }
          localObject1 = paramIntent.getStringExtra("result_js_callback");
          localObject2 = paramIntent.getStringExtra("feed_id");
          paramInt = paramIntent.getIntExtra("feedsType", 1);
          if ((localObject1 == null) || (localObject2 == null)) {
            break;
          }
          paramIntent = new JSONObject();
          try
          {
            paramIntent.put("feedsId", localObject2);
            paramIntent.put("retCode", i1);
            paramIntent.put("feedsType", paramInt);
            callJs((String)localObject1, new String[] { paramIntent.toString() });
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((paramByte == 114) || (paramByte == 115) || (paramByte == 116))
        {
          if (paramIntent == null) {
            break;
          }
          localObject2 = paramIntent.getStringExtra("arg_callback");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = "";
          switch (paramByte)
          {
          }
          for (;;)
          {
            if (paramInt != -1) {
              break label938;
            }
            paramIntent = paramIntent.getStringExtra("arg_result_json");
            if (paramIntent == null) {
              break;
            }
            try
            {
              paramIntent = new JSONObject(paramIntent);
              paramIntent.put("retCode", 0);
              paramIntent = paramIntent.toString();
              if (QLog.isColorLevel()) {
                QLog.d("PublicAccountH5AbilityPlugin", 2, (String)localObject1 + " result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
              }
              callJs((String)localObject2, new String[] { paramIntent });
              return;
            }
            catch (Exception paramIntent)
            {
              return;
            }
            localObject1 = "showUGCEditPage";
            continue;
            localObject1 = "showUGCVideoUploadPage";
            continue;
            localObject1 = "showUGCVideoRecordPage";
          }
          try
          {
            label938:
            paramIntent = new JSONObject();
            paramIntent.put("retCode", -1);
            paramIntent = paramIntent.toString();
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, (String)localObject1 + " result:" + paramIntent);
            }
            callJs((String)localObject2, new String[] { paramIntent });
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((paramByte != 117) || (paramIntent == null)) {
          break;
        }
        localObject1 = paramIntent.getStringExtra("arg_callback");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        paramIntent = paramIntent.getStringExtra("arg_result_json");
        if (paramIntent != null) {}
        try
        {
          paramIntent = new JSONObject(paramIntent);
          if (paramInt == -1) {
            paramIntent.put("retCode", 0);
          }
          for (;;)
          {
            paramIntent = paramIntent.toString();
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, "showCommentEditor result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
            }
            callJs((String)localObject1, new String[] { paramIntent });
            return;
            paramIntent = new JSONObject();
            break;
            paramIntent.put("retCode", -1);
          }
          label1155:
          paramInt = 0;
        }
        catch (Exception paramIntent) {}
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
      this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    }
    a();
  }
  
  protected void onDestroy()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        a(localCustomWebView.getUrl());
      }
    }
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      i();
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      }
      a().clear();
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin
 * JD-Core Version:    0.7.0.1
 */