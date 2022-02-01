package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.LebaIconDownloader;
import com.tencent.mobileqq.activity.LebaIconDownloader.DownloadListenerAdapter;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicAccountConfigUtilImpl
  implements IPublicAccountConfigUtil
{
  public static final String CONFIG_CUKINGCARD_DLG_SWITCH = "CUKingCard_Dlg";
  public static final String CONFIG_INTEREST_SETTING_RN_ENABLE = "rn_switch";
  public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT = "multi_video_dynamic_recommend_duration_limit";
  public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_DURATION_PERCENT = "multi_video_dynamic_recommend_duration_percent";
  public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_OPERATOR = "multi_video_dynamic_recommend_operator";
  public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_STRATEGY = "multi_video_dynamic_recommend_strategyid";
  public static final String CONFIG_PA_SUBSCRIBE_MSG_TAG = "msg";
  public static final String CONFIG_PA_SUBSCRIBE_SHOW_TAG = "show";
  public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_ICON_TAG = "icon";
  public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_ID_TAG = "id";
  public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_NAME_TAG = "name";
  public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_TAG = "public-account-folder";
  public static final String CONFIG_PUBLIC_ACCOUNT_VERSION = "version";
  public static final String CONFIG_SUBSCRIPT_FULL_RECOMMEND_TAG = "recommendFullScreen";
  public static final String CONFIG_SUBSCRIPT_FULL_RECOMMEND_URL_TAG = "recommendURL";
  public static final String CONFIG_SUBSCRIPT_FULL_RECOMMEND_VERSION = "recommendFullVersion";
  public static final String CONFIG_SUBSCRIPT_INNER_RECOMMEND_TAG = "recommendBottom";
  public static final String CONFIG_SUBSCRIPT_INNER_RECOMMEND_VERSION = "recommendBottomVersion";
  public static final String CONFIG_VIDEO_CHANNEL_AUTOPLAY_SWITCH = "videochannel_video_autoplay";
  public static final String CONFIG_VIDEO_CHANNEL_AUTOPLAY_SWITCH_VIDEO_FLOW = "videochannel_video_autoplay_18mo";
  public static final String CONFIG_VIDEO_CHANNEL_COVER_STYLE = "video_channel_style";
  public static final String CONFIG_VIDEO_CHANNEL_FEEDS_CLICK_SWITCH = "click_videocard_jump_comment";
  public static final String CONFIG_VIDEO_CHANNEL_INFO_ID = "channel_id";
  public static final String CONFIG_VIDEO_CHANNEL_INFO_NAME = "channel_name";
  public static final String CONFIG_VIDEO_CHANNEL_INFO_TYPE = "channel_type";
  public static final String CONFIG_VIDEO_CHANNEL_INFO_VERSION = "channel_version";
  public static final String CONFIG_VIDEO_DEFAULT_BITRATE = "defaultBitRate";
  public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT = "video_dynamic_recommend_duration_limit";
  public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_PERCENT = "video_dynamic_recommend_duration_percent";
  public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_OPERATOR = "video_dynamic_recommend_operator";
  public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_STRATEGY = "video_dynamic_recommend_strategyid";
  public static final String CONFIG_VIDEO_JUMP_DEFAULT_VALUE = "video_jump_to";
  public static final String CONFIG_VIDEO_MULTI_VIDEO_SUPPORT_ENABLE = "multi_video_support_enable";
  public static final String CONFIG_VIDEO_SOCIAL_SWITCH = "video_social_switch";
  public static final String CONFIG_VIDEO_SOUND = "video_sound";
  public static final String CONFIG_VIDEO_STRUCTMSG_SWITCH = "video_struct_switch";
  public static final String CONFIG_VIOLA_DYNAMIC = "viola_dynamic_switch";
  public static final String CONFIG_VIOLA_DYNAMIC_DISCOVER = "viola_discover_switch";
  public static final String CONFIG_VIOLA_DYNAMIC_MESSAGE_BOX = "viola_message_box_switch";
  public static final String CONFIG_VIOLA_DYNAMIC_WEISHI = "viola_dynamic_weishi_switch";
  public static final String CONFIG_WEB_NATIVE_RENDER = "web_viola_render_switch";
  public static final String CONFIG_WEB_NATIVE_RENDER_MODE = "web_viola_render_mode";
  public static boolean IMAGE_COLLECTION_COMMENT = false;
  public static final int MERGE_KANDIAN_FOLDER_FOLDER_DEFAULT_ICON = 2130840430;
  public static final int MERGE_KANDIAN_FOLDER_FOLDER_DEFAULT_NAME = 2131695228;
  public static final String PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
  public static String PUBLIC_ACCOUNT_CATEGORY_URL;
  public static final String PUBLIC_ACCOUNT_CENTER_DEFAULT_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
  public static String PUBLIC_ACCOUNT_CENTER_URL;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_DEFAULT_ICON = 2130840425;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_DEFAULT_NAME = 2131696434;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_DEFAULT_ICON = 2130840430;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_DEFAULT_NAME = 2131695230;
  public static final String READINJOY_FOLDER_CONFIG_ID_TAG = "id";
  public static final String READINJOY_FOLDER_ICON_TAG = "icon";
  public static final String READINJOY_FOLDER_NICKNAME_TAG = "name";
  public static final String READINJOY_READ_DATA_TAG = "kandian_read_data";
  public static String READINJOY_SEARCH_URL;
  public static boolean SERVICE_ACCOUNT_FOLDER_DELETE;
  private static String SERVICE_ACCOUNT_FOLDER_ICON;
  public static String SERVICE_ACCOUNT_FOLDER_NAME;
  public static boolean SERVICE_FOLDER_REDSPOTS;
  public static boolean SERVICE_FOLDER_RED_DELETE;
  public static boolean ServiceFolder_RedClean_After_Enter = false;
  public static ArrayList<String> bigDataChannelWhiteList;
  public static boolean disableBigDataChannel;
  public static int imageCollectionPreload;
  public static int imageCollectionPreloadCover;
  public static int imageCollectionPreloadImage;
  private static final AtomicBoolean initiatedCache = new AtomicBoolean(false);
  private static QQHashMap<Integer, IPublicAccountConfigUtil.PublicAccountConfigFolder> list = null;
  public static boolean needPABottomBar;
  public static boolean preloadToolProcess;
  public static long readInJoyADBackgroundShowTime;
  public static int readInJoyADGuideCardShowTime;
  public static boolean readInJoyFeedsImagePreload;
  public static boolean readInJoyFeedsPreload;
  public static boolean readInJoyFeedsPreload2G;
  public static boolean readInJoyFeedsPreload3G;
  public static boolean readInJoyFeedsPreload4G;
  public static boolean readInJoyFeedsPreloadWifi;
  public static boolean readInJoyIpConnect;
  public static int readInJoyIpConnectReportSwitch;
  public static String readInJoyIpConnectReportTail;
  public static boolean readInJoyLoadImg;
  public static String readInJoyPreloadToolConfig;
  public static String readInJoyReleaseWebServiceConfig;
  public static String readInJoyflingLToRHost;
  
  static
  {
    PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    READINJOY_SEARCH_URL = null;
    SERVICE_ACCOUNT_FOLDER_DELETE = true;
    SERVICE_FOLDER_REDSPOTS = false;
    SERVICE_FOLDER_RED_DELETE = false;
    IMAGE_COLLECTION_COMMENT = false;
    readInJoyFeedsPreload = false;
    readInJoyFeedsPreloadWifi = false;
    readInJoyFeedsPreload4G = false;
    readInJoyFeedsPreload3G = false;
    readInJoyFeedsPreload2G = false;
    readInJoyFeedsImagePreload = false;
    readInJoyflingLToRHost = "";
    readInJoyADBackgroundShowTime = 3000L;
    readInJoyADGuideCardShowTime = 10;
    preloadToolProcess = true;
    readInJoyPreloadToolConfig = "";
    readInJoyReleaseWebServiceConfig = "";
    needPABottomBar = false;
    readInJoyIpConnect = false;
    readInJoyIpConnectReportSwitch = 0;
    readInJoyIpConnectReportTail = "";
    readInJoyLoadImg = false;
    disableBigDataChannel = false;
    bigDataChannelWhiteList = new ArrayList();
    imageCollectionPreload = 0;
    imageCollectionPreloadCover = 0;
    imageCollectionPreloadImage = 0;
  }
  
  public static void addFolders(ArrayList<IPublicAccountConfigUtil.PublicAccountConfigFolder> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (list == null) {
        list = new PublicAccountConfigUtilImpl.5(2011, 0, 1000);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = (IPublicAccountConfigUtil.PublicAccountConfigFolder)paramArrayList.next();
        list.put(Integer.valueOf(localPublicAccountConfigFolder.a()), localPublicAccountConfigFolder);
      }
    }
  }
  
  public static boolean checkServiceAccountFolderConfigData(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1;
    label164:
    label234:
    int m;
    label301:
    label371:
    label511:
    int i;
    label441:
    label581:
    label721:
    label861:
    label1007:
    int i19;
    label651:
    label791:
    label934:
    label1080:
    label1260:
    label1400:
    int i12;
    label1190:
    label1330:
    int i13;
    try
    {
      localJSONObject = new JSONObject(paramString);
      boolean bool = localJSONObject.has("service_folder_name");
      localObject2 = "";
      if (!bool) {
        break label1964;
      }
      localObject1 = localJSONObject.getString("service_folder_name");
      if (localJSONObject.has("service_folder_icon")) {
        localObject2 = localJSONObject.getString("service_folder_icon");
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label1976;
      }
      SERVICE_ACCOUNT_FOLDER_NAME = (String)localObject1;
      SERVICE_ACCOUNT_FOLDER_ICON = (String)localObject2;
      if (!QLog.isColorLevel()) {
        break label1971;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:");
      ((StringBuilder)localObject1).append(SERVICE_ACCOUNT_FOLDER_NAME);
      ((StringBuilder)localObject1).append(" SERVICE_ACCOUNT_FOLDER_ICON:");
      ((StringBuilder)localObject1).append(SERVICE_ACCOUNT_FOLDER_ICON);
      QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
    }
    catch (Exception paramAppInterface)
    {
      JSONObject localJSONObject;
      Object localObject2;
      label1440:
      label1516:
      label1656:
      if (!QLog.isColorLevel()) {
        break label1958;
      }
      label1586:
      label1726:
      label1857:
      QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramAppInterface);
      label1796:
      paramAppInterface.printStackTrace();
      return false;
    }
    if (localJSONObject.has("service_folder_redspots"))
    {
      SERVICE_FOLDER_REDSPOTS = localJSONObject.getBoolean("service_folder_redspots");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:");
        ((StringBuilder)localObject1).append(SERVICE_FOLDER_REDSPOTS);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label1981;
        if (!localJSONObject.has("service_folder_delete")) {
          break label1993;
        }
        SERVICE_ACCOUNT_FOLDER_DELETE = localJSONObject.getBoolean("service_folder_delete");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:");
        ((StringBuilder)localObject1).append(SERVICE_ACCOUNT_FOLDER_DELETE);
        QLog.d("PublicAccountConfigUtil", 1, ((StringBuilder)localObject1).toString());
        m = 1;
        if (!localJSONObject.has("ServiceFolder_RedClean_After_Enter")) {
          break label2005;
        }
        ServiceFolder_RedClean_After_Enter = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
        if (!QLog.isColorLevel()) {
          break label1999;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ServiceFolder_RedClean_After_Enter = ");
        ((StringBuilder)localObject1).append(ServiceFolder_RedClean_After_Enter);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label1999;
        if (!localJSONObject.has("readInJoy_feeds_preload")) {
          break label2017;
        }
        readInJoyFeedsPreload = localJSONObject.getBoolean("readInJoy_feeds_preload");
        if (!QLog.isColorLevel()) {
          break label2011;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload:");
        ((StringBuilder)localObject1).append(readInJoyFeedsPreload);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2011;
        if (!localJSONObject.has("readInJoy_feeds_preload_wifi")) {
          break label2029;
        }
        readInJoyFeedsPreloadWifi = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
        if (!QLog.isColorLevel()) {
          break label2023;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload wifi:");
        ((StringBuilder)localObject1).append(readInJoyFeedsPreloadWifi);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2023;
        if (!localJSONObject.has("readInJoy_feeds_preload_4G")) {
          break label2041;
        }
        readInJoyFeedsPreload4G = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
        if (!QLog.isColorLevel()) {
          break label2035;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 4G:");
        ((StringBuilder)localObject1).append(readInJoyFeedsPreload4G);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2035;
        if (!localJSONObject.has("readInJoy_feeds_preload_3G")) {
          break label2053;
        }
        readInJoyFeedsPreload3G = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
        if (!QLog.isColorLevel()) {
          break label2047;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 3G:");
        ((StringBuilder)localObject1).append(readInJoyFeedsPreload3G);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2047;
        if (!localJSONObject.has("readInJoy_feeds_preload_2G")) {
          break label2065;
        }
        readInJoyFeedsPreload2G = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
        if (!QLog.isColorLevel()) {
          break label2059;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds preload 2G:");
        ((StringBuilder)localObject1).append(readInJoyFeedsPreload2G);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2059;
        if (!localJSONObject.has("pub_account_bottom_bar")) {
          break label2077;
        }
        needPABottomBar = localJSONObject.getBoolean("pub_account_bottom_bar");
        if (!QLog.isColorLevel()) {
          break label2071;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("needPABottomBar: ");
        ((StringBuilder)localObject1).append(needPABottomBar);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2071;
        if (!localJSONObject.has("readInJoy_feeds_image_preload")) {
          break label2089;
        }
        readInJoyFeedsImagePreload = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
        if (!QLog.isColorLevel()) {
          break label2083;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy feeds image preload");
        ((StringBuilder)localObject1).append(readInJoyFeedsImagePreload);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2083;
        if (!localJSONObject.has("kandian_feeds_fling_LToR_host")) {
          break label2100;
        }
        readInJoyflingLToRHost = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
        if (!QLog.isColorLevel()) {
          break label2095;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kandian_feeds_fling_LToR_host");
        ((StringBuilder)localObject1).append(readInJoyflingLToRHost);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2095;
        if (!localJSONObject.has("kandian_ad_background_showtime")) {
          break label2111;
        }
        readInJoyADBackgroundShowTime = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
        if (!QLog.isColorLevel()) {
          break label2105;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kandian_ad_background_showtime");
        ((StringBuilder)localObject1).append(readInJoyADBackgroundShowTime);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2105;
        i19 = i;
        if (!localJSONObject.has("readInJoy_ip_connect")) {
          break label2122;
        }
        readInJoyIpConnect = localJSONObject.getBoolean("readInJoy_ip_connect");
        if (!QLog.isColorLevel()) {
          break label2117;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy_ip_connect:");
        ((StringBuilder)localObject1).append(readInJoyIpConnect);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2117;
        if ((!localJSONObject.has("readInJoy_ip_connect_full_report")) || (!localJSONObject.has("readInJoy_ip_connect_report_tail"))) {
          break label2133;
        }
        readInJoyIpConnectReportSwitch = localJSONObject.getInt("readInJoy_ip_connect_full_report");
        readInJoyIpConnectReportTail = localJSONObject.getString("readInJoy_ip_connect_report_tail");
        if (!QLog.isColorLevel()) {
          break label2127;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoy_ip_connect_full_report:");
        ((StringBuilder)localObject1).append(readInJoyIpConnectReportSwitch);
        ((StringBuilder)localObject1).append(", readInJoy_ip_connect_report_tail:");
        ((StringBuilder)localObject1).append(readInJoyIpConnectReportTail);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2127;
        if (!localJSONObject.has("readInJoy_load_img")) {
          break label2145;
        }
        readInJoyLoadImg = localJSONObject.getBoolean("readInJoy_load_img");
        if (!QLog.isColorLevel()) {
          break label2139;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("readInJoyLoadImg:");
        ((StringBuilder)localObject1).append(readInJoyLoadImg);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2139;
        if (!localJSONObject.has("service_account_folder_redspots_delete")) {
          break label2157;
        }
        SERVICE_FOLDER_RED_DELETE = localJSONObject.getBoolean("service_account_folder_redspots_delete");
        if (!QLog.isColorLevel()) {
          break label2151;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("service_account_folder_redspots_delete:");
        ((StringBuilder)localObject1).append(SERVICE_FOLDER_RED_DELETE);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2151;
        if (!localJSONObject.has("disable_big_data_channel")) {
          break label2169;
        }
        disableBigDataChannel = localJSONObject.getBoolean("disable_big_data_channel");
        if (!QLog.isColorLevel()) {
          break label2163;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("disable big data channel is ");
        ((StringBuilder)localObject1).append(disableBigDataChannel);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2163;
        if ((i12 == 0) || (!localJSONObject.has("host_white_list"))) {
          break label2187;
        }
        localObject1 = localJSONObject.optJSONArray("host_white_list");
        bigDataChannelWhiteList.clear();
        if (localObject1 == null) {
          break label2187;
        }
        i13 = 0;
        if (i13 >= ((JSONArray)localObject1).length()) {
          break label2184;
        }
        bigDataChannelWhiteList.add(((JSONArray)localObject1).getString(i13));
        if (!QLog.isColorLevel()) {
          break label2175;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" big data channel white host is ");
        ((StringBuilder)localObject2).append(((JSONArray)localObject1).getString(i13));
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject2).toString());
        break label2175;
        if (!localJSONObject.has("album_predown_enable")) {
          break label2196;
        }
        imageCollectionPreload = localJSONObject.getInt("album_predown_enable");
        if (!QLog.isColorLevel()) {
          break label2190;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadEnable is ");
        ((StringBuilder)localObject1).append(imageCollectionPreload);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2190;
        if (!localJSONObject.has("album_predown_photo_rule")) {
          break label2208;
        }
        imageCollectionPreloadCover = localJSONObject.getInt("album_predown_photo_rule");
        if (!QLog.isColorLevel()) {
          break label2202;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadCoverEnable is ");
        ((StringBuilder)localObject1).append(imageCollectionPreloadCover);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2202;
        if (!localJSONObject.has("album_predown_slide_photocounts")) {
          break label2220;
        }
        imageCollectionPreloadImage = localJSONObject.getInt("album_predown_slide_photocounts");
        if (!QLog.isColorLevel()) {
          break label2214;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageCollectionPreloadImageEnable is ");
        ((StringBuilder)localObject1).append(imageCollectionPreloadImage);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2214;
        if (!localJSONObject.has("preload_tool_process")) {
          break label2232;
        }
        preloadToolProcess = localJSONObject.getBoolean("preload_tool_process");
        if (!QLog.isColorLevel()) {
          break label2226;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("preload tool progress is ");
        ((StringBuilder)localObject1).append(preloadToolProcess);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2226;
        if (!localJSONObject.has("useNewLogic")) {
          break label2244;
        }
        readInJoyPreloadToolConfig = paramString;
        if (!QLog.isColorLevel()) {
          break label2238;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("read in joy preload tool progress config is ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2238;
        if (!localJSONObject.has("releaseServiceMinMem")) {
          break label2256;
        }
        readInJoyReleaseWebServiceConfig = paramString;
        if (!QLog.isColorLevel()) {
          break label2250;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("release web service config is ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
        break label2250;
      }
    }
    label1958:
    label1964:
    label1971:
    int j;
    label1976:
    label1981:
    int k;
    label1993:
    label1999:
    int n;
    label2005:
    label2011:
    int i1;
    label2017:
    label2023:
    int i2;
    label2029:
    label2035:
    int i3;
    label2041:
    label2047:
    int i4;
    label2053:
    label2059:
    int i5;
    label2065:
    label2071:
    int i6;
    label2077:
    label2083:
    int i7;
    label2089:
    label2095:
    label2100:
    label2105:
    int i8;
    label2111:
    label2117:
    label2122:
    label2127:
    int i9;
    label2133:
    label2139:
    int i10;
    label2145:
    label2151:
    int i11;
    label2157:
    label2163:
    label2169:
    label2175:
    int i14;
    label2184:
    label2187:
    label2190:
    label2196:
    label2202:
    label2208:
    label2214:
    int i15;
    label2220:
    label2226:
    int i16;
    label2232:
    label2238:
    int i17;
    label2244:
    label2250:
    int i18;
    label2256:
    do
    {
      paramAppInterface = paramAppInterface.getHandler(Conversation.class);
      if (paramAppInterface != null) {
        paramAppInterface.sendEmptyMessage(1009);
      }
      return true;
      localObject1 = "";
      break;
      j = 1;
      break label164;
      j = 0;
      break label164;
      k = 1;
      break label234;
      k = 0;
      break label234;
      m = 0;
      break label301;
      n = 1;
      break label371;
      n = 0;
      break label371;
      i1 = 1;
      break label441;
      i1 = 0;
      break label441;
      i2 = 1;
      break label511;
      i2 = 0;
      break label511;
      i3 = 1;
      break label581;
      i3 = 0;
      break label581;
      i4 = 1;
      break label651;
      i4 = 0;
      break label651;
      i5 = 1;
      break label721;
      i5 = 0;
      break label721;
      i6 = 1;
      break label791;
      i6 = 0;
      break label791;
      i7 = 1;
      break label861;
      i7 = 0;
      break label861;
      i = 1;
      break label934;
      i = 0;
      break label934;
      i8 = 1;
      break label1007;
      i8 = 0;
      break label1007;
      i = 1;
      break label1080;
      i = 0;
      break label1080;
      i9 = 1;
      break label1190;
      i9 = 0;
      break label1190;
      i10 = 1;
      break label1260;
      i10 = 0;
      break label1260;
      i11 = 1;
      break label1330;
      i11 = 0;
      break label1330;
      i12 = 1;
      break label1400;
      i12 = 0;
      break label1400;
      i13 += 1;
      break label1440;
      break label1516;
      break label1516;
      i13 = 1;
      break label1586;
      i13 = 0;
      break label1586;
      i14 = 1;
      break label1656;
      i14 = 0;
      break label1656;
      i15 = 1;
      break label1726;
      i15 = 0;
      break label1726;
      i16 = 1;
      break label1796;
      i16 = 0;
      break label1796;
      i17 = 1;
      break label1857;
      i17 = 0;
      break label1857;
      i18 = 1;
      continue;
      i18 = 0;
    } while ((j != 0) || (k != 0) || (m != 0) || (i1 != 0) || (i2 != 0) || (i3 != 0) || (i4 != 0) || (i5 != 0) || (i6 != 0) || (i7 != 0) || (i != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i12 != 0) || (i13 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i19 != 0) || (i17 != 0) || (i8 != 0) || (i18 != 0) || (n != 0));
    return false;
  }
  
  public static boolean checkUrlFormat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.startsWith("http")) || (paramString.startsWith("https"));
  }
  
  private static final String getCertifiedAccountTitle()
  {
    return (String)VSConfigManager.a().a("subscribe_account_title", VSConfigManager.c);
  }
  
  public static String getDefaultName(AppInterface paramAppInterface, Context paramContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return null;
      }
      return paramContext.getString(2131695230);
    }
    return paramContext.getString(2131696434);
  }
  
  private static void init(AppInterface paramAppInterface, Context paramContext)
  {
    if (list == null) {
      list = new PublicAccountConfigUtilImpl.2(2011, 0, 1000);
    }
    if (!parseConfigXml(paramAppInterface, paramContext, SharedPreUtils.e(paramContext)))
    {
      localObject = new IPublicAccountConfigUtil.PublicAccountConfigFolder(paramAppInterface, paramContext, 1, 2131696434, 2130840425);
      list.put(Integer.valueOf(1), localObject);
    }
    Object localObject = SharedPreUtils.i(paramContext);
    String str = SharedPreUtils.j(paramContext);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = new IPublicAccountConfigUtil.PublicAccountConfigFolder();
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).initPublicAccountConfigFolder(localPublicAccountConfigFolder, paramAppInterface, paramContext, 2, (String)localObject, str);
      list.put(Integer.valueOf(2), localPublicAccountConfigFolder);
    }
    else
    {
      paramAppInterface = new IPublicAccountConfigUtil.PublicAccountConfigFolder(paramAppInterface, paramContext, 2, 2131695230, 2130840430);
      list.put(Integer.valueOf(2), paramAppInterface);
    }
    initiatedCache.set(true);
  }
  
  public static boolean isGetFollowListUseNewProtocol()
  {
    String str1 = (String)VSConfigManager.a().a("subscribe_entrance_enable", "1");
    String str2 = (String)VSConfigManager.a().a("newfollowlist", "1");
    return ("1".equals(str1)) || ("1".equals(str2));
  }
  
  public static boolean isPublishEntranceEnable()
  {
    return "1".equals((String)VSConfigManager.a().a("subscribe_publish_entrance_enable", "1"));
  }
  
  private static boolean parseConfigXml(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseConfigXml xml: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int j = paramString.getLength();
        int i = 0;
        while (i < j)
        {
          Object localObject2 = (Element)paramString.item(i);
          int k = Integer.parseInt(((Element)localObject2).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
          localObject1 = ((Element)localObject2).getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
          localObject2 = ((Element)localObject2).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue();
          IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = new IPublicAccountConfigUtil.PublicAccountConfigFolder();
          ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).initPublicAccountConfigFolder(localPublicAccountConfigFolder, paramAppInterface, paramContext, k, (String)localObject1, (String)localObject2);
          if (list == null) {
            list = new PublicAccountConfigUtilImpl.3(2011, 0, 1000);
          }
          list.put(Integer.valueOf(k), localPublicAccountConfigFolder);
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml xml is empty");
        return false;
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml error", paramAppInterface);
      }
      paramAppInterface.printStackTrace();
    }
    return false;
    return true;
  }
  
  public static boolean updateConfig(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    boolean bool = parseConfigXml(paramAppInterface, paramContext, paramString);
    if (bool)
    {
      SharedPreUtils.f(paramContext, paramString);
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublicAccountConfigUtil", 2, "updateEqqConfig fail");
    }
    return bool;
  }
  
  public static void updateServiceAccountFolderConfigVersionCode(AppInterface paramAppInterface, int paramInt)
  {
    String str = paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(str);
    paramAppInterface = paramAppInterface.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.edit();
      paramAppInterface.putInt("service_account_folder_config_version", paramInt);
      paramAppInterface.commit();
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("updateServiceAccountFolderConfigVersionCode success  version:");
      paramAppInterface.append(paramInt);
      QLog.d("PublicAccountConfigUtil", 1, paramAppInterface.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("updateServiceAccountFolderConfigVersionCode failed, uin:");
      paramAppInterface.append(str);
      paramAppInterface.append(", version:");
      paramAppInterface.append(paramInt);
      QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
    }
  }
  
  public static boolean updateSubscribeConfig(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("updateSubscribeConfig xml: ");
      paramContext.append(paramString);
      QLog.d("PublicAccountConfigUtil", 2, paramContext.toString());
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = paramString.trim();
        paramContext = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramContext.getBytes("utf-8")));
        int i = Integer.parseInt(paramContext.getElementsByTagName("version").item(0).getFirstChild().getNodeValue());
        int j = SubscriptRecommendController.a((QQAppInterface)paramAppInterface);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("updateSubscribeConfig prevVersion = ");
          paramString.append(j);
          paramString.append(", version = ");
          paramString.append(i);
          QLog.d("PublicAccountConfigUtil", 2, paramString.toString());
        }
        if (i == j)
        {
          if (!QLog.isColorLevel()) {
            break label361;
          }
          QLog.d("PublicAccountConfigUtil", 2, "IGNORE THIS ACTION because of SAME VERSION");
          return false;
        }
        paramContext = paramContext.getElementsByTagName("public-account-folder");
        if (paramContext.getLength() <= 0) {
          break label363;
        }
        paramContext = (Element)paramContext.item(0);
        j = Integer.parseInt(paramContext.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
        paramContext = paramContext.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
        SubscriptRecommendController.a((QQAppInterface)paramAppInterface, i);
        SubscriptRecommendController.a((QQAppInterface)paramAppInterface, j, paramContext);
        paramAppInterface = (IWebProcessManagerService)paramAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
        if (paramAppInterface == null) {
          break label363;
        }
        paramAppInterface.startWebProcess(-1, null);
        break label363;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml is empty");
        return false;
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updateSubscribeConfig error", paramAppInterface);
      }
      paramAppInterface.printStackTrace();
    }
    return false;
    label361:
    return false;
    label363:
    return true;
  }
  
  public boolean checkNeedLongMessageChannel(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = bigDataChannelWhiteList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!TextUtils.isEmpty(str)) && (paramString.indexOf(str) != -1) && (paramString.endsWith(str))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean checkPublicAccountCenterUrlConfigData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (checkUrlFormat(str1))
        {
          PUBLIC_ACCOUNT_CENTER_URL = str1;
          bool1 = true;
          if (checkUrlFormat(str2))
          {
            PUBLIC_ACCOUNT_CATEGORY_URL = str2;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (paramString.has("readinjoy_search_url"))
          {
            str1 = paramString.getString("readinjoy_search_url");
            bool2 = bool1;
            if (checkUrlFormat(str1))
            {
              READINJOY_SEARCH_URL = str1;
              bool2 = true;
            }
          }
          if (paramString.has("image_collection_comment"))
          {
            IMAGE_COLLECTION_COMMENT = paramString.getBoolean("image_collection_comment");
            bool2 = true;
          }
          return bool2;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  public ArrayList<String> getBigDataChannelWhiteList()
  {
    return bigDataChannelWhiteList;
  }
  
  public Drawable getDefaultDrawable(Context paramContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return paramContext.getResources().getDrawable(2130840321);
      }
      return paramContext.getResources().getDrawable(2130840430);
    }
    return paramContext.getResources().getDrawable(2130840425);
  }
  
  public boolean getDisableBigDataChannel()
  {
    return disableBigDataChannel;
  }
  
  public IPublicAccountConfigUtil.PublicAccountConfigFolder getFolder(AppInterface paramAppInterface, Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3) {
      i = 2;
    }
    if (!initiatedCache.get()) {
      init(paramAppInterface, paramContext);
    }
    if (list == null) {
      list = new PublicAccountConfigUtilImpl.1(this, 2011, 0, 1000);
    }
    return (IPublicAccountConfigUtil.PublicAccountConfigFolder)list.get(Integer.valueOf(i));
  }
  
  public int getImageCollectionPreload()
  {
    return imageCollectionPreload;
  }
  
  public int getImageCollectionPreloadCover()
  {
    return imageCollectionPreloadCover;
  }
  
  public int getImageCollectionPreloadImage()
  {
    return imageCollectionPreloadImage;
  }
  
  public String getMergerKandianName(AppInterface paramAppInterface, Context paramContext)
  {
    return getName(paramAppInterface, paramContext, 3);
  }
  
  public String getName(AppInterface paramAppInterface, Context paramContext, int paramInt)
  {
    IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = getFolder(paramAppInterface, paramContext, paramInt);
    if (localPublicAccountConfigFolder != null) {
      return localPublicAccountConfigFolder.a();
    }
    return getDefaultName(paramAppInterface, paramContext, paramInt);
  }
  
  public String getPublicAccountCategoryUrl()
  {
    return PUBLIC_ACCOUNT_CATEGORY_URL;
  }
  
  public String getPublicAccountCenterUrlConfigData(AppInterface paramAppInterface)
  {
    MobileQQ localMobileQQ = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getString("public_account_center_url_config_data", null);
    }
    return null;
  }
  
  public int getPublicAccountCenterUrlConfigVersionCode(AppInterface paramAppInterface)
  {
    MobileQQ localMobileQQ = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getInt("public_account_center_url_config_version", 0);
    }
    return 0;
  }
  
  public int getPublicAccountQQMailConfigVersionCode(AppInterface paramAppInterface)
  {
    MobileQQ localMobileQQ = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("public_account_qq_mail_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getInt("public_account_qq_mail_config_version", 0);
    }
    return 0;
  }
  
  public final String getPublicAccountTitle()
  {
    if (isSwitchToCertifiedAccount()) {
      return getCertifiedAccountTitle();
    }
    return HardCodeUtil.a(2131716346);
  }
  
  public long getReadInJoyADBackgroundShowTime()
  {
    return readInJoyADBackgroundShowTime;
  }
  
  public int getReadInJoyIpConnectReportSwitch()
  {
    return readInJoyIpConnectReportSwitch;
  }
  
  public String getReadInJoyIpConnectReportTail()
  {
    return readInJoyIpConnectReportTail;
  }
  
  public String getReadInJoyPreloadToolConfig()
  {
    return readInJoyPreloadToolConfig;
  }
  
  public String getReadInJoyReleaseWebServiceConfig()
  {
    return readInJoyReleaseWebServiceConfig;
  }
  
  public String getReadInJoyflingLToRHost()
  {
    return readInJoyflingLToRHost;
  }
  
  public String getReadinjoySearchUrl()
  {
    return READINJOY_SEARCH_URL;
  }
  
  public void getServiceAccountFolderConfigData(AppInterface paramAppInterface)
  {
    String str = paramAppInterface.getCurrentAccountUin();
    Object localObject1 = paramAppInterface.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sp_public_account_with_cuin_");
    ((StringBuilder)localObject2).append(str);
    localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    if (localObject1 != null)
    {
      SERVICE_ACCOUNT_FOLDER_NAME = ((SharedPreferences)localObject1).getString("service_account_folder_name", null);
      SERVICE_ACCOUNT_FOLDER_ICON = ((SharedPreferences)localObject1).getString("service_account_folder_icon", null);
      SERVICE_ACCOUNT_FOLDER_DELETE = ((SharedPreferences)localObject1).getBoolean("service_account_folder_delete", true);
      ServiceFolder_RedClean_After_Enter = ((SharedPreferences)localObject1).getBoolean("service_folder_redclean_after_enter", false);
      SERVICE_FOLDER_REDSPOTS = ((SharedPreferences)localObject1).getBoolean("service_account_folder_redspots", false);
      readInJoyFeedsPreload = ((SharedPreferences)localObject1).getBoolean("kandian_feeds_preload", false);
      readInJoyFeedsPreloadWifi = ((SharedPreferences)localObject1).getBoolean("kandian_feeds_preload_wifi", false);
      readInJoyFeedsPreload4G = ((SharedPreferences)localObject1).getBoolean("kandian_feeds_preload_4G", false);
      readInJoyFeedsPreload3G = ((SharedPreferences)localObject1).getBoolean("kandian_feeds_preload_3G", false);
      readInJoyFeedsPreload2G = ((SharedPreferences)localObject1).getBoolean("kandian_feeds_preload_2G", false);
      needPABottomBar = ((SharedPreferences)localObject1).getBoolean("public_account_bottom_bar", false);
      readInJoyFeedsImagePreload = ((SharedPreferences)localObject1).getBoolean("kandian_feeds_image_preload", false);
      readInJoyflingLToRHost = ((SharedPreferences)localObject1).getString("kandian_feeds_fling_LToR_host", "");
      readInJoyADBackgroundShowTime = ((SharedPreferences)localObject1).getLong("kandian_ad_background_showtime", 3000L);
      readInJoyIpConnect = ((SharedPreferences)localObject1).getBoolean("readInJoy_ip_connect", false);
      readInJoyIpConnectReportSwitch = ((SharedPreferences)localObject1).getInt("readInJoy_ip_connect_full_report", 0);
      readInJoyIpConnectReportTail = ((SharedPreferences)localObject1).getString("readInJoy_ip_connect_report_tail", "");
      readInJoyLoadImg = ((SharedPreferences)localObject1).getBoolean("readInJoy_loading_img", false);
      SERVICE_FOLDER_RED_DELETE = ((SharedPreferences)localObject1).getBoolean("service_account_folder_redspots_delete", false);
      disableBigDataChannel = ((SharedPreferences)localObject1).getBoolean("big_data_share_channel", false);
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "big_data_share_channel_urls", null);
      if (localObject2 != null) {
        bigDataChannelWhiteList = new ArrayList((Collection)localObject2);
      }
      imageCollectionPreload = ((SharedPreferences)localObject1).getInt("album_predown_enable", 0);
      imageCollectionPreloadCover = ((SharedPreferences)localObject1).getInt("album_predown_photo_rule", 0);
      imageCollectionPreloadImage = ((SharedPreferences)localObject1).getInt("album_predown_slide_photocounts", 0);
      preloadToolProcess = ((SharedPreferences)localObject1).getBoolean("ad_preload_tool_process", true);
      readInJoyPreloadToolConfig = ((SharedPreferences)localObject1).getString("key_read_in_joy_preload_tool_config", "");
      readInJoyReleaseWebServiceConfig = ((SharedPreferences)localObject1).getString("key_read_in_joy_release_service_config", "");
      paramAppInterface = paramAppInterface.getHandler(Conversation.class);
      if (paramAppInterface != null) {
        paramAppInterface.sendEmptyMessage(1009);
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getServiceAccountFolderConfigData success, uin:");
        paramAppInterface.append(str);
        paramAppInterface.append(", delete:");
        paramAppInterface.append(SERVICE_ACCOUNT_FOLDER_DELETE);
        paramAppInterface.append(", clean:");
        paramAppInterface.append(ServiceFolder_RedClean_After_Enter);
        paramAppInterface.append(", redspot:");
        paramAppInterface.append(SERVICE_FOLDER_REDSPOTS);
        QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getServiceAccountFolderConfigData failed, uin:");
      paramAppInterface.append(str);
      QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
    }
  }
  
  public int getServiceAccountFolderConfigVersionCode(AppInterface paramAppInterface)
  {
    String str = paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    int i = 0;
    paramAppInterface = paramAppInterface.getSharedPreferences(str, 0);
    if (paramAppInterface != null) {
      i = paramAppInterface.getInt("service_account_folder_config_version", 0);
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("getServiceAccountFolderConfigVersionCode  version:");
    paramAppInterface.append(i);
    QLog.d("PublicAccountConfigUtil", 1, paramAppInterface.toString());
    return i;
  }
  
  public String getServiceAccountFolderIcon()
  {
    return SERVICE_ACCOUNT_FOLDER_ICON;
  }
  
  public String getServiceAccountFolderName()
  {
    return SERVICE_ACCOUNT_FOLDER_NAME;
  }
  
  public String getServiceAccountTitle()
  {
    if (isSwitchToCertifiedAccount()) {
      return getCertifiedAccountTitle();
    }
    return HardCodeUtil.a(2131716346);
  }
  
  public boolean getServiceFolderRedDelete()
  {
    return SERVICE_FOLDER_RED_DELETE;
  }
  
  public String getSubscriptName(AppInterface paramAppInterface, Context paramContext)
  {
    return getName(paramAppInterface, paramContext, 1);
  }
  
  public String getXinKandianName(AppInterface paramAppInterface, Context paramContext)
  {
    return getName(paramAppInterface, paramContext, 2);
  }
  
  public void initPublicAccountConfigFolder(IPublicAccountConfigUtil.PublicAccountConfigFolder paramPublicAccountConfigFolder, AppInterface paramAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramPublicAccountConfigFolder.jdField_a_of_type_Int = paramInt;
    paramPublicAccountConfigFolder.jdField_a_of_type_JavaLangString = paramString1;
    paramPublicAccountConfigFolder.b = paramString2;
    paramPublicAccountConfigFolder.c = paramPublicAccountConfigFolder.a(paramInt);
    paramPublicAccountConfigFolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(paramContext, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("PublicAccountConfigFolder mId: ");
      paramString1.append(paramPublicAccountConfigFolder.jdField_a_of_type_Int);
      paramString1.append(" | mName: ");
      paramString1.append(paramPublicAccountConfigFolder.jdField_a_of_type_JavaLangString);
      paramString1.append(" | mIconUrl: ");
      paramString1.append(paramPublicAccountConfigFolder.b);
      paramString1.append(" | mUin : ");
      paramString1.append(paramPublicAccountConfigFolder.c);
      QLog.d("PublicAccountConfigUtil", 2, paramString1.toString());
    }
    if ((!TextUtils.isEmpty(paramPublicAccountConfigFolder.b)) && (!TextUtils.isEmpty(paramPublicAccountConfigFolder.c)))
    {
      paramString1 = LebaIconDownloader.b(paramContext, paramString2);
      if (paramString1 != null)
      {
        paramPublicAccountConfigFolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString1;
        return;
      }
      LebaIconDownloader.a((QQAppInterface)paramAppInterface, paramContext, paramString2, new LebaIconDownloader.DownloadListenerAdapter(paramContext, new PublicAccountConfigUtilImpl.PublicAccountDownloadListener(paramPublicAccountConfigFolder, paramAppInterface, paramPublicAccountConfigFolder.c), new Object[0]));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mIconUrl is empty");
    }
  }
  
  public boolean isClearAllPublicAccountFolderRedNumber()
  {
    return ServiceFolder_RedClean_After_Enter;
  }
  
  public boolean isDisableBigDataChannel()
  {
    return disableBigDataChannel;
  }
  
  public boolean isNeedPABottomBar()
  {
    return needPABottomBar;
  }
  
  public boolean isPreloadTooProcess()
  {
    return preloadToolProcess;
  }
  
  public boolean isPreloadToolProcess()
  {
    return preloadToolProcess;
  }
  
  public boolean isReadInJoyFeedsImagePreload()
  {
    return readInJoyFeedsImagePreload;
  }
  
  public boolean isReadInJoyFeedsPreload()
  {
    return readInJoyFeedsPreload;
  }
  
  public boolean isReadInJoyFeedsPreload2G()
  {
    return readInJoyFeedsPreload2G;
  }
  
  public boolean isReadInJoyFeedsPreload3G()
  {
    return readInJoyFeedsPreload3G;
  }
  
  public boolean isReadInJoyFeedsPreload4G()
  {
    return readInJoyFeedsPreload4G;
  }
  
  public boolean isReadInJoyFeedsPreloadWifi()
  {
    return readInJoyFeedsPreloadWifi;
  }
  
  public boolean isReadInJoyIpConnect()
  {
    return readInJoyIpConnect;
  }
  
  public boolean isReadInJoyLoadImg()
  {
    return readInJoyLoadImg;
  }
  
  public boolean isServiceAccountFolderDelete()
  {
    return SERVICE_ACCOUNT_FOLDER_DELETE;
  }
  
  public boolean isServiceFolderRedSpots()
  {
    return SERVICE_FOLDER_REDSPOTS;
  }
  
  public boolean isServiceFolderRedspots()
  {
    return SERVICE_FOLDER_REDSPOTS;
  }
  
  public boolean isSwitchToCertifiedAccount()
  {
    return "1".equals((String)VSConfigManager.a().a("subscribe_entrance_enable", "1"));
  }
  
  public void loadPublicAccountCenterUrlConfig(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("pacenter_url");
      String str2 = paramString.getString("pacategory_url");
      if (checkUrlFormat(str1)) {
        PUBLIC_ACCOUNT_CENTER_URL = str1;
      } else {
        PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      }
      if (checkUrlFormat(str2)) {
        PUBLIC_ACCOUNT_CATEGORY_URL = str2;
      } else {
        PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      }
      if (paramString.has("readinjoy_search_url"))
      {
        str1 = paramString.getString("readinjoy_search_url");
        if (checkUrlFormat(str1)) {
          READINJOY_SEARCH_URL = str1;
        }
      }
      else
      {
        updatePublicAccountCenterUrlConfigVersionCode(paramAppInterface, 0);
      }
      if (paramString.has("image_collection_comment"))
      {
        IMAGE_COLLECTION_COMMENT = paramString.getBoolean("image_collection_comment");
        return;
      }
      updatePublicAccountCenterUrlConfigVersionCode(paramAppInterface, 0);
      return;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramAppInterface);
      }
      paramAppInterface.printStackTrace();
      PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      IMAGE_COLLECTION_COMMENT = false;
    }
  }
  
  public int readInJoyADGuideCardShowTime()
  {
    return readInJoyADGuideCardShowTime;
  }
  
  public boolean readInJoyIpConnect()
  {
    return readInJoyIpConnect;
  }
  
  public int readInJoyIpConnectReportSwitch()
  {
    return readInJoyIpConnectReportSwitch;
  }
  
  public String readInJoyIpConnectReportTail()
  {
    return readInJoyIpConnectReportTail;
  }
  
  public String readInJoyPreloadToolConfig()
  {
    return readInJoyPreloadToolConfig;
  }
  
  public String readInJoyReleaseWebServiceConfig()
  {
    return readInJoyReleaseWebServiceConfig;
  }
  
  public void resetPublicAccountConfig(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetPublicAccountConfig uin:");
      localStringBuilder.append(paramString);
      QLog.d("PublicAccountConfigUtil", 2, localStringBuilder.toString());
    }
    PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    SERVICE_ACCOUNT_FOLDER_DELETE = true;
    SERVICE_FOLDER_REDSPOTS = false;
    SERVICE_FOLDER_RED_DELETE = false;
    IMAGE_COLLECTION_COMMENT = false;
    readInJoyFeedsPreload = false;
    readInJoyFeedsPreloadWifi = false;
    readInJoyFeedsPreload4G = false;
    readInJoyFeedsPreload3G = false;
    readInJoyFeedsPreload2G = false;
    readInJoyFeedsImagePreload = false;
    readInJoyflingLToRHost = "";
    readInJoyADBackgroundShowTime = 3000L;
    preloadToolProcess = true;
    readInJoyIpConnect = false;
    readInJoyIpConnectReportSwitch = 0;
    readInJoyIpConnectReportTail = "";
    readInJoyLoadImg = false;
    disableBigDataChannel = false;
    bigDataChannelWhiteList.clear();
    imageCollectionPreload = 0;
    imageCollectionPreloadCover = 0;
    imageCollectionPreloadImage = 0;
    readInJoyPreloadToolConfig = "";
    readInJoyReleaseWebServiceConfig = "";
  }
  
  public void setBigDataChannelWhiteList(ArrayList<String> paramArrayList)
  {
    bigDataChannelWhiteList = paramArrayList;
  }
  
  public void setDisableBigDataChannel(boolean paramBoolean)
  {
    disableBigDataChannel = paramBoolean;
  }
  
  public void setImageCollectionPreload(int paramInt)
  {
    imageCollectionPreload = paramInt;
  }
  
  public void setImageCollectionPreloadCover(int paramInt)
  {
    imageCollectionPreloadCover = paramInt;
  }
  
  public void setImageCollectionPreloadImage(int paramInt)
  {
    imageCollectionPreloadImage = paramInt;
  }
  
  public void setNeedPABottomBar(boolean paramBoolean)
  {
    needPABottomBar = paramBoolean;
  }
  
  public void setPreloadToolProcess(boolean paramBoolean)
  {
    preloadToolProcess = paramBoolean;
  }
  
  public void setReadInJoyADBackgroundShowTime(long paramLong)
  {
    readInJoyADBackgroundShowTime = paramLong;
  }
  
  public void setReadInJoyFeedsImagePreload(boolean paramBoolean)
  {
    readInJoyFeedsImagePreload = paramBoolean;
  }
  
  public void setReadInJoyFeedsPreload(boolean paramBoolean)
  {
    readInJoyFeedsPreload = paramBoolean;
  }
  
  public void setReadInJoyFeedsPreload2G(boolean paramBoolean)
  {
    readInJoyFeedsPreload2G = paramBoolean;
  }
  
  public void setReadInJoyFeedsPreload3G(boolean paramBoolean)
  {
    readInJoyFeedsPreload3G = paramBoolean;
  }
  
  public void setReadInJoyFeedsPreload4G(boolean paramBoolean)
  {
    readInJoyFeedsPreload4G = paramBoolean;
  }
  
  public void setReadInJoyFeedsPreloadWifi(boolean paramBoolean)
  {
    readInJoyFeedsPreloadWifi = paramBoolean;
  }
  
  public void setReadInJoyIpConnect(boolean paramBoolean)
  {
    readInJoyIpConnect = paramBoolean;
  }
  
  public void setReadInJoyIpConnectReportSwitch(int paramInt)
  {
    readInJoyIpConnectReportSwitch = paramInt;
  }
  
  public void setReadInJoyIpConnectReportTail(String paramString)
  {
    readInJoyIpConnectReportTail = paramString;
  }
  
  public void setReadInJoyLoadImg(boolean paramBoolean)
  {
    readInJoyLoadImg = paramBoolean;
  }
  
  public void setReadInJoyPreloadToolConfig(String paramString)
  {
    readInJoyPreloadToolConfig = paramString;
  }
  
  public void setReadInJoyReleaseWebServiceConfig(String paramString)
  {
    readInJoyReleaseWebServiceConfig = paramString;
  }
  
  public void setReadInJoyflingLToRHost(String paramString)
  {
    readInJoyflingLToRHost = paramString;
  }
  
  public void setServiceAccountFolderIcon(String paramString)
  {
    SERVICE_ACCOUNT_FOLDER_ICON = paramString;
  }
  
  public void setServiceAccountFolderName(String paramString)
  {
    SERVICE_ACCOUNT_FOLDER_NAME = paramString;
  }
  
  public void setServiceFolderDelete(boolean paramBoolean)
  {
    SERVICE_ACCOUNT_FOLDER_DELETE = paramBoolean;
  }
  
  public void setServiceFolderRedCleanAfterEnter(boolean paramBoolean)
  {
    ServiceFolder_RedClean_After_Enter = paramBoolean;
  }
  
  public void setServiceFolderRedDelete(boolean paramBoolean)
  {
    SERVICE_FOLDER_RED_DELETE = paramBoolean;
  }
  
  public void setServiceFolderRedSpots(boolean paramBoolean)
  {
    SERVICE_FOLDER_REDSPOTS = paramBoolean;
  }
  
  public void updatePublicAccountCenterUrlConfigData(AppInterface paramAppInterface)
  {
    Object localObject = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localObject = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (localObject != null) {
      try
      {
        paramAppInterface = new JSONObject();
        paramAppInterface.put("pacenter_url", PUBLIC_ACCOUNT_CENTER_URL);
        paramAppInterface.put("pacategory_url", PUBLIC_ACCOUNT_CATEGORY_URL);
        paramAppInterface.put("readinjoy_search_url", READINJOY_SEARCH_URL);
        paramAppInterface.put("image_collection_comment", IMAGE_COLLECTION_COMMENT);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("public_account_center_url_config_data", paramAppInterface.toString());
        ((SharedPreferences.Editor)localObject).commit();
        return;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", paramAppInterface);
        }
        paramAppInterface.printStackTrace();
      }
    }
  }
  
  public void updatePublicAccountCenterUrlConfigVersionCode(AppInterface paramAppInterface, int paramInt)
  {
    MobileQQ localMobileQQ = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.edit();
      paramAppInterface.putInt("public_account_center_url_config_version", paramInt);
      paramAppInterface.commit();
    }
  }
  
  public void updatePublicAccountQQMailConfigData(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = paramAppInterface.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("public_account_qq_mail_");
    ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
    SharedPreferences.Editor localEditor = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("tim_url")) {
          localJSONObject.getString("tim_url");
        }
        boolean bool = localJSONObject.has("tim_url_card");
        String str5 = null;
        if (!bool) {
          break label593;
        }
        paramAppInterface = localJSONObject.getString("tim_url_card");
        if (!localJSONObject.has("tim_wording")) {
          break label598;
        }
        paramString = localJSONObject.getString("tim_wording");
        if (!localJSONObject.has("tim_url_icon")) {
          break label603;
        }
        localObject1 = localJSONObject.getString("tim_url_icon");
        if (!localJSONObject.has("tim_url_icon_725")) {
          break label609;
        }
        localObject2 = localJSONObject.getString("tim_url_icon_725");
        if (!localJSONObject.has("qim_url_card")) {
          break label615;
        }
        str1 = localJSONObject.getString("qim_url_card");
        if (!localJSONObject.has("qim_wording")) {
          break label621;
        }
        str2 = localJSONObject.getString("qim_wording");
        if (!localJSONObject.has("qim_url_icon")) {
          break label627;
        }
        str3 = localJSONObject.getString("qim_url_icon");
        if (!localJSONObject.has("qim_url_icon_720")) {
          break label633;
        }
        str4 = localJSONObject.getString("qim_url_icon_720");
        if (localJSONObject.has("qim_url_icon_story")) {
          str5 = localJSONObject.getString("qim_url_icon_story");
        }
        if (checkUrlFormat(paramAppInterface)) {
          localEditor.putString("profile_card_tim_online_url", paramAppInterface);
        }
        if (checkUrlFormat((String)localObject1)) {
          localEditor.putString("profile_card_tim_online_icon_url", (String)localObject1);
        }
        if (checkUrlFormat((String)localObject2)) {
          localEditor.putString("profile_card_tim_online_icon_725_url", (String)localObject2);
        }
        if (!TextUtils.isEmpty(paramString)) {
          localEditor.putString("profile_card_tim_online_wording", paramString);
        }
        if (checkUrlFormat(str1)) {
          localEditor.putString("profile_card_qim_online_url", str1);
        }
        if (checkUrlFormat(str3)) {
          localEditor.putString("profile_card_qim_online_icon_url", str3);
        }
        if (checkUrlFormat(str4)) {
          localEditor.putString("profile_card_qim_online_icon_url_720", str4);
        }
        if (checkUrlFormat(str5)) {
          localEditor.putString("key_story_qim_online_icon_url", str5);
        }
        if (!TextUtils.isEmpty(str2)) {
          localEditor.putString("profile_card_qim_online_wording", str2);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("updatePublicAccountQQMailConfigData url_card_tim_online:");
          paramString.append(paramAppInterface);
          paramString.append("; url_card_qim_online:");
          paramString.append(str1);
          QLog.d("PublicAccountConfigUtil", 2, paramString.toString());
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update public account qq mail config error.", paramAppInterface);
        }
      }
      localEditor.putInt("public_account_qq_mail_config_version", paramInt);
      localEditor.commit();
      return;
      label593:
      paramAppInterface = null;
      continue;
      label598:
      paramString = null;
      continue;
      label603:
      localObject1 = null;
      continue;
      label609:
      localObject2 = null;
      continue;
      label615:
      String str1 = null;
      continue;
      label621:
      String str2 = null;
      continue;
      label627:
      String str3 = null;
      continue;
      label633:
      String str4 = null;
    }
  }
  
  public boolean updateReadinjoyFolderConfig(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update readinjoy folder xml: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = paramString.trim();
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localObject = paramString.getElementsByTagName("id");
      if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
      {
        int i = Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue();
        if (i > SharedPreUtils.y(paramAppInterface.getApp()))
        {
          localObject = (Element)paramString.getElementsByTagName("name").item(0);
          paramString = (Element)paramString.getElementsByTagName("icon").item(0);
          localObject = ((Element)localObject).getFirstChild().getNodeValue();
          paramString = paramString.getFirstChild().getNodeValue();
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
            SharedPreUtils.a(paramAppInterface.getApp(), (String)localObject, paramString);
          }
          SharedPreUtils.p(paramAppInterface.getApp(), i);
          return false;
        }
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("readinjoy folder config same id ! ");
          paramAppInterface.append(i);
          QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          return false;
        }
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return false;
  }
  
  public void updateServiceAccountFolderConfigData(AppInterface paramAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountConfigUtilImpl.4(this, paramAppInterface));
  }
  
  public boolean updateSubscriptRecommendConfig(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateSubscribeRecommendConfig xml: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        localObject1 = paramString.getElementsByTagName("recommendFullVersion");
        int i;
        int j;
        Object localObject2;
        int k;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = SubscriptRecommendController.b((QQAppInterface)paramAppInterface);
          if (i > j)
          {
            localObject1 = (Element)paramString.getElementsByTagName("recommendFullScreen").item(0);
            localObject2 = (Element)paramString.getElementsByTagName("recommendURL").item(0);
            k = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
            localObject1 = ((Element)localObject2).getFirstChild().getNodeValue();
            if (k != 1) {
              break label3570;
            }
            bool = true;
            SubscriptRecommendController.a(paramAppInterface, bool, (String)localObject1);
            SubscriptRecommendController.b((QQAppInterface)paramAppInterface, i);
            if (k == 1)
            {
              localObject2 = (IWebProcessManagerService)paramAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
              if (localObject2 != null) {
                ((IWebProcessManagerService)localObject2).startWebProcess(66, null);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("SubscriptRecommendConfig update fullrecommend config. version : ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(" switch : ");
              if (k != 1) {
                break label3576;
              }
              bool = true;
              ((StringBuilder)localObject2).append(bool);
              ((StringBuilder)localObject2).append(" url : ");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" oldVersion : ");
              ((StringBuilder)localObject2).append(j);
              QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("SubscriptRecommendConfig same version ! ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = paramString.getElementsByTagName("recommendBottomVersion");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = SubscriptRecommendController.c((QQAppInterface)paramAppInterface);
          if (i > j)
          {
            k = Integer.valueOf(((Element)paramString.getElementsByTagName("recommendBottom").item(0)).getFirstChild().getNodeValue()).intValue();
            localObject1 = (QQAppInterface)paramAppInterface;
            if (k != 1) {
              break label3582;
            }
            bool = true;
            SubscriptRecommendController.a((QQAppInterface)localObject1, bool);
            SubscriptRecommendController.c((QQAppInterface)paramAppInterface, i);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("SubscriptRecommendConfig update innerrecommend config. preversion -> version ");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append("->");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(" switch : ");
              ((StringBuilder)localObject1).append(k);
              QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("SubscriptRecommendConfig update fail same version ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("kandian_read_data").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramAppInterface.getApp();
          if (i != 1) {
            break label3588;
          }
          bool = true;
          SharedPreUtils.b((Context)localObject1, bool);
        }
        localObject1 = paramString.getElementsByTagName("channel_version");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoyMultiVideoChannelInfoVersion();
          if (i > j)
          {
            localObject2 = (Element)paramString.getElementsByTagName("channel_id").item(0);
            Element localElement = (Element)paramString.getElementsByTagName("channel_name").item(0);
            localObject1 = (Element)paramString.getElementsByTagName("channel_type").item(0);
            k = Integer.valueOf(((Element)localObject2).getFirstChild().getNodeValue()).intValue();
            localObject2 = String.valueOf(localElement.getFirstChild().getNodeValue());
            int m = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
            ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoyMultiVideoChannelInfo(k, (String)localObject2, m);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("update channelInfo config. preversion -> version ");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append("->");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(" channelID : ");
              ((StringBuilder)localObject1).append(k);
              ((StringBuilder)localObject1).append(" channelName: ");
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append(" channelType: ");
              ((StringBuilder)localObject1).append(m);
              QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("update channelInfo fail same version ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("video_sound").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramAppInterface.getApp();
          if (i != 0) {
            break label3594;
          }
          bool = true;
          SharedPreUtils.c((Context)localObject1, bool);
          localObject1 = (IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class);
          if (i != 0) {
            break label3600;
          }
          bool = true;
          ((IVideoVolumeControl)localObject1).saveConfig(bool);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("get video sound config ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_support_enable");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          localObject1 = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
          if (i <= 0) {
            break label3606;
          }
          bool = true;
          ((IReadInJoyHelper)localObject1).updateSupportMultiVideoSwitch(bool);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateSupportMultiVideoSwitch， supportEnable = ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("rn_switch").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramAppInterface.getApp();
          if (i == 1) {
            break label3612;
          }
          bool = true;
          SharedPreUtils.a((Context)localObject1, bool, paramAppInterface.getCurrentUin());
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("get interesrLableRn config ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("video_struct_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          paramAppInterface = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
          if (i <= 0) {
            break label3618;
          }
          bool = true;
          paramAppInterface.updateVideoStructMsgPlaySwitch(bool);
        }
        paramAppInterface = paramString.getElementsByTagName("video_social_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          if (Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3624;
          }
          bool = true;
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("parse kandian video social switch = ");
            paramAppInterface.append(bool);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateKandianVideoSocialSwitch(bool);
        }
        paramAppInterface = paramString.getElementsByTagName("videochannel_video_autoplay");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video channel auto play switch default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoChannelAutoPlaySwitchDefaultValue(i);
        }
        paramAppInterface = paramString.getElementsByTagName("video_jump_to");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video jump default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoyVideoJumpDefaultValue(i);
        }
        paramAppInterface = paramString.getElementsByTagName("defaultBitRate");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          paramAppInterface = (Element)paramAppInterface.item(0);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateKandianConfigDefaultBitRate(paramAppInterface.getFirstChild().getNodeValue());
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("defaultBitRate value = ");
            ((StringBuilder)localObject1).append(paramAppInterface.getFirstChild().getNodeValue());
            QLog.d("PublicAccountConfigUtil", 2, ((StringBuilder)localObject1).toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("CUKingCard_Dlg");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateCUKingCardDlgSwitch(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("CUKingCardDlg value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("video_channel_style");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoChannelCoverStyle(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video_channel_style value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("video_dynamic_recommend_strategyid");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommmendStrategy(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video_dynamic_recommend_strategyid value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("video_dynamic_recommend_duration_limit");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommmendDurationLimit(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video_dynamic_recommend_duration_limit value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("video_dynamic_recommend_duration_percent");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          float f = Float.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).floatValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommendDurationPercent(f);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video_dynamic_recommend_duration_percent value = ");
            paramAppInterface.append(f);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("video_dynamic_recommend_operator");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommendOperator(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video_dynamic_recommend_operator value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("web_viola_render_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateWebRenderConfig(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("web_viola_render_switch value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("web_viola_render_mode");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateWebRenderModeConfig(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("web_viola_render_mode value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("videochannel_video_autoplay_18mo");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video flow video channel auto play switch default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow(i);
        }
        paramAppInterface = paramString.getElementsByTagName("click_videocard_jump_comment");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("video channel feeds click switch default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateVideoChannelFeedsClickSwitchValue(i);
        }
        paramAppInterface = paramString.getElementsByTagName("viola_dynamic_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateViolaDynamicConfig(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("viola dynamic default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("viola_dynamic_weishi_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateViolaWeishiAdConfig(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("viola dynamic weishi default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("viola_discover_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateViolaDiscoverConfig(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("viola dynamic discover default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        paramAppInterface = paramString.getElementsByTagName("viola_message_box_switch");
        if ((paramAppInterface != null) && (paramAppInterface.getLength() > 0))
        {
          i = Integer.valueOf(((Element)paramAppInterface.item(0)).getFirstChild().getNodeValue()).intValue();
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateViolaMessageBoxConfig(i);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("viola dynamic message box default value = ");
            paramAppInterface.append(i);
            QLog.d("PublicAccountConfigUtil", 2, paramAppInterface.toString());
          }
        }
        return true;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("update subscript recommend config error.");
          paramString.append(paramAppInterface);
          QLog.e("PublicAccountConfigUtil", 2, paramString.toString());
        }
        return false;
      }
      label3570:
      boolean bool = false;
      continue;
      label3576:
      bool = false;
      continue;
      label3582:
      bool = false;
      continue;
      label3588:
      bool = false;
      continue;
      label3594:
      bool = false;
      continue;
      label3600:
      bool = false;
      continue;
      label3606:
      bool = false;
      continue;
      label3612:
      bool = false;
      continue;
      label3618:
      bool = false;
      continue;
      label3624:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl
 * JD-Core Version:    0.7.0.1
 */