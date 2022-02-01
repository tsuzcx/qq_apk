package com.tencent.mfsdk.collector;

import achn;
import acjp;
import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import bcad;
import bkwv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

@TargetApi(16)
public class DropFrameMonitor
{
  public static final int DROP_RANGE_0 = 0;
  public static final int DROP_RANGE_1 = 1;
  public static final int DROP_RANGE_2_4 = 2;
  public static final int DROP_RANGE_4_8 = 3;
  public static final int DROP_RANGE_8_15 = 4;
  public static final int DROP_RANGE_BIGGER = 5;
  public static final String LIST_AIO_PREFIX = "list_aio_";
  public static final String LIST_ALL_CONTACTS = "list_a_contacts";
  public static final String LIST_CONVERSATION = "list_conv";
  public static final String LIST_DAILY = "list_readinjoy_daily";
  public static final String LIST_DAILY_LITE = "list_readinjoy_daily_lite";
  public static final String LIST_DATALINE_MPFILE = "list_dataline_mp";
  public static final String LIST_GROUP_CONTACTS = "list_g_contacts";
  public static final String LIST_KANDIAN_ATLAS = "list_kandian_atlas";
  public static final String LIST_KANDIAN_DAILY_NEW = "list_kandian_daily_new";
  public static final String LIST_KANDIAN_NATIVE_WEB = "list_kandian_native_web";
  public static final String LIST_KANDIAN_NATIVE_WEB_LITE = "list_kandian_native_web_lite";
  public static final String LIST_KANDIAN_VIOLA = "list_kandian_viola";
  public static final String LIST_LEBA = "list_leba";
  public static final String LIST_LEBA_NEW = "list_leba_new";
  public static final String LIST_NATIVE_COMMENT = "list_comment_kandian";
  public static final String LIST_NEW_KANDIAN = "list_new_kandian";
  public static final String LIST_PHOTO = "list_photo";
  public static final String LIST_QLINK_TRANS = "list_qlink_trans";
  public static final String LIST_QQSTORY_DETAIL = "list_qqstory_detail";
  public static final String LIST_QQSTORY_HOME = "list_qqstory_home";
  public static final String LIST_QQSTORY_MEMORIES = "list_qqstory_memories";
  public static final String LIST_QQSTORY_TROOP = "list_qqstory_troop";
  public static final String LIST_SUBSCRIPT = "list_subscript";
  public static final String LIST_UNITE_SEARCH = "list_unite_search";
  public static final String LIST_VIDEO_FEEDS = "list_video_feeds";
  public static final String LIST_VIDEO_KANDIAN = "list_video_kandian";
  public static final String QCIRCLE_ALL_PUSH_TAB_PAGE = "qcircle_all_push_tab_page";
  public static final String QCIRCLE_CHAT_LIST = "qcircle_chat_list";
  public static final String QCIRCLE_COMMENT_PAGE = "qcircle_comment_page";
  public static final String QCIRCLE_CONTENT_PAGE = "qcircle_content_page";
  public static final String QCIRCLE_FOLLOW_TAB_PAGE = "qcircle_follow_tab_page";
  public static final String QCIRCLE_FOLLOW_TAG_LIST = "qcircle_follow_tag_list";
  public static final String QCIRCLE_FOLLOW_USER_LIST = "qcircle_follow_user_list";
  public static final String QCIRCLE_MESSAGE_NOTICE = "qcircle_message_notice_page";
  public static final String QCIRCLE_PERSONAL_DETAIL_PAGE = "qcircle_personal_detail_page";
  public static final String QCIRCLE_POLYMERIZATION_PAGE = "qcircle_polymerization_page";
  public static final String QCIRCLE_SPECIAL_FOLLOW_LIST = "qcircle_special_follow_list";
  public static final String QCIRCLE_TAG_PAGE = "qcircle_tag_page";
  public static final String QCIRLE_BLACK_LIST_PAGE = "qcircle_black_list";
  public static final String QCIRLE_LIKE_LIST_PAGE = "qcircle_like_page";
  public static final String QZONE_ALBUM_FIRST_PAGE = "qzone_album_first_page";
  public static final String QZONE_ALBUM_SECOND_PAGE = "qzone_album_second_page";
  public static final String QZONE_EVENTTAGPAGE = "qzone_eventtag";
  public static final String QZONE_EXTEND_FEEDS = "qzone_extendFeeds";
  public static final String QZONE_FAMOUSSPACE = "qzone_famousspace";
  public static final String QZONE_GROUPFEED = "qzone_groupfeed";
  public static final String QZONE_HOMEPAGE = "qzone_homepage";
  public static final String QZONE_MOODLIST = "qzone_moodlist";
  public static final String QZONE_MYFEED = "qzone_myfeed";
  public static final String QZONE_NEWFEED = "qzone_newfeed";
  public static final String QZONE_NUAN_FRIEND_FEED = "qzone_recommend_feed";
  public static final String QZONE_PICTURE_VIEWER = "qzone_picture_viewer";
  public static final String QZONE_RECOMMEND_FEED = "qzone_recommend_feed";
  public static final String QZONE_RELATIONFEED = "qzone_relationfeed";
  public static final String QZONE_SPECIALACTIVEFEEDS = "qzone_specialactivefeeds";
  public static final String QZONE_USERHOME = "qzone_userhome";
  public static final String QZONE_VIDEO_FLOAT_PAGE = "qzone_video_float_page";
  public static final String QZONE_VIDEO_TIAN_TAI_PAGE = "qzone_video_float_tian_tai_page";
  public static final int RANGE_COUNT = 6;
  private static final String TAG = "AutoMonitor.DropFrame";
  public static final String VAS_PROFILECARD_LIST = "vas_profilecard_list";
  public static final String WEISHI_FOLLOW_LIST = "weishi_follow_list";
  public static final String WEISHI_RECOMMEND_LIST = "weishi_recommend_list";
  public static final String WEISHI_VIDEO_PLAY_LIST = "weishi_video_play_list";
  private static DropFrameMonitor sInstance;
  private static long sLastSyncMsgTimeForLogin;
  
