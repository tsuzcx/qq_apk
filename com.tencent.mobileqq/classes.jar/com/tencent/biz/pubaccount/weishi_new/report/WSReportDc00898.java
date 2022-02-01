package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushOpModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class WSReportDc00898
{
  private static final String[] a = { "frdvideoplay_clk", "frdvideoplay_clk_ws", "frdvideoplay_dl_ws", "frdvideoplay_dl_fin", "frdvideoplay_install" };
  private static final String[] b = { "qzonevideo_exp_ws", "qzonevideo_clk_ws", "qzonevideo_dl_ws", "qzonevideo_dl_fin", "qzonevideo_install" };
  
  public static String a()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
    if (i == 1) {
      return "WiFi";
    }
    if (i == 2) {
      return "2G";
    }
    if (i == 3) {
      return "3G";
    }
    if (i == 4) {
      return "4G";
    }
    return "Other";
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "weishi_share_officialacc";
    }
    if (paramInt == 2) {
      return "weishi_share_trendstab";
    }
    return "";
  }
  
  public static String a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return "";
    }
    stWaterFallCardStyle localstWaterFallCardStyle = paramstSimpleMetaFeed.waterFallCardStyle;
    HashMap localHashMap = new HashMap();
    boolean bool = true;
    localHashMap.put("position", Integer.valueOf(paramInt + 1));
    if (localstWaterFallCardStyle != null) {
      paramInt = localstWaterFallCardStyle.cardType;
    } else {
      paramInt = 1;
    }
    localHashMap.put("cardtype", Integer.valueOf(paramInt));
    localHashMap.put("feedid", paramstSimpleMetaFeed.id);
    localHashMap.put("poolType", Integer.valueOf(paramstSimpleMetaFeed.videoPoolType));
    if (localstWaterFallCardStyle != null) {
      paramInt = localstWaterFallCardStyle.ratioW;
    } else {
      paramInt = 0;
    }
    localHashMap.put("ratioW", Integer.valueOf(paramInt));
    if (localstWaterFallCardStyle != null) {
      paramInt = localstWaterFallCardStyle.ratioH;
    } else {
      paramInt = 0;
    }
    localHashMap.put("ratioH", Integer.valueOf(paramInt));
    if ((localstWaterFallCardStyle == null) || (!localstWaterFallCardStyle.isFullSpan)) {
      bool = false;
    }
    localHashMap.put("isFullSpan", Boolean.valueOf(bool));
    localHashMap.put("dynamic_cover", Integer.valueOf(0));
    localHashMap.put("cover_type", WeishiUtils.a(paramstSimpleMetaFeed));
    return new JSONObject(localHashMap).toString();
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    String str3 = "popup_install";
    String str4 = "popup_dl_fin";
    String str1;
    String str2;
    if (paramInt != 300) {
      if (paramInt != 302) {
        if (paramInt != 501) {
          if (paramInt != 401)
          {
            str1 = str3;
            str2 = str4;
            if (paramInt == 402) {
              break label320;
            }
            str1 = str3;
            str2 = str4;
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          str1 = "";
          str2 = str1;
          break;
        case 603: 
          str2 = "home_ps_menu_dl_fin";
          str1 = "home_ps_menu_install";
          break;
        case 602: 
          str2 = "home_msg_menu_dl_fin";
          str1 = "home_msg_menu_install";
          break;
        case 601: 
          str2 = "home_msg_bubble_dl_fin";
          str1 = "home_msg_bubble_install";
        }
        break;
      case 101: 
      case 102: 
      case 103: 
        str2 = "msg_dl_fin";
        str1 = "msg_install";
        break;
      case 100: 
      case 104: 
        str2 = "feeds_dl_ws_fin";
        str1 = "feeds_dl_ws_install";
      }
      break;
    case 9: 
    case 10: 
    case 11: 
      str2 = "popup_dl_ws_fin";
      str1 = "popup_ws_install";
      break;
    case 8: 
      str2 = "lens_dl_ws_fin";
      str1 = "lens_install";
      break;
    case 4: 
      str2 = "videolay_tag_dl_fin";
      str1 = "videolay_tag_install";
      break;
    case 3: 
      str2 = "videoplay_title_dl_fin";
      str1 = "videoplay_title_install";
      break;
    case 2: 
      str2 = "follow_dl_fin";
      str1 = "follow_install";
      break;
    case 1: 
      str2 = "videolay_prof_dl_fin";
      str1 = "videolay_prof_install";
      break;
      str2 = "feeds_popup_dl_fin";
      str1 = "feeds_popup_install";
      break;
      str2 = "feeds_opcard_dl_ws_fin";
      str1 = "feeds_opcard_install_ws";
      break;
      str2 = "ftest_dl_ws_fin";
      str1 = "ftest_dl_ws_install";
      break;
      str2 = "dtest_dl_fin";
      str1 = "dtest_dl_install";
    }
    label320:
    if (paramBoolean) {
      return str2;
    }
    return str1;
  }
  
  public static String a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    String str2 = "0";
    String str1;
    boolean bool;
    if (paramWSRedDotPushMsg != null)
    {
      str2 = paramWSRedDotPushMsg.mFeedIds;
      str1 = paramWSRedDotPushMsg.mPushId;
      bool = WeishiUtils.a(paramWSRedDotPushMsg);
      paramWSRedDotPushMsg = str2;
    }
    else
    {
      str1 = "0";
      bool = false;
      paramWSRedDotPushMsg = str2;
    }
    localHashMap.put("feed_id", paramWSRedDotPushMsg);
    localHashMap.put("push_id", str1);
    if (bool) {
      i = 1;
    }
    localHashMap.put("preload_status", Integer.valueOf(i));
    localHashMap.put("networkType", a());
    localHashMap.put("ipAddress", WSDeviceUtils.a());
    return new JSONObject(localHashMap).toString();
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "0";
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = "0";
    }
    localHashMap.put("feed_id", str);
    localHashMap.put("push_id", paramString2);
    localHashMap.put("preload_status", Integer.valueOf(paramInt2));
    localHashMap.put("feeds_list_type", Integer.valueOf(paramInt3));
    localHashMap.put("preload_count", Integer.valueOf(paramInt1));
    localHashMap.put("networkType", a());
    localHashMap.put("ipAddress", WSDeviceUtils.a());
    return new JSONObject(localHashMap).toString();
  }
  
  public static void a()
  {
    a("officialacc_weishi", "feeds_clk", 0, 0, -1L, 0L, "", b());
    a("weishi_share_officialacc", "feeds_clk_ws", 0, 0, -1L, 0L, "", b());
  }
  
  public static void a(int paramInt)
  {
    a("weishi_share_officialacc", "start_dl_ws_fin", paramInt, 0, WSGlobalConfig.a().b(), 0L, "", "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a("weishi_share_officialacc", "start_install_ws", paramInt2, 0, paramInt1, 0L, "", "");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("optionId:");
    ((StringBuilder)localObject).append(paramInt3);
    WSLog.c("898", ((StringBuilder)localObject).toString());
    localObject = WeishiUtils.a(4);
    String str = String.valueOf(paramInt3);
    if (paramInt1 != 6)
    {
      if (paramInt1 != 112)
      {
        if (paramInt1 != 140)
        {
          if (paramInt1 != 114)
          {
            if (paramInt1 != 115) {
              return;
            }
            a("weishi_share_officialacc", "msg_dl_ws", paramInt2, 0, 0L, 0L, str, (String)localObject);
            return;
          }
          a("weishi_share_officialacc", "msg_clk_ws", paramInt2, 0, 0L, 0L, str, (String)localObject);
          return;
        }
        a("weishi_share_officialacc", "msg_clk_h5", paramInt2, 0, 0L, 0L, str, (String)localObject);
        return;
      }
      a("weishi_share_officialacc", "msg_clk", paramInt2, 0, 0L, 0L, str, (String)localObject);
      return;
    }
    a("weishi_share_officialacc", "msg_entry_exp", paramInt2, 0, 0L, 0L, str, (String)localObject);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("optionId:");
    ((StringBuilder)localObject).append(paramInt4);
    WSLog.d("898", ((StringBuilder)localObject).toString());
    localObject = String.valueOf(paramInt4);
    if (paramInt1 != 6)
    {
      if (paramInt1 != 112)
      {
        if (paramInt1 != 140)
        {
          if (paramInt1 != 114)
          {
            if (paramInt1 != 115) {
              return;
            }
            a("weishi_share_officialacc", "feeds_opcard_dl_ws", paramInt2, 0, paramInt3, 0L, (String)localObject, b());
            return;
          }
          a("weishi_share_officialacc", "feeds_opcard_clk_ws", paramInt2, 0, paramInt3, 0L, (String)localObject, b());
          return;
        }
        a("weishi_share_officialacc", "feeds_opcard_clk_h5", paramInt2, 0, paramInt3, 0L, (String)localObject, b());
        return;
      }
      a("weishi_share_officialacc", "feeds_op_card_clk", paramInt2, 0, paramInt3, 0L, (String)localObject, b());
      return;
    }
    a("weishi_share_officialacc", "feeds_op_card_exp", paramInt2, 0, paramInt3, 0L, (String)localObject, b());
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString)
  {
    a("officialacc_weishi", "gzh_clk_H5", paramInt1, 0, paramInt2, 0L, paramString, "");
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new WSReportDc00898.1(paramInt, paramObject));
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1)
    {
      a("officialacc_weishi", "weishi_share_officialacc", paramBoolean1, paramBoolean2);
      return;
    }
    if (paramInt == 2) {
      a("trandstab_weishi", "weishi_share_trendstab", paramBoolean1, paramBoolean2);
    }
  }
  
  public static void a(WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    if (paramWSDownloadParams == null) {
      return;
    }
    a("weishi_share_officialacc", "start_dl_ws", paramInt, 0, WSGlobalConfig.a().b(), 0L, "", paramWSDownloadParams.mTestId);
  }
  
  public static void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.a == null) {
        return;
      }
      paramWSPlayerParam = WSReportDC898Vertical.a(paramWSPlayerParam, paramBoolean);
      paramWSPlayerParam = new Gson().toJson(paramWSPlayerParam);
      a(WSReportUtils.a(), "focus_video_play", 0, 0, 0L, 0L, paramWSPlayerParam, WeishiUtils.a(9));
    }
  }
  
  public static void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg != null)
    {
      IWSPushBaseStrategy localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
      boolean bool = localIWSPushBaseStrategy instanceof WSPushStrategyInfo;
      int i = 0;
      int j = 0;
      if (bool)
      {
        localObject = (WSPushStrategyInfo)localIWSPushBaseStrategy;
        i = j;
        if (((WSPushStrategyInfo)localObject).mWSPushModel != null) {
          i = ((WSPushStrategyInfo)localObject).mWSPushModel.a;
        }
        j = ((WSPushStrategyInfo)localObject).getType();
      }
      else
      {
        j = 0;
      }
      if (j == 3) {
        j = 1;
      }
      long l1;
      if (WeishiGuideUtils.a(BaseApplicationImpl.getApplication().getApplicationContext())) {
        l1 = 1L;
      } else {
        l1 = 0L;
      }
      long l2 = i;
      Object localObject = paramWSRedDotPushMsg.mPushId;
      if (localIWSPushBaseStrategy != null) {
        paramWSRedDotPushMsg = localIWSPushBaseStrategy.getAbTest();
      } else {
        paramWSRedDotPushMsg = "";
      }
      a("officialacc_weishi", "push_text_clk", j, 0, l1, l2, (String)localObject, paramWSRedDotPushMsg);
    }
  }
  
  public static void a(WSRedDotPushMsg paramWSRedDotPushMsg, boolean paramBoolean)
  {
    int i;
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null)) {
      i = paramWSRedDotPushMsg.mStrategyInfo.getType();
    } else {
      i = 0;
    }
    if (paramBoolean) {
      paramWSRedDotPushMsg = "1";
    } else {
      paramWSRedDotPushMsg = "2";
    }
    a("trandstab_weishi", "trandstab_clk", i, 0, 0L, 0L, paramWSRedDotPushMsg, "");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString3, String paramString4)
  {
    ReportController.b(null, "dc00898", "", "", a(paramString1), a(paramString2), paramInt1, paramInt2, String.valueOf(paramLong1), String.valueOf(paramLong2), paramString3, paramString4);
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(paramString1, "network_popup_exp", 0, 0, 0L, 0L, "", "");
      return;
    }
    if (paramBoolean2)
    {
      a(paramString2, "network_dl_confirm", 0, 0, 0L, 0L, "", "");
      return;
    }
    a(paramString1, "network_dl_cancel", 0, 0, 0L, 0L, "", "");
  }
  
  public static void a(Map<String, String> paramMap)
  {
    paramMap = new JSONObject(paramMap);
    a(WSReportUtils.a(), "recommend_report_fail", 0, 0, 0L, 0L, paramMap.toString(), "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("weishi_share_zhibo", "zhibo_feeds_clk", 0, 0, 0L, 0L, "", b());
      return;
    }
    a("weishi_share_zhibo", "zhibo_feeds_exp", 0, 0, 0L, 0L, "", b());
  }
  
  public static void a(boolean paramBoolean, WSDownloadParams paramWSDownloadParams)
  {
    if (paramWSDownloadParams == null) {
      return;
    }
    String str = a(paramWSDownloadParams.mScene);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (paramBoolean)
    {
      a(str, "dl_clk_QQdownloader", 0, 0, 0L, 0L, "", paramWSDownloadParams.mTestId);
      return;
    }
    a(str, "dl_clk_officialdownloader", WSGlobalConfig.a().b(), 0, 0L, 0L, "", paramWSDownloadParams.mTestId);
  }
  
  public static String b()
  {
    return WeishiUtils.a(1);
  }
  
  public static void b()
  {
    a("trandstab_weishi", "push_clk", 0, 0, 0L, 0L, "", "");
  }
  
  public static void b(int paramInt)
  {
    a("weishi_share_officialacc", "start_install_ws_fin", paramInt, 0, 0L, 0L, "", "");
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("optionId:");
    ((StringBuilder)localObject).append(paramInt3);
    WSLog.c("898", ((StringBuilder)localObject).toString());
    localObject = String.valueOf(paramInt3);
    if (paramInt1 != 6)
    {
      if (paramInt1 != 112) {
        return;
      }
      a("weishi_share_officialacc", "comment_popup_clk", paramInt2, 0, 0L, 0L, (String)localObject, "");
      return;
    }
    a("officialacc_weishi", "comment_popup_exp", 0, 0, 0L, 0L, (String)localObject, "");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("officialacc_weishi", "blanktips_clk", 0, 0, 0L, 0L, "", "");
      return;
    }
    a("officialacc_weishi", "blanktips_exp", 0, 0, 0L, 0L, "", "");
  }
  
  public static void c()
  {
    a(WSReportUtils.a(), "focus_exp", 0, 0, 0L, 0L, UserAction.getQIMEI(), WeishiUtils.a(9));
  }
  
  public static void c(int paramInt)
  {
    a("trandstab_weishi", "trandstab_clk_H5", paramInt, 0, 0L, 0L, "", "");
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("optionId:");
    ((StringBuilder)localObject).append(paramInt3);
    WSLog.d("898", ((StringBuilder)localObject).toString());
    localObject = String.valueOf(paramInt3);
    if (paramInt1 != 6)
    {
      if (paramInt1 != 112)
      {
        if (paramInt1 != 117)
        {
          if (paramInt1 != 114)
          {
            if (paramInt1 != 115) {
              return;
            }
            a("weishi_share_officialacc", "feeds_popup_dl_ws", paramInt2, 0, 0L, 0L, (String)localObject, b());
            return;
          }
          a("weishi_share_officialacc", "feeds_popup_clk_ws", paramInt2, 0, 0L, 0L, (String)localObject, b());
          return;
        }
        a("officialacc_weishi", "feeds_popup_close", paramInt2, 0, 0L, 0L, (String)localObject, b());
        return;
      }
      a("weishi_share_officialacc", "feeds_popup_clk", paramInt2, 0, 0L, 0L, (String)localObject, b());
      return;
    }
    a("weishi_share_officialacc", "feeds_popup_exp", paramInt2, 0, 0L, 0L, (String)localObject, b());
  }
  
  private static String d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("networkType", a());
    localHashMap.put("ipAddress", WSDeviceUtils.a());
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898
 * JD-Core Version:    0.7.0.1
 */