package com.tencent.biz.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.utils.QCirclePoiUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05502.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;

public class QCirclePluginReportUtil
{
  public static Map<String, Object> a(FeedBlockData paramFeedBlockData)
  {
    HashMap localHashMap = new HashMap();
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return localHashMap;
      }
      Object localObject = (QQCircleFeedBase.StReportInfoForClient)paramFeedBlockData.a("DITTO_REPORT_INFO_FOR_CLIENT");
      if (localObject != null)
      {
        localHashMap.put("xsj_feed_type1", Integer.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject).feedtype1.get()));
        localHashMap.put("xsj_feed_type2", Integer.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject).feedtype2.get()));
        localHashMap.put("xsj_feed_type3", Integer.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject).feedtype3.get()));
        if (!TextUtils.isEmpty(((QQCircleFeedBase.StReportInfoForClient)localObject).datongJsonData.get())) {
          localHashMap.put("xsj_transfer_info", ((QQCircleFeedBase.StReportInfoForClient)localObject).datongJsonData.get());
        }
      }
      else
      {
        localObject = QCirclePluginUtil.c(paramFeedBlockData.b());
        localHashMap.put("xsj_feed_type1", Integer.valueOf(localObject[0]));
        localHashMap.put("xsj_feed_type2", Integer.valueOf(localObject[1]));
      }
      localHashMap.putAll(a(paramFeedBlockData.b()));
    }
    return localHashMap;
  }
  
  public static Map<String, Object> a(FeedCloudMeta.StFeed paramStFeed)
  {
    HashMap localHashMap = new HashMap();
    if (paramStFeed == null) {
      return localHashMap;
    }
    localHashMap.put("xsj_author_uin", paramStFeed.poster.id.get());
    localHashMap.put("xsj_topic_id", QCirclePluginUtil.b(paramStFeed));
    localHashMap.put("xsj_feed_id", paramStFeed.id.get());
    localHashMap.put("xsj_poi_msg", QCirclePoiUtils.a(paramStFeed));
    localHashMap.put("xsj_like_num", Integer.valueOf(paramStFeed.likeInfo.count.get()));
    Object localObject = QCirclePushInfoManager.a().a(paramStFeed.id.get());
    if (localObject != null) {
      localObject = Integer.valueOf(((FeedCloudMeta.StPushList)localObject).totalClickCount.get());
    } else {
      localObject = "";
    }
    localHashMap.put("xsj_push_num", localObject);
    localHashMap.put("xsj_comment_num", Integer.valueOf(paramStFeed.commentCount.get()));
    localHashMap.put("xsj_share_num", Integer.valueOf(paramStFeed.share.sharedCount.get()));
    localHashMap.put("xsj_music_id", Long.valueOf(paramStFeed.musicInfo.ID.get()));
    localHashMap.put("xsj_music_name", paramStFeed.musicInfo.musicName.get());
    return localHashMap;
  }
  
  public static QCircleLpReportDc05501.DataBuilder b(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleLpReportDc05501.DataBuilder localDataBuilder = new QCircleLpReportDc05501.DataBuilder();
    if (paramStFeed == null)
    {
      QLog.e("QCirclePluginReportUtil", 1, "feed == null");
      return localDataBuilder;
    }
    localDataBuilder.setFeedId(paramStFeed.id.get());
    localDataBuilder.setFeedTag(QCirclePluginUtil.b(paramStFeed));
    localDataBuilder.setAuthorUin(paramStFeed.poster.id.get());
    localDataBuilder.setExt1(paramStFeed.video.fileId.get());
    int i;
    if (paramStFeed.reportInfoForClient.has())
    {
      QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      try
      {
        localStReportInfoForClient.mergeFrom(paramStFeed.reportInfoForClient.get().toByteArray());
        localDataBuilder.setFeedType1(localStReportInfoForClient.feedtype1.get());
        localDataBuilder.setFeedType2(localStReportInfoForClient.feedtype2.get());
        localDataBuilder.setFeedType3(localStReportInfoForClient.feedtype3.get());
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      int[] arrayOfInt = QCirclePluginUtil.c(paramStFeed);
      localDataBuilder.setFeedType1(arrayOfInt[0]);
      localDataBuilder.setFeedType2(arrayOfInt[1]);
    }
    if ((paramStFeed.busiReport != null) && (paramStFeed.busiReport.has())) {
      localDataBuilder.setReportInfo(paramStFeed.busiReport.get().toByteArray());
    }
    return localDataBuilder;
  }
  
  public static QCircleLpReportDc05502.DataBuilder c(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleLpReportDc05502.DataBuilder localDataBuilder = new QCircleLpReportDc05502.DataBuilder();
    if (paramStFeed == null)
    {
      QLog.e("QCirclePluginReportUtil", 1, "feed == null");
      return localDataBuilder;
    }
    localDataBuilder.setToUin(paramStFeed.poster.id.get());
    int i;
    if (paramStFeed.reportInfoForClient.has())
    {
      QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      try
      {
        localStReportInfoForClient.mergeFrom(paramStFeed.reportInfoForClient.get().toByteArray());
        localDataBuilder.setFeedType1(localStReportInfoForClient.feedtype1.get());
        localDataBuilder.setFeedType2(localStReportInfoForClient.feedtype2.get());
        localDataBuilder.setFeedType3(localStReportInfoForClient.feedtype3.get());
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      int[] arrayOfInt = QCirclePluginUtil.c(paramStFeed);
      localDataBuilder.setFeedType1(arrayOfInt[0]);
      localDataBuilder.setFeedType2(arrayOfInt[1]);
    }
    localDataBuilder.setFeedId(paramStFeed.id.get());
    localDataBuilder.setFeedTag(QCirclePluginUtil.b(paramStFeed));
    localDataBuilder.setAuthorUin(paramStFeed.poster.id.get());
    if (paramStFeed.busiReport.has()) {
      localDataBuilder.setReportInfo(paramStFeed.busiReport.get().toByteArray());
    }
    return localDataBuilder;
  }
  
  public static QCircleLpReportDc05507.DataBuilder d(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder();
    if (paramStFeed == null)
    {
      QLog.e("QCirclePluginReportUtil", 1, "feed == null");
      return localDataBuilder;
    }
    localDataBuilder.setToUin(paramStFeed.poster.id.get());
    int i;
    if (paramStFeed.reportInfoForClient.has())
    {
      QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      try
      {
        localStReportInfoForClient.mergeFrom(paramStFeed.reportInfoForClient.get().toByteArray());
        localDataBuilder.setFeedType1(localStReportInfoForClient.feedtype1.get());
        localDataBuilder.setFeedType2(localStReportInfoForClient.feedtype2.get());
        localDataBuilder.setFeedType3(localStReportInfoForClient.feedtype3.get());
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      localObject = QCirclePluginUtil.c(paramStFeed);
      localDataBuilder.setFeedType1(localObject[0]);
      localDataBuilder.setFeedType2(localObject[1]);
    }
    localDataBuilder.setFeedId(paramStFeed.id.get());
    localDataBuilder.setAuthorUin(paramStFeed.poster.id.get());
    if (paramStFeed.video != null)
    {
      localDataBuilder.setVideoTotalTime(paramStFeed.video.duration.get());
      if (QCirclePluginUtil.d((FeedCloudMeta.StUser)paramStFeed.poster.get())) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      localDataBuilder.setVideoType((String)localObject);
      localDataBuilder.setCubage(paramStFeed.video.fileSize.get());
      localDataBuilder.setWidth(paramStFeed.video.width.get());
      localDataBuilder.setHeight(paramStFeed.video.height.get());
      localDataBuilder.setClear(paramStFeed.video.videoRate.get());
      localDataBuilder.setPlayId(paramStFeed.video.fileId.get());
      localDataBuilder.setVid(paramStFeed.video.fileId.get());
      localDataBuilder.setLloc(paramStFeed.cover.picId.get());
      localDataBuilder.setPlayUrl(paramStFeed.video.playUrl.get());
      localDataBuilder.setVideoTag(paramStFeed.video.playUrl.get());
      localDataBuilder.setPicInfo(paramStFeed.cover.picUrl.get());
    }
    localDataBuilder.setFeedTag(QCirclePluginUtil.b(paramStFeed));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramStFeed.title.get());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramStFeed.content.get());
    localDataBuilder.setItemDetail(((StringBuilder)localObject).toString());
    localDataBuilder.setActTime(System.currentTimeMillis());
    if (paramStFeed.busiReport.has()) {
      localDataBuilder.setReportInfo(paramStFeed.busiReport.get().toByteArray());
    }
    return localDataBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCirclePluginReportUtil
 * JD-Core Version:    0.7.0.1
 */