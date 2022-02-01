package com.tencent.mobileqq.activity.springfestival.config;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.utils.StringUtil;
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
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject("htmloffline_check_configs");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseHtmlOfflineCheckConfigs: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, ((StringBuilder)localObject).toString());
    }
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = new SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig();
    ((SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig)localObject).bids = paramJSONObject.optString("bids");
    ((SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig)localObject).time_interval = paramJSONObject.optInt("time_interval", 24);
    ((SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig)localObject).total_cnt = paramJSONObject.optInt("total_cnt", 3);
    ((SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig)localObject).net_type = paramJSONObject.optString("net_type");
    ((SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig)localObject).checkDomain = paramJSONObject.optString("check_domain");
    return localObject;
  }
  
  private static void a(SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo paramSpringFestivalHbEntryInfo, JSONObject paramJSONObject)
  {
    if (paramSpringFestivalHbEntryInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      paramSpringFestivalHbEntryInfo.activityUrl = paramJSONObject.optString("activity_url");
      paramSpringFestivalHbEntryInfo.emergencyUrl = paramJSONObject.optString("emergency_url");
      paramSpringFestivalHbEntryInfo.webType = paramJSONObject.optInt("web_type");
      paramSpringFestivalHbEntryInfo.entrySwitch = paramJSONObject.optInt("entry_switch");
      paramSpringFestivalHbEntryInfo.pendantSwitch = paramJSONObject.optInt("pendant_switch");
      paramSpringFestivalHbEntryInfo.activityPrefix = paramJSONObject.optString("activity_prefix");
      paramSpringFestivalHbEntryInfo.branchActivityPrefix = paramJSONObject.optString("branch_activity_prefix");
      paramJSONObject = paramJSONObject.optJSONArray("entry_show_list");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        ArrayList localArrayList = new ArrayList(paramJSONObject.length());
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = Utils.a(localJSONObject.optString("start_time"));
          localTimeInfo.endTime = Utils.a(localJSONObject.optString("end_time"));
          localArrayList.add(localTimeInfo);
          i += 1;
        }
        paramSpringFestivalHbEntryInfo.entryShowTime = localArrayList;
      }
    }
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseHbEntryInfo: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo();
    ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo)localObject).pendantEntryInfo = e(paramJSONObject);
    ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo)localObject).fixedEntryInfo = d(paramJSONObject);
    ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo)localObject).loadingInfo = c(paramJSONObject);
    a((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo)localObject, paramJSONObject);
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parseHbEntryInfo: ");
      paramJSONObject.append(localObject);
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, paramJSONObject.toString());
    }
    return localObject;
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo c(JSONObject paramJSONObject)
  {
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo localLoadingInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo();
    if (paramJSONObject == null) {
      return localLoadingInfo;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("loading");
    if (localJSONObject == null) {
      return localLoadingInfo;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseLoadingInfo: ");
      localStringBuilder.append(paramJSONObject);
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, localStringBuilder.toString());
    }
    localLoadingInfo.loadingUrl = localJSONObject.optString("loading_url");
    localLoadingInfo.loadingTips = localJSONObject.optString("loading_tips");
    paramJSONObject = new SpringFestivalRedpacketConfBean.TimeInfo();
    paramJSONObject.beginTime = Utils.a(localJSONObject.optString("start_time"));
    paramJSONObject.endTime = Utils.a(localJSONObject.optString("end_time"));
    localLoadingInfo.loadingTime = paramJSONObject;
    return localLoadingInfo;
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo d(JSONObject paramJSONObject)
  {
    SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo localFixedEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo();
    if (paramJSONObject == null) {
      return localFixedEntryInfo;
    }
    paramJSONObject = paramJSONObject.optJSONObject("fixed_entry");
    if (paramJSONObject == null) {
      return localFixedEntryInfo;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseFixedEntryInfo: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, ((StringBuilder)localObject).toString());
    }
    localFixedEntryInfo.defaultBanner = paramJSONObject.optString("default_banner");
    int i = 0;
    localFixedEntryInfo.useStagger = paramJSONObject.optInt("use_stagger_peak", 0);
    Object localObject = paramJSONObject.optJSONArray("entry_banner_list");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject != null)
        {
          SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo localBannerInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo();
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = Utils.a(localJSONObject.optString("start_time"));
          localTimeInfo.endTime = Utils.a(localJSONObject.optString("end_time"));
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
    } else if (localFixedEntryInfo.staggerPeakIntervalBefore <= 0) {
      localFixedEntryInfo.staggerPeakIntervalBefore = 180;
    }
    localFixedEntryInfo.staggerPeakIntervalBefore *= 1000;
    return localFixedEntryInfo;
  }
  
  private static SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo e(JSONObject paramJSONObject)
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
    if (localPendantEntryInfo.forbidRefreshIntervalBefore > 3600) {
      localPendantEntryInfo.forbidRefreshIntervalBefore = 3600;
    } else if (localPendantEntryInfo.forbidRefreshIntervalBefore <= 0) {
      localPendantEntryInfo.forbidRefreshIntervalBefore = 180;
    }
    localPendantEntryInfo.forbidRefreshIntervalBefore *= 1000;
    localPendantEntryInfo.forbidRefreshIntervalAfter = paramJSONObject.optInt("forbid_refresh_interval_after", 780);
    if (localPendantEntryInfo.forbidRefreshIntervalAfter > 3600) {
      localPendantEntryInfo.forbidRefreshIntervalAfter = 3600;
    } else if (localPendantEntryInfo.forbidRefreshIntervalAfter <= 0) {
      localPendantEntryInfo.forbidRefreshIntervalAfter = 780;
    }
    localPendantEntryInfo.forbidRefreshIntervalAfter *= 1000;
    JSONArray localJSONArray = paramJSONObject.optJSONArray("activity_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo localActivityInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo();
          localActivityInfo.id = localJSONObject.optString("activity_id");
          SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
          localTimeInfo.beginTime = Utils.a(localJSONObject.optString("start_time"));
          localTimeInfo.endTime = Utils.a(localJSONObject.optString("end_time"));
          localActivityInfo.activityTime = localTimeInfo;
          localActivityInfo.resUrl = localJSONObject.optString("res_url");
          localActivityInfo.videoUrl = localJSONObject.optString("transition_video_url");
          localActivityInfo.logoUrl = localJSONObject.optString("logo_url");
          String str = localJSONObject.optString("pendant_end_time");
          paramJSONObject = str;
          if (StringUtil.isEmpty(str)) {
            paramJSONObject = localJSONObject.optString("end_time");
          }
          localActivityInfo.pendantEndTime = Utils.a(paramJSONObject);
          if ((localActivityInfo.pendantEndTime > localTimeInfo.endTime) || (localActivityInfo.pendantEndTime <= 0L)) {
            localActivityInfo.pendantEndTime = localTimeInfo.endTime;
          }
          localArrayList.add(localActivityInfo);
        }
        i += 1;
      }
      localPendantEntryInfo.activityList = localArrayList;
    }
    return localPendantEntryInfo;
  }
  
  public static SpringFestivalRedpacketConfBean parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SpringFestivalRedpacketConfBean: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("springHb_SpringFestivalRedpacketConfBean", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new SpringFestivalRedpacketConfBean();
      paramString = new JSONObject(paramString);
      ((SpringFestivalRedpacketConfBean)localObject).htmlOfflineCheckConfig = a(paramString);
      ((SpringFestivalRedpacketConfBean)localObject).springFestivalHbEntryInfo = b(paramString.optJSONObject("entry"));
      return localObject;
    }
    catch (Throwable paramString)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean
 * JD-Core Version:    0.7.0.1
 */