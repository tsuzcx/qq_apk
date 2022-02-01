package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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
  public static final int MERGE_KANDIAN_FOLDER_FOLDER_DEFAULT_ICON = 2130840561;
  public static final int MERGE_KANDIAN_FOLDER_FOLDER_DEFAULT_NAME = 2131695232;
  public static final String PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
  public static String PUBLIC_ACCOUNT_CATEGORY_URL;
  public static final String PUBLIC_ACCOUNT_CENTER_DEFAULT_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
  public static String PUBLIC_ACCOUNT_CENTER_URL;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_DEFAULT_ICON = 2130840556;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_DEFAULT_NAME = 2131696415;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_DEFAULT_ICON = 2130840561;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_DEFAULT_NAME = 2131695234;
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
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
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
  
  public static boolean checkNeedLongMessageChannel(String paramString)
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
  
  public static boolean checkServiceAccountFolderConfigData(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject;
    String str;
    label61:
    label197:
    int k;
    label137:
    label251:
    int i13;
    label311:
    label371:
    label1011:
    int i14;
    label431:
    label491:
    label1131:
    int i19;
    label551:
    label1071:
    label1357:
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("service_folder_name")) {
        break label1935;
      }
      localObject = localJSONObject.getString("service_folder_name");
      if (!localJSONObject.has("service_folder_icon")) {
        break label1942;
      }
      str = localJSONObject.getString("service_folder_icon");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
        break label1821;
      }
      SERVICE_ACCOUNT_FOLDER_NAME = (String)localObject;
      SERVICE_ACCOUNT_FOLDER_ICON = str;
      if (!QLog.isColorLevel()) {
        break label1826;
      }
      QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + SERVICE_ACCOUNT_FOLDER_NAME + " SERVICE_ACCOUNT_FOLDER_ICON:" + SERVICE_ACCOUNT_FOLDER_ICON);
    }
    catch (Exception paramQQAppInterface)
    {
      JSONObject localJSONObject;
      label611:
      label1642:
      if (!QLog.isColorLevel()) {
        break label1684;
      }
      label731:
      QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramQQAppInterface);
      label857:
      paramQQAppInterface.printStackTrace();
      label1231:
      return false;
    }
    if (localJSONObject.has("service_folder_redspots"))
    {
      SERVICE_FOLDER_REDSPOTS = localJSONObject.getBoolean("service_folder_redspots");
      if (!QLog.isColorLevel()) {
        break label1831;
      }
      QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + SERVICE_FOLDER_REDSPOTS);
      break label1831;
      if (localJSONObject.has("service_folder_delete"))
      {
        SERVICE_ACCOUNT_FOLDER_DELETE = localJSONObject.getBoolean("service_folder_delete");
        QLog.d("PublicAccountConfigUtil", 1, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + SERVICE_ACCOUNT_FOLDER_DELETE);
        k = 1;
        if (localJSONObject.has("ServiceFolder_RedClean_After_Enter"))
        {
          ServiceFolder_RedClean_After_Enter = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
          if (!QLog.isColorLevel()) {
            break label1836;
          }
          QLog.d("PublicAccountConfigUtil", 2, "ServiceFolder_RedClean_After_Enter = " + ServiceFolder_RedClean_After_Enter);
          break label1836;
          if (localJSONObject.has("readInJoy_feeds_preload"))
          {
            readInJoyFeedsPreload = localJSONObject.getBoolean("readInJoy_feeds_preload");
            if (!QLog.isColorLevel()) {
              break label1842;
            }
            QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload:" + readInJoyFeedsPreload);
            break label1842;
            if (localJSONObject.has("readInJoy_feeds_preload_wifi"))
            {
              readInJoyFeedsPreloadWifi = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
              if (!QLog.isColorLevel()) {
                break label1848;
              }
              QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload wifi:" + readInJoyFeedsPreloadWifi);
              break label1848;
              label1537:
              if (localJSONObject.has("readInJoy_feeds_preload_4G"))
              {
                readInJoyFeedsPreload4G = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
                if (!QLog.isColorLevel()) {
                  break label1854;
                }
                QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload 4G:" + readInJoyFeedsPreload4G);
                break label1854;
                label1417:
                if (localJSONObject.has("readInJoy_feeds_preload_3G"))
                {
                  readInJoyFeedsPreload3G = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
                  if (!QLog.isColorLevel()) {
                    break label1860;
                  }
                  QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload 3G:" + readInJoyFeedsPreload3G);
                  break label1860;
                  label917:
                  if (localJSONObject.has("readInJoy_feeds_preload_2G"))
                  {
                    readInJoyFeedsPreload2G = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
                    if (!QLog.isColorLevel()) {
                      break label1866;
                    }
                    QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload 2G:" + readInJoyFeedsPreload2G);
                    break label1866;
                    label794:
                    if (localJSONObject.has("pub_account_bottom_bar"))
                    {
                      needPABottomBar = localJSONObject.getBoolean("pub_account_bottom_bar");
                      if (!QLog.isColorLevel()) {
                        break label1872;
                      }
                      QLog.d("PublicAccountConfigUtil", 2, "needPABottomBar: " + needPABottomBar);
                      break label1872;
                      label671:
                      if (localJSONObject.has("readInJoy_feeds_image_preload"))
                      {
                        readInJoyFeedsImagePreload = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
                        if (!QLog.isColorLevel()) {
                          break label1878;
                        }
                        QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds image preload" + readInJoyFeedsImagePreload);
                        break label1878;
                        if (localJSONObject.has("kandian_feeds_fling_LToR_host"))
                        {
                          readInJoyflingLToRHost = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
                          if (!QLog.isColorLevel()) {
                            break label1884;
                          }
                          QLog.d("PublicAccountConfigUtil", 2, "kandian_feeds_fling_LToR_host" + readInJoyflingLToRHost);
                          break label1884;
                          if (localJSONObject.has("kandian_ad_background_showtime"))
                          {
                            readInJoyADBackgroundShowTime = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
                            if (!QLog.isColorLevel()) {
                              break label1890;
                            }
                            QLog.d("PublicAccountConfigUtil", 2, "kandian_ad_background_showtime" + readInJoyADBackgroundShowTime);
                            break label1890;
                            if (localJSONObject.has("readInJoy_ip_connect"))
                            {
                              readInJoyIpConnect = localJSONObject.getBoolean("readInJoy_ip_connect");
                              if (!QLog.isColorLevel()) {
                                break label1896;
                              }
                              QLog.d("PublicAccountConfigUtil", 2, "readInJoy_ip_connect:" + readInJoyIpConnect);
                              break label1896;
                              if ((localJSONObject.has("readInJoy_ip_connect_full_report")) && (localJSONObject.has("readInJoy_ip_connect_report_tail")))
                              {
                                readInJoyIpConnectReportSwitch = localJSONObject.getInt("readInJoy_ip_connect_full_report");
                                readInJoyIpConnectReportTail = localJSONObject.getString("readInJoy_ip_connect_report_tail");
                                if (!QLog.isColorLevel()) {
                                  break label1902;
                                }
                                QLog.d("PublicAccountConfigUtil", 2, "readInJoy_ip_connect_full_report:" + readInJoyIpConnectReportSwitch + ", readInJoy_ip_connect_report_tail:" + readInJoyIpConnectReportTail);
                                break label1902;
                                if (localJSONObject.has("readInJoy_load_img"))
                                {
                                  readInJoyLoadImg = localJSONObject.getBoolean("readInJoy_load_img");
                                  if (!QLog.isColorLevel()) {
                                    break label1908;
                                  }
                                  QLog.d("PublicAccountConfigUtil", 2, "readInJoyLoadImg:" + readInJoyLoadImg);
                                  break label1908;
                                  if (localJSONObject.has("service_account_folder_redspots_delete"))
                                  {
                                    SERVICE_FOLDER_RED_DELETE = localJSONObject.getBoolean("service_account_folder_redspots_delete");
                                    if (!QLog.isColorLevel()) {
                                      break label1914;
                                    }
                                    QLog.d("PublicAccountConfigUtil", 2, "service_account_folder_redspots_delete:" + SERVICE_FOLDER_RED_DELETE);
                                    break label1914;
                                    if (localJSONObject.has("disable_big_data_channel"))
                                    {
                                      disableBigDataChannel = localJSONObject.getBoolean("disable_big_data_channel");
                                      if (!QLog.isColorLevel()) {
                                        break label1920;
                                      }
                                      QLog.d("PublicAccountConfigUtil", 2, "disable big data channel is " + disableBigDataChannel);
                                      break label1920;
                                      label1191:
                                      if ((i13 != 0) && (localJSONObject.has("host_white_list")))
                                      {
                                        localObject = localJSONObject.optJSONArray("host_white_list");
                                        bigDataChannelWhiteList.clear();
                                        if (localObject != null)
                                        {
                                          i14 = 0;
                                          if (i14 < ((JSONArray)localObject).length())
                                          {
                                            bigDataChannelWhiteList.add(((JSONArray)localObject).getString(i14));
                                            if (!QLog.isColorLevel()) {
                                              break label1926;
                                            }
                                            QLog.d("PublicAccountConfigUtil", 2, " big data channel white host is " + ((JSONArray)localObject).getString(i14));
                                            break label1926;
                                          }
                                        }
                                      }
                                      if (localJSONObject.has("album_predown_enable"))
                                      {
                                        imageCollectionPreload = localJSONObject.getInt("album_predown_enable");
                                        if (!QLog.isColorLevel()) {
                                          break label1949;
                                        }
                                        QLog.d("PublicAccountConfigUtil", 2, "imageCollectionPreloadEnable is " + imageCollectionPreload);
                                        break label1949;
                                        if (localJSONObject.has("album_predown_photo_rule"))
                                        {
                                          imageCollectionPreloadCover = localJSONObject.getInt("album_predown_photo_rule");
                                          if (!QLog.isColorLevel()) {
                                            break label1955;
                                          }
                                          QLog.d("PublicAccountConfigUtil", 2, "imageCollectionPreloadCoverEnable is " + imageCollectionPreloadCover);
                                          break label1955;
                                          label1588:
                                          if (localJSONObject.has("album_predown_slide_photocounts"))
                                          {
                                            imageCollectionPreloadImage = localJSONObject.getInt("album_predown_slide_photocounts");
                                            if (!QLog.isColorLevel()) {
                                              break label1961;
                                            }
                                            QLog.d("PublicAccountConfigUtil", 2, "imageCollectionPreloadImageEnable is " + imageCollectionPreloadImage);
                                            break label1961;
                                            label1477:
                                            if (localJSONObject.has("preload_tool_process"))
                                            {
                                              preloadToolProcess = localJSONObject.getBoolean("preload_tool_process");
                                              if (!QLog.isColorLevel()) {
                                                break label1967;
                                              }
                                              QLog.d("PublicAccountConfigUtil", 2, "preload tool progress is " + preloadToolProcess);
                                              break label1967;
                                              if (localJSONObject.has("useNewLogic"))
                                              {
                                                readInJoyPreloadToolConfig = paramString;
                                                if (!QLog.isColorLevel()) {
                                                  break label1973;
                                                }
                                                QLog.d("PublicAccountConfigUtil", 2, "read in joy preload tool progress config is " + paramString);
                                                break label1973;
                                                i19 = 0;
                                                if (!localJSONObject.has("releaseServiceMinMem")) {
                                                  break label1982;
                                                }
                                                readInJoyReleaseWebServiceConfig = paramString;
                                                if (!QLog.isColorLevel()) {
                                                  break label1979;
                                                }
                                                QLog.d("PublicAccountConfigUtil", 2, "release web service config is " + paramString);
                                                break label1979;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1684:
    label1821:
    label1826:
    label1831:
    label1836:
    label1842:
    label1848:
    label1854:
    label1982:
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      return true;
      int m;
      label1860:
      label1866:
      label1872:
      label1878:
      label1884:
      label1890:
      label1896:
      label1902:
      label1908:
      label1914:
      do
      {
        return false;
        int i18 = 0;
        break label1588;
        int i17 = 0;
        break label1537;
        int i16 = 0;
        break label1477;
        int i15 = 0;
        break label1417;
        i14 = 0;
        break label1357;
        i13 = 0;
        break label1191;
        int i12 = 0;
        break label1131;
        int i11 = 0;
        break label1071;
        int i10 = 0;
        break label1011;
        int i9 = 0;
        break label917;
        int i8 = 0;
        break label857;
        int i7 = 0;
        break label794;
        int i6 = 0;
        break label731;
        int i5 = 0;
        break label671;
        int i4 = 0;
        break label611;
        int i3 = 0;
        break label551;
        int i2 = 0;
        break label491;
        int i1 = 0;
        break label431;
        int n = 0;
        break label371;
        m = 0;
        break label311;
        k = 0;
        break label251;
        int j = 0;
        break label197;
        int i = 0;
        break label137;
        i = 1;
        break label137;
        j = 1;
        break label197;
        m = 1;
        break label311;
        n = 1;
        break label371;
        i1 = 1;
        break label431;
        i2 = 1;
        break label491;
        i3 = 1;
        break label551;
        i4 = 1;
        break label611;
        i5 = 1;
        break label671;
        i6 = 1;
        break label731;
        i7 = 1;
        break label794;
        i8 = 1;
        break label857;
        i9 = 1;
        break label917;
        i10 = 1;
        break label1011;
        i11 = 1;
        break label1071;
        i12 = 1;
        break label1131;
        i13 = 1;
        break label1191;
        i14 += 1;
        break label1231;
        localObject = "";
        break;
        str = "";
        break label61;
        i14 = 1;
        break label1357;
        i15 = 1;
        break label1417;
        i16 = 1;
        break label1477;
        i17 = 1;
        break label1537;
        i18 = 1;
        break label1588;
        i19 = 1;
        if ((i != 0) || (j != 0) || (k != 0) || (n != 0) || (i1 != 0) || (i2 != 0) || (i3 != 0) || (i4 != 0) || (i5 != 0) || (i6 != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i12 != 0) || (i13 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i17 != 0) || (i7 != 0) || (i18 != 0) || (i8 != 0) || (i19 != 0)) {
          break label1642;
        }
      } while (m == 0);
    }
  }
  
  public static boolean checkUrlFormat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return false;
    }
    return true;
  }
  
  private static final String getCertifiedAccountTitle()
  {
    return (String)VSConfigManager.a().a("subscribe_account_title", VSConfigManager.c);
  }
  
  public static String getDefaultName(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return paramContext.getString(2131696415);
    }
    return paramContext.getString(2131695234);
  }
  
  public static int getServiceAccountFolderConfigVersionCode(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("service_account_folder_config_version", 0);
    }
    QLog.d("PublicAccountConfigUtil", 1, "getServiceAccountFolderConfigVersionCode  version:" + i);
    return i;
  }
  
  public static final String getServiceAccountTitle()
  {
    if (isSwitchToCertifiedAccount()) {
      return getCertifiedAccountTitle();
    }
    return HardCodeUtil.a(2131716695);
  }
  
  private static void init(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (list == null) {
      list = new PublicAccountConfigUtilImpl.2(2011, 0, 1000);
    }
    if (!parseConfigXml(paramQQAppInterface, paramContext, SharedPreUtils.e(paramContext)))
    {
      localObject = new IPublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 1, 2131696415, 2130840556);
      list.put(Integer.valueOf(1), localObject);
    }
    Object localObject = SharedPreUtils.h(paramContext);
    String str = SharedPreUtils.i(paramContext);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      paramQQAppInterface = new IPublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 2, 2131695234, 2130840561);
      list.put(Integer.valueOf(2), paramQQAppInterface);
    }
    for (;;)
    {
      initiatedCache.set(true);
      return;
      paramQQAppInterface = new IPublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 2, (String)localObject, str);
      list.put(Integer.valueOf(2), paramQQAppInterface);
    }
  }
  
  public static boolean isClearAllPublicAccountFolderRedNumber()
  {
    return ServiceFolder_RedClean_After_Enter;
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
  
  public static boolean isSwitchToCertifiedAccount()
  {
    return "1".equals((String)VSConfigManager.a().a("subscribe_entrance_enable", "1"));
  }
  
  private static boolean parseConfigXml(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "parseConfigXml xml: " + paramString);
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
          Object localObject = (Element)paramString.item(i);
          int k = Integer.parseInt(((Element)localObject).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
          localObject = new IPublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, k, ((Element)localObject).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
          if (list == null) {
            list = new PublicAccountConfigUtilImpl.3(2011, 0, 1000);
          }
          list.put(Integer.valueOf(k), localObject);
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    return true;
  }
  
  public static boolean updateConfig(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    boolean bool = parseConfigXml(paramQQAppInterface, paramContext, paramString);
    if (bool) {
      SharedPreUtils.f(paramContext, paramString);
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.e("PublicAccountConfigUtil", 2, "updateEqqConfig fail");
    return bool;
  }
  
  public static void updateServiceAccountFolderConfigData(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountConfigUtilImpl.4(paramQQAppInterface));
  }
  
  public static void updateServiceAccountFolderConfigVersionCode(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("service_account_folder_config_version", paramInt);
      paramQQAppInterface.commit();
      QLog.d("PublicAccountConfigUtil", 1, "updateServiceAccountFolderConfigVersionCode success  version:" + paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigVersionCode failed, uin:" + str + ", version:" + paramInt);
  }
  
  public static boolean updateSubscribeConfig(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = paramString.trim();
        paramContext = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramContext.getBytes("utf-8")));
        int i = Integer.parseInt(paramContext.getElementsByTagName("version").item(0).getFirstChild().getNodeValue());
        int j = SubscriptRecommendController.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig prevVersion = " + j + ", version = " + i);
        }
        if (i == j)
        {
          if (!QLog.isColorLevel()) {
            break label338;
          }
          QLog.d("PublicAccountConfigUtil", 2, "IGNORE THIS ACTION because of SAME VERSION");
          break label338;
        }
        paramContext = paramContext.getElementsByTagName("public-account-folder");
        if (paramContext.getLength() <= 0) {
          break label340;
        }
        paramContext = (Element)paramContext.item(0);
        j = Integer.parseInt(paramContext.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
        paramContext = paramContext.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
        SubscriptRecommendController.a(paramQQAppInterface, i);
        SubscriptRecommendController.a(paramQQAppInterface, j, paramContext);
        paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
        if (paramQQAppInterface == null) {
          break label340;
        }
        paramQQAppInterface.startWebProcess(-1, null);
        break label340;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "updateSubscribeConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    label338:
    return false;
    label340:
    return true;
  }
  
  public boolean checkPublicAccountCenterUrlConfigData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (!checkUrlFormat(str1)) {
          break label152;
        }
        PUBLIC_ACCOUNT_CENTER_URL = str1;
        bool1 = true;
        if (checkUrlFormat(str2))
        {
          PUBLIC_ACCOUNT_CATEGORY_URL = str2;
          bool1 = true;
        }
        bool2 = bool1;
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
          return true;
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
      return bool2;
      label152:
      boolean bool1 = false;
    }
  }
  
  public Drawable getDefaultDrawable(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getResources().getDrawable(2130840452);
    case 1: 
      return paramContext.getResources().getDrawable(2130840556);
    }
    return paramContext.getResources().getDrawable(2130840561);
  }
  
  public boolean getDisableBigDataChannel()
  {
    return disableBigDataChannel;
  }
  
  public IPublicAccountConfigUtil.PublicAccountConfigFolder getFolder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3) {
      i = 2;
    }
    if (!initiatedCache.get()) {
      init(paramQQAppInterface, paramContext);
    }
    if (list == null) {
      list = new PublicAccountConfigUtilImpl.1(this, 2011, 0, 1000);
    }
    return (IPublicAccountConfigUtil.PublicAccountConfigFolder)list.get(Integer.valueOf(i));
  }
  
  public String getMergerKandianName(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return getName(paramQQAppInterface, paramContext, 3);
  }
  
  public String getName(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = getFolder(paramQQAppInterface, paramContext, paramInt);
    if (localPublicAccountConfigFolder != null) {
      return localPublicAccountConfigFolder.a();
    }
    return getDefaultName(paramQQAppInterface, paramContext, paramInt);
  }
  
  public String getPublicAccountCategoryUrl()
  {
    return PUBLIC_ACCOUNT_CATEGORY_URL;
  }
  
  public String getPublicAccountCenterUrlConfigData(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    paramQQAppInterface = localObject;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("public_account_center_url_config_data", null);
    }
    return paramQQAppInterface;
  }
  
  public int getPublicAccountCenterUrlConfigVersionCode(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("public_account_center_url_config_version", 0);
    }
    return i;
  }
  
  public int getPublicAccountQQMailConfigVersionCode(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("public_account_qq_mail_config_version", 0);
    }
    return i;
  }
  
  public final String getPublicAccountTitle()
  {
    if (isSwitchToCertifiedAccount()) {
      return getCertifiedAccountTitle();
    }
    return HardCodeUtil.a(2131716695);
  }
  
  public String getReadinjoySearchUrl()
  {
    return READINJOY_SEARCH_URL;
  }
  
  public void getServiceAccountFolderConfigData(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (localSharedPreferences != null)
    {
      SERVICE_ACCOUNT_FOLDER_NAME = localSharedPreferences.getString("service_account_folder_name", null);
      SERVICE_ACCOUNT_FOLDER_ICON = localSharedPreferences.getString("service_account_folder_icon", null);
      SERVICE_ACCOUNT_FOLDER_DELETE = localSharedPreferences.getBoolean("service_account_folder_delete", true);
      ServiceFolder_RedClean_After_Enter = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
      SERVICE_FOLDER_REDSPOTS = localSharedPreferences.getBoolean("service_account_folder_redspots", false);
      readInJoyFeedsPreload = localSharedPreferences.getBoolean("kandian_feeds_preload", false);
      readInJoyFeedsPreloadWifi = localSharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
      readInJoyFeedsPreload4G = localSharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
      readInJoyFeedsPreload3G = localSharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
      readInJoyFeedsPreload2G = localSharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
      needPABottomBar = localSharedPreferences.getBoolean("public_account_bottom_bar", false);
      readInJoyFeedsImagePreload = localSharedPreferences.getBoolean("kandian_feeds_image_preload", false);
      readInJoyflingLToRHost = localSharedPreferences.getString("kandian_feeds_fling_LToR_host", "");
      readInJoyADBackgroundShowTime = localSharedPreferences.getLong("kandian_ad_background_showtime", 3000L);
      readInJoyIpConnect = localSharedPreferences.getBoolean("readInJoy_ip_connect", false);
      readInJoyIpConnectReportSwitch = localSharedPreferences.getInt("readInJoy_ip_connect_full_report", 0);
      readInJoyIpConnectReportTail = localSharedPreferences.getString("readInJoy_ip_connect_report_tail", "");
      readInJoyLoadImg = localSharedPreferences.getBoolean("readInJoy_loading_img", false);
      SERVICE_FOLDER_RED_DELETE = localSharedPreferences.getBoolean("service_account_folder_redspots_delete", false);
      disableBigDataChannel = localSharedPreferences.getBoolean("big_data_share_channel", false);
      localSet = SharedPreferencesHandler.a(localSharedPreferences, "big_data_share_channel_urls", null);
      if (localSet != null) {
        bigDataChannelWhiteList = new ArrayList(localSet);
      }
      imageCollectionPreload = localSharedPreferences.getInt("album_predown_enable", 0);
      imageCollectionPreloadCover = localSharedPreferences.getInt("album_predown_photo_rule", 0);
      imageCollectionPreloadImage = localSharedPreferences.getInt("album_predown_slide_photocounts", 0);
      preloadToolProcess = localSharedPreferences.getBoolean("ad_preload_tool_process", true);
      readInJoyPreloadToolConfig = localSharedPreferences.getString("key_read_in_joy_preload_tool_config", "");
      readInJoyReleaseWebServiceConfig = localSharedPreferences.getString("key_read_in_joy_release_service_config", "");
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "getServiceAccountFolderConfigData success, uin:" + str + ", delete:" + SERVICE_ACCOUNT_FOLDER_DELETE + ", clean:" + ServiceFolder_RedClean_After_Enter + ", redspot:" + SERVICE_FOLDER_REDSPOTS);
      }
    }
    while (!QLog.isColorLevel())
    {
      Set localSet;
      return;
    }
    QLog.d("PublicAccountConfigUtil", 2, "getServiceAccountFolderConfigData failed, uin:" + str);
  }
  
  public String getServiceAccountFolderIcon()
  {
    return SERVICE_ACCOUNT_FOLDER_ICON;
  }
  
  public boolean getServiceFolderRedDelete()
  {
    return SERVICE_FOLDER_RED_DELETE;
  }
  
  public String getSubscriptName(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return getName(paramQQAppInterface, paramContext, 1);
  }
  
  public String getXinKandianName(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return getName(paramQQAppInterface, paramContext, 2);
  }
  
  public boolean isPreloadTooProcess()
  {
    return preloadToolProcess;
  }
  
  public boolean isServiceFolderRedspots()
  {
    return SERVICE_FOLDER_REDSPOTS;
  }
  
  public void loadPublicAccountCenterUrlConfig(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      return;
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
          if (!checkUrlFormat(str2)) {
            break label163;
          }
          PUBLIC_ACCOUNT_CATEGORY_URL = str2;
          if (!paramString.has("readinjoy_search_url")) {
            break label171;
          }
          str1 = paramString.getString("readinjoy_search_url");
          if (checkUrlFormat(str1)) {
            READINJOY_SEARCH_URL = str1;
          }
          if (!paramString.has("image_collection_comment")) {
            break;
          }
          IMAGE_COLLECTION_COMMENT = paramString.getBoolean("image_collection_comment");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
        PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
        IMAGE_COLLECTION_COMMENT = false;
        return;
      }
      PUBLIC_ACCOUNT_CENTER_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      continue;
      label163:
      PUBLIC_ACCOUNT_CATEGORY_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      continue;
      label171:
      updatePublicAccountCenterUrlConfigVersionCode(paramQQAppInterface, 0);
    }
    updatePublicAccountCenterUrlConfigVersionCode(paramQQAppInterface, 0);
  }
  
  public void resetPublicAccountConfig(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "resetPublicAccountConfig uin:" + paramString);
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
  
  public void setPreloadToolProcess(boolean paramBoolean)
  {
    preloadToolProcess = paramBoolean;
  }
  
  public void setServiceAccountFolderIcon(String paramString)
  {
    SERVICE_ACCOUNT_FOLDER_ICON = paramString;
  }
  
  public void updatePublicAccountCenterUrlConfigData(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {}
    try
    {
      paramQQAppInterface = new JSONObject();
      paramQQAppInterface.put("pacenter_url", PUBLIC_ACCOUNT_CENTER_URL);
      paramQQAppInterface.put("pacategory_url", PUBLIC_ACCOUNT_CATEGORY_URL);
      paramQQAppInterface.put("readinjoy_search_url", READINJOY_SEARCH_URL);
      paramQQAppInterface.put("image_collection_comment", IMAGE_COLLECTION_COMMENT);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("public_account_center_url_config_data", paramQQAppInterface.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void updatePublicAccountCenterUrlConfigVersionCode(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("public_account_center_url_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  public void updatePublicAccountQQMailConfigData(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramQQAppInterface = null;
      paramString = null;
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      String str7 = null;
      if (localJSONObject.has("tim_url")) {
        localJSONObject.getString("tim_url");
      }
      if (localJSONObject.has("tim_url_card")) {
        paramQQAppInterface = localJSONObject.getString("tim_url_card");
      }
      if (localJSONObject.has("tim_wording")) {
        paramString = localJSONObject.getString("tim_wording");
      }
      if (localJSONObject.has("tim_url_icon")) {
        str1 = localJSONObject.getString("tim_url_icon");
      }
      if (localJSONObject.has("tim_url_icon_725")) {
        str2 = localJSONObject.getString("tim_url_icon_725");
      }
      if (localJSONObject.has("qim_url_card")) {
        str3 = localJSONObject.getString("qim_url_card");
      }
      if (localJSONObject.has("qim_wording")) {
        str4 = localJSONObject.getString("qim_wording");
      }
      if (localJSONObject.has("qim_url_icon")) {
        str5 = localJSONObject.getString("qim_url_icon");
      }
      if (localJSONObject.has("qim_url_icon_720")) {
        str6 = localJSONObject.getString("qim_url_icon_720");
      }
      if (localJSONObject.has("qim_url_icon_story")) {
        str7 = localJSONObject.getString("qim_url_icon_story");
      }
      if (checkUrlFormat(paramQQAppInterface)) {
        localEditor.putString("profile_card_tim_online_url", paramQQAppInterface);
      }
      if (checkUrlFormat(str1)) {
        localEditor.putString("profile_card_tim_online_icon_url", str1);
      }
      if (checkUrlFormat(str2)) {
        localEditor.putString("profile_card_tim_online_icon_725_url", str2);
      }
      if (!TextUtils.isEmpty(paramString)) {
        localEditor.putString("profile_card_tim_online_wording", paramString);
      }
      if (checkUrlFormat(str3)) {
        localEditor.putString("profile_card_qim_online_url", str3);
      }
      if (checkUrlFormat(str5)) {
        localEditor.putString("profile_card_qim_online_icon_url", str5);
      }
      if (checkUrlFormat(str6)) {
        localEditor.putString("profile_card_qim_online_icon_url_720", str6);
      }
      if (checkUrlFormat(str7)) {
        localEditor.putString("key_story_qim_online_icon_url", str7);
      }
      if (!TextUtils.isEmpty(str4)) {
        localEditor.putString("profile_card_qim_online_wording", str4);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updatePublicAccountQQMailConfigData url_card_tim_online:" + paramQQAppInterface + "; url_card_qim_online:" + str3);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update public account qq mail config error.", paramQQAppInterface);
        }
      }
    }
    localEditor.putInt("public_account_qq_mail_config_version", paramInt);
    localEditor.commit();
  }
  
  public boolean updateReadinjoyFolderConfig(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "update readinjoy folder xml: " + paramString);
        }
        try
        {
          paramString = paramString.trim();
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          Object localObject = paramString.getElementsByTagName("id");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            i = Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue();
            if (i > SharedPreUtils.y(paramQQAppInterface.getApp()))
            {
              localObject = (Element)paramString.getElementsByTagName("name").item(0);
              paramString = (Element)paramString.getElementsByTagName("icon").item(0);
              localObject = ((Element)localObject).getFirstChild().getNodeValue();
              paramString = paramString.getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
                SharedPreUtils.a(paramQQAppInterface.getApp(), (String)localObject, paramString);
              }
              SharedPreUtils.p(paramQQAppInterface.getApp(), i);
              return false;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountConfigUtil", 2, "readinjoy folder config same id ! " + i);
    return false;
  }
  
  public boolean updateSubscriptRecommendConfig(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeRecommendConfig xml: " + paramString);
    }
    label3021:
    label3151:
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject1 = paramString.getElementsByTagName("recommendFullVersion");
        int j;
        Object localObject2;
        int k;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = SubscriptRecommendController.b(paramQQAppInterface);
          if (i <= j) {
            continue;
          }
          localObject1 = (Element)paramString.getElementsByTagName("recommendFullScreen").item(0);
          localObject2 = (Element)paramString.getElementsByTagName("recommendURL").item(0);
          k = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = ((Element)localObject2).getFirstChild().getNodeValue();
          if (k != 1) {
            break label3139;
          }
          bool = true;
          SubscriptRecommendController.a(paramQQAppInterface, bool, (String)localObject1);
          SubscriptRecommendController.b(paramQQAppInterface, i);
          if (k == 1)
          {
            localObject2 = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
            if (localObject2 != null) {
              ((IWebProcessManagerService)localObject2).startWebProcess(66, null);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("SubscriptRecommendConfig update fullrecommend config. version : ").append(i).append(" switch : ");
            if (k != 1) {
              break label3145;
            }
            bool = true;
            QLog.d("PublicAccountConfigUtil", 2, bool + " url : " + (String)localObject1 + " oldVersion : " + j);
          }
        }
        localObject1 = paramString.getElementsByTagName("recommendBottomVersion");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = SubscriptRecommendController.c(paramQQAppInterface);
          if (i <= j) {
            break label3027;
          }
          k = Integer.valueOf(((Element)paramString.getElementsByTagName("recommendBottom").item(0)).getFirstChild().getNodeValue()).intValue();
          if (k != 1) {
            break label3021;
          }
          bool = true;
          SubscriptRecommendController.a(paramQQAppInterface, bool);
          SubscriptRecommendController.c(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update innerrecommend config. preversion -> version " + j + "->" + i + " switch : " + k);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("kandian_read_data").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i != 1) {
            break label3151;
          }
          bool = true;
          SharedPreUtils.b((Context)localObject1, bool);
        }
        localObject1 = paramString.getElementsByTagName("channel_version");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = ReadInJoyHelper.b(paramQQAppInterface);
          if (i <= j) {
            break label3064;
          }
          localObject2 = (Element)paramString.getElementsByTagName("channel_id").item(0);
          Element localElement = (Element)paramString.getElementsByTagName("channel_name").item(0);
          localObject1 = (Element)paramString.getElementsByTagName("channel_type").item(0);
          k = Integer.valueOf(((Element)localObject2).getFirstChild().getNodeValue()).intValue();
          localObject2 = String.valueOf(localElement.getFirstChild().getNodeValue());
          int m = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.a(paramQQAppInterface, k, (String)localObject2, m);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "update channelInfo config. preversion -> version " + j + "->" + i + " channelID : " + k + " channelName: " + (String)localObject2 + " channelType: " + m);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("video_sound").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i != 0) {
            break label3101;
          }
          bool = true;
          SharedPreUtils.c((Context)localObject1, bool);
          localObject1 = VideoVolumeControl.a();
          if (i != 0) {
            break label3107;
          }
          bool = true;
          ((VideoVolumeControl)localObject1).a(bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get video sound config " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_support_enable");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (i <= 0) {
            break label3113;
          }
          bool = true;
          ReadInJoyHelper.b(paramQQAppInterface, bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "updateSupportMultiVideoSwitch， supportEnable = " + i);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("rn_switch").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i == 1) {
            break label3119;
          }
          bool = true;
          SharedPreUtils.a((Context)localObject1, bool, paramQQAppInterface.getCurrentUin());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get interesrLableRn config " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_struct_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3125;
          }
          bool = true;
          ReadInJoyHelper.d(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("video_social_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3131;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "parse kandian video social switch = " + bool);
          }
          ReadInJoyHelper.j(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel auto play switch default value = " + i);
          }
          ReadInJoyHelper.b(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("video_jump_to");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video jump default value = " + i);
          }
          ReadInJoyHelper.d(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("defaultBitRate");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          localObject1 = (Element)((NodeList)localObject1).item(0);
          ReadInJoyHelper.w(paramQQAppInterface, ((Element)localObject1).getFirstChild().getNodeValue());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "defaultBitRate value = " + ((Element)localObject1).getFirstChild().getNodeValue());
          }
        }
        localObject1 = paramString.getElementsByTagName("CUKingCard_Dlg");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.e(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "CUKingCardDlg value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_channel_style");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.l(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_channel_style value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_strategyid");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.m(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_strategyid value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_limit");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.n(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_limit value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_percent");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          float f = Float.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).floatValue();
          ReadInJoyHelper.a(paramQQAppInterface, f);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_percent value = " + f);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_operator");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.o(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_operator value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.p(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_switch value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_mode");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.q(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_mode value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay_18mo");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video flow video channel auto play switch default value = " + i);
          }
          ReadInJoyHelper.c(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("click_videocard_jump_comment");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel feeds click switch default value = " + i);
          }
          ReadInJoyHelper.a(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("viola_dynamic_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.r(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic default value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("viola_dynamic_weishi_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.s(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic weishi default value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("viola_discover_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.t(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic discover default value = " + i);
          }
        }
        paramString = paramString.getElementsByTagName("viola_message_box_switch");
        if ((paramString == null) || (paramString.getLength() <= 0)) {
          break label3137;
        }
        i = Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue();
        ReadInJoyHelper.u(paramQQAppInterface, i);
        if (!QLog.isColorLevel()) {
          break label3137;
        }
        QLog.d("PublicAccountConfigUtil", 2, "viola dynamic message box default value = " + i);
        break label3137;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig same version ! " + i);
        continue;
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update subscript recommend config error." + paramQQAppInterface);
        }
        return false;
      }
      continue;
      label3027:
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update fail same version " + i);
        continue;
        label3064:
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountConfigUtil", 2, "update channelInfo fail same version " + i);
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          return true;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl
 * JD-Core Version:    0.7.0.1
 */