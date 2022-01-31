package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config;

import ahfl;
import android.text.TextUtils;
import bbkk;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpringFestivalRedpacketConfBean
  implements Serializable
{
  public SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig htmlOfflineCheckConfig = new SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig();
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo springFestivalHbEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo();
  public int taskId;
  public int version;
  
  private static SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.optJSONObject("htmloffline_check_configs");
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, "parseHtmlOfflineCheckConfigs: " + paramJSONObject);
      }
    } while (paramJSONObject == null);
    SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig localHtmlOfflineCheckConfig = new SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig();
    localHtmlOfflineCheckConfig.bids = paramJSONObject.optString("bids");
    localHtmlOfflineCheckConfig.time_interval = paramJSONObject.optInt("time_interval", 24);
    localHtmlOfflineCheckConfig.total_cnt = paramJSONObject.optInt("total_cnt", 3);
    localHtmlOfflineCheckConfig.net_type = paramJSONObject.optString("net_type");
    localHtmlOfflineCheckConfig.checkDomain = paramJSONObject.optString("check_domain");
    return localHtmlOfflineCheckConfig;
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo a(JSONObject paramJSONObject)
  {
    int i = 0;
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo localFixedEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo();
    if (paramJSONObject == null) {
      return localFixedEntryInfo;
    }
    paramJSONObject = paramJSONObject.optJSONObject("fixed_entry");
    if (paramJSONObject == null) {
      return localFixedEntryInfo;
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, "parseFixedEntryInfo: " + paramJSONObject);
    }
    localFixedEntryInfo.defaultBanner = paramJSONObject.optString("default_banner");
    localFixedEntryInfo.useStagger = paramJSONObject.optInt("use_stagger_peak", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("entry_banner_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo localBannerInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo();
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = ahfl.a(localJSONObject.optString("start_time"));
          localTimeInfo.endTime = ahfl.a(localJSONObject.optString("end_time"));
          localBannerInfo.bannerTime = localTimeInfo;
          localBannerInfo.bannerUrl = localJSONObject.optString("banner_url");
          localBannerInfo.previewActivityUrl = localJSONObject.optString("preview_activity_url");
          localBannerInfo.popUpBgUrl = localJSONObject.optString("popup_bg_url");
          localArrayList.add(localBannerInfo);
        }
        i += 1;
      }
      localFixedEntryInfo.entryBannerList = localArrayList;
    }
    localFixedEntryInfo.staggerPeakIntervalBefore = paramJSONObject.optInt("stagger_peak_interval_before", 180);
    if (localFixedEntryInfo.staggerPeakIntervalBefore > 3600) {
      localFixedEntryInfo.staggerPeakIntervalBefore = 3600;
    }
    for (;;)
    {
      localFixedEntryInfo.staggerPeakIntervalBefore *= 1000;
      return localFixedEntryInfo;
      if (localFixedEntryInfo.staggerPeakIntervalBefore <= 0) {
        localFixedEntryInfo.staggerPeakIntervalBefore = 180;
      }
    }
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo a(JSONObject paramJSONObject)
  {
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo localLoadingInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo();
    if (paramJSONObject == null) {}
    JSONObject localJSONObject;
    do
    {
      return localLoadingInfo;
      localJSONObject = paramJSONObject.optJSONObject("loading");
    } while (localJSONObject == null);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, "parseLoadingInfo: " + paramJSONObject);
    }
    localLoadingInfo.loadingUrl = localJSONObject.optString("loading_url");
    localLoadingInfo.loadingTips = localJSONObject.optString("loading_tips");
    paramJSONObject = new SpringFestivalRedpacketConfBean.TimeInfo();
    paramJSONObject.beginTime = ahfl.a(localJSONObject.optString("start_time"));
    paramJSONObject.endTime = ahfl.a(localJSONObject.optString("end_time"));
    localLoadingInfo.loadingTime = paramJSONObject;
    return localLoadingInfo;
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo a(JSONObject paramJSONObject)
  {
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo localPendantEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo();
    if (paramJSONObject == null) {
      return localPendantEntryInfo;
    }
    paramJSONObject = paramJSONObject.optJSONObject("pendant");
    if (paramJSONObject == null) {
      return localPendantEntryInfo;
    }
    localPendantEntryInfo.defaultResUrl = paramJSONObject.optString("default_res_url");
    localPendantEntryInfo.defaultVideoUrl = paramJSONObject.optString("default_transition_video");
    localPendantEntryInfo.transitionBg = paramJSONObject.optString("transition_bg");
    localPendantEntryInfo.loading = paramJSONObject.optString("pull_loading");
    localPendantEntryInfo.forbidRefresh = paramJSONObject.optInt("forbid_refresh");
    localPendantEntryInfo.miniSmallBg = paramJSONObject.optString("mini_small_bg");
    localPendantEntryInfo.forbidRefreshIntervalBefore = paramJSONObject.optInt("forbid_refresh_interval_before", 180);
    if (localPendantEntryInfo.forbidRefreshIntervalBefore > 3600)
    {
      localPendantEntryInfo.forbidRefreshIntervalBefore = 3600;
      localPendantEntryInfo.forbidRefreshIntervalBefore *= 1000;
      localPendantEntryInfo.forbidRefreshIntervalAfter = paramJSONObject.optInt("forbid_refresh_interval_after", 780);
      if (localPendantEntryInfo.forbidRefreshIntervalAfter <= 3600) {
        break label434;
      }
      localPendantEntryInfo.forbidRefreshIntervalAfter = 3600;
    }
    ArrayList localArrayList;
    for (;;)
    {
      localPendantEntryInfo.forbidRefreshIntervalAfter *= 1000;
      JSONArray localJSONArray = paramJSONObject.optJSONArray("activity_list");
      if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
        return localPendantEntryInfo;
      }
      localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo();
          localActivityInfo.id = localJSONObject.optString("activity_id");
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = ahfl.a(localJSONObject.optString("start_time"));
          localTimeInfo.endTime = ahfl.a(localJSONObject.optString("end_time"));
          localActivityInfo.activityTime = localTimeInfo;
          localActivityInfo.resUrl = localJSONObject.optString("res_url");
          localActivityInfo.videoUrl = localJSONObject.optString("transition_video_url");
          localActivityInfo.logoUrl = localJSONObject.optString("logo_url");
          String str = localJSONObject.optString("pendant_end_time");
          paramJSONObject = str;
          if (bbkk.a(str)) {
            paramJSONObject = localJSONObject.optString("end_time");
          }
          localActivityInfo.pendantEndTime = ahfl.a(paramJSONObject);
          if ((localActivityInfo.pendantEndTime > localTimeInfo.endTime) || (localActivityInfo.pendantEndTime <= 0L)) {
            localActivityInfo.pendantEndTime = localTimeInfo.endTime;
          }
          localArrayList.add(localActivityInfo);
        }
        i += 1;
      }
      if (localPendantEntryInfo.forbidRefreshIntervalBefore > 0) {
        break;
      }
      localPendantEntryInfo.forbidRefreshIntervalBefore = 180;
      break;
      label434:
      if (localPendantEntryInfo.forbidRefreshIntervalAfter <= 0) {
        localPendantEntryInfo.forbidRefreshIntervalAfter = 780;
      }
    }
    localPendantEntryInfo.activityList = localArrayList;
    return localPendantEntryInfo;
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, "parseHbEntryInfo: " + paramJSONObject);
    }
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo localSpringFestivalHbEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo();
    localSpringFestivalHbEntryInfo.pendantEntryInfo = a(paramJSONObject);
    localSpringFestivalHbEntryInfo.fixedEntryInfo = a(paramJSONObject);
    localSpringFestivalHbEntryInfo.loadingInfo = a(paramJSONObject);
    a(localSpringFestivalHbEntryInfo, paramJSONObject);
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, "parseHbEntryInfo: " + localSpringFestivalHbEntryInfo);
    }
    return localSpringFestivalHbEntryInfo;
  }
  
  private static void a(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo paramSpringFestivalHbEntryInfo, JSONObject paramJSONObject)
  {
    if ((paramSpringFestivalHbEntryInfo == null) || (paramJSONObject == null)) {}
    do
    {
      return;
      paramSpringFestivalHbEntryInfo.activityUrl = paramJSONObject.optString("activity_url");
      paramSpringFestivalHbEntryInfo.emergencyUrl = paramJSONObject.optString("emergency_url");
      paramSpringFestivalHbEntryInfo.webType = paramJSONObject.optInt("web_type");
      paramSpringFestivalHbEntryInfo.entrySwitch = paramJSONObject.optInt("entry_switch");
      paramSpringFestivalHbEntryInfo.pendantSwitch = paramJSONObject.optInt("pendant_switch");
      paramSpringFestivalHbEntryInfo.activityPrefix = paramJSONObject.optString("activity_prefix");
      paramSpringFestivalHbEntryInfo.branchActivityPrefix = paramJSONObject.optString("branch_activity_prefix");
      paramJSONObject = paramJSONObject.optJSONArray("entry_show_list");
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    ArrayList localArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
      localTimeInfo.beginTime = ahfl.a(localJSONObject.optString("start_time"));
      localTimeInfo.endTime = ahfl.a(localJSONObject.optString("end_time"));
      localArrayList.add(localTimeInfo);
      i += 1;
    }
    paramSpringFestivalHbEntryInfo.entryShowTime = localArrayList;
  }
  
  public static SpringFestivalRedpacketConfBean parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, "SpringFestivalRedpacketConfBean: " + paramString);
    }
    try
    {
      SpringFestivalRedpacketConfBean localSpringFestivalRedpacketConfBean = new SpringFestivalRedpacketConfBean();
      paramString = new JSONObject(paramString);
      localSpringFestivalRedpacketConfBean.htmlOfflineCheckConfig = a(paramString);
      localSpringFestivalRedpacketConfBean.springFestivalHbEntryInfo = a(paramString.optJSONObject("entry"));
      return localSpringFestivalRedpacketConfBean;
    }
    catch (Throwable paramString)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean
 * JD-Core Version:    0.7.0.1
 */