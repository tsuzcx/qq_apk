package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.preload.task.QCircleTagPreLoaderTask;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.utils.QCircleABTestUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class QCircleContentDetailSchemeParser
  extends QCircleBaseSchemeParser
{
  private QQCircleFeedBase.StBusiInfoCommentListData a(QCircleLayerBean paramQCircleLayerBean, HashMap<String, String> paramHashMap)
  {
    if ((!paramHashMap.containsKey("commentid")) && (!paramHashMap.containsKey("replyid")) && (!paramHashMap.containsKey("commentposterid")) && (!paramHashMap.containsKey("replyposterid")))
    {
      paramHashMap = null;
    }
    else
    {
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.comment.set(new FeedCloudMeta.StComment());
      localStBusiInfoCommentListData.reply.set(new FeedCloudMeta.StReply());
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("commentid"))) {
        localStBusiInfoCommentListData.comment.id.set((String)paramHashMap.get("commentid"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("commentposterid")))
      {
        localStBusiInfoCommentListData.comment.postUser.set(new FeedCloudMeta.StUser());
        localStBusiInfoCommentListData.comment.postUser.id.set((String)paramHashMap.get("commentposterid"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("replyid"))) {
        localStBusiInfoCommentListData.reply.id.set((String)paramHashMap.get("replyid"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("replyposterid")))
      {
        localStBusiInfoCommentListData.reply.postUser.set(new FeedCloudMeta.StUser());
        localStBusiInfoCommentListData.reply.postUser.id.set((String)paramHashMap.get("replyposterid"));
      }
      paramHashMap = localStBusiInfoCommentListData;
    }
    if (paramHashMap != null) {
      paramQCircleLayerBean.setBusiInfoData(paramHashMap.toByteArray());
    }
    return paramHashMap;
  }
  
  private void a(HashMap<String, String> paramHashMap, QCircleLayerBean paramQCircleLayerBean)
  {
    Object localObject1 = new FeedCloudMeta.StFeed();
    if (paramHashMap.containsKey("feedid")) {
      ((FeedCloudMeta.StFeed)localObject1).id.set((String)paramHashMap.get("feedid"));
    }
    if ((paramHashMap.containsKey("createtime")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("createtime")))) {
      ((FeedCloudMeta.StFeed)localObject1).createTime.set(Long.parseLong((String)paramHashMap.get("createtime")));
    }
    if (paramHashMap.containsKey("uin"))
    {
      localObject2 = new FeedCloudMeta.StUser();
      ((FeedCloudMeta.StUser)localObject2).id.set((String)paramHashMap.get("uin"));
      ((FeedCloudMeta.StFeed)localObject1).poster.set((MessageMicro)localObject2);
    }
    boolean bool = paramHashMap.containsKey("sourcetype");
    int k = 0;
    int i;
    if (bool) {
      i = Integer.valueOf((String)paramHashMap.get("sourcetype")).intValue();
    } else {
      i = 0;
    }
    if ((paramHashMap.containsKey("issinglefeed")) && (Integer.valueOf((String)paramHashMap.get("issinglefeed")).intValue() == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    int j = k;
    if (paramHashMap.containsKey("istag"))
    {
      j = k;
      if (Integer.valueOf((String)paramHashMap.get("istag")).intValue() == 1) {
        j = 1;
      }
    }
    if (paramHashMap.containsKey("tagname")) {
      paramHashMap = (String)paramHashMap.get("tagname");
    } else {
      paramHashMap = "";
    }
    Object localObject2 = new QCircleExtraTypeInfo();
    ((QCircleExtraTypeInfo)localObject2).sourceType = i;
    paramQCircleLayerBean.setFeed((FeedCloudMeta.StFeed)localObject1);
    if ((j != 0) && (!TextUtils.isEmpty(paramHashMap)))
    {
      localObject1 = new FeedCloudMeta.StTagInfo();
      ((FeedCloudMeta.StTagInfo)localObject1).tagName.set(paramHashMap);
      paramQCircleLayerBean.setTagInfo((FeedCloudMeta.StTagInfo)localObject1);
    }
    paramQCircleLayerBean.setExtraTypeInfo((QCircleExtraTypeInfo)localObject2);
    paramQCircleLayerBean.setSingleFeed(bool);
  }
  
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if ((paramContext != null) && (paramQCircleSchemeBean != null))
    {
      if (paramQCircleSchemeBean.getAttrs() == null) {
        return;
      }
      HashMap localHashMap = paramQCircleSchemeBean.getAttrs();
      QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
      a(paramQCircleSchemeBean, localQCircleLayerBean);
      a(localQCircleLayerBean, localHashMap);
      b(localQCircleLayerBean, localHashMap);
      a(localHashMap, localQCircleLayerBean);
      a(localQCircleLayerBean, localHashMap);
      if ((localHashMap.containsKey("is_feed_detail")) && ("1".equals(localHashMap.get("is_feed_detail"))))
      {
        localQCircleLayerBean.setSingleFeed(false);
        if ((localHashMap.containsKey("without_recom")) && ("1".equals(localHashMap.get("without_recom")))) {
          localQCircleLayerBean.setSingleFeed(true);
        }
        if (localHashMap.containsKey("from_page_report"))
        {
          paramQCircleSchemeBean = new QCircleReportBean();
          paramQCircleSchemeBean.setPageId(Integer.valueOf((String)localHashMap.get("from_page_report")).intValue());
          localQCircleLayerBean.setFromReportBean(paramQCircleSchemeBean);
        }
        if (localQCircleLayerBean.isNeedShowGoHomeButton())
        {
          if (QCircleABTestUtils.a("exp_wezone_externalpage_newrecommendationmodule1"))
          {
            localHashMap.put("sourcetype", String.valueOf(15));
            localHashMap.put("pageid", String.valueOf(69));
            paramQCircleSchemeBean = new QCircleSchemeBean();
            paramQCircleSchemeBean.setAttrs(localHashMap);
            paramQCircleSchemeBean.setSchemeAction("openpolymerizedetail");
            QCircleSchemeLauncher.b(paramContext, paramQCircleSchemeBean);
          }
          else
          {
            QCircleLauncher.a(paramContext, localQCircleLayerBean);
          }
          QCircleABTestUtils.b("exp_wezone_externalpage_newrecommendationmodule1");
          return;
        }
        QCircleLauncher.a(paramContext, localQCircleLayerBean);
        return;
      }
      a(paramContext, localQCircleLayerBean);
    }
  }
  
  public void a(Context paramContext, QCircleLayerBean paramQCircleLayerBean)
  {
    if (FastClickUtils.a("QCircleBaseSchemeParser_launchContentDetailPage", 500L)) {
      return;
    }
    int i = 1;
    QLog.d("QCircleBaseSchemeParser", 1, "[launchContentLayerPageByScheme]");
    Intent localIntent = new Intent();
    if (paramQCircleLayerBean.getTagInfo().has())
    {
      PreLoader.remove("2005");
      PreLoader.preLoad("2005", new QCircleTagPreLoaderTask(paramQCircleLayerBean, true));
    }
    boolean bool = QCircleLauncherUtil.a();
    if (!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isPublicVersion())
    {
      if (QCirclePluginConfig.b().getBoolean("qcircle_force_enable_floatlayer_flutter", true))
      {
        QLog.w("QCircleBaseSchemeParser", 1, "[launchContentLayerPage] force flutter page");
      }
      else
      {
        QLog.w("QCircleBaseSchemeParser", 1, "[launchContentLayerPage] use native page");
        i = 0;
      }
    }
    else {
      i = bool;
    }
    if ((!QCircleConfigHelper.bg()) && (i != 0) && (QCircleFlutterUtils.a()))
    {
      QCircleFlutterLauncher.a(paramContext, paramQCircleLayerBean);
      return;
    }
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleLayerBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleLauncherUtil.b());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser
 * JD-Core Version:    0.7.0.1
 */