  public static DropFrameMonitor getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new DropFrameMonitor();
      }
      return sInstance;
    }
    finally {}
  }
  
  private static boolean isInQZoneProcess()
  {
    return 2 == BaseApplicationImpl.sProcessId;
  }
  
  public static void notifyMsgSyncedForLogin()
  {
    sLastSyncMsgTimeForLogin = SystemClock.uptimeMillis();
  }
  
  @NotNull
  public static HashMap<String, String> uploadDropFrameToDenta(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    bkwv.a().a(paramString, paramLong2, paramArrayOfLong, paramLong1);
    if (QLog.isColorLevel()) {
      Log.d("AutoMonitor.DropFrame", "tag = " + paramString + ", dropCount = " + paramLong2 + ", " + Arrays.toString(paramArrayOfLong) + ", totalMs = " + paramLong1);
    }
    if (isInQZoneProcess()) {}
    double d1 = paramArrayOfLong[4];
    double d2 = paramArrayOfLong[5];
    double d3 = paramArrayOfLong[0];
    double d4 = paramArrayOfLong[1];
    double d5 = paramArrayOfLong[2];
    double d6 = paramArrayOfLong[3];
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("dropCount", String.valueOf(paramLong2));
    localHashMap.put("totalMs", String.valueOf(paramLong1));
    localHashMap.put("scene", paramString);
    localHashMap.put("dropTimes", Arrays.toString(paramArrayOfLong));
    localHashMap.put("themeId", QQAppInterface.getCurrentThemeId());
    localHashMap.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
    String str1;
    String str2;
    String str3;
    if (sLastSyncMsgTimeForLogin > 0L)
    {
      paramLong1 = SystemClock.uptimeMillis() - sLastSyncMsgTimeForLogin;
      localHashMap.put("intervalAfterSyncMsg", String.valueOf(paramLong1));
      localHashMap.put("hcState", String.valueOf(acjp.a().a()));
      localHashMap.put("dropFenzi", String.valueOf(266.72000000000003D * d2 + 200.04000000000002D * d1));
      localHashMap.put("dropFenzi2", String.valueOf(16.699999999999999D * d3 + 25.049999999999997D * d4 + 50.099999999999994D * d5 + 100.19999999999999D * d6));
      if (bcad.l)
      {
        paramArrayOfLong = "-1";
        str1 = "-1";
        str2 = "-1";
        str3 = "-1";
        paramLong1 = System.currentTimeMillis();
        if (AutomatorFinish.a != -1L) {
          break label532;
        }
      }
    }
    label532:
    for (paramString = "-1";; paramString = String.valueOf(paramLong1 - AutomatorFinish.a))
    {
      if (bcad.e != 0L) {
        paramArrayOfLong = String.valueOf(paramLong1 - bcad.e);
      }
      if (bcad.d != 0L) {
        str1 = String.valueOf(paramLong1 - bcad.d);
      }
      if (bcad.g != 0L) {
        str2 = String.valueOf(paramLong1 - bcad.g);
      }
      if (bcad.f != 0L) {
        str3 = String.valueOf(paramLong1 - bcad.f);
      }
      localHashMap.put("perfConfigReportValue", String.valueOf(bcad.c));
      localHashMap.put("qZoneInterval", paramArrayOfLong);
      localHashMap.put("miniInterval", str1);
      localHashMap.put("troopListInterval", str2);
      localHashMap.put("preDownloadInterval", str3);
      localHashMap.put("automatorFinishtime", paramString);
      UnifiedMonitor.a().addEvent(9, null, 0, 0, localHashMap);
      return localHashMap;
      paramLong1 = -1L;
      break;
    }
  }
  
  public void startMonitorScene(String paramString)
  {
    MagnifierSDK.a().a().a(paramString);
    if (paramString.equals("qzone_homepage")) {
      acjp.a().a(0, 1, 1, 0, 1500, 701, 32L, Process.myTid(), "qzoneList", false);
    }
    while (!paramString.equals("list_photo")) {
      return;
    }
    acjp.a().a(0, 1, 1, 0, 1500, 702, 32L, Process.myTid(), "photoList", false);
  }
  
  public void stopMonitorScene(String paramString, boolean paramBoolean)
  {
    MagnifierSDK.a().a().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mfsdk.collector.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */