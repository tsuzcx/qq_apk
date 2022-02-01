package com.tencent.biz.qqcircle.flutter;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.qflutter.vistaimage.VistaImageRegister;
import com.qflutter.vistaplayer.VistaPlayerPlugin;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean.SourceRect;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public final class QCircleFlutterLauncher
{
  public static void a(Context paramContext, QCircleEditProfileBean paramQCircleEditProfileBean)
  {
    QLog.i("QCircleFlutterLauncher", 1, "[launchEditProfilePage]");
    if ((!FastClickUtils.a("QCircleFlutterLauncherlaunchPage", 1000L)) && (paramContext != null))
    {
      HashMap localHashMap = new HashMap();
      if (paramQCircleEditProfileBean != null)
      {
        localHashMap.put("host_uin", paramQCircleEditProfileBean.getHostUin());
        localHashMap.put("nick", paramQCircleEditProfileBean.getNick());
        localHashMap.put("gender", Integer.valueOf(paramQCircleEditProfileBean.getGender()));
        localHashMap.put("constellation", Integer.valueOf(paramQCircleEditProfileBean.getConstellation()));
        localHashMap.put("school", paramQCircleEditProfileBean.getSchool());
        localHashMap.put("company", paramQCircleEditProfileBean.getCompany());
        localHashMap.put("location", paramQCircleEditProfileBean.getLocation());
        localHashMap.put("location_code", paramQCircleEditProfileBean.getLocationCode());
        localHashMap.put("desc", paramQCircleEditProfileBean.getDesc());
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("qcircle_flutter_page_back_behavior", "1");
      if (paramQCircleEditProfileBean != null) {
        localBundle.putParcelable("report_launch_param", QCircleReportHelper.LaunchParam.wrap(paramQCircleEditProfileBean.getLaunchFrom(), paramQCircleEditProfileBean.getLaunchId(), paramQCircleEditProfileBean.getUin(), -1, paramQCircleEditProfileBean.getSchemeAttrs()));
      }
      a(paramContext, "cirEditProfileWidget", "QQCirEditProfileWidget", localHashMap, localBundle);
      return;
    }
    QLog.i("QCircleFlutterLauncher", 1, "[launchEditProfilePage] too fast");
  }
  
  public static void a(Context paramContext, QCircleLayerBean paramQCircleLayerBean)
  {
    if ((!FastClickUtils.a("QCircleFlutterLauncherlaunchPage", 1000L)) && (paramContext != null))
    {
      QLog.i("QCircleFlutterLauncher", 1, "[launchContentDetailPage]");
      if (paramQCircleLayerBean == null)
      {
        QLog.w("QCircleFlutterLauncher", 1, "[launchContentDetailPage] invalid layerBean");
        return;
      }
      Object localObject1 = paramQCircleLayerBean.getFeed();
      if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).poster != null) && (QCircleFollowManager.getInstance().getUinFollowed(((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get()).id.get()) != null))
      {
        ((FeedCloudMeta.StFeed)localObject1).poster.followState.set(QCircleFollowManager.getInstance().getUinFollowed(((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get()).id.get()).intValue());
        paramQCircleLayerBean.setFeed((FeedCloudMeta.StFeed)localObject1);
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[launchContentDetailPage] feed id=");
      ((StringBuilder)localObject2).append(((FeedCloudMeta.StFeed)localObject1).id.get());
      QLog.d("QCircleFlutterLauncher", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new HashMap();
      ((Map)localObject2).put("entry_feed", paramQCircleLayerBean.getFeedByteArray());
      ((Map)localObject2).put("is_feed_list_mode", Boolean.valueOf(true ^ paramQCircleLayerBean.isSingleFeed()));
      ((Map)localObject2).put("description_feed", paramQCircleLayerBean.getFeedByteArray());
      ((Map)localObject2).put("source_type", Integer.valueOf(QCircleGetFeedListRequest.covertToProtocolSource(paramQCircleLayerBean.getExtraTypeInfo().sourceType)));
      ((Map)localObject2).put("poi_info", paramQCircleLayerBean.getPoiInfoByteArray());
      ((Map)localObject2).put("photo_index", Integer.valueOf(paramQCircleLayerBean.getPicPos()));
      ((Map)localObject2).put("pushed_target_uid", paramQCircleLayerBean.getUin());
      ((Map)localObject2).put("max_push_times", Integer.valueOf(QCircleConfigHelper.c()));
      ((Map)localObject2).put("host_uin", HostDataTransUtils.getAccount());
      ((Map)localObject2).put("fuel_count", Integer.valueOf(QCircleConfig.getInstance().getFuleCount()));
      ((Map)localObject2).put("abtest_navigation", Boolean.valueOf(QCircleConfigHelper.ao()));
      ((Map)localObject2).put("abtest_feed_comment", Boolean.valueOf(QCircleConfigHelper.ap()));
      Object localObject3;
      if ((paramQCircleLayerBean.getSourceRect() != null) && (QCircleApplication.APP != null) && (QCircleApplication.APP.getResources() != null) && (QCircleApplication.APP.getResources().getDisplayMetrics() != null))
      {
        double d2 = QCircleApplication.APP.getResources().getDisplayMetrics().density;
        double d1 = d2;
        if (0.0D == d2) {
          d1 = 3.0D;
        }
        localObject3 = paramQCircleLayerBean.getSourceRect();
        d2 = ((QCircleLayerBean.SourceRect)localObject3).getLeft();
        Double.isNaN(d2);
        ((Map)localObject2).put("from_x", Double.valueOf(d2 * 1.0D / d1));
        d2 = ((QCircleLayerBean.SourceRect)localObject3).getTop();
        Double.isNaN(d2);
        ((Map)localObject2).put("from_y", Double.valueOf(d2 * 1.0D / d1));
        d2 = ((QCircleLayerBean.SourceRect)localObject3).getRight() - ((QCircleLayerBean.SourceRect)localObject3).getLeft();
        Double.isNaN(d2);
        ((Map)localObject2).put("from_w", Double.valueOf(d2 * 1.0D / d1));
        d2 = ((QCircleLayerBean.SourceRect)localObject3).getBottom() - ((QCircleLayerBean.SourceRect)localObject3).getTop();
        Double.isNaN(d2);
        ((Map)localObject2).put("from_h", Double.valueOf(d2 * 1.0D / d1));
      }
      if (paramQCircleLayerBean.getSimulateDataByteArray() != null) {
        ((Map)localObject2).put("simulate_data", paramQCircleLayerBean.getSimulateData().toByteArray());
      }
      if (paramQCircleLayerBean.getTagInfoByteArray() != null)
      {
        ((Map)localObject2).put("tag_info", paramQCircleLayerBean.getTagInfoByteArray());
      }
      else if (paramQCircleLayerBean.getFeedListBusiReqByteArray() != null)
      {
        localObject3 = paramQCircleLayerBean.getFeedListBusiReq();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((QQCircleFeedBase.StFeedListBusiReqData)localObject3).tagName.get())))
        {
          FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
          localStTagInfo.tagName.set(((QQCircleFeedBase.StFeedListBusiReqData)localObject3).tagName.get());
          ((Map)localObject2).put("tag_info", localStTagInfo.toByteArray());
        }
      }
      if (paramQCircleLayerBean.getFromReportBean() != null) {
        ((Map)localObject2).put("from_page_id", Integer.valueOf(paramQCircleLayerBean.getFromReportBean().getPageId()));
      }
      if ((paramQCircleLayerBean.getExtraTypeInfo().sourceType == 5) && (QCircleGpsHelper.a().e() != null)) {
        ((Map)localObject2).put("gps_info", QCircleGpsHelper.a().e().toByteArray());
      }
      if (localObject1 != null) {
        QCircleVistaPlayerImpl.mayNeedVideoContinue(((FeedCloudMeta.StFeed)localObject1).id.get(), paramQCircleLayerBean.getVideoCurrentPosition());
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("qcircle_flutter_page_back_behavior", "1");
      ((Bundle)localObject1).putParcelable("report_launch_param", QCircleReportHelper.LaunchParam.wrap(paramQCircleLayerBean.getLaunchFrom(), paramQCircleLayerBean.getLaunchId(), paramQCircleLayerBean.getUin(), -1, paramQCircleLayerBean.getSchemeAttrs()));
      a(paramContext, "cirFloatLayer", "QQCircleFloatLayer", (Map)localObject2, (Bundle)localObject1);
      return;
    }
    QLog.i("QCircleFlutterLauncher", 1, "[launchContentDetailPage] too fast");
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, Map paramMap, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[launchFlutterPage] page=");
    localStringBuilder.append(paramString2);
    QLog.i("QCircleFlutterLauncher", 1, localStringBuilder.toString());
    VistaPlayerPlugin.register(QCircleVistaPlayerImpl.class);
    TencentQQCirclePlugin.setQQCircleMethod(QQCircleMethodImpl.getInstance());
    VistaImageRegister.registerScheme("wezone", QCircleVistaImageImpl.class);
    QCircleHostLauncher.openFlutterPageForQCircle(paramContext, paramString1, paramString2, paramMap, paramBundle);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap, String paramString, QCircleInitBean paramQCircleInitBean)
  {
    QLog.i("QCircleFlutterLauncher", 1, "[launchSearchPage]");
    if ((!FastClickUtils.a("QCircleFlutterLauncherlaunchPage", 1000L)) && (paramContext != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("hostId", HostDataTransUtils.getAccount());
      localHashMap.put("followConfig", QCircleConfigHelper.a("qqcircle", "qqcircle_back_follow_enable", Integer.valueOf(1)));
      if ((paramHashMap != null) && (paramHashMap.size() > 0)) {
        localHashMap.putAll(paramHashMap);
      }
      paramHashMap = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramHashMap = "0";
      }
      paramString = new Bundle();
      paramString.putString("qcircle_flutter_page_back_behavior", paramHashMap);
      paramString.putParcelable("report_launch_param", QCircleReportHelper.LaunchParam.wrap(paramQCircleInitBean.getLaunchFrom(), paramQCircleInitBean.getLaunchId(), paramQCircleInitBean.getUin(), -1, paramQCircleInitBean.getSchemeAttrs()));
      a(paramContext, "cirSearchDetailWidget", "QQCirSearchDetailWidget", localHashMap, paramString);
      return;
    }
    QLog.i("QCircleFlutterLauncher", 1, "[launchSearchPage] too fast");
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap, QCircleInitBean paramQCircleInitBean)
  {
    QLog.i("QCircleFlutterLauncher", 1, "[launchMessageListPage]");
    if ((!FastClickUtils.a("QCircleFlutterLauncherlaunchPage", 1000L)) && (paramContext != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("hostId", HostDataTransUtils.getAccount());
      if ((paramMap != null) && (paramMap.size() > 0)) {
        localHashMap.putAll(paramMap);
      }
      paramMap = new Bundle();
      paramMap.putString("qcircle_flutter_page_back_behavior", "1");
      if (paramQCircleInitBean != null) {
        paramMap.putParcelable("report_launch_param", QCircleReportHelper.LaunchParam.wrap(paramQCircleInitBean.getLaunchFrom(), paramQCircleInitBean.getLaunchId(), paramQCircleInitBean.getUin(), -1, paramQCircleInitBean.getSchemeAttrs()));
      }
      a(paramContext, "cirMessageListWidget", "QQCirMessageListWidget", localHashMap, paramMap);
      return;
    }
    QLog.i("QCircleFlutterLauncher", 1, "[launchSearchPage] too fast");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher
 * JD-Core Version:    0.7.0.1
 */